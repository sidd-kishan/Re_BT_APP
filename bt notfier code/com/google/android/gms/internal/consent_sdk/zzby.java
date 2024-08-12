/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  com.google.android.gms.internal.consent_sdk.zzbu
 *  com.google.android.gms.internal.consent_sdk.zzbx
 */
package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import com.google.android.gms.internal.consent_sdk.zzbu;
import com.google.android.gms.internal.consent_sdk.zzbx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzby {
    public int zza = zzbu.zzg;
    public String zzb;
    public String zzc;
    public String zzd;
    public List<String> zze = Collections.emptyList();
    public List<zzbx> zzf = Collections.emptyList();

    /*
     * Unable to fully structure code
     */
    public static zzby zza(JsonReader var0) throws IOException {
        var2_1 = new zzby();
        var0.beginObject();
        block8: while (true) {
            block22: {
                if (!var0.hasNext()) {
                    var0.endObject();
                    return var2_1;
                }
                var3_3 = var0.nextName();
                switch (var3_3.hashCode()) {
                    default: {
                        break;
                    }
                    case -790907624: {
                        if (!var3_3.equals("consent_form_payload")) break;
                        var1_2 = 1;
                        break block22;
                    }
                    case -986806987: {
                        if (!var3_3.equals("request_info_keys")) break;
                        var1_2 = 4;
                        break block22;
                    }
                    case -1161803523: {
                        if (!var3_3.equals("actions")) break;
                        var1_2 = 5;
                        break block22;
                    }
                    case -1851537225: {
                        if (!var3_3.equals("consent_form_base_url")) break;
                        var1_2 = 2;
                        break block22;
                    }
                    case -1938755376: {
                        if (!var3_3.equals("error_message")) break;
                        var1_2 = 3;
                        break block22;
                    }
                    case -2001388947: {
                        if (!var3_3.equals("consent_signal")) break;
                        var1_2 = 0;
                        break block22;
                    }
                }
                var1_2 = -1;
            }
            if (var1_2 == 0) ** GOTO lbl61
            if (var1_2 == 1) ** GOTO lbl59
            if (var1_2 == 2) ** GOTO lbl57
            if (var1_2 == 3) ** GOTO lbl55
            if (var1_2 != 4) {
                if (var1_2 != 5) {
                    var0.skipValue();
                    continue;
                }
            } else {
                var2_1.zze = new ArrayList<String>();
                var0.beginArray();
                while (var0.hasNext()) {
                    var3_3 = var0.nextString();
                    var2_1.zze.add(var3_3);
                }
                var0.endArray();
                continue;
lbl55:
                // 1 sources

                var2_1.zzd = var0.nextString();
                continue;
lbl57:
                // 1 sources

                var2_1.zzc = var0.nextString();
                continue;
lbl59:
                // 1 sources

                var2_1.zzb = var0.nextString();
                continue;
lbl61:
                // 1 sources

                var2_1.zza = zzbu.zzb((JsonReader)var0);
                continue;
            }
            var2_1.zzf = new ArrayList<zzbx>();
            var0.beginArray();
            while (true) {
                if (var0.hasNext()) {
                    var3_3 = new zzbx();
                    var0.beginObject();
                } else {
                    var0.endArray();
                    continue block8;
                }
                while (var0.hasNext()) {
                    block24: {
                        block23: {
                            var4_4 = var0.nextName();
                            var1_2 = var4_4.hashCode();
                            if (var1_2 == -2105551094) break block23;
                            if (var1_2 != 1583758243 || !var4_4.equals("action_type")) ** GOTO lbl-1000
                            var1_2 = 0;
                            break block24;
                        }
                        if (var4_4.equals("args_json")) {
                            var1_2 = 1;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var1_2 = -1;
                        }
                    }
                    if (var1_2 != 0) {
                        if (var1_2 != 1) {
                            var0.skipValue();
                            continue;
                        }
                        var3_3.zzb = var0.nextString();
                        continue;
                    }
                    var3_3.zza = zzbu.zza((JsonReader)var0);
                }
                var0.endObject();
                var2_1.zzf.add((zzbx)var3_3);
            }
            break;
        }
    }
}
