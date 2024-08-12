/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 */
package com.luck.picture.lib.photoview;

import android.os.Build;
import android.view.View;

class Compat {
    private static final int SIXTY_FPS_INTERVAL = 16;

    Compat() {
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            Compat.postOnAnimationJellyBean(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    private static void postOnAnimationJellyBean(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
