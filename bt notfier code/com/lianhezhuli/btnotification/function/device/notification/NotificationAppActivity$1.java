/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.viewpager.widget.PagerAdapter
 *  com.lianhezhuli.btnotification.function.device.notification.NotificationAppActivity
 */
package com.lianhezhuli.btnotification.function.device.notification;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.lianhezhuli.btnotification.function.device.notification.NotificationAppActivity;

/*
 * Exception performing whole class analysis ignored.
 */
class NotificationAppActivity.1
extends PagerAdapter {
    final NotificationAppActivity this$0;

    NotificationAppActivity.1(NotificationAppActivity notificationAppActivity) {
        this.this$0 = notificationAppActivity;
    }

    public void destroyItem(ViewGroup viewGroup, int n, Object object) {
        viewGroup.removeView((View)object);
    }

    public int getCount() {
        return NotificationAppActivity.access$000((NotificationAppActivity)this.this$0).size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int n) {
        View view = (View)NotificationAppActivity.access$000((NotificationAppActivity)this.this$0).get(n);
        viewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl = view == object;
        return bl;
    }
}
