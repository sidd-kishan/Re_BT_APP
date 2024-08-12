/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter$ViewHolder
 */
package com.lianhezhuli.btnotification.function.device.notification.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.device.notification.adapter.NotificationAppAdapter;

public class NotificationAppAdapter$ViewHolder_ViewBinding
implements Unbinder {
    private NotificationAppAdapter.ViewHolder target;

    public NotificationAppAdapter$ViewHolder_ViewBinding(NotificationAppAdapter.ViewHolder viewHolder, View view) {
        this.target = viewHolder;
        viewHolder.mIconImg = (ImageView)Utils.findRequiredViewAsType((View)view, (int)2131296641, (String)"field 'mIconImg'", ImageView.class);
        viewHolder.mAppNameTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296644, (String)"field 'mAppNameTv'", TextView.class);
        viewHolder.mIgnoreCb = (CheckBox)Utils.findRequiredViewAsType((View)view, (int)2131296642, (String)"field 'mIgnoreCb'", CheckBox.class);
    }

    public void unbind() {
        NotificationAppAdapter.ViewHolder viewHolder = this.target;
        if (viewHolder == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        viewHolder.mIconImg = null;
        viewHolder.mAppNameTv = null;
        viewHolder.mIgnoreCb = null;
    }
}
