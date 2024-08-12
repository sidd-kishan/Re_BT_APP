/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzcfc
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzehp
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfam
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzcfc;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzehp;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzffr {
    private final zzehp zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfam zzf;
    private final Clock zzg;
    private final zzaas zzh;

    public zzffr(zzehp zzehp2, zzcgz zzcgz2, String string, String string2, Context context, zzfam zzfam2, Clock clock, zzaas zzaas2) {
        this.zza = zzehp2;
        this.zzb = zzcgz2.zza;
        this.zzc = string;
        this.zzd = string2;
        this.zze = context;
        this.zzf = zzfam2;
        this.zzg = clock;
        this.zzh = zzaas2;
    }

    public static final List<String> zzd(int n, int n2, List<String> object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        object = object.iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            StringBuilder stringBuilder = new StringBuilder(23);
            stringBuilder.append("2.");
            stringBuilder.append(n2);
            arrayList.add(zzffr.zze(string, "@gw_mpe@", stringBuilder.toString()));
        }
        return arrayList;
    }

    private static String zze(String string, String string2, String string3) {
        String string4 = string3;
        if (true != TextUtils.isEmpty((CharSequence)string3)) return string.replaceAll(string2, string4);
        string4 = "";
        return string.replaceAll(string2, string4);
    }

    private static String zzf(String string) {
        String string2 = string;
        if (TextUtils.isEmpty((CharSequence)string)) return string2;
        string2 = string;
        if (!zzcgs.zzj()) return string2;
        string2 = "fakeForAdDebugLog";
        return string2;
    }

    public final List<String> zza(zzfal zzfal2, zzezz zzezz2, List<String> list) {
        return this.zzb(zzfal2, zzezz2, false, "", "", list);
    }

    public final List<String> zzb(zzfal zzfal2, zzezz zzezz2, boolean bl, String string, String string2, List<String> object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string3 = true != bl ? "0" : "1";
        Iterator<String> iterator = object.iterator();
        while (iterator.hasNext()) {
            block11: {
                boolean bl2;
                boolean bl3;
                Object object2;
                block10: {
                    boolean bl4;
                    object = object2 = zzffr.zze(zzffr.zze(zzffr.zze(iterator.next(), "@gw_adlocid@", zzfal2.zza.zza.zzf), "@gw_adnetrefresh@", string3), "@gw_sdkver@", this.zzb);
                    if (zzezz2 != null) {
                        object = zzcfc.zza((String)zzffr.zze(zzffr.zze(zzffr.zze((String)object2, "@gw_qdata@", zzezz2.zzy), "@gw_adnetid@", zzezz2.zzx), "@gw_allocid@", zzezz2.zzw), (Context)this.zze, (boolean)zzezz2.zzS);
                    }
                    object2 = zzffr.zze(zzffr.zze(zzffr.zze((String)object, "@gw_adnetstatus@", this.zza.zzg()), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
                    object = zzbjl.zzca;
                    bl = (Boolean)zzbet.zzc().zzc((zzbjd)object);
                    bl2 = bl3 = false;
                    if (bl) {
                        bl2 = bl3;
                        if (!TextUtils.isEmpty((CharSequence)string)) {
                            bl2 = true;
                        }
                    }
                    bl3 = bl4 = TextUtils.isEmpty((CharSequence)string2) ^ true;
                    if (bl2) break block10;
                    object = object2;
                    if (!bl4) break block11;
                    bl3 = true;
                }
                Uri uri = Uri.parse((String)object2);
                object = object2;
                if (this.zzh.zza(uri)) {
                    object = object2 = Uri.parse((String)object2).buildUpon();
                    if (bl2) {
                        object = object2.appendQueryParameter("ms", string);
                    }
                    object2 = object;
                    if (bl3) {
                        object2 = object.appendQueryParameter("attok", string2);
                    }
                    object = object2.build().toString();
                }
            }
            arrayList.add((String)object);
        }
        return arrayList;
    }

    public final List<String> zzc(zzezz zzezz2, List<String> object, zzcbz object2) {
        String string;
        String string2;
        String string3;
        ArrayList<String> arrayList = new ArrayList<String>();
        long l = this.zzg.currentTimeMillis();
        try {
            string3 = object2.zzb();
            string2 = Integer.toString(object2.zzc());
            object2 = this.zzf;
            string = "";
            object2 = object2 == null ? "" : zzffr.zzf(object2.zza);
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to determine award type and amount.", (Throwable)remoteException);
            return arrayList;
        }
        zzfam zzfam2 = this.zzf;
        if (zzfam2 != null) {
            string = zzffr.zzf(zzfam2.zzb);
        }
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(zzcfc.zza((String)zzffr.zze(zzffr.zze(zzffr.zze(zzffr.zze(zzffr.zze(zzffr.zze((String)object.next(), "@gw_rwd_userid@", Uri.encode((String)object2)), "@gw_rwd_custom_data@", Uri.encode((String)string)), "@gw_tmstmp@", Long.toString(l)), "@gw_rwd_itm@", Uri.encode((String)string3)), "@gw_rwd_amt@", string2), "@gw_sdkver@", this.zzb), (Context)this.zze, (boolean)zzezz2.zzS));
        }
        return arrayList;
    }
}
