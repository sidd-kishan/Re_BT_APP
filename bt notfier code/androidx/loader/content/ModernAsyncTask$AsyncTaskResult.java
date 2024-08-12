/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.loader.content.ModernAsyncTask
 */
package androidx.loader.content;

import androidx.loader.content.ModernAsyncTask;

private static class ModernAsyncTask.AsyncTaskResult<Data> {
    final Data[] mData;
    final ModernAsyncTask mTask;

    ModernAsyncTask.AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data ... DataArray) {
        this.mTask = modernAsyncTask;
        this.mData = DataArray;
    }
}
