/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.bumptech.glide.ListPreloader$PreloadSizeProvider
 *  com.bumptech.glide.request.target.SizeReadyCallback
 *  com.bumptech.glide.util.ViewPreloadSizeProvider$SizeViewTarget
 */
package com.bumptech.glide.util;

import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T>
implements ListPreloader.PreloadSizeProvider<T>,
SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    public ViewPreloadSizeProvider() {
    }

    public ViewPreloadSizeProvider(View view) {
        this.viewTarget = new SizeViewTarget(view, (SizeReadyCallback)this);
    }

    public int[] getPreloadSize(T object, int n, int n2) {
        object = this.size;
        if (object != null) return Arrays.copyOf(object, ((T)object).length);
        return null;
    }

    public void onSizeReady(int n, int n2) {
        this.size = new int[]{n, n2};
        this.viewTarget = null;
    }

    public void setView(View view) {
        if (this.size != null) return;
        if (this.viewTarget != null) return;
        this.viewTarget = new SizeViewTarget(view, (SizeReadyCallback)this);
    }
}
