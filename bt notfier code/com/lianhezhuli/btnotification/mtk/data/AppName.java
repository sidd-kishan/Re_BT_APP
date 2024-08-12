/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.mtk.data;

public class AppName {
    private static final AppName INSTANCE = new AppName();
    private boolean FLAG = true;
    private String HOST_ID = "system_app";
    private String VIEW_ITEM_ACT_CODE = "com.android.camera.Camera";
    private String VIEW_ITEM_NAME_CODE = "com.android.camera";

    private AppName() {
    }

    public static AppName getInstance() {
        return INSTANCE;
    }

    public String getHOST_ID() {
        return this.HOST_ID;
    }

    public String getVIEW_ITEM_ACT_CODE() {
        return this.VIEW_ITEM_ACT_CODE;
    }

    public String getVIEW_ITEM_NAME_CODE() {
        return this.VIEW_ITEM_NAME_CODE;
    }

    public boolean isFLAG() {
        return this.FLAG;
    }

    public void setFLAG(boolean bl) {
        this.FLAG = bl;
    }

    public void setHOST_ID(String string) {
        this.HOST_ID = string;
    }

    public void setVIEW_ITEM_ACT_CODE(String string) {
        this.VIEW_ITEM_ACT_CODE = string;
    }

    public void setVIEW_ITEM_NAME_CODE(String string) {
        this.VIEW_ITEM_NAME_CODE = string;
    }
}
