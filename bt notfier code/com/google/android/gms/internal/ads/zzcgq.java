/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  com.google.android.gms.internal.ads.zzcgr
 *  com.google.android.gms.internal.ads.zzcgs
 */
package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzcgs;

final class zzcgq
implements zzcgr {
    private final String zza;

    zzcgq(String string) {
        this.zza = string;
    }

    public final void zza(JsonWriter jsonWriter) {
        String string = this.zza;
        int n = zzcgs.zza;
        jsonWriter.name("params").beginObject();
        if (string != null) {
            jsonWriter.name("error_description").value(string);
        }
        jsonWriter.endObject();
    }
}
