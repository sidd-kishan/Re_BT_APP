/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzawe
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzdii
 *  com.google.android.gms.internal.ads.zzezz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzawe;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzdii;
import com.google.android.gms.internal.ads.zzezz;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzdij
extends zzdgm<zzawd>
implements zzawd {
    private final Map<View, zzawe> zzb = new WeakHashMap<View, zzawe>(1);
    private final Context zzc;
    private final zzezz zzd;

    public zzdij(Context context, Set<zzdih<zzawd>> set, zzezz zzezz2) {
        super(set);
        this.zzc = context;
        this.zzd = zzezz2;
    }

    public final void zza(View view) {
        synchronized (this) {
            zzawe zzawe2;
            zzawe zzawe3 = zzawe2 = this.zzb.get(view);
            if (zzawe2 == null) {
                zzawe3 = new zzawe(this.zzc, view);
                zzawe3.zza((zzawd)this);
                this.zzb.put(view, zzawe3);
            }
            if (this.zzd.zzT) {
                view = zzbjl.zzaT;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)view)).booleanValue()) {
                    view = zzbjl.zzaS;
                    zzawe3.zze(((Long)zzbet.zzc().zzc((zzbjd)view)).longValue());
                    return;
                }
            }
            zzawe3.zzf();
            return;
        }
    }

    public final void zzb(View view) {
        synchronized (this) {
            if (!this.zzb.containsKey(view)) return;
            this.zzb.get(view).zzb((zzawd)this);
            this.zzb.remove(view);
            return;
        }
    }

    public final void zzc(zzawc zzawc2) {
        synchronized (this) {
            zzdii zzdii2 = new zzdii(zzawc2);
            this.zzk((zzdgl)zzdii2);
            return;
        }
    }
}
