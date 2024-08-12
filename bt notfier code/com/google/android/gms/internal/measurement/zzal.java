/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzq
 *  com.google.android.gms.internal.measurement.zzz
 *  com.google.android.gms.measurement.internal.zzfh
 */
package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzfh;

final class zzal
extends zzbh {
    final String zza;
    final String zzb;
    final Context zzc;
    final Bundle zzd;
    final zzbs zze;

    zzal(zzbs zzbs2, String string, String string2, Context context, Bundle bundle) {
        this.zze = zzbs2;
        this.zza = string;
        this.zzb = string2;
        this.zzc = context;
        this.zzd = bundle;
        super(zzbs2, true);
    }

    public final void zza() {
        try {
            String string;
            String string2;
            String string3;
            if (zzbs.zzM((zzbs)this.zze, (String)this.zza, (String)this.zzb)) {
                string3 = this.zzb;
                string2 = this.zza;
                string = zzbs.zzN((zzbs)this.zze);
            } else {
                string = null;
                string3 = string2 = null;
            }
            Preconditions.checkNotNull((Object)this.zzc);
            zzbs zzbs2 = this.zze;
            zzbs.zzO((zzbs)zzbs2, (zzq)zzbs2.zzc(this.zzc, true));
            if (zzbs.zzP((zzbs)this.zze) == null) {
                Log.w((String)zzbs.zzN((zzbs)this.zze), (String)"Failed to connect to measurement client.");
                return;
            }
            int n = DynamiteModule.getLocalVersion((Context)this.zzc, (String)"com.google.android.gms.measurement.dynamite");
            int n2 = DynamiteModule.getRemoteVersion((Context)this.zzc, (String)"com.google.android.gms.measurement.dynamite");
            int n3 = Math.max(n, n2);
            boolean bl = n2 < n;
            zzbs2 = new zzz(39065L, (long)n3, bl, string, string2, string3, this.zzd, zzfh.zza((Context)this.zzc));
            ((zzq)Preconditions.checkNotNull((Object)zzbs.zzP((zzbs)this.zze))).initialize(ObjectWrapper.wrap((Object)this.zzc), (zzz)zzbs2, this.zzh);
            return;
        }
        catch (Exception exception) {
            zzbs.zzL((zzbs)this.zze, (Exception)exception, (boolean)true, (boolean)false);
            return;
        }
    }
}
