/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter$ViewHolder
 */
package com.lianhezhuli.btnotification.function.device.remotealarm.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.device.remotealarm.adapter.RemoteAlarmAdapter;

public class RemoteAlarmAdapter$ViewHolder_ViewBinding
implements Unbinder {
    private RemoteAlarmAdapter.ViewHolder target;

    public RemoteAlarmAdapter$ViewHolder_ViewBinding(RemoteAlarmAdapter.ViewHolder viewHolder, View view) {
        this.target = viewHolder;
        viewHolder.mTimeTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296703, (String)"field 'mTimeTv'", TextView.class);
        viewHolder.mRepeatTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296701, (String)"field 'mRepeatTv'", TextView.class);
        viewHolder.mSwitchCb = (CheckBox)Utils.findRequiredViewAsType((View)view, (int)2131296698, (String)"field 'mSwitchCb'", CheckBox.class);
        viewHolder.mEditClickRl = (RelativeLayout)Utils.findRequiredViewAsType((View)view, (int)2131296699, (String)"field 'mEditClickRl'", RelativeLayout.class);
    }

    public void unbind() {
        RemoteAlarmAdapter.ViewHolder viewHolder = this.target;
        if (viewHolder == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        viewHolder.mTimeTv = null;
        viewHolder.mRepeatTv = null;
        viewHolder.mSwitchCb = null;
        viewHolder.mEditClickRl = null;
    }
}
