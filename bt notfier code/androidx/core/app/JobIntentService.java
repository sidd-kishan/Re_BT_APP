/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  androidx.core.app.JobIntentService$CommandProcessor
 *  androidx.core.app.JobIntentService$CompatJobEngine
 *  androidx.core.app.JobIntentService$CompatWorkEnqueuer
 *  androidx.core.app.JobIntentService$CompatWorkItem
 *  androidx.core.app.JobIntentService$GenericWorkItem
 *  androidx.core.app.JobIntentService$JobServiceEngineImpl
 *  androidx.core.app.JobIntentService$JobWorkEnqueuer
 *  androidx.core.app.JobIntentService$WorkEnqueuer
 */
package androidx.core.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.JobIntentService;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService
extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    static final HashMap<ComponentName, WorkEnqueuer> sClassWorkEnqueuer;
    static final Object sLock;
    final ArrayList<CompatWorkItem> mCompatQueue = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList();
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    boolean mDestroyed = false;
    boolean mInterruptIfStopped = false;
    CompatJobEngine mJobImpl;
    boolean mStopped = false;

    static {
        sLock = new Object();
        sClassWorkEnqueuer = new HashMap();
    }

    public static void enqueueWork(Context context, ComponentName componentName, int n, Intent intent) {
        if (intent == null) throw new IllegalArgumentException("work must not be null");
        Object object = sLock;
        synchronized (object) {
            context = JobIntentService.getWorkEnqueuer(context, componentName, true, n);
            context.ensureJobId(n);
            context.enqueueWork(intent);
            return;
        }
    }

    public static void enqueueWork(Context context, Class<?> clazz, int n, Intent intent) {
        JobIntentService.enqueueWork(context, new ComponentName(context, clazz), n, intent);
    }

    static WorkEnqueuer getWorkEnqueuer(Context context, ComponentName componentName, boolean bl, int n) {
        WorkEnqueuer workEnqueuer;
        WorkEnqueuer workEnqueuer2 = workEnqueuer = sClassWorkEnqueuer.get(componentName);
        if (workEnqueuer != null) return workEnqueuer2;
        if (Build.VERSION.SDK_INT >= 26) {
            if (!bl) throw new IllegalArgumentException("Can't be here without a job id");
            context = new JobWorkEnqueuer(context, componentName, n);
        } else {
            context = new CompatWorkEnqueuer(context, componentName);
        }
        sClassWorkEnqueuer.put(componentName, (WorkEnqueuer)context);
        workEnqueuer2 = context;
        return workEnqueuer2;
    }

    GenericWorkItem dequeueWork() {
        Object object = this.mJobImpl;
        if (object != null) {
            return object.dequeueWork();
        }
        object = this.mCompatQueue;
        synchronized (object) {
            if (this.mCompatQueue.size() <= 0) return null;
            GenericWorkItem genericWorkItem = (GenericWorkItem)this.mCompatQueue.remove(0);
            return genericWorkItem;
        }
    }

    boolean doStopCurrentWork() {
        CommandProcessor commandProcessor = this.mCurProcessor;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return this.onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean bl) {
        if (this.mCurProcessor != null) return;
        this.mCurProcessor = new CommandProcessor(this);
        WorkEnqueuer workEnqueuer = this.mCompatWorkEnqueuer;
        if (workEnqueuer != null && bl) {
            workEnqueuer.serviceProcessingStarted();
        }
        this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public IBinder onBind(Intent intent) {
        intent = this.mJobImpl;
        if (intent == null) return null;
        return intent.compatGetBinder();
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.mJobImpl = new JobServiceEngineImpl(this);
            this.mCompatWorkEnqueuer = null;
        } else {
            this.mJobImpl = null;
            this.mCompatWorkEnqueuer = JobIntentService.getWorkEnqueuer((Context)this, new ComponentName((Context)this, ((Object)((Object)this)).getClass()), false, 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList == null) return;
        synchronized (arrayList) {
            this.mDestroyed = true;
            this.mCompatWorkEnqueuer.serviceProcessingFinished();
        }
    }

    protected abstract void onHandleWork(Intent var1);

    public int onStartCommand(Intent intent, int n, int n2) {
        if (this.mCompatQueue == null) return 2;
        this.mCompatWorkEnqueuer.serviceStartReceived();
        ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
        synchronized (arrayList) {
            ArrayList<CompatWorkItem> arrayList2 = this.mCompatQueue;
            if (intent == null) {
                intent = new Intent();
            }
            CompatWorkItem compatWorkItem = new CompatWorkItem(this, intent, n2);
            arrayList2.add(compatWorkItem);
            this.ensureProcessorRunningLocked(true);
            return 3;
        }
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    void processorFinished() {
        ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList == null) return;
        synchronized (arrayList) {
            this.mCurProcessor = null;
            if (this.mCompatQueue != null && this.mCompatQueue.size() > 0) {
                this.ensureProcessorRunningLocked(false);
            } else {
                if (this.mDestroyed) return;
                this.mCompatWorkEnqueuer.serviceProcessingFinished();
            }
        }
    }

    public void setInterruptIfStopped(boolean bl) {
        this.mInterruptIfStopped = bl;
    }
}
