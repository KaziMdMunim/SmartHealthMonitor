package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class web extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.web);

        WebView view = (WebView) this.findViewById(R.id.webview);
        if(Config.lang){
            String url = "http://smarthealthmonitor.eu.pn/";
            view.getSettings().setJavaScriptEnabled(true);
            view.loadUrl(url);
        }
        else{
            String url = "http://smarthealthmonitor.eu.pn/indexbn.php";
            view.getSettings().setJavaScriptEnabled(true);
            view.loadUrl(url);
        }

    }
}