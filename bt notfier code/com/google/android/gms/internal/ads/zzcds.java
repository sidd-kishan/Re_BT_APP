/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.view.View
 *  com.google.android.gms.ads.internal.util.zzbr
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzble
 *  com.google.android.gms.internal.ads.zzcdn
 *  com.google.android.gms.internal.ads.zzcdo
 *  com.google.android.gms.internal.ads.zzcdp
 *  com.google.android.gms.internal.ads.zzcdq
 *  com.google.android.gms.internal.ads.zzcdr
 *  com.google.android.gms.internal.ads.zzcdu
 *  com.google.android.gms.internal.ads.zzcdv
 *  com.google.android.gms.internal.ads.zzcdx
 *  com.google.android.gms.internal.ads.zzcdy
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzgev
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgji
 *  com.google.android.gms.internal.ads.zzgjk
 *  com.google.android.gms.internal.ads.zzgjm
 *  com.google.android.gms.internal.ads.zzgjq
 *  com.google.android.gms.internal.ads.zzgjv
 *  com.google.android.gms.internal.ads.zzgjx
 *  com.google.android.gms.internal.ads.zzgkb
 *  com.google.android.gms.internal.ads.zzgkc
 *  com.google.android.gms.internal.ads.zzgkd
 *  com.google.android.gms.internal.ads.zzgkf
 *  com.google.android.gms.internal.ads.zzgkg
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzble;
import com.google.android.gms.internal.ads.zzcdn;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzcdp;
import com.google.android.gms.internal.ads.zzcdq;
import com.google.android.gms.internal.ads.zzcdr;
import com.google.android.gms.internal.ads.zzcdu;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzcdx;
import com.google.android.gms.internal.ads.zzcdy;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzgev;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgji;
import com.google.android.gms.internal.ads.zzgjk;
import com.google.android.gms.internal.ads.zzgjm;
import com.google.android.gms.internal.ads.zzgjq;
import com.google.android.gms.internal.ads.zzgjv;
import com.google.android.gms.internal.ads.zzgjx;
import com.google.android.gms.internal.ads.zzgkb;
import com.google.android.gms.internal.ads.zzgkc;
import com.google.android.gms.internal.ads.zzgkd;
import com.google.android.gms.internal.ads.zzgkf;
import com.google.android.gms.internal.ads.zzgkg;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzcds
implements zzcdy {
    public static final int zzb = 0;
    private static final List<Future<Void>> zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzgji zzd;
    private final LinkedHashMap<String, zzgkc> zze;
    private final List<String> zzf = new ArrayList<String>();
    private final List<String> zzg = new ArrayList<String>();
    private final Context zzh;
    private final zzcdv zzi;
    private final Object zzj = new Object();
    private HashSet<String> zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;
    private final zzcdu zzn;

    public zzcds(Context object, zzcgz object2, zzcdv object32, String string, zzcdu zzcdu2, byte[] object4) {
        long l;
        Preconditions.checkNotNull((Object)object32, (Object)"SafeBrowsing config is not present.");
        object4 = object;
        if (object.getApplicationContext() != null) {
            object4 = object.getApplicationContext();
        }
        this.zzh = (Context)object4;
        this.zze = new LinkedHashMap();
        this.zzn = zzcdu2;
        this.zzi = object32;
        for (Object object32 : ((zzcdv)object32).zze) {
            this.zzk.add(((String)object32).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        object = zzgkg.zze();
        object.zzn(9);
        object.zzb(string);
        object.zzc(string);
        object32 = zzgjk.zza();
        string = this.zzi.zza;
        if (string != null) {
            object32.zza(string);
        }
        object.zzd((zzgjk)object32.zzah());
        object32 = zzgkf.zza();
        object32.zzc(Wrappers.packageManager((Context)this.zzh).isCallerInstantApp());
        object2 = object2.zza;
        if (object2 != null) {
            object32.zza((String)object2);
        }
        if ((l = (long)GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh)) > 0L) {
            object32.zzb(l);
        }
        object.zzk((zzgkf)object32.zzah());
        this.zzd = object;
    }

    static /* synthetic */ List zza() {
        return zzc;
    }

    public final zzcdv zzb() {
        return this.zzi;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc(String string) {
        Object object = this.zzj;
        synchronized (object) {
            if (string == null) {
                this.zzd.zzi();
            } else {
                this.zzd.zzh(string);
            }
            return;
        }
    }

    public final boolean zzd() {
        if (!PlatformVersion.isAtLeastKitKat()) return false;
        if (!this.zzi.zzc) return false;
        if (this.zzl) return false;
        return true;
    }

    public final void zze(View view) {
        block15: {
            if (!this.zzi.zzc) {
                return;
            }
            if (this.zzl) {
                return;
            }
            zzt.zzc();
            Object var7_3 = null;
            if (view == null) {
                view = var7_3;
            } else {
                Canvas canvas;
                Object object;
                block14: {
                    boolean bl;
                    try {
                        bl = view.isDrawingCacheEnabled();
                        view.setDrawingCacheEnabled(true);
                        object = view.getDrawingCache();
                        object = object != null ? Bitmap.createBitmap((Bitmap)object) : null;
                    }
                    catch (RuntimeException runtimeException) {
                        object = null;
                        break block14;
                    }
                    try {
                        view.setDrawingCacheEnabled(bl);
                    }
                    catch (RuntimeException runtimeException) {}
                }
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Fail to capture the web view", (Throwable)canvas);
                if (object == null) {
                    try {
                        int n = view.getWidth();
                        int n2 = view.getHeight();
                        if (n != 0 && n2 != 0) {
                            object = Bitmap.createBitmap((int)view.getWidth(), (int)view.getHeight(), (Bitmap.Config)Bitmap.Config.RGB_565);
                            canvas = new Canvas(object);
                            view.layout(0, 0, n, n2);
                            view.draw(canvas);
                            view = object;
                            break block15;
                        }
                        com.google.android.gms.ads.internal.util.zze.zzi((String)"Width or height of view is zero");
                        view = var7_3;
                    }
                    catch (RuntimeException runtimeException) {
                        com.google.android.gms.ads.internal.util.zze.zzg((String)"Fail to capture the webview", (Throwable)runtimeException);
                        view = var7_3;
                    }
                } else {
                    view = object;
                }
            }
        }
        if (view == null) {
            zzcdx.zza((String)"Failed to capture the webview bitmap.");
            return;
        }
        this.zzl = true;
        zzs.zzo((Runnable)new zzcdn(this, (Bitmap)view));
    }

    /*
     * Unable to fully structure code
     */
    public final void zzf(String var1_1, Map<String, String> var2_3, int var3_4) {
        var5_5 = this.zzj;
        synchronized (var5_5) {
            if (var3_4 != 3) ** GOTO lbl6
            try {
                this.zzm = true;
lbl6:
                // 2 sources

                if (this.zze.containsKey(var1_1)) {
                    if (var3_4 != 3) return;
                    this.zze.get(var1_1).zze(zzgkb.zza((int)3));
                    return;
                }
                var6_6 = zzgkd.zzd();
                if ((var3_4 = zzgkb.zza((int)var3_4)) != 0) {
                    var6_6.zze(var3_4);
                }
                var6_6.zza(this.zze.size());
                var6_6.zzb(var1_1);
                var7_7 = zzgjq.zza();
                if (this.zzk.size() > 0 && var2_3 != null) {
                    for (Map.Entry<String, String> var4_9 : var2_3.entrySet()) {
                        var2_3 = var4_9.getKey() != null ? var4_9.getKey() : "";
                        var4_9 = var4_9.getValue() != null ? var4_9.getValue() : "";
                        var9_10 = var2_3.toLowerCase(Locale.ENGLISH);
                        if (!this.zzk.contains(var9_10)) continue;
                        var9_10 = zzgjm.zza();
                        var9_10.zza(zzgex.zzv((String)var2_3));
                        var9_10.zzb(zzgex.zzv((String)var4_9));
                        var7_7.zza((zzgjm)var9_10.zzah());
                    }
                }
                var6_6.zzc((zzgjq)var7_7.zzah());
                this.zze.put(var1_1, var6_6);
                return;
            }
            catch (Throwable var1_2) {
                throw var1_2;
            }
        }
    }

    public final void zzg() {
        Object object = this.zzj;
        synchronized (object) {
            this.zze.keySet();
            zzfsm zzfsm2 = zzfsd.zza(Collections.emptyMap());
            zzcdo zzcdo2 = new zzcdo(this);
            zzfsm zzfsm3 = zzfsd.zzi((zzfsm)zzfsm2, (zzfrk)zzcdo2, (Executor)zzchg.zzf);
            zzfsm2 = zzfsd.zzh((zzfsm)zzfsm3, (long)10L, (TimeUnit)TimeUnit.SECONDS, (ScheduledExecutorService)zzchg.zzd);
            zzcdo2 = new zzcdr(this, zzfsm2);
            zzfsd.zzp((zzfsm)zzfsm3, (zzfrz)zzcdo2, (Executor)zzchg.zzf);
            zzc.add((Future<Void>)zzfsm2);
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    final /* synthetic */ zzfsm zzh(Map var1_1) throws Exception {
        block26: {
            if (var1_1 == null) break block26;
            try lbl-1000:
            // 4 sources

            {
                for (Object var6_8 : var1_1.keySet()) {
                    var8_9 = (String)var1_1.get(var6_8);
                    var9_10 /* !! */  = new JSONObject((String)var8_9);
                    var11_12 = var9_10 /* !! */ .optJSONArray("matches");
                    if (var11_12 == null) continue;
                    var8_9 = this.zzj;
                    synchronized (var8_9) {
                        ** break block25
                    }
                }
                break block26;
            }
            catch (JSONException var1_2) {
                if ((Boolean)zzble.zzb.zze() == false) return zzfsd.zzc((Throwable)new Exception("Safebrowsing report transmission failed."));
                com.google.android.gms.ads.internal.util.zze.zze((String)"Failed to get SafeBrowsing metadata", (Throwable)var1_2);
                return zzfsd.zzc((Throwable)new Exception("Safebrowsing report transmission failed."));
            }
lbl-1000:
            // 1 sources

            {
                block27: {
                    var4_6 = var11_12.length();
                    var9_10 /* !! */  = this.zzj;
                    synchronized (var9_10 /* !! */ ) {
                        var10_11 = this.zze.get(var6_8);
                        if (var10_11 != null) break block27;
                    }
                    var6_8 = (var6_8 = String.valueOf(var6_8)).length() != 0 ? "Cannot find the corresponding resource object for ".concat((String)var6_8) : new String("Cannot find the corresponding resource object for ");
                    zzcdx.zza((String)var6_8);
                    ** GOTO lbl-1000
                }
                var3_5 = 0;
                for (var2_4 = 0; var2_4 < var4_6; ++var2_4) {
                    var10_11.zzd(var11_12.getJSONObject(var2_4).getString("threat_type"));
                }
                var5_7 = this.zza;
                var2_4 = var3_5;
                if (var4_6 > 0) {
                    var2_4 = 1;
                }
                this.zza = var2_4 | var5_7;
                ** GOTO lbl-1000
            }
        }
        if (this.zza) {
            var1_1 = this.zzj;
            synchronized (var1_1) {
                this.zzd.zzn(10);
            }
        }
        if (!((var5_7 = this.zza) != 0 && this.zzi.zzg || this.zzm && this.zzi.zzf)) {
            if (var5_7 != 0) return zzfsd.zza(null);
            if (this.zzi.zzd == false) return zzfsd.zza(null);
        }
        var6_8 = this.zzj;
        synchronized (var6_8) {
            for (Object var7_3 : this.zze.values()) {
                this.zzd.zzf((zzgkd)var7_3.zzah());
            }
            this.zzd.zzl(this.zzf);
            this.zzd.zzm(this.zzg);
            if (zzcdx.zzb()) {
                var9_10 /* !! */  = this.zzd.zza();
                var7_3 = this.zzd.zzg();
                var3_5 = String.valueOf(var9_10 /* !! */ ).length();
                var2_4 = String.valueOf(var7_3).length();
                var8_9 = new StringBuilder(var3_5 + 53 + var2_4);
                var8_9.append("Sending SB report\n  url: ");
                var8_9.append((String)var9_10 /* !! */ );
                var8_9.append("\n  clickUrl: ");
                var8_9.append((String)var7_3);
                var8_9.append("\n  resources: \n");
                var1_1 = new StringBuilder(var8_9.toString());
                for (Object var8_9 : this.zzd.zze()) {
                    var1_1.append("    [");
                    var1_1.append(var8_9.zzc());
                    var1_1.append("] ");
                    var1_1.append(var8_9.zza());
                }
                zzcdx.zza((String)var1_1.toString());
            }
            var8_9 = ((zzgkg)this.zzd.zzah()).zzao();
            var7_3 = this.zzi.zzb;
            var1_1 = new zzbr(this.zzh);
            var1_1 = var1_1.zzb(1, (String)var7_3, null, (byte[])var8_9);
            if (zzcdx.zzb() == false) return zzfsd.zzj((zzfsm)var1_1, (zzfln)zzcdq.zza, (Executor)zzchg.zzf);
            var1_1.zze(zzcdp.zza, (Executor)zzchg.zza);
            return zzfsd.zzj((zzfsm)var1_1, (zzfln)zzcdq.zza, (Executor)zzchg.zzf);
        }
    }

    final /* synthetic */ void zzi(Bitmap object) {
        zzgev zzgev2 = zzgex.zzB();
        object.compress(Bitmap.CompressFormat.PNG, 0, (OutputStream)zzgev2);
        object = this.zzj;
        synchronized (object) {
            zzgji zzgji2 = this.zzd;
            zzgjv zzgjv2 = zzgjx.zza();
            zzgjv2.zzb(zzgev2.zza());
            zzgjv2.zza("image/png");
            zzgjv2.zzc(2);
            zzgji2.zzj((zzgjx)zzgjv2.zzah());
            return;
        }
    }
}
