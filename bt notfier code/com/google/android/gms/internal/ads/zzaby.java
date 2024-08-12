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
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.PowerManager
 *  android.os.SystemClock
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  com.google.android.gms.internal.ads.zzabh
 *  com.google.android.gms.internal.ads.zzabk
 *  com.google.android.gms.internal.ads.zzabu
 *  com.google.android.gms.internal.ads.zzabw
 *  com.google.android.gms.internal.ads.zzabx
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
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.ads.zzabh;
import com.google.android.gms.internal.ads.zzabk;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzabw;
import com.google.android.gms.internal.ads.zzabx;
import java.lang.ref.WeakReference;

public final class zzaby
implements View.OnAttachStateChangeListener,
ViewTreeObserver.OnGlobalLayoutListener,
ViewTreeObserver.OnScrollChangedListener,
Application.ActivityLifecycleCallbacks {
    private static final Handler zza = new Handler(Looper.getMainLooper());
    private final Context zzb;
    private Application zzc;
    private final PowerManager zzd;
    private final KeyguardManager zze;
    private BroadcastReceiver zzf;
    private final zzabk zzg;
    private WeakReference<ViewTreeObserver> zzh;
    private WeakReference<View> zzi;
    private zzabh zzj;
    private byte zzk = (byte)-1;
    private int zzl = -1;
    private long zzm = -3L;

    public zzaby(Context context, zzabk zzabk2) {
        this.zzb = context = context.getApplicationContext();
        this.zzg = zzabk2;
        this.zzd = (PowerManager)context.getSystemService("power");
        this.zze = (KeyguardManager)this.zzb.getSystemService("keyguard");
        context = this.zzb;
        if (context instanceof Application) {
            context = (Application)context;
            this.zzc = context;
            this.zzj = new zzabh((Application)context, (Application.ActivityLifecycleCallbacks)this);
        }
        this.zza(null);
    }

    static /* synthetic */ void zzd(zzaby zzaby2) {
        zzaby2.zzg();
    }

    private final void zze() {
        zza.post((Runnable)new zzabw(this));
    }

    private final void zzf(Activity activity, int n) {
        if (this.zzi == null) {
            return;
        }
        if ((activity = activity.getWindow()) == null) {
            return;
        }
        View view = activity.peekDecorView();
        activity = this.zzb();
        if (activity == null) return;
        if (view == null) return;
        if (activity.getRootView() != view.getRootView()) return;
        this.zzl = n;
    }

    /*
     * WARNING - void declaration
     */
    private final void zzg() {
        int n;
        int n2;
        int n3;
        int n4;
        View view;
        block14: {
            int n5;
            block15: {
                void var1_4;
                if (this.zzi == null) {
                    return;
                }
                view = this.zzb();
                if (view == null) {
                    this.zzm = -3L;
                    this.zzk = (byte)-1;
                    return;
                }
                if (view.getVisibility() != 0) {
                    boolean by2 = true;
                } else {
                    boolean bl = false;
                }
                n4 = var1_4;
                if (!view.isShown()) {
                    n4 = var1_4 | 2;
                }
                Object object = this.zzd;
                int n6 = n4;
                if (object != null) {
                    int n7 = n4;
                    if (!object.isScreenOn()) {
                        n5 = n4 | 4;
                    }
                }
                n4 = n5;
                if (this.zzg.zza()) break block14;
                object = this.zze;
                if (object == null || !object.inKeyguardRestrictedInputMode() || (object = zzabu.zzi((View)view)) == null || (object = (object = object.getWindow()) == null ? null : object.getAttributes()) == null) break block15;
                n4 = n5;
                if ((object.flags & 0x80000) != 0) break block14;
            }
            n4 = n5 | 8;
        }
        int n8 = n4;
        if (!view.getGlobalVisibleRect(new Rect())) {
            n3 = n4 | 0x10;
        }
        void var1_8 = n3;
        if (!view.getLocalVisibleRect(new Rect())) {
            n2 = n3 | 0x20;
        }
        n4 = view.getWindowVisibility();
        int n9 = this.zzl;
        if (n9 != -1) {
            n4 = n9;
        }
        int n10 = n2;
        if (n4 != 0) {
            n = n2 | 0x40;
        }
        if (this.zzk == n) return;
        this.zzk = (byte)n;
        long l = n == 0 ? SystemClock.elapsedRealtime() : -3L - (long)n;
        this.zzm = l;
    }

    /*
     * Enabled force condition propagation
     */
    private final void zzh(View view) {
        if ((view = view.getViewTreeObserver()).isAlive()) {
            this.zzh = new WeakReference<View>(view);
            view.addOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)this);
            view.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
        if (this.zzf == null) {
            view = new IntentFilter();
            view.addAction("android.intent.action.SCREEN_ON");
            view.addAction("android.intent.action.SCREEN_OFF");
            view.addAction("android.intent.action.USER_PRESENT");
            zzabx zzabx2 = new zzabx(this);
            this.zzf = zzabx2;
            this.zzb.registerReceiver((BroadcastReceiver)zzabx2, (IntentFilter)view);
        }
        if ((view = this.zzc) == null) return;
        try {
            view.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.zzj);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void zzi(View var1_1) {
        block15: {
            block14: {
                block13: {
                    try {
                        var2_5 = this.zzh;
                        if (var2_5 == null) break block13;
                        if ((var2_5 = (ViewTreeObserver)var2_5.get()) != null && var2_5.isAlive()) {
                            var2_5.removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)this);
                            var2_5.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                        }
                        this.zzh = null;
                    }
                    catch (Exception var2_6) {
                        ** continue;
                    }
                }
lbl9:
                // 2 sources

                while (true) {
                    try {
                        var1_1 = var1_1.getViewTreeObserver();
                        if (var1_1.isAlive()) {
                            var1_1.removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener)this);
                            var1_1.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                        }
                    }
                    catch (Exception var1_2) {
                        // empty catch block
                    }
                    if ((var1_1 = this.zzf) == null) break;
                    this.zzb.unregisterReceiver((BroadcastReceiver)var1_1);
lbl21:
                    // 2 sources

                    while (true) {
                        this.zzf = null;
                        break block14;
                        break;
                    }
                    break;
                }
            }
            if ((var1_1 = this.zzc) == null) return;
            try {}
            catch (Exception var1_4) {}
            break block15;
lbl31:
            // 2 sources

            return;
            catch (Exception var1_3) {
                ** continue;
            }
        }
        var1_1.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.zzj);
        ** while (true)
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.zzf(activity, 0);
        this.zzg();
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzg();
    }

    public final void onActivityPaused(Activity activity) {
        this.zzf(activity, 4);
        this.zzg();
    }

    public final void onActivityResumed(Activity activity) {
        this.zzf(activity, 0);
        this.zzg();
        this.zze();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zzg();
    }

    public final void onActivityStarted(Activity activity) {
        this.zzf(activity, 0);
        this.zzg();
    }

    public final void onActivityStopped(Activity activity) {
        this.zzg();
    }

    public final void onGlobalLayout() {
        this.zzg();
    }

    public final void onScrollChanged() {
        this.zzg();
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzl = -1;
        this.zzh(view);
        this.zzg();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzl = -1;
        this.zzg();
        this.zze();
        this.zzi(view);
    }

    final void zza(View view) {
        long l;
        View view2 = this.zzb();
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            this.zzi(view2);
        }
        this.zzi = new WeakReference<View>(view);
        if (view != null) {
            if (view.getWindowToken() != null || view.getWindowVisibility() != 8) {
                this.zzh(view);
            }
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            l = -2L;
        } else {
            l = -3L;
        }
        this.zzm = l;
    }

    final View zzb() {
        WeakReference<View> weakReference = this.zzi;
        if (weakReference == null) return null;
        return (View)weakReference.get();
    }

    public final long zzc() {
        if (this.zzm > -2L) return this.zzm;
        if (this.zzb() != null) return this.zzm;
        this.zzm = -3L;
        return this.zzm;
    }
}
