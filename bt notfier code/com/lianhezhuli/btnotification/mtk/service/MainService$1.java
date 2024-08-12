/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.lianhezhuli.btnotification.mtk.service.MainService;

/*
 * Exception performing whole class analysis ignored.
 */
class MainService.1
extends ContentObserver {
    final MainService this$0;

    MainService.1(MainService mainService, Handler handler) {
        this.this$0 = mainService;
        super(handler);
    }

    public void onChange(boolean bl) {
        if (MainService.access$000((MainService)this.this$0) != 0) return;
        this.this$0.sendReadMissedCallData();
    }
}
