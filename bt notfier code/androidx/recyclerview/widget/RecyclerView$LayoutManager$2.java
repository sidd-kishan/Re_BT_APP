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

class RecyclerView.LayoutManager.2
implements ViewBoundsCheck.Callback {
    final RecyclerView.LayoutManager this$0;

    RecyclerView.LayoutManager.2(RecyclerView.LayoutManager layoutManager) {
        this.this$0 = layoutManager;
    }

    public View getChildAt(int n) {
        return this.this$0.getChildAt(n);
    }

    public int getChildEnd(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.this$0.getDecoratedBottom(view) + layoutParams.bottomMargin;
    }

    public int getChildStart(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)view.getLayoutParams();
        return this.this$0.getDecoratedTop(view) - layoutParams.topMargin;
    }

    public int getParentEnd() {
        return this.this$0.getHeight() - this.this$0.getPaddingBottom();
    }

    public int getParentStart() {
        return this.this$0.getPaddingTop();
    }
}
