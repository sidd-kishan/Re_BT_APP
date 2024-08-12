/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.view.Display
 */
package androidx.core.view;

import android.graphics.Point;
import android.view.Display;

static class DisplayCompat.Api17Impl {
    private DisplayCompat.Api17Impl() {
    }

    static void getRealSize(Display display, Point point) {
        display.getRealSize(point);
    }
}
