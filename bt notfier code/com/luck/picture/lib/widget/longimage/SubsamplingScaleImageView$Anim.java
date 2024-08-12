/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$OnAnimationEventListener
 */
package com.luck.picture.lib.widget.longimage;

import android.graphics.PointF;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

private static class SubsamplingScaleImageView.Anim {
    private long duration = 500L;
    private int easing = 2;
    private boolean interruptible = true;
    private SubsamplingScaleImageView.OnAnimationEventListener listener;
    private int origin = 1;
    private PointF sCenterEnd;
    private PointF sCenterEndRequested;
    private PointF sCenterStart;
    private float scaleEnd;
    private float scaleStart;
    private long time = System.currentTimeMillis();
    private PointF vFocusEnd;
    private PointF vFocusStart;

    private SubsamplingScaleImageView.Anim() {
    }

    static /* synthetic */ boolean access$2700(SubsamplingScaleImageView.Anim anim) {
        return anim.interruptible;
    }

    static /* synthetic */ boolean access$2702(SubsamplingScaleImageView.Anim anim, boolean bl) {
        anim.interruptible = bl;
        return bl;
    }

    static /* synthetic */ SubsamplingScaleImageView.OnAnimationEventListener access$2800(SubsamplingScaleImageView.Anim anim) {
        return anim.listener;
    }

    static /* synthetic */ SubsamplingScaleImageView.OnAnimationEventListener access$2802(SubsamplingScaleImageView.Anim anim, SubsamplingScaleImageView.OnAnimationEventListener onAnimationEventListener) {
        anim.listener = onAnimationEventListener;
        return onAnimationEventListener;
    }

    static /* synthetic */ long access$3100(SubsamplingScaleImageView.Anim anim) {
        return anim.time;
    }

    static /* synthetic */ long access$3102(SubsamplingScaleImageView.Anim anim, long l) {
        anim.time = l;
        return l;
    }

    static /* synthetic */ long access$3200(SubsamplingScaleImageView.Anim anim) {
        return anim.duration;
    }

    static /* synthetic */ long access$3202(SubsamplingScaleImageView.Anim anim, long l) {
        anim.duration = l;
        return l;
    }

    static /* synthetic */ int access$3300(SubsamplingScaleImageView.Anim anim) {
        return anim.easing;
    }

    static /* synthetic */ int access$3302(SubsamplingScaleImageView.Anim anim, int n) {
        anim.easing = n;
        return n;
    }

    static /* synthetic */ float access$3400(SubsamplingScaleImageView.Anim anim) {
        return anim.scaleStart;
    }

    static /* synthetic */ float access$3402(SubsamplingScaleImageView.Anim anim, float f) {
        anim.scaleStart = f;
        return f;
    }

    static /* synthetic */ float access$3500(SubsamplingScaleImageView.Anim anim) {
        return anim.scaleEnd;
    }

    static /* synthetic */ float access$3502(SubsamplingScaleImageView.Anim anim, float f) {
        anim.scaleEnd = f;
        return f;
    }

    static /* synthetic */ PointF access$3600(SubsamplingScaleImageView.Anim anim) {
        return anim.vFocusStart;
    }

    static /* synthetic */ PointF access$3602(SubsamplingScaleImageView.Anim anim, PointF pointF) {
        anim.vFocusStart = pointF;
        return pointF;
    }

    static /* synthetic */ PointF access$3700(SubsamplingScaleImageView.Anim anim) {
        return anim.vFocusEnd;
    }

    static /* synthetic */ PointF access$3702(SubsamplingScaleImageView.Anim anim, PointF pointF) {
        anim.vFocusEnd = pointF;
        return pointF;
    }

    static /* synthetic */ PointF access$3800(SubsamplingScaleImageView.Anim anim) {
        return anim.sCenterEnd;
    }

    static /* synthetic */ PointF access$3802(SubsamplingScaleImageView.Anim anim, PointF pointF) {
        anim.sCenterEnd = pointF;
        return pointF;
    }

    static /* synthetic */ int access$3900(SubsamplingScaleImageView.Anim anim) {
        return anim.origin;
    }

    static /* synthetic */ int access$3902(SubsamplingScaleImageView.Anim anim, int n) {
        anim.origin = n;
        return n;
    }

    static /* synthetic */ PointF access$4400(SubsamplingScaleImageView.Anim anim) {
        return anim.sCenterStart;
    }

    static /* synthetic */ PointF access$4402(SubsamplingScaleImageView.Anim anim, PointF pointF) {
        anim.sCenterStart = pointF;
        return pointF;
    }

    static /* synthetic */ PointF access$4500(SubsamplingScaleImageView.Anim anim) {
        return anim.sCenterEndRequested;
    }

    static /* synthetic */ PointF access$4502(SubsamplingScaleImageView.Anim anim, PointF pointF) {
        anim.sCenterEndRequested = pointF;
        return pointF;
    }
}
