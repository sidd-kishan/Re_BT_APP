/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzeds
 *  com.google.android.gms.internal.ads.zzfdw
 */
package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzeds;
import com.google.android.gms.internal.ads.zzfdw;

final class zzedo
implements zzfdw {
    private final zzedq zza;
    private final zzeds zzb;

    zzedo(zzedq zzedq2, zzeds zzeds2) {
        this.zza = zzedq2;
        this.zzb = zzeds2;
    }

    public final Object zza(Object object) {
        this.zza.zzf(this.zzb, (SQLiteDatabase)object);
        return null;
    }
}
