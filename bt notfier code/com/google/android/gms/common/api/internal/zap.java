/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.api.internal.LifecycleCallback
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.common.api.internal.zam
 *  com.google.android.gms.common.api.internal.zao
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zam;
import com.google.android.gms.common.api.internal.zao;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zap
extends LifecycleCallback
implements DialogInterface.OnCancelListener {
    protected volatile boolean zaa;
    protected final AtomicReference<zam> zab = new AtomicReference<Object>(null);
    protected final GoogleApiAvailability zac;
    private final Handler zad = new com.google.android.gms.internal.base.zap(Looper.getMainLooper());

    zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zac = googleApiAvailability;
    }

    private final void zaa() {
        this.zab.set(null);
        this.zae();
    }

    private final void zab(ConnectionResult connectionResult, int n) {
        this.zab.set(null);
        this.zad(connectionResult, n);
    }

    private static final int zac(zam zam2) {
        if (zam2 != null) return zam2.zaa();
        return -1;
    }

    static /* synthetic */ void zag(zap zap2) {
        zap2.zaa();
    }

    static /* synthetic */ void zah(zap zap2, ConnectionResult connectionResult, int n) {
        zap2.zab(connectionResult, n);
    }

    public final void onActivityResult(int n, int n2, Intent intent) {
        zam zam2 = this.zab.get();
        if (n != 1) {
            if (n == 2) {
                n = this.zac.isGooglePlayServicesAvailable((Context)this.getActivity());
                if (n == 0) {
                    this.zaa();
                    return;
                }
                if (zam2 == null) {
                    return;
                }
                if (zam2.zab().getErrorCode() == 18 && n == 18) {
                    return;
                }
            }
        } else {
            if (n2 == -1) {
                this.zaa();
                return;
            }
            if (n2 == 0) {
                if (zam2 == null) {
                    return;
                }
                n = 13;
                if (intent != null) {
                    n = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                this.zab(new ConnectionResult(n, null, zam2.zab().toString()), zap.zac(zam2));
                return;
            }
        }
        if (zam2 == null) return;
        this.zab(zam2.zab(), zam2.zaa());
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zab(new ConnectionResult(13, null), zap.zac(this.zab.get()));
    }

    public final void onCreate(Bundle object) {
        super.onCreate(object);
        if (object == null) return;
        AtomicReference<zam> atomicReference = this.zab;
        object = object.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(object.getInt("failed_status"), (PendingIntent)object.getParcelable("failed_resolution")), object.getInt("failed_client_id", -1)) : null;
        atomicReference.set((zam)object);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zam2 = this.zab.get();
        if (zam2 == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", zam2.zaa());
        bundle.putInt("failed_status", zam2.zab().getErrorCode());
        bundle.putParcelable("failed_resolution", (Parcelable)zam2.zab().getResolution());
    }

    public void onStart() {
        super.onStart();
        this.zaa = true;
    }

    public void onStop() {
        super.onStop();
        this.zaa = false;
    }

    protected abstract void zad(ConnectionResult var1, int var2);

    protected abstract void zae();

    public final void zaf(ConnectionResult connectionResult, int n) {
        if (!this.zab.compareAndSet(null, (zam)(connectionResult = new zam(connectionResult, n)))) return;
        this.zad.post((Runnable)new zao(this, (zam)connectionResult));
    }
}
