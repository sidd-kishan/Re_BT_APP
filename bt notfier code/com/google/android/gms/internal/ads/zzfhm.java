/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfgu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfgu;
import java.util.ArrayList;

public final class zzfhm {
    private final zzfgu zza;
    private final ArrayList<String> zzb;

    public zzfhm(zzfgu zzfgu2, String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        this.zzb = arrayList;
        this.zza = zzfgu2;
        arrayList.add(string);
    }

    public final void zza(String string) {
        this.zzb.add(string);
    }

    public final zzfgu zzb() {
        return this.zza;
    }

    public final ArrayList<String> zzc() {
        return this.zzb;
    }
}
