/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.os.ConditionVariable
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjf
 *  com.google.android.gms.internal.ads.zzbjg
 *  com.google.android.gms.internal.ads.zzbjh
 *  com.google.android.gms.internal.ads.zzbji
 *  com.google.android.gms.internal.ads.zzbjn
 *  com.google.android.gms.internal.ads.zzblm
 *  com.google.android.gms.internal.ads.zzbln
 *  com.google.android.gms.internal.ads.zzfmj
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjf;
import com.google.android.gms.internal.ads.zzbjg;
import com.google.android.gms.internal.ads.zzbjh;
import com.google.android.gms.internal.ads.zzbji;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzblm;
import com.google.android.gms.internal.ads.zzbln;
import com.google.android.gms.internal.ads.zzfmj;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbjj
implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();

    static /* synthetic */ SharedPreferences zza(zzbjj zzbjj2) {
        return zzbjj2.zze;
    }

    /*
     * Enabled force condition propagation
     */
    private final void zzf() {
        if (this.zze == null) {
            return;
        }
        try {
            JSONObject jSONObject;
            zzbjh zzbjh2 = new zzbjh(this);
            String string = (String)zzbjn.zza((zzfmj)zzbjh2);
            this.zzh = jSONObject = new JSONObject(string);
            return;
        }
        catch (JSONException jSONException) {
            return;
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String string) {
        if (!"flag_configuration".equals(string)) return;
        this.zzf();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzb(Context context) {
        if (this.zzd) {
            return;
        }
        Object object = this.zzb;
        synchronized (object) {
            block18: {
                block20: {
                    Context context2;
                    block19: {
                        Context context3;
                        if (this.zzd) {
                            return;
                        }
                        if (!this.zza) {
                            this.zza = true;
                        }
                        context2 = context.getApplicationContext() == null ? context : context.getApplicationContext();
                        this.zzg = context2;
                        try {
                            this.zzf = Wrappers.packageManager((Context)context2).getApplicationInfo((String)this.zzg.getPackageName(), (int)128).metaData;
                        }
                        catch (PackageManager.NameNotFoundException | NullPointerException throwable) {}
                        context2 = context3 = GooglePlayServicesUtilLight.getRemoteContext((Context)context);
                        if (context3 != null) break block19;
                        context2 = context3;
                        if (context != null && (context2 = context.getApplicationContext()) == null) break block20;
                    }
                    context = context2;
                }
                if (context != null) break block18;
                this.zza = false;
                this.zzc.open();
                return;
            }
            try {
                zzbet.zza();
                context = zzbjf.zza((Context)context);
                this.zze = context;
                if (context != null) {
                    context.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)this);
                }
                context = new zzbji(this);
                zzbln.zzb((zzblm)context);
                this.zzf();
                this.zzd = true;
                return;
            }
            finally {
                this.zza = false;
                this.zzc.open();
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final <T> T zzc(zzbjd<T> object) {
        block12: {
            Object object2;
            block11: {
                if (!this.zzc.block(5000L)) {
                    object2 = this.zzb;
                    // MONITORENTER : object2
                    if (!this.zza) {
                        IllegalStateException illegalStateException = new IllegalStateException("Flags.initialize() was not called!");
                        throw illegalStateException;
                    }
                    // MONITOREXIT : object2
                }
                if (this.zzd && this.zze != null) break block11;
                object2 = this.zzb;
                // MONITORENTER : object2
                if (!this.zzd || this.zze == null) break block12;
                // MONITOREXIT : object2
            }
            if (object.zzm() == 2) {
                object2 = this.zzf;
                if (object2 != null) return (T)object.zza((Bundle)object2);
                return (T)object.zzf();
            }
            if (object.zzm() != 1) return (T)zzbjn.zza((zzfmj)new zzbjg(this, object));
            if (!this.zzh.has(object.zze())) return (T)zzbjn.zza((zzfmj)new zzbjg(this, object));
            return (T)object.zzc(this.zzh);
        }
        Object object3 = object.zzf();
        // MONITOREXIT : object2
        return (T)object3;
    }

    final /* synthetic */ String zzd() {
        return this.zze.getString("flag_configuration", "{}");
    }

    final /* synthetic */ Object zze(zzbjd zzbjd2) {
        return zzbjd2.zzd(this.zze);
    }
}
