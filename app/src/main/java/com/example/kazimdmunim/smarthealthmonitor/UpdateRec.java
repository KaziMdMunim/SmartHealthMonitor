package com.example.kazimdmunim.smarthealthmonitor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
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

import java.util.HashMap;
import java.util.Map;

public class UpdateRec extends Activity {

    TextView bpt,bpb,sugar,pulse,feet,inches,weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.update_rec);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"font.otf");
        TextView fnm = (TextView)findViewById(R.id.ar);
        fnm.setTypeface(myTypeface);
        TextView usr = (TextView)findViewById(R.id.bpt);
        usr.setTypeface(myTypeface);
        TextView eml = (TextView)findViewById(R.id.bst);
        eml.setTypeface(myTypeface);
        TextView ps = (TextView)findViewById(R.id.pst);
        ps.setTypeface(myTypeface);
        TextView rps = (TextView)findViewById(R.id.bmit);
        rps.setTypeface(myTypeface);
        bpt = (TextView)findViewById(R.id.tp);
        bpt.setTypeface(myTypeface);

        sugar = (TextView)findViewById(R.id.sg);
        sugar.setTypeface(myTypeface);
        pulse = (TextView)findViewById(R.id.pul);
        pulse.setTypeface(myTypeface);
        bpb = (TextView)findViewById(R.id.btm);
        bpb.setTypeface(myTypeface);
        weight= (TextView)findViewById(R.id.wgt);
        weight.setTypeface(myTypeface);

        ImageView name = (ImageView) findViewById(R.id.name);
        if(Config.lang){
            fnm.setText(R.string.updateT);
            usr.setText(R.string.bp);
            eml.setText(R.string.bs);
            ps.setText(R.string.pls);
            rps.setText(R.string.bmis);
            bpt.setHint(R.string.prompt_tp);
            sugar.setHint(R.string.prompt_mg);
            pulse.setHint(R.string.prompt_bt);
            bpb.setHint(R.string.prompt_btm);
            weight.setHint(R.string.prompt_weight);
            name.setImageResource(R.drawable.text);
        }
        else {
            fnm.setText(R.string.updateTb);
            usr.setText(R.string.bpB);
            eml.setText(R.string.bsB);
            ps.setText(R.string.plsB);
            rps.setText(R.string.bmisb);
            bpt.setHint(R.string.prompt_tpb);
            bpt.setTextSize(12);
            sugar.setHint(R.string.prompt_mgb);
            sugar.setTextSize(12);
            pulse.setHint(R.string.prompt_btb);
            pulse.setTextSize(12);
            bpb.setHint(R.string.prompt_btmb);
            bpb.setTextSize(12);
            weight.setHint(R.string.prompt_weightb);
            weight.setTextSize(12);
            name.setImageResource(R.drawable.textb);
        }
    }

    public void updated (View v){
//        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
//        myAlert.setMessage("Data updated.").create();
//        myAlert.show();
        getUpdate();
    }

    private void getUpdate() {
        Config.bpTop=bpt.getText().toString().trim();
        Config.bpBottom=bpb.getText().toString().trim();
        Config.sugar=sugar.getText().toString().trim();
        Config.pulse=pulse.getText().toString().trim();
//        Config.feet=feet.getText().toString().trim();
//        Config.inch=inches.getText().toString().trim();
        Config.weight=weight.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.UPDATE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("Updated")) {
                            Toast.makeText(UpdateRec.this,"Data updated",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(UpdateRec.this, AfterLogin.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(UpdateRec.this,response,Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("asdasd", "error");
                        Toast.makeText(UpdateRec.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        )
        {
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String , String> params = new HashMap<>();

                Log.e("in", "creating params");
                params.put("uname", Config.userName);
                params.put("bpTop", Config.bpTop);
                params.put("bpBottom", Config.bpBottom);
                params.put("sugar", Config.sugar);
                params.put("pulse", Config.pulse);
//                params.put("feet", Config.feet);
//                params.put("inch", Config.inch);
                params.put("weight",Config.weight);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Log.e("in", " adding request");
    }

    public void goBc(View v){
        Intent i = new Intent(UpdateRec.this, AfterLogin.class);
        startActivity(i);
    }

}
