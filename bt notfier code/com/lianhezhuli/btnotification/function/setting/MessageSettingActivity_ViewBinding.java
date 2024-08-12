/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.setting.MessageSettingActivity
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.setting;

import android.view.View;
import android.widget.CheckBox;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.setting.MessageSettingActivity;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class MessageSettingActivity_ViewBinding
implements Unbinder {
    private MessageSettingActivity target;
    private View view7f090174;
    private View view7f090175;
    private View view7f090177;

    public MessageSettingActivity_ViewBinding(MessageSettingActivity messageSettingActivity) {
        this(messageSettingActivity, messageSettingActivity.getWindow().getDecorView());
    }

    public MessageSettingActivity_ViewBinding(MessageSettingActivity messageSettingActivity, View view) {
        View view2;
        this.target = messageSettingActivity;
        messageSettingActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296593, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        messageSettingActivity.mSmsCb = (CheckBox)Utils.findRequiredViewAsType((View)view, (int)2131296630, (String)"field 'mSmsCb'", CheckBox.class);
        messageSettingActivity.mAlwaysSendCb = (CheckBox)Utils.findRequiredViewAsType((View)view, (int)2131296627, (String)"field 'mAlwaysSendCb'", CheckBox.class);
        this.view7f090175 = view2 = Utils.findRequiredView((View)view, (int)2131296629, (String)"method 'onClick'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090174 = view2 = Utils.findRequiredView((View)view, (int)2131296628, (String)"method 'onClick'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090177 = view = Utils.findRequiredView((View)view, (int)2131296631, (String)"method 'onClick'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        MessageSettingActivity messageSettingActivity = this.target;
        if (messageSettingActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        messageSettingActivity.mTopBar = null;
        messageSettingActivity.mSmsCb = null;
        messageSettingActivity.mAlwaysSendCb = null;
        this.view7f090175.setOnClickListener(null);
        this.view7f090175 = null;
        this.view7f090174.setOnClickListener(null);
        this.view7f090174 = null;
        this.view7f090177.setOnClickListener(null);
        this.view7f090177 = null;
    }
}
