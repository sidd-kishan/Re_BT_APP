/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzcsc
 *  com.google.android.gms.internal.ads.zzezy
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcsc;
import com.google.android.gms.internal.ads.zzezy;
import java.util.Map;

public final class zzcso
implements zzcsc {
    private final zzezy zza;

    public zzcso(zzezy zzezy2) {
        this.zza = zzezy2;
    }

    public final void zza(Map<String, String> object) {
        if (TextUtils.isEmpty((CharSequence)(object = object.get("render_in_browser")))) return;
        try {
            this.zza.zza(Boolean.parseBoolean((String)object));
            return;
        }
        catch (Exception exception) {
            throw new IllegalStateException("Invalid render_in_browser state");
        }
    }
}
