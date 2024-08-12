/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Log
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$Anim
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$OnAnimationEventListener
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$ScaleAndTranslate
 */
package com.luck.picture.lib.widget.longimage;

import android.graphics.PointF;
import android.util.Log;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/*
 * Exception performing whole class analysis ignored.
 */
public final class SubsamplingScaleImageView.AnimationBuilder {
    private long duration;
    private int easing;
    private boolean interruptible;
    private SubsamplingScaleImageView.OnAnimationEventListener listener;
    private int origin;
    private boolean panLimited;
    private final PointF targetSCenter;
    private final float targetScale;
    final SubsamplingScaleImageView this$0;
    private final PointF vFocus;

    private SubsamplingScaleImageView.AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f) {
        this.this$0 = subsamplingScaleImageView;
        this.duration = 500L;
        this.easing = 2;
        this.origin = 1;
        this.interruptible = true;
        this.panLimited = true;
        this.targetScale = f;
        this.targetSCenter = subsamplingScaleImageView.getCenter();
        this.vFocus = null;
    }

    private SubsamplingScaleImageView.AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF) {
        this.this$0 = subsamplingScaleImageView;
        this.duration = 500L;
        this.easing = 2;
        this.origin = 1;
        this.interruptible = true;
        this.panLimited = true;
        this.targetScale = f;
        this.targetSCenter = pointF;
        this.vFocus = null;
    }

    private SubsamplingScaleImageView.AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2) {
        this.this$0 = subsamplingScaleImageView;
        this.duration = 500L;
        this.easing = 2;
        this.origin = 1;
        this.interruptible = true;
        this.panLimited = true;
        this.targetScale = f;
        this.targetSCenter = pointF;
        this.vFocus = pointF2;
    }

    private SubsamplingScaleImageView.AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        this.this$0 = subsamplingScaleImageView;
        this.duration = 500L;
        this.easing = 2;
        this.origin = 1;
        this.interruptible = true;
        this.panLimited = true;
        this.targetScale = SubsamplingScaleImageView.access$1000((SubsamplingScaleImageView)subsamplingScaleImageView);
        this.targetSCenter = pointF;
        this.vFocus = null;
    }

    static /* synthetic */ SubsamplingScaleImageView.AnimationBuilder access$1200(SubsamplingScaleImageView.AnimationBuilder animationBuilder, boolean bl) {
        return animationBuilder.withPanLimited(bl);
    }

    static /* synthetic */ SubsamplingScaleImageView.AnimationBuilder access$1300(SubsamplingScaleImageView.AnimationBuilder animationBuilder, int n) {
        return animationBuilder.withOrigin(n);
    }

    private SubsamplingScaleImageView.AnimationBuilder withOrigin(int n) {
        this.origin = n;
        return this;
    }

    private SubsamplingScaleImageView.AnimationBuilder withPanLimited(boolean bl) {
        this.panLimited = bl;
        return this;
    }

    public void start() {
        if (SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0) != null && SubsamplingScaleImageView.Anim.access$2800((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0)) != null) {
            try {
                SubsamplingScaleImageView.Anim.access$2800((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0)).onInterruptedByNewAnim();
            }
            catch (Exception exception) {
                Log.w((String)SubsamplingScaleImageView.access$5400(), (String)"Error thrown by animation listener", (Throwable)exception);
            }
        }
        int n = this.this$0.getPaddingLeft();
        int n2 = (this.this$0.getWidth() - this.this$0.getPaddingRight() - this.this$0.getPaddingLeft()) / 2;
        int n3 = this.this$0.getPaddingTop();
        int n4 = (this.this$0.getHeight() - this.this$0.getPaddingBottom() - this.this$0.getPaddingTop()) / 2;
        float f = SubsamplingScaleImageView.access$6500((SubsamplingScaleImageView)this.this$0, (float)this.targetScale);
        PointF pointF = this.panLimited ? SubsamplingScaleImageView.access$6600((SubsamplingScaleImageView)this.this$0, (float)this.targetSCenter.x, (float)this.targetSCenter.y, (float)f, (PointF)new PointF()) : this.targetSCenter;
        SubsamplingScaleImageView.access$6402((SubsamplingScaleImageView)this.this$0, (SubsamplingScaleImageView.Anim)new SubsamplingScaleImageView.Anim(null));
        SubsamplingScaleImageView.Anim.access$3402((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (float)SubsamplingScaleImageView.access$1000((SubsamplingScaleImageView)this.this$0));
        SubsamplingScaleImageView.Anim.access$3502((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (float)f);
        SubsamplingScaleImageView.Anim.access$3102((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (long)System.currentTimeMillis());
        SubsamplingScaleImageView.Anim.access$4502((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (PointF)pointF);
        SubsamplingScaleImageView.Anim.access$4402((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (PointF)this.this$0.getCenter());
        SubsamplingScaleImageView.Anim.access$3802((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (PointF)pointF);
        SubsamplingScaleImageView.Anim.access$3602((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (PointF)this.this$0.sourceToViewCoord(pointF));
        SubsamplingScaleImageView.Anim.access$3702((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (PointF)new PointF((float)(n + n2), (float)(n3 + n4)));
        SubsamplingScaleImageView.Anim.access$3202((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (long)this.duration);
        SubsamplingScaleImageView.Anim.access$2702((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (boolean)this.interruptible);
        SubsamplingScaleImageView.Anim.access$3302((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (int)this.easing);
        SubsamplingScaleImageView.Anim.access$3902((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (int)this.origin);
        SubsamplingScaleImageView.Anim.access$3102((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (long)System.currentTimeMillis());
        SubsamplingScaleImageView.Anim.access$2802((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (SubsamplingScaleImageView.OnAnimationEventListener)this.listener);
        pointF = this.vFocus;
        if (pointF != null) {
            float f2 = pointF.x - SubsamplingScaleImageView.Anim.access$4400((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0)).x * f;
            float f3 = this.vFocus.y - SubsamplingScaleImageView.Anim.access$4400((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0)).y * f;
            pointF = new SubsamplingScaleImageView.ScaleAndTranslate(f, new PointF(f2, f3), null);
            SubsamplingScaleImageView.access$6800((SubsamplingScaleImageView)this.this$0, (boolean)true, (SubsamplingScaleImageView.ScaleAndTranslate)pointF);
            SubsamplingScaleImageView.Anim.access$3702((SubsamplingScaleImageView.Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0), (PointF)new PointF(this.vFocus.x + (SubsamplingScaleImageView.ScaleAndTranslate.access$4800((SubsamplingScaleImageView.ScaleAndTranslate)pointF).x - f2), this.vFocus.y + (SubsamplingScaleImageView.ScaleAndTranslate.access$4800((SubsamplingScaleImageView.ScaleAndTranslate)pointF).y - f3)));
        }
        this.this$0.invalidate();
    }

    public SubsamplingScaleImageView.AnimationBuilder withDuration(long l) {
        this.duration = l;
        return this;
    }

    public SubsamplingScaleImageView.AnimationBuilder withEasing(int n) {
        if (SubsamplingScaleImageView.access$6300().contains(n)) {
            this.easing = n;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown easing type: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public SubsamplingScaleImageView.AnimationBuilder withInterruptible(boolean bl) {
        this.interruptible = bl;
        return this;
    }

    public SubsamplingScaleImageView.AnimationBuilder withOnAnimationEventListener(SubsamplingScaleImageView.OnAnimationEventListener onAnimationEventListener) {
        this.listener = onAnimationEventListener;
        return this;
    }
}
