/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.WindowInsetsAnimationController
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.WindowInsetsAnimationController;
import androidx.core.view.WindowInsetsAnimationControllerCompat;

private static class WindowInsetsAnimationControllerCompat.Impl30
extends WindowInsetsAnimationControllerCompat.Impl {
    private final WindowInsetsAnimationController mController;

    WindowInsetsAnimationControllerCompat.Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mController = windowInsetsAnimationController;
    }

    void finish(boolean bl) {
        this.mController.finish(bl);
    }

    public float getCurrentAlpha() {
        return this.mController.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.mController.getCurrentFraction();
    }

    public androidx.core.graphics.Insets getCurrentInsets() {
        return androidx.core.graphics.Insets.toCompatInsets((Insets)this.mController.getCurrentInsets());
    }

    public androidx.core.graphics.Insets getHiddenStateInsets() {
        return androidx.core.graphics.Insets.toCompatInsets((Insets)this.mController.getHiddenStateInsets());
    }

    public androidx.core.graphics.Insets getShownStateInsets() {
        return androidx.core.graphics.Insets.toCompatInsets((Insets)this.mController.getShownStateInsets());
    }

    public int getTypes() {
        return this.mController.getTypes();
    }

    boolean isCancelled() {
        return this.mController.isCancelled();
    }

    boolean isFinished() {
        return this.mController.isFinished();
    }

    public boolean isReady() {
        return this.mController.isReady();
    }

    public void setInsetsAndAlpha(androidx.core.graphics.Insets object, float f, float f2) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.mController;
        object = object == null ? null : object.toPlatformInsets();
        windowInsetsAnimationController.setInsetsAndAlpha((Insets)object, f, f2);
    }
}
