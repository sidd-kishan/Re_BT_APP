/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.webkit.WebViewClient
 *  com.google.android.gms.internal.consent_sdk.zzab
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzaw
 *  com.google.android.gms.internal.consent_sdk.zzax
 *  com.google.android.gms.internal.consent_sdk.zzay
 *  com.google.android.gms.internal.consent_sdk.zzbb
 *  com.google.android.gms.internal.consent_sdk.zzbe
 *  com.google.android.gms.internal.consent_sdk.zzbf
 *  com.google.android.gms.internal.consent_sdk.zzbh
 *  com.google.android.gms.internal.consent_sdk.zzcd
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zzk
 *  com.google.android.ump.ConsentForm
 *  com.google.android.ump.ConsentForm$OnConsentFormDismissedListener
 *  com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener
 *  com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.consent_sdk.zzab;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzaw;
import com.google.android.gms.internal.consent_sdk.zzax;
import com.google.android.gms.internal.consent_sdk.zzay;
import com.google.android.gms.internal.consent_sdk.zzbb;
import com.google.android.gms.internal.consent_sdk.zzbe;
import com.google.android.gms.internal.consent_sdk.zzbf;
import com.google.android.gms.internal.consent_sdk.zzbh;
import com.google.android.gms.internal.consent_sdk.zzcd;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zzk;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.UserMessagingPlatform;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class zzat
implements ConsentForm {
    private final Application zza;
    private final zzab zzb;
    private final zzbh zzc;
    private final zzal zzd;
    private final zzbb zze;
    private final zzct<zzbe> zzf;
    private Dialog zzg;
    private zzbe zzh;
    private final AtomicBoolean zzi = new AtomicBoolean();
    private final AtomicReference<zzax> zzj = new AtomicReference();
    private final AtomicReference<ConsentForm.OnConsentFormDismissedListener> zzk = new AtomicReference();
    private final AtomicReference<zzay> zzl = new AtomicReference();

    public zzat(Application application, zzab zzab2, zzbh zzbh2, zzal zzal2, zzbb zzbb2, zzct<zzbe> zzct2) {
        this.zza = application;
        this.zzb = zzab2;
        this.zzc = zzbh2;
        this.zzd = zzal2;
        this.zze = zzbb2;
        this.zzf = zzct2;
    }

    static /* synthetic */ Application zza(zzat zzat2) {
        return zzat2.zza;
    }

    private final void zzd() {
        Dialog dialog = this.zzg;
        if (dialog != null) {
            dialog.dismiss();
            this.zzg = null;
        }
        this.zzc.zza(null);
        dialog = this.zzl.getAndSet(null);
        if (dialog == null) return;
        zzay.zza((zzay)dialog);
    }

    public final void show(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        zzcd.zza();
        if (!this.zzi.compareAndSet(false, true)) {
            onConsentFormDismissedListener.onConsentFormDismissed(new zzk(3, "ConsentForm#show can only be invoked once.").zza());
            return;
        }
        zzay zzay2 = new zzay(this, activity);
        this.zza.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)zzay2);
        this.zzl.set(zzay2);
        this.zzc.zza(activity);
        zzay2 = new Dialog((Context)activity, 0x1030010);
        zzay2.setContentView((View)this.zzh);
        zzay2.setCancelable(false);
        activity = zzay2.getWindow();
        if (activity == null) {
            onConsentFormDismissedListener.onConsentFormDismissed(new zzk(3, "Activity with null windows is passed in.").zza());
            return;
        }
        activity.setLayout(-1, -1);
        activity.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        this.zzk.set(onConsentFormDismissedListener);
        zzay2.show();
        this.zzg = zzay2;
    }

    final zzbe zza() {
        return this.zzh;
    }

    final void zza(int n, int n2) {
        this.zzd();
        ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener = this.zzk.getAndSet(null);
        if (onConsentFormDismissedListener == null) {
            return;
        }
        this.zzd.zza(3);
        this.zzd.zzb(n2);
        onConsentFormDismissedListener.onConsentFormDismissed(null);
    }

    final void zza(zzk zzk2) {
        zzax zzax2 = this.zzj.getAndSet(null);
        if (zzax2 == null) {
            return;
        }
        zzax2.onConsentFormLoadFailure(zzk2.zza());
    }

    final void zza(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        zzbe zzbe2;
        this.zzh = zzbe2 = (zzbe)this.zzf.zza();
        zzbe2.setBackgroundColor(0);
        zzbe2.getSettings().setJavaScriptEnabled(true);
        zzbe2.setWebViewClient((WebViewClient)new zzbf(zzbe2, null));
        this.zzj.set(new zzax(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener, null));
        this.zzh.loadDataWithBaseURL(this.zze.zza(), this.zze.zzb(), "text/html", "UTF-8", null);
        zzcd.zza.postDelayed((Runnable)new zzaw(this), 10000L);
    }

    final void zzb() {
        zzax zzax2 = this.zzj.getAndSet(null);
        if (zzax2 == null) {
            return;
        }
        zzax2.onConsentFormLoadSuccess((ConsentForm)this);
    }

    final void zzb(zzk zzk2) {
        this.zzd();
        ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener = this.zzk.getAndSet(null);
        if (onConsentFormDismissedListener == null) {
            return;
        }
        onConsentFormDismissedListener.onConsentFormDismissed(zzk2.zza());
    }

    final /* synthetic */ void zzc() {
        this.zza(new zzk(4, "Web view timed out."));
    }
}
