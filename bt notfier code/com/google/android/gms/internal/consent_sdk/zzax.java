/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzav
 *  com.google.android.ump.ConsentForm
 *  com.google.android.ump.FormError
 *  com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener
 *  com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzav;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

final class zzax
implements UserMessagingPlatform.OnConsentFormLoadFailureListener,
UserMessagingPlatform.OnConsentFormLoadSuccessListener {
    private final UserMessagingPlatform.OnConsentFormLoadSuccessListener zza;
    private final UserMessagingPlatform.OnConsentFormLoadFailureListener zzb;

    private zzax(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        this.zza = onConsentFormLoadSuccessListener;
        this.zzb = onConsentFormLoadFailureListener;
    }

    /* synthetic */ zzax(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener, zzav zzav2) {
        this(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
    }

    public final void onConsentFormLoadFailure(FormError formError) {
        this.zzb.onConsentFormLoadFailure(formError);
    }

    public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
        this.zza.onConsentFormLoadSuccess(consentForm);
    }
}
