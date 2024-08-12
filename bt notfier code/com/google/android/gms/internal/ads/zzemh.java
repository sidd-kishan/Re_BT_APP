/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzemg
 *  com.google.android.gms.internal.ads.zzemi
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzemg;
import com.google.android.gms.internal.ads.zzemi;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public final class zzemh
implements zzery<zzemi> {
    private final zzfsn zza;
    private final Context zzb;
    private final zzfar zzc;
    private final View zzd;

    public zzemh(zzfsn zzfsn2, Context context, zzfar zzfar2, ViewGroup viewGroup) {
        this.zza = zzfsn2;
        this.zzb = context;
        this.zzc = zzfar2;
        this.zzd = viewGroup;
    }

    public final zzfsm<zzemi> zza() {
        return this.zza.zzb((Callable)new zzemg(this));
    }

    final /* synthetic */ zzemi zzb() throws Exception {
        Context context = this.zzb;
        zzbdl zzbdl2 = this.zzc.zze;
        ArrayList<View> arrayList = new ArrayList<View>();
        View view = this.zzd;
        while (view != null) {
            ViewParent viewParent = view.getParent();
            if (viewParent == null) {
                return new zzemi(context, zzbdl2, arrayList);
            }
            int n = viewParent instanceof ViewGroup ? ((ViewGroup)viewParent).indexOfChild(view) : -1;
            view = new Bundle();
            view.putString("type", viewParent.getClass().getName());
            view.putInt("index_of_child", n);
            arrayList.add(view);
            if (!(viewParent instanceof View)) return new zzemi(context, zzbdl2, arrayList);
            view = (View)viewParent;
        }
        return new zzemi(context, zzbdl2, arrayList);
    }
}
