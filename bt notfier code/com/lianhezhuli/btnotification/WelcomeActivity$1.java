/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.core.app.ActivityCompat
 *  com.lianhezhuli.btnotification.WelcomeActivity
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 */
package com.lianhezhuli.btnotification;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.ActivityCompat;
import com.lianhezhuli.btnotification.WelcomeActivity;
import com.lianhezhuli.btnotification.mtk.service.MainService;

/*
 * Exception performing whole class analysis ignored.
 */
class WelcomeActivity.1
implements Runnable {
    final WelcomeActivity this$0;

    WelcomeActivity.1(WelcomeActivity welcomeActivity) {
        this.this$0 = welcomeActivity;
    }

    @Override
    public void run() {
        if (ActivityCompat.checkSelfPermission((Context)this.this$0.getApplicationContext(), (String)"android.permission.BLUETOOTH_CONNECT") == 0) {
            this.this$0.startService(new Intent((Context)this.this$0, MainService.class));
        } else {
            WelcomeActivity.access$100((WelcomeActivity)this.this$0).removeCallbacks(WelcomeActivity.access$000((WelcomeActivity)this.this$0));
            WelcomeActivity.access$100((WelcomeActivity)this.this$0).postDelayed(WelcomeActivity.access$000((WelcomeActivity)this.this$0), 5000L);
        }
    }
}
