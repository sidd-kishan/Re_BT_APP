/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  com.google.android.gms.internal.ads.zzbgi
 *  com.google.android.gms.internal.ads.zzbgm
 *  com.google.android.gms.internal.ads.zzbob
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbob;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public interface zzdmu {
    public void zzA();

    public void zzd(View var1, Map<String, WeakReference<View>> var2, Map<String, WeakReference<View>> var3, View.OnTouchListener var4, View.OnClickListener var5);

    public void zze(View var1, Map<String, WeakReference<View>> var2);

    public void zzf(View var1, View var2, Map<String, WeakReference<View>> var3, Map<String, WeakReference<View>> var4, boolean var5);

    public void zzg(String var1);

    public void zzh(Bundle var1);

    public void zzi(View var1, Map<String, WeakReference<View>> var2, Map<String, WeakReference<View>> var3, boolean var4);

    public void zzj();

    public boolean zzk();

    public void zzm(View var1, MotionEvent var2, View var3);

    public void zzn(Bundle var1);

    public JSONObject zzo(View var1, Map<String, WeakReference<View>> var2, Map<String, WeakReference<View>> var3);

    public JSONObject zzp(View var1, Map<String, WeakReference<View>> var2, Map<String, WeakReference<View>> var3);

    public void zzq();

    public void zzr(View var1);

    public void zzs(zzbob var1);

    public void zzt();

    public void zzu(zzbgm var1);

    public void zzv(zzbgi var1);

    public void zzw();

    public void zzx(View var1, Map<String, WeakReference<View>> var2, Map<String, WeakReference<View>> var3);

    public void zzy();

    public boolean zzz(Bundle var1);
}
