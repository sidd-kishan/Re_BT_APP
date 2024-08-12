/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.ads.internal.util.zzce
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzbiu
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzce;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbiu;
import java.util.concurrent.Callable;

public final class zzbiv {
    private final Context zza;

    public zzbiv(Context context) {
        Preconditions.checkNotNull((Object)context, (Object)"Context can not be null");
        this.zza = context;
    }

    public final boolean zza() {
        if ((Boolean)zzce.zza((Context)this.zza, (Callable)new zzbiu()) == false) return false;
        if (Wrappers.packageManager((Context)this.zza).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) return false;
        return true;
    }

    public final boolean zzb() {
        if (!this.zzc(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"))) return false;
        return true;
    }

    public final boolean zzc(Intent intent) {
        Preconditions.checkNotNull((Object)intent, (Object)"Intent can not be null");
        if (this.zza.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) return false;
        return true;
    }
}
