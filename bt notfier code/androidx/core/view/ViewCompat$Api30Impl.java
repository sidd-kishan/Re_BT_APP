/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowInsetsController
 *  androidx.core.view.WindowInsetsControllerCompat
 */
package androidx.core.view;

import android.view.View;
import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

private static class ViewCompat.Api30Impl {
    private ViewCompat.Api30Impl() {
    }

    public static WindowInsetsControllerCompat getWindowInsetsController(View object) {
        object = (object = object.getWindowInsetsController()) != null ? WindowInsetsControllerCompat.toWindowInsetsControllerCompat((WindowInsetsController)object) : null;
        return object;
    }
}
