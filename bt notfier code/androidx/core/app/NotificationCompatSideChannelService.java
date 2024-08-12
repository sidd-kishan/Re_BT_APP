/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  androidx.core.app.NotificationCompatSideChannelService$NotificationSideChannelStub
 */
package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompatSideChannelService;

public abstract class NotificationCompatSideChannelService
extends Service {
    public abstract void cancel(String var1, int var2, String var3);

    public abstract void cancelAll(String var1);

    void checkPermission(int n, String object) {
        Object object2 = this.getPackageManager().getPackagesForUid(n);
        int n2 = ((String[])object2).length;
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("NotificationSideChannelService: Uid ");
                ((StringBuilder)object2).append(n);
                ((StringBuilder)object2).append(" is not authorized for package ");
                ((StringBuilder)object2).append((String)object);
                object = new SecurityException(((StringBuilder)object2).toString());
                throw object;
            }
            if (object2[n3].equals(object)) {
                return;
            }
            ++n3;
        }
    }

    public abstract void notify(String var1, int var2, String var3, Notification var4);

    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")) return null;
        if (Build.VERSION.SDK_INT <= 19) return new NotificationSideChannelStub(this);
        return null;
    }
}
