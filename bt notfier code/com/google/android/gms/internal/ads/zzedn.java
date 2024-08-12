/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzfdw
 */
package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzfdw;

final class zzedn
implements zzfdw {
    private final zzedq zza;
    private final String zzb;

    zzedn(zzedq zzedq2, String string) {
        this.zza = zzedq2;
        this.zzb = string;
    }

    public final Object zza(Object object) {
        String string = this.zzb;
        zzedq.zzi((SQLiteDatabase)((SQLiteDatabase)object), (String)string);
        return null;
    }
}
