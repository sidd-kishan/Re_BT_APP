/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  androidx.core.view.DragStartHelper$OnDragStartListener
 *  androidx.core.view.MotionEventCompat
 */
package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;
import androidx.core.view.MotionEventCompat;

public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final OnDragStartListener mListener;
    private final View.OnLongClickListener mLongClickListener = new /* Unavailable Anonymous Inner Class!! */;
    private final View.OnTouchListener mTouchListener = new /* Unavailable Anonymous Inner Class!! */;
    private final View mView;

    public DragStartHelper(View view, OnDragStartListener onDragStartListener) {
        this.mView = view;
        this.mListener = onDragStartListener;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(Point point) {
        point.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(View view) {
        return this.mListener.onDragStart(view, this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        block3: {
            int n;
            int n2;
            block0: {
                block1: {
                    boolean bl;
                    block2: {
                        n2 = (int)motionEvent.getX();
                        n = (int)motionEvent.getY();
                        int n3 = motionEvent.getAction();
                        if (n3 == 0) break block0;
                        if (n3 == 1) break block1;
                        if (n3 == 2) break block2;
                        if (n3 == 3) break block1;
                        break block3;
                    }
                    if (!MotionEventCompat.isFromSource((MotionEvent)motionEvent, (int)8194)) return false;
                    if ((motionEvent.getButtonState() & 1) == 0 || this.mDragging || this.mLastTouchX == n2 && this.mLastTouchY == n) return false;
                    this.mLastTouchX = n2;
                    this.mLastTouchY = n;
                    this.mDragging = bl = this.mListener.onDragStart(view, this);
                    return bl;
                }
                this.mDragging = false;
                break block3;
            }
            this.mLastTouchX = n2;
            this.mLastTouchY = n;
        }
        return false;
    }
}
