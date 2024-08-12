/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbbd
 *  com.google.android.gms.internal.ads.zzbbm
 *  com.google.android.gms.internal.ads.zzeda
 *  com.google.android.gms.internal.ads.zzedb
 *  com.google.android.gms.internal.ads.zzfdw
 */
package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzeda;
import com.google.android.gms.internal.ads.zzedb;
import com.google.android.gms.internal.ads.zzfdw;
import java.util.ArrayList;

final class zzecz
implements zzfdw {
    private final zzeda zza;
    private final boolean zzb;
    private final ArrayList zzc;
    private final zzbbd zzd;
    private final zzbbm zze;

    zzecz(zzeda zzeda2, boolean bl, ArrayList arrayList, zzbbd zzbbd2, zzbbm zzbbm2) {
        this.zza = zzeda2;
        this.zzb = bl;
        this.zzc = arrayList;
        this.zzd = zzbbd2;
        this.zze = zzbbm2;
    }

    public final Object zza(Object object) {
        Object object2 = this.zza;
        boolean bl = this.zzb;
        ArrayList arrayList = this.zzc;
        zzbbd zzbbd2 = this.zzd;
        zzbbm zzbbm2 = this.zze;
        object = (SQLiteDatabase)object;
        if (zzedb.zzb((zzedb)object2.zzb).zzC()) return null;
        object2 = zzedb.zze((zzedb)object2.zzb, (boolean)bl, (ArrayList)arrayList, (zzbbd)zzbbd2, (zzbbm)zzbbm2);
        arrayList = new ContentValues();
        arrayList.put("timestamp", zzt.zzj().currentTimeMillis());
        arrayList.put("serialized_proto_data", (byte[])object2);
        object.insert("offline_signal_contents", null, (ContentValues)arrayList);
        object.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
        if (bl) return null;
        object.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "failed_requests"));
        return null;
    }
}
