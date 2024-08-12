/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.work.Operation$State
 *  androidx.work.Operation$State$IN_PROGRESS
 *  androidx.work.Operation$State$SUCCESS
 */
package androidx.work;

import androidx.lifecycle.LiveData;
import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;

public interface Operation {
    public static final State.IN_PROGRESS IN_PROGRESS;
    public static final State.SUCCESS SUCCESS;

    static {
        SUCCESS = new State.SUCCESS(null);
        IN_PROGRESS = new State.IN_PROGRESS(null);
    }

    public ListenableFuture<State.SUCCESS> getResult();

    public LiveData<State> getState();
}
