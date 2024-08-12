/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.view.View
 *  android.webkit.WebView
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbzi
 *  com.google.android.gms.internal.ads.zzbzk
 *  com.google.android.gms.internal.ads.zzbzl
 *  com.google.android.gms.internal.ads.zzbzm
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgv
 *  com.google.android.gms.internal.ads.zzcgw
 *  com.google.android.gms.internal.ads.zzcgx
 *  com.google.android.gms.internal.ads.zzffy
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbzi;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcgw;
import com.google.android.gms.internal.ads.zzcgx;
import com.google.android.gms.internal.ads.zzffy;

public final class zzbzj
implements zzbzk {
    static boolean zza;
    static boolean zzb;
    private static final Object zzd;
    zzffy zzc;

    static {
        zzd = new Object();
        zza = false;
        zzb = false;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean zza(Context context) {
        Object object = zzd;
        synchronized (object) {
            void var1_4;
            zzbjd zzbjd2 = zzbjl.zzdu;
            if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                return false;
            }
            if (zza) {
                return true;
            }
            try {
                boolean bl;
                this.zzb(context);
                zza = bl = this.zzc.zze(ObjectWrapper.wrap((Object)context));
                return bl;
            }
            catch (NullPointerException nullPointerException) {
            }
            catch (RemoteException remoteException) {
                // empty catch block
            }
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_4);
            return false;
        }
    }

    final void zzb(Context context) {
        Object object = zzd;
        synchronized (object) {
            zzbjd zzbjd2 = zzbjl.zzdu;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            boolean bl = zzb;
            if (bl) return;
            try {
                zzb = true;
                this.zzc = (zzffy)zzcgx.zza((Context)context, (String)"com.google.android.gms.ads.omid.DynamiteOmid", (zzcgv)zzbzi.zza);
            }
            catch (zzcgw zzcgw2) {
                zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)zzcgw2);
            }
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    public final String zzc(Context object) {
        void var1_4;
        zzbjd zzbjd2 = zzbjl.zzdu;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return null;
        }
        try {
            this.zzb((Context)object);
            object = String.valueOf(this.zzc.zzh());
            object = ((String)object).length() != 0 ? "a.".concat((String)object) : new String("a.");
            return object;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_4);
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final IObjectWrapper zzd(String string, WebView webView, String string2, String object, String string3, zzbzm zzbzm2, zzbzl zzbzl2, String string4) {
        Object object2 = zzd;
        // MONITORENTER : object2
        zzbjd zzbjd2 = zzbjl.zzdu;
        boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
        zzbjd2 = null;
        if (bl && zza) {
            // MONITOREXIT : object2
            try {
                void var8_11;
                void var7_10;
                void var6_9;
                void var5_8;
                void var2_5;
                return this.zzc.zzl(string, ObjectWrapper.wrap((Object)var2_5), "", "javascript", (String)var5_8, "Google", var6_9.toString(), var7_10.toString(), (String)var8_11);
            }
            catch (NullPointerException nullPointerException) {
            }
            catch (RemoteException remoteException) {
                // empty catch block
            }
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)((Object)string));
            return zzbjd2;
        }
        // MONITOREXIT : object2
        return zzbjd2;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final IObjectWrapper zze(String string, WebView webView, String object, String string2, String string3, String string4, zzbzm zzbzm2, zzbzl zzbzl2, String string5) {
        Object object2 = zzd;
        // MONITORENTER : object2
        zzbjd zzbjd2 = zzbjl.zzdu;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && zza) {
            void var1_4;
            // MONITOREXIT : object2
            try {
                void var9_13;
                void var8_12;
                void var7_11;
                void var6_10;
                void var5_9;
                void var2_6;
                return this.zzc.zzk(string, ObjectWrapper.wrap((Object)var2_6), "", "javascript", (String)var5_9, (String)var6_10, var7_11.toString(), var8_12.toString(), (String)var9_13);
            }
            catch (NullPointerException nullPointerException) {
            }
            catch (RemoteException remoteException) {
                // empty catch block
            }
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_4);
            return null;
        }
        // MONITOREXIT : object2
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzf(IObjectWrapper iObjectWrapper) {
        void var1_4;
        Object object = zzd;
        synchronized (object) {
            zzbjd zzbjd2 = zzbjl.zzdu;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            if (!zza) {
                return;
            }
        }
        try {
            this.zzc.zzf(iObjectWrapper);
            return;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_4);
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzg(IObjectWrapper iObjectWrapper) {
        void var1_4;
        Object object = zzd;
        synchronized (object) {
            zzbjd zzbjd2 = zzbjl.zzdu;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            if (!zza) {
                return;
            }
        }
        try {
            this.zzc.zzi(iObjectWrapper);
            return;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_4);
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzh(IObjectWrapper iObjectWrapper, View view) {
        void var1_4;
        Object object = zzd;
        synchronized (object) {
            zzbjd zzbjd2 = zzbjl.zzdu;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            if (!zza) {
                return;
            }
        }
        try {
            void var2_5;
            this.zzc.zzg(iObjectWrapper, ObjectWrapper.wrap((Object)var2_5));
            return;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_4);
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzi(IObjectWrapper iObjectWrapper, View view) {
        void var1_4;
        Object object = zzd;
        synchronized (object) {
            zzbjd zzbjd2 = zzbjl.zzdu;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            if (!zza) {
                return;
            }
        }
        try {
            void var2_5;
            this.zzc.zzj(iObjectWrapper, ObjectWrapper.wrap((Object)var2_5));
            return;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var1_4);
    }
}
