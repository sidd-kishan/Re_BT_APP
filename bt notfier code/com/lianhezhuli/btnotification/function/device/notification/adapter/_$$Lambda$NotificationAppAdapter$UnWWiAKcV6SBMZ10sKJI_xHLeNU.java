/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter
 *  com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter$ViewHolder
 */
package com.lianhezhuli.btnotification.function.device.notification.adapter;

import android.view.View;
import com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter;

public final class _$$Lambda$NotificationAppAdapter$UnWWiAKcV6SBMZ10sKJI_xHLeNU
implements View.OnClickListener {
    private final NotificationAppAdapter f$0;
    private final int f$1;
    private final NotificationAppAdapter.ViewHolder f$2;

    public /* synthetic */ _$$Lambda$NotificationAppAdapter$UnWWiAKcV6SBMZ10sKJI_xHLeNU(NotificationAppAdapter notificationAppAdapter, int n, NotificationAppAdapter.ViewHolder viewHolder) {
        this.f$0 = notificationAppAdapter;
        this.f$1 = n;
        this.f$2 = viewHolder;
    }

    public final void onClick(View view) {
        this.f$0.lambda$getView$0$NotificationAppAdapter(this.f$1, this.f$2, view);
    }
}
