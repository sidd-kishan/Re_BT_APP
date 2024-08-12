/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RectF
 *  android.view.MotionEvent
 *  android.view.View
 *  com.lianhezhuli.btnotification.bean.BarChartBean
 *  com.lianhezhuli.btnotification.utils.DateUtil
 *  com.lianhezhuli.btnotification.utils.StringUtils
 *  com.lianhezhuli.btnotification.view.SportBarChartView$OnBarClickListener
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.lianhezhuli.btnotification.bean.BarChartBean;
import com.lianhezhuli.btnotification.utils.DateUtil;
import com.lianhezhuli.btnotification.utils.StringUtils;
import com.lianhezhuli.btnotification.view.SportBarChartView;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SportBarChartView
extends View {
    private OnBarClickListener listener;
    private float mBarBottomMargin;
    private int mBarColor;
    private float mBarSize;
    private List<RectF> mBars;
    private float mBottomMargin;
    private RectF mBottomTextArea;
    private float mBottomTextSize;
    private float mChartW;
    private List<RectF> mClickRectF;
    private List<BarChartBean> mDatas = new ArrayList<BarChartBean>();
    private float mInsideMargin;
    private String[] mLabel;
    private float mLabelMarginLine;
    private float mLeftMargin;
    private float mLineBottomPoint;
    private int mLineColor;
    private float mLineEndPoint;
    private float mLineSpacing;
    private float mLineStartPoint;
    private float mLineTextSize;
    private float mLineTopPoint;
    private float mLineWidth;
    private int mMaxValue = 0;
    private Paint mPaint;
    private float mRightMargin;
    private int mScaleValue = 500;
    private int mSelectIndex = -1;
    private int mSelectTextColor;
    private float mTopMargin;
    private int mTotalH;
    private int mTotalW;

    public SportBarChartView(Context context) {
        super(context);
        this.mBars = new ArrayList<RectF>();
        this.mClickRectF = new ArrayList<RectF>();
        this.init(context);
    }

    public SportBarChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBars = new ArrayList<RectF>();
        this.mClickRectF = new ArrayList<RectF>();
        this.init(context);
    }

    public SportBarChartView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mBars = new ArrayList<RectF>();
        this.mClickRectF = new ArrayList<RectF>();
        this.init(context);
    }

    public SportBarChartView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.mBars = new ArrayList<RectF>();
        this.mClickRectF = new ArrayList<RectF>();
        this.init(context);
    }

    private void drawBar(Canvas canvas) {
        this.mPaint.setColor(this.mBarColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        int n = 0;
        while (n < this.mBars.size()) {
            canvas.drawRect(this.mBars.get(n), this.mPaint);
            ++n;
        }
    }

    private void drawClickText(Canvas canvas) {
        if (this.mSelectIndex == -1) {
            return;
        }
        if (this.mBars.size() == 0) {
            return;
        }
        Object object = new Path();
        float f = this.mBars.get(this.mSelectIndex).centerX();
        float f2 = this.mBars.get((int)this.mSelectIndex).top - this.mBarBottomMargin * 2.0f;
        object.moveTo(f, f2);
        float f3 = this.mBarSize;
        object.lineTo(f - f3 / 5.0f, f2 - f3 / 3.0f);
        f3 = this.mBarSize;
        object.lineTo(f3 / 5.0f + f, f2 - f3 / 3.0f);
        object.lineTo(f, f2);
        object.close();
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setColor(this.mBarColor);
        canvas.drawPath((Path)object, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mSelectTextColor);
        this.mPaint.setTextSize(this.mBottomTextSize);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        object = new StringBuilder();
        ((StringBuilder)object).append(this.mDatas.get(this.mSelectIndex).getValue());
        ((StringBuilder)object).append("");
        canvas.drawText(((StringBuilder)object).toString(), f, f2 - this.mBarSize / 3.0f - this.mBarBottomMargin, this.mPaint);
    }

    private void drawLinesAndText(Canvas canvas) {
        Object object;
        int n;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mLineColor);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        float f = this.mLineStartPoint;
        float f2 = this.mLineBottomPoint;
        float f3 = this.mLabelMarginLine;
        canvas.drawLine(f, f2 - f3, this.mLineEndPoint, f2 - f3, this.mPaint);
        f = this.mLineStartPoint;
        f3 = this.mLineTopPoint;
        canvas.drawLine(f, f3, this.mLineEndPoint, f3, this.mPaint);
        f = this.mLineStartPoint;
        f3 = this.mLineTopPoint;
        f2 = this.mLineSpacing;
        canvas.drawLine(f, f3 + f2, this.mLineEndPoint, f3 + f2, this.mPaint);
        f3 = this.mLineStartPoint;
        f2 = this.mLineTopPoint;
        f = this.mLineSpacing;
        canvas.drawLine(f3, f2 + f * 2.0f, this.mLineEndPoint, f2 + f * 2.0f, this.mPaint);
        this.mPaint.setTextAlign(Paint.Align.RIGHT);
        this.mPaint.setTextSize(this.mLineTextSize);
        int n2 = 0;
        int n3 = 0;
        for (n = 0; n < 4; ++n) {
            int n4 = this.mScaleValue;
            if (n4 > 1000) {
                object = StringUtils.formatStr((String)"%.1fk", (Object[])new Object[]{Float.valueOf((float)(n4 * n) / 1000.0f)});
                f2 = this.mLineStartPoint;
                f = this.mTotalH;
                if (n > 0) {
                    f -= this.mLineTopPoint;
                    f3 = this.mLineSpacing * (float)n;
                } else {
                    f -= this.mLabelMarginLine;
                    f3 = this.mLineTopPoint;
                }
                canvas.drawText((String)object, f2, f - f3 - this.mLineTextSize / 4.0f, this.mPaint);
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            ((StringBuilder)object).append(this.mScaleValue * n);
            object = ((StringBuilder)object).toString();
            f2 = this.mLineStartPoint;
            f = this.mTotalH;
            if (n > 0) {
                f -= this.mLineTopPoint;
                f3 = this.mLineSpacing * (float)n;
            } else {
                f -= this.mLabelMarginLine;
                f3 = this.mLineTopPoint;
            }
            canvas.drawText((String)object, f2, f - f3 - this.mLineTextSize / 4.0f, this.mPaint);
        }
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(this.mBottomTextSize);
        n = n2;
        if (this.mDatas.size() != 0) {
            while (n < this.mDatas.size()) {
                canvas.drawText(this.mDatas.get(n).getLabel(), this.mClickRectF.get(n).centerX(), this.mBottomTextArea.centerY(), this.mPaint);
                ++n;
            }
            return;
        }
        n = n3;
        while (n < ((Object)(object = this.mLabel)).length) {
            canvas.drawText((String)object[n], this.mClickRectF.get(n).centerX(), this.mBottomTextArea.centerY(), this.mPaint);
            ++n;
        }
    }

    private void handleData() {
        float f = this.mTotalH - this.getPaddingTop();
        float f2 = this.mTopMargin;
        float f3 = this.mBarBottomMargin;
        float f4 = this.mBottomMargin;
        float f5 = this.getPaddingBottom();
        float f6 = this.getPaddingLeft();
        float f7 = this.mLeftMargin;
        float f8 = this.mInsideMargin;
        float f9 = (float)this.mMaxValue / 3.0f;
        this.mScaleValue = f9 == 0.0f ? 500 : (f9 % 100.0f > 0.0f ? ((int)f9 / 100 + 1) * 100 : (int)f9);
        f9 = this.mMaxValue;
        int n = this.mScaleValue;
        if (f9 / ((float)n * 3.0f) > 0.9f) {
            this.mScaleValue = n > 1000 ? n + 1000 : n + 100;
        }
        this.mBars.clear();
        n = 0;
        while (n < this.mDatas.size()) {
            RectF rectF = new RectF();
            rectF.top = (float)this.mTotalH - (float)this.mDatas.get(n).getValue() / (float)this.mScaleValue / 3.0f * (f - f2 - f3 - f4 - f5) - this.mBarBottomMargin - this.mBottomMargin - this.mLabelMarginLine;
            rectF.left = (float)n * this.mBarSize * 2.0f + (f6 + f7 + f8);
            rectF.right = rectF.left + this.mBarSize;
            rectF.bottom = (float)this.mTotalH - this.mBottomMargin - this.mBarBottomMargin - this.mLabelMarginLine;
            this.mBars.add(rectF);
            ++n;
        }
    }

    private void init(Context stringArray) {
        this.mPaint = new Paint(1);
        this.mLineWidth = stringArray.getResources().getDimension(2131165294);
        this.mBottomTextSize = stringArray.getResources().getDimension(2131166234);
        this.mLineTextSize = stringArray.getResources().getDimension(2131166235);
        this.mTopMargin = stringArray.getResources().getDimension(2131165416);
        this.mBottomMargin = stringArray.getResources().getDimension(2131165527);
        this.mLeftMargin = stringArray.getResources().getDimension(2131165749);
        this.mRightMargin = stringArray.getResources().getDimension(2131165249);
        this.mInsideMargin = stringArray.getResources().getDimension(2131165305);
        this.mBarBottomMargin = stringArray.getResources().getDimension(2131165738);
        this.mLabelMarginLine = stringArray.getResources().getDimension(2131165205);
        this.mLineColor = stringArray.getResources().getColor(2131099906);
        this.mSelectTextColor = stringArray.getResources().getColor(2131099907);
        this.mBarColor = stringArray.getResources().getColor(2131099905);
        stringArray = DateUtil.getLast7WeekDay((Date)new Date());
        this.mLabel = stringArray;
        Logger.d((Object)stringArray);
    }

    private void initClickArea() {
        float f;
        this.mChartW = f = (float)(this.mTotalW - this.getPaddingLeft()) - this.mLeftMargin - (float)this.getPaddingRight() - this.mRightMargin;
        this.mBarSize = (f - this.mInsideMargin * 2.0f) / 13.0f;
        this.mLineStartPoint = (float)this.getPaddingLeft() + this.mLeftMargin;
        this.mLineEndPoint = (float)(this.mTotalW - this.getPaddingRight()) - this.mRightMargin;
        this.mLineTopPoint = (float)this.getPaddingTop() + this.mTopMargin;
        this.mLineBottomPoint = f = (float)(this.mTotalH - this.getPaddingBottom()) - this.mBottomMargin;
        this.mLineSpacing = (f - this.mLineTopPoint) / 3.0f;
        float f2 = this.getPaddingLeft();
        float f3 = this.mLeftMargin;
        f = this.mInsideMargin;
        this.mBottomTextArea = new RectF(0.0f, (float)this.mTotalH - this.mBottomMargin - (float)this.getPaddingBottom() - this.mLabelMarginLine, 10.0f, (float)(this.mTotalH - this.getPaddingBottom()));
        int n = 0;
        while (n < 7) {
            RectF rectF = new RectF();
            rectF.left = (float)n * this.mBarSize * 2.0f + (f2 + f3 + f);
            rectF.top = (float)this.getPaddingTop() + this.mTopMargin;
            rectF.right = rectF.left + this.mBarSize;
            rectF.bottom = (float)this.mTotalH - this.mBottomMargin - this.mBarBottomMargin - this.mLabelMarginLine;
            this.mClickRectF.add(rectF);
            ++n;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.drawLinesAndText(canvas);
        this.drawClickText(canvas);
        this.drawBar(canvas);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        this.mTotalH = this.getMeasuredHeight();
        this.mTotalW = this.getMeasuredWidth();
        this.initClickArea();
    }

    public boolean onTouchEvent(MotionEvent object) {
        if (object.getAction() != 0) return false;
        float f = object.getX();
        float f2 = object.getY();
        int n = 0;
        while (n < this.mClickRectF.size()) {
            if (this.mClickRectF.get(n).contains(f, f2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("mSelectIndex == ");
                ((StringBuilder)object).append(n);
                Logger.e((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                this.mSelectIndex = n;
                object = this.listener;
                if (object != null) {
                    object.onWitchClick(this.mDatas.get(n));
                }
                this.invalidate();
                return false;
            }
            ++n;
        }
        return false;
    }

    public void setData(List<BarChartBean> list, int n, int n2) {
        this.mDatas.clear();
        this.mDatas.addAll(list);
        this.mMaxValue = n;
        this.mSelectIndex = n2;
        this.handleData();
        this.invalidate();
    }

    public void setOnBarClickListener(OnBarClickListener onBarClickListener) {
        this.listener = onBarClickListener;
    }

    public void setmBarColor(int n) {
        this.mBarColor = n;
    }

    public void setmLineColor(int n) {
        this.mLineColor = n;
    }

    public void setmSelectTextColor(int n) {
        this.mSelectTextColor = n;
    }
}
