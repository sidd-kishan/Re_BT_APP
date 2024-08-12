/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.google.android.gms.internal.ads.zzciy
 */
package com.google.android.gms.internal.ads;

import android.os.Looper;
import com.google.android.gms.internal.ads.zzciy;

final class zzciw
implements Runnable {
    zzciw(zzciy zzciy2) {
    }

    @Override
    public final void run() {
        Looper.myLooper().quit();
    }
}
