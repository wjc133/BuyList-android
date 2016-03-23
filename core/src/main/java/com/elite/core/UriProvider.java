package com.elite.core;

/**
 * Create by wjc133
 * Date: 2016/1/6
 * Time: 22:17
 */
public class UriProvider {
    private static final String PROTOCOL_HEADER_HTTP = "http://";
    private static final String PROTOCOL_HEADER_HTTPS = "https://";
    public static String LIST_STICKY_SAVE;    //请求更新接口
    public static String LIST_STICKY_GET;   //获取命令接口
    public static String LIST_STICKY_UPDATE;   //上传位置接口
    //for test
    public static String WEATHER_GET;
    public static String CITY_INFO_GET;
    private static String DATA_HOST;
    private static String BAIDU_HOST;

    /**
     * 初始化
     *
     * @param dataHostIp
     * @param baiduHostIp 用于测试HttpVisitor功能是否正常
     */
    public static void init(String dataHostIp, String baiduHostIp) {
        DATA_HOST = PROTOCOL_HEADER_HTTP + dataHostIp;
        BAIDU_HOST = PROTOCOL_HEADER_HTTP + baiduHostIp;

        LIST_STICKY_SAVE = DATA_HOST + "/list/sticky";
        LIST_STICKY_GET = DATA_HOST + "/list/stickys";
        LIST_STICKY_UPDATE = DATA_HOST + "/list/uid/%d/sticky/%s";

        CITY_INFO_GET = BAIDU_HOST + "/apistore/weatherservice/citylist";
        WEATHER_GET = BAIDU_HOST + "/apistore/weatherservice/cityname";
    }

    public static String getListStickyUpdate(long uid, String stickyId) {
        return String.format(LIST_STICKY_UPDATE, uid, stickyId);
    }
}
