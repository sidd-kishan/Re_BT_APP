/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  androidx.viewpager.widget.ViewPager
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.home.fragment.SportFragment
 *  com.lianhezhuli.btnotification.view.SportProgressView
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.home.fragment.SportFragment;
import com.lianhezhuli.btnotification.view.SportProgressView;

public class SportFragment_ViewBinding
implements Unbinder {
    private SportFragment target;

    public SportFragment_ViewBinding(SportFragment sportFragment, View view) {
        this.target = sportFragment;
        sportFragment.mStatusView = Utils.findRequiredView((View)view, (int)2131296773, (String)"field 'mStatusView'");
        sportFragment.mDataVp = (ViewPager)Utils.findRequiredViewAsType((View)view, (int)2131296768, (String)"field 'mDataVp'", ViewPager.class);
        sportFragment.mIndicatorLl = (LinearLayout)Utils.findRequiredViewAsType((View)view, (int)2131296778, (String)"field 'mIndicatorLl'", LinearLayout.class);
        sportFragment.mStepNumTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296775, (String)"field 'mStepNumTv'", TextView.class);
        sportFragment.mTargetProgressTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296776, (String)"field 'mTargetProgressTv'", TextView.class);
        sportFragment.mDistanceTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296770, (String)"field 'mDistanceTv'", TextView.class);
        sportFragment.mCalorieTv = (TextView)Utils.findRequiredViewAsType((View)view, (int)2131296771, (String)"field 'mCalorieTv'", TextView.class);
        sportFragment.mRefreshLayout = (SwipeRefreshLayout)Utils.findRequiredViewAsType((View)view, (int)2131296772, (String)"field 'mRefreshLayout'", SwipeRefreshLayout.class);
        sportFragment.mProgressView = (SportProgressView)Utils.findRequiredViewAsType((View)view, (int)2131296777, (String)"field 'mProgressView'", SportProgressView.class);
    }

    public void unbind() {
        SportFragment sportFragment = this.target;
        if (sportFragment == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        sportFragment.mStatusView = null;
        sportFragment.mDataVp = null;
        sportFragment.mIndicatorLl = null;
        sportFragment.mStepNumTv = null;
        sportFragment.mTargetProgressTv = null;
        sportFragment.mDistanceTv = null;
        sportFragment.mCalorieTv = null;
        sportFragment.mRefreshLayout = null;
        sportFragment.mProgressView = null;
    }
}
