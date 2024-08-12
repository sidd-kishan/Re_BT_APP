/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.R$id
 *  androidx.recyclerview.widget.ItemTouchUIUtil
 *  androidx.recyclerview.widget.RecyclerView
 */
package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.ItemTouchUIUtil;
import androidx.recyclerview.widget.RecyclerView;

class ItemTouchUIUtilImpl
implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();

    ItemTouchUIUtilImpl() {
    }

    private static float findMaxElevation(RecyclerView recyclerView, View view) {
        int n = recyclerView.getChildCount();
        float f = 0.0f;
        int n2 = 0;
        while (n2 < n) {
            float f2;
            View view2 = recyclerView.getChildAt(n2);
            if (view2 == view) {
                f2 = f;
            } else {
                float f3 = ViewCompat.getElevation((View)view2);
                f2 = f;
                if (f3 > f) {
                    f2 = f3;
                }
            }
            ++n2;
            f = f2;
        }
        return f;
    }

    public void clearView(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object object = view.getTag(R.id.item_touch_helper_previous_elevation);
            if (object instanceof Float) {
                ViewCompat.setElevation((View)view, (float)((Float)object).floatValue());
            }
            view.setTag(R.id.item_touch_helper_previous_elevation, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int n, boolean bl) {
        if (Build.VERSION.SDK_INT >= 21 && bl && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            float f3 = ViewCompat.getElevation((View)view);
            ViewCompat.setElevation((View)view, (float)(ItemTouchUIUtilImpl.findMaxElevation(recyclerView, view) + 1.0f));
            view.setTag(R.id.item_touch_helper_previous_elevation, (Object)Float.valueOf(f3));
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int n, boolean bl) {
    }

    public void onSelected(View view) {
    }
}
