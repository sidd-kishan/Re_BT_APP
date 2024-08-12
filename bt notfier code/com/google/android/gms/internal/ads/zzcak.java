/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public final class zzcak {
    @Nonnull
    private View zza;
    private final Map<String, WeakReference<View>> zzb = new HashMap<String, WeakReference<View>>();

    static /* synthetic */ View zza(zzcak zzcak2) {
        return zzcak2.zza;
    }

    static /* synthetic */ Map zzb(zzcak zzcak2) {
        return zzcak2.zzb;
    }

    public final zzcak zzc(View view) {
        this.zza = view;
        return this;
    }

    public final zzcak zzd(Map<String, View> object) {
        this.zzb.clear();
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            View view = (View)entry.getValue();
            if (view == null) continue;
            this.zzb.put((String)entry.getKey(), new WeakReference<View>(view));
        }
        return this;
    }
}
