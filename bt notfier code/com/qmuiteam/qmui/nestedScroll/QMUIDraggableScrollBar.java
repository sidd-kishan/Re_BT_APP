/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  androidx.core.content.ContextCompat
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.R$drawable
 *  com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar$Callback
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUILangHelper
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;

public class QMUIDraggableScrollBar
extends View {
    private int mAdjustDistanceProtection;
    private int mAdjustMaxDistanceOnce;
    private Callback mCallback;
    private float mCurrentAlpha = 0.0f;
    private Runnable mDelayInvalidateRunnable = new /* Unavailable Anonymous Inner Class!! */;
    private Drawable mDragDrawable;
    private float mDragInnerTop = 0.0f;
    private int mDrawableDrawTop = -1;
    private boolean mIsInDragging = false;
    private int mKeepShownTime = 800;
    private float mPercent = 0.0f;
    private long mStartTransitionTime = 0L;
    private int mTransitionDuration = 100;

    public QMUIDraggableScrollBar(Context context) {
        this(context, (AttributeSet)null);
    }

    public QMUIDraggableScrollBar(Context context, Drawable drawable) {
        this(context, (AttributeSet)null);
        this.mDragDrawable = drawable.mutate();
    }

    public QMUIDraggableScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdjustDistanceProtection = QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)20);
        this.mAdjustMaxDistanceOnce = QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)4);
    }

    private void onDragging(Drawable drawable, float f) {
        f = QMUILangHelper.constrain((float)((f - (float)this.getScrollBarTopMargin() - this.mDragInnerTop) / (float)(this.getHeight() - this.getScrollBarBottomMargin() - this.getScrollBarTopMargin() - drawable.getIntrinsicHeight())), (float)0.0f, (float)1.0f);
        drawable = this.mCallback;
        if (drawable != null) {
            drawable.onDragToPercent(f);
        }
        this.setPercentInternal(f);
    }

    private void setPercentInternal(float f) {
        this.mPercent = f;
        this.invalidate();
    }

    public void awakenScrollBar() {
        int n;
        long l;
        long l2;
        if (this.mDragDrawable == null) {
            this.mDragDrawable = ContextCompat.getDrawable((Context)this.getContext(), (int)R.drawable.qmui_icon_scroll_bar);
        }
        if ((l2 = System.currentTimeMillis()) - (l = this.mStartTransitionTime) > (long)(n = this.mTransitionDuration)) {
            this.mStartTransitionTime = l2 - (long)n;
        }
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    protected int getScrollBarBottomMargin() {
        return 0;
    }

    protected int getScrollBarTopMargin() {
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    protected void onDraw(Canvas var1_1) {
        block12: {
            block14: {
                block13: {
                    block11: {
                        super.onDraw(var1_1);
                        var16_2 = this.mDragDrawable;
                        if (var16_2 == null) {
                            return;
                        }
                        var7_3 = var16_2.getIntrinsicWidth();
                        var8_4 = var16_2.getIntrinsicHeight();
                        if (var7_3 <= 0) return;
                        if (var8_4 <= 0) return;
                        var12_5 = System.currentTimeMillis() - this.mStartTransitionTime;
                        if (var12_5 >= (long)(var4_6 = this.mTransitionDuration)) break block11;
                        this.mCurrentAlpha = (float)var12_5 * 1.0f / (float)var4_6;
                        ** GOTO lbl22
                    }
                    var14_8 = var4_6;
                    var3_7 = this.mKeepShownTime;
                    if (var12_5 - var14_8 < (long)var3_7) {
                        this.mCurrentAlpha = 1.0f;
                        var3_7 = (int)((long)var3_7 - (var12_5 - (long)var4_6));
                    } else if ((var12_5 = var12_5 - (long)var4_6 - (long)var3_7) < (long)var4_6) {
                        this.mCurrentAlpha = 1.0f - (float)var12_5 * 1.0f / (float)var4_6;
lbl22:
                        // 2 sources

                        var3_7 = 0;
                    } else {
                        this.mCurrentAlpha = 0.0f;
                        var3_7 = -1;
                    }
                    var2_9 = this.mCurrentAlpha;
                    if (var2_9 <= 0.0f) {
                        return;
                    }
                    var16_2.setAlpha((int)(var2_9 * 255.0f));
                    var4_6 = this.getHeight();
                    var5_10 = this.getScrollBarTopMargin();
                    var6_11 = this.getScrollBarBottomMargin();
                    var9_12 = this.getWidth();
                    var6_11 = this.getScrollBarTopMargin() + (int)((float)(var4_6 - var5_10 - var6_11 - var8_4) * this.mPercent);
                    var4_6 = var3_7;
                    var5_10 = var6_11;
                    if (this.mIsInDragging) break block12;
                    var11_13 = this.mDrawableDrawTop;
                    var4_6 = var3_7;
                    var5_10 = var6_11;
                    if (var11_13 <= 0) break block12;
                    var10_14 = var6_11 - var11_13;
                    var4_6 = this.mAdjustMaxDistanceOnce;
                    if (var10_14 <= var4_6 || var10_14 >= this.mAdjustDistanceProtection) break block13;
                    var3_7 = var11_13 + var4_6;
                    break block14;
                }
                var11_13 = this.mAdjustMaxDistanceOnce;
                var4_6 = var3_7;
                var5_10 = var6_11;
                if (var10_14 >= -var11_13) break block12;
                var4_6 = var3_7;
                var5_10 = var6_11;
                if (var10_14 <= -this.mAdjustDistanceProtection) break block12;
                var3_7 = this.mDrawableDrawTop - var11_13;
            }
            var4_6 = 0;
            var5_10 = var3_7;
        }
        var16_2.setBounds(0, 0, var7_3, var8_4);
        var1_1.save();
        var1_1.translate((float)(var9_12 - var7_3), (float)var5_10);
        var16_2.draw(var1_1);
        var1_1.restore();
        this.mDrawableDrawTop = var5_10;
        if (var4_6 == 0) {
            this.invalidate();
        } else {
            if (var4_6 <= 0) return;
            ViewCompat.postOnAnimationDelayed((View)this, (Runnable)this.mDelayInvalidateRunnable, (long)var4_6);
        }
    }

    protected void onMeasure(int n, int n2) {
        Drawable drawable2 = this.mDragDrawable;
        if (drawable2 == null) {
            super.onMeasure(n, n2);
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)drawable2.getIntrinsicWidth(), (int)0x40000000), n2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable2 = this.mDragDrawable;
        if (drawable2 == null) {
            return super.onTouchEvent(motionEvent);
        }
        int n = motionEvent.getAction();
        float f = motionEvent.getX();
        float f2 = motionEvent.getY();
        if (n == 0) {
            this.mIsInDragging = false;
            if (!(this.mCurrentAlpha > 0.0f)) return this.mIsInDragging;
            if (!(f > (float)(this.getWidth() - drawable2.getIntrinsicWidth()))) return this.mIsInDragging;
            n = this.mDrawableDrawTop;
            if (!(f2 >= (float)n)) return this.mIsInDragging;
            if (!(f2 <= (float)(n + drawable2.getIntrinsicHeight()))) return this.mIsInDragging;
            this.mDragInnerTop = f2 - (float)this.mDrawableDrawTop;
            this.getParent().requestDisallowInterceptTouchEvent(true);
            this.mIsInDragging = true;
            motionEvent = this.mCallback;
            if (motionEvent == null) return this.mIsInDragging;
            motionEvent.onDragStarted();
        } else if (n == 2) {
            if (!this.mIsInDragging) return this.mIsInDragging;
            this.getParent().requestDisallowInterceptTouchEvent(true);
            this.onDragging(drawable2, f2);
        } else {
            if (n != 1) {
                if (n != 3) return this.mIsInDragging;
            }
            if (!this.mIsInDragging) return this.mIsInDragging;
            this.mIsInDragging = false;
            this.onDragging(drawable2, f2);
            motionEvent = this.mCallback;
            if (motionEvent == null) return this.mIsInDragging;
            motionEvent.onDragEnd();
        }
        return this.mIsInDragging;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setDragDrawable(Drawable drawable2) {
        this.mDragDrawable = drawable2.mutate();
        this.invalidate();
    }

    public void setKeepShownTime(int n) {
        this.mKeepShownTime = n;
    }

    public void setPercent(float f) {
        if (this.mIsInDragging) return;
        this.setPercentInternal(f);
    }

    public void setTransitionDuration(int n) {
        this.mTransitionDuration = n;
    }
}
