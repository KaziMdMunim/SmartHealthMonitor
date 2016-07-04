package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphPL extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.graph_pl);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"font.otf");
        TextView bpTex = (TextView) findViewById(R.id.bptext);
        bpTex.setTypeface(typeface);

        TextView max = (TextView) findViewById(R.id.max);
        max.setTypeface(typeface);
        TextView min = (TextView) findViewById(R.id.min);
        min.setTypeface(typeface);
        TextView avg = (TextView) findViewById(R.id.avg);
        avg.setTypeface(typeface);
        TextView sg = (TextView) findViewById(R.id.sugg);
        sg.setTypeface(typeface);


        ImageView name = (ImageView) findViewById(R.id.name);
        if(Config.lang){
            max.setText(R.string.max);
            sg.setText(R.string.stsAndsuggPl);
            min.setText(R.string.min);
            avg.setText(R.string.avg);
            bpTex.setText(R.string.pls);
            name.setImageResource(R.drawable.text);
        }
        else{
            max.setText(R.string.maxB);
            min.setText(R.string.minB);
            sg.setText(R.string.stsAndsuggPlbn);
            avg.setText(R.string.avgB);
            bpTex.setText(R.string.plsB);
            name.setImageResource(R.drawable.textb);
        }




        String maxx=String.format("%.2f", Config.maxPL);
        String minn=String.format("%.2f", Config.minPL);
        String avgg=String.format("%.2f", Config.avgPL);

        TextView sysmax = (TextView) findViewById(R.id.sysmax);
        sysmax.setTypeface(typeface);
        sysmax.setText(maxx);
        TextView sysmin = (TextView) findViewById(R.id.sysmin);
        sysmin.setTypeface(typeface);
        sysmin.setText(minn);
        TextView sysavg = (TextView) findViewById(R.id.sysavg);
        sysavg.setTypeface(typeface);
        sysavg.setText(avgg);



        GraphView graph = (GraphView) findViewById(R.id.graph);


        LineGraphSeries<DataPoint> seriesP = new LineGraphSeries<DataPoint>(new DataPoint[]{});

        for(int i=0;i<Config.lenPl;i++){
            seriesP.appendData(new DataPoint(i, Config.beats[i]), true, 12);
//            series.appendData(new DataPoint( i+3 , i), true, 20);
        }

        seriesP.setDrawDataPoints(true);
        seriesP.setDataPointsRadius(5);
        seriesP.setColor(Color.parseColor("#1EB7B2"));
        seriesP.setThickness(3);

        graph.addSeries(seriesP);
    }
    public void suggest (View v){
        Config.paramName="Pulse";
        Config.paramNamebn="নাড়ির স্পন্দন";
        Intent i = new Intent(graphPL.this,suggBM.class);
        startActivity(i);
    }
}
