package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class setAlarm extends Activity {

    TextView hour,min,med_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.set_alarm);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"font.otf");

        TextView set = (TextView) findViewById(R.id.set_med_alart_text);
        TextView hh = (TextView) findViewById(R.id.hh);
        TextView mm = (TextView) findViewById(R.id.mm);
        TextView medName = (TextView) findViewById(R.id.medice_name);

        set.setTypeface(myTypeface);
        hh.setTypeface(myTypeface);
        mm.setTypeface(myTypeface);
        medName.setTypeface(myTypeface);
    }
}
