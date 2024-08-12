/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.viewpager.widget.ViewPager
 *  butterknife.Unbinder
 *  butterknife.internal.Utils
 *  com.lianhezhuli.btnotification.function.device.notification.NotificationAppActivity
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITopBarLayout
 */
package com.lianhezhuli.btnotification.function.device.notification;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lianhezhuli.btnotification.function.device.notification.NotificationAppActivity;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class NotificationAppActivity_ViewBinding
implements Unbinder {
    private NotificationAppActivity target;

    public NotificationAppActivity_ViewBinding(NotificationAppActivity notificationAppActivity) {
        this(notificationAppActivity, notificationAppActivity.getWindow().getDecorView());
    }

    public NotificationAppActivity_ViewBinding(NotificationAppActivity notificationAppActivity, View view) {
        this.target = notificationAppActivity;
        notificationAppActivity.mTopBar = (QMUITopBarLayout)Utils.findRequiredViewAsType((View)view, (int)2131296646, (String)"field 'mTopBar'", QMUITopBarLayout.class);
        notificationAppActivity.mViewPager = (ViewPager)Utils.findRequiredViewAsType((View)view, (int)2131296647, (String)"field 'mViewPager'", ViewPager.class);
        notificationAppActivity.mTabSegment = (QMUITabSegment)Utils.findRequiredViewAsType((View)view, (int)2131296645, (String)"field 'mTabSegment'", QMUITabSegment.class);
    }

    public void unbind() {
        NotificationAppActivity notificationAppActivity = this.target;
        if (notificationAppActivity == null) throw new IllegalStateException("Bindings already cleared.");
        this.target = null;
        notificationAppActivity.mTopBar = null;
        notificationAppActivity.mViewPager = null;
        notificationAppActivity.mTabSegment = null;
    }
}
