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

class CancelWorkRunnable.3
extends CancelWorkRunnable {
    final boolean val$allowReschedule;
    final String val$name;
    final WorkManagerImpl val$workManagerImpl;

    CancelWorkRunnable.3(WorkManagerImpl workManagerImpl, String string, boolean bl) {
        this.val$workManagerImpl = workManagerImpl;
        this.val$name = string;
        this.val$allowReschedule = bl;
    }

    void runInternal() {
        WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            for (String string : workDatabase.workSpecDao().getUnfinishedWorkWithName(this.val$name)) {
                this.cancel(this.val$workManagerImpl, string);
            }
            workDatabase.setTransactionSuccessful();
        }
        finally {
            workDatabase.endTransaction();
        }
        if (!this.val$allowReschedule) return;
        this.reschedulePendingWorkers(this.val$workManagerImpl);
    }
}
