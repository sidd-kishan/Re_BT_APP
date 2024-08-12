/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkerParameters$RuntimeExtras
 *  androidx.work.impl.WorkManagerImpl
 */
package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;

public class StartWorkRunnable
implements Runnable {
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private WorkManagerImpl mWorkManagerImpl;
    private String mWorkSpecId;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, String string, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = string;
        this.mRuntimeExtras = runtimeExtras;
    }

    @Override
    public void run() {
        this.mWorkManagerImpl.getProcessor().startWork(this.mWorkSpecId, this.mRuntimeExtras);
    }
}
