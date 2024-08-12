/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Build
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaza
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzbbd
 *  com.google.android.gms.internal.ads.zzbbi
 *  com.google.android.gms.internal.ads.zzbbn
 *  com.google.android.gms.internal.ads.zzbbz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzecq
 *  com.google.android.gms.internal.ads.zzedd
 *  com.google.android.gms.internal.ads.zzede
 *  com.google.android.gms.internal.ads.zzedf
 *  com.google.android.gms.internal.ads.zzedg
 *  com.google.android.gms.internal.ads.zzedh
 *  com.google.android.gms.internal.ads.zzfdw
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfpb
 */
package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzecq;
import com.google.android.gms.internal.ads.zzedd;
import com.google.android.gms.internal.ads.zzede;
import com.google.android.gms.internal.ads.zzedf;
import com.google.android.gms.internal.ads.zzedg;
import com.google.android.gms.internal.ads.zzedh;
import com.google.android.gms.internal.ads.zzfdw;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfpb;
import java.util.ArrayList;
import java.util.List;

public final class zzedi {
    private final zzazb zza;
    private final Context zzb;
    private final zzecq zzc;
    private final zzcgz zzd;
    private final String zze;
    private final zzffc zzf;
    private final zzg zzg;

    public zzedi(Context context, zzcgz zzcgz2, zzazb zzazb2, zzecq zzecq2, String string, zzffc zzffc2) {
        this.zzb = context;
        this.zzd = zzcgz2;
        this.zza = zzazb2;
        this.zzc = zzecq2;
        this.zze = string;
        this.zzf = zzffc2;
        this.zzg = zzt.zzg().zzp();
    }

    private static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList<zzbbi> contentValues) {
        int n = contentValues.size();
        int n2 = 0;
        long l = 0L;
        while (true) {
            if (n2 >= n) {
                if (l == 0L) return;
                contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(l));
                sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
                return;
            }
            zzbbi zzbbi2 = (zzbbi)contentValues.get(n2);
            long l2 = l;
            if (zzbbi2.zzs() == 2) {
                l2 = l;
                if (zzbbi2.zza() > l) {
                    l2 = zzbbi2.zza();
                }
            }
            ++n2;
            l = l2;
        }
    }

    public final void zza(boolean bl) {
        try {
            zzecq zzecq2 = this.zzc;
            zzede zzede2 = new zzede(this, bl);
            zzecq2.zza((zzfdw)zzede2);
            return;
        }
        catch (Exception exception) {
            String string = String.valueOf(exception.getMessage());
            string = string.length() != 0 ? "Error in offline signals database startup: ".concat(string) : new String("Error in offline signals database startup: ");
            com.google.android.gms.ads.internal.util.zze.zzf((String)string);
            return;
        }
    }

    final /* synthetic */ Void zzb(boolean bl, SQLiteDatabase sQLiteDatabase) throws Exception {
        if (bl) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            Object object;
            Object object2 = zzbjl.zzgi;
            bl = (Boolean)zzbet.zzc().zzc(object2);
            int n = 2;
            if (!bl) {
                object2 = zzedd.zza((SQLiteDatabase)sQLiteDatabase);
                object = zzbbn.zza();
                object.zze(this.zzb.getPackageName());
                object.zzf(Build.MODEL);
                object.zzb(zzedd.zzb((SQLiteDatabase)sQLiteDatabase, (int)0));
                object.zza((Iterable)object2);
                object.zzc(zzedd.zzb((SQLiteDatabase)sQLiteDatabase, (int)1));
                object.zzd(zzt.zzj().currentTimeMillis());
                object.zzg(zzedd.zzc((SQLiteDatabase)sQLiteDatabase, (int)2));
                object = (zzbbn)object.zzah();
                zzedi.zzc(sQLiteDatabase, (ArrayList<zzbbi>)object2);
                this.zza.zzb((zzaza)new zzedf((zzbbn)object));
                object2 = zzbbz.zza();
                object2.zza(this.zzd.zzb);
                object2.zzb(this.zzd.zzc);
                if (this.zzd.zzd) {
                    n = 0;
                }
                object2.zzc(n);
                object2 = (zzbbz)object2.zzah();
                this.zza.zzb((zzaza)new zzedg((zzbbz)object2));
                this.zza.zzc(10004);
            } else {
                object = zzffb.zza((String)"oa_upload");
                object.zzc("oa_failed_reqs", String.valueOf(zzedd.zzb((SQLiteDatabase)sQLiteDatabase, (int)0)));
                object.zzc("oa_total_reqs", String.valueOf(zzedd.zzb((SQLiteDatabase)sQLiteDatabase, (int)1)));
                object.zzc("oa_upload_time", String.valueOf(zzt.zzj().currentTimeMillis()));
                object.zzc("oa_last_successful_time", String.valueOf(zzedd.zzc((SQLiteDatabase)sQLiteDatabase, (int)2)));
                object2 = this.zzg.zzC() ? "" : this.zze;
                object.zzc("oa_session_id", (String)object2);
                this.zzf.zza((zzffb)object);
                object = zzedd.zza((SQLiteDatabase)sQLiteDatabase);
                zzedi.zzc(sQLiteDatabase, (ArrayList<zzbbi>)object);
                int n2 = object.size();
                for (n = 0; n < n2; ++n) {
                    zzbbi zzbbi2 = (zzbbi)object.get(n);
                    zzffb zzffb2 = zzffb.zza((String)"oa_signals");
                    object2 = this.zzg.zzC() ? "" : this.zze;
                    zzffb2.zzc("oa_session_id", (String)object2);
                    zzbbd zzbbd2 = zzbbi2.zzf();
                    object2 = zzbbd2.zza() ? String.valueOf(zzbbd2.zzg() - 1) : "-1";
                    String string = zzfpb.zzb((List)zzbbi2.zze(), (zzfln)zzedh.zza).toString();
                    zzffb2.zzc("oa_sig_ts", String.valueOf(zzbbi2.zza()));
                    zzffb2.zzc("oa_sig_status", String.valueOf(zzbbi2.zzs() - 1));
                    zzffb2.zzc("oa_sig_resp_lat", String.valueOf(zzbbi2.zzc()));
                    zzffb2.zzc("oa_sig_render_lat", String.valueOf(zzbbi2.zzd()));
                    zzffb2.zzc("oa_sig_formats", string);
                    zzffb2.zzc("oa_sig_nw_type", (String)object2);
                    zzffb2.zzc("oa_sig_wifi", String.valueOf(zzbbi2.zzt() - 1));
                    zzffb2.zzc("oa_sig_airplane", String.valueOf(zzbbi2.zzu() - 1));
                    zzffb2.zzc("oa_sig_data", String.valueOf(zzbbi2.zzv() - 1));
                    zzffb2.zzc("oa_sig_nw_resp", String.valueOf(zzbbi2.zzg()));
                    zzffb2.zzc("oa_sig_offline", String.valueOf(zzbbi2.zzw() - 1));
                    zzffb2.zzc("oa_sig_nw_state", String.valueOf(zzbbi2.zzh().zza()));
                    if (zzbbd2.zzc() && zzbbd2.zza() && zzbbd2.zzg() == 2) {
                        zzffb2.zzc("oa_sig_cell_type", String.valueOf(zzbbd2.zzh() - 1));
                    }
                    this.zzf.zza(zzffb2);
                }
            }
            sQLiteDatabase.delete("offline_signal_contents", null, null);
            object = new ContentValues();
            object2 = 0;
            object.put("value", (Integer)object2);
            sQLiteDatabase.update("offline_signal_statistics", (ContentValues)object, "statistic_name = ?", new String[]{"failed_requests"});
            object = new ContentValues();
            object.put("value", (Integer)object2);
            sQLiteDatabase.update("offline_signal_statistics", (ContentValues)object, "statistic_name = ?", new String[]{"total_requests"});
        }
        return null;
    }
}
