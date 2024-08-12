/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 */
package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.Comparator;

static class CoordinatorLayout.ViewElevationComparator
implements Comparator<View> {
    CoordinatorLayout.ViewElevationComparator() {
    }

    @Override
    public int compare(View view, View view2) {
        float f;
        float f2 = ViewCompat.getZ((View)view);
        if (f2 > (f = ViewCompat.getZ((View)view2))) {
            return -1;
        }
        if (!(f2 < f)) return 0;
        return 1;
    }
}
