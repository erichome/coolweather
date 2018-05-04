package com.example.eric.coolweather.util;

import android.text.TextUtils;

import com.example.eric.coolweather.db.City;
import com.example.eric.coolweather.db.County;
import com.example.eric.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by eric on 2018/5/4.
 */

public class Utility {
    /**
     * 解析和处理省局数据
     * @param reponse
     * @return
     */
    public static boolean handleProvinceResponse(String reponse){
        if(!TextUtils.isEmpty(reponse)){
            try {
                JSONArray provinces = new JSONArray(reponse);
                for(int i=0;i<provinces.length();i++){
                    JSONObject object = provinces.getJSONObject(i);
                    Province province = new Province();
                    province.setCode(object.getInt("id"));
                    province.setName(object.getString("name"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray cities = new JSONArray(response);
                for(int i=0;i<cities.length();i++){
                    JSONObject object = cities.getJSONObject(i);
                    City city = new City();
                    city.setCode(object.getInt("id"));
                    city.setName(object.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray counties = new JSONArray(response);
                for(int i=0;i<counties.length();i++){
                    JSONObject object = counties.getJSONObject(i);
                    County county = new County();
                    county.setWeatherId(object.getString("weacher_id"));
                    county.setName(object.getString("name"));
                    county.setCityId(cityId);
                    county.save();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
