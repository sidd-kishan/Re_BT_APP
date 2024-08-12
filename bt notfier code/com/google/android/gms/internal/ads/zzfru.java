/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrv
 *  com.google.android.gms.internal.ads.zzfse
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrv;
import com.google.android.gms.internal.ads.zzfse;
import com.google.android.gms.internal.ads.zzfsm;

public class zzfru<V>
extends zzfse<V> {
    zzfru() {
    }

    public static <V> zzfru<V> zzw(zzfsm<V> object) {
        object = object instanceof zzfru ? (zzfru)((Object)object) : new zzfrv(object);
        return object;
    }
}
