package com.example.kazimdmunim.smarthealthmonitor;

/**
 * Created by USER on 4/6/2016.
 */

public class Config {

//    public static final String serverIP="192.168.24.1";
    //URL to our login.php filee
//    public static final String LOGIN_URL = "http://"+serverIP+":80/web-new_2/api/RegistrationApi/loginAndroid.php";
//    public static final String REGISTER_URL = "http://"+serverIP+":80/web-new_2/api/RegistrationApi/registrationAndroid.php";

    public static final String LOGIN_URL = "http://smarthealthmonitor.eu.pn/api/RegistrationApi/loginAndroid.php";
    public static final String REGISTER_URL = "http://smarthealthmonitor.eu.pn/api/RegistrationApi/registrationAndroid.php";
    public static final String UPDATE_URL = "http://smarthealthmonitor.eu.pn/api/UpdateApi/updateAndroid.php";
    public static final String CHANGE_URL = "http://smarthealthmonitor.eu.pn/api/RegistrationApi/changePasswordAndroid.php";
    public static final String GRAPH_URL = "http://smarthealthmonitor.eu.pn/api/GraphApi/getBloodPressureAndroid.php";
    public static final String GRAPH_URL_SG = "http://smarthealthmonitor.eu.pn/api/GraphApi/getBloodSugarAndroid.php";
    public static final String GRAPH_URL_PL = "http://smarthealthmonitor.eu.pn/api/GraphApi/getPulseInfoAndroid.php";
    public static final String GRAPH_URL_BM = "http://smarthealthmonitor.eu.pn/api/GraphApi/getBMIAndroid.php";
    public static final String GRAPH_URL_BM_SUGG = "http://smarthealthmonitor.eu.pn/api/GraphApi/getBMIsuggAndroid.php";
    public static final String GRAPH_URL_SG_SUGG = "http://smarthealthmonitor.eu.pn/api/GraphApi/getBloodSugarsuggAndroid.php";
    public static final String GRAPH_URL_BP_SUGG = "http://smarthealthmonitor.eu.pn/api/GraphApi/getBloodPressuresuggAndroid.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_USERNAME = "user_name";
    public static final String KEY_PASSWORD = "user_password";

    public static boolean lang= true    ;
    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    public static  String fullName,userName,email,password,rpassword,feet,inch,weight,years,bpTop,bpBottom,sugar,pulse,oldpass,newpass,reppass;
    public static String p[];
    public static  String a1,a2,a3,a4,a5;
    public static long dtet[]=new long [12];
    public static long dte[]=new long [12];
    public static long bpt[]=new long [12];
    public static long bpb[]=new long [12];
    public static int maxBpT=0,minBpT=0;
    public static int maxBpB=0,minBpB=0;
    public static float avgBpT=0,avgBpB=0;
    public static int len=0;


    public static long dtetSg[]=new long [12];
    public static long dteSg[]=new long [12];
    public static float sugarLvl[]=new float[12];
    public static int lenSg=0;
    public static float avgSG=0,maxSG=0,minSG=0;

    public static long dtetPl[]=new long [12];
    public static long dtePl[]=new long [12];
    public static float beats[]=new float[12];
    public static int lenPl=0;
    public static float avgPL=0,maxPL=0,minPL=0;

    public static long dtetBm[]=new long [12];
    public static long dteBm[]=new long [12];
    public static float bmi[]=new float[12];
    public static int lenBm=0;
    public static float avgBM=0,maxBM=0,minBM=0;
    public static float curBMI = 0;
    public static float curSUGAR = 0;
    public static float curBP = 0;
    public static float curPL = 0;

    public static String graphName= "";
    public static String paramName= "";
    public static String paramNamebn= "";



    public static float highBM=0,lowBM=0;
    public static String statusBM,suggBM;
    public static String statusBMbn,suggBMbn;



//
//    //Keys for Sharedpreferences
//    //This would be the name of our shared preferences
//    public static final String SHARED_PREF_NAME = "libraryapp";
//
//    //This would be used to store the email of current logged in user
//    public static final String USERNAME_SHARED_PREF = "email";
//
//    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
//    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}
