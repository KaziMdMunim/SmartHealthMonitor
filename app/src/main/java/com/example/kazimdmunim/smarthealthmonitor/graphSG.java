package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
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
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.HashMap;
import java.util.Map;

public class graphSG extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.graph_sg);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"font.otf");
        TextView bpTex = (TextView) findViewById(R.id.bptext);
        bpTex.setTypeface(typeface);

        TextView max = (TextView) findViewById(R.id.max);
        max.setTypeface(typeface);
        TextView min = (TextView) findViewById(R.id.min);
        min.setTypeface(typeface);
        TextView avg = (TextView) findViewById(R.id.avg);
        avg.setTypeface(typeface);

        ImageView name = (ImageView) findViewById(R.id.name);
        if(Config.lang){
            max.setText(R.string.max);
            min.setText(R.string.min);
            avg.setText(R.string.avg);
            bpTex.setText(R.string.bs);
            name.setImageResource(R.drawable.text);
        }
        else{
            max.setText(R.string.maxB);
            min.setText(R.string.minB);
            avg.setText(R.string.avgB);
            bpTex.setText(R.string.bsB);
            name.setImageResource(R.drawable.textb);
        }



        String maxx=String.format("%.2f", Config.maxSG);
        String minn=String.format("%.2f", Config.minSG);
        String avgg=String.format("%.2f", Config.avgSG);

        TextView sysmax = (TextView) findViewById(R.id.sysmax);
        sysmax.setTypeface(typeface);
        sysmax.setText(maxx);
        TextView sysmin = (TextView) findViewById(R.id.sysmin);
        sysmin.setTypeface(typeface);
        sysmin.setText(minn);
        TextView sysavg = (TextView) findViewById(R.id.sysavg);
        sysavg.setTypeface(typeface);
        sysavg.setText(avgg);
        TextView sg = (TextView) findViewById(R.id.sugg);
        sg.setTypeface(typeface);



        GraphView graph = (GraphView) findViewById(R.id.graph);


        LineGraphSeries<DataPoint> seriesS = new LineGraphSeries<DataPoint>(new DataPoint[]{});

        for(int i=0;i<Config.lenSg;i++){
            seriesS.appendData(new DataPoint(i, Config.sugarLvl[i]), true, 12);
//            series.appendData(new DataPoint( i+3 , i), true, 20);
        }

        seriesS.setDrawDataPoints(true);
        seriesS.setDataPointsRadius(5);
        seriesS.setColor(Color.parseColor("#b9ced5"));
        seriesS.setThickness(3);

        graph.addSeries(seriesS);

    }


    public void suggest (View v){
        fetchSugg();
    }

    private void fetchSugg() {

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.GRAPH_URL_SG_SUGG,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(!response.equals("failed")){
                            fetchJSON(response);
                        }

                        else{
                            Toast.makeText(graphSG.this, "No suggestions!", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(graphSG.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("uname", Config.userName);
                params.put("lvl", Float.toString(Config.curSUGAR));

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("in ", "adding request");
    }

    private void fetchJSON(String json) {
        ParseJSONsuggBM pj = new ParseJSONsuggBM(json);
        pj.parseJSONsuggBM();
        Config.paramName="Blood Sugar";
        Intent i = new Intent(graphSG.this,suggBM.class);
        startActivity(i);
    }
}
