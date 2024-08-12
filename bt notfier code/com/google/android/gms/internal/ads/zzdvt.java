/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzbla
 */
package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbla;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public final class zzdvt {
    private final Clock zza;

    public zzdvt(Clock clock) {
        this.zza = clock;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zza(List<Object> object, String string, String string2, Object ... objectArray) {
        StringWriter stringWriter;
        block7: {
            int n;
            if (!((Boolean)zzbla.zza.zze()).booleanValue()) {
                return;
            }
            long l = this.zza.currentTimeMillis();
            stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter((Writer)stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(l);
                jsonWriter.name("source").value(string);
                jsonWriter.name("event").value(string2);
                jsonWriter.name("components").beginArray();
                object = object.iterator();
                while (object.hasNext()) {
                    jsonWriter.value(object.next().toString());
                }
                jsonWriter.endArray();
                jsonWriter.name("params").beginArray();
                n = objectArray.length;
            }
            catch (IOException iOException) {
                zze.zzg((String)"unable to log", (Throwable)iOException);
                break block7;
            }
            for (int i = 0; i < n; ++i) {
                object = objectArray[i];
                object = object != null ? object.toString() : null;
                {
                    jsonWriter.value((String)object);
                    continue;
                }
            }
            {
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            }
        }
        object = String.valueOf(stringWriter.toString());
        object = ((String)object).length() != 0 ? "AD-DBG ".concat((String)object) : new String("AD-DBG ");
        zze.zzh((String)object);
    }
}
