/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter
 */
package com.lianhezhuli.btnotification.function.device.remotealarm.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter;

public class RemoteAlarmAdapter.ViewHolder
extends RecyclerView.ViewHolder {
    @BindView(value=2131296699)
    RelativeLayout mEditClickRl;
    @BindView(value=2131296701)
    TextView mRepeatTv;
    @BindView(value=2131296698)
    CheckBox mSwitchCb;
    @BindView(value=2131296703)
    TextView mTimeTv;
    final RemoteAlarmAdapter this$0;

    public RemoteAlarmAdapter.ViewHolder(RemoteAlarmAdapter remoteAlarmAdapter, View view) {
        this.this$0 = remoteAlarmAdapter;
        super(view);
        ButterKnife.bind((Object)((Object)this), (View)view);
    }
}
