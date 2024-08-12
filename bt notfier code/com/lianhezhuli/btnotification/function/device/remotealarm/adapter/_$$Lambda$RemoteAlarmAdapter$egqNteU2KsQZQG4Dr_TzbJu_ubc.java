/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter
 */
package com.lianhezhuli.btnotification.function.device.remotealarm.adapter;

import android.view.View;
import com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter;

public final class _$$Lambda$RemoteAlarmAdapter$egqNteU2KsQZQG4Dr_TzbJu_ubc
implements View.OnClickListener {
    private final RemoteAlarmAdapter f$0;
    private final int f$1;

    public /* synthetic */ _$$Lambda$RemoteAlarmAdapter$egqNteU2KsQZQG4Dr_TzbJu_ubc(RemoteAlarmAdapter remoteAlarmAdapter, int n) {
        this.f$0 = remoteAlarmAdapter;
        this.f$1 = n;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$1$RemoteAlarmAdapter(this.f$1, view);
    }
}
