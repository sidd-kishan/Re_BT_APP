/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  android.util.JsonToken
 *  com.google.android.gms.ads.internal.util.zzbx
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzfab
 *  org.json.JSONException
 */
package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzfab;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

public final class zzfac {
    public final List<String> zza;
    public final String zzb;
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final long zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzfab zzi;

    zzfac(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String string;
        List list = Collections.emptyList();
        jsonReader.beginObject();
        int n = 0;
        String string2 = "";
        long l = 0L;
        zzfab zzfab2 = null;
        boolean bl = false;
        String string3 = string = "";
        int n2 = 0;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                this.zza = list;
                this.zzc = n;
                this.zzb = string;
                this.zzd = string3;
                this.zze = n2;
                this.zzf = l;
                this.zzi = zzfab2;
                this.zzg = bl;
                this.zzh = string2;
                return;
            }
            String string4 = jsonReader.nextName();
            if ("nofill_urls".equals(string4)) {
                list = zzbx.zzb((JsonReader)jsonReader);
                continue;
            }
            if ("refresh_interval".equals(string4)) {
                n = jsonReader.nextInt();
                continue;
            }
            if ("gws_query_id".equals(string4)) {
                string = jsonReader.nextString();
                continue;
            }
            if ("analytics_query_ad_event_id".equals(string4)) {
                string3 = jsonReader.nextString();
                continue;
            }
            if ("is_idless".equals(string4)) {
                bl = jsonReader.nextBoolean();
                continue;
            }
            if ("response_code".equals(string4)) {
                n2 = jsonReader.nextInt();
                continue;
            }
            if ("latency".equals(string4)) {
                l = jsonReader.nextLong();
                continue;
            }
            zzbjd zzbjd2 = zzbjl.zzfV;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && "public_error".equals(string4) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                zzfab2 = new zzfab(jsonReader);
                continue;
            }
            if ("bidding_data".equals(string4)) {
                string2 = jsonReader.nextString();
                continue;
            }
            jsonReader.skipValue();
        }
    }
}
