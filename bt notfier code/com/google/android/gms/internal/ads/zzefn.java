/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.view.View
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbvp
 *  com.google.android.gms.internal.ads.zzbxb
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzcwv
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzefl
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvp;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzcwv;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzefl;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzefn
implements zzeek<zzcvh, zzbxn, zzefy> {
    private final Context zza;
    private final zzcwe zzb;
    private View zzc;
    private zzbvp zzd;

    public zzefn(Context context, zzcwe zzcwe2) {
        this.zza = context;
        this.zzb = zzcwe2;
    }

    static /* synthetic */ View zzc(zzefn zzefn2, View view) {
        zzefn2.zzc = view;
        return view;
    }

    static /* synthetic */ zzbvp zzd(zzefn zzefn2, zzbvp zzbvp2) {
        zzefn2.zzd = zzbvp2;
        return zzbvp2;
    }

    public final void zza(zzfal zzfal2, zzezz object, zzeef<zzbxn, zzefy> zzeef2) throws zzfaw {
        try {
            ((zzbxn)zzeef2.zzb).zzo(object.zzV);
            Object object2 = zzbjl.zzfB;
            if (((Boolean)zzbet.zzc().zzc(object2)).booleanValue() && object.zzad) {
                zzbxn zzbxn2 = (zzbxn)zzeef2.zzb;
                object2 = object.zzQ;
                String string = object.zzv.toString();
                object = zzfal2.zza.zza.zzd;
                IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)this.zza);
                zzefl zzefl2 = new zzefl(this, zzeef2, null);
                zzbxn2.zzq((String)object2, string, (zzbdg)object, iObjectWrapper, (zzbxb)zzefl2, (zzbvm)zzeef2.zzc, zzfal2.zza.zza.zze);
                return;
            }
            object2 = (zzbxn)zzeef2.zzb;
            String string = object.zzQ;
            object = object.zzv.toString();
            zzbdg zzbdg2 = zzfal2.zza.zza.zzd;
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)this.zza);
            zzefl zzefl3 = new zzefl(this, zzeef2, null);
            object2.zzi(string, (String)object, zzbdg2, iObjectWrapper, (zzbxb)zzefl3, (zzbvm)zzeef2.zzc, zzfal2.zza.zza.zze);
            return;
        }
        catch (RemoteException remoteException) {
            throw new zzfaw((Throwable)remoteException);
        }
    }

    final /* synthetic */ zzfsm zze(View view, zzezz zzezz2, Object object) throws Exception {
        return zzfsd.zza((Object)zzcwv.zza((Context)this.zza, (View)view, (zzezz)zzezz2));
    }
}
