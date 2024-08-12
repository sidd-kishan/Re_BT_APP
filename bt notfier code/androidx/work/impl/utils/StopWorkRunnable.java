/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Logger
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.Processor
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.model.WorkSpecDao
 */
package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;

public class StopWorkRunnable
implements Runnable {
    private static final String TAG = Logger.tagWithPrefix((String)"StopWorkRunnable");
    private final boolean mStopInForeground;
    private final WorkManagerImpl mWorkManagerImpl;
    private final String mWorkSpecId;

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, String string, boolean bl) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = string;
        this.mStopInForeground = bl;
    }

    @Override
    public void run() {
        WorkDatabase workDatabase = this.mWorkManagerImpl.getWorkDatabase();
        Processor processor = this.mWorkManagerImpl.getProcessor();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            boolean bl = processor.isEnqueuedInForeground(this.mWorkSpecId);
            if (this.mStopInForeground) {
                bl = this.mWorkManagerImpl.getProcessor().stopForegroundWork(this.mWorkSpecId);
            } else {
                if (!bl && workSpecDao.getState(this.mWorkSpecId) == WorkInfo.State.RUNNING) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, new String[]{this.mWorkSpecId});
                }
                bl = this.mWorkManagerImpl.getProcessor().stopWork(this.mWorkSpecId);
            }
            Logger.get().debug(TAG, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.mWorkSpecId, bl), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            workDatabase.endTransaction();
        }
    }
}
