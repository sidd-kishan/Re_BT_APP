/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzfdw
 */
package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzfdw;

final class zzedm
implements zzfdw {
    private final zzedq zza;
    private final zzcgy zzb;
    private final String zzc;

    zzedm(zzedq zzedq2, zzcgy zzcgy2, String string) {
        this.zza = zzedq2;
        this.zzb = zzcgy2;
        this.zzc = string;
    }

    public final Object zza(Object object) {
        zzedq zzedq2 = this.zza;
        zzcgy zzcgy2 = this.zzb;
        String string = this.zzc;
        zzedq2.zzb((SQLiteDatabase)object, zzcgy2, string);
        return null;
    }
}
