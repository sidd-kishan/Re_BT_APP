/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.lifecycle.MediatorLiveData
 *  androidx.lifecycle.Observer
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

class LiveDataUtils.1
implements Observer<In> {
    Out mCurrentOutput;
    final Object val$lock;
    final Function val$mappingMethod;
    final MediatorLiveData val$outputLiveData;
    final TaskExecutor val$workTaskExecutor;

    LiveDataUtils.1(TaskExecutor taskExecutor, Object object, Function function, MediatorLiveData mediatorLiveData) {
        this.val$workTaskExecutor = taskExecutor;
        this.val$lock = object;
        this.val$mappingMethod = function;
        this.val$outputLiveData = mediatorLiveData;
        this.mCurrentOutput = null;
    }

    public void onChanged(In In) {
        this.val$workTaskExecutor.executeOnBackgroundThread((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
