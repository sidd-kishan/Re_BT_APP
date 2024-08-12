/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.KeyguardManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.internal.ads.zzfgt
 */
package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.ads.zzfgt;

final class zzfgs
extends BroadcastReceiver {
    final zzfgt zza;

    zzfgs(zzfgt zzfgt2) {
        this.zza = zzfgt2;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            zzfgt.zzf((zzfgt)this.zza, (boolean)true);
            return;
        }
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            zzfgt.zzf((zzfgt)this.zza, (boolean)false);
            return;
        }
        if (!"android.intent.action.SCREEN_ON".equals(intent.getAction())) return;
        if ((context = (KeyguardManager)context.getSystemService("keyguard")) == null) return;
        if (context.inKeyguardRestrictedInputMode()) return;
        zzfgt.zzf((zzfgt)this.zza, (boolean)false);
    }
}
