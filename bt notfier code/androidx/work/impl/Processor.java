/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager$WakeLock
 *  androidx.core.content.ContextCompat
 *  androidx.work.Configuration
 *  androidx.work.ForegroundInfo
 *  androidx.work.Logger
 *  androidx.work.WorkerParameters$RuntimeExtras
 *  androidx.work.impl.ExecutionListener
 *  androidx.work.impl.Processor$FutureListener
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkerWrapper
 *  androidx.work.impl.WorkerWrapper$Builder
 *  androidx.work.impl.foreground.ForegroundProcessor
 *  androidx.work.impl.foreground.SystemForegroundDispatcher
 *  androidx.work.impl.utils.WakeLocks
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Processor
implements ExecutionListener,
ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix((String)"Processor");
    private Context mAppContext;
    private Set<String> mCancelledIds;
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap;
    private PowerManager.WakeLock mForegroundLock;
    private Map<String, WorkerWrapper> mForegroundWorkMap;
    private final Object mLock;
    private final List<ExecutionListener> mOuterListeners;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mEnqueuedWorkMap = new HashMap<String, WorkerWrapper>();
        this.mForegroundWorkMap = new HashMap<String, WorkerWrapper>();
        this.mSchedulers = list;
        this.mCancelledIds = new HashSet<String>();
        this.mOuterListeners = new ArrayList<ExecutionListener>();
        this.mForegroundLock = null;
        this.mLock = new Object();
    }

    private static boolean interrupt(String string, WorkerWrapper workerWrapper) {
        if (workerWrapper != null) {
            workerWrapper.interrupt();
            Logger.get().debug(TAG, String.format("WorkerWrapper interrupted for %s", string), new Throwable[0]);
            return true;
        }
        Logger.get().debug(TAG, String.format("WorkerWrapper could not be found for %s", string), new Throwable[0]);
        return false;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void stopForegroundService() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mForegroundWorkMap.isEmpty() ^ true) return;
            Intent intent = SystemForegroundDispatcher.createStopForegroundIntent((Context)this.mAppContext);
            try {
                this.mAppContext.startService(intent);
            }
            catch (Throwable throwable) {
                Logger.get().error(TAG, "Unable to stop foreground service", new Throwable[]{throwable});
            }
            if (this.mForegroundLock == null) return;
            this.mForegroundLock.release();
            this.mForegroundLock = null;
            return;
        }
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        Object object = this.mLock;
        synchronized (object) {
            this.mOuterListeners.add(executionListener);
            return;
        }
    }

    public boolean hasWork() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = !this.mEnqueuedWorkMap.isEmpty() || !this.mForegroundWorkMap.isEmpty();
            return bl;
        }
    }

    public boolean isCancelled(String string) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = this.mCancelledIds.contains(string);
            return bl;
        }
    }

    public boolean isEnqueued(String string) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = this.mEnqueuedWorkMap.containsKey(string) || this.mForegroundWorkMap.containsKey(string);
            return bl;
        }
    }

    public boolean isEnqueuedInForeground(String string) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = this.mForegroundWorkMap.containsKey(string);
            return bl;
        }
    }

    public void onExecuted(String string, boolean bl) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                this.mEnqueuedWorkMap.remove(string);
                Logger.get().debug(TAG, String.format("%s %s executed; reschedule = %s", this.getClass().getSimpleName(), string, bl), new Throwable[0]);
                Iterator<ExecutionListener> iterator = this.mOuterListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().onExecuted(string, bl);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        Object object = this.mLock;
        synchronized (object) {
            this.mOuterListeners.remove(executionListener);
            return;
        }
    }

    public void startForeground(String string, ForegroundInfo foregroundInfo) {
        Object object = this.mLock;
        synchronized (object) {
            Logger.get().info(TAG, String.format("Moving WorkSpec (%s) to the foreground", string), new Throwable[0]);
            WorkerWrapper workerWrapper = this.mEnqueuedWorkMap.remove(string);
            if (workerWrapper == null) return;
            if (this.mForegroundLock == null) {
                PowerManager.WakeLock wakeLock;
                this.mForegroundLock = wakeLock = WakeLocks.newWakeLock((Context)this.mAppContext, (String)FOREGROUND_WAKELOCK_TAG);
                wakeLock.acquire();
            }
            this.mForegroundWorkMap.put(string, workerWrapper);
            string = SystemForegroundDispatcher.createStartForegroundIntent((Context)this.mAppContext, (String)string, (ForegroundInfo)foregroundInfo);
            ContextCompat.startForegroundService((Context)this.mAppContext, (Intent)string);
            return;
        }
    }

    public boolean startWork(String string) {
        return this.startWork(string, null);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean startWork(String string, WorkerParameters.RuntimeExtras runtimeExtras) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.isEnqueued(string)) {
                Logger.get().debug(TAG, String.format("Work %s is already enqueued for processing", string), new Throwable[0]);
                return false;
            }
            Object object2 = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, (ForegroundProcessor)this, this.mWorkDatabase, string);
            runtimeExtras = object2.withSchedulers(this.mSchedulers).withRuntimeExtras(runtimeExtras).build();
            object2 = runtimeExtras.getFuture();
            FutureListener futureListener = new FutureListener((ExecutionListener)this, string, (ListenableFuture)object2);
            object2.addListener((Runnable)futureListener, this.mWorkTaskExecutor.getMainThreadExecutor());
            this.mEnqueuedWorkMap.put(string, (WorkerWrapper)runtimeExtras);
        }
        this.mWorkTaskExecutor.getBackgroundExecutor().execute((Runnable)runtimeExtras);
        Logger.get().debug(TAG, String.format("%s: processing %s", this.getClass().getSimpleName(), string), new Throwable[0]);
        return true;
    }

    public boolean stopAndCancelWork(String string) {
        Object object = this.mLock;
        synchronized (object) {
            Logger logger = Logger.get();
            String string2 = TAG;
            boolean bl = true;
            logger.debug(string2, String.format("Processor cancelling %s", string), new Throwable[0]);
            this.mCancelledIds.add(string);
            logger = this.mForegroundWorkMap.remove(string);
            if (logger == null) {
                bl = false;
            }
            string2 = logger;
            if (logger == null) {
                string2 = this.mEnqueuedWorkMap.remove(string);
            }
            boolean bl2 = Processor.interrupt(string, (WorkerWrapper)string2);
            if (!bl) return bl2;
            this.stopForegroundService();
            return bl2;
        }
    }

    public void stopForeground(String string) {
        Object object = this.mLock;
        synchronized (object) {
            this.mForegroundWorkMap.remove(string);
            this.stopForegroundService();
            return;
        }
    }

    public boolean stopForegroundWork(String string) {
        Object object = this.mLock;
        synchronized (object) {
            Logger.get().debug(TAG, String.format("Processor stopping foreground work %s", string), new Throwable[0]);
            boolean bl = Processor.interrupt(string, this.mForegroundWorkMap.remove(string));
            return bl;
        }
    }

    public boolean stopWork(String string) {
        Object object = this.mLock;
        synchronized (object) {
            Logger.get().debug(TAG, String.format("Processor stopping background work %s", string), new Throwable[0]);
            boolean bl = Processor.interrupt(string, this.mEnqueuedWorkMap.remove(string));
            return bl;
        }
    }
}
