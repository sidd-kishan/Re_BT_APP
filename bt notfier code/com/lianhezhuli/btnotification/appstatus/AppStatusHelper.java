/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.appstatus.AppStatusHelper$AppStatusListener
 */
package com.lianhezhuli.btnotification.appstatus;

import com.lianhezhuli.btnotification.appstatus.AppStatusHelper;
import java.util.HashSet;
import java.util.Iterator;

public class AppStatusHelper {
    private static AppStatusHelper instance = new AppStatusHelper();
    private HashSet<AppStatusListener> set = new HashSet();

    public static AppStatusHelper getInstance() {
        return instance;
    }

    public void notify(boolean bl) {
        Iterator<AppStatusListener> iterator = this.set.iterator();
        while (iterator.hasNext()) {
            iterator.next().onStatusChange(bl);
        }
    }

    public void registerAppStatusListener(AppStatusListener appStatusListener) {
        this.set.add(appStatusListener);
    }
}
