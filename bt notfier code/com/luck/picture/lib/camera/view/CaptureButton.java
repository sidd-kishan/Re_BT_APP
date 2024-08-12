/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.view.MotionEvent
 *  android.view.View
 *  com.luck.picture.lib.camera.listener.CaptureListener
 *  com.luck.picture.lib.camera.view.CaptureButton$LongPressRunnable
 *  com.luck.picture.lib.camera.view.CaptureButton$RecordCountDownTimer
 *  com.luck.picture.lib.camera.view._$$Lambda$CaptureButton$PPHVqWJbpMVMrEg9aw38zQFWnDM
 *  com.luck.picture.lib.camera.view._$$Lambda$CaptureButton$WKIj1TQ1dZWPtd4Afg8Fh2N4yzo
 *  com.luck.picture.lib.camera.view._$$Lambda$CaptureButton$iiHYE_BWL14LIFcvXf3hzsLEtfs
 */
package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.luck.picture.lib.camera.listener.CaptureListener;
import com.luck.picture.lib.camera.view.CaptureButton;
import com.luck.picture.lib.camera.view._$;

public class CaptureButton
extends View {
    public static final int STATE_BAN = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LONG_PRESS = 3;
    public static final int STATE_PRESS = 2;
    public static final int STATE_RECORDERING = 4;
    private float button_inside_radius;
    private float button_outside_radius;
    private float button_radius;
    private int button_size;
    private int button_state;
    private CaptureListener captureLisenter;
    private float center_X;
    private float center_Y;
    private int duration;
    private float event_Y;
    private int inside_color = -1;
    private int inside_reduce_size;
    private boolean isTakeCamera = true;
    private LongPressRunnable longPressRunnable;
    private Paint mPaint;
    private int min_duration;
    private int outside_add_size;
    private int outside_color = -287515428;
    private float progress;
    private int progress_color = -300503530;
    private int recorded_time;
    private RectF rectF;
    private int state;
    private float strokeWidth;
    private RecordCountDownTimer timer;

    public CaptureButton(Context context) {
        super(context);
    }

    public CaptureButton(Context context, int n) {
        super(context);
        float f;
        this.button_size = n;
        this.button_radius = f = (float)n / 2.0f;
        this.button_outside_radius = f;
        this.button_inside_radius = f * 0.75f;
        this.strokeWidth = n / 15;
        this.outside_add_size = n /= 8;
        this.inside_reduce_size = n;
        context = new Paint();
        this.mPaint = context;
        context.setAntiAlias(true);
        this.progress = 0.0f;
        this.longPressRunnable = new LongPressRunnable(this, null);
        this.state = 1;
        this.button_state = 259;
        this.duration = 10000;
        this.min_duration = 1500;
        n = this.button_size;
        int n2 = this.outside_add_size;
        this.center_X = (n2 * 2 + n) / 2;
        this.center_Y = (n + n2 * 2) / 2;
        float f2 = this.center_X;
        float f3 = this.button_radius;
        n = this.outside_add_size;
        float f4 = n;
        f = this.strokeWidth;
        float f5 = f / 2.0f;
        float f6 = this.center_Y;
        this.rectF = new RectF(f2 - (f4 + f3 - f5), f6 - ((float)n + f3 - f / 2.0f), f2 + ((float)n + f3 - f / 2.0f), f6 + (f3 + (float)n - f / 2.0f));
        n = this.duration;
        this.timer = new RecordCountDownTimer(this, (long)n, (long)(n / 360));
    }

    static /* synthetic */ CaptureListener access$100(CaptureButton captureButton) {
        return captureButton.captureLisenter;
    }

    static /* synthetic */ int access$200(CaptureButton captureButton) {
        return captureButton.state;
    }

    static /* synthetic */ int access$202(CaptureButton captureButton, int n) {
        captureButton.state = n;
        return n;
    }

    static /* synthetic */ RecordCountDownTimer access$300(CaptureButton captureButton) {
        return captureButton.timer;
    }

    static /* synthetic */ void access$400(CaptureButton captureButton, long l) {
        captureButton.updateProgress(l);
    }

    static /* synthetic */ float access$500(CaptureButton captureButton) {
        return captureButton.button_outside_radius;
    }

    static /* synthetic */ int access$600(CaptureButton captureButton) {
        return captureButton.outside_add_size;
    }

    static /* synthetic */ float access$700(CaptureButton captureButton) {
        return captureButton.button_inside_radius;
    }

    static /* synthetic */ int access$800(CaptureButton captureButton) {
        return captureButton.inside_reduce_size;
    }

    static /* synthetic */ void access$900(CaptureButton captureButton, float f, float f2, float f3, float f4) {
        captureButton.startRecordAnimation(f, f2, f3, f4);
    }

    private void handlerPressByState() {
        this.removeCallbacks((Runnable)this.longPressRunnable);
        int n = this.state;
        if (n != 2) {
            if (n == 3 || n == 4) {
                this.timer.cancel();
                this.recordEnd();
            }
        } else if (this.captureLisenter != null && ((n = this.button_state) == 257 || n == 259)) {
            this.startCaptureAnimation(this.button_inside_radius);
        } else {
            this.state = 1;
        }
        this.state = 1;
    }

    private void resetRecordAnim() {
        this.state = 5;
        this.progress = 0.0f;
        this.invalidate();
        float f = this.button_outside_radius;
        float f2 = this.button_radius;
        this.startRecordAnimation(f, f2, this.button_inside_radius, 0.75f * f2);
    }

    private void startCaptureAnimation(float f) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{f, 0.75f * f, f});
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new _$.Lambda.CaptureButton.WKIj1TQ1dZWPtd4Afg8Fh2N4yzo(this));
        valueAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.setDuration(50L);
        valueAnimator.start();
    }

    private void startRecordAnimation(float f, float f2, float f3, float f4) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{f, f2});
        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat((float[])new float[]{f3, f4});
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new _$.Lambda.CaptureButton.PPHVqWJbpMVMrEg9aw38zQFWnDM(this));
        valueAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new _$.Lambda.CaptureButton.iiHYE_BWL14LIFcvXf3hzsLEtfs(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        animatorSet.playTogether(new Animator[]{valueAnimator, valueAnimator2});
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    private void updateProgress(long l) {
        int n = this.duration;
        this.recorded_time = (int)((long)n - l);
        this.progress = 360.0f - (float)l / (float)n * 360.0f;
        this.invalidate();
    }

    public int getButtonFeatures() {
        return this.button_state;
    }

    public boolean isIdle() {
        int n = this.state;
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    public /* synthetic */ void lambda$startCaptureAnimation$0$CaptureButton(ValueAnimator valueAnimator) {
        this.button_inside_radius = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        this.invalidate();
    }

    public /* synthetic */ void lambda$startRecordAnimation$1$CaptureButton(ValueAnimator valueAnimator) {
        this.button_outside_radius = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        this.invalidate();
    }

    public /* synthetic */ void lambda$startRecordAnimation$2$CaptureButton(ValueAnimator valueAnimator) {
        this.button_inside_radius = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        this.invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.outside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_outside_radius, this.mPaint);
        this.mPaint.setColor(this.inside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_inside_radius, this.mPaint);
        if (this.state != 4) return;
        this.mPaint.setColor(this.progress_color);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.strokeWidth);
        canvas.drawArc(this.rectF, -90.0f, this.progress, false, this.mPaint);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        n2 = this.button_size;
        n = this.outside_add_size;
        this.setMeasuredDimension(n * 2 + n2, n2 + n * 2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isTakeCamera) return true;
        int n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1) {
                if (n != 2) return true;
                if (this.captureLisenter == null) return true;
                if (this.state != 4) return true;
                n = this.button_state;
                if (n != 258) {
                    if (n != 259) return true;
                }
                this.captureLisenter.recordZoom(this.event_Y - motionEvent.getY());
            } else {
                this.handlerPressByState();
            }
        } else {
            if (motionEvent.getPointerCount() > 1) return true;
            if (this.state != 1) return true;
            this.event_Y = motionEvent.getY();
            this.state = 2;
            n = this.button_state;
            if (n != 258) {
                if (n != 259) return true;
            }
            this.postDelayed((Runnable)this.longPressRunnable, 500L);
        }
        return true;
    }

    public void recordEnd() {
        CaptureListener captureListener = this.captureLisenter;
        if (captureListener != null) {
            int n = this.recorded_time;
            if (n < this.min_duration) {
                captureListener.recordShort((long)n);
            } else {
                captureListener.recordEnd((long)n);
            }
        }
        this.resetRecordAnim();
    }

    public void resetState() {
        this.state = 1;
    }

    public void setButtonCaptureEnabled(boolean bl) {
        this.isTakeCamera = bl;
    }

    public void setButtonFeatures(int n) {
        this.button_state = n;
    }

    public void setCaptureListener(CaptureListener captureListener) {
        this.captureLisenter = captureListener;
    }

    public void setDuration(int n) {
        this.duration = n;
        this.timer = new RecordCountDownTimer(this, (long)n, (long)(n / 360));
    }

    public void setMinDuration(int n) {
        this.min_duration = n;
    }
}
