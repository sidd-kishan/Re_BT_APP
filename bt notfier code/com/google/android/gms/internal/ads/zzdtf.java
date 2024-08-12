/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.ads.mediation.AdUrlAdapter
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzbvj
 *  com.google.android.gms.internal.ads.zzbwf
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzbye
 *  com.google.android.gms.internal.ads.zzdtc
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbvj;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzbye;
import com.google.android.gms.internal.ads.zzdtc;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdtf {
    private final zzdtc zza;
    private final AtomicReference<zzbvg> zzb = new AtomicReference();

    zzdtf(zzdtc zzdtc2) {
        this.zza = zzdtc2;
    }

    private final zzbvg zze() throws RemoteException {
        zzbvg zzbvg2 = this.zzb.get();
        if (zzbvg2 != null) {
            return zzbvg2;
        }
        zze.zzi((String)"Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final void zza(zzbvg zzbvg2) {
        this.zzb.compareAndSet(null, zzbvg2);
    }

    public final zzfbi zzb(String string, JSONObject object) throws zzfaw {
        try {
            block11: {
                if ("com.google.ads.mediation.admob.AdMobAdapter".equals(string)) {
                    AdMobAdapter adMobAdapter = new AdMobAdapter();
                    object = new zzbwf((MediationAdapter)adMobAdapter);
                } else if ("com.google.ads.mediation.AdUrlAdapter".equals(string)) {
                    object = new AdUrlAdapter();
                    object = new zzbwf((MediationAdapter)object);
                } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(string)) {
                    object = new zzbye();
                    object = new zzbwf((MediationAdapter)object);
                } else {
                    zzbvg zzbvg2 = this.zze();
                    boolean bl = "com.google.ads.mediation.customevent.CustomEventAdapter".equals(string);
                    if (bl || (bl = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(string))) {
                        try {
                            object = object.getString("class_name");
                            object = zzbvg2.zzc((String)object) ? zzbvg2.zzb("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") : (zzbvg2.zzd((String)object) ? zzbvg2.zzb((String)object) : zzbvg2.zzb("com.google.ads.mediation.customevent.CustomEventAdapter"));
                            break block11;
                        }
                        catch (JSONException jSONException) {
                            zze.zzg((String)"Invalid custom event.", (Throwable)jSONException);
                        }
                    }
                    object = zzbvg2.zzb(string);
                }
            }
            object = new zzfbi((zzbvj)object);
        }
        catch (Throwable throwable) {
            throw new zzfaw(throwable);
        }
        this.zza.zza(string, (zzfbi)object);
        return object;
    }

    public final zzbxn zzc(String string) throws RemoteException {
        zzbxn zzbxn2 = this.zze().zzf(string);
        this.zza.zzb(string, zzbxn2);
        return zzbxn2;
    }

    public final boolean zzd() {
        if (this.zzb.get() == null) return false;
        return true;
    }
}
