/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.loader.content.ModernAsyncTask$4
 *  androidx.loader.content.ModernAsyncTask$AsyncTaskResult
 *  androidx.loader.content.ModernAsyncTask$InternalHandler
 *  androidx.loader.content.ModernAsyncTask$Status
 *  androidx.loader.content.ModernAsyncTask$WorkerRunnable
 */
package androidx.loader.content;

import android.os.Handler;
import androidx.loader.content.ModernAsyncTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    final AtomicBoolean mCancelled;
    private final FutureTask<Result> mFuture;
    private volatile Status mStatus = Status.PENDING;
    final AtomicBoolean mTaskInvoked;
    private final WorkerRunnable<Params, Result> mWorker;

    static {
        sThreadFactory = new /* Unavailable Anonymous Inner Class!! */;
        sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
        sDefaultExecutor = threadPoolExecutor;
    }

    ModernAsyncTask() {
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        this.mWorker = new /* Unavailable Anonymous Inner Class!! */;
        this.mFuture = new /* Unavailable Anonymous Inner Class!! */;
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    private static Handler getHandler() {
        synchronized (ModernAsyncTask.class) {
            InternalHandler internalHandler;
            if (sHandler == null) {
                sHandler = internalHandler = new InternalHandler();
            }
            internalHandler = sHandler;
            return internalHandler;
        }
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean bl) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(bl);
    }

    protected abstract Result doInBackground(Params ... var1);

    public final ModernAsyncTask<Params, Progress, Result> execute(Params ... ParamsArray) {
        return this.executeOnExecutor(sDefaultExecutor, ParamsArray);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params ... ParamsArray) {
        if (this.mStatus != Status.PENDING) {
            int n = 4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
            if (n == 1) throw new IllegalStateException("Cannot execute task: the task is already running.");
            if (n == 2) throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            throw new IllegalStateException("We should never reach this state");
        }
        this.mStatus = Status.RUNNING;
        this.onPreExecute();
        this.mWorker.mParams = ParamsArray;
        executor.execute(this.mFuture);
        return this;
    }

    void finish(Result Result) {
        if (this.isCancelled()) {
            this.onCancelled(Result);
        } else {
            this.onPostExecute(Result);
        }
        this.mStatus = Status.FINISHED;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(l, timeUnit);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Result Result) {
        this.onCancelled();
    }

    protected void onPostExecute(Result Result) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Progress ... ProgressArray) {
    }

    Result postResult(Result Result) {
        ModernAsyncTask.getHandler().obtainMessage(1, (Object)new AsyncTaskResult(this, new Object[]{Result})).sendToTarget();
        return Result;
    }

    void postResultIfNotInvoked(Result Result) {
        if (this.mTaskInvoked.get()) return;
        this.postResult(Result);
    }

    protected final void publishProgress(Progress ... ProgressArray) {
        if (this.isCancelled()) return;
        ModernAsyncTask.getHandler().obtainMessage(2, (Object)new AsyncTaskResult(this, (Object[])ProgressArray)).sendToTarget();
    }
}
