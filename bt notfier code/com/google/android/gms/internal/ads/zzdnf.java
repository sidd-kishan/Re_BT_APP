/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.widget.FrameLayout
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzawe
 *  com.google.android.gms.internal.ads.zzbmq
 *  com.google.android.gms.internal.ads.zzcht
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdog
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzawe;
import com.google.android.gms.internal.ads.zzbmq;
import com.google.android.gms.internal.ads.zzcht;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzdnf
extends zzbmq
implements ViewTreeObserver.OnGlobalLayoutListener,
ViewTreeObserver.OnScrollChangedListener,
zzdog {
    private final WeakReference<View> zza;
    private final Map<String, WeakReference<View>> zzb = new HashMap<String, WeakReference<View>>();
    private final Map<String, WeakReference<View>> zzc = new HashMap<String, WeakReference<View>>();
    private final Map<String, WeakReference<View>> zzd = new HashMap<String, WeakReference<View>>();
    private zzdmh zze;
    private zzawe zzf;

    public zzdnf(View view, HashMap<String, View> object, HashMap<String, View> object2) {
        String string;
        view.setOnTouchListener((View.OnTouchListener)this);
        view.setOnClickListener((View.OnClickListener)this);
        zzt.zzz();
        zzcht.zza((View)view, (ViewTreeObserver.OnGlobalLayoutListener)this);
        zzt.zzz();
        zzcht.zzb((View)view, (ViewTreeObserver.OnScrollChangedListener)this);
        this.zza = new WeakReference<View>(view);
        for (Map.Entry entry : object.entrySet()) {
            string = (String)entry.getKey();
            View entry2 = (View)entry.getValue();
            if (entry2 == null) continue;
            this.zzb.put(string, new WeakReference<View>(entry2));
            if ("1098".equals(string) || "3011".equals(string)) continue;
            entry2.setOnTouchListener((View.OnTouchListener)this);
            entry2.setClickable(true);
            entry2.setOnClickListener((View.OnClickListener)this);
        }
        this.zzd.putAll(this.zzb);
        object2 = object2.entrySet().iterator();
        while (true) {
            if (!object2.hasNext()) {
                this.zzd.putAll(this.zzc);
                this.zzf = new zzawe(view.getContext(), view);
                return;
            }
            object = object2.next();
            string = (View)object.getValue();
            if (string == null) continue;
            this.zzc.put((String)object.getKey(), new WeakReference<String>(string));
            string.setOnTouchListener((View.OnTouchListener)this);
            string.setClickable(false);
        }
    }

    public final void onClick(View view) {
        synchronized (this) {
            zzdmh zzdmh2 = this.zze;
            if (zzdmh2 == null) return;
            zzdmh2.zzp(view, this.zzbx(), this.zzj(), this.zzk(), true);
            return;
        }
    }

    public final void onGlobalLayout() {
        synchronized (this) {
            zzdmh zzdmh2 = this.zze;
            if (zzdmh2 == null) return;
            zzdmh2.zzr(this.zzbx(), this.zzj(), this.zzk(), zzdmh.zzC((View)this.zzbx()));
            return;
        }
    }

    public final void onScrollChanged() {
        synchronized (this) {
            zzdmh zzdmh2 = this.zze;
            if (zzdmh2 == null) return;
            zzdmh2.zzr(this.zzbx(), this.zzj(), this.zzk(), zzdmh.zzC((View)this.zzbx()));
            return;
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this) {
            zzdmh zzdmh2 = this.zze;
            if (zzdmh2 == null) return false;
            zzdmh2.zzq(view, motionEvent, this.zzbx());
            return false;
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        synchronized (this) {
            Object object = ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
            if (!(object instanceof zzdmh)) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Not an instance of InternalNativeAd. This is most likely a transient error");
                return;
            }
            iObjectWrapper = this.zze;
            if (iObjectWrapper != null) {
                iObjectWrapper.zzk((zzdog)this);
            }
            if ((iObjectWrapper = (zzdmh)object).zzD()) {
                this.zze = iObjectWrapper;
                iObjectWrapper.zzj((zzdog)this);
                this.zze.zzH(this.zzbx());
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zzf((String)"Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
            return;
        }
    }

    public final FrameLayout zzbt() {
        return null;
    }

    public final View zzbx() {
        return (View)this.zza.get();
    }

    public final void zzc() {
        synchronized (this) {
            zzdmh zzdmh2 = this.zze;
            if (zzdmh2 == null) return;
            zzdmh2.zzk((zzdog)this);
            this.zze = null;
            return;
        }
    }

    public final void zzd(IObjectWrapper object) {
        synchronized (this) {
            if (this.zze == null) return;
            if (!((object = ObjectWrapper.unwrap((IObjectWrapper)object)) instanceof View)) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zze.zzu((View)object);
            return;
        }
    }

    public final zzawe zzh() {
        return this.zzf;
    }

    public final void zzi(String string, View view, boolean bl) {
        synchronized (this) {
            Map<String, WeakReference<View>> map = this.zzd;
            WeakReference<View> weakReference = new WeakReference<View>(view);
            map.put(string, weakReference);
            if ("1098".equals(string)) return;
            if ("3011".equals(string)) {
                return;
            }
            map = this.zzb;
            weakReference = new WeakReference<View>(view);
            map.put(string, weakReference);
            view.setClickable(true);
            view.setOnClickListener((View.OnClickListener)this);
            view.setOnTouchListener((View.OnTouchListener)this);
            return;
        }
    }

    public final Map<String, WeakReference<View>> zzj() {
        synchronized (this) {
            Map<String, WeakReference<View>> map = this.zzd;
            return map;
        }
    }

    public final Map<String, WeakReference<View>> zzk() {
        synchronized (this) {
            Map<String, WeakReference<View>> map = this.zzb;
            return map;
        }
    }

    public final Map<String, WeakReference<View>> zzl() {
        synchronized (this) {
            Map<String, WeakReference<View>> map = this.zzc;
            return map;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final View zzm(String object) {
        synchronized (this) {
            object = this.zzd.get(object);
            if (object != null) return (View)((Reference)object).get();
            return null;
        }
    }

    /*
     * Converted monitor instructions to comments
     */
    public final String zzn() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return "1007";
    }

    /*
     * Converted monitor instructions to comments
     */
    public final IObjectWrapper zzo() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    /*
     * Converted monitor instructions to comments
     */
    public final JSONObject zzp() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    public final JSONObject zzq() {
        synchronized (this) {
            zzdmh zzdmh2 = this.zze;
            if (zzdmh2 == null) return null;
            zzdmh2 = zzdmh2.zzt(this.zzbx(), this.zzj(), this.zzk());
            return zzdmh2;
        }
    }
}
