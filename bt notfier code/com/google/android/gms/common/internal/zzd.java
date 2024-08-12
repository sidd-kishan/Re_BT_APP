/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.Log
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zzaa
 *  com.google.android.gms.common.internal.zzi
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzi;

public final class zzd
extends zzaa {
    private BaseGmsClient zza;
    private final int zzb;

    public zzd(BaseGmsClient baseGmsClient, int n) {
        this.zza = baseGmsClient;
        this.zzb = n;
    }

    public final void onPostInitComplete(int n, IBinder iBinder, Bundle bundle) {
        Preconditions.checkNotNull((Object)this.zza, (Object)"onPostInitComplete can be called only once per call to getRemoteService");
        this.zza.onPostInitHandler(n, iBinder, bundle, this.zzb);
        this.zza = null;
    }

    public final void zzb(int n, Bundle bundle) {
        Log.wtf((String)"GmsClient", (String)"received deprecated onAccountValidationComplete callback, ignoring", (Throwable)new Exception());
    }

    public final void zzc(int n, IBinder iBinder, zzi zzi2) {
        BaseGmsClient baseGmsClient = this.zza;
        Preconditions.checkNotNull((Object)baseGmsClient, (Object)"onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull((Object)zzi2);
        BaseGmsClient.zzo((BaseGmsClient)baseGmsClient, (zzi)zzi2);
        this.onPostInitComplete(n, iBinder, zzi2.zza);
    }
}
