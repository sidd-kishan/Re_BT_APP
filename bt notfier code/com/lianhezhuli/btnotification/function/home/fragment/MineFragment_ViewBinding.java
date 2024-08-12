/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.home.fragment.MineFragment
 *  com.qmuiteam.qmui.widget.QMUIRadiusImageView
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.home.fragment.MineFragment;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

public class MineFragment_ViewBinding
implements Unbinder {
    private MineFragment target;
    private View view7f090154;
    private View view7f090156;
    private View view7f090157;
    private View view7f09015c;
    private View view7f09015e;
    private View view7f090168;

    public MineFragment_ViewBinding(MineFragment mineFragment, View view) {
        View view2;
        this.target = mineFragment;
        mineFragment.mHeadView = Utils.findRequiredView((View)view, (int)2131296601, (String)"field 'mHeadView'");
        mineFragment.mHeadImg = (QMUIRadiusImageView)Utils.findRequiredViewAsType((View)view, (int)2131296600, (String)"field 'mHeadImg'", QMUIRadiusImageView.class);
        mineFragment.mNicknameTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296605, (String)"field 'mNicknameTv'", TextView.class);
        mineFragment.mHeightTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296603, (String)"field 'mHeightTv'", TextView.class);
        mineFragment.mWeightTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296617, (String)"field 'mWeightTv'", TextView.class);
        this.view7f090157 = view2 = Utils.findRequiredView((View)view, (int)2131296599, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f09015e = view2 = Utils.findRequiredView((View)view, (int)2131296606, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090156 = view2 = Utils.findRequiredView((View)view, (int)2131296598, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090154 = view2 = Utils.findRequiredView((View)view, (int)2131296596, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f090168 = view2 = Utils.findRequiredView((View)view, (int)2131296616, (String)"method 'click'");
        view2.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        this.view7f09015c = view = Utils.findRequiredView((View)view, (int)2131296604, (String)"method 'click'");
        view.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unbind() {
        MineFragment mineFragment = this.target;
        if (mineFragment == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        mineFragment.mHeadView = null;
        mineFragment.mHeadImg = null;
        mineFragment.mNicknameTv = null;
        mineFragment.mHeightTv = null;
        mineFragment.mWeightTv = null;
        this.view7f090157.setOnClickListener(null);
        this.view7f090157 = null;
        this.view7f09015e.setOnClickListener(null);
        this.view7f09015e = null;
        this.view7f090156.setOnClickListener(null);
        this.view7f090156 = null;
        this.view7f090154.setOnClickListener(null);
        this.view7f090154 = null;
        this.view7f090168.setOnClickListener(null);
        this.view7f090168 = null;
        this.view7f09015c.setOnClickListener(null);
        this.view7f09015c = null;
    }
}
