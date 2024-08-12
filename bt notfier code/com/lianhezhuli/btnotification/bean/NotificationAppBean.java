/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package com.lianhezhuli.btnotification.bean;

import android.graphics.drawable.Drawable;

public class NotificationAppBean {
    private String appName;
    private Drawable icon;
    private boolean isSelect;
    private String packageName;

    public String getAppName() {
        return this.appName;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setAppName(String string) {
        this.appName = string;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setPackageName(String string) {
        this.packageName = string;
    }

    public void setSelect(boolean bl) {
        this.isSelect = bl;
    }
}
