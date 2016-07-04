package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.HashMap;
import java.util.Map;

public class graphBP extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.graph_bp);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"font.otf");
        TextView bpTex = (TextView) findViewById(R.id.bptext);
        bpTex.setTypeface(typeface);

        TextView max = (TextView) findViewById(R.id.max);
        max.setTypeface(typeface);
        TextView min = (TextView) findViewById(R.id.min);
        min.setTypeface(typeface);
        TextView avg = (TextView) findViewById(R.id.avg);
        avg.setTypeface(typeface);
        TextView sys = (TextView) findViewById(R.id.sys);
        sys.setTypeface(typeface);
        TextView dia = (TextView) findViewById(R.id.dia);
        dia.setTypeface(typeface);
        TextView syst = (TextView) findViewById(R.id.syst);
        syst.setTypeface(typeface);
        TextView dias = (TextView) findViewById(R.id.dias);
        dias.setTypeface(typeface);



        String avgt=String.format("%.2f", Config.avgBpT);
        String avgb=String.format("%.2f", Config.avgBpB);

        TextView sysmax = (TextView) findViewById(R.id.sysmax);
        sysmax.setTypeface(typeface);
        sysmax.setText(String.valueOf(Config.maxBpT));
        TextView sysmin = (TextView) findViewById(R.id.sysmin);
        sysmin.setTypeface(typeface);
        sysmin.setText(String.valueOf(Config.minBpT));
        TextView sysavg = (TextView) findViewById(R.id.sysavg);
        sysavg.setTypeface(typeface);
        sysavg.setText(avgt);

        TextView diamax = (TextView) findViewById(R.id.diamax);
        diamax.setTypeface(typeface);
        diamax.setText(String.valueOf(Config.maxBpB));
        TextView diamin = (TextView) findViewById(R.id.diamin);
        diamin.setTypeface(typeface);
        diamin.setText(String.valueOf(Config.minBpB));
        TextView diaavg = (TextView) findViewById(R.id.diaavg);
        diaavg.setTypeface(typeface);
        diaavg.setText(avgb);
        TextView sg = (TextView) findViewById(R.id.sugg);
        sg.setTypeface(typeface);


        ImageView name = (ImageView) findViewById(R.id.name);
        if(Config.lang){
            max.setText(R.string.max);
            min.setText(R.string.min);
            avg.setText(R.string.avg);
            sys.setText(R.string.sys);
            syst.setText(R.string.sys);
            dia.setText(R.string.dia);
            dias.setText(R.string.dia);
            sg.setText(R.string.stsAndsugg);
            bpTex.setText(R.string.bp);
            name.setImageResource(R.drawable.text);
        }
        else{
            max.setText(R.string.maxB);
            min.setText(R.string.minB);
            avg.setText(R.string.avgB);
            sys.setText(R.string.sysB);
            syst.setText(R.string.sysB);
            sg.setText(R.string.stsAndsuggbn);
            dia.setText(R.string.diaB);
            dias.setText(R.string.diaB);
            bpTex.setText(R.string.bpB);
            name.setImageResource(R.drawable.textb);
        }


        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> seriesT = new LineGraphSeries<DataPoint>(new DataPoint[]{});
        LineGraphSeries<DataPoint> seriesB = new LineGraphSeries<DataPoint>(new DataPoint[]{});

        for(int i=0;i<Config.len;i++){
            seriesT.appendData(new DataPoint(i, Config.bpt[i]), true, 12);
            seriesB.appendData(new DataPoint(i, Config.bpb[i]), true, 12);
//            series.appendData(new DataPoint( i+3 , i), true, 20);
        }

        seriesT.setDrawDataPoints(true);
        seriesT.setDataPointsRadius(5);
        seriesT.setColor(Color.RED);
        seriesT.setThickness(3);

        seriesB.setDrawDataPoints(true);
        seriesB.setDataPointsRadius(5);
        seriesB.setColor(Color.YELLOW);
        seriesB.setThickness(3);


        graph.addSeries(seriesT);
        graph.addSeries(seriesB);
    }

    public void suggest (View v){
        fetchSugg();
    }

    private void fetchSugg() {

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.GRAPH_URL_BP_SUGG,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if(!response.equals("failed")){
                            fetchJSON(response);
                        }

                        else{
                            Toast.makeText(graphBP.this, "No suggestions!", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        Log.d("asdasd", "error");
                        Toast.makeText(graphBP.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request
                Log.e("in ", "creating params");
                params.put("uname", Config.userName);
                params.put("lvl", Float.toString(Config.curBP));

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
        Config.paramName="Blood Pressure";
        Config.paramNamebn="রক্তচাপ";
        Intent i = new Intent(graphBP.this,suggBM.class);
        startActivity(i);
    }
}
