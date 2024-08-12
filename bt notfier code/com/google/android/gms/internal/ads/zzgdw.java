/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgcq
 *  com.google.android.gms.internal.ads.zzgcs
 *  com.google.android.gms.internal.ads.zzgdv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcq;
import com.google.android.gms.internal.ads.zzgcs;
import com.google.android.gms.internal.ads.zzgdv;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

public final class zzgdw
extends zzgcs {
    public zzgdw(byte[] byArray) throws GeneralSecurityException {
        super(byArray);
    }

    final zzgcq zzb(byte[] byArray, int n) throws InvalidKeyException {
        return new zzgdv(byArray, n);
    }
}
