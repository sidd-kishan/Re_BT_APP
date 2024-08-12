/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Bundle
 *  android.preference.PreferenceManager
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzeop
 *  com.google.android.gms.internal.ads.zzeoq
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzeop;
import com.google.android.gms.internal.ads.zzeoq;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzeos
implements zzery<zzeoq> {
    private final Context zza;
    private final zzfsn zzb;

    zzeos(Context context, zzfsn zzfsn2) {
        this.zza = context;
        this.zzb = zzfsn2;
    }

    public final zzfsm<zzeoq> zza() {
        return this.zzb.zzb((Callable)new zzeop(this));
    }

    final /* synthetic */ zzeoq zzb() throws Exception {
        zzt.zzc();
        Object object = this.zza;
        Object object2 = zzbjl.zzeq;
        boolean bl = (Boolean)zzbet.zzc().zzc(object2);
        object2 = "";
        int n = 0;
        object = !bl ? "" : object.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
        Object object3 = zzbjl.zzes;
        if (((Boolean)zzbet.zzc().zzc(object3)).booleanValue()) {
            object2 = this.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "");
        }
        zzt.zzc();
        Context context = this.zza;
        object3 = zzbjl.zzer;
        if (!((Boolean)zzbet.zzc().zzc(object3)).booleanValue()) {
            object3 = null;
            return new zzeoq((String)object, (String)object2, (Bundle)object3, null);
        }
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context);
        context = new Bundle();
        if (sharedPreferences.contains("IABConsent_CMPPresent")) {
            context.putBoolean("IABConsent_CMPPresent", sharedPreferences.getBoolean("IABConsent_CMPPresent", false));
        }
        while (true) {
            object3 = context;
            if (n >= 4) return new zzeoq((String)object, (String)object2, (Bundle)object3, null);
            object3 = (new String[]{"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"})[n];
            if (sharedPreferences.contains((String)object3)) {
                context.putString((String)object3, sharedPreferences.getString((String)object3, null));
            }
            ++n;
        }
    }
}
