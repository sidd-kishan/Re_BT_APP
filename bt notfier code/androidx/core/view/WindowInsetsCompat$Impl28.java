/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 *  androidx.core.view.DisplayCutoutCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Impl21
 */
package androidx.core.view;

import android.view.WindowInsets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Objects;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.Impl28
extends WindowInsetsCompat.Impl21 {
    WindowInsetsCompat.Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    WindowInsetsCompat.Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat.Impl28 impl28) {
        super(windowInsetsCompat, (WindowInsetsCompat.Impl21)impl28);
    }

    WindowInsetsCompat consumeDisplayCutout() {
        return WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)this.mPlatformInsets.consumeDisplayCutout());
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof WindowInsetsCompat.Impl28)) {
            return false;
        }
        object = (WindowInsetsCompat.Impl28)((Object)object);
        if (Objects.equals(this.mPlatformInsets, ((WindowInsetsCompat.Impl28)((Object)object)).mPlatformInsets) && Objects.equals(this.mRootViewVisibleInsets, ((WindowInsetsCompat.Impl28)((Object)object)).mRootViewVisibleInsets)) return bl;
        bl = false;
        return bl;
    }

    DisplayCutoutCompat getDisplayCutout() {
        return DisplayCutoutCompat.wrap((Object)this.mPlatformInsets.getDisplayCutout());
    }

    public int hashCode() {
        return this.mPlatformInsets.hashCode();
    }
}
