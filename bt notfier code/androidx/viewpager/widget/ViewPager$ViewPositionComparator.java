/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.viewpager.widget.ViewPager$LayoutParams
 */
package androidx.viewpager.widget;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.Comparator;

static class ViewPager.ViewPositionComparator
implements Comparator<View> {
    ViewPager.ViewPositionComparator() {
    }

    @Override
    public int compare(View view, View view2) {
        view = (ViewPager.LayoutParams)view.getLayoutParams();
        view2 = (ViewPager.LayoutParams)view2.getLayoutParams();
        if (view.isDecor == view2.isDecor) return view.position - view2.position;
        int n = view.isDecor ? 1 : -1;
        return n;
    }
}
