package com.elite.core.sticky.loader;

import android.content.Context;

import com.elite.core.base.CoreManager;
import com.elite.core.common.exception.CoreException;
import com.elite.core.common.model.UIResponse;
import com.elite.core.loader.Data;
import com.elite.core.loader.UIResponseAsyncDataLoader;
import com.elite.core.sticky.api.StickyCore;
import com.elite.findmyphone.api.sticky.Sticky;

import java.util.List;

/**
 * Create by wjc133
 * Date: 2016/3/24
 * Time: 10:24
 */
public class StickyGetLoader extends UIResponseAsyncDataLoader<List<Sticky>> {
    private Integer limit;
    private Integer offset;
    private String ticket;

    public StickyGetLoader(Context context, String ticket, Integer limit, Integer offset) {
        super(context);
        this.ticket = ticket;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    protected Data<UIResponse<List<Sticky>>> loadInBackgroundSafety() throws CoreException {
        if (ticket == null) {
            return null;
        }
        return new Data<>(UIResponse.success(getCityInfo()));
    }

    private List<Sticky> getCityInfo() throws CoreException {
        return CoreManager.getCore(StickyCore.class).getStickys(ticket, limit, offset);
    }

}
