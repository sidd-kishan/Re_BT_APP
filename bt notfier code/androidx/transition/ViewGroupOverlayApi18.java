/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 *  androidx.transition.ViewGroupOverlayImpl
 */
package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.transition.ViewGroupOverlayImpl;

class ViewGroupOverlayApi18
implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay mViewGroupOverlay;

    ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.mViewGroupOverlay = viewGroup.getOverlay();
    }

    public void add(Drawable drawable) {
        this.mViewGroupOverlay.add(drawable);
    }

    public void add(View view) {
        this.mViewGroupOverlay.add(view);
    }

    public void remove(Drawable drawable) {
        this.mViewGroupOverlay.remove(drawable);
    }

    public void remove(View view) {
        this.mViewGroupOverlay.remove(view);
    }
}
