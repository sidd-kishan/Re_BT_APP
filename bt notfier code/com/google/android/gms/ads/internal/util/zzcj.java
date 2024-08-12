/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  com.google.android.gms.ads.internal.util.zzci
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.ads.internal.util.zzci;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzcj {
    private final BroadcastReceiver zza;
    private final Map<BroadcastReceiver, IntentFilter> zzb = new WeakHashMap<BroadcastReceiver, IntentFilter>();
    private boolean zzc = false;
    private boolean zzd;
    private Context zze;

    public zzcj() {
        this.zza = new zzci(this);
    }

    static /* synthetic */ void zzd(zzcj zzcj2, Context context, Intent intent) {
        zzcj2.zze(context, intent);
    }

    private final void zze(Context context, Intent intent) {
        synchronized (this) {
            try {
                ArrayList<BroadcastReceiver> arrayList = new ArrayList<BroadcastReceiver>();
                for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.zzb.entrySet()) {
                    if (!entry.getValue().hasAction(intent.getAction())) continue;
                    arrayList.add(entry.getKey());
                }
                int n = arrayList.size();
                int n2 = 0;
                while (n2 < n) {
                    ((BroadcastReceiver)arrayList.get(n2)).onReceive(context, intent);
                    ++n2;
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(Context context) {
        synchronized (this) {
            Context context2;
            boolean bl = this.zzc;
            if (bl) {
                return;
            }
            this.zze = context2 = context.getApplicationContext();
            if (context2 == null) {
                this.zze = context;
            }
            zzbjl.zza((Context)this.zze);
            context = zzbjl.zzcn;
            this.zzd = (Boolean)zzbet.zzc().zzc((zzbjd)context);
            context = new IntentFilter();
            context.addAction("android.intent.action.SCREEN_ON");
            context.addAction("android.intent.action.SCREEN_OFF");
            context.addAction("android.intent.action.USER_PRESENT");
            this.zze.registerReceiver(this.zza, (IntentFilter)context);
            this.zzc = true;
            return;
        }
    }

    public final void zzb(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this) {
            if (this.zzd) {
                this.zzb.put(broadcastReceiver, intentFilter);
                return;
            }
            context.registerReceiver(broadcastReceiver, intentFilter);
            return;
        }
    }

    public final void zzc(Context context, BroadcastReceiver broadcastReceiver) {
        synchronized (this) {
            if (this.zzd) {
                this.zzb.remove(broadcastReceiver);
                return;
            }
            context.unregisterReceiver(broadcastReceiver);
            return;
        }
    }
}
