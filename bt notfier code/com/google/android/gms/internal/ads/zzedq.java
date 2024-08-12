/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzedj
 *  com.google.android.gms.internal.ads.zzedl
 *  com.google.android.gms.internal.ads.zzedm
 *  com.google.android.gms.internal.ads.zzedn
 *  com.google.android.gms.internal.ads.zzedo
 *  com.google.android.gms.internal.ads.zzedp
 *  com.google.android.gms.internal.ads.zzeds
 *  com.google.android.gms.internal.ads.zzfdw
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzedj;
import com.google.android.gms.internal.ads.zzedl;
import com.google.android.gms.internal.ads.zzedm;
import com.google.android.gms.internal.ads.zzedn;
import com.google.android.gms.internal.ads.zzedo;
import com.google.android.gms.internal.ads.zzedp;
import com.google.android.gms.internal.ads.zzeds;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzedq
extends SQLiteOpenHelper {
    private final Context zza;
    private final zzfsn zzb;

    public zzedq(Context context, zzfsn zzfsn2) {
        zzbjd zzbjd2 = zzbjl.zzfZ;
        super(context, "AdMobOfflineBufferedPings.db", null, ((Integer)zzbet.zzc().zzc(zzbjd2)).intValue());
        this.zza = context;
        this.zzb = zzfsn2;
    }

    static final /* synthetic */ void zzg(SQLiteDatabase sQLiteDatabase, String string, zzcgy zzcgy2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", Integer.valueOf(1));
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{string});
        zzedq.zzj(sQLiteDatabase, zzcgy2);
    }

    static final /* synthetic */ Void zzh(zzcgy zzcgy2, SQLiteDatabase sQLiteDatabase) throws Exception {
        zzedq.zzj(sQLiteDatabase, zzcgy2);
        return null;
    }

    static final void zzi(SQLiteDatabase sQLiteDatabase, String string) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{string, Integer.toString(0)});
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private static void zzj(SQLiteDatabase sQLiteDatabase, zzcgy zzcgy2) {
        int n;
        int n2;
        int n3;
        Cursor cursor;
        String[] stringArray;
        sQLiteDatabase.beginTransaction();
        try {
            stringArray = new StringBuilder(25);
            stringArray.append("event_state = ");
            stringArray.append(1);
            stringArray = stringArray.toString();
            cursor = sQLiteDatabase.query("offline_buffered_pings", new String[]{"url"}, (String)stringArray, null, null, null, "timestamp ASC", null);
            n3 = cursor.getCount();
            stringArray = new String[n3];
            n2 = 0;
            n = 0;
            while (cursor.moveToNext()) {
                int n4 = cursor.getColumnIndex("url");
                if (n4 != -1) {
                    stringArray[n] = cursor.getString(n4);
                }
                ++n;
            }
        }
        catch (Throwable throwable) {
            sQLiteDatabase.endTransaction();
            throw throwable;
        }
        {
            cursor.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
        }
        sQLiteDatabase.endTransaction();
        n = n2;
        while (n < n3) {
            zzcgy2.zza(stringArray[n]);
            ++n;
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    final void zza(zzfdw<SQLiteDatabase, Void> zzfdw2) {
        zzfsd.zzp((zzfsm)this.zzb.zzb((Callable)new zzedj(this)), (zzfrz)new zzedp(this, zzfdw2), (Executor)this.zzb);
    }

    final void zzb(SQLiteDatabase sQLiteDatabase, zzcgy zzcgy2, String string) {
        this.zzb.execute((Runnable)new zzedl(sQLiteDatabase, string, zzcgy2));
    }

    public final void zzc(zzcgy zzcgy2, String string) {
        this.zza((zzfdw<SQLiteDatabase, Void>)new zzedm(this, zzcgy2, string));
    }

    public final void zzd(String string) {
        this.zza((zzfdw<SQLiteDatabase, Void>)new zzedn(this, string));
    }

    public final void zze(zzeds zzeds2) {
        this.zza((zzfdw<SQLiteDatabase, Void>)new zzedo(this, zzeds2));
    }

    final /* synthetic */ Void zzf(zzeds zzeds2, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzeds2.zza));
        contentValues.put("gws_query_id", zzeds2.zzb);
        contentValues.put("url", zzeds2.zzc);
        contentValues.put("event_state", Integer.valueOf(zzeds2.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", null, contentValues);
        zzt.zzc();
        zzeds2 = zzs.zzD((Context)this.zza);
        if (zzeds2 == null) return null;
        try {
            zzeds2.zzf(ObjectWrapper.wrap((Object)this.zza));
        }
        catch (RemoteException remoteException) {
            zze.zzb((String)"Failed to schedule offline ping sender.", (Throwable)remoteException);
        }
        return null;
    }
}
