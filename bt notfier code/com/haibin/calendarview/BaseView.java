/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Paint$Style
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarLayout
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarViewDelegate
 */
package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarViewDelegate;
import java.util.Iterator;
import java.util.List;

public abstract class BaseView
extends View
implements View.OnClickListener,
View.OnLongClickListener {
    static final int TEXT_SIZE = 14;
    boolean isClick = true;
    protected Paint mCurDayLunarTextPaint;
    protected Paint mCurDayTextPaint;
    protected Paint mCurMonthLunarTextPaint;
    protected Paint mCurMonthTextPaint = new Paint();
    int mCurrentItem = -1;
    CalendarViewDelegate mDelegate;
    protected int mItemHeight;
    protected int mItemWidth;
    List<Calendar> mItems;
    protected Paint mOtherMonthLunarTextPaint;
    protected Paint mOtherMonthTextPaint = new Paint();
    CalendarLayout mParentLayout;
    protected Paint mSchemeLunarTextPaint;
    protected Paint mSchemePaint;
    protected Paint mSchemeTextPaint;
    protected Paint mSelectTextPaint;
    protected Paint mSelectedLunarTextPaint;
    protected Paint mSelectedPaint;
    protected float mTextBaseLine;
    float mX;
    float mY;

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurMonthLunarTextPaint = new Paint();
        this.mSelectedLunarTextPaint = new Paint();
        this.mOtherMonthLunarTextPaint = new Paint();
        this.mSchemeLunarTextPaint = new Paint();
        this.mSchemePaint = new Paint();
        this.mSelectedPaint = new Paint();
        this.mSchemeTextPaint = new Paint();
        this.mSelectTextPaint = new Paint();
        this.mCurDayTextPaint = new Paint();
        this.mCurDayLunarTextPaint = new Paint();
        this.initPaint(context);
    }

    private void initPaint(Context context) {
        this.mCurMonthTextPaint.setAntiAlias(true);
        this.mCurMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurMonthTextPaint.setColor(-15658735);
        this.mCurMonthTextPaint.setFakeBoldText(true);
        this.mCurMonthTextPaint.setTextSize((float)CalendarUtil.dipToPx((Context)context, (float)14.0f));
        this.mOtherMonthTextPaint.setAntiAlias(true);
        this.mOtherMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthTextPaint.setColor(-1973791);
        this.mOtherMonthTextPaint.setFakeBoldText(true);
        this.mOtherMonthTextPaint.setTextSize((float)CalendarUtil.dipToPx((Context)context, (float)14.0f));
        this.mCurMonthLunarTextPaint.setAntiAlias(true);
        this.mCurMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectedLunarTextPaint.setAntiAlias(true);
        this.mSelectedLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthLunarTextPaint.setAntiAlias(true);
        this.mOtherMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeLunarTextPaint.setAntiAlias(true);
        this.mSchemeLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setAntiAlias(true);
        this.mSchemeTextPaint.setStyle(Paint.Style.FILL);
        this.mSchemeTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setColor(-1223853);
        this.mSchemeTextPaint.setFakeBoldText(true);
        this.mSchemeTextPaint.setTextSize((float)CalendarUtil.dipToPx((Context)context, (float)14.0f));
        this.mSelectTextPaint.setAntiAlias(true);
        this.mSelectTextPaint.setStyle(Paint.Style.FILL);
        this.mSelectTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectTextPaint.setColor(-1223853);
        this.mSelectTextPaint.setFakeBoldText(true);
        this.mSelectTextPaint.setTextSize((float)CalendarUtil.dipToPx((Context)context, (float)14.0f));
        this.mSchemePaint.setAntiAlias(true);
        this.mSchemePaint.setStyle(Paint.Style.FILL);
        this.mSchemePaint.setStrokeWidth(2.0f);
        this.mSchemePaint.setColor(-1052689);
        this.mCurDayTextPaint.setAntiAlias(true);
        this.mCurDayTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayTextPaint.setColor(-65536);
        this.mCurDayTextPaint.setFakeBoldText(true);
        this.mCurDayTextPaint.setTextSize((float)CalendarUtil.dipToPx((Context)context, (float)14.0f));
        this.mCurDayLunarTextPaint.setAntiAlias(true);
        this.mCurDayLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayLunarTextPaint.setColor(-65536);
        this.mCurDayLunarTextPaint.setFakeBoldText(true);
        this.mCurDayLunarTextPaint.setTextSize((float)CalendarUtil.dipToPx((Context)context, (float)14.0f));
        this.mSelectedPaint.setAntiAlias(true);
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setStrokeWidth(2.0f);
        this.setOnClickListener(this);
        this.setOnLongClickListener(this);
    }

    final void addSchemesFromMap() {
        if (this.mDelegate.mSchemeDatesMap == null) return;
        if (this.mDelegate.mSchemeDatesMap.size() == 0) {
            return;
        }
        Iterator<Calendar> iterator = this.mItems.iterator();
        while (iterator.hasNext()) {
            Calendar calendar = iterator.next();
            if (this.mDelegate.mSchemeDatesMap.containsKey(calendar.toString())) {
                Calendar calendar2 = (Calendar)this.mDelegate.mSchemeDatesMap.get(calendar.toString());
                String string = TextUtils.isEmpty((CharSequence)calendar2.getScheme()) ? this.mDelegate.getSchemeText() : calendar2.getScheme();
                calendar.setScheme(string);
                calendar.setSchemeColor(calendar2.getSchemeColor());
                calendar.setSchemes(calendar2.getSchemes());
                continue;
            }
            calendar.setScheme("");
            calendar.setSchemeColor(0);
            calendar.setSchemes(null);
        }
    }

    protected void initPaint() {
    }

    protected final boolean isInRange(Calendar calendar) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        boolean bl = calendarViewDelegate != null && CalendarUtil.isCalendarInRange((Calendar)calendar, (CalendarViewDelegate)calendarViewDelegate);
        return bl;
    }

    protected boolean isSelected(Calendar calendar) {
        List<Calendar> list = this.mItems;
        boolean bl = list != null && list.indexOf(calendar) == this.mCurrentItem;
        return bl;
    }

    protected final boolean onCalendarIntercept(Calendar calendar) {
        boolean bl = this.mDelegate.mCalendarInterceptListener != null && this.mDelegate.mCalendarInterceptListener.onCalendarIntercept(calendar);
        return bl;
    }

    protected abstract void onDestroy();

    protected void onPreviewHook() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getPointerCount();
        boolean bl = false;
        if (n > 1) {
            return false;
        }
        n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1) {
                if (n != 2) return super.onTouchEvent(motionEvent);
                if (!this.isClick) return super.onTouchEvent(motionEvent);
                if (Math.abs(motionEvent.getY() - this.mY) <= 50.0f) {
                    bl = true;
                }
                this.isClick = bl;
            } else {
                this.mX = motionEvent.getX();
                this.mY = motionEvent.getY();
            }
        } else {
            this.mX = motionEvent.getX();
            this.mY = motionEvent.getY();
            this.isClick = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    final void removeSchemes() {
        Iterator<Calendar> iterator = this.mItems.iterator();
        while (iterator.hasNext()) {
            Calendar calendar = iterator.next();
            calendar.setScheme("");
            calendar.setSchemeColor(0);
            calendar.setSchemes(null);
        }
    }

    final void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        this.updateStyle();
        this.updateItemHeight();
        this.initPaint();
    }

    final void update() {
        if (this.mDelegate.mSchemeDatesMap != null && this.mDelegate.mSchemeDatesMap.size() != 0) {
            this.addSchemesFromMap();
            this.invalidate();
            return;
        }
        this.removeSchemes();
        this.invalidate();
    }

    abstract void updateCurrentDate();

    void updateItemHeight() {
        this.mItemHeight = this.mDelegate.getCalendarItemHeight();
        Paint.FontMetrics fontMetrics = this.mCurMonthTextPaint.getFontMetrics();
        this.mTextBaseLine = (float)(this.mItemHeight / 2) - fontMetrics.descent + (fontMetrics.bottom - fontMetrics.top) / 2.0f;
    }

    final void updateStyle() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) {
            return;
        }
        this.mCurDayTextPaint.setColor(calendarViewDelegate.getCurDayTextColor());
        this.mCurDayLunarTextPaint.setColor(this.mDelegate.getCurDayLunarTextColor());
        this.mCurMonthTextPaint.setColor(this.mDelegate.getCurrentMonthTextColor());
        this.mOtherMonthTextPaint.setColor(this.mDelegate.getOtherMonthTextColor());
        this.mCurMonthLunarTextPaint.setColor(this.mDelegate.getCurrentMonthLunarTextColor());
        this.mSelectedLunarTextPaint.setColor(this.mDelegate.getSelectedLunarTextColor());
        this.mSelectTextPaint.setColor(this.mDelegate.getSelectedTextColor());
        this.mOtherMonthLunarTextPaint.setColor(this.mDelegate.getOtherMonthLunarTextColor());
        this.mSchemeLunarTextPaint.setColor(this.mDelegate.getSchemeLunarTextColor());
        this.mSchemePaint.setColor(this.mDelegate.getSchemeThemeColor());
        this.mSchemeTextPaint.setColor(this.mDelegate.getSchemeTextColor());
        this.mCurMonthTextPaint.setTextSize((float)this.mDelegate.getDayTextSize());
        this.mOtherMonthTextPaint.setTextSize((float)this.mDelegate.getDayTextSize());
        this.mCurDayTextPaint.setTextSize((float)this.mDelegate.getDayTextSize());
        this.mSchemeTextPaint.setTextSize((float)this.mDelegate.getDayTextSize());
        this.mSelectTextPaint.setTextSize((float)this.mDelegate.getDayTextSize());
        this.mCurMonthLunarTextPaint.setTextSize((float)this.mDelegate.getLunarTextSize());
        this.mSelectedLunarTextPaint.setTextSize((float)this.mDelegate.getLunarTextSize());
        this.mCurDayLunarTextPaint.setTextSize((float)this.mDelegate.getLunarTextSize());
        this.mOtherMonthLunarTextPaint.setTextSize((float)this.mDelegate.getLunarTextSize());
        this.mSchemeLunarTextPaint.setTextSize((float)this.mDelegate.getLunarTextSize());
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setColor(this.mDelegate.getSelectedThemeColor());
    }
}
