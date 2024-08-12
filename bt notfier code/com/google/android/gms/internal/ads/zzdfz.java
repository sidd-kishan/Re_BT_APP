/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamv
 *  com.google.android.gms.internal.ads.zzbot
 *  com.google.android.gms.internal.ads.zzdfy
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamv;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzdfy;
import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import java.util.Set;

public final class zzdfz
extends zzdgm<zzamv>
implements zzbot {
    public zzdfz(Set<zzdih<zzamv>> set) {
        super(set);
    }

    public final void zzbA(String string, String string2) {
        synchronized (this) {
            zzdfy zzdfy2 = new zzdfy(string, string2);
            this.zzk((zzdgl)zzdfy2);
            return;
        }
    }
}
