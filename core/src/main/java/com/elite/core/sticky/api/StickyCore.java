package com.elite.core.sticky.api;

import com.elite.core.base.BaseCore;
import com.elite.findmyphone.api.sticky.Sticky;
import com.elite.findmyphone.api.sticky.StickyCommand;

import java.util.List;

/**
 * Created by wjc133.
 * Date: 2016/3/22
 * Time: 23:48
 * Description:
 */
public interface StickyCore extends BaseCore {
    Sticky storeSticky(StickyCommand stickyCommand);

    List<Sticky> getStickys(String ticket, Integer limit, Integer offset);
}
