/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.IBinder
 *  android.support.customtabs.IPostMessageService$Stub
 */
package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.customtabs.IPostMessageService;

public class PostMessageService
extends Service {
    private IPostMessageService.Stub mBinder = new /* Unavailable Anonymous Inner Class!! */;

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
