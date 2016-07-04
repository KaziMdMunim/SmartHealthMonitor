package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphALL extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.graph_all);

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
        TextView systb = (TextView) findViewById(R.id.systb);
        systb.setTypeface(typeface);
        TextView diasb = (TextView) findViewById(R.id.diasb);
        diasb.setTypeface(typeface);


        TextView sugar = (TextView) findViewById(R.id.sugar);
        sugar.setTypeface(typeface);
        TextView pulse = (TextView) findViewById(R.id.pulse);
        pulse.setTypeface(typeface);
        TextView bmii = (TextView) findViewById(R.id.bmii);
        bmii.setTypeface(typeface);

        TextView plsb = (TextView) findViewById(R.id.plsb);
        plsb.setTypeface(typeface);
        TextView bmib = (TextView) findViewById(R.id.bmib);
        bmib.setTypeface(typeface);
        TextView sgrb = (TextView) findViewById(R.id.sgrb);
        sgrb.setTypeface(typeface);

        TextView pls = (TextView) findViewById(R.id.pls);
        pls.setTypeface(typeface);
        TextView bmi = (TextView) findViewById(R.id.bmi);
        bmi.setTypeface(typeface);
        TextView sgr = (TextView) findViewById(R.id.sgr);
        sgr.setTypeface(typeface);



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



        String maxx=String.format("%.2f", Config.maxBM);
        String minn=String.format("%.2f", Config.minBM);
        String avgg=String.format("%.2f", Config.avgBM);

        TextView bmimax = (TextView) findViewById(R.id.bmimax);
        bmimax.setTypeface(typeface);
        bmimax.setText(maxx);
        TextView bmimin = (TextView) findViewById(R.id.bmimin);
        bmimin.setTypeface(typeface);
        bmimin.setText(minn);
        TextView bmiavg = (TextView) findViewById(R.id.bmiavg);
        bmiavg.setTypeface(typeface);
        bmiavg.setText(avgg);


        String maxxp=String.format("%.2f", Config.maxPL);
        String minnp=String.format("%.2f", Config.minPL);
        String avggp=String.format("%.2f", Config.avgPL);

        TextView plsmax = (TextView) findViewById(R.id.plsmax);
        plsmax.setTypeface(typeface);
        plsmax.setText(maxxp);
        TextView plsmin = (TextView) findViewById(R.id.plsmin);
        plsmin.setTypeface(typeface);
        plsmin.setText(minnp);
        TextView plsavg = (TextView) findViewById(R.id.plsavg);
        plsavg.setTypeface(typeface);
        plsavg.setText(avggp);



        String maxxs=String.format("%.2f", Config.maxSG);
        String minns=String.format("%.2f", Config.minSG);
        String avggs=String.format("%.2f", Config.avgSG);

        TextView sugarmax = (TextView) findViewById(R.id.sugarmax);
        sugarmax.setTypeface(typeface);
        sugarmax.setText(maxxs);
        TextView sugarmin = (TextView) findViewById(R.id.sugarmin);
        sugarmin.setTypeface(typeface);
        sugarmin.setText(minns);
        TextView sugaravg = (TextView) findViewById(R.id.sugaravg);
        sugaravg.setTypeface(typeface);
        sugaravg.setText(avggs);



        ImageView name = (ImageView) findViewById(R.id.name);
        if(Config.lang){
            max.setText(R.string.max);
            min.setText(R.string.min);
            avg.setText(R.string.avg);
            sys.setText(R.string.sys);
            syst.setText(R.string.sys);
            dia.setText(R.string.dia);
            dias.setText(R.string.dia);
            bpTex.setText(R.string.allg);

            pls.setText(R.string.pls);
            bmi.setText(R.string.bmis);
            sgr.setText(R.string.bss);
            pulse.setText(R.string.pls);
            bmii.setText(R.string.bmis);
            sugar.setText(R.string.bss);
            name.setImageResource(R.drawable.text);
        }
        else{
            max.setText(R.string.maxB);
            min.setText(R.string.minB);
            avg.setText(R.string.avgB);
            sys.setText(R.string.sysB);
            systb.setText(R.string.sysB);
            dia.setText(R.string.diaB);
            diasb.setText(R.string.diaB);
            bpTex.setText(R.string.allgB);
            plsb.setText(R.string.plsB);
            bmib.setText(R.string.bmisb);
            sgrb.setText(R.string.bssB);
            pulse.setText(R.string.plsB);
            bmii.setText(R.string.bmisb);
            sugar.setText(R.string.bssB);
            name.setImageResource(R.drawable.textb);
        }


        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> seriesT = new LineGraphSeries<DataPoint>(new DataPoint[]{});
        LineGraphSeries<DataPoint> seriesB = new LineGraphSeries<DataPoint>(new DataPoint[]{});
        LineGraphSeries<DataPoint> seriesS = new LineGraphSeries<DataPoint>(new DataPoint[]{});
        LineGraphSeries<DataPoint> seriesP = new LineGraphSeries<DataPoint>(new DataPoint[]{});
        LineGraphSeries<DataPoint> seriesBm = new LineGraphSeries<DataPoint>(new DataPoint[]{});

        for(int i=0;i<Config.len;i++){
            seriesT.appendData(new DataPoint(i, Config.bpt[i]), true, 1000);
            seriesB.appendData(new DataPoint(i, Config.bpb[i]), true, 1000);
//            series.appendData(new DataPoint( i+3 , i), true, 20);
        }

        seriesT.setDrawDataPoints(true);
        seriesT.setDataPointsRadius(5);
        seriesT.setColor(Color.parseColor("#0ceefe"));
        seriesT.setThickness(3);

        graph.addSeries(seriesT);

        seriesB.setDrawDataPoints(true);
        seriesB.setDataPointsRadius(5);
        seriesB.setColor(Color.parseColor("#ff1616"));
        seriesB.setThickness(3);

        graph.addSeries(seriesB);


        for(int i=0;i<Config.lenSg;i++){
            seriesS.appendData(new DataPoint(i, Config.sugarLvl[i]), true, 200);
//            series.appendData(new DataPoint( i+3 , i), true, 20);
        }

        seriesS.setDrawDataPoints(true);
        seriesS.setDataPointsRadius(5);
        seriesS.setColor(Color.parseColor("#BFFF00"));
        seriesS.setThickness(3);

        graph.addSeries(seriesS);

        for(int i=0;i<Config.lenBm;i++){
            seriesBm.appendData(new DataPoint(i, Config.bmi[i]), true, 200);
//            series.appendData(new DataPoint( i+3 , i), true, 20);
        }

        seriesBm.setDrawDataPoints(true);
        seriesBm.setDataPointsRadius(5);
        seriesBm.setColor(Color.parseColor("#FFFFFF"));
        seriesBm.setThickness(3);

        graph.addSeries(seriesBm);

        for(int i=0;i<Config.lenPl;i++){
            seriesP.appendData(new DataPoint(i, Config.beats[i]), true, 200);
//            series.appendData(new DataPoint( i+3 , i), true, 20);
        }

        seriesP.setDrawDataPoints(true);
        seriesP.setDataPointsRadius(5);
        seriesP.setColor(Color.parseColor("#ffff00"));
        seriesP.setThickness(3);

        graph.addSeries(seriesP);


    }
}
