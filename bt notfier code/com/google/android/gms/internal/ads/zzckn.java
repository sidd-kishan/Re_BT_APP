/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzxl
 *  com.google.android.gms.internal.ads.zzxp
 *  com.google.android.gms.internal.ads.zzxr
 *  com.google.android.gms.internal.ads.zzxs
 *  com.google.android.gms.internal.ads.zzxt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzxl;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzxr;
import com.google.android.gms.internal.ads.zzxs;
import com.google.android.gms.internal.ads.zzxt;

final class zzckn
extends zzxl {
    static final zzckn zzb = new zzckn();

    zzckn() {
    }

    public final zzxp zza(String string, byte[] byArray, String string2) {
        if ("moov".equals(string)) {
            return new zzxr();
        }
        if (!"mvhd".equals(string)) return new zzxt(string);
        return new zzxs();
    }
}
