/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.Window
 *  androidx.core.view.WindowInsetsControllerCompat$Impl23
 */
package androidx.core.view;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat;

private static class WindowInsetsControllerCompat.Impl26
extends WindowInsetsControllerCompat.Impl23 {
    WindowInsetsControllerCompat.Impl26(Window window, View view) {
        super(window, view);
    }

    public boolean isAppearanceLightNavigationBars() {
        boolean bl = (this.mWindow.getDecorView().getSystemUiVisibility() & 0x10) != 0;
        return bl;
    }

    public void setAppearanceLightNavigationBars(boolean bl) {
        if (bl) {
            this.unsetWindowFlag(0x8000000);
            this.setWindowFlag(Integer.MIN_VALUE);
            this.setSystemUiFlag(16);
        } else {
            this.unsetSystemUiFlag(16);
        }
    }
}
