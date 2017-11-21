package com.example.berka.aktovnostilogovanjegeolokacija.constants;

/**
 * Created by berka on 6/23/2017.
 */

public class Constants {

    //    public static final String BASE_URL = "http://10.0.2.2/";
    public static final String BASE_URL = "http://192.168.0.11/";
    //    public static final String BASE_URL = "http://127.0.0.1/";
    public static final String LOGIN_OPERATION = "login";
    public static final String SEND_DATA_OPERATION = "send_data";

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String IS_LOGGED_IN = "isLoggedIn";

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String UNIQUE_ID = "unique_id";

    public static final String TAG = "Learn2Crack";

    //FETCHADDRESS CONSTANTS BELOW

    public static final int SUCCESS_RESULT = 0;

    public static final int FAILURE_RESULT = 1;

    private static final String PACKAGE_NAME =
            "com.example.berka.aktovnostilogovanjegeolokacija.constants";

    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";

    public static final String RESULT_DATA_KEY = PACKAGE_NAME + ".RESULT_DATA_KEY";

    public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME + ".LOCATION_DATA_EXTRA";
}
