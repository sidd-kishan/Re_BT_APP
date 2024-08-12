/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.internal.ads.zzedi
 *  com.google.android.gms.internal.ads.zzfdw
 */
package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzedi;
import com.google.android.gms.internal.ads.zzfdw;

final class zzede
implements zzfdw {
    private final zzedi zza;
    private final boolean zzb;

    zzede(zzedi zzedi2, boolean bl) {
        this.zza = zzedi2;
        this.zzb = bl;
    }

    public final Object zza(Object object) {
        this.zza.zzb(this.zzb, (SQLiteDatabase)object);
        return null;
    }
}
