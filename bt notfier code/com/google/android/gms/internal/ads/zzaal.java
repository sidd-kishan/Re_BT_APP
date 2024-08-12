/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzaai
 *  com.google.android.gms.internal.ads.zzaaj
 *  com.google.android.gms.internal.ads.zzaak
 *  com.google.android.gms.internal.ads.zzaao
 *  com.google.android.gms.internal.ads.zzaav
 *  com.google.android.gms.internal.ads.zzabk
 *  com.google.android.gms.internal.ads.zzabl
 *  com.google.android.gms.internal.ads.zzaby
 *  com.google.android.gms.internal.ads.zzadf
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzfie
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfij
 *  com.google.android.gms.internal.ads.zzfik
 *  com.google.android.gms.internal.ads.zzfil
 *  com.google.android.gms.internal.ads.zzfis
 *  com.google.android.gms.internal.ads.zzfjb
 *  com.google.android.gms.internal.ads.zzfjk
 *  com.google.android.gms.internal.ads.zzfjl
 *  com.google.android.gms.internal.ads.zzfjw
 *  com.google.android.gms.internal.ads.zzfjx
 *  com.google.android.gms.internal.ads.zzfkd
 *  com.google.android.gms.internal.ads.zzfke
 *  com.google.android.gms.internal.ads.zzfkf
 *  com.google.android.gms.internal.ads.zzfkg
 *  com.google.android.gms.internal.ads.zzfkh
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaai;
import com.google.android.gms.internal.ads.zzaaj;
import com.google.android.gms.internal.ads.zzaak;
import com.google.android.gms.internal.ads.zzaao;
import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzabk;
import com.google.android.gms.internal.ads.zzabl;
import com.google.android.gms.internal.ads.zzaby;
import com.google.android.gms.internal.ads.zzadf;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzfie;
import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfij;
import com.google.android.gms.internal.ads.zzfik;
import com.google.android.gms.internal.ads.zzfil;
import com.google.android.gms.internal.ads.zzfis;
import com.google.android.gms.internal.ads.zzfjb;
import com.google.android.gms.internal.ads.zzfjk;
import com.google.android.gms.internal.ads.zzfjl;
import com.google.android.gms.internal.ads.zzfjw;
import com.google.android.gms.internal.ads.zzfjx;
import com.google.android.gms.internal.ads.zzfkd;
import com.google.android.gms.internal.ads.zzfke;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzfkg;
import com.google.android.gms.internal.ads.zzfkh;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class zzaal
implements zzaao {
    private static zzaal zzb;
    volatile long zza = 0L;
    private final Context zzc;
    private final zzfjx zzd;
    private final zzfke zze;
    private final zzfkg zzf;
    private final zzabl zzg;
    private final zzfii zzh;
    private final Executor zzi;
    private final zzfkd zzj;
    private final CountDownLatch zzk;
    private final Object zzl = new Object();
    private volatile boolean zzm;
    private volatile boolean zzn = false;
    private final int zzo;

    zzaal(Context context, zzfii zzfii2, zzfjx zzfjx2, zzfke zzfke2, zzfkg zzfkg2, zzabl zzabl2, Executor executor, zzfie zzfie2, int n) {
        this.zzc = context;
        this.zzh = zzfii2;
        this.zzd = zzfjx2;
        this.zze = zzfke2;
        this.zzf = zzfkg2;
        this.zzg = zzabl2;
        this.zzi = executor;
        this.zzo = n;
        this.zzk = new CountDownLatch(1);
        this.zzj = new zzaaj(this, zzfie2);
    }

    static /* synthetic */ zzfii zza(zzaal zzaal2) {
        return zzaal2.zzh;
    }

    static /* synthetic */ Object zzb(zzaal zzaal2) {
        return zzaal2.zzl;
    }

    static /* synthetic */ boolean zzc(zzaal zzaal2) {
        return zzaal2.zzm;
    }

    static /* synthetic */ boolean zzd(zzaal zzaal2, boolean bl) {
        zzaal2.zzm = bl;
        return bl;
    }

    @Deprecated
    public static zzaal zze(String object, Context context, Executor executor, boolean bl, boolean bl2) {
        synchronized (zzaal.class) {
            if (zzb == null) {
                zzfij zzfij2 = zzfik.zzd();
                zzfij2.zza((String)object);
                zzfij2.zzb(bl);
                zzfik zzfik2 = zzfij2.zzd();
                zzfij2 = zzfii.zza((Context)context, (Executor)executor, (boolean)bl2);
                object = zzbjl.zzbW;
                object = (Boolean)zzbet.zzc().zzc((zzbjd)object) != false ? zzaav.zzb((Context)context) : null;
                Object object2 = zzfjb.zza((Context)context, (Executor)executor, (zzfii)zzfij2, (zzfik)zzfik2);
                zzabk zzabk2 = new zzabk(context);
                zzaby zzaby2 = new zzaby(context, zzabk2);
                zzabl zzabl2 = new zzabl(zzfik2, (zzfjb)object2, zzaby2, zzabk2, (zzaav)object);
                int n = zzfjk.zzb((Context)context, (zzfii)zzfij2);
                object = new zzfie();
                zzfik2 = new zzfjx(context, n);
                zzaai zzaai2 = new zzaai((zzfii)zzfij2);
                zzaby2 = zzbjl.zzbv;
                zzabk2 = new zzfke(context, n, (zzfjl)zzaai2, ((Boolean)zzbet.zzc().zzc((zzbjd)zzaby2)).booleanValue());
                zzaby2 = new zzfkg(context, (zzfkh)zzabl2, (zzfii)zzfij2, (zzfie)object);
                object2 = new zzaal(context, (zzfii)zzfij2, (zzfjx)zzfik2, (zzfke)zzabk2, (zzfkg)zzaby2, zzabl2, executor, (zzfie)object, n);
                zzb = object2;
                ((zzaal)object2).zzh();
                zzb.zzq();
            }
            object = zzb;
            return object;
        }
    }

    public static zzaal zzf(String object, Context context, boolean bl, boolean bl2) {
        synchronized (zzaal.class) {
            object = zzaal.zze((String)object, context, Executors.newCachedThreadPool(), bl, bl2);
            return object;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    static /* synthetic */ void zzi(zzaal var0) {
        block18: {
            var2_1 = System.currentTimeMillis();
            var6_2 /* !! */  = var0.zzr(1);
            if (var6_2 /* !! */  == null) break block18;
            var5_3 = var6_2 /* !! */ .zza().zza();
            var6_2 /* !! */  = var6_2 /* !! */ .zza().zzc();
            ** GOTO lbl-1000
        }
        var5_3 = null;
        var6_2 /* !! */  = null;
lbl-1000:
        // 2 sources

        {
            block19: {
                block20: {
                    block26: {
                        block17: {
                            block25: {
                                block24: {
                                    block22: {
                                        block23: {
                                            block21: {
                                                var6_2 /* !! */  = zzfis.zza((Context)var0.zzc, (int)1, (int)var0.zzo, (String)var5_3, (String)var6_2 /* !! */ , (String)"1", (zzfii)var0.zzh);
                                                var5_3 = var6_2 /* !! */ .zzb;
                                                if (var5_3 == null || (var1_7 = ((Object)var5_3).length) == 0) break block19;
                                                try {
                                                    var5_3 = zzadf.zze((zzgex)zzgex.zzt((byte[])var5_3), (zzgfm)zzgfm.zza());
                                                }
                                                catch (NullPointerException var5_4) {
                                                    var0.zzh.zzb(2030, System.currentTimeMillis() - var2_1);
                                                    var0 = var0.zzk;
                                                    break block17;
                                                }
                                                if (var5_3.zza().zza().isEmpty() || var5_3.zza().zzc().isEmpty() || var5_3.zzd().zzz().length == 0) break block20;
                                                var7_8 = super.zzr(1);
                                                if (var7_8 == null) break block21;
                                                var7_8 = var7_8.zza();
                                                if (var5_3.zza().zza().equals(var7_8.zza()) && var5_3.zza().zzc().equals(var7_8.zzc())) break block20;
                                            }
                                            var7_8 = var0.zzj;
                                            var1_7 = var6_2 /* !! */ .zzc;
                                            var6_2 /* !! */  = zzbjl.zzbt;
                                            if (!((Boolean)zzbet.zzc().zzc((zzbjd)var6_2 /* !! */ )).booleanValue()) break block22;
                                            if (var1_7 != 3) break block23;
                                            var4_9 = var0.zze.zzb((zzadf)var5_3);
                                            break block24;
                                        }
                                        if (var1_7 != 4) break block25;
                                        var4_9 = var0.zze.zza((zzadf)var5_3, (zzfkd)var7_8);
                                        break block24;
                                    }
                                    var4_9 = var0.zzd.zza((zzadf)var5_3, (zzfkd)var7_8);
                                }
                                if (var4_9) break block26;
                            }
                            var0.zzh.zzb(4009, System.currentTimeMillis() - var2_1);
                            var0 = var0.zzk;
                        }
lbl47:
                        // 4 sources

                        while (true) {
                            var0.countDown();
                            return;
                        }
                    }
                    var5_3 = super.zzr(1);
                    if (var5_3 != null) {
                        if (var0.zzf.zza((zzfjw)var5_3)) {
                            var0.zzn = true;
                        }
                        var0.zza = System.currentTimeMillis() / 1000L;
                    }
                    var0 = var0.zzk;
                    ** GOTO lbl47
                }
                var0.zzh.zzb(5010, System.currentTimeMillis() - var2_1);
                var0 = var0.zzk;
                ** GOTO lbl47
            }
            var0.zzh.zzb(5009, System.currentTimeMillis() - var2_1);
        }
        var0 = var0.zzk;
        ** while (true)
    }

    private final zzfjw zzr(int n) {
        if (!zzfjk.zza((int)this.zzo)) {
            return null;
        }
        zzbjd zzbjd2 = zzbjl.zzbt;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return this.zzd.zzc(1);
        return this.zze.zzc(1);
    }

    public final boolean zzg() {
        synchronized (this) {
            boolean bl = this.zzn;
            return bl;
        }
    }

    final void zzh() {
        synchronized (this) {
            long l = System.currentTimeMillis();
            zzfjw zzfjw2 = this.zzr(1);
            if (zzfjw2 != null) {
                if (!this.zzf.zza(zzfjw2)) return;
                this.zzn = true;
                this.zzk.countDown();
                return;
            }
            this.zzh.zzb(4013, System.currentTimeMillis() - l);
            return;
        }
    }

    public final void zzj(MotionEvent motionEvent) {
        zzfil zzfil2 = this.zzf.zzb();
        if (zzfil2 == null) return;
        try {
            zzfil2.zzd(null, motionEvent);
            return;
        }
        catch (zzfkf zzfkf2) {
            this.zzh.zzc(zzfkf2.zza(), -1L, (Exception)((Object)zzfkf2));
        }
    }

    public final void zzk(int n, int n2, int n3) {
    }

    public final String zzl(Context object, String string, View view, Activity activity) {
        this.zzq();
        zzfil zzfil2 = this.zzf.zzb();
        if (zzfil2 == null) return "";
        long l = System.currentTimeMillis();
        object = zzfil2.zzc(object, null, string, view, activity);
        this.zzh.zzd(5000, System.currentTimeMillis() - l, (String)object, null);
        return object;
    }

    public final String zzm(Context context, String string, View view) {
        return this.zzl(context, string, view, null);
    }

    public final void zzn(View view) {
        this.zzg.zza(view);
    }

    public final String zzo(Context object, View view, Activity activity) {
        this.zzq();
        activity = this.zzf.zzb();
        if (activity == null) return "";
        long l = System.currentTimeMillis();
        object = activity.zzb(object, null, view, null);
        this.zzh.zzd(5002, System.currentTimeMillis() - l, (String)object, null);
        return object;
    }

    public final String zzp(Context object) {
        this.zzq();
        zzfil zzfil2 = this.zzf.zzb();
        if (zzfil2 == null) return "";
        long l = System.currentTimeMillis();
        object = zzfil2.zza(object, null);
        this.zzh.zzd(5001, System.currentTimeMillis() - l, (String)object, null);
        return object;
    }

    public final void zzq() {
        if (this.zzm) return;
        Object object = this.zzl;
        synchronized (object) {
            if (this.zzm) return;
            if (System.currentTimeMillis() / 1000L - this.zza < 3600L) {
                return;
            }
            zzfjw zzfjw2 = this.zzf.zzc();
            if (zzfjw2 != null) {
                if (!zzfjw2.zze(3600L)) return;
            }
            if (!zzfjk.zza((int)this.zzo)) return;
            Executor executor = this.zzi;
            zzfjw2 = new zzaak(this);
            executor.execute((Runnable)zzfjw2);
            return;
        }
    }
}
