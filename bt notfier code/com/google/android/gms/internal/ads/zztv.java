/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zzng
 *  com.google.android.gms.internal.ads.zzni
 *  com.google.android.gms.internal.ads.zznk
 *  com.google.android.gms.internal.ads.zznl
 *  com.google.android.gms.internal.ads.zztu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzng;
import com.google.android.gms.internal.ads.zzni;
import com.google.android.gms.internal.ads.zznk;
import com.google.android.gms.internal.ads.zznl;
import com.google.android.gms.internal.ads.zztu;

final class zztv
extends zznl {
    public zztv(zzamn zzamn2, long l, long l2) {
        super((zzni)new zzng(), (zznk)new zztu(zzamn2, null), l, 0L, l + 1L, 0L, l2, 188L, 1000);
    }

    static /* synthetic */ int zzh(byte[] byArray, int n) {
        byte by = byArray[n];
        byte by2 = byArray[n + 1];
        byte by3 = byArray[n + 2];
        return byArray[n + 3] & 0xFF | ((by & 0xFF) << 24 | (by2 & 0xFF) << 16 | (by3 & 0xFF) << 8);
    }
}
