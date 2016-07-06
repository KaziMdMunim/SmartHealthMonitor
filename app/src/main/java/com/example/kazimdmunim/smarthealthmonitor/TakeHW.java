package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

public class TakeHW extends Activity {

    TextView feet,inch,weight,years;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.take_hw);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"font.otf");
        TextView fnm = (TextView)findViewById(R.id.ht);
        fnm.setTypeface(myTypeface);
        TextView usr = (TextView)findViewById(R.id.wtn);
        usr.setTypeface(myTypeface);
        TextView age = (TextView)findViewById(R.id.ag);
        age.setTypeface(myTypeface);
        feet = (TextView)findViewById(R.id.ft);
        feet.setTypeface(myTypeface);
        inch = (TextView)findViewById(R.id.inc);
        inch.setTypeface(myTypeface);
        weight = (TextView)findViewById(R.id.wt);
        weight.setTypeface(myTypeface);
        TextView ttl = (TextView)findViewById(R.id.ar);
        ttl.setTypeface(myTypeface);
        years = (TextView)findViewById(R.id.dt);
        years.setTypeface(myTypeface);

        ImageView name = (ImageView) findViewById(R.id.name);
        if(Config.lang){
            ttl.setText(R.string.fewMore);
            age.setText(R.string.age);
            fnm.setText(R.string.height);
            usr.setText(R.string.weight);
            inch.setHint(R.string.prompt_inches);
            feet.setHint(R.string.prompt_feet);
            years.setHint(R.string.prompt_day);
            weight.setHint(R.string.prompt_weight);
            name.setImageResource(R.drawable.text);
        }
        else {
            ttl.setText(R.string.fewMoreB);
            age.setText(R.string.ageB);
            fnm.setText(R.string.heightB);
            usr.setText(R.string.weightB);
            inch.setHint(R.string.prompt_inchesb);
            feet.setHint(R.string.prompt_feetb);
            years.setHint(R.string.prompt_yearb);
            weight.setHint(R.string.prompt_weightb);
            name.setImageResource(R.drawable.textb);
        }
//        TextView m = (TextView)findViewById(R.id.mon);
//        m.setTypeface(myTypeface);
//        TextView y = (TextView)findViewById(R.id.yr);
//        y.setTypeface(myTypeface);
    }

    public void registerUser(View v){
      register();
    }

    private void register(){


        Config.years = years.getText().toString().trim();
        Config.feet = feet.getText().toString().trim();
        Config.inch = inch.getText().toString().trim();
        Config.weight = weight.getText().toString().trim();
//        Config.rpassword = rps.getText().toString().trim();
//
        //Getting values from edit texts

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server

                        if(response.equals("Registration Successful")){
                            Intent i=new Intent(TakeHW.this,AfterLogin.class);
                            startActivity(i);
                            //Starting profile activity
                        }else{

                            //If the server response is not success
                            //Displaying an error message on toast
                            Toast.makeText(TakeHW.this, response, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(TakeHW.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("fname", Config.fullName);
                params.put("uname", Config.userName);
                params.put("email", Config.email);
                params.put("pwd", Config.password);
                params.put("rpwd", Config.rpassword);

                params.put("age", Config.years);
                params.put("heightf", Config.feet);
                params.put("heighti", Config.inch);
                params.put("weight", Config.weight);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("in ", "adding request");
    }

}
