/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.NetworkExtras
 */
package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras
implements NetworkExtras {
    private final HashMap<String, Object> zza = new HashMap();

    public Object getExtra(String string) {
        return this.zza.get(string);
    }

    public void setExtra(String string, Object object) {
        this.zza.put(string, object);
    }
}
