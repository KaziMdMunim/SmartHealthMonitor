package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    TextView editTextLogin,editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"font.otf");

        TextView login = (TextView)findViewById(R.id.login);
        login.setTypeface(myTypeface);


        editTextLogin = (EditText)findViewById(R.id.editText);
        editTextLogin.setTypeface(myTypeface);

        editTextPassword = (EditText)findViewById(R.id.editText2);
        editTextPassword.setTypeface(myTypeface);

        TextView myTextViewf = (TextView)findViewById(R.id.forgot);
        myTextViewf.setTypeface(myTypeface);
        TextView su=(TextView) findViewById(R.id.sign);
        su.setTypeface(myTypeface);
        TextView dn=(TextView) findViewById(R.id.dont);
        dn.setTypeface(myTypeface);
        TextView en=(TextView) findViewById(R.id.eng);
        en.setTypeface(myTypeface);
//        TextView bng=(TextView) findViewById(R.id.bn);
//        bng.setTypeface(myTypeface);

        ImageView name = (ImageView) findViewById(R.id.name);
        if(Config.lang){
            login.setText(R.string.Login);
            editTextLogin.setHint(R.string.prompt_username);
            editTextPassword.setHint(R.string.prompt_password);
            en.setText(R.string.ChangeLangE);
            myTextViewf.setText(R.string.forgetpass);
            su.setText(R.string.signup);
            dn.setText(R.string.noaccount);
            name.setImageResource(R.drawable.text);
        }
        else {
            login.setText(R.string.LoginB);
            editTextLogin.setHint(R.string.prompt_usernameb);
            editTextPassword.setHint(R.string.prompt_passwordb);
            en.setText(R.string.ChangeLangB);
            myTextViewf.setText(R.string.forgetpassB);
            su.setText(R.string.signupB);
            dn.setText(R.string.noaccountB);
            name.setImageResource(R.drawable.textb);
        }


        myTextViewf.setPaintFlags(myTextViewf.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        su.setPaintFlags(su.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        en.setPaintFlags(en.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    public void logged(View v){
        login();
    }

    private void login(){
        //Getting values from edit texts
        final String user_email = editTextLogin.getText().toString().trim();
        final String user_password = editTextPassword.getText().toString().trim();
        Config.userName=user_email;

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(response.equals("Success")){
                            //Starting profile activity
                            finish();
                            Intent i=new Intent(MainActivity.this,AfterLogin.class);
                            startActivity(i);

                        }else{
                            //If the server response is not success
                            //Displaying an error message on toast
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(MainActivity.this,"No internet connection!", Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("user_email", user_email);
                params.put("user_password", user_password);
                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("in ", "adding request");
    }

    public void forpass(View v){
        Intent i=new Intent(MainActivity.this,ForgetPass.class);
        startActivity(i);
    }
    public void signup(View v){
        Intent i=new Intent(MainActivity.this,SignUp.class);
        startActivity(i);
    }
    public void changeLang(View v){
        Config.lang=!Config.lang;
        finish();
        startActivity(getIntent());
    }
}
