/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewOverlay
 *  androidx.transition.ViewOverlayImpl
 */
package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.transition.ViewOverlayImpl;

class ViewOverlayApi18
implements ViewOverlayImpl {
    private final ViewOverlay mViewOverlay;

    ViewOverlayApi18(View view) {
        this.mViewOverlay = view.getOverlay();
    }

    public void add(Drawable drawable) {
        this.mViewOverlay.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.mViewOverlay.remove(drawable);
    }
}
