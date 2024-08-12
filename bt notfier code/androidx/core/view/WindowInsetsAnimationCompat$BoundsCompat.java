/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsetsAnimation$Bounds
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl30
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.core.view;

import android.view.WindowInsetsAnimation;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class WindowInsetsAnimationCompat.BoundsCompat {
    private final Insets mLowerBound;
    private final Insets mUpperBound;

    private WindowInsetsAnimationCompat.BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
        this.mLowerBound = WindowInsetsAnimationCompat.Impl30.getLowerBounds((WindowInsetsAnimation.Bounds)bounds);
        this.mUpperBound = WindowInsetsAnimationCompat.Impl30.getHigherBounds((WindowInsetsAnimation.Bounds)bounds);
    }

    public WindowInsetsAnimationCompat.BoundsCompat(Insets insets, Insets insets2) {
        this.mLowerBound = insets;
        this.mUpperBound = insets2;
    }

    public static WindowInsetsAnimationCompat.BoundsCompat toBoundsCompat(WindowInsetsAnimation.Bounds bounds) {
        return new WindowInsetsAnimationCompat.BoundsCompat(bounds);
    }

    public Insets getLowerBound() {
        return this.mLowerBound;
    }

    public Insets getUpperBound() {
        return this.mUpperBound;
    }

    public WindowInsetsAnimationCompat.BoundsCompat inset(Insets insets) {
        return new WindowInsetsAnimationCompat.BoundsCompat(WindowInsetsCompat.insetInsets((Insets)this.mLowerBound, (int)insets.left, (int)insets.top, (int)insets.right, (int)insets.bottom), WindowInsetsCompat.insetInsets((Insets)this.mUpperBound, (int)insets.left, (int)insets.top, (int)insets.right, (int)insets.bottom));
    }

    public WindowInsetsAnimation.Bounds toBounds() {
        return WindowInsetsAnimationCompat.Impl30.createPlatformBounds((WindowInsetsAnimationCompat.BoundsCompat)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bounds{lower=");
        stringBuilder.append(this.mLowerBound);
        stringBuilder.append(" upper=");
        stringBuilder.append(this.mUpperBound);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
