/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  androidx.recyclerview.widget.RecyclerView$LayoutParams
 *  androidx.recyclerview.widget.ViewBoundsCheck$Callback
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck;

class RecyclerView.LayoutManager.1
implements ViewBoundsCheck.Callback {
    final RecyclerView.LayoutManager this$0;

    RecyclerView.LayoutManager.1(RecyclerView.LayoutManager layoutManager) {
        this.this$0 = layoutManager;
    }

    public View getChildAt(int n) {
        return this.this$0.getChildAt(n);
    }

    public int getChildEnd(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.this$0.getDecoratedRight(view) + layoutParams.rightMargin;
    }

    public int getChildStart(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.this$0.getDecoratedLeft(view) - layoutParams.leftMargin;
    }

    public int getParentEnd() {
        return this.this$0.getWidth() - this.this$0.getPaddingRight();
    }

    public int getParentStart() {
        return this.this$0.getPaddingLeft();
    }
}
