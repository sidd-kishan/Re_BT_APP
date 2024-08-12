/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 *  androidx.core.view.WindowInsetsAnimationCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.core.view;

import android.view.WindowInsets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

public static abstract class WindowInsetsAnimationCompat.Callback {
    public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
    public static final int DISPATCH_MODE_STOP = 0;
    WindowInsets mDispachedInsets;
    private final int mDispatchMode;

    public WindowInsetsAnimationCompat.Callback(int n) {
        this.mDispatchMode = n;
    }

    public final int getDispatchMode() {
        return this.mDispatchMode;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    public abstract WindowInsetsCompat onProgress(WindowInsetsCompat var1, List<WindowInsetsAnimationCompat> var2);

    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        return boundsCompat;
    }
}
