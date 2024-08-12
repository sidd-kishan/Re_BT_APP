/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.view.View
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbvp
 *  com.google.android.gms.internal.ads.zzbxa
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzefm
 *  com.google.android.gms.internal.ads.zzefn
 *  com.google.android.gms.internal.ads.zzefy
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbvp;
import com.google.android.gms.internal.ads.zzbxa;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzefm;
import com.google.android.gms.internal.ads.zzefn;
import com.google.android.gms.internal.ads.zzefy;

final class zzefl
extends zzbxa {
    final zzefn zza;
    private final zzeef<zzbxn, zzefy> zzb;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzefl(zzefn zzefn2, zzeef zzeef2, zzefm zzefm2) {
        this.zza = zzefn2;
        this.zzb = zzeef2;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzefn.zzc((zzefn)this.zza, (View)((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper)));
        ((zzefy)this.zzb.zzc).zzj();
    }

    public final void zzf(String string) throws RemoteException {
        ((zzefy)this.zzb.zzc).zzw(0, string);
    }

    public final void zzg(zzbcz zzbcz2) throws RemoteException {
        ((zzefy)this.zzb.zzc).zzx(zzbcz2);
    }

    public final void zzh(zzbvp zzbvp2) throws RemoteException {
        zzefn.zzd((zzefn)this.zza, (zzbvp)zzbvp2);
        ((zzefy)this.zzb.zzc).zzj();
    }
}
