/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.view.MotionEvent
 *  android.view.View
 *  androidx.core.content.ContextCompat
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$dimen
 *  com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$ScrollingListener
 */
package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

public class HorizontalProgressWheelView
extends View {
    private final Rect mCanvasClipBounds = new Rect();
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private Paint mProgressMiddleLinePaint;
    private boolean mScrollStarted;
    private ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
    }

    private void init() {
        Paint paint;
        this.mMiddleLineColor = ContextCompat.getColor((Context)this.getContext(), (int)R.color.ucrop_color_widget_rotate_mid_line);
        this.mProgressLineWidth = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        this.mProgressLinePaint = paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth((float)this.mProgressLineWidth);
        this.mProgressLinePaint.setColor(this.getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        this.mProgressMiddleLinePaint = paint = new Paint(this.mProgressLinePaint);
        paint.setColor(this.mMiddleLineColor);
        this.mProgressMiddleLinePaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressMiddleLinePaint.setStrokeWidth((float)this.getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    private void onScrollEvent(MotionEvent motionEvent, float f) {
        this.mTotalScrollDistance -= f;
        this.postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        motionEvent = this.mScrollingListener;
        if (motionEvent == null) return;
        motionEvent.onScroll(-f, this.mTotalScrollDistance);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int n = this.mCanvasClipBounds.width();
        int n2 = this.mProgressLineWidth;
        int n3 = this.mProgressLineMargin;
        n /= n2 + n3;
        float f = this.mTotalScrollDistance;
        float f2 = n3 + n2;
        n3 = 0;
        while (true) {
            float f3;
            if (n3 >= n) {
                f = this.mCanvasClipBounds.centerX();
                f2 = this.mCanvasClipBounds.centerY();
                f3 = (float)this.mProgressLineHeight / 2.0f;
                float f4 = this.mCanvasClipBounds.centerX();
                float f5 = this.mCanvasClipBounds.centerY();
                canvas.drawLine(f, f2 - f3, f4, (float)this.mProgressLineHeight / 2.0f + f5, this.mProgressMiddleLinePaint);
                return;
            }
            n2 = n / 4;
            if (n3 < n2) {
                this.mProgressLinePaint.setAlpha((int)((float)n3 / (float)n2 * 255.0f));
            } else if (n3 > n * 3 / 4) {
                this.mProgressLinePaint.setAlpha((int)((float)(n - n3) / (float)n2 * 255.0f));
            } else {
                this.mProgressLinePaint.setAlpha(255);
            }
            f3 = -(f % f2);
            canvas.drawLine((float)this.mCanvasClipBounds.left + f3 + (float)((this.mProgressLineWidth + this.mProgressLineMargin) * n3), (float)this.mCanvasClipBounds.centerY() - (float)this.mProgressLineHeight / 4.0f, f3 + (float)this.mCanvasClipBounds.left + (float)((this.mProgressLineWidth + this.mProgressLineMargin) * n3), (float)this.mCanvasClipBounds.centerY() + (float)this.mProgressLineHeight / 4.0f, this.mProgressLinePaint);
            ++n3;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1) {
                if (n != 2) return true;
                float f = motionEvent.getX() - this.mLastTouchedPosition;
                if (f == 0.0f) return true;
                if (!this.mScrollStarted) {
                    this.mScrollStarted = true;
                    ScrollingListener scrollingListener = this.mScrollingListener;
                    if (scrollingListener != null) {
                        scrollingListener.onScrollStart();
                    }
                }
                this.onScrollEvent(motionEvent, f);
            } else {
                motionEvent = this.mScrollingListener;
                if (motionEvent == null) return true;
                this.mScrollStarted = false;
                motionEvent.onScrollEnd();
            }
        } else {
            this.mLastTouchedPosition = motionEvent.getX();
        }
        return true;
    }

    public void setMiddleLineColor(int n) {
        this.mMiddleLineColor = n;
        this.invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }
}
