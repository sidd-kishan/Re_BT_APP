/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.common.api.internal.zap
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public final class zabw
extends zap {
    private TaskCompletionSource<Void> zad = new TaskCompletionSource();

    private zabw(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.getInstance());
        this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", (LifecycleCallback)this);
    }

    public static zabw zaa(Activity object) {
        LifecycleFragment lifecycleFragment = zabw.getFragment((Activity)object);
        if ((object = (zabw)lifecycleFragment.getCallbackOrNull("GmsAvailabilityHelper", zabw.class)) == null) return new zabw(lifecycleFragment);
        if (!object.zad.getTask().isComplete()) return object;
        object.zad = new TaskCompletionSource();
        return object;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zad.trySetException((Exception)new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    public final Task<Void> zab() {
        return this.zad.getTask();
    }

    protected final void zad(ConnectionResult connectionResult, int n) {
        String string;
        String string2 = string = connectionResult.getErrorMessage();
        if (string == null) {
            string2 = "Error connecting to Google Play services";
        }
        this.zad.setException((Exception)new ApiException(new Status(connectionResult, string2, connectionResult.getErrorCode())));
    }

    protected final void zae() {
        Activity activity = this.mLifecycleFragment.getLifecycleActivity();
        if (activity == null) {
            this.zad.trySetException((Exception)new ApiException(new Status(8)));
            return;
        }
        int n = this.zac.isGooglePlayServicesAvailable((Context)activity);
        if (n == 0) {
            this.zad.trySetResult(null);
            return;
        }
        if (this.zad.getTask().isComplete()) return;
        this.zaf(new ConnectionResult(n, null), 0);
    }
}
