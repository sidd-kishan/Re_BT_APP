/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.os.IBinder
 */
package androidx.core.app;

import android.content.ComponentName;
import android.os.IBinder;

private static class NotificationManagerCompat.ServiceConnectedEvent {
    final ComponentName componentName;
    final IBinder iBinder;

    NotificationManagerCompat.ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
        this.componentName = componentName;
        this.iBinder = iBinder;
    }
}
