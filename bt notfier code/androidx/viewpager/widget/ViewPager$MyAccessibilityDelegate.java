/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager
 */
package androidx.viewpager.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

class ViewPager.MyAccessibilityDelegate
extends AccessibilityDelegateCompat {
    final ViewPager this$0;

    ViewPager.MyAccessibilityDelegate(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    private boolean canScroll() {
        PagerAdapter pagerAdapter = this.this$0.mAdapter;
        boolean bl = true;
        if (pagerAdapter != null && this.this$0.mAdapter.getCount() > 1) return bl;
        bl = false;
        return bl;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ViewPager.class.getName());
        accessibilityEvent.setScrollable(this.canScroll());
        if (accessibilityEvent.getEventType() != 4096) return;
        if (this.this$0.mAdapter == null) return;
        accessibilityEvent.setItemCount(this.this$0.mAdapter.getCount());
        accessibilityEvent.setFromIndex(this.this$0.mCurItem);
        accessibilityEvent.setToIndex(this.this$0.mCurItem);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName((CharSequence)ViewPager.class.getName());
        accessibilityNodeInfoCompat.setScrollable(this.canScroll());
        if (this.this$0.canScrollHorizontally(1)) {
            accessibilityNodeInfoCompat.addAction(4096);
        }
        if (!this.this$0.canScrollHorizontally(-1)) return;
        accessibilityNodeInfoCompat.addAction(8192);
    }

    public boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        if (super.performAccessibilityAction(view, n, bundle)) {
            return true;
        }
        if (n == 4096) {
            if (!this.this$0.canScrollHorizontally(1)) return false;
            view = this.this$0;
            view.setCurrentItem(view.mCurItem + 1);
            return true;
        }
        if (n != 8192) {
            return false;
        }
        if (!this.this$0.canScrollHorizontally(-1)) return false;
        view = this.this$0;
        view.setCurrentItem(view.mCurItem - 1);
        return true;
    }
}
