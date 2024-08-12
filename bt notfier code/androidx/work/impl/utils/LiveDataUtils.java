/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MediatorLiveData
 *  androidx.lifecycle.Observer
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class LiveDataUtils {
    private LiveDataUtils() {
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(LiveData<In> liveData, Function<In, Out> function, TaskExecutor taskExecutor) {
        Object object = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, (Observer)new /* Unavailable Anonymous Inner Class!! */);
        return mediatorLiveData;
    }
}
