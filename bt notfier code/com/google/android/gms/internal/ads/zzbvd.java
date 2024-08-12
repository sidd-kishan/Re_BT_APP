/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.ads.mediation.AdUrlAdapter
 *  com.google.ads.mediation.MediationAdapter
 *  com.google.ads.mediation.NetworkExtras
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.ads.mediation.customevent.CustomEventAdapter
 *  com.google.android.gms.ads.mediation.Adapter
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 *  com.google.android.gms.ads.mediation.customevent.CustomEventExtras
 *  com.google.android.gms.ads.mediation.rtb.RtbAdapter
 *  com.google.android.gms.internal.ads.zzbvf
 *  com.google.android.gms.internal.ads.zzbvj
 *  com.google.android.gms.internal.ads.zzbwf
 *  com.google.android.gms.internal.ads.zzbwk
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzbxr
 *  com.google.android.gms.internal.ads.zzbxy
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.internal.ads.zzbvf;
import com.google.android.gms.internal.ads.zzbvj;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzbwk;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzbxr;
import com.google.android.gms.internal.ads.zzbxy;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.Map;

public final class zzbvd
extends zzbvf {
    private static final zzbxr zzb = new zzbxr();
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zza;

    public final zzbvj zzb(String string) throws RemoteException {
        block15: {
            try {
                zzbwf zzbwf2 = Class.forName(string, false, zzbvd.class.getClassLoader());
                if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom((Class<?>)zzbwf2)) {
                    com.google.ads.mediation.MediationAdapter mediationAdapter = (com.google.ads.mediation.MediationAdapter)zzbwf2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    com.google.ads.mediation.NetworkExtras networkExtras = (com.google.ads.mediation.NetworkExtras)this.zza.get(mediationAdapter.getAdditionalParametersType());
                    zzbwf2 = new zzbwk(mediationAdapter, networkExtras);
                    string = zzbwf2;
                } else if (MediationAdapter.class.isAssignableFrom((Class<?>)zzbwf2)) {
                    zzbwf2 = new zzbwf((MediationAdapter)zzbwf2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    string = zzbwf2;
                } else {
                    if (!Adapter.class.isAssignableFrom((Class<?>)zzbwf2)) {
                        int n = String.valueOf(string).length();
                        zzbwf2 = new StringBuilder(n + 64);
                        zzbwf2.append("Could not instantiate mediation adapter: ");
                        zzbwf2.append(string);
                        zzbwf2.append(" (not a valid adapter).");
                        zzcgt.zzi((String)zzbwf2.toString());
                        zzbwf2 = new RemoteException();
                        throw zzbwf2;
                    }
                    zzbwf2 = new zzbwf((Adapter)zzbwf2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    string = zzbwf2;
                }
            }
            catch (Throwable throwable) {
                try {
                    zzcgt.zzd((String)"Reflection failed, retrying using direct instantiation");
                    if ("com.google.ads.mediation.admob.AdMobAdapter".equals(string)) {
                        AdMobAdapter adMobAdapter = new AdMobAdapter();
                        adMobAdapter = new zzbwf((MediationAdapter)adMobAdapter);
                        string = adMobAdapter;
                    } else if ("com.google.ads.mediation.AdUrlAdapter".equals(string)) {
                        AdUrlAdapter adUrlAdapter = new AdUrlAdapter();
                        adUrlAdapter = new zzbwf((MediationAdapter)adUrlAdapter);
                        string = adUrlAdapter;
                    } else if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(string)) {
                        com.google.android.gms.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.android.gms.ads.mediation.customevent.CustomEventAdapter();
                        customEventAdapter = new zzbwf((MediationAdapter)customEventAdapter);
                        string = customEventAdapter;
                    } else {
                        if (!"com.google.ads.mediation.customevent.CustomEventAdapter".equals(string)) throw new RemoteException();
                        CustomEventAdapter customEventAdapter = new CustomEventAdapter();
                        customEventAdapter = new zzbwk((com.google.ads.mediation.MediationAdapter)customEventAdapter, (com.google.ads.mediation.NetworkExtras)((CustomEventExtras)this.zza.get(customEventAdapter.getAdditionalParametersType())));
                        string = customEventAdapter;
                    }
                }
                catch (Throwable throwable2) {
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 43);
                    stringBuilder.append("Could not instantiate mediation adapter: ");
                    stringBuilder.append(string);
                    stringBuilder.append(". ");
                    zzcgt.zzj((String)stringBuilder.toString(), (Throwable)throwable2);
                    break block15;
                }
            }
            return string;
        }
        throw new RemoteException();
    }

    public final boolean zzc(String string) throws RemoteException {
        try {
            boolean bl = CustomEvent.class.isAssignableFrom(Class.forName(string, false, zzbvd.class.getClassLoader()));
            return bl;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 88);
            stringBuilder.append("Could not load custom event implementation class: ");
            stringBuilder.append(string);
            stringBuilder.append(", trying Adapter implementation class.");
            zzcgt.zzi((String)stringBuilder.toString());
            return false;
        }
    }

    public final boolean zzd(String string) throws RemoteException {
        try {
            boolean bl = Adapter.class.isAssignableFrom(Class.forName(string, false, zzbvd.class.getClassLoader()));
            return bl;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 104);
            stringBuilder.append("Could not load custom event implementation class as Adapter: ");
            stringBuilder.append(string);
            stringBuilder.append(", assuming old custom event implementation.");
            zzcgt.zzi((String)stringBuilder.toString());
            return false;
        }
    }

    public final void zze(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zza = map;
    }

    public final zzbxn zzf(String string) throws RemoteException {
        try {
            string = new zzbxy((RtbAdapter)Class.forName(string, false, zzbxr.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            return string;
        }
        catch (Throwable throwable) {
            throw new RemoteException();
        }
    }
}
