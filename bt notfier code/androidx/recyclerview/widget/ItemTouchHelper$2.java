/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  androidx.recyclerview.widget.ItemTouchHelper
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$OnItemTouchListener
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

class ItemTouchHelper.2
implements RecyclerView.OnItemTouchListener {
    final ItemTouchHelper this$0;

    ItemTouchHelper.2(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.this$0.mGestureDetector.onTouchEvent(motionEvent);
        int n = motionEvent.getActionMasked();
        boolean bl = true;
        if (n == 0) {
            this.this$0.mActivePointerId = motionEvent.getPointerId(0);
            this.this$0.mInitialTouchX = motionEvent.getX();
            this.this$0.mInitialTouchY = motionEvent.getY();
            this.this$0.obtainVelocityTracker();
            if (this.this$0.mSelected == null && (recyclerView = this.this$0.findAnimation(motionEvent)) != null) {
                ItemTouchHelper itemTouchHelper = this.this$0;
                itemTouchHelper.mInitialTouchX -= recyclerView.mX;
                itemTouchHelper = this.this$0;
                itemTouchHelper.mInitialTouchY -= recyclerView.mY;
                this.this$0.endRecoverAnimation(recyclerView.mViewHolder, true);
                if (this.this$0.mPendingCleanup.remove(recyclerView.mViewHolder.itemView)) {
                    this.this$0.mCallback.clearView(this.this$0.mRecyclerView, recyclerView.mViewHolder);
                }
                this.this$0.select(recyclerView.mViewHolder, recyclerView.mActionState);
                recyclerView = this.this$0;
                recyclerView.updateDxDy(motionEvent, recyclerView.mSelectedFlags, 0);
            }
        } else if (n != 3 && n != 1) {
            int n2;
            if (this.this$0.mActivePointerId != -1 && (n2 = motionEvent.findPointerIndex(this.this$0.mActivePointerId)) >= 0) {
                this.this$0.checkSelectForSwipe(n, motionEvent, n2);
            }
        } else {
            this.this$0.mActivePointerId = -1;
            this.this$0.select(null, 0);
        }
        if (this.this$0.mVelocityTracker != null) {
            this.this$0.mVelocityTracker.addMovement(motionEvent);
        }
        if (this.this$0.mSelected != null) return bl;
        bl = false;
        return bl;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean bl) {
        if (!bl) {
            return;
        }
        this.this$0.select(null, 0);
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        block8: {
            block5: {
                RecyclerView.ViewHolder viewHolder;
                int n;
                block6: {
                    block7: {
                        this.this$0.mGestureDetector.onTouchEvent(motionEvent);
                        if (this.this$0.mVelocityTracker != null) {
                            this.this$0.mVelocityTracker.addMovement(motionEvent);
                        }
                        if (this.this$0.mActivePointerId == -1) {
                            return;
                        }
                        int n2 = motionEvent.getActionMasked();
                        n = motionEvent.findPointerIndex(this.this$0.mActivePointerId);
                        if (n >= 0) {
                            this.this$0.checkSelectForSwipe(n2, motionEvent, n);
                        }
                        if ((viewHolder = this.this$0.mSelected) == null) {
                            return;
                        }
                        int n3 = 0;
                        if (n2 == 1) break block5;
                        if (n2 == 2) break block6;
                        if (n2 == 3) break block7;
                        if (n2 != 6) return;
                        n2 = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(n2) != this.this$0.mActivePointerId) return;
                        if (n2 == 0) {
                            n3 = 1;
                        }
                        this.this$0.mActivePointerId = motionEvent.getPointerId(n3);
                        recyclerView = this.this$0;
                        recyclerView.updateDxDy(motionEvent, recyclerView.mSelectedFlags, n2);
                        break block8;
                    }
                    if (this.this$0.mVelocityTracker == null) break block5;
                    this.this$0.mVelocityTracker.clear();
                    break block5;
                }
                if (n < 0) return;
                recyclerView = this.this$0;
                recyclerView.updateDxDy(motionEvent, recyclerView.mSelectedFlags, n);
                this.this$0.moveIfNecessary(viewHolder);
                this.this$0.mRecyclerView.removeCallbacks(this.this$0.mScrollRunnable);
                this.this$0.mScrollRunnable.run();
                this.this$0.mRecyclerView.invalidate();
                break block8;
            }
            this.this$0.select(null, 0);
            this.this$0.mActivePointerId = -1;
        }
    }
}
