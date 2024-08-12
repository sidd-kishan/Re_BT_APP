/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.WindowInsetsAnimationController
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
 *  androidx.core.view.WindowInsetsAnimationControllerCompat$Impl30
 */
package androidx.core.view;

import android.os.Build;
import android.view.WindowInsetsAnimationController;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationControllerCompat;

public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    WindowInsetsAnimationControllerCompat() {
        if (Build.VERSION.SDK_INT < 30) {
            this.mImpl = new Impl();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("On API 30+, the constructor taking a ");
        stringBuilder.append(WindowInsetsAnimationController.class.getSimpleName());
        stringBuilder.append(" as parameter");
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new Impl30(windowInsetsAnimationController);
    }

    public void finish(boolean bl) {
        this.mImpl.finish(bl);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        boolean bl = !this.isFinished() && !this.isCancelled();
        return bl;
    }

    public void setInsetsAndAlpha(Insets insets, float f, float f2) {
        this.mImpl.setInsetsAndAlpha(insets, f, f2);
    }
}
