/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.animation.LinearInterpolator
 *  android.widget.AbsListView
 *  android.widget.LinearLayout
 *  androidx.core.view.MotionEventCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  com.haibin.calendarview.Calendar
 *  com.haibin.calendarview.CalendarLayout$CalendarScrollView
 *  com.haibin.calendarview.CalendarUtil
 *  com.haibin.calendarview.CalendarView
 *  com.haibin.calendarview.CalendarViewDelegate
 *  com.haibin.calendarview.MonthViewPager
 *  com.haibin.calendarview.R$id
 *  com.haibin.calendarview.R$styleable
 *  com.haibin.calendarview.WeekBar
 *  com.haibin.calendarview.WeekViewPager
 *  com.haibin.calendarview.YearViewPager
 */
package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarUtil;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.CalendarViewDelegate;
import com.haibin.calendarview.MonthViewPager;
import com.haibin.calendarview.R;
import com.haibin.calendarview.WeekBar;
import com.haibin.calendarview.WeekViewPager;
import com.haibin.calendarview.YearViewPager;

public class CalendarLayout
extends LinearLayout {
    private static final int ACTIVE_POINTER = 1;
    private static final int CALENDAR_SHOW_MODE_BOTH_MONTH_WEEK_VIEW = 0;
    private static final int CALENDAR_SHOW_MODE_ONLY_MONTH_VIEW = 2;
    private static final int CALENDAR_SHOW_MODE_ONLY_WEEK_VIEW = 1;
    private static final int GESTURE_MODE_DEFAULT = 0;
    private static final int GESTURE_MODE_DISABLED = 2;
    private static final int INVALID_POINTER = -1;
    private static final int STATUS_EXPAND = 0;
    private static final int STATUS_SHRINK = 1;
    private float downY;
    private boolean isAnimating = false;
    private boolean isWeekView;
    private int mActivePointerId;
    private int mCalendarShowMode;
    CalendarView mCalendarView;
    ViewGroup mContentView;
    private int mContentViewId;
    private int mContentViewTranslateY;
    private int mDefaultStatus;
    private CalendarViewDelegate mDelegate;
    private int mGestureMode;
    private int mItemHeight;
    private float mLastY;
    private int mMaximumVelocity;
    MonthViewPager mMonthView;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int mViewPagerTranslateY = 0;
    WeekBar mWeekBar;
    WeekViewPager mWeekPager;
    YearViewPager mYearView;

    public CalendarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setOrientation(1);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.CalendarLayout);
        this.mContentViewId = attributeSet.getResourceId(R.styleable.CalendarLayout_calendar_content_view_id, 0);
        this.mDefaultStatus = attributeSet.getInt(R.styleable.CalendarLayout_default_status, 0);
        this.mCalendarShowMode = attributeSet.getInt(R.styleable.CalendarLayout_calendar_show_mode, 0);
        this.mGestureMode = attributeSet.getInt(R.styleable.CalendarLayout_gesture_mode, 0);
        attributeSet.recycle();
        this.mVelocityTracker = VelocityTracker.obtain();
        context = ViewConfiguration.get((Context)context);
        this.mTouchSlop = context.getScaledTouchSlop();
        this.mMaximumVelocity = context.getScaledMaximumFlingVelocity();
    }

    static /* synthetic */ int access$000(CalendarLayout calendarLayout) {
        return calendarLayout.mContentViewTranslateY;
    }

    static /* synthetic */ int access$100(CalendarLayout calendarLayout) {
        return calendarLayout.mViewPagerTranslateY;
    }

    static /* synthetic */ boolean access$202(CalendarLayout calendarLayout, boolean bl) {
        calendarLayout.isAnimating = bl;
        return bl;
    }

    static /* synthetic */ int access$300(CalendarLayout calendarLayout) {
        return calendarLayout.mGestureMode;
    }

    static /* synthetic */ void access$400(CalendarLayout calendarLayout, boolean bl) {
        calendarLayout.hideWeek(bl);
    }

    static /* synthetic */ CalendarViewDelegate access$500(CalendarLayout calendarLayout) {
        return calendarLayout.mDelegate;
    }

    static /* synthetic */ boolean access$600(CalendarLayout calendarLayout) {
        return calendarLayout.isWeekView;
    }

    static /* synthetic */ boolean access$602(CalendarLayout calendarLayout, boolean bl) {
        calendarLayout.isWeekView = bl;
        return bl;
    }

    static /* synthetic */ void access$700(CalendarLayout calendarLayout) {
        calendarLayout.showWeek();
    }

    private int getCalendarViewHeight() {
        int n;
        int n2;
        if (this.mMonthView.getVisibility() == 0) {
            n2 = this.mDelegate.getWeekBarHeight();
            n = this.mMonthView.getHeight();
        } else {
            n2 = this.mDelegate.getWeekBarHeight();
            n = this.mDelegate.getCalendarItemHeight();
        }
        return n2 + n;
    }

    private int getPointerIndex(MotionEvent motionEvent, int n) {
        if ((n = MotionEventCompat.findPointerIndex((MotionEvent)motionEvent, (int)n)) != -1) return n;
        this.mActivePointerId = -1;
        return n;
    }

    private void hideWeek(boolean bl) {
        if (bl) {
            this.onShowMonthView();
        }
        this.mWeekPager.setVisibility(8);
        this.mMonthView.setVisibility(0);
    }

    private void initCalendarPosition(Calendar calendar) {
        this.updateSelectPosition(CalendarUtil.getMonthViewStartDiff((Calendar)calendar, (int)this.mDelegate.getWeekStart()) + calendar.getDay() - 1);
    }

    private void onShowMonthView() {
        if (this.mMonthView.getVisibility() == 0) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) return;
        if (calendarViewDelegate.mViewChangeListener == null) return;
        if (!this.isWeekView) return;
        this.mDelegate.mViewChangeListener.onViewChange(true);
    }

    private void onShowWeekView() {
        if (this.mWeekPager.getVisibility() == 0) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) return;
        if (calendarViewDelegate.mViewChangeListener == null) return;
        if (this.isWeekView) return;
        this.mDelegate.mViewChangeListener.onViewChange(false);
    }

    private void showWeek() {
        this.onShowWeekView();
        this.mWeekPager.getAdapter().notifyDataSetChanged();
        this.mWeekPager.setVisibility(0);
        this.mMonthView.setVisibility(4);
    }

    private void translationViewPager() {
        float f = this.mContentView.getTranslationY() * 1.0f / (float)this.mContentViewTranslateY;
        this.mMonthView.setTranslationY((float)this.mViewPagerTranslateY * f);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.mGestureMode == 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.mYearView == null) return super.dispatchTouchEvent(motionEvent);
        CalendarView calendarView = this.mCalendarView;
        if (calendarView == null) return super.dispatchTouchEvent(motionEvent);
        if (calendarView.getVisibility() == 8) return super.dispatchTouchEvent(motionEvent);
        calendarView = this.mContentView;
        if (calendarView == null) return super.dispatchTouchEvent(motionEvent);
        if (calendarView.getVisibility() != 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int n = this.mCalendarShowMode;
        if (n == 2) return super.dispatchTouchEvent(motionEvent);
        if (n == 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.mYearView.getVisibility() == 0) return super.dispatchTouchEvent(motionEvent);
        if (this.mDelegate.isShowYearSelectedLayout) {
            return super.dispatchTouchEvent(motionEvent);
        }
        n = motionEvent.getAction();
        float f = motionEvent.getY();
        if (n != 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!(f - this.mLastY > 0.0f)) return super.dispatchTouchEvent(motionEvent);
        if (this.mContentView.getTranslationY() != (float)(-this.mContentViewTranslateY)) return super.dispatchTouchEvent(motionEvent);
        if (!this.isScrollTop()) return super.dispatchTouchEvent(motionEvent);
        this.requestDisallowInterceptTouchEvent(false);
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean expand() {
        return this.expand(240);
    }

    public boolean expand(int n) {
        if (this.isAnimating) return false;
        if (this.mCalendarShowMode == 1) return false;
        if (this.mContentView == null) {
            return false;
        }
        if (this.mMonthView.getVisibility() != 0) {
            this.mWeekPager.setVisibility(8);
            this.onShowMonthView();
            this.isWeekView = false;
            this.mMonthView.setVisibility(0);
        }
        ViewGroup viewGroup = this.mContentView;
        viewGroup = ObjectAnimator.ofFloat((Object)viewGroup, (String)"translationY", (float[])new float[]{viewGroup.getTranslationY(), 0.0f});
        viewGroup.setDuration((long)n);
        viewGroup.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        viewGroup.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        viewGroup.start();
        return true;
    }

    public void hideCalendarView() {
        CalendarView calendarView = this.mCalendarView;
        if (calendarView == null) {
            return;
        }
        calendarView.setVisibility(8);
        if (!this.isExpand()) {
            this.expand(0);
        }
        this.requestLayout();
    }

    final void hideContentView() {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup == null) {
            return;
        }
        viewGroup.animate().translationY((float)(this.getHeight() - this.mMonthView.getHeight())).setDuration(220L).setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    final void initStatus() {
        if ((this.mDefaultStatus == 1 || this.mCalendarShowMode == 1) && this.mCalendarShowMode != 2) {
            if (this.mContentView == null) {
                this.mWeekPager.setVisibility(0);
                this.mMonthView.setVisibility(8);
                return;
            }
            this.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            if (this.mDelegate.mViewChangeListener == null) {
                return;
            }
            this.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public final boolean isExpand() {
        boolean bl = this.mMonthView.getVisibility() == 0;
        return bl;
    }

    protected boolean isScrollTop() {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup instanceof CalendarScrollView) {
            return ((CalendarScrollView)viewGroup).isScrollToTop();
        }
        boolean bl = viewGroup instanceof RecyclerView;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        boolean bl5 = false;
        if (bl) {
            if (((RecyclerView)viewGroup).computeVerticalScrollOffset() == 0) return bl4;
            bl4 = false;
            return bl4;
        }
        if (viewGroup instanceof AbsListView) {
            viewGroup = (AbsListView)viewGroup;
            bl4 = bl5;
            if (viewGroup.getFirstVisiblePosition() != 0) return bl4;
            bl4 = viewGroup.getChildAt(0).getTop() == 0 ? bl2 : false;
            return bl4;
        }
        bl4 = viewGroup.getScrollY() == 0 ? bl3 : false;
        return bl4;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mMonthView = (MonthViewPager)this.findViewById(R.id.vp_month);
        this.mWeekPager = (WeekViewPager)this.findViewById(R.id.vp_week);
        if (this.getChildCount() > 0) {
            this.mCalendarView = (CalendarView)this.getChildAt(0);
        }
        this.mContentView = (ViewGroup)this.findViewById(this.mContentViewId);
        this.mYearView = (YearViewPager)this.findViewById(R.id.selectLayout);
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup == null) return;
        viewGroup.setOverScrollMode(2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating) {
            return true;
        }
        if (this.mGestureMode == 2) {
            return false;
        }
        if (this.mYearView == null) return super.onInterceptTouchEvent(motionEvent);
        CalendarView calendarView = this.mCalendarView;
        if (calendarView == null) return super.onInterceptTouchEvent(motionEvent);
        if (calendarView.getVisibility() == 8) return super.onInterceptTouchEvent(motionEvent);
        calendarView = this.mContentView;
        if (calendarView == null) return super.onInterceptTouchEvent(motionEvent);
        if (calendarView.getVisibility() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int n = this.mCalendarShowMode;
        if (n == 2) return false;
        if (n == 1) {
            return false;
        }
        if (this.mYearView.getVisibility() == 0) return super.onInterceptTouchEvent(motionEvent);
        if (this.mDelegate.isShowYearSelectedLayout) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        n = motionEvent.getAction();
        float f = motionEvent.getY();
        if (n != 0) {
            if (n != 2) return super.onInterceptTouchEvent(motionEvent);
            float f2 = f - this.mLastY;
            if (f2 < 0.0f && this.mContentView.getTranslationY() == (float)(-this.mContentViewTranslateY)) {
                return false;
            }
            if (f2 > 0.0f && this.mContentView.getTranslationY() == (float)(-this.mContentViewTranslateY) && f >= (float)(this.mDelegate.getCalendarItemHeight() + this.mDelegate.getWeekBarHeight()) && !this.isScrollTop()) {
                return false;
            }
            if (f2 > 0.0f && this.mContentView.getTranslationY() == 0.0f && f >= (float)CalendarUtil.dipToPx((Context)this.getContext(), (float)98.0f)) {
                return false;
            }
            if (!(Math.abs(f2) > (float)this.mTouchSlop)) return super.onInterceptTouchEvent(motionEvent);
            if (!(f2 > 0.0f) || !(this.mContentView.getTranslationY() <= 0.0f)) {
                if (!(f2 < 0.0f)) return super.onInterceptTouchEvent(motionEvent);
                if (!(this.mContentView.getTranslationY() >= (float)(-this.mContentViewTranslateY))) return super.onInterceptTouchEvent(motionEvent);
            }
            this.mLastY = f;
            return true;
        }
        this.mActivePointerId = MotionEventCompat.getPointerId((MotionEvent)motionEvent, (int)MotionEventCompat.getActionIndex((MotionEvent)motionEvent));
        this.downY = f;
        this.mLastY = f;
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected void onMeasure(int n, int n2) {
        if (this.mContentView != null && this.mCalendarView != null) {
            int n3 = this.mDelegate.mIndexCalendar.getYear();
            int n4 = this.mDelegate.mIndexCalendar.getMonth();
            int n5 = CalendarUtil.dipToPx((Context)this.getContext(), (float)1.0f) + this.mDelegate.getWeekBarHeight();
            int n6 = CalendarUtil.getMonthViewHeight((int)n3, (int)n4, (int)this.mDelegate.getCalendarItemHeight(), (int)this.mDelegate.getWeekStart(), (int)this.mDelegate.getMonthViewShowMode()) + n5;
            int n7 = View.MeasureSpec.getSize((int)n2);
            if (this.mDelegate.isFullScreenCalendar()) {
                super.onMeasure(n, n2);
                n2 = View.MeasureSpec.makeMeasureSpec((int)(n7 - n5 - this.mDelegate.getCalendarItemHeight()), (int)0x40000000);
                this.mContentView.measure(n, n2);
                ViewGroup viewGroup = this.mContentView;
                viewGroup.layout(viewGroup.getLeft(), this.mContentView.getTop(), this.mContentView.getRight(), this.mContentView.getBottom());
                return;
            }
            if (n6 >= n7 && this.mMonthView.getHeight() > 0) {
                n3 = View.MeasureSpec.makeMeasureSpec((int)(n6 + n5 + this.mDelegate.getWeekBarHeight()), (int)0x40000000);
                n4 = n6;
            } else {
                n4 = n7;
                n3 = n2;
                if (n6 < n7) {
                    n4 = n7;
                    n3 = n2;
                    if (this.mMonthView.getHeight() > 0) {
                        n3 = View.MeasureSpec.makeMeasureSpec((int)n7, (int)0x40000000);
                        n4 = n7;
                    }
                }
            }
            if (this.mCalendarShowMode != 2 && this.mCalendarView.getVisibility() != 8) {
                if (this.mGestureMode == 2 && !this.isAnimating) {
                    if (this.isExpand()) {
                        n2 = n6;
                    } else {
                        n4 -= n5;
                        n2 = this.mItemHeight;
                    }
                } else {
                    n4 -= n5;
                    n2 = this.mItemHeight;
                }
            } else {
                n2 = this.mCalendarView.getVisibility() == 8 ? 0 : this.mCalendarView.getHeight();
            }
            super.onMeasure(n, n3);
            n2 = View.MeasureSpec.makeMeasureSpec((int)(n4 - n2), (int)0x40000000);
            this.mContentView.measure(n, n2);
            ViewGroup viewGroup = this.mContentView;
            viewGroup.layout(viewGroup.getLeft(), this.mContentView.getTop(), this.mContentView.getRight(), this.mContentView.getBottom());
            return;
        }
        super.onMeasure(n, n2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle)parcelable;
        parcelable = bundle.getParcelable("super");
        if (bundle.getBoolean("isExpand")) {
            this.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            this.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putBoolean("isExpand", this.isExpand());
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        block20: {
            float f;
            CalendarView calendarView;
            block16: {
                float f2;
                float f3;
                int n;
                block17: {
                    block18: {
                        block19: {
                            if (this.mDelegate.isShowYearSelectedLayout) {
                                return false;
                            }
                            if (this.mContentView == null) return false;
                            calendarView = this.mCalendarView;
                            if (calendarView == null) return false;
                            if (calendarView.getVisibility() == 8) {
                                return false;
                            }
                            n = motionEvent.getAction();
                            f = motionEvent.getY();
                            this.mVelocityTracker.addMovement(motionEvent);
                            if (n == 0) {
                                this.mActivePointerId = MotionEventCompat.getPointerId((MotionEvent)motionEvent, (int)MotionEventCompat.getActionIndex((MotionEvent)motionEvent));
                                this.downY = f;
                                this.mLastY = f;
                                return true;
                            }
                            if (n == 1) break block16;
                            if (n == 2) break block17;
                            if (n == 3) break block18;
                            if (n == 5) break block19;
                            if (n == 6) break block18;
                            break block20;
                        }
                        this.mActivePointerId = n = MotionEventCompat.getPointerId((MotionEvent)motionEvent, (int)MotionEventCompat.getActionIndex((MotionEvent)motionEvent));
                        if (n != 0) return super.onTouchEvent(motionEvent);
                        this.mLastY = MotionEventCompat.getY((MotionEvent)motionEvent, (int)n);
                        break block20;
                    }
                    n = this.getPointerIndex(motionEvent, this.mActivePointerId);
                    if (this.mActivePointerId == -1) return super.onTouchEvent(motionEvent);
                    this.mLastY = MotionEventCompat.getY((MotionEvent)motionEvent, (int)n);
                    break block20;
                }
                if (this.mGestureMode == 2) return false;
                n = this.mCalendarShowMode;
                if (n == 2) return false;
                if (n == 1) {
                    return false;
                }
                this.getPointerIndex(motionEvent, this.mActivePointerId);
                if (this.mActivePointerId == -1) {
                    this.mLastY = f;
                    this.mActivePointerId = 1;
                }
                if ((f3 = f - this.mLastY) < 0.0f && this.mContentView.getTranslationY() == (float)(-this.mContentViewTranslateY)) {
                    this.mLastY = f;
                    motionEvent.setAction(0);
                    this.dispatchTouchEvent(motionEvent);
                    this.mWeekPager.setVisibility(0);
                    this.mMonthView.setVisibility(4);
                    if (!this.isWeekView && this.mDelegate.mViewChangeListener != null) {
                        this.mDelegate.mViewChangeListener.onViewChange(false);
                    }
                    this.isWeekView = true;
                    return false;
                }
                this.hideWeek(false);
                if (f3 > 0.0f && this.mContentView.getTranslationY() + f3 >= 0.0f) {
                    this.mContentView.setTranslationY(0.0f);
                    this.translationViewPager();
                    this.mLastY = f;
                    return super.onTouchEvent(motionEvent);
                }
                if (f3 < 0.0f && (f2 = this.mContentView.getTranslationY()) + f3 <= (float)(-(n = this.mContentViewTranslateY))) {
                    this.mContentView.setTranslationY((float)(-n));
                    this.translationViewPager();
                    this.mLastY = f;
                    return super.onTouchEvent(motionEvent);
                }
                calendarView = this.mContentView;
                calendarView.setTranslationY(calendarView.getTranslationY() + f3);
                this.translationViewPager();
                this.mLastY = f;
                break block20;
            }
            calendarView = this.mVelocityTracker;
            calendarView.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
            f = calendarView.getYVelocity();
            if (this.mContentView.getTranslationY() != 0.0f && this.mContentView.getTranslationY() != (float)this.mContentViewTranslateY) {
                if (Math.abs(f) >= 800.0f) {
                    if (f < 0.0f) {
                        this.shrink();
                    } else {
                        this.expand();
                    }
                    return super.onTouchEvent(motionEvent);
                }
                if (motionEvent.getY() - this.downY > 0.0f) {
                    this.expand();
                } else {
                    this.shrink();
                }
            } else {
                this.expand();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setModeBothMonthWeekView() {
        this.mCalendarShowMode = 0;
        this.requestLayout();
    }

    public void setModeOnlyMonthView() {
        this.mCalendarShowMode = 2;
        this.requestLayout();
    }

    public void setModeOnlyWeekView() {
        this.mCalendarShowMode = 1;
        this.requestLayout();
    }

    final void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        this.mItemHeight = calendarViewDelegate.getCalendarItemHeight();
        calendarViewDelegate = calendarViewDelegate.mSelectedCalendar.isAvailable() ? calendarViewDelegate.mSelectedCalendar : calendarViewDelegate.createCurrentDate();
        this.initCalendarPosition((Calendar)calendarViewDelegate);
        this.updateContentViewTranslateY();
    }

    public void showCalendarView() {
        this.mCalendarView.setVisibility(0);
        this.requestLayout();
    }

    final void showContentView() {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setTranslationY((float)(this.getHeight() - this.mMonthView.getHeight()));
        this.mContentView.setVisibility(0);
        this.mContentView.animate().translationY(0.0f).setDuration(180L).setInterpolator((TimeInterpolator)new LinearInterpolator()).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean shrink() {
        return this.shrink(240);
    }

    public boolean shrink(int n) {
        if (this.mGestureMode == 2) {
            this.requestLayout();
        }
        if (this.isAnimating) return false;
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup == null) {
            return false;
        }
        viewGroup = ObjectAnimator.ofFloat((Object)viewGroup, (String)"translationY", (float[])new float[]{viewGroup.getTranslationY(), -this.mContentViewTranslateY});
        viewGroup.setDuration((long)n);
        viewGroup.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        viewGroup.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        viewGroup.start();
        return true;
    }

    final void updateCalendarItemHeight() {
        this.mItemHeight = this.mDelegate.getCalendarItemHeight();
        if (this.mContentView == null) {
            return;
        }
        Calendar calendar = this.mDelegate.mIndexCalendar;
        this.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth((Calendar)calendar, (int)this.mDelegate.getWeekStart()));
        this.mContentViewTranslateY = this.mDelegate.getMonthViewShowMode() == 0 ? this.mItemHeight * 5 : CalendarUtil.getMonthViewHeight((int)calendar.getYear(), (int)calendar.getMonth(), (int)this.mItemHeight, (int)this.mDelegate.getWeekStart()) - this.mItemHeight;
        this.translationViewPager();
        if (this.mWeekPager.getVisibility() != 0) return;
        this.mContentView.setTranslationY((float)(-this.mContentViewTranslateY));
    }

    void updateContentViewTranslateY() {
        Calendar calendar = this.mDelegate.mIndexCalendar;
        this.mContentViewTranslateY = this.mDelegate.getMonthViewShowMode() == 0 ? this.mItemHeight * 5 : CalendarUtil.getMonthViewHeight((int)calendar.getYear(), (int)calendar.getMonth(), (int)this.mItemHeight, (int)this.mDelegate.getWeekStart()) - this.mItemHeight;
        if (this.mWeekPager.getVisibility() != 0) return;
        calendar = this.mContentView;
        if (calendar == null) {
            return;
        }
        calendar.setTranslationY((float)(-this.mContentViewTranslateY));
    }

    final void updateSelectPosition(int n) {
        this.mViewPagerTranslateY = ((n + 7) / 7 - 1) * this.mItemHeight;
    }

    final void updateSelectWeek(int n) {
        this.mViewPagerTranslateY = (n - 1) * this.mItemHeight;
    }
}
