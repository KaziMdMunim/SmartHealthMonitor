package com.example.kazimdmunim.smarthealthmonitor;

/**
 * Created by Kazi on 21-Apr-16.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSONSg {
    public static String[] sgLvl;
    public static String[] dateSg;

    public static final String JSON_ARRAY = "result";
    public static final String SG_LVL = "sugar_level";
    public static final String DATE = "date_sg";

    private JSONArray users = null;

    private String json;

    public ParseJSONSg(String json){
        this.json = json;
    }

    protected void parseJSONSg(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);
            Config.lenSg=users.length();
            sgLvl = new String[users.length()];
            dateSg = new String[users.length()];

            int start = 0;
            if(users.length()>9){
                start=users.length()-9;
                Config.lenSg=9;
            }

            int j=0;
            for(int i=start;i<users.length();i++,j++){
                JSONObject jo = users.getJSONObject(i);
                Config.sugarLvl[j] = Float.parseFloat(jo.getString(SG_LVL));
                Config.dteSg[j] =  Long.parseLong(jo.getString(DATE));
//                sgLvl[i] = jo.getString(SG_LVL);
//                dateSg[i] = jo.getString(DATE);
            }
            if(users.length()>1){
                Config.curSUGAR=(Config.sugarLvl[j-1]+Config.sugarLvl[j-2])/2;
            }
            else{
                Config.curSUGAR=Config.sugarLvl[j-1];
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}