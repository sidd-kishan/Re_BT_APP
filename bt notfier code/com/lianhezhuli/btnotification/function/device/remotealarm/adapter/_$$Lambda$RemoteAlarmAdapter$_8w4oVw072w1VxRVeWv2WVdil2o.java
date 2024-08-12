/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter$ViewHolder
 */
package com.lianhezhuli.btnotification.function.device.remotealarm.adapter;

import android.view.View;
import com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter;

public final class _$$Lambda$RemoteAlarmAdapter$_8w4oVw072w1VxRVeWv2WVdil2o
implements View.OnClickListener {
    private final RemoteAlarmAdapter f$0;
    private final int f$1;
    private final RemoteAlarmAdapter.ViewHolder f$2;

    public /* synthetic */ _$$Lambda$RemoteAlarmAdapter$_8w4oVw072w1VxRVeWv2WVdil2o(RemoteAlarmAdapter remoteAlarmAdapter, int n, RemoteAlarmAdapter.ViewHolder viewHolder) {
        this.f$0 = remoteAlarmAdapter;
        this.f$1 = n;
        this.f$2 = viewHolder;
    }

    public final void onClick(View view) {
        this.f$0.lambda$onBindViewHolder$0$RemoteAlarmAdapter(this.f$1, this.f$2, view);
    }
}
