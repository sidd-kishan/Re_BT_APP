/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  org.json.JSONException
 */
package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import org.json.JSONException;

public final class zzfab {
    private String zza;

    /*
     * Unable to fully structure code
     */
    zzfab(JsonReader var1_1) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        super();
        var1_1.beginObject();
        var3_2 = "";
        while (true) {
            block7: {
                block6: {
                    if (!var1_1.hasNext()) {
                        var1_1.endObject();
                        this.zza = var3_2;
                        return;
                    }
                    var4_4 = var1_1.nextName();
                    var2_3 = var4_4.hashCode();
                    if (var2_3 == -1724546052) break block6;
                    if (var2_3 != 3059181 || !var4_4.equals("code")) ** GOTO lbl-1000
                    var2_3 = 0;
                    break block7;
                }
                if (var4_4.equals("description")) {
                    var2_3 = 1;
                } else lbl-1000:
                // 2 sources

                {
                    var2_3 = -1;
                }
            }
            if (var2_3 != 0) {
                if (var2_3 != 1) {
                    var1_1.skipValue();
                    continue;
                }
                var3_2 = var1_1.nextString();
                continue;
            }
            var1_1.nextInt();
        }
    }

    public final String zza() {
        return this.zza;
    }
}
