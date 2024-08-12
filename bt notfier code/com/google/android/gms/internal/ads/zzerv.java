/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.preference.PreferenceManager
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzert
 *  com.google.android.gms.internal.ads.zzeru
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzert;
import com.google.android.gms.internal.ads.zzeru;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzerv
implements zzery<zzerx<Bundle>> {
    private final zzfsn zza;
    private final Context zzb;

    zzerv(zzfsn zzfsn2, Context context) {
        this.zza = zzfsn2;
        this.zzb = context;
    }

    public static Bundle zzb(Context context, JSONArray jSONArray) {
        Bundle bundle = new Bundle();
        int n = 0;
        while (n < jSONArray.length()) {
            Object object = jSONArray.optJSONObject(n);
            String string = object.optString("bk");
            String string2 = object.optString("sk");
            int n2 = object.optInt("type", -1);
            n2 = n2 != 0 ? (n2 != 1 ? (n2 != 2 ? 0 : 3) : 2) : 1;
            if (!TextUtils.isEmpty((CharSequence)string) && !TextUtils.isEmpty((CharSequence)string2) && n2 != 0) {
                String[] stringArray = string2.split("/");
                int n3 = stringArray.length;
                string2 = null;
                object = string2;
                if (n3 <= 2) {
                    if (n3 == 0) {
                        object = string2;
                    } else {
                        if (n3 == 1) {
                            object = PreferenceManager.getDefaultSharedPreferences((Context)context);
                            string2 = stringArray[0];
                        } else {
                            object = context.getSharedPreferences(stringArray[0], 0);
                            string2 = stringArray[1];
                        }
                        object = object.getAll().get(string2);
                    }
                }
                if (object != null) {
                    if (--n2 != 0) {
                        if (n2 != 1) {
                            if (object instanceof Boolean) {
                                bundle.putBoolean(string, ((Boolean)object).booleanValue());
                            }
                        } else if (object instanceof Integer) {
                            bundle.putInt(string, ((Integer)object).intValue());
                        } else if (object instanceof Long) {
                            bundle.putLong(string, ((Long)object).longValue());
                        } else if (object instanceof Float) {
                            bundle.putFloat(string, ((Float)object).floatValue());
                        }
                    } else if (object instanceof String) {
                        bundle.putString(string, (String)object);
                    }
                }
            }
            ++n;
        }
        return bundle;
    }

    public final zzfsm<zzerx<Bundle>> zza() {
        return this.zza.zzb((Callable)new zzert(this));
    }

    final /* synthetic */ zzerx zzc() throws Exception {
        Object object = zzbjl.zzet;
        object = (String)zzbet.zzc().zzc(object);
        if (TextUtils.isEmpty((CharSequence)object)) {
            return null;
        }
        try {
            object = new JSONArray((String)object);
        }
        catch (JSONException jSONException) {
            zze.zze((String)"JSON parsing error", (Throwable)jSONException);
            return null;
        }
        return new zzeru(zzerv.zzb(this.zzb, (JSONArray)object));
    }
}
