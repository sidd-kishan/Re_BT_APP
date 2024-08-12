/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.executor.GlideExecutor$DefaultThreadFactory
 *  com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy
 *  com.bumptech.glide.load.engine.executor.RuntimeCompat
 */
package com.bumptech.glide.load.engine.executor;

import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.executor.RuntimeCompat;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class GlideExecutor
implements ExecutorService {
    private static final String ANIMATION_EXECUTOR_NAME = "animation";
    private static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    private static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    private static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final long KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10L);
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    GlideExecutor(ExecutorService executorService) {
        this.delegate = executorService;
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount != 0) return bestThreadCount;
        bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
        return bestThreadCount;
    }

    public static GlideExecutor newAnimationExecutor() {
        int n = GlideExecutor.calculateBestThreadCount() >= 4 ? 2 : 1;
        return GlideExecutor.newAnimationExecutor(n, UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newAnimationExecutor(int n, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(0, n, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), (ThreadFactory)new DefaultThreadFactory(ANIMATION_EXECUTOR_NAME, uncaughtThrowableStrategy, true)));
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return GlideExecutor.newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newDiskCacheExecutor(int n, String string, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), (ThreadFactory)new DefaultThreadFactory(string, uncaughtThrowableStrategy, true)));
    }

    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return GlideExecutor.newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, uncaughtThrowableStrategy);
    }

    public static GlideExecutor newSourceExecutor() {
        return GlideExecutor.newSourceExecutor(GlideExecutor.calculateBestThreadCount(), DEFAULT_SOURCE_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT);
    }

    public static GlideExecutor newSourceExecutor(int n, String string, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(), (ThreadFactory)new DefaultThreadFactory(string, uncaughtThrowableStrategy, false)));
    }

    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return GlideExecutor.newSourceExecutor(GlideExecutor.calculateBestThreadCount(), DEFAULT_SOURCE_EXECUTOR_NAME, uncaughtThrowableStrategy);
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), (ThreadFactory)new DefaultThreadFactory(SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(l, timeUnit);
    }

    @Override
    public void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long l, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, l, timeUnit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.delegate.invokeAny(collection);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.invokeAny(collection, l, timeUnit);
    }

    @Override
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    @Override
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    public String toString() {
        return this.delegate.toString();
    }
}
