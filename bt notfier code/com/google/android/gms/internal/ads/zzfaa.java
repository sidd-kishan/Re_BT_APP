/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 */
package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class zzfaa {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzfaa(int n, int n2, boolean bl) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = bl;
    }

    static List<zzfaa> zza(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList<zzfaa> arrayList = new ArrayList<zzfaa>();
        jsonReader.beginArray();
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endArray();
                return arrayList;
            }
            jsonReader.beginObject();
            int n = 0;
            int n2 = 0;
            boolean bl = false;
            while (jsonReader.hasNext()) {
                String string = jsonReader.nextName();
                if ("width".equals(string)) {
                    n = jsonReader.nextInt();
                    continue;
                }
                if ("height".equals(string)) {
                    n2 = jsonReader.nextInt();
                    continue;
                }
                if ("is_fluid_height".equals(string)) {
                    bl = jsonReader.nextBoolean();
                    continue;
                }
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            arrayList.add(new zzfaa(n, n2, bl));
        }
    }
}
