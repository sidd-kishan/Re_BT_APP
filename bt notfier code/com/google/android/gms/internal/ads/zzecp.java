/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzecq
 *  com.google.android.gms.internal.ads.zzfdw
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzecq;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzfrz;

final class zzecp
implements zzfrz<SQLiteDatabase> {
    final zzfdw zza;

    zzecp(zzecq zzecq2, zzfdw zzfdw2) {
        this.zza = zzfdw2;
    }

    public final void zza(Throwable object) {
        object = ((String)(object = String.valueOf(((Throwable)object).getMessage()))).length() != 0 ? "Failed to get offline signal database: ".concat((String)object) : new String("Failed to get offline signal database: ");
        zze.zzf((String)object);
    }
}
