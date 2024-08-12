/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.internal.consent_sdk.zzca
 *  com.google.android.gms.internal.consent_sdk.zzf
 *  com.google.android.gms.internal.consent_sdk.zzi
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.consent_sdk.zzca;
import com.google.android.gms.internal.consent_sdk.zzf;
import com.google.android.gms.internal.consent_sdk.zzi;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

final class zzg
implements Runnable {
    private final String zza;
    private final String zzb;
    private final zzi[] zzc;

    zzg(String string, String string2, zzi[] zziArray) {
        this.zza = string;
        this.zzb = string2;
        this.zzc = zziArray;
    }

    @Override
    public final void run() {
        String string = this.zza;
        CharSequence charSequence = this.zzb;
        zzi[] zziArray = this.zzc;
        if (TextUtils.isEmpty((CharSequence)string)) {
            Log.d((String)"UserMessagingPlatform", (String)"Error on action: empty action name");
            return;
        }
        String string2 = string.toLowerCase();
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            string = new JSONObject();
        } else {
            try {
                string = new JSONObject((String)charSequence);
            }
            catch (JSONException jSONException) {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 32 + String.valueOf(charSequence).length());
                stringBuilder.append("Action[");
                stringBuilder.append(string2);
                stringBuilder.append("]: failed to parse args: ");
                stringBuilder.append((String)charSequence);
                Log.d((String)"UserMessagingPlatform", (String)stringBuilder.toString());
                return;
            }
        }
        Object object = String.valueOf(string);
        charSequence = new StringBuilder(String.valueOf(string2).length() + 10 + String.valueOf(object).length());
        ((StringBuilder)charSequence).append("Action[");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("]: ");
        ((StringBuilder)charSequence).append((String)object);
        Log.d((String)"UserMessagingPlatform", (String)((StringBuilder)charSequence).toString());
        int n = zziArray.length;
        int n2 = 0;
        while (n2 < n) {
            charSequence = zziArray[n2];
            object = new FutureTask(new zzf((zzi)charSequence, string2, (JSONObject)string));
            charSequence.zza().execute((Runnable)object);
            try {
                boolean bl = (Boolean)((FutureTask)object).get();
                if (bl) {
                    return;
                }
            }
            catch (InterruptedException interruptedException) {
                object = new StringBuilder(String.valueOf(string2).length() + 33);
                ((StringBuilder)object).append("Thread interrupted for Action[");
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append("]: ");
                zzca.zza((String)((StringBuilder)object).toString(), (Throwable)interruptedException);
            }
            catch (ExecutionException executionException) {
                object = new StringBuilder(String.valueOf(string2).length() + 24);
                ((StringBuilder)object).append("Failed to run Action[");
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append("]: ");
                zzca.zza((String)((StringBuilder)object).toString(), (Throwable)executionException.getCause());
            }
            ++n2;
        }
    }
}
