package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AfterLogin extends Activity {

    public static int startBP=0;
    public static int startSG=0;
    public static int startBM=0;
    public static int startPL=0;
    public static int startALL=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.after_login);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"font.otf");

        TextView myTextView = (TextView)findViewById(R.id.ur);
        myTextView.setTypeface(myTypeface);

        TextView lout = (TextView)findViewById(R.id.lo);
        lout.setTypeface(myTypeface);

//        TextView pr = (TextView)findViewById(R.id.par);
//        pr.setTypeface(myTypeface);

        TextView us = (TextView)findViewById(R.id.usr);
        us.setText("( " + Config.userName + " )");
        us.setTypeface(myTypeface);
        ImageView name = (ImageView) findViewById(R.id.name);
        ImageView bp = (ImageView) findViewById(R.id.btnbp);
        ImageView pls = (ImageView) findViewById(R.id.btnpl);
        ImageView bmi = (ImageView) findViewById(R.id.btnbmi);
        ImageView sg = (ImageView) findViewById(R.id.btnbs);
        ImageView all = (ImageView) findViewById(R.id.btnall);
        ImageView rem = (ImageView) findViewById(R.id.btnalm);
        ImageView web = (ImageView) findViewById(R.id.btnweb);
        ImageView faq = (ImageView) findViewById(R.id.btnfaq);
        if(Config.lang){
            lout.setText(R.string.logout);
            myTextView.setText(R.string.update);
            name.setImageResource(R.drawable.text);
            bp.setImageResource(R.drawable.bp);
            pls.setImageResource(R.drawable.pulse);
            bmi.setImageResource(R.drawable.bmi);
            sg.setImageResource(R.drawable.bs);
            all.setImageResource(R.drawable.allgraph);
            rem.setImageResource(R.drawable.alrm);
            web.setImageResource(R.drawable.web);
            faq.setImageResource(R.drawable.btnfaq);
        }
        else{
            lout.setText(R.string.logoutB);
            myTextView.setText(R.string.updateB);
            name.setImageResource(R.drawable.textb);
            bp.setImageResource(R.drawable.bpb);
            pls.setImageResource(R.drawable.pulseb);
            bmi.setImageResource(R.drawable.bmib);
            sg.setImageResource(R.drawable.bsb);
            all.setImageResource(R.drawable.allgraphb);
            rem.setImageResource(R.drawable.alrmb);
            web.setImageResource(R.drawable.webb);
            faq.setImageResource(R.drawable.btnfaqb);
        }

        us.setPaintFlags(us.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        lout.setPaintFlags(lout.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        myTextView.setPaintFlags(myTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    public void goProfile (View v){
        Intent i = new Intent(AfterLogin.this,change_password.class);
        startActivity(i);
    }

    public void logout(View v){
        clearAll();
        finish();
        Intent i = new Intent(AfterLogin.this,MainActivity.class);
        startActivity(i);
    }


    public void graphAll(View v){
        Config.graphName="ALL";
        showGraph();
        showGraphSg();
        showGraphPl();
        showGraphBm();

    }

    public void graphBp(View v){
        Config.graphName="BP";
        showGraph();
    }
    public void graphSg(View v){
        Config.graphName="SG";
        showGraphSg();

    }

    public void graphPl(View v){
        Config.graphName="PL";
        showGraphPl();

    }
    public void graphBm(View v){
        Config.graphName="BM";
        showGraphBm();

    }

    private void showGraph() {


        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.GRAPH_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(!response.equals("failed")){
                            showJSON(response);
                        }

                        else{
                            error();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(AfterLogin.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("uname", Config.userName);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("in ", "adding request");
    }

    private void showGraphSg() {


        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.GRAPH_URL_SG,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(!response.equals("failed")){
                            showJSONSg(response);
                        }

                        else{
                            error();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(AfterLogin.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("uname", Config.userName);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("in ", "adding request");
    }

    private void showGraphPl() {


        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.GRAPH_URL_PL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(!response.equals("failed")){
                            showJSONPl(response);
                        }

                        else{
                            error();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(AfterLogin.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("uname", Config.userName);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("in ", "adding request");
    }

    private void showGraphBm() {


        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.GRAPH_URL_BM,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(!response.equals("failed")){
                            showJSONBm(response);
                        }

                        else{
                            error();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(AfterLogin.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("uname", Config.userName);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("in ", "adding request");
    }


    private void showJSON(String json) {
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();

//        for(int i=0;i<Config.len;i++){
//            Config.dtet[i]=Integer.parseInt(ParseJSON.date[i].substring(6,ParseJSON.date[i].length()));
//        }
//
//
//        long max=999999,hi;
//        int pos=0,in;
//
//        for (int i=0;i<Config.len;i++){
//            in=0;hi=max;
//            for(int j=0;j<Config.len;j++){
//                if(Config.dtet[j]<hi){
//                    hi=Config.dtet[j];
//                    in=j;
//                }
//            }
//            Config.dtet[in]=max;
//            Config.dte[pos]=hi;
//            Config.bpt[pos]=Integer.parseInt(ParseJSON.bpTop[in]);
//            Config.bpb[pos]=Integer.parseInt(ParseJSON.bpBottom[in]);
//            pos++;
//        }

        float avgT=0,avgB=0;
        long bpmxT=0,bpmnT=9999;
        long bpmxB=0,bpmnB=9999;
//        if(Config.len>9){
//            startBP = Config.len-9;
//        }
        for(int i=0;i<Config.len;i++){
            avgT+=Config.bpt[i];
            avgB+=Config.bpb[i];
            if(bpmxT<Config.bpt[i]){
                bpmxT=Config.bpt[i];
            }
            if(bpmnT>Config.bpt[i]){
                bpmnT=Config.bpt[i];
            }
            if(bpmxB<Config.bpb[i]){
                bpmxB=Config.bpb[i];
            }
            if(bpmnB>Config.bpb[i]){
                bpmnB=Config.bpb[i];
            }
        }

        Config.maxBpT=(int)bpmxT;
        Config.minBpT=(int)bpmnT;
        Config.maxBpB=(int)bpmxB;
        Config.minBpB=(int)bpmnB;

        Config.avgBpT=avgT/(float)(Config.len);
        Config.avgBpB=avgB/(float)(Config.len);

        if(Config.graphName.equals("BP")) {
            Intent i = new Intent(this, graphBP.class);
            startActivity(i);
        }
    }

    private void showJSONSg(String json) {
        ParseJSONSg pj = new ParseJSONSg(json);
        pj.parseJSONSg();

//        for(int i=0;i<Config.lenSg;i++){
//            Config.dtetSg[i]=Integer.parseInt(ParseJSONSg.dateSg[i].substring(6,ParseJSONSg.dateSg[i].length()));
//        }
//
//
//        long max=999999,hi;
//        int pos=0,in;
//
//        for (int i=0;i<Config.lenSg;i++){
//            in=0;hi=max;
//            for(int j=0;j<Config.lenSg;j++){
//                if(Config.dtetSg[j]<hi){
//                    hi=Config.dtetSg[j];
//                    in=j;
//                }
//            }
//            Config.dtetSg[in]=max;
//            Config.dteSg[pos]=hi;
//            Config.sugarLvl[pos]=Float.parseFloat(ParseJSONSg.sgLvl[in]);
//            pos++;
//        }


        if(Config.lenSg>9){
            startSG = Config.lenSg-9;
        }

        float avgSg=0;
        float sgMx=0,sgMn=9999;
        for(int i=startSG;i<Config.lenSg;i++){
            avgSg+=Config.sugarLvl[i];
            if(sgMx<Config.sugarLvl[i]){
                sgMx=Config.sugarLvl[i];
            }
            if(sgMn>Config.sugarLvl[i]){
                sgMn=Config.sugarLvl[i];
            }
        }

        Config.maxSG=sgMx;
        Config.minSG=sgMn;

        Config.avgSG=avgSg/(Config.lenSg-startSG);

        if(Config.graphName.equals("SG")) {
            Intent i = new Intent(this, graphSG.class);
            startActivity(i);
        }
    }

    private void showJSONPl(String json) {
        ParseJSONPl pj = new ParseJSONPl(json);
        pj.parseJSONPl();

//        for(int i=0;i<Config.lenPl;i++){
//            Config.dtetPl[i]=Integer.parseInt(ParseJSONPl.datePl[i].substring(6,ParseJSONPl.datePl[i].length()));
//        }


        if(Config.lenPl>9){
            startPL=Config.lenPl-9;
        }

//        long max=999999,hi;
//        int pos=0,in;
//
//        for (int i=0;i<Config.lenPl;i++){
//            in=0;hi=max;
//            for(int j=0;j<Config.lenPl;j++){
//                if(Config.dtetPl[j]<hi){
//                    hi=Config.dtetPl[j];
//                    in=j;
//                }
//            }
//            Config.dtetPl[in]=max;
//            Config.dtePl[pos]=hi;
//            Config.beats[pos]=Float.parseFloat(ParseJSONPl.beats[in]);
//            pos++;
//        }

        float avgPl=0;
        float plMx=0,plMn=9999;
        for(int i=startPL;i<Config.lenPl;i++){
            avgPl+=Config.beats[i];
            if(plMx<Config.beats[i]){
                plMx=Config.beats[i];
            }
            if(plMn>Config.beats[i]){
                plMn=Config.beats[i];
            }
        }

        Config.maxPL=plMx;
        Config.minPL=plMn;

        Config.avgPL=avgPl/(Config.lenPl-startPL);

        if(Config.graphName.equals("PL")) {
            Intent i = new Intent(this, graphPL.class);
            startActivity(i);
        }
    }

    private void showJSONBm(String json) {
        ParseJSONBm pj = new ParseJSONBm(json);
        pj.parseJSONBm();

//        for(int i=0;i<Config.lenBm;i++){
//            Config.dtetBm[i]=Integer.parseInt(ParseJSONBm.dateBm[i].substring(6,ParseJSONBm.dateBm[i].length()));
//        }


//        long max=999999,hi;
//        int pos=0,in;

        float feet=Float.parseFloat(ParseJSONBm.heightFeet);
        float inch=Float.parseFloat(ParseJSONBm.heightInch);

        float height=(feet*12)+inch;
//        float weight,bmi;

        height*=2.54;
        height/=100;

        if(Config.lenBm>9){
            startBM=Config.lenBm-9;
        }

        for (int i=startBM;i<Config.lenBm;i++){
            Config.bmi[i]=Config.bmi[i]/height/height;
        }

        float avgBm=0;
        float bmMx=0,bmMn=9999;
        for(int i=startBM;i<Config.lenBm;i++){
            avgBm+=Config.bmi[i];
            if(bmMx<Config.bmi[i]){
                bmMx=Config.bmi[i];
            }
            if(bmMn>Config.bmi[i]){
                bmMn=Config.bmi[i];
            }
        }

        Config.maxBM=bmMx;
        Config.minBM=bmMn;

        Config.curBMI=Config.bmi[Config.lenBm-1];

        Config.avgBM=avgBm/(Config.lenBm-startBM);

        if(Config.graphName.equals("BM")) {
            Intent i = new Intent(this, graphBM.class);
            startActivity(i);
        }

        else if(Config.graphName.equals("ALL")){
            Intent i = new Intent(this, graphALL.class);
            startActivity(i);
        }
    }

    public void error() {
        if(Config.graphName.equals("BP")) {
            Intent i = new Intent(this, graphBP.class);
            startActivity(i);
        }
        else if(Config.graphName.equals("SG")){
            Intent i = new Intent(this, graphSG.class);
            startActivity(i);
        }
        else if(Config.graphName.equals("PL")){
            Intent i = new Intent(this, graphPL.class);
            startActivity(i);
        }
        else if(Config.graphName.equals("BM")){
            Intent i = new Intent(this, graphBM.class);
            startActivity(i);
        }
        else if(Config.graphName.equals("ALL")){
            Intent i = new Intent(this, graphALL.class);
            startActivity(i);
        }
        Toast.makeText(AfterLogin.this,"No data is found!",Toast.LENGTH_LONG).show();
    }

    public void update (View v){
        Intent i = new Intent(AfterLogin.this,UpdateRec.class);
        startActivity(i);
    }

    public void set_alarm (View v){
        Intent i = new Intent(AfterLogin.this,setAlarm.class);
        startActivity(i);
    }

    public void viewWeb (View v){
        Intent i = new Intent(AfterLogin.this,web.class);
        startActivity(i);
    }

    public void faq (View v){
        Intent i = new Intent(AfterLogin.this,Faq.class);
        startActivity(i);
    }

    private void clearAll() {

        Config.maxBpT=0;Config.minBpT=0;
        Config.maxBpB=0;Config.minBpB=0;
        Config.avgBpT=0;Config.avgBpB=0;
        Config.len=0;

        Config.lenSg=0;
        Config.avgSG=0;Config.maxSG=0;Config.minSG=0;

        Config.lenPl=0;
        Config.avgPL=0;Config.maxPL=0;Config.minPL=0;

        Config.lenBm=0;
        Config.avgBM=0;Config.maxBM=0;Config.minBM=0;
        Config.curBMI = 0;
        Config.curSUGAR = 0;
        Config.curBP = 0;
        Config.curPL = 0;

        Config.graphName= "";
        Config.paramName= "";



        Config.highBM=0;Config.lowBM=0;
        Config.statusBM="";Config.suggBM="";
    }
}
