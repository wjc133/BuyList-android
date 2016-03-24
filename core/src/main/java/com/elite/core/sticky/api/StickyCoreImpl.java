package com.elite.core.sticky.api;

import com.elite.core.ApiCore;
import com.elite.core.UriProvider;
import com.elite.core.utils.HttpUtils;
import com.elite.findmyphone.api.sticky.Sticky;
import com.elite.findmyphone.api.sticky.StickyCommand;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by wjc133.
 * Date: 2016/3/22
 * Time: 23:50
 * Description:
 */
public class StickyCoreImpl extends ApiCore implements StickyCore {
    @Override
    public Sticky storeSticky(StickyCommand stickyCommand) {
        String url = UriProvider.getStickySaveUrl();
        return HttpUtils.INSTANCE.postSync(url, stickyCommand, Sticky.class);
    }

    @Override
    public List<Sticky> getStickys(String ticket, Integer limit, Integer offset) {
        String url = UriProvider.getStickyGetUrl();
        Map<String, String> params = Maps.newHashMap();
        params.put("ticket", ticket);
        params.put("limit", String.valueOf(limit));
        params.put("offset", String.valueOf(offset));
        Type type = new TypeToken<List<Sticky>>() {
        }.getType();
        return HttpUtils.INSTANCE.getSync(url, params, type);
    }
}
