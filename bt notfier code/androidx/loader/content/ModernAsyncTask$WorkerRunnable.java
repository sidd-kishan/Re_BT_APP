/*
 * Decompiled with CFR 0.152.
 */
package androidx.loader.content;

import java.util.concurrent.Callable;

private static abstract class ModernAsyncTask.WorkerRunnable<Params, Result>
implements Callable<Result> {
    Params[] mParams;

    ModernAsyncTask.WorkerRunnable() {
    }
}
