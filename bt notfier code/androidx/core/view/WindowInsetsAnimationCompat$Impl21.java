/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.WindowInsets
 *  android.view.animation.Interpolator
 *  androidx.core.R$id
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsAnimationCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$Callback
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Builder
 */
package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

private static class WindowInsetsAnimationCompat.Impl21
extends WindowInsetsAnimationCompat.Impl {
    WindowInsetsAnimationCompat.Impl21(int n, Interpolator interpolator, long l) {
        super(n, interpolator, l);
    }

    static int buildAnimationMask(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
        int n = 1;
        int n2 = 0;
        while (n <= 256) {
            int n3 = n2;
            if (!windowInsetsCompat.getInsets(n).equals((Object)windowInsetsCompat2.getInsets(n))) {
                n3 = n2 | n;
            }
            n <<= 1;
            n2 = n3;
        }
        return n2;
    }

    static WindowInsetsAnimationCompat.BoundsCompat computeAnimationBounds(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int n) {
        windowInsetsCompat = windowInsetsCompat.getInsets(n);
        windowInsetsCompat2 = windowInsetsCompat2.getInsets(n);
        return new WindowInsetsAnimationCompat.BoundsCompat(Insets.of((int)Math.min(windowInsetsCompat.left, windowInsetsCompat2.left), (int)Math.min(windowInsetsCompat.top, windowInsetsCompat2.top), (int)Math.min(windowInsetsCompat.right, windowInsetsCompat2.right), (int)Math.min(windowInsetsCompat.bottom, windowInsetsCompat2.bottom)), Insets.of((int)Math.max(windowInsetsCompat.left, windowInsetsCompat2.left), (int)Math.max(windowInsetsCompat.top, windowInsetsCompat2.top), (int)Math.max(windowInsetsCompat.right, windowInsetsCompat2.right), (int)Math.max(windowInsetsCompat.bottom, windowInsetsCompat2.bottom)));
    }

    private static View.OnApplyWindowInsetsListener createProxyListener(View view, WindowInsetsAnimationCompat.Callback callback) {
        return new Impl21OnApplyWindowInsetsListener(view, callback);
    }

    static void dispatchOnEnd(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(view);
        if (callback != null) {
            callback.onEnd(windowInsetsAnimationCompat);
            if (callback.getDispatchMode() == 0) {
                return;
            }
        }
        if (!(view instanceof ViewGroup)) return;
        view = (ViewGroup)view;
        int n = 0;
        while (n < view.getChildCount()) {
            WindowInsetsAnimationCompat.Impl21.dispatchOnEnd(view.getChildAt(n), windowInsetsAnimationCompat);
            ++n;
        }
    }

    static void dispatchOnPrepare(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean bl) {
        WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(view);
        int n = 0;
        boolean bl2 = bl;
        if (callback != null) {
            callback.mDispachedInsets = windowInsets;
            bl2 = bl;
            if (!bl) {
                callback.onPrepare(windowInsetsAnimationCompat);
                bl2 = callback.getDispatchMode() == 0;
            }
        }
        if (!(view instanceof ViewGroup)) return;
        view = (ViewGroup)view;
        while (n < view.getChildCount()) {
            WindowInsetsAnimationCompat.Impl21.dispatchOnPrepare(view.getChildAt(n), windowInsetsAnimationCompat, windowInsets, bl2);
            ++n;
        }
    }

    static void dispatchOnProgress(View view, WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
        WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(view);
        WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
        if (callback != null) {
            windowInsetsCompat2 = callback.onProgress(windowInsetsCompat, list);
            if (callback.getDispatchMode() == 0) {
                return;
            }
        }
        if (!(view instanceof ViewGroup)) return;
        view = (ViewGroup)view;
        int n = 0;
        while (n < view.getChildCount()) {
            WindowInsetsAnimationCompat.Impl21.dispatchOnProgress(view.getChildAt(n), windowInsetsCompat2, list);
            ++n;
        }
    }

    static void dispatchOnStart(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(view);
        if (callback != null) {
            callback.onStart(windowInsetsAnimationCompat, boundsCompat);
            if (callback.getDispatchMode() == 0) {
                return;
            }
        }
        if (!(view instanceof ViewGroup)) return;
        view = (ViewGroup)view;
        int n = 0;
        while (n < view.getChildCount()) {
            WindowInsetsAnimationCompat.Impl21.dispatchOnStart(view.getChildAt(n), windowInsetsAnimationCompat, boundsCompat);
            ++n;
        }
    }

    static WindowInsets forwardToViewIfNeeded(View view, WindowInsets windowInsets) {
        if (view.getTag(R.id.tag_on_apply_window_listener) == null) return view.onApplyWindowInsets(windowInsets);
        return windowInsets;
    }

    static WindowInsetsAnimationCompat.Callback getCallback(View object) {
        object = (object = object.getTag(R.id.tag_window_insets_animation_callback)) instanceof Impl21OnApplyWindowInsetsListener ? ((Impl21OnApplyWindowInsetsListener)object).mCallback : null;
        return object;
    }

    static WindowInsetsCompat interpolateInsets(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f, int n) {
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
        int n2 = 1;
        while (n2 <= 256) {
            if ((n & n2) == 0) {
                builder.setInsets(n2, windowInsetsCompat.getInsets(n2));
            } else {
                Insets insets = windowInsetsCompat.getInsets(n2);
                Insets insets2 = windowInsetsCompat2.getInsets(n2);
                float f2 = insets.left - insets2.left;
                float f3 = 1.0f - f;
                double d = f2 * f3;
                Double.isNaN(d);
                int n3 = (int)(d + 0.5);
                d = (float)(insets.top - insets2.top) * f3;
                Double.isNaN(d);
                int n4 = (int)(d + 0.5);
                d = (float)(insets.right - insets2.right) * f3;
                Double.isNaN(d);
                int n5 = (int)(d + 0.5);
                d = (float)(insets.bottom - insets2.bottom) * f3;
                Double.isNaN(d);
                builder.setInsets(n2, WindowInsetsCompat.insetInsets((Insets)insets, (int)n3, (int)n4, (int)n5, (int)((int)(d + 0.5))));
            }
            n2 <<= 1;
        }
        return builder.build();
    }

    static void setCallback(View view, WindowInsetsAnimationCompat.Callback callback) {
        Object object = view.getTag(R.id.tag_on_apply_window_listener);
        if (callback == null) {
            view.setTag(R.id.tag_window_insets_animation_callback, null);
            if (object != null) return;
            view.setOnApplyWindowInsetsListener(null);
        } else {
            callback = WindowInsetsAnimationCompat.Impl21.createProxyListener(view, callback);
            view.setTag(R.id.tag_window_insets_animation_callback, (Object)callback);
            if (object != null) return;
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)callback);
        }
    }
}
