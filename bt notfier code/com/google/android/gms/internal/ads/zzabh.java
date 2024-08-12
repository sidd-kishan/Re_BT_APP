/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzaaz
 *  com.google.android.gms.internal.ads.zzaba
 *  com.google.android.gms.internal.ads.zzabb
 *  com.google.android.gms.internal.ads.zzabc
 *  com.google.android.gms.internal.ads.zzabd
 *  com.google.android.gms.internal.ads.zzabe
 *  com.google.android.gms.internal.ads.zzabf
 *  com.google.android.gms.internal.ads.zzabg
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzabc;
import com.google.android.gms.internal.ads.zzabd;
import com.google.android.gms.internal.ads.zzabe;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzabg;
import java.lang.ref.WeakReference;

final class zzabh
implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzb;
    private boolean zzc = false;

    public zzabh(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference<Application.ActivityLifecycleCallbacks>(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.zza((zzabg)new zzaaz(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza((zzabg)new zzabf(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        this.zza((zzabg)new zzabc(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        this.zza((zzabg)new zzabb(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza((zzabg)new zzabe(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        this.zza((zzabg)new zzaba(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        this.zza((zzabg)new zzabd(this, activity));
    }

    /*
     * Enabled force condition propagation
     */
    protected final void zza(zzabg zzabg2) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzabg2.zza(activityLifecycleCallbacks);
                return;
            }
            if (this.zzc) return;
            this.zza.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
            this.zzc = true;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}
