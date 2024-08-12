/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.utils.CancelWorkRunnable
 */
package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import java.util.UUID;

class CancelWorkRunnable.1
extends CancelWorkRunnable {
    final UUID val$id;
    final WorkManagerImpl val$workManagerImpl;

    CancelWorkRunnable.1(WorkManagerImpl workManagerImpl, UUID uUID) {
        this.val$workManagerImpl = workManagerImpl;
        this.val$id = uUID;
    }

    void runInternal() {
        WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            this.cancel(this.val$workManagerImpl, this.val$id.toString());
            workDatabase.setTransactionSuccessful();
            this.reschedulePendingWorkers(this.val$workManagerImpl);
            return;
        }
        finally {
            workDatabase.endTransaction();
        }
    }
}
