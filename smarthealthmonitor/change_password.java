package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
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

public class change_password extends Activity {
    TextView ps, old, rps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.change_password);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"font.otf");

        ImageView name = (ImageView) findViewById(R.id.name);

        old = (TextView)findViewById(R.id.oldpass);
        old.setTypeface(myTypeface);
        ps = (TextView)findViewById(R.id.pass);
        ps.setTypeface(myTypeface);
        rps = (TextView)findViewById(R.id.rpass);
        rps.setTypeface(myTypeface);

        TextView ttl = (TextView)findViewById(R.id.ar);
        ttl.setTypeface(myTypeface);


        if(Config.lang){
            old.setHint(" Current password");
            ps.setHint(" New password");
            rps.setHint(" Retype new password");
            ttl.setText(R.string.passChange);
            name.setImageResource(R.drawable.text);
        }
        else{
            old.setHint(" বর্তমান পাসওয়ার্ড");
            ps.setHint(" নতুন পাসওয়ার্ড");
            rps.setHint(" নতুন পাসওয়ার্ড পুনরায় লিখুন");
            ttl.setText(R.string.passChangebn);
            name.setImageResource(R.drawable.textb);
        }
    }

    public void changed (View v){
        changedPass();
    }

    private void changedPass() {

        Config.oldpass = old.getText().toString().trim();
        Config.newpass = ps.getText().toString().trim();
        Config.reppass = rps.getText().toString().trim();
//        Config.rpassword = rps.getText().toString().trim();
//
        //Getting values from edit texts

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.CHANGE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server

                        if(response.equals("Successful")){
                            Toast.makeText(change_password.this, "Password changed successfully", Toast.LENGTH_LONG).show();
                            Intent i=new Intent(change_password.this,AfterLogin.class);
                            startActivity(i);
                            //Starting profile activity
                        }else{

                            //If the server response is not success
                            //Displaying an error message on toast
                            Toast.makeText(change_password.this, response, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(change_password.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("uname", Config.userName);
                params.put("old", Config.oldpass);
                params.put("pwd", Config.newpass);
                params.put("rpwd", Config.reppass);

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
