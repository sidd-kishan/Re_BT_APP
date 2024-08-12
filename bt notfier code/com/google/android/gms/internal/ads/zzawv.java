/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzawu
 *  com.google.android.gms.internal.ads.zzaww
 *  com.google.android.gms.internal.ads.zzaxk
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzawu;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzaxk;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzawv
implements Application.ActivityLifecycleCallbacks {
    private Activity zza;
    private Context zzb;
    private final Object zzc = new Object();
    private boolean zzd = true;
    private boolean zze = false;
    private final List<zzaww> zzf = new ArrayList<zzaww>();
    private final List<zzaxk> zzg = new ArrayList<zzaxk>();
    private Runnable zzh;
    private boolean zzi = false;
    private long zzj;

    zzawv() {
    }

    static /* synthetic */ Object zza(zzawv zzawv2) {
        return zzawv2.zzc;
    }

    static /* synthetic */ boolean zzb(zzawv zzawv2) {
        return zzawv2.zzd;
    }

    static /* synthetic */ boolean zzc(zzawv zzawv2, boolean bl) {
        zzawv2.zzd = false;
        return false;
    }

    static /* synthetic */ boolean zzd(zzawv zzawv2) {
        return zzawv2.zze;
    }

    static /* synthetic */ List zze(zzawv zzawv2) {
        return zzawv2.zzf;
    }

    private final void zzk(Activity activity) {
        Object object = this.zzc;
        synchronized (object) {
            if (activity.getClass().getName().startsWith("com.google.android.gms.ads")) return;
            this.zza = activity;
            return;
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity object) {
        Object object2 = this.zzc;
        synchronized (object2) {
            try {
                Activity activity = this.zza;
                if (activity == null) return;
                if (activity.equals(object)) {
                    this.zza = null;
                }
                object = this.zzg.iterator();
                while (object.hasNext()) {
                    activity = (zzaxk)object.next();
                    try {
                        if (!activity.zza()) continue;
                        object.remove();
                    }
                    catch (Exception exception) {
                        zzt.zzg().zzk((Throwable)exception, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzcgt.zzg((String)"", (Throwable)exception);
                    }
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void onActivityPaused(Activity object) {
        block7: {
            this.zzk((Activity)object);
            object = this.zzc;
            synchronized (object) {
                for (zzaxk zzaxk2 : this.zzg) {
                    try {
                        zzaxk2.zzb();
                    }
                    catch (Exception exception) {
                        zzt.zzg().zzk((Throwable)exception, "AppActivityTracker.ActivityListener.onActivityPaused");
                        zzcgt.zzg((String)"", (Throwable)exception);
                    }
                }
                // MONITOREXIT @DISABLED, blocks:[0, 3] lbl15 : MonitorExitStatement: MONITOREXIT : var1_1 /* !! */ 
                this.zze = true;
                if (this.zzh == null) break block7;
                {
                    catch (Throwable throwable) {}
                    {
                        throw throwable;
                    }
                }
            }
            zzs.zza.removeCallbacks(this.zzh);
        }
        object = zzs.zza;
        zzawu zzawu2 = new zzawu(this);
        this.zzh = zzawu2;
        object.postDelayed((Runnable)zzawu2, this.zzj);
    }

    /*
     * Enabled force condition propagation
     */
    public final void onActivityResumed(Activity object) {
        this.zzk((Activity)object);
        this.zze = false;
        boolean bl = this.zzd;
        this.zzd = true;
        if (this.zzh != null) {
            zzs.zza.removeCallbacks(this.zzh);
        }
        Object object2 = this.zzc;
        synchronized (object2) {
            block11: {
                for (zzaxk zzaxk2 : this.zzg) {
                    try {
                        zzaxk2.zzc();
                    }
                    catch (Exception exception) {
                        zzt.zzg().zzk((Throwable)exception, "AppActivityTracker.ActivityListener.onActivityResumed");
                        zzcgt.zzg((String)"", (Throwable)exception);
                    }
                }
                if (!(bl ^ true)) break block11;
                Iterator<zzaxk> iterator = this.zzf.iterator();
                while (iterator.hasNext()) {
                    zzaxk zzaxk2;
                    zzaxk2 = (zzaww)iterator.next();
                    try {
                        zzaxk2.zza(true);
                    }
                    catch (Exception exception) {
                        zzcgt.zzg((String)"", (Throwable)exception);
                    }
                }
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zzd((String)"App is still foreground.");
            return;
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        this.zzk(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zzf(Application application, Context context) {
        if (this.zzi) return;
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        if (context instanceof Activity) {
            this.zzk((Activity)context);
        }
        this.zzb = application;
        application = zzbjl.zzaD;
        this.zzj = (Long)zzbet.zzc().zzc((zzbjd)application);
        this.zzi = true;
    }

    public final void zzg(zzaww zzaww2) {
        Object object = this.zzc;
        synchronized (object) {
            this.zzf.add(zzaww2);
            return;
        }
    }

    public final void zzh(zzaww zzaww2) {
        Object object = this.zzc;
        synchronized (object) {
            this.zzf.remove(zzaww2);
            return;
        }
    }

    public final Activity zzi() {
        return this.zza;
    }

    public final Context zzj() {
        return this.zzb;
    }
}
