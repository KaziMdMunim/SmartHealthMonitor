package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class suggBM extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.sugg_bm);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"font.otf");
        TextView sts = (TextView) findViewById(R.id.status);
        sts.setTypeface(typeface);
        TextView stsT = (TextView) findViewById(R.id.statusText);
        stsT.setTypeface(typeface);
        TextView suggT = (TextView) findViewById(R.id.sugg);
        suggT.setTypeface(typeface);
        TextView param = (TextView) findViewById(R.id.param);
        param.setTypeface(typeface);
        param.setText(Config.paramName);

        WebView mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings();
        mWebView.setBackgroundColor(Color.TRANSPARENT);
        ImageView name = (ImageView) findViewById(R.id.name);

        if(Config.lang){
            sts.setText(Config.statusBM);
            param.setText(Config.paramName);
            stsT.setText("Status: ");
            suggT.setText("Suggestions:");
            if(Config.paramName.equals("Pulse")){
                suggT.setText(" ");
                String s="";
                if(Config.curPL>=60 && Config.curPL<=100){
                    s="Normal pulse rate";
                }
                else if(Config.curPL>100){
                    s="High pulse rate";
                }
                else {
                    s="Low pulse rate";
                }
                sts.setText(s);
            }
            else {
                suggT.setText("Suggestions:");


                String text = "<html><body>"
                        + "<p align=\"justify\">" + "<font color=\"#1c1d26\" >"
                        + Config.suggBM + "</font>"
                        + "</p> "
                        + "</body></html>";

                mWebView.loadData(text, "text/html", "utf-8");

            }

            name.setImageResource(R.drawable.text);
        }
        else{
            sts.setText(Config.statusBMbn);
            param.setText(Config.paramNamebn);
            stsT.setText("স্বাস্থ্য অবস্থাঃ ");
            suggT.setText("পরামর্শঃ");
            if(Config.paramName.equals("Pulse")){
                suggT.setText(" ");
                String s="";
                if(Config.curPL>=60 && Config.curPL<=100){
                    s="স্বাভাবিক নাড়ি স্পন্দন";
                }
                else if(Config.curPL>100){
                    s="উচ্চ নাড়ি স্পন্দন";
                }
                else {
                    s="নিম্ন নাড়ি স্পন্দন";
                }
                sts.setText(s);
            }
            else {
                suggT.setText("পরামর্শঃ");

                String text = "<html><body>"
                        + "<p align=\"justify\">" + "<font color=\"#1c1d26\" >"
                        + Config.suggBMbn + "</font>"
                        + "</p> "
                        + "</body></html>";

                mWebView.loadData(text, "text/html", "utf-8");

            }

            name.setImageResource(R.drawable.textb);
        }




    }
}
