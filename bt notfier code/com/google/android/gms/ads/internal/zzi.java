/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzg
 *  com.google.android.gms.ads.internal.zzh
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaal
 *  com.google.android.gms.internal.ads.zzaao
 *  com.google.android.gms.internal.ads.zzaar
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzfii
 *  com.google.android.gms.internal.ads.zzfjk
 *  com.google.android.gms.internal.ads.zzfjl
 *  com.google.android.gms.internal.ads.zzfke
 */
package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaal;
import com.google.android.gms.internal.ads.zzaao;
import com.google.android.gms.internal.ads.zzaar;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzfii;
import com.google.android.gms.internal.ads.zzfjk;
import com.google.android.gms.internal.ads.zzfjl;
import com.google.android.gms.internal.ads.zzfke;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public final class zzi
implements Runnable,
zzaao {
    final CountDownLatch zza;
    private final List<Object[]> zzb = new Vector<Object[]>();
    private final AtomicReference<zzaao> zzc = new AtomicReference();
    private final AtomicReference<zzaao> zzd = new AtomicReference();
    private final boolean zze;
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    private final zzfii zzi;
    private Context zzj;
    private final Context zzk;
    private zzcgz zzl;
    private final zzcgz zzm;
    private final boolean zzn;
    private int zzo;

    public zzi(Context context, zzcgz zzcgz2) {
        boolean bl;
        this.zza = new CountDownLatch(1);
        this.zzj = context;
        this.zzk = context;
        this.zzl = zzcgz2;
        this.zzm = zzcgz2;
        this.zzh = Executors.newCachedThreadPool();
        zzcgz2 = zzbjl.zzby;
        this.zzn = bl = ((Boolean)zzbet.zzc().zzc((zzbjd)zzcgz2)).booleanValue();
        this.zzi = zzfii.zza((Context)context, (Executor)this.zzh, (boolean)bl);
        context = zzbjl.zzbu;
        this.zzf = (Boolean)zzbet.zzc().zzc((zzbjd)context);
        context = zzbjl.zzbz;
        this.zzg = (Boolean)zzbet.zzc().zzc((zzbjd)context);
        context = zzbjl.zzbx;
        this.zzo = (Boolean)zzbet.zzc().zzc((zzbjd)context) != false ? 2 : 1;
        Context context2 = this.zzj;
        zzfii zzfii2 = this.zzi;
        zzcgz2 = new zzh(this);
        context = this.zzj;
        int n = zzfjk.zzb((Context)context2, (zzfii)zzfii2);
        zzfii2 = zzbjl.zzbv;
        this.zze = new zzfke(context, n, (zzfjl)zzcgz2, ((Boolean)zzbet.zzc().zzc((zzbjd)zzfii2)).booleanValue()).zzd(1);
        context = zzbjl.zzbT;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)context)).booleanValue()) {
            zzchg.zza.execute((Runnable)this);
            return;
        }
        zzber.zza();
        if (zzcgm.zzp()) {
            zzchg.zza.execute((Runnable)this);
            return;
        }
        this.run();
    }

    static /* synthetic */ zzfii zza(zzi zzi2) {
        return zzi2.zzi;
    }

    private final void zze() {
        zzaao zzaao2 = this.zzg();
        if (this.zzb.isEmpty()) return;
        if (zzaao2 == null) return;
        for (Object[] objectArray : this.zzb) {
            int n = objectArray.length;
            if (n == 1) {
                zzaao2.zzj((MotionEvent)objectArray[0]);
                continue;
            }
            if (n != 3) continue;
            zzaao2.zzk(((Integer)objectArray[0]).intValue(), ((Integer)objectArray[1]).intValue(), ((Integer)objectArray[2]).intValue());
        }
        this.zzb.clear();
    }

    private final void zzf(boolean bl) {
        zzaar zzaar2 = zzaar.zzt((String)this.zzl.zza, (Context)com.google.android.gms.ads.internal.zzi.zzh(this.zzj), (boolean)bl, (int)this.zzo);
        this.zzc.set((zzaao)zzaar2);
    }

    private final zzaao zzg() {
        if (this.zzd() != 2) return this.zzc.get();
        return this.zzd.get();
    }

    private static final Context zzh(Context context) {
        Context context2 = context.getApplicationContext();
        if (context2 != null) return context2;
        return context;
    }

    @Override
    public final void run() {
        try {
            boolean bl;
            boolean bl2 = this.zzl.zzd;
            zzbjd zzbjd2 = zzbjl.zzaH;
            boolean bl3 = (Boolean)zzbet.zzc().zzc(zzbjd2);
            boolean bl4 = bl = false;
            if (!bl3) {
                bl4 = bl;
                if (bl2) {
                    bl4 = true;
                }
            }
            if (this.zzd() == 1) {
                this.zzf(bl4);
                if (this.zzo != 2) return;
                Executor executor = this.zzh;
                zzbjd2 = new zzg(this, bl4);
                executor.execute((Runnable)zzbjd2);
            } else {
                long l = System.currentTimeMillis();
                try {
                    zzbjd2 = zzaal.zzf((String)this.zzl.zza, (Context)com.google.android.gms.ads.internal.zzi.zzh(this.zzj), (boolean)bl4, (boolean)this.zzn);
                    this.zzd.set((zzaao)zzbjd2);
                    if (!this.zzg) return;
                    if (zzbjd2.zzg()) return;
                    this.zzo = 1;
                    this.zzf(bl4);
                }
                catch (NullPointerException nullPointerException) {
                    this.zzo = 1;
                    this.zzf(bl4);
                    this.zzi.zzc(2031, System.currentTimeMillis() - l, (Exception)nullPointerException);
                }
            }
            return;
        }
        finally {
            this.zza.countDown();
            this.zzj = null;
            this.zzl = null;
        }
    }

    public final boolean zzb() {
        try {
            this.zza.await();
            return true;
        }
        catch (InterruptedException interruptedException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Interrupted during GADSignals creation.", (Throwable)interruptedException);
            return false;
        }
    }

    final /* synthetic */ void zzc(boolean bl) {
        long l = System.currentTimeMillis();
        try {
            zzaal.zzf((String)this.zzm.zza, (Context)com.google.android.gms.ads.internal.zzi.zzh(this.zzk), (boolean)bl, (boolean)this.zzn).zzq();
            return;
        }
        catch (NullPointerException nullPointerException) {
            this.zzi.zzc(2027, System.currentTimeMillis() - l, (Exception)nullPointerException);
            return;
        }
    }

    protected final int zzd() {
        if (!this.zzf) return this.zzo;
        if (this.zze) return this.zzo;
        return 1;
    }

    public final void zzj(MotionEvent motionEvent) {
        zzaao zzaao2 = this.zzg();
        if (zzaao2 != null) {
            this.zze();
            zzaao2.zzj(motionEvent);
            return;
        }
        this.zzb.add(new Object[]{motionEvent});
    }

    public final void zzk(int n, int n2, int n3) {
        zzaao zzaao2 = this.zzg();
        if (zzaao2 != null) {
            this.zze();
            zzaao2.zzk(n, n2, n3);
            return;
        }
        this.zzb.add(new Object[]{n, n2, n3});
    }

    public final String zzl(Context context, String string, View view, Activity activity) {
        if (!this.zzb()) return "";
        zzaao zzaao2 = this.zzg();
        zzbjd zzbjd2 = zzbjl.zzgV;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzt.zzc();
            zzs.zzM((View)view, (int)4, null);
        }
        if (zzaao2 == null) return "";
        this.zze();
        return zzaao2.zzl(com.google.android.gms.ads.internal.zzi.zzh(context), string, view, activity);
    }

    public final String zzm(Context context, String string, View view) {
        return this.zzl(context, string, view, null);
    }

    public final void zzn(View view) {
        zzaao zzaao2 = this.zzg();
        if (zzaao2 == null) return;
        zzaao2.zzn(view);
    }

    public final String zzo(Context context, View view, Activity activity) {
        activity = zzbjl.zzgU;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)activity)).booleanValue()) {
            if (!this.zzb()) return "";
            zzaao zzaao2 = this.zzg();
            activity = zzbjl.zzgV;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)activity)).booleanValue()) {
                zzt.zzc();
                zzs.zzM((View)view, (int)2, null);
            }
            if (zzaao2 == null) return "";
            return zzaao2.zzo(context, view, null);
        }
        activity = this.zzg();
        zzbjd zzbjd2 = zzbjl.zzgV;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            zzt.zzc();
            zzs.zzM((View)view, (int)2, null);
        }
        if (activity == null) return "";
        return activity.zzo(context, view, null);
    }

    public final String zzp(Context object) {
        zzaao zzaao2;
        if (this.zzb() && (zzaao2 = this.zzg()) != null) {
            this.zze();
            object = zzaao2.zzp(com.google.android.gms.ads.internal.zzi.zzh(object));
        } else {
            object = "";
        }
        return object;
    }
}
