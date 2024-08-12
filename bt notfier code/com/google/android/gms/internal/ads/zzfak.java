/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  com.google.android.gms.ads.internal.util.zzbx
 *  com.google.android.gms.common.util.IOUtils
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfad
 *  com.google.android.gms.internal.ads.zzfaj
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfad;
import com.google.android.gms.internal.ads.zzfaj;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfak {
    public final List<zzezz> zza;
    public final zzfac zzb;
    public final List<zzfaj> zzc;

    zzfak(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List list = Collections.emptyList();
        ArrayList<zzfaj> arrayList = new ArrayList<zzfaj>();
        jsonReader.beginObject();
        zzfac zzfac2 = null;
        block0: while (true) {
            String string;
            block16: {
                block15: {
                    block13: {
                        block14: {
                            if (!jsonReader.hasNext()) break block13;
                            string = jsonReader.nextName();
                            if (!"responses".equals(string)) break block14;
                            jsonReader.beginArray();
                            jsonReader.beginObject();
                            break block15;
                        }
                        if (!string.equals("actions")) continue;
                        break block16;
                    }
                    this.zzc = arrayList;
                    this.zza = list;
                    if (zzfac2 == null) {
                        zzfac2 = new zzfac(new JsonReader((Reader)new StringReader("{}")));
                    }
                    this.zzb = zzfac2;
                    return;
                }
                while (jsonReader.hasNext()) {
                    string = jsonReader.nextName();
                    if ("ad_configs".equals(string)) {
                        list = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            list.add(new zzezz(jsonReader));
                        }
                        jsonReader.endArray();
                        continue;
                    }
                    if (string.equals("common")) {
                        zzfac2 = new zzfac(jsonReader);
                        continue;
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                jsonReader.endArray();
                continue;
            }
            jsonReader.beginArray();
            while (true) {
                String string2;
                if (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    string2 = null;
                    string = null;
                } else {
                    jsonReader.endArray();
                    continue block0;
                }
                while (jsonReader.hasNext()) {
                    String string3 = jsonReader.nextName();
                    if ("name".equals(string3)) {
                        string2 = jsonReader.nextString();
                        continue;
                    }
                    if ("info".equals(string3)) {
                        string = zzbx.zzc((JsonReader)jsonReader);
                        continue;
                    }
                    jsonReader.skipValue();
                }
                if (string2 != null) {
                    arrayList.add(new zzfaj(string2, (JSONObject)string));
                }
                jsonReader.endObject();
            }
            break;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static zzfak zza(Reader reader) throws zzfad {
        Throwable throwable2;
        block8: {
            Object object;
            try {
                object = new JsonReader(reader);
                object = new zzfak((JsonReader)object);
            }
            catch (Throwable throwable2) {
                break block8;
            }
            catch (AssertionError assertionError) {
            }
            catch (NumberFormatException numberFormatException) {
            }
            catch (JSONException jSONException) {
            }
            catch (IllegalStateException illegalStateException) {
            }
            catch (IOException iOException) {
                // empty catch block
            }
            IOUtils.closeQuietly((Closeable)reader);
            return object;
            {
                void var1_8;
                zzfad zzfad2 = new zzfad("unable to parse ServerResponse", (Throwable)var1_8);
                throw zzfad2;
            }
        }
        IOUtils.closeQuietly((Closeable)reader);
        throw throwable2;
    }
}
