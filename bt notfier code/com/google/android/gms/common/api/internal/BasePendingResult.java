/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.RemoteException
 *  android.util.Log
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Releasable
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.ResultTransform
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.TransformedResult
 *  com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler
 *  com.google.android.gms.common.api.internal.zacv
 *  com.google.android.gms.common.api.internal.zacw
 *  com.google.android.gms.common.api.internal.zaq
 *  com.google.android.gms.common.api.internal.zar
 *  com.google.android.gms.common.internal.ICancelToken
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zacv;
import com.google.android.gms.common.api.internal.zacw;
import com.google.android.gms.common.api.internal.zaq;
import com.google.android.gms.common.api.internal.zar;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasePendingResult<R extends Result>
extends PendingResult<R> {
    static final ThreadLocal<Boolean> zaa = new zaq();
    public static final int zad = 0;
    private zar mResultGuardian;
    protected final CallbackHandler<R> zab;
    protected final WeakReference<GoogleApiClient> zac;
    private final Object zae = new Object();
    private final CountDownLatch zaf = new CountDownLatch(1);
    private final ArrayList<PendingResult.StatusListener> zag = new ArrayList();
    private ResultCallback<? super R> zah;
    private final AtomicReference<zacw> zai = new AtomicReference();
    private R zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private ICancelToken zao;
    private volatile zacv<R> zap;
    private boolean zaq = false;

    @Deprecated
    BasePendingResult() {
        this.zab = new CallbackHandler(Looper.getMainLooper());
        this.zac = new WeakReference<Object>(null);
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zab = new CallbackHandler(looper);
        this.zac = new WeakReference<Object>(null);
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        Looper looper = googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper();
        this.zab = new CallbackHandler(looper);
        this.zac = new WeakReference<GoogleApiClient>(googleApiClient);
    }

    protected BasePendingResult(CallbackHandler<R> callbackHandler) {
        this.zab = (CallbackHandler)Preconditions.checkNotNull(callbackHandler, (Object)"CallbackHandler must not be null");
        this.zac = new WeakReference<Object>(null);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final R zaa() {
        R r;
        Object object = this.zae;
        synchronized (object) {
            Preconditions.checkState((boolean)(this.zal ^ true), (Object)"Result has already been consumed.");
            Preconditions.checkState((boolean)this.isReady(), (Object)"Result is not ready.");
            r = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        object = this.zai.getAndSet(null);
        if (object == null) return (R)((Result)Preconditions.checkNotNull(r));
        ((zacw)object).zaa.zab.remove((Object)this);
        return (R)((Result)Preconditions.checkNotNull(r));
    }

    private final void zab(R object) {
        this.zaj = object;
        this.zak = object.getStatus();
        this.zao = null;
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            object = this.zah;
            if (object == null) {
                if (this.zaj instanceof Releasable) {
                    this.mResultGuardian = new zar(this, null);
                }
            } else {
                this.zab.removeMessages(2);
                this.zab.zaa((ResultCallback)object, this.zaa());
            }
        }
        object = this.zag;
        int n = object.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.zag.clear();
                return;
            }
            ((PendingResult.StatusListener)object.get(n2)).onComplete(this.zak);
            ++n2;
        }
    }

    public static void zal(Result object) {
        if (!(object instanceof Releasable)) return;
        try {
            ((Releasable)object).release();
            return;
        }
        catch (RuntimeException runtimeException) {
            object = String.valueOf(object);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 18);
            stringBuilder.append("Unable to release ");
            stringBuilder.append((String)object);
            Log.w((String)"BasePendingResult", (String)stringBuilder.toString(), (Throwable)runtimeException);
        }
    }

    static /* synthetic */ Result zam(BasePendingResult basePendingResult) {
        return basePendingResult.zaj;
    }

    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        boolean bl = statusListener != null;
        Preconditions.checkArgument((boolean)bl, (Object)"Callback cannot be null.");
        Object object = this.zae;
        synchronized (object) {
            if (this.isReady()) {
                statusListener.onComplete(this.zak);
            } else {
                this.zag.add(statusListener);
            }
            return;
        }
    }

    public final R await() {
        Preconditions.checkNotMainThread((String)"await must not be called on the UI thread");
        boolean bl = this.zal;
        boolean bl2 = true;
        Preconditions.checkState((boolean)(bl ^ true), (Object)"Result has already been consumed");
        if (this.zap != null) {
            bl2 = false;
        }
        Preconditions.checkState((boolean)bl2, (Object)"Cannot await if then() has been called.");
        try {
            this.zaf.await();
        }
        catch (InterruptedException interruptedException) {
            this.forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState((boolean)this.isReady(), (Object)"Result is not ready.");
        return this.zaa();
    }

    public final R await(long l, TimeUnit timeUnit) {
        if (l > 0L) {
            Preconditions.checkNotMainThread((String)"await must not be called on the UI thread when time is greater than zero.");
        }
        boolean bl = this.zal;
        boolean bl2 = true;
        Preconditions.checkState((boolean)(bl ^ true), (Object)"Result has already been consumed.");
        if (this.zap != null) {
            bl2 = false;
        }
        Preconditions.checkState((boolean)bl2, (Object)"Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(l, timeUnit)) {
                this.forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        }
        catch (InterruptedException interruptedException) {
            this.forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState((boolean)this.isReady(), (Object)"Result is not ready.");
        return this.zaa();
    }

    public void cancel() {
        Object object = this.zae;
        synchronized (object) {
            if (this.zam) return;
            if (this.zal) {
                return;
            }
            ICancelToken iCancelToken = this.zao;
            if (iCancelToken != null) {
                try {
                    iCancelToken.cancel();
                }
                catch (RemoteException remoteException) {}
            }
            BasePendingResult.zal(this.zaj);
            this.zam = true;
            this.zab(this.createFailedResult(Status.RESULT_CANCELED));
            return;
        }
    }

    protected abstract R createFailedResult(Status var1);

    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        Object object = this.zae;
        synchronized (object) {
            if (this.isReady()) return;
            this.setResult(this.createFailedResult(status));
            this.zan = true;
            return;
        }
    }

    public final boolean isCanceled() {
        Object object = this.zae;
        synchronized (object) {
            boolean bl = this.zam;
            return bl;
        }
    }

    public final boolean isReady() {
        if (this.zaf.getCount() != 0L) return false;
        return true;
    }

    protected final void setCancelToken(ICancelToken iCancelToken) {
        Object object = this.zae;
        synchronized (object) {
            this.zao = iCancelToken;
            return;
        }
    }

    public final void setResult(R r) {
        Object object = this.zae;
        synchronized (object) {
            if (!this.zan && !this.zam) {
                this.isReady();
                Preconditions.checkState((boolean)(this.isReady() ^ true), (Object)"Results have already been set");
                Preconditions.checkState((boolean)(this.zal ^ true), (Object)"Result has already been consumed");
                this.zab(r);
                return;
            }
            BasePendingResult.zal(r);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        Object object = this.zae;
        synchronized (object) {
            if (resultCallback == null) {
                this.zah = null;
                return;
            }
            boolean bl = this.zal;
            boolean bl2 = true;
            Preconditions.checkState((boolean)(bl ^ true), (Object)"Result has already been consumed.");
            if (this.zap != null) {
                bl2 = false;
            }
            Preconditions.checkState((boolean)bl2, (Object)"Cannot set callbacks if then() has been called.");
            if (this.isCanceled()) {
                return;
            }
            if (this.isReady()) {
                this.zab.zaa(resultCallback, this.zaa());
            } else {
                this.zah = resultCallback;
            }
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long l, TimeUnit timeUnit) {
        Object object = this.zae;
        synchronized (object) {
            if (resultCallback == null) {
                this.zah = null;
                return;
            }
            boolean bl = this.zal;
            boolean bl2 = true;
            Preconditions.checkState((boolean)(bl ^ true), (Object)"Result has already been consumed.");
            if (this.zap != null) {
                bl2 = false;
            }
            Preconditions.checkState((boolean)bl2, (Object)"Cannot set callbacks if then() has been called.");
            if (this.isCanceled()) {
                return;
            }
            if (this.isReady()) {
                this.zab.zaa(resultCallback, this.zaa());
            } else {
                long l2;
                void var4_3;
                this.zah = resultCallback;
                resultCallback = this.zab;
                l2 = var4_3.toMillis(l2);
                resultCallback.sendMessageDelayed(resultCallback.obtainMessage(2, (Object)this), l2);
            }
            return;
        }
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> transformedResult) {
        Preconditions.checkState((boolean)(this.zal ^ true), (Object)"Result has already been consumed.");
        Object object = this.zae;
        synchronized (object) {
            zacv zacv2 = this.zap;
            boolean bl = false;
            boolean bl2 = zacv2 == null;
            Preconditions.checkState((boolean)bl2, (Object)"Cannot call then() twice.");
            bl2 = bl;
            if (this.zah == null) {
                bl2 = true;
            }
            Preconditions.checkState((boolean)bl2, (Object)"Cannot call then() if callbacks are set.");
            Preconditions.checkState((boolean)(this.zam ^ true), (Object)"Cannot call then() if result was canceled.");
            this.zaq = true;
            this.zap = zacv2 = new zacv(this.zac);
            transformedResult = this.zap.then(transformedResult);
            if (this.isReady()) {
                this.zab.zaa(this.zap, this.zaa());
            } else {
                this.zah = this.zap;
            }
            return transformedResult;
        }
    }

    public final boolean zaj() {
        Object object = this.zae;
        synchronized (object) {
            if ((GoogleApiClient)this.zac.get() == null || !this.zaq) {
                this.cancel();
            }
            boolean bl = this.isCanceled();
            return bl;
        }
    }

    public final void zak() {
        boolean bl;
        boolean bl2 = this.zaq;
        boolean bl3 = bl = true;
        if (!bl2) {
            bl3 = zaa.get() != false ? bl : false;
        }
        this.zaq = bl3;
    }

    public final void zan(zacw zacw2) {
        this.zai.set(zacw2);
    }
}
