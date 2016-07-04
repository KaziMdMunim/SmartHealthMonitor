package com.example.kazimdmunim.smarthealthmonitor;

/**
 * Created by Kazi on 21-Apr-16.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] bpTop;
    public static String[] bpBottom;
    public static String[] date;

    public static final String JSON_ARRAY = "result";
    public static final String TOP = "top";
    public static final String BOTTOM = "btm";
    public static final String DATE = "date";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);
            Config.len=users.length();
            bpTop = new String[users.length()];
            bpBottom = new String[users.length()];
            date = new String[users.length()];

            int start = 0;
            if(users.length()>9){
                start=users.length()-9;
                Config.len=9;
            }

            int j=0;
            for(int i=start;i<users.length();i++,j++){
                JSONObject jo = users.getJSONObject(i);
                Config.bpt[j] = Long.parseLong(jo.getString(TOP));
                Config.bpb[j] = Long.parseLong(jo.getString(BOTTOM));
                Config.dte[j] = Long.parseLong(jo.getString(DATE));
//                bpTop[i] = jo.getString(TOP);
//                bpBottom[i] = jo.getString(BOTTOM);
//                date[i] = jo.getString(DATE);
            }
            if(users.length()>2){
                float a = (float)(Config.bpt[j-1]+Config.bpt[j-2]+Config.bpt[j-3])/3;
                float b = (float)(Config.bpb[j-1]+Config.bpb[j-2]+Config.bpb[j-3])/3;
                Config.curBP=(a+b)/2;
            }
            else if(users.length()>1){
                float a = (float)(Config.bpt[j-1]+Config.bpt[j-2])/2;
                float b = (float)(Config.bpb[j-1]+Config.bpb[j-2])/2;
                Config.curBP=(a+b)/2;
            }
            else{
                float a = (float)(Config.bpt[j-1]);
                float b = (float)(Config.bpb[j-1]);
                Config.curBP=(a+b)/2;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}