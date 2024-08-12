/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.google.android.gms.ads.internal.util.zzca
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzawe
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbmk
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcht
 *  com.google.android.gms.internal.ads.zzdmh
 *  com.google.android.gms.internal.ads.zzdng
 *  com.google.android.gms.internal.ads.zzdog
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfsn
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzawe;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcht;
import com.google.android.gms.internal.ads.zzdmh;
import com.google.android.gms.internal.ads.zzdng;
import com.google.android.gms.internal.ads.zzdog;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfsn;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class zzdnh
extends zzbmk
implements ViewTreeObserver.OnGlobalLayoutListener,
ViewTreeObserver.OnScrollChangedListener,
zzdog {
    public static final zzfoj<String> zza = zzfoj.zzl((Object)"2011", (Object)"1009", (Object)"3010");
    private final String zzb;
    private Map<String, WeakReference<View>> zzc = new HashMap<String, WeakReference<View>>();
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzfsn zzf;
    private View zzg;
    private final int zzh;
    private zzdmh zzi;
    private zzawe zzj;
    private IObjectWrapper zzk = null;
    private zzbme zzl;
    private boolean zzm;
    private boolean zzn = false;

    public zzdnh(FrameLayout frameLayout, FrameLayout object, int n) {
        this.zzd = frameLayout;
        this.zze = object;
        this.zzh = 213806000;
        String string = frameLayout.getClass().getCanonicalName();
        boolean bl = "com.google.android.gms.ads.formats.NativeContentAdView".equals(string);
        object = "3012";
        if (bl) {
            object = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(string)) {
            object = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(string);
        }
        this.zzb = object;
        zzt.zzz();
        zzcht.zza((View)frameLayout, (ViewTreeObserver.OnGlobalLayoutListener)this);
        zzt.zzz();
        zzcht.zzb((View)frameLayout, (ViewTreeObserver.OnScrollChangedListener)this);
        this.zzf = zzchg.zze;
        this.zzj = new zzawe(this.zzd.getContext(), (View)this.zzd);
        frameLayout.setOnTouchListener((View.OnTouchListener)this);
        frameLayout.setOnClickListener((View.OnClickListener)this);
    }

    private final void zzs() {
        synchronized (this) {
            zzfsn zzfsn2 = this.zzf;
            zzdng zzdng2 = new zzdng(this);
            zzfsn2.execute((Runnable)zzdng2);
            return;
        }
    }

    private final void zzt(String object) {
        synchronized (this) {
            FrameLayout frameLayout;
            block8: {
                frameLayout = new FrameLayout(this.zze.getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                Context context = this.zze.getContext();
                frameLayout.setClickable(false);
                frameLayout.setFocusable(false);
                if (!TextUtils.isEmpty((CharSequence)object)) {
                    layoutParams = context;
                    if (context.getApplicationContext() != null) {
                        layoutParams = context.getApplicationContext();
                    }
                    if ((layoutParams = layoutParams.getResources()) != null && (layoutParams = layoutParams.getDisplayMetrics()) != null) {
                        try {
                            object = Base64.decode((String)object, (int)0);
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            zzcgt.zzj((String)"Encountered invalid base64 watermark.", (Throwable)illegalArgumentException);
                            break block8;
                        }
                        object = BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)((Object)object).length);
                        context = new BitmapDrawable((Bitmap)object);
                        context.setTargetDensity(layoutParams.densityDpi);
                        context.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        frameLayout.setBackground((Drawable)context);
                    }
                }
            }
            this.zze.addView((View)frameLayout);
            return;
        }
    }

    public final void onClick(View view) {
        synchronized (this) {
            zzdmh zzdmh2 = this.zzi;
            if (zzdmh2 == null) return;
            zzdmh2.zzw();
            this.zzi.zzp(view, (View)this.zzd, this.zzj(), this.zzk(), false);
            return;
        }
    }

    public final void onGlobalLayout() {
        synchronized (this) {
            zzdmh zzdmh2 = this.zzi;
            if (zzdmh2 == null) return;
            zzdmh2.zzr((View)this.zzd, this.zzj(), this.zzk(), zzdmh.zzC((View)this.zzd));
            return;
        }
    }

    public final void onScrollChanged() {
        synchronized (this) {
            zzdmh zzdmh2 = this.zzi;
            if (zzdmh2 == null) return;
            zzdmh2.zzr((View)this.zzd, this.zzj(), this.zzk(), zzdmh.zzC((View)this.zzd));
            return;
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this) {
            zzdmh zzdmh2 = this.zzi;
            if (zzdmh2 == null) return false;
            zzdmh2.zzq(view, motionEvent, (View)this.zzd);
            return false;
        }
    }

    public final void zzb(String string, IObjectWrapper iObjectWrapper) {
        synchronized (this) {
            this.zzi(string, (View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), true);
            return;
        }
    }

    public final FrameLayout zzbt() {
        return this.zze;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzbu(IObjectWrapper iObjectWrapper) {
        synchronized (this) {
            boolean bl = this.zzn;
            if (bl) {
                return;
            }
            this.zzk = iObjectWrapper;
            return;
        }
    }

    public final void zzbv(IObjectWrapper iObjectWrapper) {
        iObjectWrapper = (MotionEvent)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        this.onTouch((View)this.zzd, (MotionEvent)iObjectWrapper);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzbw(zzbme zzbme2) {
        synchronized (this) {
            boolean bl = this.zzn;
            if (bl) {
                return;
            }
            this.zzm = true;
            this.zzl = zzbme2;
            zzdmh zzdmh2 = this.zzi;
            if (zzdmh2 == null) return;
            zzdmh2.zzJ().zzb(zzbme2);
            return;
        }
    }

    public final IObjectWrapper zzc(String string) {
        synchronized (this) {
            string = ObjectWrapper.wrap((Object)this.zzm(string));
            return string;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzd(IObjectWrapper object) {
        synchronized (this) {
            zzdmh zzdmh2;
            boolean bl = this.zzn;
            if (bl) {
                return;
            }
            Object object2 = ObjectWrapper.unwrap((IObjectWrapper)object);
            if (!(object2 instanceof zzdmh)) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzdmh zzdmh3 = this.zzi;
            if (zzdmh3 != null) {
                zzdmh3.zzk((zzdog)this);
            }
            this.zzs();
            this.zzi = zzdmh2 = (zzdmh)object2;
            zzdmh2.zzj((zzdog)this);
            this.zzi.zzH((View)this.zzd);
            this.zzi.zzI((View)this.zze);
            if (this.zzm) {
                this.zzi.zzJ().zzb(this.zzl);
            }
            zzbjd zzbjd2 = zzbjl.zzcr;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            if (TextUtils.isEmpty((CharSequence)this.zzi.zzE())) return;
            this.zzt(this.zzi.zzE());
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zze() {
        synchronized (this) {
            boolean bl = this.zzn;
            if (bl) {
                return;
            }
            zzdmh zzdmh2 = this.zzi;
            if (zzdmh2 != null) {
                zzdmh2.zzk((zzdog)this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
            return;
        }
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzf(IObjectWrapper iObjectWrapper, int n) {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        synchronized (this) {
            this.zzi.zzu((View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
            return;
        }
    }

    public final zzawe zzh() {
        return this.zzj;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzi(String string, View view, boolean bl) {
        synchronized (this) {
            void var2_2;
            boolean bl2 = this.zzn;
            if (bl2) {
                return;
            }
            if (var2_2 == null) {
                this.zzc.remove(string);
                return;
            }
            Map<String, WeakReference<View>> map = this.zzc;
            WeakReference<void> weakReference = new WeakReference<void>(var2_2);
            map.put(string, weakReference);
            if ("1098".equals(string)) return;
            if ("3011".equals(string)) {
                return;
            }
            if (zzca.zza((int)this.zzh)) {
                var2_2.setOnTouchListener((View.OnTouchListener)this);
            }
            var2_2.setClickable(true);
            var2_2.setOnClickListener((View.OnClickListener)this);
            return;
        }
    }

    public final Map<String, WeakReference<View>> zzj() {
        synchronized (this) {
            Map<String, WeakReference<View>> map = this.zzc;
            return map;
        }
    }

    public final Map<String, WeakReference<View>> zzk() {
        synchronized (this) {
            Map<String, WeakReference<View>> map = this.zzc;
            return map;
        }
    }

    /*
     * Converted monitor instructions to comments
     */
    public final Map<String, WeakReference<View>> zzl() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final View zzm(String object) {
        synchronized (this) {
            boolean bl = this.zzn;
            if (bl) {
                return null;
            }
            if ((object = this.zzc.get(object)) != null) return (View)((Reference)object).get();
            return null;
        }
    }

    public final String zzn() {
        synchronized (this) {
            String string = this.zzb;
            return string;
        }
    }

    public final IObjectWrapper zzo() {
        return this.zzk;
    }

    public final JSONObject zzp() {
        synchronized (this) {
            zzdmh zzdmh2 = this.zzi;
            if (zzdmh2 == null) return null;
            zzdmh2 = zzdmh2.zzs((View)this.zzd, this.zzj(), this.zzk());
            return zzdmh2;
        }
    }

    public final JSONObject zzq() {
        synchronized (this) {
            zzdmh zzdmh2 = this.zzi;
            if (zzdmh2 == null) return null;
            zzdmh2 = zzdmh2.zzt((View)this.zzd, this.zzj(), this.zzk());
            return zzdmh2;
        }
    }

    final /* synthetic */ void zzr() {
        if (this.zzg == null) {
            View view;
            this.zzg = view = new View(this.zzd.getContext());
            view.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd == this.zzg.getParent()) return;
        this.zzd.addView(this.zzg);
    }
}
