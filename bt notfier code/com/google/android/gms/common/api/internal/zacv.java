/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.Log
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Releasable
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.ResultCallbacks
 *  com.google.android.gms.common.api.ResultTransform
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.TransformedResult
 *  com.google.android.gms.common.api.internal.zacj
 *  com.google.android.gms.common.api.internal.zact
 *  com.google.android.gms.common.api.internal.zacu
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.internal.zacj;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.api.internal.zacu;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

public final class zacv<R extends Result>
extends TransformedResult<R>
implements ResultCallback<R> {
    private ResultTransform<? super R, ? extends Result> zaa = null;
    private zacv<? extends Result> zab = null;
    private volatile ResultCallbacks<? super R> zac = null;
    private PendingResult<R> zad = null;
    private final Object zae = new Object();
    private Status zaf = null;
    private final WeakReference<GoogleApiClient> zag;
    private final zacu zah;
    private boolean zai = false;

    public zacv(WeakReference<GoogleApiClient> googleApiClient) {
        Preconditions.checkNotNull(googleApiClient, (Object)"GoogleApiClient reference must not be null");
        this.zag = googleApiClient;
        googleApiClient = (GoogleApiClient)googleApiClient.get();
        googleApiClient = googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper();
        this.zah = new zacu(this, (Looper)googleApiClient);
    }

    static /* synthetic */ ResultTransform zac(zacv zacv2) {
        return zacv2.zaa;
    }

    static /* synthetic */ zacu zad(zacv zacv2) {
        return zacv2.zah;
    }

    static /* synthetic */ void zae(zacv zacv2, Result result) {
        zacv.zan(result);
    }

    static /* synthetic */ WeakReference zaf(zacv zacv2) {
        return zacv2.zag;
    }

    static /* synthetic */ Object zag(zacv zacv2) {
        return zacv2.zae;
    }

    static /* synthetic */ zacv zah(zacv zacv2) {
        return zacv2.zab;
    }

    static /* synthetic */ void zai(zacv zacv2, Status status) {
        zacv2.zak(status);
    }

    private final void zaj() {
        if (this.zaa == null) {
            if (this.zac == null) return;
        }
        PendingResult<R> pendingResult = (PendingResult<R>)this.zag.get();
        if (!this.zai && this.zaa != null && pendingResult != null) {
            pendingResult.zao(this);
            this.zai = true;
        }
        if ((pendingResult = this.zaf) != null) {
            this.zal((Status)pendingResult);
            return;
        }
        pendingResult = this.zad;
        if (pendingResult == null) return;
        pendingResult.setResultCallback((ResultCallback)this);
    }

    private final void zak(Status status) {
        Object object = this.zae;
        synchronized (object) {
            this.zaf = status;
            this.zal(status);
            return;
        }
    }

    private final void zal(Status status) {
        Object object = this.zae;
        synchronized (object) {
            ResultTransform<? super R, ? extends Result> resultTransform = this.zaa;
            if (resultTransform != null) {
                status = (Status)Preconditions.checkNotNull((Object)resultTransform.onFailure(status), (Object)"onFailure must not return null");
                ((zacv)((Object)Preconditions.checkNotNull(this.zab))).zak(status);
            } else {
                if (!this.zam()) return;
                ((ResultCallbacks)Preconditions.checkNotNull(this.zac)).onFailure(status);
            }
            return;
        }
    }

    private final boolean zam() {
        GoogleApiClient googleApiClient = (GoogleApiClient)this.zag.get();
        if (this.zac == null) return false;
        if (googleApiClient == null) return false;
        return true;
    }

    private static final void zan(Result object) {
        if (!(object instanceof Releasable)) return;
        try {
            ((Releasable)object).release();
            return;
        }
        catch (RuntimeException runtimeException) {
            String string = String.valueOf(object);
            object = new StringBuilder(String.valueOf(string).length() + 18);
            ((StringBuilder)object).append("Unable to release ");
            ((StringBuilder)object).append(string);
            Log.w((String)"TransformedResultImpl", (String)((StringBuilder)object).toString(), (Throwable)runtimeException);
        }
    }

    public final void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        Object object = this.zae;
        synchronized (object) {
            ResultCallbacks<? super R> resultCallbacks2 = this.zac;
            boolean bl = true;
            boolean bl2 = resultCallbacks2 == null;
            Preconditions.checkState((boolean)bl2, (Object)"Cannot call andFinally() twice.");
            bl2 = this.zaa == null ? bl : false;
            Preconditions.checkState((boolean)bl2, (Object)"Cannot call then() and andFinally() on the same TransformedResult.");
            this.zac = resultCallbacks;
            this.zaj();
            return;
        }
    }

    public final void onResult(R r) {
        Object object = this.zae;
        synchronized (object) {
            if (r.getStatus().isSuccess()) {
                if (this.zaa != null) {
                    ExecutorService executorService = zacj.zaa();
                    zact zact2 = new zact(this, r);
                    executorService.submit((Runnable)zact2);
                } else {
                    if (!this.zam()) return;
                    ((ResultCallbacks)Preconditions.checkNotNull(this.zac)).onSuccess(r);
                }
            } else {
                this.zak(r.getStatus());
                zacv.zan(r);
            }
            return;
        }
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> object) {
        Object object2 = this.zae;
        synchronized (object2) {
            ResultTransform<? super R, ? extends Result> resultTransform = this.zaa;
            boolean bl = true;
            boolean bl2 = resultTransform == null;
            Preconditions.checkState((boolean)bl2, (Object)"Cannot call then() twice.");
            bl2 = this.zac == null ? bl : false;
            Preconditions.checkState((boolean)bl2, (Object)"Cannot call then() and andFinally() on the same TransformedResult.");
            this.zaa = object;
            object = new Object(this.zag);
            this.zab = object;
            this.zaj();
            return object;
        }
    }

    public final void zaa(PendingResult<?> pendingResult) {
        Object object = this.zae;
        synchronized (object) {
            this.zad = pendingResult;
            this.zaj();
            return;
        }
    }

    final void zab() {
        this.zac = null;
    }
}
