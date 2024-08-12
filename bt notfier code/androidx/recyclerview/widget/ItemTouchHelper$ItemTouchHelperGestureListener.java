/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.recyclerview.widget.ItemTouchHelper
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

private class ItemTouchHelper.ItemTouchHelperGestureListener
extends GestureDetector.SimpleOnGestureListener {
    private boolean mShouldReactToLongPress;
    final ItemTouchHelper this$0;

    ItemTouchHelper.ItemTouchHelperGestureListener(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
        this.mShouldReactToLongPress = true;
    }

    void doNotReactToLongPress() {
        this.mShouldReactToLongPress = false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (!this.mShouldReactToLongPress) {
            return;
        }
        View view = this.this$0.findChildView(motionEvent);
        if (view == null) return;
        if ((view = this.this$0.mRecyclerView.getChildViewHolder(view)) == null) return;
        if (!this.this$0.mCallback.hasDragFlag(this.this$0.mRecyclerView, (RecyclerView.ViewHolder)view)) {
            return;
        }
        if (motionEvent.getPointerId(0) != this.this$0.mActivePointerId) return;
        int n = motionEvent.findPointerIndex(this.this$0.mActivePointerId);
        float f = motionEvent.getX(n);
        float f2 = motionEvent.getY(n);
        this.this$0.mInitialTouchX = f;
        this.this$0.mInitialTouchY = f2;
        motionEvent = this.this$0;
        motionEvent.mDy = 0.0f;
        motionEvent.mDx = 0.0f;
        if (!this.this$0.mCallback.isLongPressDragEnabled()) return;
        this.this$0.select((RecyclerView.ViewHolder)view, 2);
    }
}
