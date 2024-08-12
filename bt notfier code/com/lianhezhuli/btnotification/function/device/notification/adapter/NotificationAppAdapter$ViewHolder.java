/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 *  butterknife.BindView
 *  butterknife.ButterKnife
 *  com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter
 */
package com.lianhezhuli.btnotification.function.device.notification.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter;

class NotificationAppAdapter.ViewHolder {
    @BindView(value=2131296644)
    TextView mAppNameTv;
    @BindView(value=2131296641)
    ImageView mIconImg;
    @BindView(value=2131296642)
    CheckBox mIgnoreCb;
    final NotificationAppAdapter this$0;

    public NotificationAppAdapter.ViewHolder(NotificationAppAdapter notificationAppAdapter, View view) {
        this.this$0 = notificationAppAdapter;
        ButterKnife.bind((Object)this, (View)view);
    }
}
