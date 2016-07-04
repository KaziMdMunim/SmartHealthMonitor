package com.example.kazimdmunim.smarthealthmonitor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kazi on 24-Apr-16.
 */
public class ParseJSONBm {
    public static String[] weight;
    public static String[] dateBm;
    public static String heightFeet;
    public static String heightInch;

    public static final String JSON_ARRAY = "result";
    public static final String WEIGHT = "weight";
    public static final String FEET = "user_height_feet";
    public static final String INCH = "user_height_inch";
    public static final String DATE = "date_bm";

    private JSONArray users = null;

    private String json;

    public ParseJSONBm(String json){
        this.json = json;
    }

    protected void parseJSONBm(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);
            Config.lenBm=users.length()-1;
            weight = new String[users.length()];
            dateBm = new String[users.length()];

            int start = 0;
            if(users.length()>10){
                start=users.length()-10;
                Config.lenBm=9;
            }

            for(int i=start,j=0;i<users.length()-1;i++,j++){
                JSONObject jo = users.getJSONObject(i);
                Config.bmi[j]= Float.parseFloat(jo.getString(WEIGHT));
                Config.dteBm[j] = Long.parseLong(jo.getString(DATE));
            }
            JSONObject jo = users.getJSONObject(users.length()-1);
            heightFeet=jo.getString(FEET);
            heightInch=jo.getString(INCH);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
