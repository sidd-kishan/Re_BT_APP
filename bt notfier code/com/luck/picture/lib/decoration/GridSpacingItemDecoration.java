/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$State
 */
package com.luck.picture.lib.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration
extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;

    public GridSpacingItemDecoration(int n, int n2, boolean bl) {
        this.spanCount = n;
        this.spacing = n2;
        this.includeEdge = bl;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int n = recyclerView.getChildAdapterPosition(view);
        int n2 = this.spanCount;
        int n3 = n % n2;
        if (this.includeEdge) {
            int n4 = this.spacing;
            rect.left = n4 - n3 * n4 / n2;
            rect.right = (n3 + 1) * this.spacing / this.spanCount;
            if (n < this.spanCount) {
                rect.top = this.spacing;
            }
            rect.bottom = this.spacing;
        } else {
            rect.left = this.spacing * n3 / n2;
            int n5 = this.spacing;
            rect.right = n5 - (n3 + 1) * n5 / this.spanCount;
            if (n < this.spanCount) {
                rect.top = this.spacing;
            }
            rect.bottom = this.spacing;
        }
    }
}
