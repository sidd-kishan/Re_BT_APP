/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmTimeSettingActivity
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.device.remotealarm;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmTimeSettingActivity;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class RemoteAlarmTimeSettingActivity_ViewBinding
implements Unbinder {
    private RemoteAlarmTimeSettingActivity target;
    private View view7f090043;
    private View view7f090046;
    private View view7f090048;

    public RemoteAlarmTimeSettingActivity_ViewBinding(RemoteAlarmTimeSettingActivity remoteAlarmTimeSettingActivity) {
        this(remoteAlarmTimeSettingActivity, remoteAlarmTimeSettingActivity.getWindow().getDecorView());
    }

    public RemoteAlarmTimeSettingActivity_ViewBinding(RemoteAlarmTimeSettingActivity remoteAlarmTimeSettingActivity, View view) {
        View view2;
        this.target = remoteAlarmTimeSettingActivity;
        remoteAlarmTimeSettingActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296327, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        remoteAlarmTimeSettingActivity.mTimeSettingTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296329, (String)"field 'mTimeSettingTv'", TextView.class);
        remoteAlarmTimeSettingActivity.mAlarmRepeatTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296324, (String)"field 'mAlarmRepeatTv'", TextView.class);
        remoteAlarmTimeSettingActivity.mSwitchCb = (CheckBox)Utils.findRequiredViewAsType((View)view, (int)2131296325, (String)"field 'mSwitchCb'", CheckBox.class);
        this.view7f090048 = view2 = Utils.findRequiredView((View)view, (int)2131296328, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090043 = view2 = Utils.findRequiredView((View)view, (int)2131296323, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090046 = view = Utils.findRequiredView((View)view, (int)2131296326, (String)"method 'click'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        RemoteAlarmTimeSettingActivity remoteAlarmTimeSettingActivity = this.target;
        if (remoteAlarmTimeSettingActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        remoteAlarmTimeSettingActivity.mTopBar = null;
        remoteAlarmTimeSettingActivity.mTimeSettingTv = null;
        remoteAlarmTimeSettingActivity.mAlarmRepeatTv = null;
        remoteAlarmTimeSettingActivity.mSwitchCb = null;
        this.view7f090048.setOnClickListener(null);
        this.view7f090048 = null;
        this.view7f090043.setOnClickListener(null);
        this.view7f090043 = null;
        this.view7f090046.setOnClickListener(null);
        this.view7f090046 = null;
    }
}
