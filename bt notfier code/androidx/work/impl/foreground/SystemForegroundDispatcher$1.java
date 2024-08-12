/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.foreground.SystemForegroundDispatcher
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl.foreground;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;

class SystemForegroundDispatcher.1
implements Runnable {
    final SystemForegroundDispatcher this$0;
    final WorkDatabase val$database;
    final String val$workSpecId;

    SystemForegroundDispatcher.1(SystemForegroundDispatcher systemForegroundDispatcher, WorkDatabase workDatabase, String string) {
        this.this$0 = systemForegroundDispatcher;
        this.val$database = workDatabase;
        this.val$workSpecId = string;
    }

    @Override
    public void run() {
        WorkSpec workSpec = this.val$database.workSpecDao().getWorkSpec(this.val$workSpecId);
        if (workSpec == null) return;
        if (!workSpec.hasConstraints()) return;
        Object object = this.this$0.mLock;
        synchronized (object) {
            this.this$0.mWorkSpecById.put(this.val$workSpecId, workSpec);
            this.this$0.mTrackedWorkSpecs.add(workSpec);
            this.this$0.mConstraintsTracker.replace((Iterable)this.this$0.mTrackedWorkSpecs);
        }
    }
}
