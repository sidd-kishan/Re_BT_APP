/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.DuplicateTaskCompletionException
 *  com.google.android.gms.tasks.OnCanceledListener
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.OnFailureListener
 *  com.google.android.gms.tasks.OnSuccessListener
 *  com.google.android.gms.tasks.RuntimeExecutionException
 *  com.google.android.gms.tasks.SuccessContinuation
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskExecutors
 *  com.google.android.gms.tasks.zzd
 *  com.google.android.gms.tasks.zzf
 *  com.google.android.gms.tasks.zzh
 *  com.google.android.gms.tasks.zzj
 *  com.google.android.gms.tasks.zzl
 *  com.google.android.gms.tasks.zzn
 *  com.google.android.gms.tasks.zzp
 *  com.google.android.gms.tasks.zzq
 *  com.google.android.gms.tasks.zzr
 *  com.google.android.gms.tasks.zzv
 */
package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzd;
import com.google.android.gms.tasks.zzf;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzj;
import com.google.android.gms.tasks.zzl;
import com.google.android.gms.tasks.zzn;
import com.google.android.gms.tasks.zzp;
import com.google.android.gms.tasks.zzq;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzv;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class zzw<TResult>
extends Task<TResult> {
    private final Object zza = new Object();
    private final zzr<TResult> zzb = new zzr();
    private boolean zzc;
    private volatile boolean zzd;
    private TResult zze;
    private Exception zzf;

    zzw() {
    }

    private final void zzf() {
        Preconditions.checkState((boolean)this.zzc, (Object)"Task is not yet complete");
    }

    private final void zzg() {
        if (this.zzc) throw DuplicateTaskCompletionException.of((Task)this);
    }

    private final void zzh() {
        if (this.zzd) throw new CancellationException("Task is already canceled.");
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzi() {
        Object object = this.zza;
        synchronized (object) {
            if (!this.zzc) {
                return;
            }
        }
        this.zzb.zzb((Task)this);
    }

    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        onCanceledListener = new zzh(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.zzb.zza((zzq)onCanceledListener);
        zzv.zza((Activity)activity).zzb((zzq)onCanceledListener);
        this.zzi();
        return this;
    }

    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        this.addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
        return this;
    }

    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.zzb.zza((zzq)new zzh(executor, onCanceledListener));
        this.zzi();
        return this;
    }

    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> zzj2) {
        zzj2 = new zzj(TaskExecutors.MAIN_THREAD, zzj2);
        this.zzb.zza((zzq)zzj2);
        zzv.zza((Activity)activity).zzb((zzq)zzj2);
        this.zzi();
        return this;
    }

    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        this.zzb.zza((zzq)new zzj(executor, onCompleteListener));
        this.zzi();
        return this;
    }

    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza((zzq)new zzj(executor, onCompleteListener));
        this.zzi();
        return this;
    }

    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        onFailureListener = new zzl(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzb.zza((zzq)onFailureListener);
        zzv.zza((Activity)activity).zzb((zzq)onFailureListener);
        this.zzi();
        return this;
    }

    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        this.addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.zzb.zza((zzq)new zzl(executor, onFailureListener));
        this.zzi();
        return this;
    }

    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<? super TResult> zzn2) {
        zzn2 = new zzn(TaskExecutors.MAIN_THREAD, zzn2);
        this.zzb.zza((zzq)zzn2);
        zzv.zza((Activity)activity).zzb((zzq)zzn2);
        this.zzi();
        return this;
    }

    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        this.addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzb.zza((zzq)new zzn(executor, onSuccessListener));
        this.zzi();
        return this;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return this.continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        zzw<TResult> zzw2 = new zzw<TResult>();
        this.zzb.zza((zzq)new zzd(executor, continuation, zzw2));
        this.zzi();
        return zzw2;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return this.continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzw<TResult> zzw2 = new zzw<TResult>();
        this.zzb.zza((zzq)new zzf(executor, continuation, zzw2));
        this.zzi();
        return zzw2;
    }

    public final Exception getException() {
        Object object = this.zza;
        synchronized (object) {
            Exception exception = this.zzf;
            return exception;
        }
    }

    public final TResult getResult() {
        Object object = this.zza;
        synchronized (object) {
            this.zzf();
            this.zzh();
            Exception exception = this.zzf;
            if (exception == null) {
                TResult TResult = this.zze;
                return TResult;
            }
            RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException((Throwable)exception);
            throw runtimeExecutionException;
        }
    }

    public final <X extends Throwable> TResult getResult(Class<X> serializable) throws X {
        Object object = this.zza;
        synchronized (object) {
            this.zzf();
            this.zzh();
            if (serializable.isInstance(this.zzf)) throw (Throwable)serializable.cast(this.zzf);
            serializable = this.zzf;
            if (serializable == null) {
                serializable = this.zze;
                return (TResult)serializable;
            }
            RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException(serializable);
            throw runtimeExecutionException;
        }
    }

    public final boolean isCanceled() {
        return this.zzd;
    }

    public final boolean isComplete() {
        Object object = this.zza;
        synchronized (object) {
            boolean bl = this.zzc;
            return bl;
        }
    }

    public final boolean isSuccessful() {
        Object object = this.zza;
        synchronized (object) {
            boolean bl;
            boolean bl2 = this.zzc;
            boolean bl3 = bl = false;
            if (!bl2) return bl3;
            bl3 = bl;
            if (this.zzd) return bl3;
            bl3 = bl;
            if (this.zzf != null) return bl3;
            bl3 = true;
            return bl3;
        }
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        zzw<TResult> zzw2 = new zzw<TResult>();
        this.zzb.zza((zzq)new zzp(executor, successContinuation, zzw2));
        this.zzi();
        return zzw2;
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzw<TResult> zzw2 = new zzw<TResult>();
        this.zzb.zza((zzq)new zzp(executor, successContinuation, zzw2));
        this.zzi();
        return zzw2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(TResult TResult) {
        Object object = this.zza;
        synchronized (object) {
            this.zzg();
            this.zzc = true;
            this.zze = TResult;
        }
        this.zzb.zzb((Task)this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzb(TResult TResult) {
        Object object = this.zza;
        synchronized (object) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zze = TResult;
        }
        this.zzb.zzb((Task)this);
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc(Exception exception) {
        Preconditions.checkNotNull((Object)exception, (Object)"Exception must not be null");
        Object object = this.zza;
        synchronized (object) {
            this.zzg();
            this.zzc = true;
            this.zzf = exception;
        }
        this.zzb.zzb((Task)this);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzd(Exception exception) {
        Preconditions.checkNotNull((Object)exception, (Object)"Exception must not be null");
        Object object = this.zza;
        synchronized (object) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzf = exception;
        }
        this.zzb.zzb((Task)this);
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zze() {
        Object object = this.zza;
        synchronized (object) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzd = true;
        }
        this.zzb.zzb((Task)this);
        return true;
    }
}
