/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.viewpager.widget.ViewPager$ItemInfo
 */
package androidx.viewpager.widget;

import androidx.viewpager.widget.ViewPager;
import java.util.Comparator;

static final class ViewPager.1
implements Comparator<ViewPager.ItemInfo> {
    ViewPager.1() {
    }

    @Override
    public int compare(ViewPager.ItemInfo itemInfo, ViewPager.ItemInfo itemInfo2) {
        return itemInfo.position - itemInfo2.position;
    }
}
