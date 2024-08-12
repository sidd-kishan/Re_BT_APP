/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.JsonReader
 *  android.util.JsonToken
 *  android.util.JsonWriter
 *  com.google.android.gms.ads.internal.util.zzbv
 *  com.google.android.gms.ads.internal.util.zzbw
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzfae
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.internal.util;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzfae;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbx {
    public static final zzbw<Map<String, ?>> zza = new zzbv();

    public static List<String> zza(JSONArray jSONArray, List<String> list) throws JSONException {
        List<String> list2 = list;
        if (list == null) {
            list2 = new ArrayList<String>();
        }
        if (jSONArray == null) return list2;
        int n = 0;
        while (n < jSONArray.length()) {
            list2.add(jSONArray.getString(n));
            ++n;
        }
        return list2;
    }

    public static List<String> zzb(JsonReader jsonReader) throws IllegalStateException, IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        jsonReader.beginArray();
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endArray();
                return arrayList;
            }
            arrayList.add(jsonReader.nextString());
        }
    }

    public static JSONObject zzc(JsonReader object) throws IllegalStateException, IOException, JSONException {
        JSONObject jSONObject = new JSONObject();
        object.beginObject();
        while (true) {
            if (!object.hasNext()) {
                object.endObject();
                return jSONObject;
            }
            String string = object.nextName();
            JsonToken jsonToken = object.peek();
            if (JsonToken.BEGIN_ARRAY.equals((Object)jsonToken)) {
                jSONObject.put(string, (Object)zzbx.zzd(object));
                continue;
            }
            if (JsonToken.BEGIN_OBJECT.equals((Object)jsonToken)) {
                jSONObject.put(string, (Object)zzbx.zzc(object));
                continue;
            }
            if (JsonToken.BOOLEAN.equals((Object)jsonToken)) {
                jSONObject.put(string, object.nextBoolean());
                continue;
            }
            if (JsonToken.NUMBER.equals((Object)jsonToken)) {
                jSONObject.put(string, object.nextDouble());
                continue;
            }
            if (!JsonToken.STRING.equals((Object)jsonToken)) {
                object = String.valueOf(jsonToken);
                String.valueOf(object).length();
                throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(object)));
            }
            jSONObject.put(string, (Object)object.nextString());
        }
    }

    public static JSONArray zzd(JsonReader object) throws IllegalStateException, IOException, JSONException {
        JSONArray jSONArray = new JSONArray();
        object.beginArray();
        while (true) {
            if (!object.hasNext()) {
                object.endArray();
                return jSONArray;
            }
            JsonToken jsonToken = object.peek();
            if (JsonToken.BEGIN_ARRAY.equals((Object)jsonToken)) {
                jSONArray.put((Object)zzbx.zzd(object));
                continue;
            }
            if (JsonToken.BEGIN_OBJECT.equals((Object)jsonToken)) {
                jSONArray.put((Object)zzbx.zzc(object));
                continue;
            }
            if (JsonToken.BOOLEAN.equals((Object)jsonToken)) {
                jSONArray.put(object.nextBoolean());
                continue;
            }
            if (JsonToken.NUMBER.equals((Object)jsonToken)) {
                jSONArray.put(object.nextDouble());
                continue;
            }
            if (!JsonToken.STRING.equals((Object)jsonToken)) {
                object = String.valueOf(jsonToken);
                String.valueOf(object).length();
                throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(object)));
            }
            jSONArray.put((Object)object.nextString());
        }
    }

    public static void zze(JsonWriter object, JSONObject object2) throws IOException {
        try {
            object.beginObject();
            Iterator iterator = object2.keys();
            while (true) {
                if (!iterator.hasNext()) {
                    object.endObject();
                    return;
                }
                String string = (String)iterator.next();
                Object object3 = object2.get(string);
                if (object3 instanceof String) {
                    object.name(string).value((String)object3);
                    continue;
                }
                if (object3 instanceof Number) {
                    object.name(string).value((Number)object3);
                    continue;
                }
                if (object3 instanceof Boolean) {
                    object.name(string).value(((Boolean)object3).booleanValue());
                    continue;
                }
                if (object3 instanceof JSONObject) {
                    zzbx.zze(object.name(string), (JSONObject)object3);
                    continue;
                }
                if (!(object3 instanceof JSONArray)) {
                    object2 = String.valueOf(object3);
                    int n = String.valueOf(object2).length();
                    object3 = new StringBuilder(n + 23);
                    ((StringBuilder)object3).append("unable to write field: ");
                    ((StringBuilder)object3).append((String)object2);
                    object = new JSONException(((StringBuilder)object3).toString());
                    throw object;
                }
                zzbx.zzf(object.name(string), (JSONArray)object3);
            }
        }
        catch (JSONException jSONException) {
            IOException iOException = new IOException(jSONException);
            throw iOException;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static void zzf(JsonWriter object, JSONArray object2) throws IOException {
        try {
            void var1_4;
            object.beginArray();
            for (int i = 0; i < var1_4.length(); ++i) {
                Object object3 = var1_4.get(i);
                if (object3 instanceof String) {
                    object.value((String)object3);
                    continue;
                }
                if (object3 instanceof Number) {
                    object.value((Number)object3);
                    continue;
                }
                if (object3 instanceof Boolean) {
                    object.value(((Boolean)object3).booleanValue());
                    continue;
                }
                if (object3 instanceof JSONObject) {
                    zzbx.zze(object, (JSONObject)object3);
                    continue;
                }
                if (object3 instanceof JSONArray) {
                    zzbx.zzf(object, (JSONArray)object3);
                    continue;
                }
                String string = String.valueOf(object3);
                i = String.valueOf(string).length();
                object3 = new StringBuilder(i + 23);
                ((StringBuilder)object3).append("unable to write field: ");
                ((StringBuilder)object3).append(string);
                JSONException jSONException = new JSONException(((StringBuilder)object3).toString());
                throw jSONException;
            }
            object.endArray();
            return;
        }
        catch (JSONException jSONException) {
            IOException iOException = new IOException(jSONException);
            throw iOException;
        }
    }

    public static JSONObject zzg(JSONObject jSONObject, String string) throws JSONException {
        try {
            JSONObject jSONObject2;
            jSONObject = jSONObject2 = jSONObject.getJSONObject(string);
        }
        catch (JSONException jSONException) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put(string, (Object)jSONObject3);
            jSONObject = jSONObject3;
        }
        return jSONObject;
    }

    public static JSONObject zzh(JSONObject jSONObject, String ... stringArray) {
        if ((jSONObject = zzbx.zzn(jSONObject, stringArray)) != null) return jSONObject.optJSONObject(stringArray[1]);
        return null;
    }

    public static boolean zzi(boolean bl, JSONObject jSONObject, String ... stringArray) {
        if ((jSONObject = zzbx.zzn(jSONObject, stringArray)) != null) return jSONObject.optBoolean(stringArray[stringArray.length - 1], false);
        return false;
    }

    public static String zzj(String string, JSONObject jSONObject, String ... stringArray) {
        string = zzbx.zzn(jSONObject, stringArray);
        if (string != null) return string.optString(stringArray[0], "");
        return "";
    }

    public static Bundle zzk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator iterator = jSONObject.keys();
        Bundle bundle = new Bundle();
        while (iterator.hasNext()) {
            String[] stringArray;
            int n;
            int n2;
            JSONArray jSONArray;
            Object object;
            String string;
            block22: {
                Bundle[] bundleArray;
                string = (String)iterator.next();
                object = jSONObject.opt(string);
                if (object == null) continue;
                if (object instanceof Boolean) {
                    bundle.putBoolean(string, ((Boolean)object).booleanValue());
                    continue;
                }
                if (object instanceof Double) {
                    bundle.putDouble(string, ((Double)object).doubleValue());
                    continue;
                }
                if (object instanceof Integer) {
                    bundle.putInt(string, ((Integer)object).intValue());
                    continue;
                }
                if (object instanceof Long) {
                    bundle.putLong(string, ((Long)object).longValue());
                    continue;
                }
                if (object instanceof String) {
                    bundle.putString(string, (String)object);
                    continue;
                }
                if (object instanceof JSONArray) {
                    jSONArray = (JSONArray)object;
                    if (jSONArray.length() == 0) continue;
                    n2 = jSONArray.length();
                    int n3 = 0;
                    int n4 = 0;
                    int n5 = 0;
                    int n6 = 0;
                    object = null;
                } else {
                    if (object instanceof JSONObject) {
                        bundle.putBundle(string, zzbx.zzk((JSONObject)object));
                        continue;
                    }
                    object = String.valueOf(string);
                    object = ((String)object).length() != 0 ? "Unsupported type for key:".concat((String)object) : new String("Unsupported type for key:");
                    zze.zzi((String)object);
                    continue;
                }
                for (n = 0; object == null && n < n2; ++n) {
                    object = !jSONArray.isNull(n) ? jSONArray.opt(n) : null;
                }
                if (object == null) {
                    object = String.valueOf(string);
                    object = ((String)object).length() != 0 ? "Expected JSONArray with at least 1 non-null element for key:".concat((String)object) : new String("Expected JSONArray with at least 1 non-null element for key:");
                    zze.zzi((String)object);
                    continue;
                }
                if (object instanceof JSONObject) {
                    bundleArray = new Bundle[n2];
                } else {
                    if (object instanceof Number) {
                        object = new double[jSONArray.length()];
                        for (n = n3; n < n2; ++n) {
                            object[n] = jSONArray.optDouble(n);
                        }
                        bundle.putDoubleArray(string, (double[])object);
                        continue;
                    }
                    if (object instanceof CharSequence) {
                        stringArray = new String[n2];
                        break block22;
                    } else {
                        if (object instanceof Boolean) {
                            object = new boolean[n2];
                            for (n = n5; n < n2; ++n) {
                                object[n] = jSONArray.optBoolean(n);
                            }
                            bundle.putBooleanArray(string, (boolean[])object);
                            continue;
                        }
                        zze.zzi((String)String.format("JSONArray with unsupported type %s for key:%s", object.getClass().getCanonicalName(), string));
                        continue;
                    }
                }
                for (n = n6; n < n2; ++n) {
                    object = !jSONArray.isNull(n) ? zzbx.zzk(jSONArray.optJSONObject(n)) : null;
                    bundleArray[n] = object;
                }
                bundle.putParcelableArray(string, (Parcelable[])bundleArray);
                continue;
            }
            for (n = n4; n < n2; ++n) {
                object = !jSONArray.isNull(n) ? jSONArray.optString(n) : null;
                stringArray[n] = object;
            }
            bundle.putStringArray(string, stringArray);
        }
        return bundle;
    }

    public static String zzl(zzfae object) {
        Object var1_2 = null;
        if (object == null) {
            object = var1_2;
        } else {
            StringWriter stringWriter = new StringWriter();
            try {
                JsonWriter jsonWriter = new JsonWriter((Writer)stringWriter);
                zzbx.zzm(jsonWriter, object);
                jsonWriter.close();
                object = stringWriter.toString();
            }
            catch (IOException iOException) {
                zze.zzg((String)"Error when writing JSON.", (Throwable)iOException);
                object = var1_2;
            }
        }
        return object;
    }

    private static void zzm(JsonWriter jsonWriter, Object iterator) throws IOException {
        if (iterator == null) {
            jsonWriter.nullValue();
            return;
        }
        if (iterator instanceof Number) {
            jsonWriter.value((Number)((Object)iterator));
            return;
        }
        if (iterator instanceof Boolean) {
            jsonWriter.value(((Boolean)((Object)iterator)).booleanValue());
            return;
        }
        if (iterator instanceof String) {
            jsonWriter.value((String)((Object)iterator));
            return;
        }
        if (iterator instanceof zzfae) {
            zzbx.zze(jsonWriter, ((zzfae)iterator).zzd);
            return;
        }
        if (iterator instanceof Map) {
            jsonWriter.beginObject();
            Iterator iterator2 = ((Map)((Object)iterator)).entrySet().iterator();
            while (true) {
                if (!iterator2.hasNext()) {
                    jsonWriter.endObject();
                    return;
                }
                Map.Entry entry = iterator2.next();
                iterator = entry.getKey();
                if (!(iterator instanceof String)) continue;
                entry = entry.getValue();
                zzbx.zzm(jsonWriter.name((String)((Object)iterator)), entry);
            }
        }
        if (!(iterator instanceof List)) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        iterator = ((List)((Object)iterator)).iterator();
        while (true) {
            if (!iterator.hasNext()) {
                jsonWriter.endArray();
                return;
            }
            zzbx.zzm(jsonWriter, iterator.next());
        }
    }

    private static JSONObject zzn(JSONObject jSONObject, String[] stringArray) {
        int n = 0;
        while (n < stringArray.length - 1) {
            if (jSONObject == null) {
                return null;
            }
            jSONObject = jSONObject.optJSONObject(stringArray[n]);
            ++n;
        }
        return jSONObject;
    }
}
