/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftm
 *  com.google.android.gms.internal.ads.zzfto
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfug
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzfto;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfug;
import com.google.android.gms.internal.ads.zzghi;

public final class zzfuf<PrimitiveT, KeyProtoT extends zzghi, PublicKeyProtoT extends zzghi>
extends zzfto<PrimitiveT, KeyProtoT>
implements zzftm<PrimitiveT> {
    private final zzfug<KeyProtoT, PublicKeyProtoT> zza;
    private final zzftu<PublicKeyProtoT> zzb;

    public zzfuf(zzfug<KeyProtoT, PublicKeyProtoT> zzfug2, zzftu<PublicKeyProtoT> zzftu2, Class<PrimitiveT> clazz) {
        super(zzfug2, clazz);
        this.zza = zzfug2;
        this.zzb = zzftu2;
    }
}
