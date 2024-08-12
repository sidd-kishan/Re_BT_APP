/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskExecutors
 *  com.google.android.gms.tasks.zzaa
 *  com.google.android.gms.tasks.zzab
 *  com.google.android.gms.tasks.zzac
 *  com.google.android.gms.tasks.zzw
 *  com.google.android.gms.tasks.zzx
 *  com.google.android.gms.tasks.zzy
 *  com.google.android.gms.tasks.zzz
 */
package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzaa;
import com.google.android.gms.tasks.zzab;
import com.google.android.gms.tasks.zzac;
import com.google.android.gms.tasks.zzw;
import com.google.android.gms.tasks.zzx;
import com.google.android.gms.tasks.zzy;
import com.google.android.gms.tasks.zzz;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, (Object)"Task must not be null");
        if (task.isComplete()) {
            return Tasks.zza(task);
        }
        zzaa zzaa2 = new zzaa(null);
        Tasks.zzb(task, zzaa2);
        zzaa2.zza();
        return Tasks.zza(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long l, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, (Object)"Task must not be null");
        Preconditions.checkNotNull((Object)((Object)timeUnit), (Object)"TimeUnit must not be null");
        if (task.isComplete()) {
            return Tasks.zza(task);
        }
        zzaa zzaa2 = new zzaa(null);
        Tasks.zzb(task, zzaa2);
        if (!zzaa2.zzb(l, timeUnit)) throw new TimeoutException("Timed out waiting for Task");
        return Tasks.zza(task);
    }

    @Deprecated
    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return Tasks.call(TaskExecutors.MAIN_THREAD, callable);
    }

    @Deprecated
    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        Preconditions.checkNotNull((Object)executor, (Object)"Executor must not be null");
        Preconditions.checkNotNull(callable, (Object)"Callback must not be null");
        zzw zzw2 = new zzw();
        executor.execute((Runnable)new zzx(zzw2, callable));
        return zzw2;
    }

    public static <TResult> Task<TResult> forCanceled() {
        zzw zzw2 = new zzw();
        zzw2.zze();
        return zzw2;
    }

    public static <TResult> Task<TResult> forException(Exception exception) {
        zzw zzw2 = new zzw();
        zzw2.zzc(exception);
        return zzw2;
    }

    public static <TResult> Task<TResult> forResult(TResult TResult) {
        zzw zzw2 = new zzw();
        zzw2.zza(TResult);
        return zzw2;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> object) {
        if (object == null) return Tasks.forResult(null);
        if (object.isEmpty()) {
            return Tasks.forResult(null);
        }
        zzw zzw2 = object.iterator();
        while (zzw2.hasNext()) {
            if (zzw2.next() == null) throw new NullPointerException("null tasks are not accepted");
        }
        zzw2 = new zzw();
        zzac zzac2 = new zzac(object.size(), zzw2);
        object = object.iterator();
        while (object.hasNext()) {
            Tasks.zzb((Task)object.next(), zzac2);
        }
        return zzw2;
    }

    public static Task<Void> whenAll(Task<?> ... taskArray) {
        if (taskArray == null) return Tasks.forResult(null);
        if (taskArray.length != 0) return Tasks.whenAll(Arrays.asList(taskArray));
        return Tasks.forResult(null);
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> zzz2) {
        if (zzz2 == null) return Tasks.forResult(Collections.emptyList());
        if (zzz2.isEmpty()) {
            return Tasks.forResult(Collections.emptyList());
        }
        Task<Void> task = Tasks.whenAll(zzz2);
        zzz2 = new zzz(zzz2);
        return task.continueWithTask(TaskExecutors.MAIN_THREAD, (Continuation)zzz2);
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?> ... taskArray) {
        if (taskArray == null) return Tasks.forResult(Collections.emptyList());
        if (taskArray.length != 0) return Tasks.whenAllComplete(Arrays.asList(taskArray));
        return Tasks.forResult(Collections.emptyList());
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task> zzy2) {
        if (zzy2 == null) return Tasks.forResult(Collections.emptyList());
        if (zzy2.isEmpty()) {
            return Tasks.forResult(Collections.emptyList());
        }
        Task<Void> task = Tasks.whenAll(zzy2);
        zzy2 = new zzy(zzy2);
        return task.continueWith(TaskExecutors.MAIN_THREAD, (Continuation)zzy2);
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task ... taskArray) {
        if (taskArray == null) return Tasks.forResult(Collections.emptyList());
        if (taskArray.length != 0) return Tasks.whenAllSuccess(Arrays.asList(taskArray));
        return Tasks.forResult(Collections.emptyList());
    }

    private static <TResult> TResult zza(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return (TResult)task.getResult();
        }
        if (!task.isCanceled()) throw new ExecutionException(task.getException());
        throw new CancellationException("Task is already canceled");
    }

    private static <T> void zzb(Task<T> task, zzab<? super T> zzab2) {
        task.addOnSuccessListener(TaskExecutors.zza, zzab2);
        task.addOnFailureListener(TaskExecutors.zza, zzab2);
        task.addOnCanceledListener(TaskExecutors.zza, zzab2);
    }
}
