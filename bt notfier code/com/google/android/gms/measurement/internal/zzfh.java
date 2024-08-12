/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  com.google.android.gms.common.R$string
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R;

public final class zzfh {
    public static String zza(Context object) {
        try {
            String string2 = object.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
            object = string2;
        }
        catch (Resources.NotFoundException notFoundException) {
            object = object.getPackageName();
        }
        return object;
    }

    public static final String zzb(String string2, Resources object, String string3) {
        int n = object.getIdentifier(string2, "string", string3);
        string2 = null;
        if (n == 0) return string2;
        try {
            object = object.getString(n);
            string2 = object;
        }
        catch (Resources.NotFoundException notFoundException) {}
        return string2;
    }
}
