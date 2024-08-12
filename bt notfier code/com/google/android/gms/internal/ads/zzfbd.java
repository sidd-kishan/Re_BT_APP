/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class zzfbd {
    public static Bundle zza(Bundle object, String string) {
        string = object.getBundle(string);
        object = string;
        if (string != null) return object;
        object = new Bundle();
        return object;
    }

    public static void zzb(Bundle bundle, String string, String string2, boolean bl) {
        if (!bl) return;
        bundle.putString(string, string2);
    }

    public static void zzc(Bundle bundle, String string, Integer n, boolean bl) {
        if (!bl) return;
        bundle.putInt(string, n.intValue());
    }

    public static void zzd(Bundle bundle, String string, Boolean bl, boolean bl2) {
        if (!bl2) return;
        bundle.putBoolean(string, bl.booleanValue());
    }

    public static void zze(Bundle bundle, String string, String string2) {
        if (string2 == null) return;
        bundle.putString(string, string2);
    }

    public static void zzf(Bundle bundle, String string, Bundle bundle2) {
        if (bundle2 == null) return;
        bundle.putBundle(string, bundle2);
    }

    public static void zzg(Bundle bundle, String string, List<String> list) {
        if (list == null) return;
        bundle.putStringArrayList(string, new ArrayList<String>(list));
    }
}
