package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ForgetPass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.forget_pass);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"font.otf");
        TextView myTextView = (TextView)findViewById(R.id.ar);
        myTextView.setTypeface(myTypeface);
        TextView mail = (TextView)findViewById(R.id.editText);
        mail.setTypeface(myTypeface);
    }

    public void goPrv(View v){
        Intent i=new Intent(ForgetPass.this,MainActivity.class);
        startActivity(i);
    }
}
