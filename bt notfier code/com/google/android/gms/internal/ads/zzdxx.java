/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrs
 *  com.google.android.gms.internal.ads.zzdtc
 *  com.google.android.gms.internal.ads.zzdxk
 *  com.google.android.gms.internal.ads.zzdxv
 *  com.google.android.gms.internal.ads.zzdxw
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzdtc;
import com.google.android.gms.internal.ads.zzdxk;
import com.google.android.gms.internal.ads.zzdxv;
import com.google.android.gms.internal.ads.zzdxw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzdxx {
    private final zzdxk zza;
    private final zzdtc zzb;
    private final Object zzc = new Object();
    private final List<zzdxw> zzd;
    private boolean zze;

    zzdxx(zzdxk zzdxk2, zzdtc zzdtc2) {
        this.zza = zzdxk2;
        this.zzb = zzdtc2;
        this.zzd = new ArrayList<zzdxw>();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzc(zzdxx zzdxx2, List list) {
        zzdxx2.zzd(list);
    }

    private final void zzd(List<zzbrl> object) {
        Object object2 = this.zzc;
        synchronized (object2) {
            try {
                if (this.zze) {
                    return;
                }
                Iterator<zzbrl> iterator = object.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.zze = true;
                        return;
                    }
                    zzbrl zzbrl2 = iterator.next();
                    List<zzdxw> list = this.zzd;
                    String string = zzbrl2.zza;
                    object = this.zzb.zzc(string);
                    object = object == null ? "" : ((object = object.zzb) == null ? "" : object.toString());
                    zzdxw zzdxw2 = new zzdxw(string, (String)object, zzbrl2.zzb ? 1 : 0, zzbrl2.zzd, zzbrl2.zzc);
                    list.add(zzdxw2);
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zza() {
        this.zza.zzh((zzbrs)new zzdxv(this));
    }

    public final JSONArray zzb() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Object object = this.zzc;
        synchronized (object) {
            try {
                if (!this.zze) {
                    if (!this.zza.zzm()) {
                        this.zza();
                        return jSONArray;
                    }
                    this.zzd(this.zza.zzj());
                }
                Iterator<zzdxw> iterator = this.zzd.iterator();
                while (iterator.hasNext()) {
                    jSONArray.put((Object)iterator.next().zza());
                }
                return jSONArray;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
