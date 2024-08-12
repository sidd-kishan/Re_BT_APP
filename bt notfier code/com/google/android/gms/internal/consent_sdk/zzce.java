/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  com.google.android.gms.internal.consent_sdk.zzcb
 *  com.google.android.gms.internal.consent_sdk.zzcc
 */
package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.consent_sdk.zzcb;
import com.google.android.gms.internal.consent_sdk.zzcc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzce {
    private final Context zza;
    private final Map<String, SharedPreferences.Editor> zzb = new HashMap<String, SharedPreferences.Editor>();

    public zzce(Context context) {
        this.zza = context;
    }

    static /* synthetic */ SharedPreferences.Editor zza(zzce zzce2, String string) {
        return zzce2.zza(string);
    }

    private final SharedPreferences.Editor zza(String string) {
        if (this.zzb.containsKey(string)) return this.zzb.get(string);
        this.zzb.put(string, this.zza.getSharedPreferences(string, 0).edit());
        return this.zzb.get(string);
    }

    public final void zza() {
        Iterator<SharedPreferences.Editor> iterator = this.zzb.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().apply();
        }
    }

    public final boolean zza(String string, Object object) {
        if ((string = zzcc.zza((Context)this.zza, (String)string)) == null) {
            return false;
        }
        SharedPreferences.Editor editor = this.zza(((zzcb)string).zza);
        if (object instanceof Integer) {
            editor.putInt(((zzcb)string).zzb, ((Integer)object).intValue());
        } else if (object instanceof Long) {
            editor.putLong(((zzcb)string).zzb, ((Long)object).longValue());
        } else if (object instanceof Double) {
            editor.putFloat(((zzcb)string).zzb, ((Double)object).floatValue());
        } else if (object instanceof Float) {
            editor.putFloat(((zzcb)string).zzb, ((Float)object).floatValue());
        } else if (object instanceof Boolean) {
            editor.putBoolean(((zzcb)string).zzb, ((Boolean)object).booleanValue());
        } else {
            if (!(object instanceof String)) return false;
            editor.putString(((zzcb)string).zzb, (String)object);
        }
        return true;
    }
}
