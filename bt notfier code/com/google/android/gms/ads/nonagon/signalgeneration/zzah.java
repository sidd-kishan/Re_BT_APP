/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.JsonReader
 *  org.json.JSONException
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public final class zzah {
    public final String zza;
    public String zzb;
    public Bundle zzc = new Bundle();

    /*
     * Unable to fully structure code
     */
    public zzah(JsonReader var1_1) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        super();
        var4_2 = new HashMap<String, String>();
        var1_1.beginObject();
        var3_3 = "";
        while (var1_1.hasNext()) {
            block9: {
                block8: {
                    var5_5 = var6_6 = var1_1.nextName();
                    if (var6_6 == null) {
                        var5_5 = "";
                    }
                    if ((var2_4 = var5_5.hashCode()) == -995427962) break block8;
                    if (var2_4 != -271442291 || !var5_5.equals("signal_dictionary")) ** GOTO lbl-1000
                    var2_4 = 1;
                    break block9;
                }
                if (var5_5.equals("params")) {
                    var2_4 = 0;
                } else lbl-1000:
                // 2 sources

                {
                    var2_4 = -1;
                }
            }
            if (var2_4 != 0) {
                if (var2_4 != 1) {
                    var1_1.skipValue();
                    continue;
                }
                var4_2 = new HashMap<K, V>();
                var1_1.beginObject();
                while (var1_1.hasNext()) {
                    var4_2.put(var1_1.nextName(), var1_1.nextString());
                }
                var1_1.endObject();
                continue;
            }
            var3_3 = var1_1.nextString();
        }
        this.zza = var3_3;
        var1_1.endObject();
        var1_1 = var4_2.entrySet().iterator();
        while (var1_1.hasNext() != false) {
            var3_3 = (Map.Entry)var1_1.next();
            if (var3_3.getKey() == null || var3_3.getValue() == null) continue;
            this.zzc.putString((String)var3_3.getKey(), (String)var3_3.getValue());
        }
    }
}
