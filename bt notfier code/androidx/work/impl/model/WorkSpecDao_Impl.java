/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.collection.ArrayMap
 *  androidx.lifecycle.LiveData
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.InvalidationTracker
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomSQLiteQuery
 *  androidx.room.SharedSQLiteStatement
 *  androidx.room.util.CursorUtil
 *  androidx.room.util.DBUtil
 *  androidx.room.util.StringUtil
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.Constraints
 *  androidx.work.Data
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.model.WorkSpec$IdAndState
 *  androidx.work.impl.model.WorkSpec$WorkInfoPojo
 *  androidx.work.impl.model.WorkSpecDao
 *  androidx.work.impl.model.WorkTypeConverters
 */
package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class WorkSpecDao_Impl
implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetPeriodStartTime;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfDelete = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfSetOutput = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfSetPeriodStartTime = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfMarkWorkSpecScheduled = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfResetScheduledState = new /* Unavailable Anonymous Inner Class!! */;
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new /* Unavailable Anonymous Inner Class!! */;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> arrayMap) {
        Object object = arrayMap.keySet();
        if (object.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            ArrayMap arrayMap2 = new ArrayMap(999);
            int n = arrayMap.size();
            int n2 = 0;
            while (true) {
                int n3;
                int n4 = 0;
                int n5 = n2;
                do {
                    if (n5 >= n) {
                        if (n4 <= 0) return;
                        this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap2);
                        return;
                    }
                    arrayMap2.put((Object)((String)arrayMap.keyAt(n5)), (Object)((ArrayList)arrayMap.valueAt(n5)));
                    n2 = n5 + 1;
                    n3 = n4 + 1;
                    n5 = n2;
                    n4 = n3;
                } while (n3 != 999);
                this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap2);
                arrayMap2 = new ArrayMap(999);
            }
        }
        StringBuilder stringBuilder = StringUtil.newStringBuilder();
        stringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)stringBuilder, (int)n);
        stringBuilder.append(")");
        stringBuilder = RoomSQLiteQuery.acquire((String)stringBuilder.toString(), (int)(n + 0));
        object = object.iterator();
        n = 1;
        while (object.hasNext()) {
            String string = (String)object.next();
            if (string == null) {
                stringBuilder.bindNull(n);
            } else {
                stringBuilder.bindString(n, string);
            }
            ++n;
        }
        stringBuilder = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)stringBuilder, (boolean)false, null);
        try {
            n = CursorUtil.getColumnIndex((Cursor)stringBuilder, (String)"work_spec_id");
            if (n == -1) {
                return;
            }
            while (stringBuilder.moveToNext()) {
                if (stringBuilder.isNull(n) || (object = (ArrayList)arrayMap.get((Object)stringBuilder.getString(n))) == null) continue;
                ((ArrayList)object).add(Data.fromByteArray((byte[])stringBuilder.getBlob(0)));
            }
            return;
        }
        finally {
            stringBuilder.close();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> arrayMap) {
        Object object = arrayMap.keySet();
        if (object.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            ArrayMap arrayMap2 = new ArrayMap(999);
            int n = arrayMap.size();
            int n2 = 0;
            while (true) {
                int n3;
                int n4 = 0;
                int n5 = n2;
                do {
                    if (n5 >= n) {
                        if (n4 <= 0) return;
                        this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap2);
                        return;
                    }
                    arrayMap2.put((Object)((String)arrayMap.keyAt(n5)), (Object)((ArrayList)arrayMap.valueAt(n5)));
                    n2 = n5 + 1;
                    n3 = n4 + 1;
                    n5 = n2;
                    n4 = n3;
                } while (n3 != 999);
                this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap2);
                arrayMap2 = new ArrayMap(999);
            }
        }
        StringBuilder stringBuilder = StringUtil.newStringBuilder();
        stringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)stringBuilder, (int)n);
        stringBuilder.append(")");
        stringBuilder = RoomSQLiteQuery.acquire((String)stringBuilder.toString(), (int)(n + 0));
        object = object.iterator();
        n = 1;
        while (object.hasNext()) {
            String string = (String)object.next();
            if (string == null) {
                stringBuilder.bindNull(n);
            } else {
                stringBuilder.bindString(n, string);
            }
            ++n;
        }
        stringBuilder = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)stringBuilder, (boolean)false, null);
        try {
            n = CursorUtil.getColumnIndex((Cursor)stringBuilder, (String)"work_spec_id");
            if (n == -1) {
                return;
            }
            while (stringBuilder.moveToNext()) {
                if (stringBuilder.isNull(n) || (object = (ArrayList)arrayMap.get((Object)stringBuilder.getString(n))) == null) continue;
                ((ArrayList)object).add(stringBuilder.getString(0));
            }
            return;
        }
        finally {
            stringBuilder.close();
        }
    }

    static /* synthetic */ RoomDatabase access$000(WorkSpecDao_Impl workSpecDao_Impl) {
        return workSpecDao_Impl.__db;
    }

    static /* synthetic */ void access$100(WorkSpecDao_Impl workSpecDao_Impl, ArrayMap arrayMap) {
        workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap);
    }

    static /* synthetic */ void access$200(WorkSpecDao_Impl workSpecDao_Impl, ArrayMap arrayMap) {
        workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap);
    }

    public void delete(String string) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDelete.acquire();
        if (string == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(supportSQLiteStatement);
        }
    }

    /*
     * WARNING - void declaration
     */
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int n) {
        void var28_34;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block5: {
            ArrayList<WorkSpec> arrayList;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", (int)1);
            roomSQLiteQuery.bindLong(1, (long)n);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
            try {
                n15 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"required_network_type");
                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_charging");
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_device_idle");
                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_battery_not_low");
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_storage_not_low");
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_content_update_delay");
                n9 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_max_content_delay");
                n8 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"content_uri_triggers");
                n7 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
                n6 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
                n5 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"worker_class_name");
                n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input_merger_class_name");
                n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input");
                n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"initial_delay");
                int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"interval_duration");
                int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"flex_duration");
                int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
                n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_policy");
                int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_delay_duration");
                int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"period_start_time");
                int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"minimum_retention_duration");
                int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"schedule_requested_at");
                int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_in_foreground");
                int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n7);
                    String string2 = cursor.getString(n5);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType((int)cursor.getInt(n15)));
                    boolean bl = cursor.getInt(n14) != 0;
                    constraints.setRequiresCharging(bl);
                    bl = cursor.getInt(n13) != 0;
                    constraints.setRequiresDeviceIdle(bl);
                    bl = cursor.getInt(n12) != 0;
                    constraints.setRequiresBatteryNotLow(bl);
                    bl = cursor.getInt(n11) != 0;
                    constraints.setRequiresStorageNotLow(bl);
                    constraints.setTriggerContentUpdateDelay(cursor.getLong(n10));
                    constraints.setTriggerMaxContentDelay(cursor.getLong(n9));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers((byte[])cursor.getBlob(n8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState((int)cursor.getInt(n6));
                    workSpec.inputMergerClassName = cursor.getString(n4);
                    workSpec.input = Data.fromByteArray((byte[])cursor.getBlob(n3));
                    workSpec.output = Data.fromByteArray((byte[])cursor.getBlob(n2));
                    workSpec.initialDelay = cursor.getLong(n16);
                    workSpec.intervalDuration = cursor.getLong(n17);
                    workSpec.flexDuration = cursor.getLong(n18);
                    workSpec.runAttemptCount = cursor.getInt(n19);
                    int n26 = cursor.getInt(n);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy((int)n26);
                    workSpec.backoffDelayDuration = cursor.getLong(n20);
                    workSpec.periodStartTime = cursor.getLong(n21);
                    workSpec.minimumRetentionDuration = cursor.getLong(n22);
                    workSpec.scheduleRequestedAt = cursor.getLong(n23);
                    bl = cursor.getInt(n24) != 0;
                    workSpec.expedited = bl;
                    n26 = cursor.getInt(n25);
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int)n26);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var28_34;
    }

    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", (int)0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id FROM workspec", (int)0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
            }
            return arrayList;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id FROM workspec", (int)0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        roomSQLiteQuery = new /* Unavailable Anonymous Inner Class!! */;
        return invalidationTracker.createLiveData(new String[]{"workspec"}, true, (Callable)roomSQLiteQuery);
    }

    /*
     * WARNING - void declaration
     */
    public List<WorkSpec> getEligibleWorkForScheduling(int n) {
        void var28_34;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block5: {
            ArrayList<WorkSpec> arrayList;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", (int)1);
            roomSQLiteQuery.bindLong(1, (long)n);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
            try {
                n15 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"required_network_type");
                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_charging");
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_device_idle");
                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_battery_not_low");
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_storage_not_low");
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_content_update_delay");
                n9 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_max_content_delay");
                n8 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"content_uri_triggers");
                n7 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
                n6 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
                n5 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"worker_class_name");
                n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input_merger_class_name");
                n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input");
                n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"initial_delay");
                int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"interval_duration");
                int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"flex_duration");
                int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
                n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_policy");
                int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_delay_duration");
                int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"period_start_time");
                int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"minimum_retention_duration");
                int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"schedule_requested_at");
                int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_in_foreground");
                int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n7);
                    String string2 = cursor.getString(n5);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType((int)cursor.getInt(n15)));
                    boolean bl = cursor.getInt(n14) != 0;
                    constraints.setRequiresCharging(bl);
                    bl = cursor.getInt(n13) != 0;
                    constraints.setRequiresDeviceIdle(bl);
                    bl = cursor.getInt(n12) != 0;
                    constraints.setRequiresBatteryNotLow(bl);
                    bl = cursor.getInt(n11) != 0;
                    constraints.setRequiresStorageNotLow(bl);
                    constraints.setTriggerContentUpdateDelay(cursor.getLong(n10));
                    constraints.setTriggerMaxContentDelay(cursor.getLong(n9));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers((byte[])cursor.getBlob(n8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState((int)cursor.getInt(n6));
                    workSpec.inputMergerClassName = cursor.getString(n4);
                    workSpec.input = Data.fromByteArray((byte[])cursor.getBlob(n3));
                    workSpec.output = Data.fromByteArray((byte[])cursor.getBlob(n2));
                    workSpec.initialDelay = cursor.getLong(n16);
                    workSpec.intervalDuration = cursor.getLong(n17);
                    workSpec.flexDuration = cursor.getLong(n18);
                    workSpec.runAttemptCount = cursor.getInt(n19);
                    int n26 = cursor.getInt(n);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy((int)n26);
                    workSpec.backoffDelayDuration = cursor.getLong(n20);
                    workSpec.periodStartTime = cursor.getLong(n21);
                    workSpec.minimumRetentionDuration = cursor.getLong(n22);
                    workSpec.scheduleRequestedAt = cursor.getLong(n23);
                    bl = cursor.getInt(n24) != 0;
                    workSpec.expedited = bl;
                    n26 = cursor.getInt(n25);
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int)n26);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var28_34;
    }

    public List<Data> getInputsFromPrerequisites(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        string = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            ArrayList<Data> arrayList = new ArrayList<Data>(string.getCount());
            while (string.moveToNext()) {
                arrayList.add(Data.fromByteArray((byte[])string.getBlob(0)));
            }
            return arrayList;
        }
        finally {
            string.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * WARNING - void declaration
     */
    public List<WorkSpec> getRecentlyCompletedWork(long l) {
        void var30_35;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block5: {
            ArrayList<WorkSpec> arrayList;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", (int)1);
            roomSQLiteQuery.bindLong(1, l);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"required_network_type");
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_charging");
                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_device_idle");
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_battery_not_low");
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_storage_not_low");
                n9 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_content_update_delay");
                n8 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_max_content_delay");
                n7 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"content_uri_triggers");
                n6 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
                n5 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
                n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"worker_class_name");
                n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input_merger_class_name");
                n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input");
                n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"initial_delay");
                int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"interval_duration");
                int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"flex_duration");
                int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
                int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_policy");
                int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_delay_duration");
                int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"period_start_time");
                int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"minimum_retention_duration");
                int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"schedule_requested_at");
                int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_in_foreground");
                int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n6);
                    String string2 = cursor.getString(n4);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType((int)cursor.getInt(n14)));
                    boolean bl = cursor.getInt(n13) != 0;
                    constraints.setRequiresCharging(bl);
                    bl = cursor.getInt(n12) != 0;
                    constraints.setRequiresDeviceIdle(bl);
                    bl = cursor.getInt(n11) != 0;
                    constraints.setRequiresBatteryNotLow(bl);
                    bl = cursor.getInt(n10) != 0;
                    constraints.setRequiresStorageNotLow(bl);
                    constraints.setTriggerContentUpdateDelay(cursor.getLong(n9));
                    constraints.setTriggerMaxContentDelay(cursor.getLong(n8));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers((byte[])cursor.getBlob(n7)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState((int)cursor.getInt(n5));
                    workSpec.inputMergerClassName = cursor.getString(n3);
                    workSpec.input = Data.fromByteArray((byte[])cursor.getBlob(n2));
                    workSpec.output = Data.fromByteArray((byte[])cursor.getBlob(n));
                    workSpec.initialDelay = cursor.getLong(n15);
                    workSpec.intervalDuration = cursor.getLong(n16);
                    workSpec.flexDuration = cursor.getLong(n17);
                    workSpec.runAttemptCount = cursor.getInt(n18);
                    int n26 = cursor.getInt(n19);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy((int)n26);
                    workSpec.backoffDelayDuration = cursor.getLong(n20);
                    workSpec.periodStartTime = cursor.getLong(n21);
                    workSpec.minimumRetentionDuration = cursor.getLong(n22);
                    workSpec.scheduleRequestedAt = cursor.getLong(n23);
                    bl = cursor.getInt(n24) != 0;
                    workSpec.expedited = bl;
                    n26 = cursor.getInt(n25);
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int)n26);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var30_35;
    }

    /*
     * WARNING - void declaration
     */
    public List<WorkSpec> getRunningWork() {
        void var28_34;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block5: {
            ArrayList<WorkSpec> arrayList;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", (int)0);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"required_network_type");
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_charging");
                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_device_idle");
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_battery_not_low");
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_storage_not_low");
                n9 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_content_update_delay");
                n8 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_max_content_delay");
                n7 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"content_uri_triggers");
                n6 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
                n5 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
                n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"worker_class_name");
                n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input_merger_class_name");
                n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input");
                n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"initial_delay");
                int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"interval_duration");
                int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"flex_duration");
                int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
                int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_policy");
                int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_delay_duration");
                int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"period_start_time");
                int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"minimum_retention_duration");
                int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"schedule_requested_at");
                int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_in_foreground");
                int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n6);
                    String string2 = cursor.getString(n4);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType((int)cursor.getInt(n14)));
                    boolean bl = cursor.getInt(n13) != 0;
                    constraints.setRequiresCharging(bl);
                    bl = cursor.getInt(n12) != 0;
                    constraints.setRequiresDeviceIdle(bl);
                    bl = cursor.getInt(n11) != 0;
                    constraints.setRequiresBatteryNotLow(bl);
                    bl = cursor.getInt(n10) != 0;
                    constraints.setRequiresStorageNotLow(bl);
                    constraints.setTriggerContentUpdateDelay(cursor.getLong(n9));
                    constraints.setTriggerMaxContentDelay(cursor.getLong(n8));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers((byte[])cursor.getBlob(n7)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState((int)cursor.getInt(n5));
                    workSpec.inputMergerClassName = cursor.getString(n3);
                    workSpec.input = Data.fromByteArray((byte[])cursor.getBlob(n2));
                    workSpec.output = Data.fromByteArray((byte[])cursor.getBlob(n));
                    workSpec.initialDelay = cursor.getLong(n15);
                    workSpec.intervalDuration = cursor.getLong(n16);
                    workSpec.flexDuration = cursor.getLong(n17);
                    workSpec.runAttemptCount = cursor.getInt(n18);
                    int n26 = cursor.getInt(n19);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy((int)n26);
                    workSpec.backoffDelayDuration = cursor.getLong(n20);
                    workSpec.periodStartTime = cursor.getLong(n21);
                    workSpec.minimumRetentionDuration = cursor.getLong(n22);
                    workSpec.scheduleRequestedAt = cursor.getLong(n23);
                    bl = cursor.getInt(n24) != 0;
                    workSpec.expedited = bl;
                    n26 = cursor.getInt(n25);
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int)n26);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var28_34;
    }

    public LiveData<Long> getScheduleRequestedAtLiveData(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT schedule_requested_at FROM workspec WHERE id=?", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        string = this.__db.getInvalidationTracker();
        roomSQLiteQuery = new /* Unavailable Anonymous Inner Class!! */;
        return string.createLiveData(new String[]{"workspec"}, false, (Callable)roomSQLiteQuery);
    }

    /*
     * WARNING - void declaration
     */
    public List<WorkSpec> getScheduledWork() {
        void var28_31;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block5: {
            ArrayList<WorkSpec> arrayList;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", (int)0);
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"required_network_type");
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_charging");
                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_device_idle");
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_battery_not_low");
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_storage_not_low");
                n9 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_content_update_delay");
                n8 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_max_content_delay");
                n7 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"content_uri_triggers");
                n6 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
                n5 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
                n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"worker_class_name");
                n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input_merger_class_name");
                n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input");
                n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"initial_delay");
                int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"interval_duration");
                int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"flex_duration");
                int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
                int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_policy");
                int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_delay_duration");
                int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"period_start_time");
                int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"minimum_retention_duration");
                int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"schedule_requested_at");
                int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_in_foreground");
                int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList<WorkSpec>(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n6);
                    String string2 = cursor.getString(n4);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType((int)cursor.getInt(n14)));
                    boolean bl = cursor.getInt(n13) != 0;
                    constraints.setRequiresCharging(bl);
                    bl = cursor.getInt(n12) != 0;
                    constraints.setRequiresDeviceIdle(bl);
                    bl = cursor.getInt(n11) != 0;
                    constraints.setRequiresBatteryNotLow(bl);
                    bl = cursor.getInt(n10) != 0;
                    constraints.setRequiresStorageNotLow(bl);
                    constraints.setTriggerContentUpdateDelay(cursor.getLong(n9));
                    constraints.setTriggerMaxContentDelay(cursor.getLong(n8));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers((byte[])cursor.getBlob(n7)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState((int)cursor.getInt(n5));
                    workSpec.inputMergerClassName = cursor.getString(n3);
                    workSpec.input = Data.fromByteArray((byte[])cursor.getBlob(n2));
                    workSpec.output = Data.fromByteArray((byte[])cursor.getBlob(n));
                    workSpec.initialDelay = cursor.getLong(n15);
                    workSpec.intervalDuration = cursor.getLong(n16);
                    workSpec.flexDuration = cursor.getLong(n17);
                    workSpec.runAttemptCount = cursor.getInt(n18);
                    int n26 = cursor.getInt(n19);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy((int)n26);
                    workSpec.backoffDelayDuration = cursor.getLong(n20);
                    workSpec.periodStartTime = cursor.getLong(n21);
                    workSpec.minimumRetentionDuration = cursor.getLong(n22);
                    workSpec.scheduleRequestedAt = cursor.getLong(n23);
                    bl = cursor.getInt(n24) != 0;
                    workSpec.expedited = bl;
                    n26 = cursor.getInt(n25);
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int)n26);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var28_31;
    }

    public WorkInfo.State getState(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT state FROM workspec WHERE id=?", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        RoomDatabase roomDatabase = this.__db;
        string = null;
        roomDatabase = DBUtil.query((RoomDatabase)roomDatabase, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            if (!roomDatabase.moveToFirst()) return string;
            string = WorkTypeConverters.intToState((int)roomDatabase.getInt(0));
            return string;
        }
        finally {
            roomDatabase.close();
            roomSQLiteQuery.release();
        }
    }

    public List<String> getUnfinishedWorkWithName(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        string = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(string.getCount());
            while (string.moveToNext()) {
                arrayList.add(string.getString(0));
            }
            return arrayList;
        }
        finally {
            string.close();
            roomSQLiteQuery.release();
        }
    }

    public List<String> getUnfinishedWorkWithTag(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        string = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            ArrayList<String> arrayList = new ArrayList<String>(string.getCount());
            while (string.moveToNext()) {
                arrayList.add(string.getString(0));
            }
            return arrayList;
        }
        finally {
            string.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * WARNING - void declaration
     */
    public WorkSpec getWorkSpec(String string) {
        void var1_4;
        Cursor cursor;
        RoomSQLiteQuery roomSQLiteQuery;
        block8: {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", (int)1);
            if (string == null) {
                roomSQLiteQuery.bindNull(1);
            } else {
                roomSQLiteQuery.bindString(1, string);
            }
            this.__db.assertNotSuspendingTransaction();
            cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"required_network_type");
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_charging");
                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_device_idle");
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_battery_not_low");
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"requires_storage_not_low");
                n9 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_content_update_delay");
                n8 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"trigger_max_content_delay");
                n7 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"content_uri_triggers");
                n6 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
                n5 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
                n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"worker_class_name");
                n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input_merger_class_name");
                n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"input");
                n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block8;
            }
            try {
                int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"initial_delay");
                int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"interval_duration");
                int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"flex_duration");
                int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
                int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_policy");
                int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"backoff_delay_duration");
                int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"period_start_time");
                int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"minimum_retention_duration");
                int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"schedule_requested_at");
                int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_in_foreground");
                int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"out_of_quota_policy");
                if (cursor.moveToFirst()) {
                    String string2 = cursor.getString(n6);
                    String string3 = cursor.getString(n4);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType((int)cursor.getInt(n14)));
                    boolean bl = cursor.getInt(n13) != 0;
                    constraints.setRequiresCharging(bl);
                    bl = cursor.getInt(n12) != 0;
                    constraints.setRequiresDeviceIdle(bl);
                    bl = cursor.getInt(n11) != 0;
                    constraints.setRequiresBatteryNotLow(bl);
                    bl = cursor.getInt(n10) != 0;
                    constraints.setRequiresStorageNotLow(bl);
                    constraints.setTriggerContentUpdateDelay(cursor.getLong(n9));
                    constraints.setTriggerMaxContentDelay(cursor.getLong(n8));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers((byte[])cursor.getBlob(n7)));
                    string = new WorkSpec(string2, string3);
                    ((WorkSpec)string).state = WorkTypeConverters.intToState((int)cursor.getInt(n5));
                    ((WorkSpec)string).inputMergerClassName = cursor.getString(n3);
                    ((WorkSpec)string).input = Data.fromByteArray((byte[])cursor.getBlob(n2));
                    ((WorkSpec)string).output = Data.fromByteArray((byte[])cursor.getBlob(n));
                    ((WorkSpec)string).initialDelay = cursor.getLong(n15);
                    ((WorkSpec)string).intervalDuration = cursor.getLong(n16);
                    ((WorkSpec)string).flexDuration = cursor.getLong(n17);
                    ((WorkSpec)string).runAttemptCount = cursor.getInt(n18);
                    ((WorkSpec)string).backoffPolicy = WorkTypeConverters.intToBackoffPolicy((int)cursor.getInt(n19));
                    ((WorkSpec)string).backoffDelayDuration = cursor.getLong(n20);
                    ((WorkSpec)string).periodStartTime = cursor.getLong(n21);
                    ((WorkSpec)string).minimumRetentionDuration = cursor.getLong(n22);
                    ((WorkSpec)string).scheduleRequestedAt = cursor.getLong(n23);
                    bl = cursor.getInt(n24) != 0;
                    ((WorkSpec)string).expedited = bl;
                    ((WorkSpec)string).outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int)cursor.getInt(n25));
                    ((WorkSpec)string).constraints = constraints;
                } else {
                    string = null;
                }
            }
            catch (Throwable throwable) {
                break block8;
            }
            cursor.close();
            roomSQLiteQuery.release();
            return string;
        }
        cursor.close();
        roomSQLiteQuery.release();
        throw var1_4;
    }

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        this.__db.assertNotSuspendingTransaction();
        string = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        try {
            int n = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"id");
            int n2 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"state");
            ArrayList<WorkSpec.IdAndState> arrayList = new ArrayList<WorkSpec.IdAndState>(string.getCount());
            while (string.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.id = string.getString(n);
                idAndState.state = WorkTypeConverters.intToState((int)string.getInt(n2));
                arrayList.add(idAndState);
            }
            return arrayList;
        }
        finally {
            string.close();
            roomSQLiteQuery.release();
        }
    }

    /*
     * WARNING - void declaration
     */
    public WorkSpec[] getWorkSpecs(List<String> workSpecArray) {
        void var1_4;
        String string;
        StringBuilder stringBuilder;
        block8: {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            stringBuilder = StringUtil.newStringBuilder();
            stringBuilder.append("SELECT ");
            stringBuilder.append("*");
            stringBuilder.append(" FROM workspec WHERE id IN (");
            int n15 = workSpecArray.size();
            StringUtil.appendPlaceholders((StringBuilder)stringBuilder, (int)n15);
            stringBuilder.append(")");
            stringBuilder = RoomSQLiteQuery.acquire((String)stringBuilder.toString(), (int)(n15 + 0));
            workSpecArray = workSpecArray.iterator();
            n15 = 1;
            while (workSpecArray.hasNext()) {
                string = (String)workSpecArray.next();
                if (string == null) {
                    stringBuilder.bindNull(n15);
                } else {
                    stringBuilder.bindString(n15, string);
                }
                ++n15;
            }
            this.__db.assertNotSuspendingTransaction();
            string = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)stringBuilder, (boolean)false, null);
            try {
                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"required_network_type");
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"requires_charging");
                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"requires_device_idle");
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"requires_battery_not_low");
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"requires_storage_not_low");
                n9 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"trigger_content_update_delay");
                n8 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"trigger_max_content_delay");
                n7 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"content_uri_triggers");
                n6 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"id");
                n5 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"state");
                n4 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"worker_class_name");
                n3 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"input_merger_class_name");
                n2 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"input");
                n = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block8;
            }
            try {
                int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"initial_delay");
                int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"interval_duration");
                int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"flex_duration");
                int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"run_attempt_count");
                n15 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"backoff_policy");
                int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"backoff_delay_duration");
                int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"period_start_time");
                int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"minimum_retention_duration");
                int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"schedule_requested_at");
                int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"run_in_foreground");
                int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)string, (String)"out_of_quota_policy");
                workSpecArray = new WorkSpec[string.getCount()];
                int n26 = 0;
                while (string.moveToNext()) {
                    String string2 = string.getString(n6);
                    String string3 = string.getString(n4);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType((int)string.getInt(n14)));
                    boolean bl = string.getInt(n13) != 0;
                    constraints.setRequiresCharging(bl);
                    bl = string.getInt(n12) != 0;
                    constraints.setRequiresDeviceIdle(bl);
                    bl = string.getInt(n11) != 0;
                    constraints.setRequiresBatteryNotLow(bl);
                    bl = string.getInt(n10) != 0;
                    constraints.setRequiresStorageNotLow(bl);
                    constraints.setTriggerContentUpdateDelay(string.getLong(n9));
                    constraints.setTriggerMaxContentDelay(string.getLong(n8));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers((byte[])string.getBlob(n7)));
                    WorkSpec workSpec = new WorkSpec(string2, string3);
                    workSpec.state = WorkTypeConverters.intToState((int)string.getInt(n5));
                    workSpec.inputMergerClassName = string.getString(n3);
                    workSpec.input = Data.fromByteArray((byte[])string.getBlob(n2));
                    workSpec.output = Data.fromByteArray((byte[])string.getBlob(n));
                    workSpec.initialDelay = string.getLong(n16);
                    workSpec.intervalDuration = string.getLong(n17);
                    workSpec.flexDuration = string.getLong(n18);
                    workSpec.runAttemptCount = string.getInt(n19);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy((int)string.getInt(n15));
                    workSpec.backoffDelayDuration = string.getLong(n20);
                    workSpec.periodStartTime = string.getLong(n21);
                    workSpec.minimumRetentionDuration = string.getLong(n22);
                    workSpec.scheduleRequestedAt = string.getLong(n23);
                    bl = string.getInt(n24) != 0;
                    workSpec.expedited = bl;
                    workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy((int)string.getInt(n25));
                    workSpec.constraints = constraints;
                    workSpecArray[n26] = workSpec;
                    ++n26;
                }
            }
            catch (Throwable throwable) {
                break block8;
            }
            string.close();
            stringBuilder.release();
            return workSpecArray;
        }
        string.close();
        stringBuilder.release();
        throw var1_4;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String object) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id, state, output, run_attempt_count FROM workspec WHERE id=?", (int)1);
        if (object == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, (String)object);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Object object2 = this.__db;
        object = null;
        Object workInfoPojo = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)true, null);
        try {
            int n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
            int n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
            int n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            int n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
            object2 = new ArrayMap();
            ArrayMap arrayMap = new ArrayMap();
            while (cursor.moveToNext()) {
                ArrayList arrayList;
                ArrayList arrayList2;
                if (!cursor.isNull(n) && (ArrayList)object2.get((Object)(arrayList2 = cursor.getString(n))) == null) {
                    arrayList = new ArrayList();
                    object2.put((Object)arrayList2, arrayList);
                }
                if (cursor.isNull(n) || (ArrayList)arrayMap.get((Object)(arrayList = cursor.getString(n))) != null) continue;
                arrayList2 = new ArrayList();
                arrayMap.put(arrayList, arrayList2);
            }
            cursor.moveToPosition(-1);
            this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)object2);
            this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap);
            if (cursor.moveToFirst()) {
                object = !cursor.isNull(n) ? (ArrayList)object2.get((Object)cursor.getString(n)) : null;
                object2 = object;
                if (object == null) {
                    object2 = new ArrayList();
                }
                object = workInfoPojo;
                if (!cursor.isNull(n)) {
                    object = (ArrayList)arrayMap.get((Object)cursor.getString(n));
                }
                workInfoPojo = object;
                if (object == null) {
                    workInfoPojo = new ArrayList();
                }
                object = new WorkSpec.WorkInfoPojo();
                ((WorkSpec.WorkInfoPojo)object).id = cursor.getString(n);
                ((WorkSpec.WorkInfoPojo)object).state = WorkTypeConverters.intToState((int)cursor.getInt(n2));
                ((WorkSpec.WorkInfoPojo)object).output = Data.fromByteArray((byte[])cursor.getBlob(n3));
                ((WorkSpec.WorkInfoPojo)object).runAttemptCount = cursor.getInt(n4);
                ((WorkSpec.WorkInfoPojo)object).tags = object2;
                ((WorkSpec.WorkInfoPojo)object).progress = workInfoPojo;
            }
            this.__db.setTransactionSuccessful();
        }
        catch (Throwable throwable) {
            cursor.close();
            roomSQLiteQuery.release();
            throw throwable;
        }
        try {
            cursor.close();
            roomSQLiteQuery.release();
            return object;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> object) {
        ArrayList<WorkSpec.WorkInfoPojo> arrayList;
        ArrayList workInfoPojo = StringUtil.newStringBuilder();
        ((StringBuilder)((Object)workInfoPojo)).append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)((Object)workInfoPojo), (int)n);
        ((StringBuilder)((Object)workInfoPojo)).append(")");
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)((StringBuilder)((Object)workInfoPojo)).toString(), (int)(n + 0));
        workInfoPojo = object.iterator();
        n = 1;
        while (workInfoPojo.hasNext()) {
            object = (String)workInfoPojo.next();
            if (object == null) {
                roomSQLiteQuery.bindNull(n);
            } else {
                roomSQLiteQuery.bindString(n, (String)object);
            }
            ++n;
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)true, null);
        try {
            int n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
            int n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
            int n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (cursor.moveToNext()) {
                if (!cursor.isNull(n2) && (ArrayList)arrayMap.get((Object)(workInfoPojo = cursor.getString(n2))) == null) {
                    object = new ArrayList();
                    arrayMap.put((Object)workInfoPojo, object);
                }
                if (cursor.isNull(n2) || (ArrayList)arrayMap2.get((Object)(workInfoPojo = cursor.getString(n2))) != null) continue;
                object = new ArrayList();
                arrayMap2.put((Object)workInfoPojo, object);
            }
            cursor.moveToPosition(-1);
            this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap);
            this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap2);
            arrayList = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
            while (cursor.moveToNext()) {
                object = !cursor.isNull(n2) ? (ArrayList)arrayMap.get((Object)cursor.getString(n2)) : null;
                workInfoPojo = object;
                if (object == null) {
                    workInfoPojo = new ArrayList();
                }
                object = !cursor.isNull(n2) ? (ArrayList)arrayMap2.get((Object)cursor.getString(n2)) : null;
                Object workInfoPojo2 = object;
                if (object == null) {
                    workInfoPojo2 = new ArrayList();
                }
                object = new WorkSpec.WorkInfoPojo();
                ((WorkSpec.WorkInfoPojo)object).id = cursor.getString(n2);
                ((WorkSpec.WorkInfoPojo)object).state = WorkTypeConverters.intToState((int)cursor.getInt(n3));
                ((WorkSpec.WorkInfoPojo)object).output = Data.fromByteArray((byte[])cursor.getBlob(n4));
                ((WorkSpec.WorkInfoPojo)object).runAttemptCount = cursor.getInt(n);
                ((WorkSpec.WorkInfoPojo)object).tags = workInfoPojo;
                ((WorkSpec.WorkInfoPojo)object).progress = workInfoPojo2;
                arrayList.add((WorkSpec.WorkInfoPojo)object);
            }
            this.__db.setTransactionSuccessful();
        }
        catch (Throwable throwable) {
            cursor.close();
            roomSQLiteQuery.release();
            throw throwable;
        }
        try {
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String object) {
        ArrayList<WorkSpec.WorkInfoPojo> arrayList2;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", (int)1);
        if (object == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, (String)object);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)true, null);
        try {
            ArrayList arrayList;
            int n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
            int n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
            int n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            int n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (cursor.moveToNext()) {
                if (!cursor.isNull(n) && (ArrayList)arrayMap.get(object = cursor.getString(n)) == null) {
                    arrayList = new ArrayList();
                    arrayMap.put(object, (Object)arrayList);
                }
                if (cursor.isNull(n) || (ArrayList)arrayMap2.get(object = cursor.getString(n)) != null) continue;
                arrayList = new ArrayList();
                arrayMap2.put(object, arrayList);
            }
            cursor.moveToPosition(-1);
            this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap);
            this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap2);
            arrayList2 = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
            while (cursor.moveToNext()) {
                object = !cursor.isNull(n) ? (ArrayList)arrayMap.get((Object)cursor.getString(n)) : null;
                arrayList = object;
                if (object == null) {
                    arrayList = new ArrayList();
                }
                object = !cursor.isNull(n) ? (ArrayList)arrayMap2.get((Object)cursor.getString(n)) : null;
                Object workInfoPojo = object;
                if (object == null) {
                    workInfoPojo = new ArrayList();
                }
                object = new WorkSpec.WorkInfoPojo();
                ((WorkSpec.WorkInfoPojo)object).id = cursor.getString(n);
                ((WorkSpec.WorkInfoPojo)object).state = WorkTypeConverters.intToState((int)cursor.getInt(n2));
                ((WorkSpec.WorkInfoPojo)object).output = Data.fromByteArray((byte[])cursor.getBlob(n3));
                ((WorkSpec.WorkInfoPojo)object).runAttemptCount = cursor.getInt(n4);
                ((WorkSpec.WorkInfoPojo)object).tags = arrayList;
                ((WorkSpec.WorkInfoPojo)object).progress = workInfoPojo;
                arrayList2.add((WorkSpec.WorkInfoPojo)object);
            }
            this.__db.setTransactionSuccessful();
        }
        catch (Throwable throwable) {
            cursor.close();
            roomSQLiteQuery.release();
            throw throwable;
        }
        try {
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList2;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String object) {
        ArrayList<WorkSpec.WorkInfoPojo> arrayList2;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", (int)1);
        if (object == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, (String)object);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)true, null);
        try {
            ArrayList arrayList;
            int n = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"id");
            int n2 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"state");
            int n3 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"output");
            int n4 = CursorUtil.getColumnIndexOrThrow((Cursor)cursor, (String)"run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (cursor.moveToNext()) {
                if (!cursor.isNull(n) && (ArrayList)arrayMap.get((Object)(arrayList = cursor.getString(n))) == null) {
                    object = new ArrayList();
                    arrayMap.put((Object)arrayList, object);
                }
                if (cursor.isNull(n) || (ArrayList)arrayMap2.get(object = cursor.getString(n)) != null) continue;
                arrayList = new ArrayList();
                arrayMap2.put(object, arrayList);
            }
            cursor.moveToPosition(-1);
            this.__fetchRelationshipWorkTagAsjavaLangString((ArrayMap<String, ArrayList<String>>)arrayMap);
            this.__fetchRelationshipWorkProgressAsandroidxWorkData((ArrayMap<String, ArrayList<Data>>)arrayMap2);
            arrayList2 = new ArrayList<WorkSpec.WorkInfoPojo>(cursor.getCount());
            while (cursor.moveToNext()) {
                object = !cursor.isNull(n) ? (ArrayList)arrayMap.get((Object)cursor.getString(n)) : null;
                arrayList = object;
                if (object == null) {
                    arrayList = new ArrayList();
                }
                object = !cursor.isNull(n) ? (ArrayList)arrayMap2.get((Object)cursor.getString(n)) : null;
                Object workInfoPojo = object;
                if (object == null) {
                    workInfoPojo = new ArrayList();
                }
                object = new WorkSpec.WorkInfoPojo();
                ((WorkSpec.WorkInfoPojo)object).id = cursor.getString(n);
                ((WorkSpec.WorkInfoPojo)object).state = WorkTypeConverters.intToState((int)cursor.getInt(n2));
                ((WorkSpec.WorkInfoPojo)object).output = Data.fromByteArray((byte[])cursor.getBlob(n3));
                ((WorkSpec.WorkInfoPojo)object).runAttemptCount = cursor.getInt(n4);
                ((WorkSpec.WorkInfoPojo)object).tags = arrayList;
                ((WorkSpec.WorkInfoPojo)object).progress = workInfoPojo;
                arrayList2.add((WorkSpec.WorkInfoPojo)object);
            }
            this.__db.setTransactionSuccessful();
        }
        catch (Throwable throwable) {
            cursor.close();
            roomSQLiteQuery.release();
            throw throwable;
        }
        try {
            cursor.close();
            roomSQLiteQuery.release();
            return arrayList2;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> object) {
        StringBuilder stringBuilder = StringUtil.newStringBuilder();
        stringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int n = object.size();
        StringUtil.appendPlaceholders((StringBuilder)stringBuilder, (int)n);
        stringBuilder.append(")");
        stringBuilder = RoomSQLiteQuery.acquire((String)stringBuilder.toString(), (int)(n + 0));
        object = object.iterator();
        n = 1;
        while (true) {
            if (!object.hasNext()) {
                object = this.__db.getInvalidationTracker();
                stringBuilder = new /* Unavailable Anonymous Inner Class!! */;
                return object.createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, (Callable)((Object)stringBuilder));
            }
            String string = (String)object.next();
            if (string == null) {
                stringBuilder.bindNull(n);
            } else {
                stringBuilder.bindString(n, string);
            }
            ++n;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        string = this.__db.getInvalidationTracker();
        roomSQLiteQuery = new /* Unavailable Anonymous Inner Class!! */;
        return string.createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, (Callable)roomSQLiteQuery);
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String string) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", (int)1);
        if (string == null) {
            roomSQLiteQuery.bindNull(1);
        } else {
            roomSQLiteQuery.bindString(1, string);
        }
        string = this.__db.getInvalidationTracker();
        roomSQLiteQuery = new /* Unavailable Anonymous Inner Class!! */;
        return string.createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, (Callable)roomSQLiteQuery);
    }

    public boolean hasUnfinishedWork() {
        boolean bl = false;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire((String)"SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", (int)0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor = DBUtil.query((RoomDatabase)this.__db, (SupportSQLiteQuery)roomSQLiteQuery, (boolean)false, null);
        boolean bl2 = bl;
        try {
            if (!cursor.moveToFirst()) return bl2;
            int n = cursor.getInt(0);
            bl2 = bl;
            if (n == 0) return bl2;
            bl2 = true;
        }
        finally {
            cursor.close();
            roomSQLiteQuery.release();
        }
        return bl2;
    }

    public int incrementWorkSpecRunAttemptCount(String string) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (string == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string);
        }
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(supportSQLiteStatement);
        }
    }

    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert((Object)workSpec);
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public int markWorkSpecScheduled(String string, long l) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        supportSQLiteStatement.bindLong(1, l);
        if (string == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string);
        }
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(supportSQLiteStatement);
        }
    }

    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(supportSQLiteStatement);
        }
    }

    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(supportSQLiteStatement);
        }
    }

    public int resetWorkSpecRunAttemptCount(String string) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (string == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, string);
        }
        this.__db.beginTransaction();
        try {
            int n = supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return n;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(supportSQLiteStatement);
        }
    }

    public void setOutput(String string, Data object) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfSetOutput.acquire();
        object = Data.toByteArrayInternal((Data)object);
        if (object == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindBlob(1, (byte[])object);
        }
        if (string == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(supportSQLiteStatement);
        }
    }

    public void setPeriodStartTime(String string, long l) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfSetPeriodStartTime.acquire();
        supportSQLiteStatement.bindLong(1, l);
        if (string == null) {
            supportSQLiteStatement.bindNull(2);
        } else {
            supportSQLiteStatement.bindString(2, string);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetPeriodStartTime.release(supportSQLiteStatement);
        }
    }

    public int setState(WorkInfo.State object, String ... stringArray) {
        int n;
        this.__db.assertNotSuspendingTransaction();
        CharSequence charSequence = StringUtil.newStringBuilder();
        charSequence.append("UPDATE workspec SET state=");
        charSequence.append("?");
        charSequence.append(" WHERE id IN (");
        StringUtil.appendPlaceholders((StringBuilder)charSequence, (int)stringArray.length);
        charSequence.append(")");
        charSequence = charSequence.toString();
        charSequence = this.__db.compileStatement((String)charSequence);
        charSequence.bindLong(1, WorkTypeConverters.stateToInt((WorkInfo.State)object));
        int n2 = stringArray.length;
        int n3 = 2;
        for (n = 0; n < n2; ++n3, ++n) {
            object = stringArray[n];
            if (object == null) {
                charSequence.bindNull(n3);
                continue;
            }
            charSequence.bindString(n3, (String)object);
        }
        this.__db.beginTransaction();
        try {
            n = charSequence.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
        return n;
    }
}
