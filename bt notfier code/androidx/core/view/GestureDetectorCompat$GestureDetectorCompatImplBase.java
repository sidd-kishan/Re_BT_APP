/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 *  androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
 *  androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler
 */
package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.view.GestureDetectorCompat;

static class GestureDetectorCompat.GestureDetectorCompatImplBase
implements GestureDetectorCompat.GestureDetectorCompatImpl {
    private static final int DOUBLE_TAP_TIMEOUT;
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private static final int TAP_TIMEOUT;
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    MotionEvent mCurrentDownEvent;
    boolean mDeferConfirmSingleTap;
    GestureDetector.OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    final GestureDetector.OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;

    static {
        TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    }

    GestureDetectorCompat.GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.mHandler = handler != null ? new GestureHandler(this, handler) : new GestureHandler(this);
        this.mListener = onGestureListener;
        if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
            this.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)onGestureListener);
        }
        this.init(context);
    }

    private void cancel() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        if (!this.mInLongPress) return;
        this.mInLongPress = false;
    }

    private void cancelTaps() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mIsDoubleTapping = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        if (!this.mInLongPress) return;
        this.mInLongPress = false;
    }

    private void init(Context context) {
        if (context == null) throw new IllegalArgumentException("Context must not be null");
        if (this.mListener == null) throw new IllegalArgumentException("OnGestureListener must not be null");
        this.mIsLongpressEnabled = true;
        context = ViewConfiguration.get((Context)context);
        int n = context.getScaledTouchSlop();
        int n2 = context.getScaledDoubleTapSlop();
        this.mMinimumFlingVelocity = context.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = context.getScaledMaximumFlingVelocity();
        this.mTouchSlopSquare = n * n;
        this.mDoubleTapSlopSquare = n2 * n2;
    }

    private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        int n;
        boolean bl = this.mAlwaysInBiggerTapRegion;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        if (motionEvent3.getEventTime() - motionEvent2.getEventTime() > (long)DOUBLE_TAP_TIMEOUT) {
            return false;
        }
        int n2 = (int)motionEvent.getX() - (int)motionEvent3.getX();
        if (n2 * n2 + (n = (int)motionEvent.getY() - (int)motionEvent3.getY()) * n >= this.mDoubleTapSlopSquare) return bl2;
        bl2 = true;
        return bl2;
    }

    void dispatchLongPress() {
        this.mHandler.removeMessages(3);
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = true;
        this.mListener.onLongPress(this.mCurrentDownEvent);
    }

    public boolean isLongpressEnabled() {
        return this.mIsLongpressEnabled;
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block31: {
            block30: {
                block25: {
                    block33: {
                        block34: {
                            block32: {
                                block26: {
                                    block27: {
                                        block28: {
                                            block29: {
                                                var6_2 = var1_1.getAction();
                                                if (this.mVelocityTracker == null) {
                                                    this.mVelocityTracker = VelocityTracker.obtain();
                                                }
                                                this.mVelocityTracker.addMovement(var1_1);
                                                var10_3 = var6_2 & 255;
                                                var12_4 = 0;
                                                var6_2 = var10_3 == 6 ? 1 : 0;
                                                var7_5 = var6_2 != 0 ? var1_1.getActionIndex() : -1;
                                                var9_6 = var1_1.getPointerCount();
                                                var3_8 = 0.0f;
                                                var2_9 = 0.0f;
                                                for (var8_7 = 0; var8_7 < var9_6; ++var8_7) {
                                                    if (var7_5 == var8_7) continue;
                                                    var3_8 += var1_1.getX(var8_7);
                                                    var2_9 += var1_1.getY(var8_7);
                                                }
                                                var6_2 = var6_2 != 0 ? var9_6 - 1 : var9_6;
                                                var4_10 = var6_2;
                                                var3_8 /= var4_10;
                                                var2_9 /= var4_10;
                                                if (var10_3 == 0) break block25;
                                                if (var10_3 == 1) break block26;
                                                if (var10_3 == 2) break block27;
                                                if (var10_3 == 3) break block28;
                                                if (var10_3 == 5) break block29;
                                                if (var10_3 == 6) break block30;
                                                var11_11 = var12_4;
                                                break block31;
                                            }
                                            this.mLastFocusX = var3_8;
                                            this.mDownFocusX = var3_8;
                                            this.mLastFocusY = var2_9;
                                            this.mDownFocusY = var2_9;
                                            this.cancelTaps();
                                            var11_11 = var12_4;
                                            break block31;
                                        }
                                        this.cancel();
                                        var11_11 = var12_4;
                                        break block31;
                                    }
                                    if (this.mInLongPress) {
                                        var11_11 = var12_4;
                                    } else {
                                        var4_10 = this.mLastFocusX - var3_8;
                                        var5_12 = this.mLastFocusY - var2_9;
                                        if (this.mIsDoubleTapping) {
                                            var11_11 = 0 | this.mDoubleTapListener.onDoubleTapEvent(var1_1);
                                        } else if (this.mAlwaysInTapRegion) {
                                            var6_2 = (int)(var3_8 - this.mDownFocusX);
                                            var7_5 = (int)(var2_9 - this.mDownFocusY);
                                            if ((var6_2 = var6_2 * var6_2 + var7_5 * var7_5) > this.mTouchSlopSquare) {
                                                var12_4 = this.mListener.onScroll(this.mCurrentDownEvent, var1_1, var4_10, var5_12);
                                                this.mLastFocusX = var3_8;
                                                this.mLastFocusY = var2_9;
                                                this.mAlwaysInTapRegion = false;
                                                this.mHandler.removeMessages(3);
                                                this.mHandler.removeMessages(1);
                                                this.mHandler.removeMessages(2);
                                            } else {
                                                var12_4 = 0;
                                            }
                                            var11_11 = var12_4;
                                            if (var6_2 <= this.mTouchSlopSquare) return (boolean)var11_11;
                                            this.mAlwaysInBiggerTapRegion = false;
                                            var11_11 = var12_4;
                                        } else {
                                            if (!(Math.abs(var4_10) >= 1.0f)) {
                                                var11_11 = var12_4;
                                                if (!(Math.abs(var5_12) >= 1.0f)) return (boolean)var11_11;
                                            }
                                            var11_11 = this.mListener.onScroll(this.mCurrentDownEvent, var1_1, var4_10, var5_12);
                                            this.mLastFocusX = var3_8;
                                            this.mLastFocusY = var2_9;
                                        }
                                    }
                                    break block31;
                                }
                                this.mStillDown = false;
                                var13_13 = MotionEvent.obtain((MotionEvent)var1_1);
                                if (!this.mIsDoubleTapping) break block32;
                                var11_11 = this.mDoubleTapListener.onDoubleTapEvent(var1_1) | 0;
                                break block33;
                            }
                            if (!this.mInLongPress) break block34;
                            this.mHandler.removeMessages(3);
                            this.mInLongPress = false;
                            ** GOTO lbl-1000
                        }
                        if (this.mAlwaysInTapRegion) {
                            var11_11 = this.mListener.onSingleTapUp(var1_1);
                            if (this.mDeferConfirmSingleTap && (var14_15 = this.mDoubleTapListener) != null) {
                                var14_15.onSingleTapConfirmed(var1_1);
                            }
                        } else {
                            var14_16 = this.mVelocityTracker;
                            var6_2 = var1_1.getPointerId(0);
                            var14_16.computeCurrentVelocity(1000, (float)this.mMaximumFlingVelocity);
                            var3_8 = var14_16.getYVelocity(var6_2);
                            var2_9 = var14_16.getXVelocity(var6_2);
                            if (!(Math.abs(var3_8) > (float)this.mMinimumFlingVelocity) && !(Math.abs(var2_9) > (float)this.mMinimumFlingVelocity)) lbl-1000:
                            // 2 sources

                            {
                                var11_11 = 0;
                            } else {
                                var11_11 = this.mListener.onFling(this.mCurrentDownEvent, var1_1, var2_9, var3_8);
                            }
                        }
                    }
                    var1_1 = this.mPreviousUpEvent;
                    if (var1_1 != null) {
                        var1_1.recycle();
                    }
                    this.mPreviousUpEvent = var13_13;
                    var1_1 = this.mVelocityTracker;
                    if (var1_1 != null) {
                        var1_1.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    break block31;
                }
                if (this.mDoubleTapListener == null) ** GOTO lbl127
                var11_11 = this.mHandler.hasMessages(3);
                if (var11_11 != 0) {
                    this.mHandler.removeMessages(3);
                }
                if ((var14_17 = this.mCurrentDownEvent) != null && (var13_14 = this.mPreviousUpEvent) != null && var11_11 != 0 && this.isConsideredDoubleTap(var14_17, var13_14, var1_1)) {
                    this.mIsDoubleTapping = true;
                    var6_2 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(var1_1);
                } else {
                    this.mHandler.sendEmptyMessageDelayed(3, (long)GestureDetectorCompat.GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT);
lbl127:
                    // 2 sources

                    var6_2 = 0;
                }
                this.mLastFocusX = var3_8;
                this.mDownFocusX = var3_8;
                this.mLastFocusY = var2_9;
                this.mDownFocusY = var2_9;
                var13_14 = this.mCurrentDownEvent;
                if (var13_14 != null) {
                    var13_14.recycle();
                }
                this.mCurrentDownEvent = MotionEvent.obtain((MotionEvent)var1_1);
                this.mAlwaysInTapRegion = true;
                this.mAlwaysInBiggerTapRegion = true;
                this.mStillDown = true;
                this.mInLongPress = false;
                this.mDeferConfirmSingleTap = false;
                if (this.mIsLongpressEnabled) {
                    this.mHandler.removeMessages(2);
                    this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + (long)GestureDetectorCompat.GestureDetectorCompatImplBase.TAP_TIMEOUT + (long)ViewConfiguration.getLongPressTimeout());
                }
                this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + (long)GestureDetectorCompat.GestureDetectorCompatImplBase.TAP_TIMEOUT);
                var11_11 = var6_2 | this.mListener.onDown(var1_1);
                break block31;
            }
            this.mLastFocusX = var3_8;
            this.mDownFocusX = var3_8;
            this.mLastFocusY = var2_9;
            this.mDownFocusY = var2_9;
            this.mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaximumFlingVelocity);
            var7_5 = var1_1.getActionIndex();
            var6_2 = var1_1.getPointerId(var7_5);
            var3_8 = this.mVelocityTracker.getXVelocity(var6_2);
            var2_9 = this.mVelocityTracker.getYVelocity(var6_2);
            var6_2 = 0;
            while (true) {
                var11_11 = var12_4;
                if (var6_2 >= var9_6) return (boolean)var11_11;
                if (var6_2 != var7_5 && this.mVelocityTracker.getXVelocity(var8_7 = var1_1.getPointerId(var6_2)) * var3_8 + this.mVelocityTracker.getYVelocity(var8_7) * var2_9 < 0.0f) {
                    this.mVelocityTracker.clear();
                    var11_11 = var12_4;
                    break;
                }
                ++var6_2;
            }
        }
        return (boolean)var11_11;
    }

    public void setIsLongpressEnabled(boolean bl) {
        this.mIsLongpressEnabled = bl;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mDoubleTapListener = onDoubleTapListener;
    }
}
