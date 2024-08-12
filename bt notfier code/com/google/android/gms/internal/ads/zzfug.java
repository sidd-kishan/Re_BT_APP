/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftt
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftt;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzghi;

public abstract class zzfug<KeyProtoT extends zzghi, PublicKeyProtoT extends zzghi>
extends zzftu<KeyProtoT> {
    @SafeVarargs
    protected zzfug(Class<KeyProtoT> clazz, Class<PublicKeyProtoT> clazz2, zzftt<?, KeyProtoT> ... zzfttArray) {
        super(clazz, zzfttArray);
    }
}
