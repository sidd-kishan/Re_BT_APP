/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  androidx.browser.customtabs.CustomTabsIntent
 *  androidx.browser.customtabs.CustomTabsIntent$Builder
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzbkj
 *  com.google.android.gms.internal.ads.zzbyc
 *  com.google.android.gms.internal.ads.zzbyd
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgz
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzbyc;
import com.google.android.gms.internal.ads.zzbyd;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgz;

public final class zzbye
implements MediationInterstitialAdapter {
    private Activity zza;
    private MediationInterstitialListener zzb;
    private Uri zzc;

    static /* synthetic */ Activity zza(zzbye zzbye2) {
        return zzbye2.zza;
    }

    static /* synthetic */ MediationInterstitialListener zzb(zzbye zzbye2) {
        return zzbye2.zzb;
    }

    public final void onDestroy() {
        zzcgt.zzd((String)"Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzcgt.zzd((String)"Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzcgt.zzd((String)"Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener object, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzb = object;
        if (object == null) {
            zzcgt.zzi((String)"Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            zzcgt.zzi((String)"AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzb.onAdFailedToLoad((MediationInterstitialAdapter)this, 0);
            return;
        }
        if (PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzbkj.zza((Context)context)) {
            object = bundle.getString("tab_url");
            if (TextUtils.isEmpty((CharSequence)object)) {
                zzcgt.zzi((String)"The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzb.onAdFailedToLoad((MediationInterstitialAdapter)this, 0);
                return;
            }
            this.zza = (Activity)context;
            this.zzc = Uri.parse((String)object);
            this.zzb.onAdLoaded((MediationInterstitialAdapter)this);
            return;
        }
        zzcgt.zzi((String)"Default browser does not support custom tabs. Bailing out.");
        this.zzb.onAdFailedToLoad((MediationInterstitialAdapter)this, 0);
    }

    public final void showInterstitial() {
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
        customTabsIntent.intent.setData(this.zzc);
        customTabsIntent = new AdOverlayInfoParcel(new zzc(customTabsIntent.intent, null), null, (zzo)new zzbyc(this), null, new zzcgz(0, 0, false, false, false), null, null);
        zzs.zza.post((Runnable)new zzbyd(this, (AdOverlayInfoParcel)customTabsIntent));
        zzt.zzg().zzh();
    }
}
