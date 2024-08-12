/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.ListenableWorker
 *  androidx.work.Logger
 *  androidx.work.WorkerParameters
 */
package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;

public abstract class WorkerFactory {
    private static final String TAG = Logger.tagWithPrefix((String)"WorkerFactory");

    public static WorkerFactory getDefaultWorkerFactory() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public abstract ListenableWorker createWorker(Context var1, String var2, WorkerParameters var3);

    public final ListenableWorker createWorkerWithDefaultFallback(Context context, String string, WorkerParameters workerParameters) {
        ListenableWorker listenableWorker = this.createWorker(context, string, workerParameters);
        Object object = listenableWorker;
        if (listenableWorker == null) {
            Object object2 = null;
            try {
                object = Class.forName(string).asSubclass(ListenableWorker.class);
                object2 = object;
            }
            catch (Throwable throwable) {
                Logger logger = Logger.get();
                String string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid class: ");
                stringBuilder.append(string);
                logger.error(string2, stringBuilder.toString(), new Throwable[]{throwable});
            }
            object = listenableWorker;
            if (object2 != null) {
                try {
                    object = (ListenableWorker)object2.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                }
                catch (Throwable throwable) {
                    workerParameters = Logger.get();
                    object2 = TAG;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Could not instantiate ");
                    ((StringBuilder)object).append(string);
                    workerParameters.error((String)object2, ((StringBuilder)object).toString(), new Throwable[]{throwable});
                    object = listenableWorker;
                }
            }
        }
        if (object == null) return object;
        if (object.isUsed()) throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", this.getClass().getName(), string));
        return object;
    }
}
