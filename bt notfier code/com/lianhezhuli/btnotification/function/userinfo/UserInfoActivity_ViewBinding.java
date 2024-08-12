/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity
 *  com.qmuiteam.qmui.widget.QMUIRadiusImageView
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.userinfo;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.userinfo.UserInfoActivity;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class UserInfoActivity_ViewBinding
implements Unbinder {
    private UserInfoActivity target;
    private View view7f090271;
    private View view7f090279;
    private View view7f09027c;
    private View view7f09027d;
    private View view7f09027f;
    private View view7f090281;

    public UserInfoActivity_ViewBinding(UserInfoActivity userInfoActivity) {
        this(userInfoActivity, userInfoActivity.getWindow().getDecorView());
    }

    public UserInfoActivity_ViewBinding(UserInfoActivity userInfoActivity, View view) {
        View view2;
        this.target = userInfoActivity;
        userInfoActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296899, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        userInfoActivity.mHeadImg = (QMUIRadiusImageView)Utils.findRequiredViewAsType((View)view, (int)2131296891, (String)"field 'mHeadImg'", QMUIRadiusImageView.class);
        userInfoActivity.mNicknameTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296896, (String)"field 'mNicknameTv'", TextView.class);
        userInfoActivity.mSexTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296898, (String)"field 'mSexTv'", TextView.class);
        userInfoActivity.mBirthTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296890, (String)"field 'mBirthTv'", TextView.class);
        userInfoActivity.mHeightTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296894, (String)"field 'mHeightTv'", TextView.class);
        userInfoActivity.mWeightTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296882, (String)"field 'mWeightTv'", TextView.class);
        this.view7f09027c = view2 = Utils.findRequiredView((View)view, (int)2131296892, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f09027f = view2 = Utils.findRequiredView((View)view, (int)2131296895, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090281 = view2 = Utils.findRequiredView((View)view, (int)2131296897, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090279 = view2 = Utils.findRequiredView((View)view, (int)2131296889, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f09027d = view2 = Utils.findRequiredView((View)view, (int)2131296893, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090271 = view = Utils.findRequiredView((View)view, (int)2131296881, (String)"method 'click'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        UserInfoActivity userInfoActivity = this.target;
        if (userInfoActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        userInfoActivity.mTopBar = null;
        userInfoActivity.mHeadImg = null;
        userInfoActivity.mNicknameTv = null;
        userInfoActivity.mSexTv = null;
        userInfoActivity.mBirthTv = null;
        userInfoActivity.mHeightTv = null;
        userInfoActivity.mWeightTv = null;
        this.view7f09027c.setOnClickListener(null);
        this.view7f09027c = null;
        this.view7f09027f.setOnClickListener(null);
        this.view7f09027f = null;
        this.view7f090281.setOnClickListener(null);
        this.view7f090281 = null;
        this.view7f090279.setOnClickListener(null);
        this.view7f090279 = null;
        this.view7f09027d.setOnClickListener(null);
        this.view7f09027d = null;
        this.view7f090271.setOnClickListener(null);
        this.view7f090271 = null;
    }
}
