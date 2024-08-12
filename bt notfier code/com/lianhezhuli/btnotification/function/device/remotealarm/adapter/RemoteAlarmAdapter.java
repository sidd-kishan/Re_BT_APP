/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.lianhezhuli.btnotification.base.adapter.BaseRecyclerAdapter
 *  com.lianhezhuli.btnotification.bean.RemoteAlarmBean
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter$OnButtonClickListener
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter$ViewHolder
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter._$$Lambda$RemoteAlarmAdapter$_8w4oVw072w1VxRVeWv2WVdil2o
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter._$$Lambda$RemoteAlarmAdapter$egqNteU2KsQZQG4Dr_TzbJu_ubc
 *  com.lianhezhuli.btnotification.utils.AlarmRepeatUtils
 */
package com.lianhezhuli.btnotification.function.device.remotealarm.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.lianhezhuli.btnotification.base.adapter.BaseRecyclerAdapter;
import com.lianhezhuli.btnotification.bean.RemoteAlarmBean;
import com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter;
import com.lianhezhuli.btnotification.function.device.remotealarm.adapter._$;
import com.lianhezhuli.btnotification.utils.AlarmRepeatUtils;

public class RemoteAlarmAdapter
extends BaseRecyclerAdapter<RemoteAlarmBean> {
    private OnButtonClickListener mListener;

    public RemoteAlarmAdapter(Context context) {
        super(context);
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$RemoteAlarmAdapter(int n, ViewHolder viewHolder, View view) {
        view = this.mListener;
        if (view != null) {
            view.switchCheckChange(n, viewHolder.mSwitchCb.isChecked());
        }
        viewHolder.mSwitchCb.setChecked(viewHolder.mSwitchCb.isChecked() ^ true);
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$RemoteAlarmAdapter(int n, View view) {
        view = this.mListener;
        if (view == null) return;
        view.edit(n);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        super.onBindViewHolder(viewHolder, n);
        viewHolder = (ViewHolder)viewHolder;
        RemoteAlarmBean remoteAlarmBean = (RemoteAlarmBean)this.mList.get(n);
        viewHolder.mTimeTv.setText((CharSequence)remoteAlarmBean.getTime());
        viewHolder.mRepeatTv.setText((CharSequence)AlarmRepeatUtils.getRepeatStr((int)remoteAlarmBean.getRepeat()));
        viewHolder.mSwitchCb.setChecked(remoteAlarmBean.getOn().equals("1"));
        viewHolder.mSwitchCb.setOnClickListener((View.OnClickListener)new _$.Lambda.RemoteAlarmAdapter._8w4oVw072w1VxRVeWv2WVdil2o(this, n, (ViewHolder)viewHolder));
        viewHolder.mEditClickRl.setOnClickListener((View.OnClickListener)new _$.Lambda.RemoteAlarmAdapter.egqNteU2KsQZQG4Dr_TzbJu_ubc(this, n));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new ViewHolder(this, this.createView(viewGroup, 2131492931));
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.mListener = onButtonClickListener;
    }
}
