/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzblc
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrp
 *  com.google.android.gms.internal.ads.zzbrs
 *  com.google.android.gms.internal.ads.zzbrv
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdht
 *  com.google.android.gms.internal.ads.zzdtf
 *  com.google.android.gms.internal.ads.zzdvr
 *  com.google.android.gms.internal.ads.zzdwz
 *  com.google.android.gms.internal.ads.zzdxb
 *  com.google.android.gms.internal.ads.zzdxc
 *  com.google.android.gms.internal.ads.zzdxd
 *  com.google.android.gms.internal.ads.zzdxe
 *  com.google.android.gms.internal.ads.zzdxf
 *  com.google.android.gms.internal.ads.zzdxg
 *  com.google.android.gms.internal.ads.zzdxi
 *  com.google.android.gms.internal.ads.zzdxj
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbrv;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdht;
import com.google.android.gms.internal.ads.zzdtf;
import com.google.android.gms.internal.ads.zzdvr;
import com.google.android.gms.internal.ads.zzdwz;
import com.google.android.gms.internal.ads.zzdxb;
import com.google.android.gms.internal.ads.zzdxc;
import com.google.android.gms.internal.ads.zzdxd;
import com.google.android.gms.internal.ads.zzdxe;
import com.google.android.gms.internal.ads.zzdxf;
import com.google.android.gms.internal.ads.zzdxg;
import com.google.android.gms.internal.ads.zzdxi;
import com.google.android.gms.internal.ads.zzdxj;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdxk {
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final long zzd;
    private final zzchl<Boolean> zze = new zzchl();
    private final Context zzf;
    private final WeakReference<Context> zzg;
    private final zzdtf zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdvr zzl;
    private final zzcgz zzm;
    private final Map<String, zzbrl> zzn = new ConcurrentHashMap<String, zzbrl>();
    private final zzdht zzo;
    private boolean zzp = true;

    public zzdxk(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzdtf zzdtf2, ScheduledExecutorService scheduledExecutorService, zzdvr zzdvr2, zzcgz zzcgz2, zzdht zzdht2) {
        this.zzh = zzdtf2;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdvr2;
        this.zzm = zzcgz2;
        this.zzo = zzdht2;
        this.zzd = zzt.zzj().elapsedRealtime();
        this.zzu("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* synthetic */ boolean zza(zzdxk zzdxk2, boolean bl) {
        zzdxk2.zzc = true;
        return true;
    }

    static /* synthetic */ long zzb(zzdxk zzdxk2) {
        return zzdxk2.zzd;
    }

    static /* synthetic */ zzchl zzc(zzdxk zzdxk2) {
        return zzdxk2.zze;
    }

    static /* synthetic */ Executor zzd(zzdxk zzdxk2) {
        return zzdxk2.zzi;
    }

    static /* synthetic */ zzdvr zze(zzdxk zzdxk2) {
        return zzdxk2.zzl;
    }

    static /* synthetic */ zzdht zzf(zzdxk zzdxk2) {
        return zzdxk2.zzo;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    static /* synthetic */ void zzk(zzdxk var0, String var1_2) {
        block15: {
            try {
                var5_3 = new ArrayList();
                var6_4 = new JSONObject((String)var1_2);
                var6_4 = var6_4.getJSONObject("initializer_settings").getJSONObject("config");
                var1_2 = var6_4.keys();
lbl6:
                // 4 sources

                while (var1_2.hasNext()) {
                    var7_7 = (String)var1_2.next();
                    var10_12 = new Object();
                    var9_11 = new zzchl();
                    var8_10 = zzbjl.zzbj;
                    var8_10 = zzfsd.zzh((zzfsm)var9_11, (long)((Long)zzbet.zzc().zzc(var8_10)), (TimeUnit)TimeUnit.SECONDS, (ScheduledExecutorService)var0.zzk);
                    var0.zzl.zza(var7_7);
                    var0.zzo.zza(var7_7);
                    var3_6 = zzt.zzj().elapsedRealtime();
                    var11_14 = new zzdxd(var0, var10_12, (zzchl)var9_11, var7_7, var3_6);
                    var8_10.zze((Runnable)var11_14, var0.zzi);
                    var5_3.add(var8_10);
                    var8_10 = new zzdxj(var0, var10_12, var7_7, var3_6, (zzchl)var9_11);
                    var10_12 = var6_4.optJSONObject(var7_7);
                    var9_11 = new ArrayList();
                    if (var10_12 != null) {
                        break block15;
                    }
                    ** GOTO lbl49
                }
                ** GOTO lbl66
            }
            catch (JSONException var0_1) {
                com.google.android.gms.ads.internal.util.zze.zzb((String)"Malformed CLD response", (Throwable)var0_1);
                return;
            }
        }
        var11_14 = var10_12.getJSONArray("data");
        for (var2_5 = 0; var2_5 < var11_14.length(); ++var2_5) {
            var12_15 = var11_14.getJSONObject(var2_5);
            var10_12 = var12_15.optString("format", "");
            var14_17 = var12_15.optJSONObject("data");
            var12_15 = new Bundle();
            if (var14_17 != null) {
                var13_16 = var14_17.keys();
                while (var13_16.hasNext()) {
                    var15_18 = (String)var13_16.next();
                    var12_15.putString(var15_18, var14_17.optString(var15_18, ""));
                }
            }
            var13_16 = new zzbrv((String)var10_12, (Bundle)var12_15);
            var9_11.add(var13_16);
        }
        {
            catch (JSONException var10_13) {
                ** continue;
            }
lbl49:
            // 3 sources

            while (true) {
                var0.zzu(var7_7, false, "", 0);
                try {
                    var10_12 = var0.zzh;
                    var11_14 = new JSONObject();
                    var10_12 = var10_12.zzb(var7_7, (JSONObject)var11_14);
                    var11_14 = var0.zzj;
                    var12_15 = new zzdxf(var0, (zzfbi)var10_12, (zzbrp)var8_10, (List)var9_11, var7_7);
                    var11_14.execute((Runnable)var12_15);
                }
                catch (zzfaw var7_8) {
                    try {
                        var8_10.zzf("Failed to create Adapter.");
                        ** GOTO lbl6
                    }
                    catch (RemoteException var7_9) {
                        zzcgt.zzg((String)"", (Throwable)var7_9);
                    }
                }
                ** GOTO lbl6
                break;
            }
lbl66:
            // 1 sources

            var5_3 = zzfsd.zzm(var5_3);
            var1_2 = new zzdxe(var0);
            var5_3.zza((Callable)var1_2, var0.zzi);
            return;
        }
    }

    static /* synthetic */ void zzl(zzdxk zzdxk2, String string, boolean bl, String string2, int n) {
        zzdxk2.zzu(string, bl, string2, n);
    }

    private final zzfsm<String> zzt() {
        synchronized (this) {
            String string = zzt.zzg().zzp().zzn().zzd();
            if (!TextUtils.isEmpty((CharSequence)string)) {
                string = zzfsd.zza((Object)string);
                return string;
            }
            zzchl zzchl2 = new zzchl();
            zzg zzg2 = zzt.zzg().zzp();
            string = new zzdxb(this, zzchl2);
            zzg2.zzp((Runnable)((Object)string));
            return zzchl2;
        }
    }

    private final void zzu(String string, boolean bl, String string2, int n) {
        this.zzn.put(string, new zzbrl(string, bl, n, string2));
    }

    public final void zzg() {
        this.zzp = false;
    }

    public final void zzh(zzbrs zzbrs2) {
        this.zze.zze((Runnable)new zzdwz(this, zzbrs2), this.zzj);
    }

    public final void zzi() {
        if (!((Boolean)zzblc.zza.zze()).booleanValue()) {
            int n = this.zzm.zzc;
            zzfsm<String> zzfsm2 = zzbjl.zzbi;
            if (n >= (Integer)zzbet.zzc().zzc((zzbjd)zzfsm2) && this.zzp) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    if (this.zza) {
                        return;
                    }
                    this.zzl.zzd();
                    this.zzo.zzd();
                    Object object = this.zze;
                    zzfsm2 = new zzfsm<String>(this);
                    object.zze((Runnable)zzfsm2, this.zzi);
                    this.zza = true;
                    zzfsm2 = this.zzt();
                    object = this.zzk;
                    zzdxc zzdxc2 = new zzdxc(this);
                    zzbjd zzbjd2 = zzbjl.zzbk;
                    object.schedule((Runnable)zzdxc2, (long)((Long)zzbet.zzc().zzc(zzbjd2)), TimeUnit.SECONDS);
                    object = new zzdxi(this);
                    zzfsd.zzp(zzfsm2, (zzfrz)object, (Executor)this.zzi);
                    return;
                }
            }
        }
        if (this.zza) return;
        this.zzu("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc((Object)false);
        this.zza = true;
        this.zzb = true;
    }

    public final List<zzbrl> zzj() {
        ArrayList<zzbrl> arrayList = new ArrayList<zzbrl>();
        Iterator<String> iterator = this.zzn.keySet().iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            zzbrl zzbrl2 = this.zzn.get(string);
            arrayList.add(new zzbrl(string, zzbrl2.zzb, zzbrl2.zzc, zzbrl2.zzd));
        }
        return arrayList;
    }

    public final boolean zzm() {
        return this.zzb;
    }

    final /* synthetic */ void zzn(zzfbi zzfbi2, zzbrp zzbrp2, List list, String string) {
        try {
            Context context = (Context)this.zzg.get();
            if (context == null) {
                context = this.zzf;
            }
            zzfbi2.zzy(context, zzbrp2, list);
            return;
        }
        catch (zzfaw zzfaw2) {
            try {
                int n = String.valueOf(string).length();
                StringBuilder stringBuilder = new StringBuilder(n + 74);
                stringBuilder.append("Failed to initialize adapter. ");
                stringBuilder.append(string);
                stringBuilder.append(" does not implement the initialize() method.");
                zzbrp2.zzf(stringBuilder.toString());
                return;
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"", (Throwable)remoteException);
                return;
            }
        }
    }

    final /* synthetic */ Object zzo() throws Exception {
        this.zze.zzc((Object)true);
        return null;
    }

    final /* synthetic */ void zzp(Object object, zzchl zzchl2, String string, long l) {
        synchronized (object) {
            if (zzchl2.isDone()) return;
            this.zzu(string, false, "Timeout.", (int)(zzt.zzj().elapsedRealtime() - l));
            this.zzl.zzc(string, "timeout");
            this.zzo.zzc(string, "timeout");
            zzchl2.zzc((Object)false);
            return;
        }
    }

    final /* synthetic */ void zzq() {
        synchronized (this) {
            if (this.zzc) {
                return;
            }
            this.zzu("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int)(zzt.zzj().elapsedRealtime() - this.zzd));
            zzchl<Boolean> zzchl2 = this.zze;
            Exception exception = new Exception();
            zzchl2.zzd((Throwable)exception);
            return;
        }
    }

    final /* synthetic */ void zzr(zzchl zzchl2) {
        this.zzi.execute((Runnable)new zzdxg(this, zzchl2));
    }

    final /* synthetic */ void zzs() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }
}
