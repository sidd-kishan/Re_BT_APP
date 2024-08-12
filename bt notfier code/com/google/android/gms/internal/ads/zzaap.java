/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzaao
 *  com.google.android.gms.internal.ads.zzabi
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzabs
 *  com.google.android.gms.internal.ads.zzabt
 *  com.google.android.gms.internal.ads.zzabu
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzyc
 *  com.google.android.gms.internal.ads.zzyj
 *  com.google.android.gms.internal.ads.zzyz
 *  com.google.android.gms.internal.ads.zzzs
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaao;
import com.google.android.gms.internal.ads.zzabi;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzabt;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyj;
import com.google.android.gms.internal.ads.zzyz;
import com.google.android.gms.internal.ads.zzzs;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzaap
implements zzaao {
    protected static volatile zzabr zza;
    protected MotionEvent zzb;
    protected final LinkedList<MotionEvent> zzc = new LinkedList();
    protected long zzd = 0L;
    protected long zze = 0L;
    protected long zzf = 0L;
    protected long zzg = 0L;
    protected long zzh = 0L;
    protected long zzi = 0L;
    protected long zzj = 0L;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected boolean zzp = false;
    protected DisplayMetrics zzq;
    private double zzr;
    private double zzs;
    private boolean zzt = false;

    /*
     * Enabled force condition propagation
     */
    protected zzaap(Context context) {
        try {
            zzbjd zzbjd2 = zzbjl.zzbR;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                zzzs.zzb();
            } else {
                zzabs.zza((zzabr)zza);
            }
            this.zzq = context.getResources().getDisplayMetrics();
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    private final void zzf() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        if (this.zzc.size() > 0) {
            Iterator iterator = this.zzc.iterator();
            while (iterator.hasNext()) {
                ((MotionEvent)iterator.next()).recycle();
            }
            this.zzc.clear();
        } else {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzb = null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private final String zzg(Context var1_1, String var2_2, int var3_3, View var4_4, Activity var5_8, byte[] var6_10) {
        block23: {
            block20: {
                block19: {
                    block22: {
                        block21: {
                            block24: {
                                var8_11 = System.currentTimeMillis();
                                var6_10 /* !! */  = (byte[])zzbjl.zzbG;
                                var12_12 = (Boolean)zzbet.zzc().zzc((zzbjd)var6_10 /* !! */ );
                                var13_13 = null;
                                if (var12_12) {
                                    var6_10 /* !! */  = (byte[])(zzaap.zza != null ? (byte[])zzaap.zza.zzj() : null);
                                    var14_14 /* !! */  = zzbjl.zzbR;
                                    if (!((Boolean)zzbet.zzc().zzc(var14_14 /* !! */ )).booleanValue()) {
                                        var15_15 = "te";
                                        var14_14 /* !! */  = (zzbjd)var6_10 /* !! */ ;
                                        var6_10 /* !! */  = (byte[])var15_15;
                                    } else {
                                        var15_16 = "be";
                                        var14_14 /* !! */  = (zzbjd)var6_10 /* !! */ ;
                                        var6_10 /* !! */  = (byte[])var15_16;
                                    }
                                } else {
                                    var14_14 /* !! */  = null;
                                    var6_10 /* !! */  = null;
                                }
                                if (var3_3 != 3) break block24;
                                try {
                                    var1_1 /* !! */  = this.zzb(var1_1 /* !! */ , var4_4, var5_8);
                                }
                                catch (Exception var4_5) {
                                    var1_1 /* !! */  = var13_13;
                                    break block19;
                                }
                                try {
                                    this.zzt = true;
                                    var7_17 = 1002;
                                    ** GOTO lbl40
                                }
                                catch (Exception var5_9) {
                                    break block20;
                                }
                            }
                            if (var3_3 != 2) ** GOTO lbl38
                            {
                                block25: {
                                    var1_1 /* !! */  = this.zzc(var1_1 /* !! */ , var4_4, var5_8);
                                    var7_17 = 1008;
                                    break block25;
lbl38:
                                    // 1 sources

                                    var1_1 /* !! */  = this.zza(var1_1 /* !! */ , null);
                                    var7_17 = 1000;
                                }
                                if (!var12_12 || var14_14 /* !! */  == null) break block21;
                                var13_13 = var1_1 /* !! */ ;
                                var10_18 = System.currentTimeMillis();
                            }
                            try {
                                var14_14 /* !! */ .zzc(var7_17, -1, var10_18 - var8_11, (String)var6_10 /* !! */ , null);
                                var4_4 = var1_1 /* !! */ ;
                                break block22;
                            }
                            catch (Exception var4_6) {
                                break block19;
                            }
                        }
                        var4_4 = var1_1 /* !! */ ;
                    }
lbl53:
                    // 3 sources

                    while (true) {
                        var7_17 = var3_3;
                        var1_1 /* !! */  = var4_4;
                        break block23;
                        break;
                    }
                }
                var5_8 = var4_4;
            }
            var4_4 = var1_1 /* !! */ ;
            if (!var12_12) ** GOTO lbl53
            var4_4 = var1_1 /* !! */ ;
            if (var14_14 /* !! */  != null) ** break;
            ** while (true)
            if (var3_3 == 3) {
                var7_17 = 1003;
            } else if (var3_3 == 2) {
                var7_17 = 1009;
            } else {
                var3_3 = 1;
                var7_17 = 1001;
            }
            var14_14 /* !! */ .zzc(var7_17, -1, System.currentTimeMillis() - var8_11, (String)var6_10 /* !! */ , (Exception)var5_8);
            var7_17 = var3_3;
        }
        var8_11 = System.currentTimeMillis();
        if (var1_1 /* !! */  == null) return Integer.toString(5);
        try {
            if (((zzyz)var1_1 /* !! */ .zzah()).zzaw() == 0) return Integer.toString(5);
            var2_2 = zzzs.zzc((zzyz)((zzyz)var1_1 /* !! */ .zzah()), (String)var2_2);
            var1_1 /* !! */  = var2_2;
            if (var12_12 == false) return var1_1 /* !! */ ;
            var1_1 /* !! */  = var2_2;
            if (var14_14 /* !! */  == null) return var1_1 /* !! */ ;
            var3_3 = var7_17 == 3 ? 1006 : (var7_17 == 2 ? 1010 : 1004);
            var14_14 /* !! */ .zzc(var3_3, -1, System.currentTimeMillis() - var8_11, (String)var6_10 /* !! */ , null);
            return var2_2;
        }
        catch (Exception var4_7) {
            var2_2 = Integer.toString(7);
            var1_1 /* !! */  = var2_2;
            if (var12_12 == false) return var1_1 /* !! */ ;
            var1_1 /* !! */  = var2_2;
            if (var14_14 /* !! */  == null) return var1_1 /* !! */ ;
            var3_3 = var7_17 == 3 ? 1007 : (var7_17 == 2 ? 1011 : 1005);
            var14_14 /* !! */ .zzc(var3_3, -1, System.currentTimeMillis() - var8_11, (String)var6_10 /* !! */ , var4_7);
            return var2_2;
        }
    }

    protected abstract zzyj zza(Context var1, zzyc var2);

    protected abstract zzyj zzb(Context var1, View var2, Activity var3);

    protected abstract zzyj zzc(Context var1, View var2, Activity var3);

    protected abstract zzabt zzd(MotionEvent var1) throws zzabi;

    protected abstract long zze(StackTraceElement[] var1) throws zzabi;

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzj(MotionEvent object) {
        synchronized (this) {
            block17: {
                block18: {
                    block19: {
                        int n;
                        if (this.zzt) {
                            this.zzf();
                            this.zzt = false;
                        }
                        if ((n = object.getAction()) != 0) {
                            if (n == 1 || n == 2) {
                                double d = object.getRawX();
                                double d2 = object.getRawY();
                                double d3 = this.zzr;
                                Double.isNaN(d);
                                d3 = d - d3;
                                double d4 = this.zzs;
                                Double.isNaN(d2);
                                d4 = d2 - d4;
                                this.zzk += Math.sqrt(d3 * d3 + d4 * d4);
                                this.zzr = d;
                                this.zzs = d2;
                            }
                        } else {
                            this.zzk = 0.0;
                            this.zzr = object.getRawX();
                            this.zzs = object.getRawY();
                        }
                        n = object.getAction();
                        if (n == 0) break block18;
                        if (n == 1) break block19;
                        if (n != 2) {
                            if (n == 3) {
                                ++this.zzg;
                            }
                            break block17;
                        } else {
                            this.zze += (long)(object.getHistorySize() + 1);
                            object = this.zzd((MotionEvent)object);
                            Long l = ((zzabt)object).zzd;
                            if (l != null && ((zzabt)object).zzg != null) {
                                this.zzi += l + ((zzabt)object).zzg;
                            }
                            if (this.zzq != null && (l = ((zzabt)object).zze) != null && ((zzabt)object).zzh != null) {
                                this.zzj += l + ((zzabt)object).zzh;
                            }
                            break block17;
                        }
                    }
                    object = MotionEvent.obtain((MotionEvent)object);
                    this.zzb = object;
                    this.zzc.add((MotionEvent)object);
                    if (this.zzc.size() > 6) {
                        this.zzc.remove().recycle();
                    }
                    ++this.zzf;
                    try {
                        object = new Throwable();
                        this.zzh = this.zze(((Throwable)object).getStackTrace());
                        break block17;
                    }
                    catch (zzabi zzabi2) {}
                }
                this.zzl = object.getX();
                this.zzm = object.getY();
                this.zzn = object.getRawX();
                this.zzo = object.getRawY();
                ++this.zzd;
            }
            this.zzp = true;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzk(int n, int n2, int n3) {
        synchronized (this) {
            zzbjd zzbjd2;
            if (this.zzb != null) {
                zzbjd2 = zzbjl.zzbE;
                if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                    this.zzf();
                } else {
                    this.zzb.recycle();
                }
            }
            if ((zzbjd2 = this.zzq) != null) {
                long l = n3;
                float f = n;
                float f2 = zzbjd2.density;
                float f3 = n2;
                this.zzb = MotionEvent.obtain((long)0L, (long)l, (int)1, (float)(f * f2), (float)(this.zzq.density * f3), (float)0.0f, (float)0.0f, (int)0, (float)0.0f, (float)0.0f, (int)0, (int)0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
            return;
        }
    }

    public final String zzl(Context context, String string, View view, Activity activity) {
        return this.zzg(context, string, 3, view, activity, null);
    }

    public final String zzm(Context context, String string, View view) {
        return this.zzg(context, string, 3, view, null, null);
    }

    public void zzn(View view) {
    }

    public final String zzo(Context context, View view, Activity activity) {
        return this.zzg(context, null, 2, view, null, null);
    }

    public final String zzp(Context context) {
        if (zzabu.zzf()) throw new IllegalStateException("The caller must not be called from the UI thread.");
        return this.zzg(context, null, 1, null, null, null);
    }
}
