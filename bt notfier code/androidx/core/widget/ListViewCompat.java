/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.ListView
 */
package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class ListViewCompat {
    private ListViewCompat() {
    }

    public static boolean canScrollList(ListView listView, int n) {
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(n);
        }
        int n2 = listView.getChildCount();
        boolean bl = false;
        boolean bl2 = false;
        if (n2 == 0) {
            return false;
        }
        int n3 = listView.getFirstVisiblePosition();
        if (n > 0) {
            n = listView.getChildAt(n2 - 1).getBottom();
            if (n3 + n2 >= listView.getCount()) {
                if (n <= listView.getHeight() - listView.getListPaddingBottom()) return bl2;
            }
            bl2 = true;
            return bl2;
        }
        n = listView.getChildAt(0).getTop();
        if (n3 <= 0) {
            bl2 = bl;
            if (n >= listView.getListPaddingTop()) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    public static void scrollListBy(ListView listView, int n) {
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(n);
        } else {
            int n2 = listView.getFirstVisiblePosition();
            if (n2 == -1) {
                return;
            }
            View view = listView.getChildAt(0);
            if (view == null) {
                return;
            }
            listView.setSelectionFromTop(n2, view.getTop() - n);
        }
    }
}
