/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.internal.consent_sdk.zzcb
 *  com.google.android.gms.internal.consent_sdk.zzce
 */
package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.consent_sdk.zzcb;
import com.google.android.gms.internal.consent_sdk.zzce;
import java.util.Iterator;
import java.util.Set;

public final class zzcc {
    public static zzcb zza(Context object, String object2) {
        if (TextUtils.isEmpty((CharSequence)object2)) {
            return null;
        }
        if (((String[])(object2 = object2.split("/", -1))).length == 1) {
            object = String.valueOf(object.getPackageName()).concat("_preferences");
            object2 = object2[0];
        } else {
            if (((String[])object2).length != 2) return null;
            object = object2[0];
            object2 = object2[1];
        }
        if (TextUtils.isEmpty((CharSequence)object)) return null;
        if (!TextUtils.isEmpty((CharSequence)object2)) return new zzcb((String)object, (String)object2);
        return null;
    }

    public static void zza(Context context, Set<String> object) {
        zzce zzce2 = new zzce(context);
        Iterator<String> iterator = object.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                zzce2.zza();
                return;
            }
            object = iterator.next();
            zzcb zzcb2 = zzcc.zza(context, (String)object);
            if (zzcb2 == null) {
                object = ((String)(object = String.valueOf(object))).length() != 0 ? "clearKeys: unable to process key: ".concat((String)object) : new String("clearKeys: unable to process key: ");
                Log.d((String)"UserMessagingPlatform", (String)object);
                continue;
            }
            zzce.zza((zzce)zzce2, (String)zzcb2.zza).remove(zzcb2.zzb);
        }
    }
}
