/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  com.bumptech.glide.request.target.ViewTarget$SizeDeterminer
 */
package com.bumptech.glide.request.target;

import android.util.Log;
import android.view.ViewTreeObserver;
import com.bumptech.glide.request.target.ViewTarget;
import java.lang.ref.WeakReference;

private static final class ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener
implements ViewTreeObserver.OnPreDrawListener {
    private final WeakReference<ViewTarget.SizeDeterminer> sizeDeterminerRef;

    ViewTarget.SizeDeterminer.SizeDeterminerLayoutListener(ViewTarget.SizeDeterminer sizeDeterminer) {
        this.sizeDeterminerRef = new WeakReference<ViewTarget.SizeDeterminer>(sizeDeterminer);
    }

    public boolean onPreDraw() {
        StringBuilder stringBuilder;
        if (Log.isLoggable((String)"ViewTarget", (int)2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("OnGlobalLayoutListener called attachStateListener=");
            stringBuilder.append(this);
            Log.v((String)"ViewTarget", (String)stringBuilder.toString());
        }
        if ((stringBuilder = (ViewTarget.SizeDeterminer)this.sizeDeterminerRef.get()) == null) return true;
        stringBuilder.checkCurrentDimens();
        return true;
    }
}
