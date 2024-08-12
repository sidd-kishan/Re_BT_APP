/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.google.android.gms.internal.measurement.zzbh
 *  com.google.android.gms.internal.measurement.zzbk
 *  com.google.android.gms.internal.measurement.zzbl
 *  com.google.android.gms.internal.measurement.zzbm
 *  com.google.android.gms.internal.measurement.zzbn
 *  com.google.android.gms.internal.measurement.zzbo
 *  com.google.android.gms.internal.measurement.zzbp
 *  com.google.android.gms.internal.measurement.zzbq
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.internal.measurement.zzn
 */
package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbh;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbp;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzn;

final class zzbr
implements Application.ActivityLifecycleCallbacks {
    final zzbs zza;

    zzbr(zzbs zzbs2) {
        this.zza = zzbs2;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzbs.zzQ((zzbs)this.zza, (zzbh)new zzbk(this, bundle, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        zzbs.zzQ((zzbs)this.zza, (zzbh)new zzbq(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zzbs.zzQ((zzbs)this.zza, (zzbh)new zzbn(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zzbs.zzQ((zzbs)this.zza, (zzbh)new zzbm(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzn zzn2 = new zzn();
        zzbs.zzQ((zzbs)this.zza, (zzbh)new zzbp(this, activity, zzn2));
        activity = zzn2.zzd(50L);
        if (activity == null) return;
        bundle.putAll((Bundle)activity);
    }

    public final void onActivityStarted(Activity activity) {
        zzbs.zzQ((zzbs)this.zza, (zzbh)new zzbl(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zzbs.zzQ((zzbs)this.zza, (zzbh)new zzbo(this, activity));
    }
}
