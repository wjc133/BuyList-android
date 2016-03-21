package com.elite.core.base;

import com.elite.core.weather.api.WeatherCore;
import com.elite.core.weather.api.WeatherCoreImpl;

/**
 * Create by wjc133
 * Date: 2015/12/30
 * Time: 20:52
 */
public class CoreRegisterCenter {
    public static void registerCore() {
        if (!CoreFactory.hasRegisteredCoreClass(WeatherCore.class)) {
            CoreFactory.registerCoreClass(WeatherCore.class, WeatherCoreImpl.class);
        }
    }
}
