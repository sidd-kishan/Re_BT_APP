/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  com.qmuiteam.qmui.link.ITouchableSpan
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceView
 */
package com.qmuiteam.qmui.qqface;

import android.graphics.Rect;
import android.view.View;
import com.qmuiteam.qmui.link.ITouchableSpan;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;

/*
 * Exception performing whole class analysis ignored.
 */
private class QMUIQQFaceView.SpanInfo {
    private int mEndLine;
    private int mEndPoint;
    private int mStartLine;
    private int mStartPoint;
    private ITouchableSpan mTouchableSpan;
    final QMUIQQFaceView this$0;

    public QMUIQQFaceView.SpanInfo(QMUIQQFaceView qMUIQQFaceView, ITouchableSpan iTouchableSpan) {
        this.this$0 = qMUIQQFaceView;
        this.mTouchableSpan = iTouchableSpan;
    }

    public void invalidateSpan() {
        int n = this.this$0.getPaddingTop();
        int n2 = this.mStartLine;
        int n3 = n;
        if (n2 > 1) {
            n3 = n + (n2 - 1) * (QMUIQQFaceView.access$100((QMUIQQFaceView)this.this$0) + QMUIQQFaceView.access$200((QMUIQQFaceView)this.this$0));
        }
        n2 = this.mEndLine;
        n = QMUIQQFaceView.access$100((QMUIQQFaceView)this.this$0);
        int n4 = QMUIQQFaceView.access$200((QMUIQQFaceView)this.this$0);
        int n5 = QMUIQQFaceView.access$100((QMUIQQFaceView)this.this$0);
        Rect rect = new Rect();
        rect.top = n3;
        rect.bottom = (n2 - 1) * (n + n4) + n3 + n5;
        rect.left = this.this$0.getPaddingLeft();
        rect.right = this.this$0.getWidth() - this.this$0.getPaddingRight();
        if (this.mStartLine == this.mEndLine) {
            rect.left = this.mStartPoint;
            rect.right = this.mEndPoint;
        }
        this.this$0.invalidate(rect);
    }

    public void onClick() {
        this.mTouchableSpan.onClick((View)this.this$0);
    }

    public boolean onTouch(int n, int n2) {
        int n3 = this.this$0.getPaddingTop();
        int n4 = this.mStartLine;
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        int n5 = n3;
        if (n4 > 1) {
            n5 = n3 + (n4 - 1) * (QMUIQQFaceView.access$100((QMUIQQFaceView)this.this$0) + QMUIQQFaceView.access$200((QMUIQQFaceView)this.this$0));
        }
        n3 = (this.mEndLine - 1) * (QMUIQQFaceView.access$100((QMUIQQFaceView)this.this$0) + QMUIQQFaceView.access$200((QMUIQQFaceView)this.this$0)) + this.this$0.getPaddingTop() + QMUIQQFaceView.access$100((QMUIQQFaceView)this.this$0);
        if (n2 < n5) return false;
        if (n2 > n3) {
            return false;
        }
        if (this.mStartLine == this.mEndLine) {
            bl2 = n >= this.mStartPoint && n <= this.mEndPoint ? bl4 : false;
            return bl2;
        }
        n4 = QMUIQQFaceView.access$100((QMUIQQFaceView)this.this$0);
        if (n2 > (n5 += QMUIQQFaceView.access$100((QMUIQQFaceView)this.this$0)) && n2 < n3 - n4) {
            bl2 = bl;
            if (this.mEndLine - this.mStartLine != 1) return bl2;
            bl2 = n >= this.mStartPoint && n <= this.mEndPoint ? bl : false;
            return bl2;
        }
        if (n2 <= n5) {
            if (n >= this.mStartPoint) return bl2;
            bl2 = false;
            return bl2;
        }
        bl2 = n <= this.mEndPoint ? bl3 : false;
        return bl2;
    }

    public void setEnd(int n, int n2) {
        this.mEndLine = n;
        this.mEndPoint = n2;
    }

    public void setPressed(boolean bl) {
        this.mTouchableSpan.setPressed(bl);
    }

    public void setStart(int n, int n2) {
        this.mStartLine = n;
        this.mStartPoint = n2;
    }
}
