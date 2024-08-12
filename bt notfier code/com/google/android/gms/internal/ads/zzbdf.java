/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamic.RemoteCreator
 *  com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException
 *  com.google.android.gms.internal.ads.zzbde
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbfl
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbfo
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcar
 *  com.google.android.gms.internal.ads.zzcat
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgv
 *  com.google.android.gms.internal.ads.zzcgw
 *  com.google.android.gms.internal.ads.zzcgx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbfl;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfo;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcar;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcgw;
import com.google.android.gms.internal.ads.zzcgx;

public final class zzbdf
extends RemoteCreator<zzbfo> {
    private zzcat zza;

    public zzbdf() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /*
     * WARNING - void declaration
     */
    public final zzbfn zza(Context object, zzbdl zzbdl2, String string, zzbvg zzbvg2, int n) {
        void var1_4;
        zzbjl.zza((Context)object);
        zzbjd zzbjd2 = zzbjl.zzgW;
        boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
        IObjectWrapper iObjectWrapper = null;
        zzbjd2 = null;
        if (bl) {
            block12: {
                void var2_9;
                try {
                    iObjectWrapper = ObjectWrapper.wrap((Object)object);
                    zzbdl2 = ((zzbfo)zzcgx.zza((Context)object, (String)"com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", (zzcgv)zzbde.zza)).zze(iObjectWrapper, zzbdl2, string, zzbvg2, 213806000, n);
                    if (zzbdl2 == null) {
                        object = zzbjd2;
                    } else {
                        string = zzbdl2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                        if (string instanceof zzbfn) {
                            zzbdl2 = (zzbfn)string;
                            object = zzbdl2;
                        } else {
                            zzbdl2 = new zzbfl((IBinder)zzbdl2);
                            object = zzbdl2;
                        }
                    }
                    break block12;
                }
                catch (NullPointerException nullPointerException) {
                }
                catch (RemoteException remoteException) {
                }
                catch (zzcgw zzcgw2) {
                    // empty catch block
                }
                object = zzcar.zza((Context)object);
                this.zza = object;
                object.zzd((Throwable)var2_9, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var2_9);
                object = zzbjd2;
            }
            return object;
        }
        try {
            zzbjd2 = ObjectWrapper.wrap((Object)object);
            object = ((zzbfo)this.getRemoteCreatorInstance((Context)object)).zze((IObjectWrapper)zzbjd2, zzbdl2, string, zzbvg2, 213806000, n);
            object = object == null ? iObjectWrapper : ((zzbdl2 = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager")) instanceof zzbfn ? (zzbfn)zzbdl2 : new zzbfl((IBinder)object));
            return object;
        }
        catch (RemoteCreator.RemoteCreatorException remoteCreatorException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zze((String)"Could not create remote AdManager.", (Throwable)var1_4);
        return null;
    }
}
