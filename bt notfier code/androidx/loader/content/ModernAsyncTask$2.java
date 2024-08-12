/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Process
 *  androidx.loader.content.ModernAsyncTask
 *  androidx.loader.content.ModernAsyncTask$WorkerRunnable
 */
package androidx.loader.content;

import android.os.Binder;
import android.os.Process;
import androidx.loader.content.ModernAsyncTask;

class ModernAsyncTask.2
extends ModernAsyncTask.WorkerRunnable<Params, Result> {
    final ModernAsyncTask this$0;

    ModernAsyncTask.2(ModernAsyncTask modernAsyncTask) {
        this.this$0 = modernAsyncTask;
    }

    public Result call() throws Exception {
        Object object;
        this.this$0.mTaskInvoked.set(true);
        Object object2 = object = null;
        try {
            Process.setThreadPriority((int)10);
            object2 = object;
            object2 = object = this.this$0.doInBackground(this.mParams);
            Binder.flushPendingCommands();
        }
        catch (Throwable throwable) {
            try {
                this.this$0.mCancelled.set(true);
                throw throwable;
            }
            catch (Throwable throwable2) {
                this.this$0.postResult(object2);
                throw throwable2;
            }
        }
        this.this$0.postResult(object);
        return object;
    }
}
