/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.view.MotionEvent
 *  android.view.View
 *  com.lianhezhuli.btnotification.bean.BarChartBean
 *  com.lianhezhuli.btnotification.utils.DateUtil
 *  com.lianhezhuli.btnotification.view.SleepBarChartView$OnBarClickListener
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.lianhezhuli.btnotification.bean.BarChartBean;
import com.lianhezhuli.btnotification.utils.DateUtil;
import com.lianhezhuli.btnotification.view.SleepBarChartView;
import com.orhanobut.logger.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SleepBarChartView
extends View {
    private OnBarClickListener listener;
    private float mBarBottomMargin;
    private int mBarColor;
    private float mBarSize;
    private List<RectF> mBars;
    private int mBgColor;
    private RectF mBottomTextArea;
    private int mBottomTextColor;
    private float mBottomTextSize;
    private float mChartW;
    private List<RectF> mClickRectF;
    private List<BarChartBean> mDatas = new ArrayList<BarChartBean>();
    private String[] mLabel;
    private float mLeftMargin;
    private int mMaxValue = 0;
    private Paint mPaint;
    private float mRightMargin;
    private float mTopMargin;
    private int mTotalH;
    private int mTotalW;

    public SleepBarChartView(Context context) {
        super(context);
        this.mBars = new ArrayList<RectF>();
        this.mClickRectF = new ArrayList<RectF>();
        this.init(context);
    }

    public SleepBarChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBars = new ArrayList<RectF>();
        this.mClickRectF = new ArrayList<RectF>();
        this.init(context);
    }

    public SleepBarChartView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mBars = new ArrayList<RectF>();
        this.mClickRectF = new ArrayList<RectF>();
        this.init(context);
    }

    public SleepBarChartView(Context context, AttributeSet attributeSet, int n, int n2) {
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

    private void drawLabelText(Canvas canvas) {
        String[] stringArray;
        this.mPaint.setColor(this.mBottomTextColor);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(this.mBottomTextSize);
        int n = this.mDatas.size();
        int n2 = 0;
        int n3 = 0;
        if (n != 0) {
            while (n2 < this.mDatas.size()) {
                canvas.drawText(this.mDatas.get(n2).getLabel(), this.mClickRectF.get(n2).centerX(), this.mBottomTextArea.centerY() + this.mBottomTextSize / 3.0f, this.mPaint);
                ++n2;
            }
            return;
        }
        n2 = n3;
        while (n2 < (stringArray = this.mLabel).length) {
            canvas.drawText(stringArray[n2], this.mClickRectF.get(n2).centerX(), this.mBottomTextArea.centerY() + this.mBottomTextSize / 3.0f, this.mPaint);
            ++n2;
        }
    }

    private void handleData() {
        float f = this.mTotalH - this.getPaddingTop();
        float f2 = this.mTopMargin;
        float f3 = this.mBarBottomMargin;
        float f4 = this.getPaddingBottom();
        float f5 = this.getPaddingLeft();
        float f6 = this.mLeftMargin;
        this.mBars.clear();
        int n = 0;
        while (n < this.mDatas.size()) {
            RectF rectF = new RectF();
            rectF.top = (float)this.mTotalH - (float)this.mDatas.get(n).getValue() / (float)this.mMaxValue * (f - f2 - f3 - f4) - this.mBarBottomMargin;
            rectF.left = (float)n * this.mBarSize * 2.6f + (f5 + f6);
            rectF.right = rectF.left + this.mBarSize;
            rectF.bottom = (float)this.mTotalH - this.mBarBottomMargin;
            this.mBars.add(rectF);
            ++n;
        }
    }

    private void init(Context context) {
        this.mPaint = new Paint(1);
        this.mBottomTextSize = context.getResources().getDimension(2131166234);
        this.mTopMargin = context.getResources().getDimension(2131165962);
        this.mLeftMargin = context.getResources().getDimension(2131165382);
        this.mRightMargin = context.getResources().getDimension(2131165382);
        this.mBarBottomMargin = context.getResources().getDimension(2131165382);
        this.mBottomTextColor = context.getResources().getColor(2131099724);
        this.mBarColor = context.getResources().getColor(2131099723);
        this.mBgColor = context.getResources().getColor(2131099722);
        this.mLabel = DateUtil.getLast7WeekDay((Date)new Date());
    }

    private void initClickArea() {
        float f;
        this.mChartW = f = (float)(this.mTotalW - this.getPaddingLeft()) - this.mLeftMargin - (float)this.getPaddingRight() - this.mRightMargin;
        this.mBarSize = f / 16.6f;
        f = this.getPaddingLeft();
        float f2 = this.mLeftMargin;
        int n = this.mTotalH;
        this.mBottomTextArea = new RectF(0.0f, (float)n - this.mBarBottomMargin, (float)this.mTotalW, (float)(n - this.getPaddingBottom()));
        n = 0;
        while (n < 7) {
            RectF rectF = new RectF();
            rectF.left = (float)n * this.mBarSize * 2.6f + (f + f2);
            rectF.top = (float)this.getPaddingTop() + this.mTopMargin;
            rectF.right = rectF.left + this.mBarSize;
            rectF.bottom = (float)this.mTotalH - this.mBarBottomMargin;
            this.mClickRectF.add(rectF);
            ++n;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.mBgColor);
        this.mPaint.setColor(-1);
        canvas.drawRect(this.mBottomTextArea, this.mPaint);
        this.drawLabelText(canvas);
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
                object = this.listener;
                if (object == null) return false;
                object.onWitchClick(this.mDatas.get(n));
                return false;
            }
            ++n;
        }
        return false;
    }

    public void setBarColor(int n) {
        this.mBarColor = n;
    }

    public void setBottomTextColor(int n) {
        this.mBottomTextColor = n;
    }

    public void setData(List<BarChartBean> list, int n) {
        this.mDatas.clear();
        this.mDatas.addAll(list);
        this.mMaxValue = n;
        this.handleData();
        this.invalidate();
    }

    public void setOnBarClickListener(OnBarClickListener onBarClickListener) {
        this.listener = onBarClickListener;
    }
}
