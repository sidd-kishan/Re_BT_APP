/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.view.ViewGroup
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzepg
 *  com.google.android.gms.internal.ads.zzepi
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzepg;
import com.google.android.gms.internal.ads.zzepi;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.Set;
import java.util.concurrent.Callable;

public final class zzeph
implements zzery<zzepi> {
    private final zzfsn zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set<String> zzd;

    public zzeph(zzfsn zzfsn2, ViewGroup viewGroup, Context context, Set<String> set) {
        this.zza = zzfsn2;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final zzfsm<zzepi> zza() {
        return this.zza.zzb((Callable)new zzepg(this));
    }

    final /* synthetic */ zzepi zzb() throws Exception {
        Object object = zzbjl.zzei;
        if (((Boolean)zzbet.zzc().zzc(object)).booleanValue() && this.zzb != null) {
            if (this.zzd.contains("banner")) return new zzepi(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        object = zzbjl.zzej;
        boolean bl = (Boolean)zzbet.zzc().zzc(object);
        object = null;
        if (!bl) return new zzepi(null);
        if (!this.zzd.contains("native")) return new zzepi(null);
        Object object2 = this.zzc;
        if (!(object2 instanceof Activity)) return new zzepi(null);
        Activity activity = (Activity)object2;
        object2 = activity.getWindow();
        bl = true;
        if (object2 != null && (object2.getAttributes().flags & 0x1000000) != 0) {
            object = true;
        } else {
            try {
                if ((activity.getPackageManager().getActivityInfo((ComponentName)activity.getComponentName(), (int)0).flags & 0x200) == 0) {
                    bl = false;
                }
                object2 = bl;
                object = object2;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        }
        return new zzepi((Boolean)object);
    }
}
