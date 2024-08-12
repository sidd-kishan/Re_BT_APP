/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.Paint$Style
 *  android.graphics.Point
 *  android.graphics.RectF
 *  android.util.Log
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.QMUIProgressBar$QMUIProgressBarTextGenerator
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIProgressBar;

public class QMUIProgressBar
extends View {
    public static final int DEFAULT_BACKGROUND_COLOR = -7829368;
    public static final int DEFAULT_PROGRESS_COLOR = -16776961;
    public static int DEFAULT_STROKE_WIDTH = 0;
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final int DEFAULT_TEXT_SIZE = 20;
    private static final int PENDING_VALUE_NOT_SET = -1;
    public static final int TOTAL_DURATION = 1000;
    public static final int TYPE_CIRCLE = 1;
    public static final int TYPE_RECT = 0;
    public static final int TYPE_ROUND_RECT = 2;
    private int mAnimationDistance;
    private int mAnimationDuration;
    private long mAnimationStartTime;
    private RectF mArcOval;
    private int mBackgroundColor;
    private Paint mBackgroundPaint = new Paint();
    RectF mBgRect;
    private Point mCenterPoint;
    private int mCircleRadius;
    private int mHeight;
    private int mMaxValue;
    private Paint mPaint = new Paint();
    private int mPendingValue;
    private int mProgressColor;
    RectF mProgressRect;
    QMUIProgressBarTextGenerator mQMUIProgressBarTextGenerator;
    private boolean mRoundCap;
    private int mStrokeWidth;
    private String mText = "";
    private int mTextColor;
    private Paint mTextPaint = new Paint(1);
    private int mTextSize;
    private int mType;
    private int mValue;
    private int mWidth;

    static {
        DEFAULT_STROKE_WIDTH = QMUIDisplayHelper.dpToPx((int)40);
    }

    public QMUIProgressBar(Context context) {
        super(context);
        this.mArcOval = new RectF();
        this.setup(context, null);
    }

    public QMUIProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mArcOval = new RectF();
        this.setup(context, attributeSet);
    }

    public QMUIProgressBar(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mArcOval = new RectF();
        this.setup(context, attributeSet);
    }

    private void configPaint(int n, int n2, boolean bl) {
        this.mPaint.setColor(this.mProgressColor);
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        int n3 = this.mType;
        if (n3 != 0 && n3 != 2) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth((float)this.mStrokeWidth);
            this.mPaint.setAntiAlias(true);
            if (bl) {
                this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            }
            this.mBackgroundPaint.setStyle(Paint.Style.STROKE);
            this.mBackgroundPaint.setStrokeWidth((float)this.mStrokeWidth);
            this.mBackgroundPaint.setAntiAlias(true);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        }
        this.mTextPaint.setColor(n);
        this.mTextPaint.setTextSize((float)n2);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    private void configShape() {
        int n = this.mType;
        if (n != 0 && n != 2) {
            this.mCircleRadius = (Math.min(this.mWidth, this.mHeight) - this.mStrokeWidth) / 2;
            this.mCenterPoint = new Point(this.mWidth / 2, this.mHeight / 2);
        } else {
            this.mBgRect = new RectF((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.mWidth + this.getPaddingLeft()), (float)(this.mHeight + this.getPaddingTop()));
            this.mProgressRect = new RectF();
        }
    }

    private void drawCircle(Canvas canvas) {
        String string;
        canvas.drawCircle((float)this.mCenterPoint.x, (float)this.mCenterPoint.y, (float)this.mCircleRadius, this.mBackgroundPaint);
        this.mArcOval.left = this.mCenterPoint.x - this.mCircleRadius;
        this.mArcOval.right = this.mCenterPoint.x + this.mCircleRadius;
        this.mArcOval.top = this.mCenterPoint.y - this.mCircleRadius;
        this.mArcOval.bottom = this.mCenterPoint.y + this.mCircleRadius;
        int n = this.mValue;
        if (n > 0) {
            canvas.drawArc(this.mArcOval, 270.0f, (float)n * 360.0f / (float)this.mMaxValue, false, this.mPaint);
        }
        if ((string = this.mText) == null) return;
        if (string.length() <= 0) return;
        string = this.mTextPaint.getFontMetricsInt();
        float f = this.mArcOval.top;
        float f2 = (this.mArcOval.height() - (float)((Paint.FontMetricsInt)string).bottom + (float)((Paint.FontMetricsInt)string).top) / 2.0f;
        float f3 = ((Paint.FontMetricsInt)string).top;
        canvas.drawText(this.mText, (float)this.mCenterPoint.x, f + f2 - f3, this.mTextPaint);
    }

    private void drawRect(Canvas canvas) {
        canvas.drawRect(this.mBgRect, this.mBackgroundPaint);
        this.mProgressRect.set((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getPaddingLeft() + this.parseValueToWidth()), (float)(this.getPaddingTop() + this.mHeight));
        canvas.drawRect(this.mProgressRect, this.mPaint);
        String string = this.mText;
        if (string == null) return;
        if (string.length() <= 0) return;
        string = this.mTextPaint.getFontMetricsInt();
        float f = this.mBgRect.top;
        float f2 = (this.mBgRect.height() - (float)((Paint.FontMetricsInt)string).bottom + (float)((Paint.FontMetricsInt)string).top) / 2.0f;
        float f3 = ((Paint.FontMetricsInt)string).top;
        canvas.drawText(this.mText, this.mBgRect.centerX(), f + f2 - f3, this.mTextPaint);
    }

    private void drawRoundRect(Canvas canvas) {
        float f = (float)this.mHeight / 2.0f;
        canvas.drawRoundRect(this.mBgRect, f, f, this.mBackgroundPaint);
        this.mProgressRect.set((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getPaddingLeft() + this.parseValueToWidth()), (float)(this.getPaddingTop() + this.mHeight));
        canvas.drawRoundRect(this.mProgressRect, f, f, this.mPaint);
        String string = this.mText;
        if (string == null) return;
        if (string.length() <= 0) return;
        string = this.mTextPaint.getFontMetricsInt();
        float f2 = this.mBgRect.top;
        f = (this.mBgRect.height() - (float)((Paint.FontMetricsInt)string).bottom + (float)((Paint.FontMetricsInt)string).top) / 2.0f;
        float f3 = ((Paint.FontMetricsInt)string).top;
        canvas.drawText(this.mText, this.mBgRect.centerX(), f2 + f - f3, this.mTextPaint);
    }

    private int parseValueToWidth() {
        return this.mWidth * this.mValue / this.mMaxValue;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getProgress() {
        return this.mValue;
    }

    public QMUIProgressBarTextGenerator getQMUIProgressBarTextGenerator() {
        return this.mQMUIProgressBarTextGenerator;
    }

    protected void onDraw(Canvas canvas) {
        QMUIProgressBarTextGenerator qMUIProgressBarTextGenerator;
        int n;
        if (this.mPendingValue != -1) {
            long l = System.currentTimeMillis() - this.mAnimationStartTime;
            if (l >= (long)(n = this.mAnimationDuration)) {
                this.mValue = this.mPendingValue;
                this.mPendingValue = -1;
            } else {
                this.mValue = (int)((float)this.mPendingValue - (1.0f - (float)l / (float)n) * (float)this.mAnimationDistance);
                ViewCompat.postInvalidateOnAnimation((View)this);
            }
        }
        if ((qMUIProgressBarTextGenerator = this.mQMUIProgressBarTextGenerator) != null) {
            this.mText = qMUIProgressBarTextGenerator.generateText(this, this.mValue, this.mMaxValue);
        }
        if ((n = this.mType) == 0) {
            this.drawRect(canvas);
        } else if (n == 2) {
            this.drawRoundRect(canvas);
        } else {
            this.drawCircle(canvas);
        }
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        this.mWidth = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
        this.mHeight = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        this.configShape();
        this.setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void setBarColor(int n, int n2) {
        this.mBackgroundColor = n;
        this.mProgressColor = n2;
        this.mBackgroundPaint.setColor(n);
        this.mPaint.setColor(this.mProgressColor);
        this.invalidate();
    }

    public void setMaxValue(int n) {
        this.mMaxValue = n;
    }

    public void setProgress(int n) {
        this.setProgress(n, true);
    }

    public void setProgress(int n, boolean bl) {
        int n2;
        if (n > this.mMaxValue) return;
        if (n < 0) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setProgress = ");
        stringBuilder.append(n);
        stringBuilder.append("; current = ");
        stringBuilder.append(this.mValue);
        Log.i((String)"cgine", (String)stringBuilder.toString());
        if (this.mPendingValue == -1) {
            if (this.mValue == n) return;
        }
        if ((n2 = this.mPendingValue) != -1 && n2 == n) {
            return;
        }
        if (!bl) {
            this.mPendingValue = -1;
            this.mValue = n;
            this.invalidate();
        } else {
            this.mAnimationDuration = Math.abs((int)((float)((this.mValue - n) * 1000) / (float)this.mMaxValue));
            this.mAnimationStartTime = System.currentTimeMillis();
            this.mAnimationDistance = n - this.mValue;
            this.mPendingValue = n;
            this.invalidate();
        }
    }

    public void setQMUIProgressBarTextGenerator(QMUIProgressBarTextGenerator qMUIProgressBarTextGenerator) {
        this.mQMUIProgressBarTextGenerator = qMUIProgressBarTextGenerator;
    }

    public void setStrokeRoundCap(boolean bl) {
        Paint paint = this.mPaint;
        Paint.Cap cap = bl ? Paint.Cap.ROUND : Paint.Cap.BUTT;
        paint.setStrokeCap(cap);
        this.invalidate();
    }

    public void setTextColor(int n) {
        this.mTextPaint.setColor(n);
        this.invalidate();
    }

    public void setTextSize(int n) {
        this.mTextPaint.setTextSize((float)n);
        this.invalidate();
    }

    public void setType(int n) {
        this.mType = n;
        this.configPaint(this.mTextColor, this.mTextSize, this.mRoundCap);
        this.invalidate();
    }

    public void setup(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIProgressBar);
        this.mType = context.getInt(R.styleable.QMUIProgressBar_qmui_type, 0);
        this.mProgressColor = context.getColor(R.styleable.QMUIProgressBar_qmui_progress_color, -16776961);
        this.mBackgroundColor = context.getColor(R.styleable.QMUIProgressBar_qmui_background_color, -7829368);
        this.mMaxValue = context.getInt(R.styleable.QMUIProgressBar_qmui_max_value, 100);
        this.mValue = context.getInt(R.styleable.QMUIProgressBar_qmui_value, 0);
        this.mRoundCap = context.getBoolean(R.styleable.QMUIProgressBar_qmui_stroke_round_cap, false);
        this.mTextSize = 20;
        if (context.hasValue(R.styleable.QMUIProgressBar_android_textSize)) {
            this.mTextSize = context.getDimensionPixelSize(R.styleable.QMUIProgressBar_android_textSize, 20);
        }
        this.mTextColor = -16777216;
        if (context.hasValue(R.styleable.QMUIProgressBar_android_textColor)) {
            this.mTextColor = context.getColor(R.styleable.QMUIProgressBar_android_textColor, -16777216);
        }
        if (this.mType == 1) {
            this.mStrokeWidth = context.getDimensionPixelSize(R.styleable.QMUIProgressBar_qmui_stroke_width, DEFAULT_STROKE_WIDTH);
        }
        context.recycle();
        this.configPaint(this.mTextColor, this.mTextSize, this.mRoundCap);
        this.setProgress(this.mValue);
    }
}
