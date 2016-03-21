package com.elite.core.weather.api;

import com.elite.core.base.BaseCore;
import com.elite.core.common.exception.CoreException;
import com.elite.findmyphone.api.weather.City;
import com.elite.findmyphone.api.weather.Weather;

import java.util.List;

/**
 * Created by wjc133.
 * Date: 2016/1/17
 * Time: 1:15
 * Description: 天气相关的业务接口
 */
public interface WeatherCore extends BaseCore {
    List<City> getCityInfo(String cityName) throws CoreException;

    Weather getWeather(String cityName);
}
