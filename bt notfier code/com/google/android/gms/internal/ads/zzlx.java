/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzfn
 *  com.google.android.gms.internal.ads.zzfo
 */
package com.google.android.gms.internal.ads;

import android.view.Surface;
import com.google.android.gms.internal.ads.zzfn;
import com.google.android.gms.internal.ads.zzfo;

public final class zzlx
extends zzfn {
    public zzlx(Throwable throwable, zzfo zzfo2, Surface surface) {
        super(throwable, zzfo2);
        System.identityHashCode(surface);
        if (surface == null) return;
        surface.isValid();
    }
}
