/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbqd
 *  com.google.android.gms.internal.ads.zzbqe
 *  com.google.android.gms.internal.ads.zzbsw
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbqd;
import com.google.android.gms.internal.ads.zzbqe;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbqf
implements zzbpr<Object> {
    private final Object zza = new Object();
    private final Map<String, zzbqe> zzb = new HashMap<String, zzbqe>();

    public final void zza(Object object, Map<String, String> object2) {
        String string = object2.get("id");
        String string2 = object2.get("fail");
        object = object2.get("fail_reason");
        Object object3 = object2.get("fail_stack");
        String string3 = object2.get("result");
        object2 = object;
        if (TextUtils.isEmpty((CharSequence)object3)) {
            object2 = "Unknown Fail Reason.";
        }
        object = TextUtils.isEmpty((CharSequence)object3) ? "" : (((String)(object = String.valueOf(object3))).length() != 0 ? "\n".concat((String)object) : new String("\n"));
        object3 = this.zza;
        synchronized (object3) {
            zzbqe zzbqe2 = this.zzb.remove(string);
            if (zzbqe2 == null) {
                object = String.valueOf(string);
                object = ((String)object).length() != 0 ? "Received result for unexpected method invocation: ".concat((String)object) : new String("Received result for unexpected method invocation: ");
                zze.zzi((String)object);
                return;
            }
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                object2 = String.valueOf(object2);
                object = ((String)(object = String.valueOf(object))).length() != 0 ? ((String)object2).concat((String)object) : new String((String)object2);
                zzbqe2.zzb((String)object);
                return;
            }
            if (string3 == null) {
                zzbqe2.zza(null);
                return;
            }
            try {
                object2 = new JSONObject(string3);
                if (zze.zzc()) {
                    object = String.valueOf(object2.toString(2));
                    object = ((String)object).length() != 0 ? "Result GMSG: ".concat((String)object) : new String("Result GMSG: ");
                    zze.zza((String)object);
                }
                zzbqe2.zza((JSONObject)object2);
            }
            catch (JSONException jSONException) {
                zzbqe2.zzb(jSONException.getMessage());
            }
            return;
        }
    }

    public final void zzb(String string, zzbqe zzbqe2) {
        Object object = this.zza;
        synchronized (object) {
            this.zzb.put(string, zzbqe2);
            return;
        }
    }

    public final <EngineT extends zzbsw> zzfsm<JSONObject> zzc(EngineT EngineT, String string, JSONObject jSONObject) {
        zzchl zzchl2 = new zzchl();
        zzt.zzc();
        String string2 = UUID.randomUUID().toString();
        this.zzb(string2, (zzbqe)new zzbqd(this, zzchl2));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", (Object)string2);
            jSONObject2.put("args", (Object)jSONObject);
            EngineT.zzr(string, jSONObject2);
        }
        catch (Exception exception) {
            zzchl2.zzd((Throwable)exception);
        }
        return zzchl2;
    }
}
