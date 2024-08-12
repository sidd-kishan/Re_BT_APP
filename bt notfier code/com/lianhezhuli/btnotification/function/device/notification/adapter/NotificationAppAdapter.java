/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  com.lianhezhuli.btnotification.bean.NotificationAppBean
 *  com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter$OnButtonClickListener
 *  com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter$ViewHolder
 *  com.lianhezhuli.btnotification.function.device.notification.adapter._$$Lambda$NotificationAppAdapter$UnWWiAKcV6SBMZ10sKJI_xHLeNU
 */
package com.lianhezhuli.btnotification.function.device.notification.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.lianhezhuli.btnotification.bean.NotificationAppBean;
import com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter;
import com.lianhezhuli.btnotification.function.device.notification.adapter._$;
import java.util.ArrayList;
import java.util.List;

public class NotificationAppAdapter
extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<NotificationAppBean> mList = new ArrayList<NotificationAppBean>();
    private OnButtonClickListener mListener;

    public NotificationAppAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from((Context)context);
    }

    public int getCount() {
        return this.mList.size();
    }

    public Object getItem(int n) {
        return this.mList.get(n);
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(2131492930, null);
            viewGroup = new ViewHolder(this, view);
            view.setTag((Object)viewGroup);
        } else {
            viewGroup = (ViewHolder)view.getTag();
        }
        NotificationAppBean notificationAppBean = this.mList.get(n);
        viewGroup.mIconImg.setImageDrawable(notificationAppBean.getIcon());
        viewGroup.mAppNameTv.setText((CharSequence)notificationAppBean.getAppName());
        viewGroup.mIgnoreCb.setChecked(notificationAppBean.isSelect());
        viewGroup.mIgnoreCb.setOnClickListener((View.OnClickListener)new _$.Lambda.NotificationAppAdapter.UnWWiAKcV6SBMZ10sKJI_xHLeNU(this, n, (ViewHolder)viewGroup));
        return view;
    }

    public /* synthetic */ void lambda$getView$0$NotificationAppAdapter(int n, ViewHolder viewHolder, View view) {
        view = this.mListener;
        if (view == null) return;
        view.switchCheckChange(n, viewHolder.mIgnoreCb.isChecked());
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.mListener = onButtonClickListener;
    }

    public void updateData(List<NotificationAppBean> list) {
        this.mList.clear();
        this.mList.addAll(list);
        this.notifyDataSetChanged();
    }
}
