/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbvc {
    public static final List<String> zza(JSONObject jSONObject, String object) throws JSONException {
        if ((jSONObject = jSONObject.optJSONArray((String)object)) == null) return null;
        object = new ArrayList(jSONObject.length());
        int n = 0;
        while (n < jSONObject.length()) {
            object.add(jSONObject.getString(n));
            ++n;
        }
        return Collections.unmodifiableList(object);
    }
}
