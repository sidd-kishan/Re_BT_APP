/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.internal.BaseGmsClient
 */
package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;

public abstract class zzc<TListener> {
    private TListener zza;
    private boolean zzb;
    final BaseGmsClient zzd;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzc(BaseGmsClient baseGmsClient, Object object) {
        this.zzd = baseGmsClient;
        this.zza = object;
        this.zzb = false;
    }

    protected abstract void zzc();

    protected abstract void zzd(TListener var1);

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void zze() {
        // MONITORENTER : this
        TListener TListener = this.zza;
        if (this.zzb) {
            String string = String.valueOf(this);
            int n = String.valueOf(string).length();
            StringBuilder stringBuilder = new StringBuilder(n + 47);
            stringBuilder.append("Callback proxy ");
            stringBuilder.append(string);
            stringBuilder.append(" being reused. This is not safe.");
            Log.w((String)"GmsClient", (String)stringBuilder.toString());
        }
        // MONITOREXIT : this
        if (TListener != null) {
            this.zzd(TListener);
        }
        // MONITORENTER : this
        this.zzb = true;
        // MONITOREXIT : this
        this.zzf();
    }

    public final void zzf() {
        this.zzg();
        ArrayList arrayList = BaseGmsClient.zzm((BaseGmsClient)this.zzd);
        synchronized (arrayList) {
            BaseGmsClient.zzm((BaseGmsClient)this.zzd).remove(this);
            return;
        }
    }

    public final void zzg() {
        synchronized (this) {
            this.zza = null;
            return;
        }
    }
}
