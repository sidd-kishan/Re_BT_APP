/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface
 *  com.google.android.gms.ads.query.QueryInfo
 *  com.google.android.gms.ads.query.QueryInfoGenerationCallback
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;
import org.json.JSONObject;

final class zzai
extends QueryInfoGenerationCallback {
    final String zza;
    final TaggingLibraryJsInterface zzb;

    zzai(TaggingLibraryJsInterface taggingLibraryJsInterface, String string) {
        this.zzb = taggingLibraryJsInterface;
        this.zza = string;
    }

    public final void onFailure(String string) {
        String string2 = String.valueOf(string);
        string2 = string2.length() != 0 ? "Failed to generate query info for the tagging library, error: ".concat(string2) : new String("Failed to generate query info for the tagging library, error: ");
        zze.zzi((String)string2);
        string = String.format("window.postMessage({'paw_id': '%1$s', 'error': '%2$s'}, '*');", this.zza, string);
        TaggingLibraryJsInterface.zza((TaggingLibraryJsInterface)this.zzb).evaluateJavascript(string, null);
    }

    public final void onSuccess(QueryInfo object) {
        String string = object.getQuery();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", (Object)this.zza);
            jSONObject.put("signal", (Object)string);
            string = String.format("window.postMessage(%1$s, '*');", jSONObject);
            object = string;
        }
        catch (JSONException jSONException) {
            object = String.format("window.postMessage({'paw_id': '%1$s', 'signal': '%2$s'}, '*');", this.zza, object.getQuery());
        }
        TaggingLibraryJsInterface.zza((TaggingLibraryJsInterface)this.zzb).evaluateJavascript((String)object, null);
    }
}
