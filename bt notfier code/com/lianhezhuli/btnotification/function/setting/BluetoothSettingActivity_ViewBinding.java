/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.setting.BluetoothSettingActivity
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.setting;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.setting.BluetoothSettingActivity;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class BluetoothSettingActivity_ViewBinding
implements Unbinder {
    private BluetoothSettingActivity target;
    private View view7f090060;
    private View view7f090155;

    public BluetoothSettingActivity_ViewBinding(BluetoothSettingActivity bluetoothSettingActivity) {
        this(bluetoothSettingActivity, bluetoothSettingActivity.getWindow().getDecorView());
    }

    public BluetoothSettingActivity_ViewBinding(BluetoothSettingActivity bluetoothSettingActivity, View view) {
        View view2;
        this.target = bluetoothSettingActivity;
        bluetoothSettingActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296353, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        this.view7f090060 = view2 = Utils.findRequiredView((View)view, (int)2131296352, (String)"method 'onClick'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090155 = view = Utils.findRequiredView((View)view, (int)2131296597, (String)"method 'onClick'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        BluetoothSettingActivity bluetoothSettingActivity = this.target;
        if (bluetoothSettingActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        bluetoothSettingActivity.mTopBar = null;
        this.view7f090060.setOnClickListener(null);
        this.view7f090060 = null;
        this.view7f090155.setOnClickListener(null);
        this.view7f090155 = null;
    }
}
