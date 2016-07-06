package com.example.kazimdmunim.smarthealthmonitor;


import com.android.volley.AuthFailureError;
import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;

public class SignUp extends Activity {

    TextView fnm,usr,eml,ps,rps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.sign_up);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"font.otf");
        fnm = (TextView)findViewById(R.id.fname);
        fnm.setTypeface(myTypeface);
        usr = (TextView)findViewById(R.id.user);
        usr.setTypeface(myTypeface);
        eml = (TextView)findViewById(R.id.email);
        eml.setTypeface(myTypeface);
        ps = (TextView)findViewById(R.id.pass);
        ps.setTypeface(myTypeface);
        rps = (TextView)findViewById(R.id.rpass);
        rps.setTypeface(myTypeface);

        TextView ttl = (TextView)findViewById(R.id.ar);
        ttl.setTypeface(myTypeface);

        ImageView name = (ImageView) findViewById(R.id.name);
        if(Config.lang){
            fnm.setHint(R.string.prompt_fullname);
            usr.setHint(R.string.prompt_username);
            eml.setHint(R.string.prompt_email);
            ps.setHint(R.string.prompt_password);
            rps.setHint(R.string.prompt_Rpassword);
            ttl.setText(R.string.createAccount);
            name.setImageResource(R.drawable.text);
        }
        else {
            fnm.setHint(R.string.prompt_fullnameb);
            usr.setHint(R.string.prompt_usernameb);
            eml.setHint(R.string.prompt_emailb);
            ps.setHint(R.string.prompt_passwordb);
            rps.setHint(R.string.prompt_Rpasswordb);
            ttl.setText(R.string.createAccountB);
            name.setImageResource(R.drawable.textb);
        }
    }

    public void takeHW(View v){

        Config.fullName = fnm.getText().toString().trim();
        Config.userName = usr.getText().toString().trim();
        Config.email = eml.getText().toString().trim();
        Config.password = ps.getText().toString().trim();
        Config.rpassword = rps.getText().toString().trim();

        Intent i=new Intent(SignUp.this,TakeHW.class);
        startActivity(i);

//        register();
    }


}
