/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.MutableContextWrapper
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

public final class zzcoa
extends MutableContextWrapper {
    private Activity zza;
    private Context zzb;
    private Context zzc;

    public zzcoa(Context context) {
        super(context);
        this.setBaseContext(context);
    }

    public final Object getSystemService(String string) {
        return this.zzc.getSystemService(string);
    }

    public final void setBaseContext(Context context) {
        this.zzb = context.getApplicationContext();
        Activity activity = context instanceof Activity ? (Activity)context : null;
        this.zza = activity;
        this.zzc = context;
        super.setBaseContext(this.zzb);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zza;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(0x10000000);
        this.zzb.startActivity(intent);
    }

    public final Activity zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzc;
    }
}
