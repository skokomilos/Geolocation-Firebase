package com.example.berka.aktovnostilogovanjegeolokacija;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.berka.aktovnostilogovanjegeolokacija.constants.Constants;
import com.example.berka.aktovnostilogovanjegeolokacija.model.SendData;
import com.example.berka.aktovnostilogovanjegeolokacija.model.User;
import com.example.berka.aktovnostilogovanjegeolokacija.server.RequestInterface;
import com.example.berka.aktovnostilogovanjegeolokacija.server.ServerRequest;
import com.example.berka.aktovnostilogovanjegeolokacija.server.ServerResponse;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private EditText et_email, et_password;
    private ProgressBar progressBar;

    private SharedPreferences pref;

    public static final String USER_KEY = "USER_KEY";

    View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLayout = findViewById(android.R.id.content);

        //pref = MainActivity.this.getPreferences(0);
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        btn_login = (Button)findViewById(R.id.btn_login);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {

                    progressBar.setVisibility(View.VISIBLE);
                    loginProcess(email, password);

                } else {

                    Snackbar.make(parentLayout, "Fields are empty !", Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }

    private void loginProcess(String email, String password) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        ServerRequest request = new ServerRequest();
        request.setOperation(Constants.LOGIN_OPERATION);
        request.setUser(user);
        Call<ServerResponse> response = requestInterface.operation(request);

        response.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

                ServerResponse resp = response.body();
                Snackbar.make(parentLayout, resp.getMessage(), Snackbar.LENGTH_LONG).show();

                if (resp.getResult().equals(Constants.SUCCESS)) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean(Constants.IS_LOGGED_IN, true);
                    editor.putString(Constants.EMAIL, resp.getUser().getEmail());
                    editor.putString(Constants.NAME, resp.getUser().getName());
                    editor.putString(Constants.UNIQUE_ID, resp.getUser().getUnique_id());
                    editor.commit();

                    Intent i  =new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
//                    editor.apply();

//                    Intent i  =new Intent(MainActivity.this, SecondActivity.class);
//                    i.putExtra(USER_KEY, String.valueOf(editor));
//

                    startActivity(i);

                }
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                progressBar.setVisibility(View.INVISIBLE);
                Log.d(Constants.TAG, "failed");
                Snackbar.make(parentLayout, t.getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

}