/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.bumptech.glide.load.engine.prefill;

import android.os.SystemClock;

static class BitmapPreFillRunner.Clock {
    BitmapPreFillRunner.Clock() {
    }

    long now() {
        return SystemClock.currentThreadTimeMillis();
    }
}
