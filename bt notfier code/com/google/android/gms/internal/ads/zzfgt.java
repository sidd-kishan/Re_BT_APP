/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgr
 *  com.google.android.gms.internal.ads.zzfgs
 *  com.google.android.gms.internal.ads.zzfgx
 *  com.google.android.gms.internal.ads.zzfgy
 *  com.google.android.gms.internal.ads.zzfhe
 *  com.google.android.gms.internal.ads.zzfhu
 */
package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfgs;
import com.google.android.gms.internal.ads.zzfgx;
import com.google.android.gms.internal.ads.zzfgy;
import com.google.android.gms.internal.ads.zzfhe;
import com.google.android.gms.internal.ads.zzfhu;
import java.util.Iterator;

public final class zzfgt {
    private static final zzfgt zza = new zzfgt();
    private Context zzb;
    private BroadcastReceiver zzc;
    private boolean zzd;
    private boolean zze;
    private zzfgy zzf;

    private zzfgt() {
    }

    public static zzfgt zza() {
        return zza;
    }

    static /* synthetic */ void zzf(zzfgt zzfgt2, boolean bl) {
        if (zzfgt2.zze == bl) return;
        zzfgt2.zze = bl;
        if (!zzfgt2.zzd) return;
        zzfgt2.zzh();
        if (zzfgt2.zzf == null) return;
        if (zzfgt2.zze()) {
            zzfhu.zzf().zzg();
            return;
        }
        zzfhu.zzf().zzi();
    }

    private final void zzh() {
        boolean bl = this.zze;
        Iterator iterator = zzfgr.zza().zze().iterator();
        while (iterator.hasNext()) {
            zzfhe zzfhe2 = ((zzfgg)iterator.next()).zzg();
            if (!zzfhe2.zze()) continue;
            String string = true != bl ? "foregrounded" : "backgrounded";
            zzfgx.zza().zzg(zzfhe2.zzd(), "setState", new Object[]{string});
        }
    }

    public final void zzb(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public final void zzc() {
        this.zzc = new zzfgs(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzb.registerReceiver(this.zzc, intentFilter);
        this.zzd = true;
        this.zzh();
    }

    public final void zzd() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.zzb;
        if (context != null && (broadcastReceiver = this.zzc) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.zzc = null;
        }
        this.zzd = false;
        this.zze = false;
        this.zzf = null;
    }

    public final boolean zze() {
        if (this.zze) return false;
        return true;
    }

    public final void zzg(zzfgy zzfgy2) {
        this.zzf = zzfgy2;
    }
}
