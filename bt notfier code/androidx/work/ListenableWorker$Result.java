/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.ListenableWorker$Result$Failure
 *  androidx.work.ListenableWorker$Result$Retry
 *  androidx.work.ListenableWorker$Result$Success
 */
package androidx.work;

import androidx.work.Data;
import androidx.work.ListenableWorker;

public static abstract class ListenableWorker.Result {
    ListenableWorker.Result() {
    }

    public static ListenableWorker.Result failure() {
        return new Failure();
    }

    public static ListenableWorker.Result failure(Data data) {
        return new Failure(data);
    }

    public static ListenableWorker.Result retry() {
        return new Retry();
    }

    public static ListenableWorker.Result success() {
        return new Success();
    }

    public static ListenableWorker.Result success(Data data) {
        return new Success(data);
    }

    public abstract Data getOutputData();
}
