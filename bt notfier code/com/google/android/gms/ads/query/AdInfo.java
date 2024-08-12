/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.query.QueryInfo
 *  com.google.android.gms.internal.ads.zzcgt
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.query;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.internal.ads.zzcgt;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class AdInfo {
    private final QueryInfo zza;
    private final String zzb;

    public AdInfo(QueryInfo queryInfo, String string) {
        this.zza = queryInfo;
        this.zzb = string;
    }

    public static String getRequestId(String string) {
        if (string == null) {
            zzcgt.zzi((String)"adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.");
            return "";
        }
        try {
            string = new JSONObject(string);
        }
        catch (JSONException jSONException) {
            zzcgt.zzi((String)"Invalid adString passed to AdInfo.getRequestId(). Returning empty string.");
            return "";
        }
        return string.optString("request_id", "");
    }

    public String getAdString() {
        return this.zzb;
    }

    public QueryInfo getQueryInfo() {
        return this.zza;
    }
}
