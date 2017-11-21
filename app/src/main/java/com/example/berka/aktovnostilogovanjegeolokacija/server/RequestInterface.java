package com.example.berka.aktovnostilogovanjegeolokacija.server;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by berka on 6/23/2017.
 */

public interface RequestInterface {


    @POST("learn2crack-login-register/")
    Call<ServerResponse> operation(@Body ServerRequest request);

    @POST("learn2crack-login-register/")
    Call<ServerResponse> operationSend(@Body ServerRequest request);
}
