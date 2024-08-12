/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzawi
 *  com.google.android.gms.internal.ads.zzawj
 *  com.google.android.gms.internal.ads.zzawk
 *  com.google.android.gms.internal.ads.zzawl
 *  com.google.android.gms.internal.ads.zzawm
 *  com.google.android.gms.internal.ads.zzawn
 *  com.google.android.gms.internal.ads.zzawo
 *  com.google.android.gms.internal.ads.zzawp
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzawi;
import com.google.android.gms.internal.ads.zzawj;
import com.google.android.gms.internal.ads.zzawk;
import com.google.android.gms.internal.ads.zzawl;
import com.google.android.gms.internal.ads.zzawm;
import com.google.android.gms.internal.ads.zzawn;
import com.google.android.gms.internal.ads.zzawo;
import com.google.android.gms.internal.ads.zzawp;
import java.lang.ref.WeakReference;

final class zzawq
implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzb;
    private boolean zzc = false;

    public zzawq(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference<Application.ActivityLifecycleCallbacks>(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.zza((zzawp)new zzawi(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza((zzawp)new zzawo(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        this.zza((zzawp)new zzawl(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        this.zza((zzawp)new zzawk(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza((zzawp)new zzawn(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        this.zza((zzawp)new zzawj(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        this.zza((zzawp)new zzawm(this, activity));
    }

    protected final void zza(zzawp zzawp2) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzawp2.zza(activityLifecycleCallbacks);
                return;
            }
            if (this.zzc) return;
            this.zza.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
            this.zzc = true;
            return;
        }
        catch (Exception exception) {
            zze.zzg((String)"Error while dispatching lifecycle callback.", (Throwable)exception);
            return;
        }
    }
}
