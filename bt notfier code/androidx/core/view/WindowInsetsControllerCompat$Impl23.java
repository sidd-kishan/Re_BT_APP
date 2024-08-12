/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.Window
 *  androidx.core.view.WindowInsetsControllerCompat$Impl20
 */
package androidx.core.view;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat;

private static class WindowInsetsControllerCompat.Impl23
extends WindowInsetsControllerCompat.Impl20 {
    WindowInsetsControllerCompat.Impl23(Window window, View view) {
        super(window, view);
    }

    public boolean isAppearanceLightStatusBars() {
        boolean bl = (this.mWindow.getDecorView().getSystemUiVisibility() & 0x2000) != 0;
        return bl;
    }

    public void setAppearanceLightStatusBars(boolean bl) {
        if (bl) {
            this.unsetWindowFlag(0x4000000);
            this.setWindowFlag(Integer.MIN_VALUE);
            this.setSystemUiFlag(8192);
        } else {
            this.unsetSystemUiFlag(8192);
        }
    }
}
