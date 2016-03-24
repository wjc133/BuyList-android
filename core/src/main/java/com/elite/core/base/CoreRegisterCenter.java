package com.elite.core.base;

import com.elite.core.sticky.api.StickyCore;
import com.elite.core.sticky.api.StickyCoreImpl;

/**
 * Create by wjc133
 * Date: 2015/12/30
 * Time: 20:52
 */
public class CoreRegisterCenter {
    public static void registerCore() {
        if (!CoreFactory.hasRegisteredCoreClass(StickyCore.class)) {
            CoreFactory.registerCoreClass(StickyCore.class, StickyCoreImpl.class);
        }
    }
}
