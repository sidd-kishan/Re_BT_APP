/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbbi
 *  com.google.android.gms.internal.ads.zzggm
 */
package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzggm;
import java.util.ArrayList;

public final class zzedd {
    public static ArrayList<zzbbi> zza(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzbbi> arrayList = new ArrayList<zzbbi>();
        sQLiteDatabase = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
        while (true) {
            if (!sQLiteDatabase.moveToNext()) {
                sQLiteDatabase.close();
                return arrayList;
            }
            byte[] byArray = sQLiteDatabase.getBlob(sQLiteDatabase.getColumnIndexOrThrow("serialized_proto_data"));
            try {
                arrayList.add(zzbbi.zzi((byte[])byArray));
            }
            catch (zzggm zzggm2) {
                zze.zzf((String)"Unable to deserialize proto from offline signals database:");
                zze.zzf((String)zzggm2.getMessage());
                continue;
            }
            break;
        }
    }

    public static int zzb(SQLiteDatabase sQLiteDatabase, int n) {
        if ((sQLiteDatabase = zzedd.zzd(sQLiteDatabase, n)).getCount() > 0) {
            sQLiteDatabase.moveToNext();
            n = sQLiteDatabase.getInt(sQLiteDatabase.getColumnIndexOrThrow("value"));
        } else {
            n = 0;
        }
        sQLiteDatabase.close();
        return n;
    }

    public static long zzc(SQLiteDatabase sQLiteDatabase, int n) {
        long l;
        if ((sQLiteDatabase = zzedd.zzd(sQLiteDatabase, 2)).getCount() > 0) {
            sQLiteDatabase.moveToNext();
            l = sQLiteDatabase.getLong(sQLiteDatabase.getColumnIndexOrThrow("value"));
        } else {
            l = 0L;
        }
        sQLiteDatabase.close();
        return l;
    }

    private static Cursor zzd(SQLiteDatabase sQLiteDatabase, int n) {
        String[] stringArray = new String[1];
        stringArray[0] = n != 0 ? (n != 1 ? "last_successful_request_time" : "total_requests") : "failed_requests";
        return sQLiteDatabase.query("offline_signal_statistics", new String[]{"value"}, "statistic_name = ?", stringArray, null, null, null);
    }
}
