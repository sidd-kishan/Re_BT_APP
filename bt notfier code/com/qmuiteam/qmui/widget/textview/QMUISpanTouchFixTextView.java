/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.Spannable
 *  android.text.method.MovementMethod
 *  android.view.MotionEvent
 *  android.widget.TextView
 *  com.qmuiteam.qmui.link.QMUILinkTouchMovementMethod
 *  com.qmuiteam.qmui.widget.textview.ISpanTouchFix
 */
package com.qmuiteam.qmui.widget.textview;

import android.content.Context;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.qmuiteam.qmui.link.QMUILinkTouchMovementMethod;
import com.qmuiteam.qmui.widget.textview.ISpanTouchFix;

public class QMUISpanTouchFixTextView
extends TextView
implements ISpanTouchFix {
    private boolean mIsPressedRecord = false;
    private boolean mNeedForceEventToParent = false;
    private boolean mTouchSpanHit;

    public QMUISpanTouchFixTextView(Context context) {
        this(context, null);
    }

    public QMUISpanTouchFixTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUISpanTouchFixTextView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.setHighlightColor(0);
    }

    protected void onSetPressed(boolean bl) {
        super.setPressed(bl);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(this.getText() instanceof Spannable)) {
            return super.onTouchEvent(motionEvent);
        }
        this.mTouchSpanHit = true;
        boolean bl = super.onTouchEvent(motionEvent);
        if (!this.mNeedForceEventToParent) return bl;
        bl = this.mTouchSpanHit;
        return bl;
    }

    public boolean performClick() {
        if (this.mTouchSpanHit) return false;
        if (this.mNeedForceEventToParent) return false;
        return super.performClick();
    }

    public boolean performLongClick() {
        if (this.mTouchSpanHit) return false;
        if (this.mNeedForceEventToParent) return false;
        return super.performLongClick();
    }

    public void setMovementMethodCompat(MovementMethod movementMethod) {
        this.setMovementMethod(movementMethod);
        if (!this.mNeedForceEventToParent) return;
        this.setNeedForceEventToParent(true);
    }

    public void setMovementMethodDefault() {
        this.setMovementMethodCompat(QMUILinkTouchMovementMethod.getInstance());
    }

    public void setNeedForceEventToParent(boolean bl) {
        this.mNeedForceEventToParent = bl;
        this.setFocusable(bl ^ true);
        this.setClickable(bl ^ true);
        this.setLongClickable(bl ^ true);
    }

    public final void setPressed(boolean bl) {
        this.mIsPressedRecord = bl;
        if (this.mTouchSpanHit) return;
        this.onSetPressed(bl);
    }

    public void setTouchSpanHit(boolean bl) {
        if (this.mTouchSpanHit == bl) return;
        this.mTouchSpanHit = bl;
        this.setPressed(this.mIsPressedRecord);
    }
}
