/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgr
 *  com.google.android.gms.internal.ads.zzfgz
 *  com.google.android.gms.internal.ads.zzfha
 *  com.google.android.gms.internal.ads.zzfhl
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import android.view.View;
import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfgz;
import com.google.android.gms.internal.ads.zzfha;
import com.google.android.gms.internal.ads.zzfhl;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class zzfhc
implements zzfha {
    private final zzfha zza;

    public zzfhc(zzfha zzfha2) {
        this.zza = zzfha2;
    }

    public final JSONObject zza(View view) {
        throw null;
    }

    public final void zzb(View object, JSONObject jSONObject, zzfgz zzfgz2, boolean bl) {
        int n;
        int n2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = zzfgr.zza();
        if (object != null) {
            object = object.zzf();
            n2 = object.size();
            IdentityHashMap<Object, Object> identityHashMap = new IdentityHashMap<Object, Object>(n2 + n2 + 3);
            Iterator iterator = object.iterator();
            block0: while (iterator.hasNext()) {
                View view = ((zzfgg)iterator.next()).zzi();
                if (view == null || Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow() || !view.isShown()) continue;
                object = view;
                while (object != null) {
                    if (object.getAlpha() == 0.0f) continue block0;
                    if ((object = object.getParent()) instanceof View) {
                        object = (View)object;
                        continue;
                    }
                    object = null;
                }
                object = view.getRootView();
                if (object == null || identityHashMap.containsKey(object)) continue;
                identityHashMap.put(object, object);
                float f = zzfhl.zza((View)object);
                n2 = arrayList.size();
                while (n2 > 0 && zzfhl.zza((View)((View)arrayList.get(n = n2 - 1))) > f) {
                    n2 = n;
                }
                arrayList.add(n2, object);
            }
        }
        n = arrayList.size();
        n2 = 0;
        while (n2 < n) {
            zzfgz2.zza((View)arrayList.get(n2), this.zza, jSONObject);
            ++n2;
        }
    }
}
