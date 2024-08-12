/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcht
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfaa
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcht;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfaa;
import org.json.JSONObject;

public final class zzcwv
extends FrameLayout
implements ViewTreeObserver.OnScrollChangedListener,
ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcwv(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcwv zza(Context object, View view, zzezz zzezz2) {
        DisplayMetrics displayMetrics;
        Resources resources;
        object = new zzcwv((Context)object);
        if (!zzezz2.zzu.isEmpty() && (resources = ((zzcwv)((Object)object)).zza.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            resources = (zzfaa)zzezz2.zzu.get(0);
            object.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams((int)((float)resources.zza * displayMetrics.density), (int)((float)resources.zzb * displayMetrics.density)));
        }
        ((zzcwv)((Object)object)).zzb = view;
        object.addView(view);
        zzt.zzz();
        zzcht.zzb((View)object, (ViewTreeObserver.OnScrollChangedListener)object);
        zzt.zzz();
        zzcht.zza((View)object, (ViewTreeObserver.OnGlobalLayoutListener)object);
        zzezz2 = zzezz2.zzae;
        view = new RelativeLayout(((zzcwv)((Object)object)).zza);
        resources = zzezz2.optJSONObject("header");
        if (resources != null) {
            super.zzb((JSONObject)resources, (RelativeLayout)view, 10);
        }
        if ((zzezz2 = zzezz2.optJSONObject("footer")) != null) {
            super.zzb((JSONObject)zzezz2, (RelativeLayout)view, 12);
        }
        object.addView(view);
        return object;
    }

    private final void zzb(JSONObject jSONObject, RelativeLayout relativeLayout, int n) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText((CharSequence)jSONObject.optString("text", ""));
        textView.setTextSize((float)jSONObject.optDouble("text_size", 11.0));
        int n2 = this.zzc(jSONObject.optDouble("padding", 0.0));
        textView.setPadding(0, n2, 0, n2);
        jSONObject = new RelativeLayout.LayoutParams(-1, this.zzc(jSONObject.optDouble("height", 15.0)));
        jSONObject.addRule(n);
        relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)jSONObject);
    }

    private final int zzc(double d) {
        zzber.zza();
        return zzcgm.zzs((Context)this.zza, (int)((int)d));
    }

    public final void onGlobalLayout() {
        int[] nArray = new int[2];
        this.getLocationInWindow(nArray);
        this.zzb.setY((float)(-nArray[1]));
    }

    public final void onScrollChanged() {
        int[] nArray = new int[2];
        this.getLocationInWindow(nArray);
        this.zzb.setY((float)(-nArray[1]));
    }
}
