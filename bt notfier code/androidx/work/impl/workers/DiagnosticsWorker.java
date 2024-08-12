/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.Logger
 *  androidx.work.Worker
 *  androidx.work.WorkerParameters
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.model.SystemIdInfoDao
 *  androidx.work.impl.model.WorkNameDao
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.model.WorkTagDao
 */
package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTagDao;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker
extends Worker {
    private static final String TAG = Logger.tagWithPrefix((String)"DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String workSpecRow(WorkSpec workSpec, String string, Integer n, String string2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", workSpec.id, workSpec.workerClassName, n, workSpec.state.name(), string, string2);
    }

    private static String workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> object) {
        StringBuilder stringBuilder = new StringBuilder();
        String string = Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id";
        stringBuilder.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", string));
        Iterator<WorkSpec> iterator = object.iterator();
        while (iterator.hasNext()) {
            string = iterator.next();
            object = null;
            Object object2 = systemIdInfoDao.getSystemIdInfo(((WorkSpec)string).id);
            if (object2 != null) {
                object = object2.systemId;
            }
            object2 = workNameDao.getNamesForWorkSpecId(((WorkSpec)string).id);
            List list = workTagDao.getTagsForWorkSpecId(((WorkSpec)string).id);
            stringBuilder.append(DiagnosticsWorker.workSpecRow((WorkSpec)string, TextUtils.join((CharSequence)",", (Iterable)object2), (Integer)object, TextUtils.join((CharSequence)",", (Iterable)list)));
        }
        return stringBuilder.toString();
    }

    public ListenableWorker.Result doWork() {
        WorkDatabase workDatabase = WorkManagerImpl.getInstance((Context)this.getApplicationContext()).getWorkDatabase();
        Object object = workDatabase.workSpecDao();
        WorkNameDao workNameDao = workDatabase.workNameDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        workDatabase = workDatabase.systemIdInfoDao();
        List list = object.getRecentlyCompletedWork(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List list2 = object.getRunningWork();
        object = object.getAllEligibleWorkSpecsForScheduling(200);
        if (list != null && !list.isEmpty()) {
            Logger.get().info(TAG, "Recently completed work:\n\n", new Throwable[0]);
            Logger.get().info(TAG, DiagnosticsWorker.workSpecRows(workNameDao, workTagDao, (SystemIdInfoDao)workDatabase, list), new Throwable[0]);
        }
        if (list2 != null && !list2.isEmpty()) {
            Logger.get().info(TAG, "Running work:\n\n", new Throwable[0]);
            Logger.get().info(TAG, DiagnosticsWorker.workSpecRows(workNameDao, workTagDao, (SystemIdInfoDao)workDatabase, list2), new Throwable[0]);
        }
        if (object == null) return ListenableWorker.Result.success();
        if (object.isEmpty()) return ListenableWorker.Result.success();
        Logger.get().info(TAG, "Enqueued work:\n\n", new Throwable[0]);
        Logger.get().info(TAG, DiagnosticsWorker.workSpecRows(workNameDao, workTagDao, (SystemIdInfoDao)workDatabase, (List<WorkSpec>)object), new Throwable[0]);
        return ListenableWorker.Result.success();
    }
}
