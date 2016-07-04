package com.example.kazimdmunim.smarthealthmonitor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kazi on 24-Apr-16.
 */
public class ParseJSONPl {
    public static String[] beats;
    public static String[] datePl;

    public static final String JSON_ARRAY = "result";
    public static final String BEATS = "beats";
    public static final String DATE = "date_pl";

    private JSONArray users = null;

    private String json;

    public ParseJSONPl(String json){
        this.json = json;
    }

    protected void parseJSONPl(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);
            Config.lenPl=users.length();
            beats = new String[users.length()];
            datePl = new String[users.length()];

            int start = 0;
            if(users.length()>9){
                start=users.length()-9;
                Config.lenPl=9;
            }

            int j=0;
            for(int i=start;i<users.length();i++,j++){
                JSONObject jo = users.getJSONObject(i);
                Config.beats[j] = Float.parseFloat(jo.getString(BEATS));
                Config.dtePl[j] = Long.parseLong(jo.getString(DATE));
//                beats[i] = jo.getString(BEATS);
//                datePl[i] = jo.getString(DATE);
            }

            if(users.length()>2){
                float a = (Config.beats[j-1]+Config.beats[j-2]+Config.beats[j-3])/3;
                Config.curPL=a;
            }
            else if(users.length()>1){
                float a = (Config.beats[j-1]+Config.beats[j-2])/2;
                Config.curPL=a;
            }
            else{
                float a = (Config.beats[j-1]);
                Config.curPL=a;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
