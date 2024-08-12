/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$BuilderImpl29
 *  androidx.core.view.WindowInsetsCompat$TypeImpl30
 */
package androidx.core.view;

import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.BuilderImpl30
extends WindowInsetsCompat.BuilderImpl29 {
    WindowInsetsCompat.BuilderImpl30() {
    }

    WindowInsetsCompat.BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
    }

    void setInsets(int n, Insets insets) {
        this.mPlatBuilder.setInsets(WindowInsetsCompat.TypeImpl30.toPlatformType((int)n), insets.toPlatformInsets());
    }

    void setInsetsIgnoringVisibility(int n, Insets insets) {
        this.mPlatBuilder.setInsetsIgnoringVisibility(WindowInsetsCompat.TypeImpl30.toPlatformType((int)n), insets.toPlatformInsets());
    }

    void setVisible(int n, boolean bl) {
        this.mPlatBuilder.setVisible(WindowInsetsCompat.TypeImpl30.toPlatformType((int)n), bl);
    }
}
