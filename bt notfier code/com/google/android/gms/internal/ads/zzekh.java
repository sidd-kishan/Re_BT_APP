/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzbxp
 *  com.google.android.gms.internal.ads.zzchl
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzbxp;
import com.google.android.gms.internal.ads.zzchl;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzekh
extends zzbxp {
    private final String zza;
    private final zzbxn zzb;
    private final zzchl<JSONObject> zzc;
    private final JSONObject zzd;
    private boolean zze;

    /*
     * Enabled force condition propagation
     */
    public zzekh(String string, zzbxn zzbxn2, zzchl<JSONObject> zzchl2) {
        JSONObject jSONObject;
        this.zzd = jSONObject = new JSONObject();
        this.zze = false;
        this.zzc = zzchl2;
        this.zza = string;
        this.zzb = zzbxn2;
        try {
            jSONObject.put("adapter_version", (Object)zzbxn2.zzf().toString());
            this.zzd.put("sdk_version", (Object)this.zzb.zzg().toString());
            this.zzd.put("name", (Object)this.zza);
            return;
        }
        catch (RemoteException | NullPointerException | JSONException throwable) {
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzb() {
        synchronized (this) {
            boolean bl = this.zze;
            if (bl) {
                return;
            }
            this.zzc.zzc((Object)this.zzd);
            this.zze = true;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zze(String string) throws RemoteException {
        synchronized (this) {
            boolean bl = this.zze;
            if (bl) {
                return;
            }
            if (string == null) {
                this.zzf("Adapter returned null signals");
                return;
            }
            try {
                this.zzd.put("signals", (Object)string);
            }
            catch (JSONException jSONException) {}
            this.zzc.zzc((Object)this.zzd);
            this.zze = true;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzf(String string) throws RemoteException {
        synchronized (this) {
            boolean bl = this.zze;
            if (bl) {
                return;
            }
            try {
                this.zzd.put("signal_error", (Object)string);
            }
            catch (JSONException jSONException) {}
            this.zzc.zzc((Object)this.zzd);
            this.zze = true;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzg(zzbcz zzbcz2) throws RemoteException {
        synchronized (this) {
            boolean bl = this.zze;
            if (bl) {
                return;
            }
            try {
                this.zzd.put("signal_error", (Object)zzbcz2.zzb);
            }
            catch (JSONException jSONException) {}
            this.zzc.zzc((Object)this.zzd);
            this.zze = true;
            return;
        }
    }
}
