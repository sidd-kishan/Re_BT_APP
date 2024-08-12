/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.app.KeyguardManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.os.PowerManager
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.view.WindowManager
 *  com.google.android.gms.ads.internal.util.zzcc
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzawa
 *  com.google.android.gms.internal.ads.zzawb
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzawq
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzcc;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzawa;
import com.google.android.gms.internal.ads.zzawb;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzawq;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class zzawe
implements View.OnAttachStateChangeListener,
ViewTreeObserver.OnGlobalLayoutListener,
ViewTreeObserver.OnScrollChangedListener,
Application.ActivityLifecycleCallbacks {
    private static final long zzc;
    BroadcastReceiver zza;
    final WeakReference<View> zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference<ViewTreeObserver> zzi;
    private zzawq zzj;
    private final zzcc zzk = new zzcc(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet<zzawd> zzn = new HashSet();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    static {
        zzbjd zzbjd2 = zzbjl.zzaR;
        zzc = (Long)zzbet.zzc().zzc(zzbjd2);
    }

    public zzawe(Context object, View view) {
        this.zzd = object.getApplicationContext();
        this.zzf = (WindowManager)object.getSystemService("window");
        this.zzg = (PowerManager)this.zzd.getSystemService("power");
        this.zzh = (KeyguardManager)object.getSystemService("keyguard");
        Context context = this.zzd;
        if (context instanceof Application) {
            context = (Application)context;
            this.zze = context;
            this.zzj = new zzawq((Application)context, (Application.ActivityLifecycleCallbacks)this);
        }
        this.zzo = object.getResources().getDisplayMetrics();
        object = new Rect();
        this.zzp = object;
        ((Rect)object).right = this.zzf.getDefaultDisplay().getWidth();
        this.zzp.bottom = this.zzf.getDefaultDisplay().getHeight();
        object = this.zzb;
        object = object != null ? (View)((Reference)object).get() : null;
        if (object != null) {
            object.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            this.zzm((View)object);
        }
        this.zzb = new WeakReference<View>(view);
        if (view == null) return;
        if (zzt.zze().zzg(view)) {
            this.zzl(view);
        }
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    static /* synthetic */ void zzc(zzawe zzawe2, int n) {
        zzawe2.zzj(3);
    }

    private final void zzh() {
        zzs.zza.post((Runnable)new zzawa(this));
    }

    private final void zzi(Activity activity, int n) {
        if (this.zzb == null) {
            return;
        }
        if ((activity = activity.getWindow()) == null) {
            return;
        }
        View view = activity.peekDecorView();
        activity = (View)this.zzb.get();
        if (activity == null) return;
        if (view == null) return;
        if (activity.getRootView() != view.getRootView()) return;
        this.zzm = n;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void zzj(int var1_1) {
        block22: {
            if (this.zzn.size() == 0) {
                return;
            }
            var16_2 = this.zzb;
            if (var16_2 == null) {
                return;
            }
            var19_4 = (View)var16_2.get();
            var23_5 = new Rect();
            var24_6 = new Rect();
            var21_7 = new Rect();
            var22_8 = new Rect();
            var16_2 = new int[2];
            var17_9 /* !! */  = new int[2];
            var14_11 = true;
            if (var19_4 != null) {
                var12_12 = var19_4.getGlobalVisibleRect(var24_6);
                var11_13 = var19_4.getLocalVisibleRect(var21_7);
                var19_4.getHitRect(var22_8);
                try {
                    var19_4.getLocationOnScreen((int[])var16_2);
                    var19_4.getLocationInWindow(var17_9 /* !! */ );
                }
                catch (Exception var17_10) {
                    com.google.android.gms.ads.internal.util.zze.zzg((String)"Failure getting view location.", (Throwable)var17_10);
                }
                var23_5.left = (int)var16_2[0];
                var23_5.top = (int)var16_2[1];
                var23_5.right = var23_5.left + var19_4.getWidth();
                var23_5.bottom = var23_5.top + var19_4.getHeight();
                var17_9 /* !! */  = (int[])var19_4;
            } else {
                var17_9 /* !! */  = null;
                var12_12 = false;
                var11_13 = false;
            }
            var16_2 = zzbjl.zzaU;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)var16_2)).booleanValue() && var17_9 /* !! */  != null) {
                try {
                    var20_14 = new ArrayList<T>();
                    var18_15 = var17_9 /* !! */ .getParent();
                    while (true) {
                        var16_2 = var20_14;
                        if (!(var18_15 instanceof View)) break;
                        var16_2 = (View)var18_15;
                        var25_16 = new Rect();
                        if (var16_2.isScrollContainer() && var16_2.getGlobalVisibleRect(var25_16)) {
                            var20_14.add(this.zzd(var25_16));
                        }
                        var18_15 = var18_15.getParent();
                    }
                }
                catch (Exception var16_3) {
                    zzt.zzg().zzk((Throwable)var16_3, "PositionWatcher.getParentScrollViewRects");
                    var16_2 = Collections.emptyList();
                }
            } else {
                var16_2 = Collections.emptyList();
            }
            var2_17 = var17_9 /* !! */  != null ? var17_9 /* !! */ .getWindowVisibility() : 8;
            var3_18 = this.zzm;
            if (var3_18 != -1) {
                var2_17 = var3_18;
            }
            zzt.zzc();
            var7_19 = zzs.zzA((View)var17_9 /* !! */ );
            var18_15 = zzbjl.zzgQ;
            if (!((Boolean)zzbet.zzc().zzc((zzbjd)var18_15)).booleanValue()) break block22;
            if (var19_4 == null) ** GOTO lbl-1000
            zzt.zzc();
            if (!zzs.zzW((View)var17_9 /* !! */ , (PowerManager)this.zzg, (KeyguardManager)this.zzh) || !var12_12 || !var11_13) ** GOTO lbl-1000
            var18_15 = zzbjl.zzgT;
            if (var7_19 < (long)((Integer)zzbet.zzc().zzc((zzbjd)var18_15)).intValue() || var2_17 != 0) ** GOTO lbl-1000
            ** GOTO lbl-1000
        }
        if (var19_4 != null) {
            zzt.zzc();
            ** if (!zzs.zzW((View)var17_9 /* !! */ , (PowerManager)this.zzg, (KeyguardManager)this.zzh) || !var12_12 || !var11_13 || var2_17 != 0) goto lbl-1000
        }
        ** GOTO lbl-1000
lbl-1000:
        // 2 sources

        {
            var13_20 = 1;
            var4_21 = 0;
            ** GOTO lbl80
        }
lbl-1000:
        // 5 sources

        {
            var13_20 = 0;
            var4_21 = var2_17;
        }
lbl80:
        // 2 sources

        var18_15 = zzbjl.zzgV;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)var18_15)).booleanValue()) {
            zzt.zzc();
            var2_17 = true != zzs.zzW((View)var17_9 /* !! */ , (PowerManager)this.zzg, (KeyguardManager)this.zzh) ? 0 : 64;
            var3_18 = true != var12_12 ? 0 : 8;
            var5_22 = true != var11_13 ? 0 : 16;
            var4_21 = var4_21 == 0 ? 128 : 0;
            var18_15 = zzbjl.zzgT;
            var6_23 = var7_19 >= (long)((Integer)zzbet.zzc().zzc((zzbjd)var18_15)).intValue() ? 32 : 0;
            zzt.zzc();
            zzs.zzM((View)var17_9 /* !! */ , (int)(var4_21 | (var2_17 | var3_18 | var5_22) | var6_23 | var13_20), null);
        }
        if (var1_1 == 1 && !this.zzk.zza()) {
            if (var13_20 == this.zzl) return;
        }
        if (var13_20 == 0 && !this.zzl) {
            if (var1_1 == 1) return;
        }
        var9_24 = zzt.zzj().elapsedRealtime();
        var15_25 = this.zzg.isScreenOn();
        if (var17_9 /* !! */  == null || !zzt.zze().zzg((View)var17_9 /* !! */ )) {
            var14_11 = false;
        }
        var1_1 = var17_9 /* !! */  != null ? var17_9 /* !! */ .getWindowVisibility() : 8;
        var17_9 /* !! */  = (int[])new zzawc(var9_24, var15_25, var14_11, var1_1, this.zzd(this.zzp), this.zzd(var23_5), this.zzd(var24_6), var12_12, this.zzd(var21_7), var11_13, var7_19, this.zzd(var22_8), this.zzo.density, (boolean)var13_20, (List)var16_2);
        var16_2 = this.zzn.iterator();
        while (true) {
            if (!var16_2.hasNext()) {
                this.zzl = var13_20;
                return;
            }
            ((zzawd)var16_2.next()).zzc((zzawc)var17_9 /* !! */ );
        }
    }

    private final int zzk(int n) {
        return (int)((float)n / this.zzo.density);
    }

    private final void zzl(View view) {
        if ((view = view.getViewTreeObserver()).isAlive()) {
            this.zzi = new WeakReference<View>(view);
            view.addOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)this);
            view.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
        if (this.zza == null) {
            view = new IntentFilter();
            view.addAction("android.intent.action.SCREEN_ON");
            view.addAction("android.intent.action.SCREEN_OFF");
            view.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzawb(this);
            zzt.zzx().zzb(this.zzd, this.zza, (IntentFilter)view);
        }
        if ((view = this.zze) == null) return;
        try {
            view.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.zzj);
            return;
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Error registering activity lifecycle callbacks.", (Throwable)exception);
        }
    }

    private final void zzm(View view) {
        try {
            ViewTreeObserver viewTreeObserver = this.zzi;
            if (viewTreeObserver != null) {
                if ((viewTreeObserver = (ViewTreeObserver)viewTreeObserver.get()) != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)this);
                    viewTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                }
                this.zzi = null;
            }
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Error while unregistering listeners from the last ViewTreeObserver.", (Throwable)exception);
        }
        try {
            view = view.getViewTreeObserver();
            if (view.isAlive()) {
                view.removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)this);
                view.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
            }
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Error while unregistering listeners from the ViewTreeObserver.", (Throwable)exception);
        }
        if (this.zza != null) {
            try {
                zzt.zzx().zzc(this.zzd, this.zza);
            }
            catch (Exception exception) {
                zzt.zzg().zzk((Throwable)exception, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            catch (IllegalStateException illegalStateException) {
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Failed trying to unregister the receiver", (Throwable)illegalStateException);
            }
            this.zza = null;
        }
        if ((view = this.zze) == null) return;
        try {
            view.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.zzj);
            return;
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Error registering activity lifecycle callbacks.", (Throwable)exception);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.zzi(activity, 0);
        this.zzj(3);
        this.zzh();
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzj(3);
        this.zzh();
    }

    public final void onActivityPaused(Activity activity) {
        this.zzi(activity, 4);
        this.zzj(3);
        this.zzh();
    }

    public final void onActivityResumed(Activity activity) {
        this.zzi(activity, 0);
        this.zzj(3);
        this.zzh();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zzj(3);
        this.zzh();
    }

    public final void onActivityStarted(Activity activity) {
        this.zzi(activity, 0);
        this.zzj(3);
        this.zzh();
    }

    public final void onActivityStopped(Activity activity) {
        this.zzj(3);
        this.zzh();
    }

    public final void onGlobalLayout() {
        this.zzj(2);
        this.zzh();
    }

    public final void onScrollChanged() {
        this.zzj(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        this.zzl(view);
        this.zzj(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        this.zzj(3);
        this.zzh();
        this.zzm(view);
    }

    public final void zza(zzawd zzawd2) {
        this.zzn.add(zzawd2);
        this.zzj(3);
    }

    public final void zzb(zzawd zzawd2) {
        this.zzn.remove(zzawd2);
    }

    final Rect zzd(Rect rect) {
        return new Rect(this.zzk(rect.left), this.zzk(rect.top), this.zzk(rect.right), this.zzk(rect.bottom));
    }

    public final void zze(long l) {
        this.zzk.zzb(l);
    }

    public final void zzf() {
        this.zzk.zzb(zzc);
    }

    final /* synthetic */ void zzg() {
        this.zzj(3);
    }
}
