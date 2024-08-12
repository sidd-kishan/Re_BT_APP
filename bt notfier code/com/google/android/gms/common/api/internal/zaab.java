/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  androidx.collection.ArraySet
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.common.api.internal.zap
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zap;
import com.google.android.gms.common.internal.Preconditions;

public final class zaab
extends zap {
    private final ArraySet<ApiKey<?>> zad = new ArraySet();
    private final GoogleApiManager zae;

    zaab(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.zae = googleApiManager;
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", (LifecycleCallback)this);
    }

    public static void zaa(Activity object, GoogleApiManager googleApiManager, ApiKey<?> apiKey) {
        LifecycleFragment lifecycleFragment = zaab.getFragment((Activity)object);
        zaab zaab2 = (zaab)lifecycleFragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaab.class);
        object = zaab2;
        if (zaab2 == null) {
            object = new zaab(lifecycleFragment, googleApiManager, GoogleApiAvailability.getInstance());
        }
        Preconditions.checkNotNull(apiKey, (Object)"ApiKey cannot be null");
        object.zad.add(apiKey);
        googleApiManager.zae((zaab)((Object)object));
    }

    private final void zac() {
        if (this.zad.isEmpty()) return;
        this.zae.zae(this);
    }

    public final void onResume() {
        super.onResume();
        this.zac();
    }

    public final void onStart() {
        super.onStart();
        this.zac();
    }

    public final void onStop() {
        super.onStop();
        this.zae.zaf(this);
    }

    final ArraySet<ApiKey<?>> zab() {
        return this.zad;
    }

    protected final void zad(ConnectionResult connectionResult, int n) {
        this.zae.zaq(connectionResult, n);
    }

    protected final void zae() {
        this.zae.zai();
    }
}
