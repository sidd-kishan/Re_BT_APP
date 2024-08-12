/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgc
 *  com.google.android.gms.internal.measurement.zzhd
 *  com.google.android.gms.internal.measurement.zzib
 *  com.google.android.gms.internal.measurement.zziv
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzhd;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zziv;

public abstract class zzgb<MessageType extends zzgc<MessageType, BuilderType>, BuilderType extends zzgb<MessageType, BuilderType>>
implements zziv {
    public abstract BuilderType zzaq();

    public BuilderType zzar(byte[] byArray, int n, int n2) throws zzib {
        throw null;
    }

    public BuilderType zzas(byte[] byArray, int n, int n2, zzhd zzhd2) throws zzib {
        throw null;
    }

    protected abstract BuilderType zzat(MessageType var1);
}
