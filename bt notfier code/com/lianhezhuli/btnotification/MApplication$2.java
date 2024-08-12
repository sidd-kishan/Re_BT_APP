/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.MApplication
 *  com.orhanobut.logger.AndroidLogAdapter
 *  com.orhanobut.logger.FormatStrategy
 */
package com.lianhezhuli.btnotification;

import com.lianhezhuli.btnotification.MApplication;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;

class MApplication.2
extends AndroidLogAdapter {
    final MApplication this$0;

    MApplication.2(MApplication mApplication, FormatStrategy formatStrategy) {
        this.this$0 = mApplication;
        super(formatStrategy);
    }

    public boolean isLoggable(int n, String string) {
        return false;
    }
}
