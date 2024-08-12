/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgcp
 *  com.google.android.gms.internal.ads.zzgcq
 *  com.google.android.gms.internal.ads.zzgcs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcp;
import com.google.android.gms.internal.ads.zzgcq;
import com.google.android.gms.internal.ads.zzgcs;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

public final class zzgcr
extends zzgcs {
    public zzgcr(byte[] byArray) throws GeneralSecurityException {
        super(byArray);
    }

    final zzgcq zzb(byte[] byArray, int n) throws InvalidKeyException {
        return new zzgcp(byArray, n);
    }
}
