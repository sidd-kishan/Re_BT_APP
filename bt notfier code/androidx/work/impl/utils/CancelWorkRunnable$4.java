/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.utils.CancelWorkRunnable
 *  androidx.work.impl.utils.PreferenceUtils
 */
package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.PreferenceUtils;

class CancelWorkRunnable.4
extends CancelWorkRunnable {
    final WorkManagerImpl val$workManagerImpl;

    CancelWorkRunnable.4(WorkManagerImpl workManagerImpl) {
        this.val$workManagerImpl = workManagerImpl;
    }

    void runInternal() {
        WorkDatabase workDatabase = this.val$workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            for (String string : workDatabase.workSpecDao().getAllUnfinishedWork()) {
                this.cancel(this.val$workManagerImpl, string);
            }
            PreferenceUtils preferenceUtils = new PreferenceUtils(this.val$workManagerImpl.getWorkDatabase());
            preferenceUtils.setLastCancelAllTimeMillis(System.currentTimeMillis());
            workDatabase.setTransactionSuccessful();
        }
        finally {
            workDatabase.endTransaction();
        }
    }
}
