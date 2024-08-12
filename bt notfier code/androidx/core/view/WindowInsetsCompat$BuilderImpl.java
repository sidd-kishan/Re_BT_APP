/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.graphics.Insets
 *  androidx.core.view.DisplayCutoutCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Type
 */
package androidx.core.view;

import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.BuilderImpl {
    private final WindowInsetsCompat mInsets;
    Insets[] mInsetsTypeMask;

    WindowInsetsCompat.BuilderImpl() {
        this(new WindowInsetsCompat((WindowInsetsCompat)null));
    }

    WindowInsetsCompat.BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
        this.mInsets = windowInsetsCompat;
    }

    protected final void applyInsetTypes() {
        Insets insets;
        Insets insets2 = this.mInsetsTypeMask;
        if (insets2 == null) return;
        Insets insets3 = insets2[WindowInsetsCompat.Type.indexOf((int)1)];
        insets2 = insets = this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf((int)2)];
        if (insets == null) {
            insets2 = this.mInsets.getInsets(2);
        }
        insets = insets3;
        if (insets3 == null) {
            insets = this.mInsets.getInsets(1);
        }
        this.setSystemWindowInsets(Insets.max((Insets)insets, (Insets)insets2));
        insets2 = this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf((int)16)];
        if (insets2 != null) {
            this.setSystemGestureInsets(insets2);
        }
        if ((insets2 = this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf((int)32)]) != null) {
            this.setMandatorySystemGestureInsets(insets2);
        }
        if ((insets2 = this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf((int)64)]) == null) return;
        this.setTappableElementInsets(insets2);
    }

    WindowInsetsCompat build() {
        this.applyInsetTypes();
        return this.mInsets;
    }

    void setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
    }

    void setInsets(int n, Insets insets) {
        if (this.mInsetsTypeMask == null) {
            this.mInsetsTypeMask = new Insets[9];
        }
        int n2 = 1;
        while (n2 <= 256) {
            if ((n & n2) != 0) {
                this.mInsetsTypeMask[WindowInsetsCompat.Type.indexOf((int)n2)] = insets;
            }
            n2 <<= 1;
        }
    }

    void setInsetsIgnoringVisibility(int n, Insets insets) {
        if (n == 8) throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
    }

    void setMandatorySystemGestureInsets(Insets insets) {
    }

    void setStableInsets(Insets insets) {
    }

    void setSystemGestureInsets(Insets insets) {
    }

    void setSystemWindowInsets(Insets insets) {
    }

    void setTappableElementInsets(Insets insets) {
    }

    void setVisible(int n, boolean bl) {
    }
}
