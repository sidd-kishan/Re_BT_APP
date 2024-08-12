/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.core.app.ActivityCompat
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 */
package com.lianhezhuli.btnotification;

import android.content.Context;
import androidx.core.app.ActivityCompat;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.mtk.service.MainService;

/*
 * Exception performing whole class analysis ignored.
 */
class MApplication.1
implements Runnable {
    final MApplication this$0;

    MApplication.1(MApplication mApplication) {
        this.this$0 = mApplication;
    }

    @Override
    public void run() {
        if (ActivityCompat.checkSelfPermission((Context)this.this$0.getApplicationContext(), (String)"android.permission.BLUETOOTH_CONNECT") == 0) {
            MainService.getInstance();
        } else {
            MApplication.access$100((MApplication)this.this$0).removeCallbacks(MApplication.access$000((MApplication)this.this$0));
            MApplication.access$100((MApplication)this.this$0).postDelayed(MApplication.access$000((MApplication)this.this$0), 5000L);
        }
    }
}
