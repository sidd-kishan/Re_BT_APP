/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Configuration
 *  androidx.work.Operation
 *  androidx.work.Operation$State
 *  androidx.work.Operation$State$FAILURE
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.OperationImpl
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.Schedulers
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.model.DependencyDao
 *  androidx.work.impl.model.WorkSpecDao
 */
package androidx.work.impl.utils;

import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.AbstractCollection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class CancelWorkRunnable
implements Runnable {
    private final OperationImpl mOperation = new OperationImpl();

    public static CancelWorkRunnable forAll(WorkManagerImpl workManagerImpl) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static CancelWorkRunnable forId(UUID uUID, WorkManagerImpl workManagerImpl) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static CancelWorkRunnable forName(String string, WorkManagerImpl workManagerImpl, boolean bl) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static CancelWorkRunnable forTag(String string, WorkManagerImpl workManagerImpl) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase object, String string) {
        WorkSpecDao workSpecDao = object.workSpecDao();
        DependencyDao dependencyDao = object.dependencyDao();
        object = new LinkedList();
        ((LinkedList)object).add(string);
        while (!((AbstractCollection)object).isEmpty()) {
            string = (String)((LinkedList)object).remove();
            WorkInfo.State state = workSpecDao.getState(string);
            if (state != WorkInfo.State.SUCCEEDED && state != WorkInfo.State.FAILED) {
                workSpecDao.setState(WorkInfo.State.CANCELLED, new String[]{string});
            }
            ((LinkedList)object).addAll(dependencyDao.getDependentWorkIds(string));
        }
    }

    void cancel(WorkManagerImpl object, String string) {
        this.iterativelyCancelWorkAndDependents(object.getWorkDatabase(), string);
        object.getProcessor().stopAndCancelWork(string);
        object = object.getSchedulers().iterator();
        while (object.hasNext()) {
            ((Scheduler)object.next()).cancel(string);
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule((Configuration)workManagerImpl.getConfiguration(), (WorkDatabase)workManagerImpl.getWorkDatabase(), (List)workManagerImpl.getSchedulers());
    }

    @Override
    public void run() {
        try {
            this.runInternal();
            this.mOperation.setState((Operation.State)Operation.SUCCESS);
        }
        catch (Throwable throwable) {
            this.mOperation.setState((Operation.State)new Operation.State.FAILURE(throwable));
        }
    }

    abstract void runInternal();
}
