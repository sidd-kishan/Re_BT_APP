/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  com.lianhezhuli.btnotification.function.device.notification.NotificationAppActivity
 *  io.reactivex.functions.Consumer
 */
package com.lianhezhuli.btnotification.function.device.notification;

import android.content.pm.PackageInfo;
import com.lianhezhuli.btnotification.function.device.notification.NotificationAppActivity;
import io.reactivex.functions.Consumer;
import java.util.HashSet;

public final class _$$Lambda$NotificationAppActivity$GFucjXVM5_5Vli3Gcb5lULnpST0
implements Consumer {
    private final NotificationAppActivity f$0;
    private final HashSet f$1;
    private final HashSet f$2;

    public /* synthetic */ _$$Lambda$NotificationAppActivity$GFucjXVM5_5Vli3Gcb5lULnpST0(NotificationAppActivity notificationAppActivity, HashSet hashSet, HashSet hashSet2) {
        this.f$0 = notificationAppActivity;
        this.f$1 = hashSet;
        this.f$2 = hashSet2;
    }

    public final void accept(Object object) {
        this.f$0.lambda$getAppList$1$NotificationAppActivity(this.f$1, this.f$2, (PackageInfo)object);
    }
}
