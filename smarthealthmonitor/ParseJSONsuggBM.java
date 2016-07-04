package com.example.kazimdmunim.smarthealthmonitor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kazi on 30-Apr-16.
 */
public class ParseJSONsuggBM {
    public static final String JSON_ARRAY = "result";
    public static final String HIGH = "hi";
    public static final String LOW = "lo";
    public static final String STATUS = "st";
    public static final String STATUSBN = "stbn";
    public static final String SUGG = "sg";
    public static final String SUGGBN = "sgbn";

    private JSONArray users = null;

    private String json;

    public ParseJSONsuggBM(String json){
        this.json = json;
    }

    protected void parseJSONsuggBM(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                Config.highBM = Float.parseFloat(jo.getString(HIGH));
                Config.lowBM = Float.parseFloat(jo.getString(LOW));
                Config.statusBM = jo.getString(STATUS);
                Config.statusBMbn = jo.getString(STATUSBN);
                Config.suggBM = jo.getString(SUGG);
                Config.suggBMbn = jo.getString(SUGGBN);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
