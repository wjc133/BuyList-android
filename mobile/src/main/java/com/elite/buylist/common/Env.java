package com.elite.buylist.common;


import com.elite.buylist.R;
import com.elite.buylist.constant.EnvType;
import com.elite.core.utils.BasicConfig;
import com.elite.core.utils.pref.CommonPref;

/**
 * Create by wjc133
 * Date: 2016/1/6
 * Time: 22:36
 * 环境配置类
 */
public class Env {
    public static final String PREF_URI_SETTING = "PREF_URI_SETTING";

    private static final Env mEnv = new Env();

    private Env() {
    }

    public static Env instance() {
        return mEnv;
    }

    public void init() {
        if (!isReleaseEnv()) {
            UriManager.init(getEnvType(), BasicConfig.INSTANCE.getAppContext());
        } else {
            UriManager.init(EnvType.PRODUCT, BasicConfig.INSTANCE.getAppContext());
        }
    }

    /**
     * 设置uri环境
     *
     * @param envType
     */
    public void setEnvType(EnvType envType) {
        if (envType != null && !isReleaseEnv()) {
            CommonPref.instance(BasicConfig.INSTANCE.getAppContext()).putInt(PREF_URI_SETTING, envType.code());
            UriManager.init(envType, BasicConfig.INSTANCE.getAppContext());
        }
    }

    /**
     * 取uri环境
     *
     * @return
     */
    public EnvType getEnvType() {
        if (isReleaseEnv()) {
            return EnvType.PRODUCT;
        }

        byte code = (byte) CommonPref.instance(BasicConfig.INSTANCE.getAppContext()).getInt(PREF_URI_SETTING, EnvType.UNKNOWN.code());
        if (code != EnvType.UNKNOWN.code()) {
            return EnvType.valueOf(code);
        } else {
            if (getBuildEnv() == EnvType.DEV) {
                return EnvType.DEV;
            }

            return EnvType.TEST;
        }
    }

    public static boolean isReleaseEnv() {
        return getBuildEnv() == EnvType.PRODUCT;
    }

    public static EnvType getBuildEnv() {
        EnvType env = EnvType.PRODUCT;
        String mvnEnv = BasicConfig.INSTANCE.getAppContext().getString(R.string.current_env);
        switch (mvnEnv) {
            case "dev":
                env = EnvType.DEV;
                break;
            case "test":
                env = EnvType.TEST;
                break;
            case "release":
                env = EnvType.PRODUCT;
                break;
            default:
                break;
        }

        return env;
    }
}
