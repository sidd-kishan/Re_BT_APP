/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.view.WindowManager
 *  com.bumptech.glide.request.target.SizeReadyCallback
 *  com.bumptech.glide.request.target.ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

static final class ViewTarget.SizeDeterminer {
    private static final int PENDING_SIZE = 0;
    static Integer maxDisplayLength;
    private final List<SizeReadyCallback> cbs = new ArrayList<SizeReadyCallback>();
    private SizeDeterminerLayoutListener layoutListener;
    private final View view;
    boolean waitForLayout;

    ViewTarget.SizeDeterminer(View view) {
        this.view = view;
    }

    private static int getMaxDisplayLength(Context context) {
        if (maxDisplayLength != null) return maxDisplayLength;
        context = ((WindowManager)Preconditions.checkNotNull((Object)((WindowManager)context.getSystemService("window")))).getDefaultDisplay();
        Point point = new Point();
        context.getSize(point);
        maxDisplayLength = Math.max(point.x, point.y);
        return maxDisplayLength;
    }

    private int getTargetDimen(int n, int n2, int n3) {
        int n4 = n2 - n3;
        if (n4 > 0) {
            return n4;
        }
        if (this.waitForLayout && this.view.isLayoutRequested()) {
            return 0;
        }
        if ((n -= n3) > 0) {
            return n;
        }
        if (this.view.isLayoutRequested()) return 0;
        if (n2 != -2) return 0;
        if (!Log.isLoggable((String)"ViewTarget", (int)4)) return ViewTarget.SizeDeterminer.getMaxDisplayLength(this.view.getContext());
        Log.i((String)"ViewTarget", (String)"Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        return ViewTarget.SizeDeterminer.getMaxDisplayLength(this.view.getContext());
    }

    private int getTargetHeight() {
        int n = this.view.getPaddingTop();
        int n2 = this.view.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        int n3 = layoutParams != null ? layoutParams.height : 0;
        return this.getTargetDimen(this.view.getHeight(), n3, n + n2);
    }

    private int getTargetWidth() {
        int n = this.view.getPaddingLeft();
        int n2 = this.view.getPaddingRight();
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        int n3 = layoutParams != null ? layoutParams.width : 0;
        return this.getTargetDimen(this.view.getWidth(), n3, n + n2);
    }

    private boolean isDimensionValid(int n) {
        boolean bl = n > 0 || n == Integer.MIN_VALUE;
        return bl;
    }

    private boolean isViewStateAndSizeValid(int n, int n2) {
        boolean bl = this.isDimensionValid(n) && this.isDimensionValid(n2);
        return bl;
    }

    private void notifyCbs(int n, int n2) {
        Iterator<SizeReadyCallback> iterator = new ArrayList<SizeReadyCallback>(this.cbs).iterator();
        while (iterator.hasNext()) {
            iterator.next().onSizeReady(n, n2);
        }
    }

    void checkCurrentDimens() {
        int n;
        if (this.cbs.isEmpty()) {
            return;
        }
        int n2 = this.getTargetWidth();
        if (!this.isViewStateAndSizeValid(n2, n = this.getTargetHeight())) {
            return;
        }
        this.notifyCbs(n2, n);
        this.clearCallbacksAndListener();
    }

    void clearCallbacksAndListener() {
        ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.layoutListener);
        }
        this.layoutListener = null;
        this.cbs.clear();
    }

    void getSize(SizeReadyCallback sizeReadyCallback) {
        SizeDeterminerLayoutListener sizeDeterminerLayoutListener;
        int n;
        int n2 = this.getTargetWidth();
        if (this.isViewStateAndSizeValid(n2, n = this.getTargetHeight())) {
            sizeReadyCallback.onSizeReady(n2, n);
            return;
        }
        if (!this.cbs.contains(sizeReadyCallback)) {
            this.cbs.add(sizeReadyCallback);
        }
        if (this.layoutListener != null) return;
        sizeReadyCallback = this.view.getViewTreeObserver();
        this.layoutListener = sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
        sizeReadyCallback.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)sizeDeterminerLayoutListener);
    }

    void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.cbs.remove(sizeReadyCallback);
    }
}
