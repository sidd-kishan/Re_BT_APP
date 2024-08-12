/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.luck.picture.lib.widget.longimage;

import android.graphics.PointF;

private static class SubsamplingScaleImageView.ScaleAndTranslate {
    private float scale;
    private PointF vTranslate;

    private SubsamplingScaleImageView.ScaleAndTranslate(float f, PointF pointF) {
        this.scale = f;
        this.vTranslate = pointF;
    }

    static /* synthetic */ float access$4700(SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate) {
        return scaleAndTranslate.scale;
    }

    static /* synthetic */ float access$4702(SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate, float f) {
        scaleAndTranslate.scale = f;
        return f;
    }

    static /* synthetic */ PointF access$4800(SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate) {
        return scaleAndTranslate.vTranslate;
    }
}
