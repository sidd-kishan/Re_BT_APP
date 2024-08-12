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

class CancelWorkRunnable.2
extends CancelWorkRunnable {
    final String val$tag;
    final WorkManagerImpl val$workManagerImpl;

    CancelWorkRunnable.2(WorkManagerImpl workManagerImpl, String string) {
        this.val$workManagerImpl = workManagerImpl;
        this.val$tag = string;
    }

    void runInternal() {
        WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            for (String string : workDatabase.workSpecDao().getUnfinishedWorkWithTag(this.val$tag)) {
                this.cancel(this.val$workManagerImpl, string);
            }
            workDatabase.setTransactionSuccessful();
        }
        finally {
            workDatabase.endTransaction();
        }
        this.reschedulePendingWorkers(this.val$workManagerImpl);
    }
}
