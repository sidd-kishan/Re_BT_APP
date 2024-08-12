/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzfgz
 *  com.google.android.gms.internal.ads.zzfha
 *  com.google.android.gms.internal.ads.zzfhb
 *  com.google.android.gms.internal.ads.zzfhi
 *  com.google.android.gms.internal.ads.zzfhl
 *  com.google.android.gms.internal.ads.zzfhm
 *  com.google.android.gms.internal.ads.zzfhn
 *  com.google.android.gms.internal.ads.zzfho
 *  com.google.android.gms.internal.ads.zzfhp
 *  com.google.android.gms.internal.ads.zzfhq
 *  com.google.android.gms.internal.ads.zzfhr
 *  com.google.android.gms.internal.ads.zzfhs
 *  com.google.android.gms.internal.ads.zzfht
 *  com.google.android.gms.internal.ads.zzfhx
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.internal.ads.zzfgz;
import com.google.android.gms.internal.ads.zzfha;
import com.google.android.gms.internal.ads.zzfhb;
import com.google.android.gms.internal.ads.zzfhi;
import com.google.android.gms.internal.ads.zzfhl;
import com.google.android.gms.internal.ads.zzfhm;
import com.google.android.gms.internal.ads.zzfhn;
import com.google.android.gms.internal.ads.zzfho;
import com.google.android.gms.internal.ads.zzfhp;
import com.google.android.gms.internal.ads.zzfhq;
import com.google.android.gms.internal.ads.zzfhr;
import com.google.android.gms.internal.ads.zzfhs;
import com.google.android.gms.internal.ads.zzfht;
import com.google.android.gms.internal.ads.zzfhx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class zzfhu
implements zzfgz {
    private static final zzfhu zza = new zzfhu();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzj = new zzfhq();
    private static final Runnable zzk = new zzfhr();
    private final List<zzfht> zzd = new ArrayList<zzfht>();
    private int zze;
    private final zzfhb zzf;
    private final zzfhn zzg = new zzfhn();
    private final zzfho zzh;
    private long zzi;

    zzfhu() {
        this.zzf = new zzfhb();
        this.zzh = new zzfho(new zzfhx());
    }

    static /* synthetic */ Handler zzb() {
        return zzc;
    }

    static /* synthetic */ zzfho zzc(zzfhu zzfhu2) {
        return zzfhu2.zzh;
    }

    static /* synthetic */ Runnable zzd() {
        return zzj;
    }

    static /* synthetic */ Runnable zze() {
        return zzk;
    }

    public static zzfhu zzf() {
        return zza;
    }

    static /* synthetic */ void zzj(zzfhu zzfhu2) {
        Object object3;
        zzfhu2.zze = 0;
        zzfhu2.zzi = System.nanoTime();
        zzfhu2.zzg.zzd();
        long l = System.nanoTime();
        Object object2 = zzfhu2.zzf.zza();
        if (zzfhu2.zzg.zzb().size() > 0) {
            for (Object object3 : zzfhu2.zzg.zzb()) {
                JSONObject jSONObject = zzfhi.zzb((int)0, (int)0, (int)0, (int)0);
                View view = zzfhu2.zzg.zzh((String)object3);
                zzfha zzfha2 = zzfhu2.zzf.zzb();
                Object object4 = zzfhu2.zzg.zzc((String)object3);
                if (object4 != null) {
                    zzfha2 = zzfha2.zza(view);
                    zzfhi.zzd((JSONObject)zzfha2, (String)object3);
                    zzfhi.zze((JSONObject)zzfha2, (String)object4);
                    zzfhi.zzg((JSONObject)jSONObject, (JSONObject)zzfha2);
                }
                zzfhi.zzh((JSONObject)jSONObject);
                object4 = new HashSet();
                ((HashSet)object4).add(object3);
                zzfhu2.zzh.zzb(jSONObject, (HashSet)object4, l);
            }
        }
        if (zzfhu2.zzg.zza().size() > 0) {
            object3 = zzfhi.zzb((int)0, (int)0, (int)0, (int)0);
            zzfhu2.zzk(null, (zzfha)object2, (JSONObject)object3, 1);
            zzfhi.zzh((JSONObject)object3);
            zzfhu2.zzh.zza(object3, zzfhu2.zzg.zza(), l);
        } else {
            zzfhu2.zzh.zzc();
        }
        zzfhu2.zzg.zze();
        l = System.nanoTime();
        long l2 = zzfhu2.zzi;
        if (zzfhu2.zzd.size() <= 0) return;
        object2 = zzfhu2.zzd.iterator();
        while (object2.hasNext()) {
            object3 = (zzfht)object2.next();
            int n = zzfhu2.zze;
            TimeUnit.NANOSECONDS.toMillis(l - l2);
            object3.zzb();
            if (!(object3 instanceof zzfhs)) continue;
            object3 = (zzfhs)object3;
            n = zzfhu2.zze;
            object3.zza();
        }
    }

    private final void zzk(View view, zzfha zzfha2, JSONObject jSONObject, int n) {
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        zzfha2.zzb(view, jSONObject, (zzfgz)this, bl);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler == null) return;
        handler.removeCallbacks(zzk);
        zzc = null;
    }

    public final void zza(View view, zzfha zzfha2, JSONObject object) {
        if (zzfhl.zzb((View)view) != null) return;
        int n = this.zzg.zzj(view);
        if (n == 3) {
            return;
        }
        JSONObject jSONObject = zzfha2.zza(view);
        zzfhi.zzg((JSONObject)object, (JSONObject)jSONObject);
        object = this.zzg.zzg(view);
        if (object != null) {
            zzfhi.zzd((JSONObject)jSONObject, (String)object);
            this.zzg.zzf();
        } else {
            object = this.zzg.zzi(view);
            if (object != null) {
                zzfhi.zzf((JSONObject)jSONObject, (zzfhm)object);
            }
            this.zzk(view, zzfha2, jSONObject, n);
        }
        ++this.zze;
    }

    public final void zzg() {
        Handler handler;
        if (zzc != null) return;
        zzc = handler = new Handler(Looper.getMainLooper());
        handler.post(zzj);
        zzc.postDelayed(zzk, 200L);
    }

    public final void zzh() {
        zzfhu.zzl();
        this.zzd.clear();
        zzb.post((Runnable)new zzfhp(this));
    }

    public final void zzi() {
        zzfhu.zzl();
    }
}
