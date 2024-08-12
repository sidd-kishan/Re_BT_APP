/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 *  androidx.camera.core.impl.utils.futures.FutureChain
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ChainingListenableFuture<I, O>
extends FutureChain<O>
implements Runnable {
    private AsyncFunction<? super I, ? extends O> mFunction;
    private ListenableFuture<? extends I> mInputFuture;
    private final BlockingQueue<Boolean> mMayInterruptIfRunningChannel = new LinkedBlockingQueue<Boolean>(1);
    private final CountDownLatch mOutputCreated = new CountDownLatch(1);
    volatile ListenableFuture<? extends O> mOutputFuture;

    ChainingListenableFuture(AsyncFunction<? super I, ? extends O> asyncFunction, ListenableFuture<? extends I> listenableFuture) {
        this.mFunction = (AsyncFunction)Preconditions.checkNotNull(asyncFunction);
        this.mInputFuture = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }

    private void cancel(Future<?> future, boolean bl) {
        if (future == null) return;
        future.cancel(bl);
    }

    private <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e) {
        boolean bl = false;
        while (true) {
            try {
                blockingQueue.put(e);
                if (!bl) return;
                Thread.currentThread().interrupt();
                return;
            }
            catch (Throwable throwable) {
                if (!bl) throw throwable;
                Thread.currentThread().interrupt();
                throw throwable;
            }
            catch (InterruptedException interruptedException) {
                bl = true;
                continue;
            }
            break;
        }
    }

    private <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        E e;
        boolean bl = false;
        while (true) {
            try {
                e = blockingQueue.take();
                if (!bl) return e;
                Thread.currentThread().interrupt();
            }
            catch (Throwable throwable) {
                if (!bl) throw throwable;
                Thread.currentThread().interrupt();
                throw throwable;
            }
            catch (InterruptedException interruptedException) {
                bl = true;
                continue;
            }
            break;
        }
        return e;
    }

    public boolean cancel(boolean bl) {
        if (!super.cancel(bl)) return false;
        this.putUninterruptibly(this.mMayInterruptIfRunningChannel, bl);
        this.cancel(this.mInputFuture, bl);
        this.cancel(this.mOutputFuture, bl);
        return true;
    }

    public O get() throws InterruptedException, ExecutionException {
        if (this.isDone()) return (O)super.get();
        ListenableFuture<I> listenableFuture = this.mInputFuture;
        if (listenableFuture != null) {
            listenableFuture.get();
        }
        this.mOutputCreated.await();
        listenableFuture = this.mOutputFuture;
        if (listenableFuture == null) return (O)super.get();
        listenableFuture.get();
        return (O)super.get();
    }

    public O get(long l, TimeUnit object) throws TimeoutException, ExecutionException, InterruptedException {
        long l2 = l;
        TimeUnit timeUnit = object;
        if (this.isDone()) return (O)super.get(l2, timeUnit);
        l2 = l;
        TimeUnit timeUnit2 = object;
        if (object != TimeUnit.NANOSECONDS) {
            l2 = TimeUnit.NANOSECONDS.convert(l, (TimeUnit)((Object)object));
            timeUnit2 = TimeUnit.NANOSECONDS;
        }
        object = this.mInputFuture;
        l = l2;
        if (object != null) {
            l = System.nanoTime();
            object.get(l2, timeUnit2);
            l = l2 - Math.max(0L, System.nanoTime() - l);
        }
        l2 = System.nanoTime();
        if (!this.mOutputCreated.await(l, timeUnit2)) throw new TimeoutException();
        l -= Math.max(0L, System.nanoTime() - l2);
        object = this.mOutputFuture;
        l2 = l;
        timeUnit = timeUnit2;
        if (object == null) return (O)super.get(l2, timeUnit);
        object.get(l, timeUnit2);
        l2 = l;
        timeUnit = timeUnit2;
        return (O)super.get(l2, timeUnit);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        block15: {
            block14: {
                block16: {
                    try {
                        block17: {
                            block13: {
                                try {
                                    var1_1 = Futures.getUninterruptibly(this.mInputFuture);
                                }
                                catch (ExecutionException var1_6) {
                                    this.setException(var1_6.getCause());
                                    break block13;
                                }
                                catch (CancellationException var1_7) {
                                    this.cancel(false);
                                    break block13;
                                }
                                this.mOutputFuture = var1_1 = this.mFunction.apply(var1_1);
                                if (!this.isCancelled()) break block17;
                                var1_1.cancel(this.takeUninterruptibly(this.mMayInterruptIfRunningChannel));
                                this.mOutputFuture = null;
                            }
                            this.mFunction = null;
                            this.mInputFuture = null;
                            this.mOutputCreated.countDown();
                            return;
                        }
                        var2_8 = new /* Unavailable Anonymous Inner Class!! */;
                        var1_1.addListener((Runnable)var2_8, CameraXExecutors.directExecutor());
                        break block14;
                    }
                    catch (Throwable var1_2) {
                        break block15;
                    }
                    catch (Error var1_3) {
                    }
                    catch (Exception var1_4) {
                        break block16;
                    }
                    catch (UndeclaredThrowableException var1_5) {
                        ** GOTO lbl-1000
                    }
                    this.setException(var1_3);
                    break block14;
                }
                this.setException(var1_4);
                break block14;
lbl-1000:
                // 1 sources

                {
                    this.setException(var1_5.getCause());
                }
            }
            this.mFunction = null;
            this.mInputFuture = null;
            this.mOutputCreated.countDown();
            return;
        }
        this.mFunction = null;
        this.mInputFuture = null;
        this.mOutputCreated.countDown();
        throw var1_2;
    }
}
