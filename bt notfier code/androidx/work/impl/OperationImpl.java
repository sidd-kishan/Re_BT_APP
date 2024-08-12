/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MutableLiveData
 *  androidx.work.Operation
 *  androidx.work.Operation$State
 *  androidx.work.Operation$State$FAILURE
 *  androidx.work.Operation$State$SUCCESS
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public class OperationImpl
implements Operation {
    private final SettableFuture<Operation.State.SUCCESS> mOperationFuture;
    private final MutableLiveData<Operation.State> mOperationState = new MutableLiveData();

    public OperationImpl() {
        this.mOperationFuture = SettableFuture.create();
        this.setState((Operation.State)Operation.IN_PROGRESS);
    }

    public ListenableFuture<Operation.State.SUCCESS> getResult() {
        return this.mOperationFuture;
    }

    public LiveData<Operation.State> getState() {
        return this.mOperationState;
    }

    public void setState(Operation.State state) {
        this.mOperationState.postValue((Object)state);
        if (state instanceof Operation.State.SUCCESS) {
            this.mOperationFuture.set((Object)((Operation.State.SUCCESS)state));
        } else {
            if (!(state instanceof Operation.State.FAILURE)) return;
            state = (Operation.State.FAILURE)state;
            this.mOperationFuture.setException(state.getThrowable());
        }
    }
}
