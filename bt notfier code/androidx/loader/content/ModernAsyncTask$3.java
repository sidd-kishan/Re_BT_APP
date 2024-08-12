/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.loader.content.ModernAsyncTask
 */
package androidx.loader.content;

import android.util.Log;
import androidx.loader.content.ModernAsyncTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class ModernAsyncTask.3
extends FutureTask<Result> {
    final ModernAsyncTask this$0;

    ModernAsyncTask.3(ModernAsyncTask modernAsyncTask, Callable callable) {
        this.this$0 = modernAsyncTask;
        super(callable);
    }

    @Override
    protected void done() {
        try {
            Object v = this.get();
            this.this$0.postResultIfNotInvoked(v);
        }
        catch (Throwable throwable) {
            throw new RuntimeException("An error occurred while executing doInBackground()", throwable);
        }
        catch (CancellationException cancellationException) {
            this.this$0.postResultIfNotInvoked(null);
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException("An error occurred while executing doInBackground()", executionException.getCause());
        }
        catch (InterruptedException interruptedException) {
            Log.w((String)"AsyncTask", (Throwable)interruptedException);
        }
    }
}
