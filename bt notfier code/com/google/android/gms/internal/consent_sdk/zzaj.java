/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzcc
 *  com.google.android.gms.internal.consent_sdk.zzce
 *  com.google.android.gms.internal.consent_sdk.zzi
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzcc;
import com.google.android.gms.internal.consent_sdk.zzce;
import com.google.android.gms.internal.consent_sdk.zzi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzaj
implements zzi {
    private final Application zza;
    private final zzal zzb;
    private final Executor zzc;

    public zzaj(Application application, zzal zzal2, Executor executor) {
        this.zza = application;
        this.zzb = zzal2;
        this.zzc = executor;
    }

    public final Executor zza() {
        return this.zzc;
    }

    /*
     * Enabled force condition propagation
     */
    public final boolean zza(String string, JSONObject object) {
        int n = string.hashCode();
        int n2 = 0;
        if (n != 94746189) {
            if (n != 113399775) return false;
            if (!string.equals("write")) return false;
            n = 0;
        } else {
            if (!string.equals("clear")) return false;
            n = 1;
        }
        if (n != 0) {
            if (n != 1) {
                return false;
            }
            string = object.optJSONArray("keys");
            if (string == null || string.length() == 0) {
                string = String.valueOf(object.toString());
                string = string.length() != 0 ? "Action[clear]: wrong args.".concat(string) : new String("Action[clear]: wrong args.");
                Log.d((String)"UserMessagingPlatform", (String)string);
                return true;
            }
            object = new HashSet();
            int n3 = string.length();
            n = n2;
            while (true) {
                if (n >= n3) {
                    zzcc.zza((Context)this.zza, (Set)object);
                    return true;
                }
                CharSequence charSequence = string.optString(n);
                if (TextUtils.isEmpty((CharSequence)charSequence)) {
                    charSequence = new StringBuilder(46);
                    ((StringBuilder)charSequence).append("Action[clear]: empty key at index: ");
                    ((StringBuilder)charSequence).append(n);
                    Log.d((String)"UserMessagingPlatform", (String)((StringBuilder)charSequence).toString());
                } else {
                    object.add(charSequence);
                }
                ++n;
            }
        }
        zzce zzce2 = new zzce((Context)this.zza);
        Iterator iterator = object.keys();
        while (true) {
            if (!iterator.hasNext()) {
                this.zzb.zze();
                zzce2.zza();
                return true;
            }
            string = (String)iterator.next();
            Object object2 = object.opt(string);
            String string2 = String.valueOf(object2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 23 + String.valueOf(string2).length());
            stringBuilder.append("Writing to storage: [");
            stringBuilder.append(string);
            stringBuilder.append("] ");
            stringBuilder.append(string2);
            Log.d((String)"UserMessagingPlatform", (String)stringBuilder.toString());
            if (zzce2.zza(string, object2)) {
                this.zzb.zzd().add(string);
                continue;
            }
            string = (string = String.valueOf(string)).length() != 0 ? "Failed writing key: ".concat(string) : new String("Failed writing key: ");
            Log.d((String)"UserMessagingPlatform", (String)string);
        }
    }
}
