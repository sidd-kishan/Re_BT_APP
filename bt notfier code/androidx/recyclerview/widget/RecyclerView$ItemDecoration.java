/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.RecyclerView$State
 */
package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public static abstract class RecyclerView.ItemDecoration {
    @Deprecated
    public void getItemOffsets(Rect rect, int n, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        this.getItemOffsets(rect, ((RecyclerView.LayoutParams)view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
    }

    @Deprecated
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        this.onDraw(canvas, recyclerView);
    }

    @Deprecated
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        this.onDrawOver(canvas, recyclerView);
    }
}
