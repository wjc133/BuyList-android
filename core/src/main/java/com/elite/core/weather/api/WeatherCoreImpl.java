package com.elite.core.weather.api;


import com.elite.core.ApiCore;
import com.elite.core.UriProvider;
import com.elite.core.common.exception.CoreException;
import com.elite.core.utils.HttpUtils;
import com.elite.findmyphone.api.ServerResult;
import com.elite.findmyphone.api.weather.City;
import com.elite.findmyphone.api.weather.Weather;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by wjc133.
 * Date: 2016/1/17
 * Time: 1:29
 * Description:
 */
public class WeatherCoreImpl extends ApiCore implements WeatherCore {
    @SuppressWarnings("unchecked")
    @Override
    public List<City> getCityInfo(String cityName) throws CoreException {
        String url = UriProvider.CITY_INFO_GET;
        Map<String, String> params = Maps.newHashMap();
        params.put("cityname", cityName);
        Map<String, String> headers = Maps.newHashMap();
        headers.put("apikey", "e5cba1557b738ff5e717f7558850ae8f");
        Type typeOfResult = new TypeToken<ServerResult<List<City>>>() {
        }.getType();
        return HttpUtils.INSTANCE.getSync(url, params, headers, typeOfResult);
    }

    @Override
    public Weather getWeather(String cityName) {
        return null;
    }
}
