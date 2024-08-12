/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmActivity
 *  com.lianhezhuli.btnotification.view.SwipeRecycler
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.device.remotealarm;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.device.remotealarm.RemoteAlarmActivity;
import com.lianhezhuli.btnotification.view.SwipeRecycler;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class RemoteAlarmActivity_ViewBinding
implements Unbinder {
    private RemoteAlarmActivity target;

    public RemoteAlarmActivity_ViewBinding(RemoteAlarmActivity remoteAlarmActivity) {
        this(remoteAlarmActivity, remoteAlarmActivity.getWindow().getDecorView());
    }

    public RemoteAlarmActivity_ViewBinding(RemoteAlarmActivity remoteAlarmActivity, View view) {
        this.target = remoteAlarmActivity;
        remoteAlarmActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296702, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        remoteAlarmActivity.mRecycler = (SwipeRecycler)Utils.findRequiredViewAsType((View)view, (int)2131296700, (String)"field 'mRecycler'", SwipeRecycler.class);
    }

    public void unbind() {
        RemoteAlarmActivity remoteAlarmActivity = this.target;
        if (remoteAlarmActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        remoteAlarmActivity.mTopBar = null;
        remoteAlarmActivity.mRecycler = null;
    }
}
