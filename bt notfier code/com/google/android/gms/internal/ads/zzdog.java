/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.widget.FrameLayout
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzawe
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzawe;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public interface zzdog
extends View.OnClickListener,
View.OnTouchListener {
    public FrameLayout zzbt();

    public View zzbx();

    public zzawe zzh();

    public void zzi(String var1, View var2, boolean var3);

    public Map<String, WeakReference<View>> zzj();

    public Map<String, WeakReference<View>> zzk();

    public Map<String, WeakReference<View>> zzl();

    public View zzm(String var1);

    public String zzn();

    public IObjectWrapper zzo();

    public JSONObject zzp();

    public JSONObject zzq();
}
