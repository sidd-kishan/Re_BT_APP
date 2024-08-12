/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$styleable
 *  com.yalantis.ucrop.callback.CropBoundsChangeListener
 *  com.yalantis.ucrop.callback.OverlayViewChangeListener
 *  com.yalantis.ucrop.view.GestureCropImageView
 *  com.yalantis.ucrop.view.OverlayView
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.luck.picture.lib.R;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;

public class UCropView
extends FrameLayout {
    private GestureCropImageView mGestureCropImageView;
    private final OverlayView mViewOverlay;

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UCropView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        LayoutInflater.from((Context)context).inflate(R.layout.ucrop_view, (ViewGroup)this, true);
        this.mGestureCropImageView = (GestureCropImageView)this.findViewById(R.id.image_view_crop);
        this.mViewOverlay = (OverlayView)this.findViewById(R.id.view_overlay);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        this.mViewOverlay.processStyledAttributes((TypedArray)context);
        this.mGestureCropImageView.processStyledAttributes((TypedArray)context);
        context.recycle();
        this.setListenersToViews();
    }

    static /* synthetic */ OverlayView access$000(UCropView uCropView) {
        return uCropView.mViewOverlay;
    }

    static /* synthetic */ GestureCropImageView access$100(UCropView uCropView) {
        return uCropView.mGestureCropImageView;
    }

    private void setListenersToViews() {
        this.mGestureCropImageView.setCropBoundsChangeListener((CropBoundsChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mViewOverlay.setOverlayViewChangeListener((OverlayViewChangeListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public GestureCropImageView getCropImageView() {
        return this.mGestureCropImageView;
    }

    public OverlayView getOverlayView() {
        return this.mViewOverlay;
    }

    public void resetCropImageView() {
        this.removeView((View)this.mGestureCropImageView);
        this.mGestureCropImageView = new GestureCropImageView(this.getContext());
        this.setListenersToViews();
        this.mGestureCropImageView.setCropRect(this.getOverlayView().getCropViewRect());
        this.addView((View)this.mGestureCropImageView, 0);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
