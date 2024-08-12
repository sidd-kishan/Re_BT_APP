/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.device.FindDeviceActivity
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.device;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.device.FindDeviceActivity;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class FindDeviceActivity_ViewBinding
implements Unbinder {
    private FindDeviceActivity target;
    private View view7f0900ea;

    public FindDeviceActivity_ViewBinding(FindDeviceActivity findDeviceActivity) {
        this(findDeviceActivity, findDeviceActivity.getWindow().getDecorView());
    }

    public FindDeviceActivity_ViewBinding(FindDeviceActivity findDeviceActivity, View view) {
        this.target = findDeviceActivity;
        findDeviceActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296491, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        this.view7f0900ea = view = Utils.findRequiredView((View)view, (int)2131296490, (String)"method 'onClick'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        FindDeviceActivity findDeviceActivity = this.target;
        if (findDeviceActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        findDeviceActivity.mTopBar = null;
        this.view7f0900ea.setOnClickListener(null);
        this.view7f0900ea = null;
    }
}
