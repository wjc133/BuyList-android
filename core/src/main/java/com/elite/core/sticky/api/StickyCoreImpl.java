package com.elite.core.sticky.api;

import com.elite.core.ApiCore;
import com.elite.core.UriProvider;
import com.elite.findmyphone.api.sticky.Sticky;
import com.elite.findmyphone.api.sticky.StickyCommand;

import java.util.List;

/**
 * Created by wjc133.
 * Date: 2016/3/22
 * Time: 23:50
 * Description:
 */
public class StickyCoreImpl extends ApiCore implements StickyCore {
    @Override
    public Sticky store(StickyCommand stickyCommand) {
        String url = UriProvider.LIST_STICKY_SAVE;
        return null;
    }

    @Override
    public List<Sticky> getStickys(String ticket, Integer limit, Integer offset) {
        return null;
    }
}
