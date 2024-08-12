/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityInsertionAdapter
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.work.BackoffPolicy
 *  androidx.work.ContentUriTriggers
 *  androidx.work.Data
 *  androidx.work.NetworkType
 *  androidx.work.OutOfQuotaPolicy
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.model.WorkSpecDao_Impl
 *  androidx.work.impl.model.WorkTypeConverters
 */
package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.ContentUriTriggers;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTypeConverters;

class WorkSpecDao_Impl.1
extends EntityInsertionAdapter<WorkSpec> {
    final WorkSpecDao_Impl this$0;

    WorkSpecDao_Impl.1(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = workSpecDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec object) {
        if (object.id == null) {
            supportSQLiteStatement.bindNull(1);
        } else {
            supportSQLiteStatement.bindString(1, object.id);
        }
        supportSQLiteStatement.bindLong(2, (long)WorkTypeConverters.stateToInt((WorkInfo.State)object.state));
        if (object.workerClassName == null) {
            supportSQLiteStatement.bindNull(3);
        } else {
            supportSQLiteStatement.bindString(3, object.workerClassName);
        }
        if (object.inputMergerClassName == null) {
            supportSQLiteStatement.bindNull(4);
        } else {
            supportSQLiteStatement.bindString(4, object.inputMergerClassName);
        }
        byte[] byArray = Data.toByteArrayInternal((Data)object.input);
        if (byArray == null) {
            supportSQLiteStatement.bindNull(5);
        } else {
            supportSQLiteStatement.bindBlob(5, byArray);
        }
        byArray = Data.toByteArrayInternal((Data)object.output);
        if (byArray == null) {
            supportSQLiteStatement.bindNull(6);
        } else {
            supportSQLiteStatement.bindBlob(6, byArray);
        }
        supportSQLiteStatement.bindLong(7, object.initialDelay);
        supportSQLiteStatement.bindLong(8, object.intervalDuration);
        supportSQLiteStatement.bindLong(9, object.flexDuration);
        supportSQLiteStatement.bindLong(10, (long)object.runAttemptCount);
        supportSQLiteStatement.bindLong(11, (long)WorkTypeConverters.backoffPolicyToInt((BackoffPolicy)object.backoffPolicy));
        supportSQLiteStatement.bindLong(12, object.backoffDelayDuration);
        supportSQLiteStatement.bindLong(13, object.periodStartTime);
        supportSQLiteStatement.bindLong(14, object.minimumRetentionDuration);
        supportSQLiteStatement.bindLong(15, object.scheduleRequestedAt);
        supportSQLiteStatement.bindLong(16, (long)object.expedited);
        supportSQLiteStatement.bindLong(17, (long)WorkTypeConverters.outOfQuotaPolicyToInt((OutOfQuotaPolicy)object.outOfQuotaPolicy));
        object = object.constraints;
        if (object != null) {
            supportSQLiteStatement.bindLong(18, (long)WorkTypeConverters.networkTypeToInt((NetworkType)object.getRequiredNetworkType()));
            supportSQLiteStatement.bindLong(19, (long)object.requiresCharging());
            supportSQLiteStatement.bindLong(20, (long)object.requiresDeviceIdle());
            supportSQLiteStatement.bindLong(21, (long)object.requiresBatteryNotLow());
            supportSQLiteStatement.bindLong(22, (long)object.requiresStorageNotLow());
            supportSQLiteStatement.bindLong(23, object.getTriggerContentUpdateDelay());
            supportSQLiteStatement.bindLong(24, object.getTriggerMaxContentDelay());
            object = WorkTypeConverters.contentUriTriggersToByteArray((ContentUriTriggers)object.getContentUriTriggers());
            if (object == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindBlob(25, (byte[])object);
            }
        } else {
            supportSQLiteStatement.bindNull(18);
            supportSQLiteStatement.bindNull(19);
            supportSQLiteStatement.bindNull(20);
            supportSQLiteStatement.bindNull(21);
            supportSQLiteStatement.bindNull(22);
            supportSQLiteStatement.bindNull(23);
            supportSQLiteStatement.bindNull(24);
            supportSQLiteStatement.bindNull(25);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}
