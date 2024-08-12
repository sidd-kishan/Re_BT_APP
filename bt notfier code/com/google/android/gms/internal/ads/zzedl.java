/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzedq
 */
package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzedq;

final class zzedl
implements Runnable {
    private final SQLiteDatabase zza;
    private final String zzb;
    private final zzcgy zzc;

    zzedl(SQLiteDatabase sQLiteDatabase, String string, zzcgy zzcgy2) {
        this.zza = sQLiteDatabase;
        this.zzb = string;
        this.zzc = zzcgy2;
    }

    @Override
    public final void run() {
        zzedq.zzg((SQLiteDatabase)this.zza, (String)this.zzb, (zzcgy)this.zzc);
    }
}
