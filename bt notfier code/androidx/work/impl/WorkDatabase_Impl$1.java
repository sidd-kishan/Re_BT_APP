/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomDatabase$Callback
 *  androidx.room.RoomOpenHelper$Delegate
 *  androidx.room.RoomOpenHelper$ValidationResult
 *  androidx.room.util.DBUtil
 *  androidx.room.util.TableInfo
 *  androidx.room.util.TableInfo$Column
 *  androidx.room.util.TableInfo$ForeignKey
 *  androidx.room.util.TableInfo$Index
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.work.impl.WorkDatabase_Impl
 */
package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis ignored.
 */
class WorkDatabase_Impl.1
extends RoomOpenHelper.Delegate {
    final WorkDatabase_Impl this$0;

    WorkDatabase_Impl.1(WorkDatabase_Impl workDatabase_Impl, int n) {
        this.this$0 = workDatabase_Impl;
        super(n);
    }

    public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }

    public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preference`");
        if (WorkDatabase_Impl.access$000((WorkDatabase_Impl)this.this$0) == null) return;
        int n = 0;
        int n2 = WorkDatabase_Impl.access$100((WorkDatabase_Impl)this.this$0).size();
        while (n < n2) {
            ((RoomDatabase.Callback)WorkDatabase_Impl.access$200((WorkDatabase_Impl)this.this$0).get(n)).onDestructiveMigration(supportSQLiteDatabase);
            ++n;
        }
    }

    protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (WorkDatabase_Impl.access$300((WorkDatabase_Impl)this.this$0) == null) return;
        int n = 0;
        int n2 = WorkDatabase_Impl.access$400((WorkDatabase_Impl)this.this$0).size();
        while (n < n2) {
            ((RoomDatabase.Callback)WorkDatabase_Impl.access$500((WorkDatabase_Impl)this.this$0).get(n)).onCreate(supportSQLiteDatabase);
            ++n;
        }
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        WorkDatabase_Impl.access$602((WorkDatabase_Impl)this.this$0, (SupportSQLiteDatabase)supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
        WorkDatabase_Impl.access$700((WorkDatabase_Impl)this.this$0, (SupportSQLiteDatabase)supportSQLiteDatabase);
        if (WorkDatabase_Impl.access$800((WorkDatabase_Impl)this.this$0) == null) return;
        int n = 0;
        int n2 = WorkDatabase_Impl.access$900((WorkDatabase_Impl)this.this$0).size();
        while (n < n2) {
            ((RoomDatabase.Callback)WorkDatabase_Impl.access$1000((WorkDatabase_Impl)this.this$0).get(n)).onOpen(supportSQLiteDatabase);
            ++n;
        }
    }

    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        DBUtil.dropFtsSyncTriggers((SupportSQLiteDatabase)supportSQLiteDatabase);
    }

    protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase object) {
        Cloneable cloneable = new HashMap<String, TableInfo.Column>(2);
        ((HashMap)cloneable).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
        ((HashMap)cloneable).put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2, null, 1));
        Object object2 = new HashSet(2);
        ((HashSet)object2).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        ((HashSet)object2).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
        Object object3 = new HashSet(2);
        ((HashSet)object3).add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
        ((HashSet)object3).add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
        object3 = new TableInfo("Dependency", cloneable, object2, object3);
        object2 = TableInfo.read((SupportSQLiteDatabase)object, (String)"Dependency");
        if (!object3.equals(object2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n");
            ((StringBuilder)object).append(object3);
            ((StringBuilder)object).append("\n Found:\n");
            ((StringBuilder)object).append(object2);
            return new RoomOpenHelper.ValidationResult(false, ((StringBuilder)object).toString());
        }
        object2 = new HashMap(25);
        ((HashMap)object2).put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
        ((HashMap)object2).put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0, null, 1));
        ((HashMap)object2).put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", false, 0, null, 1));
        ((HashMap)object2).put("input", new TableInfo.Column("input", "BLOB", true, 0, null, 1));
        ((HashMap)object2).put("output", new TableInfo.Column("output", "BLOB", true, 0, null, 1));
        ((HashMap)object2).put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("period_start_time", new TableInfo.Column("period_start_time", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("out_of_quota_policy", new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", false, 0, null, 1));
        ((HashMap)object2).put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
        ((HashMap)object2).put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", false, 0, null, 1));
        object3 = new HashSet(0);
        cloneable = new HashSet(2);
        ((HashSet)cloneable).add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
        ((HashSet)cloneable).add(new TableInfo.Index("index_WorkSpec_period_start_time", false, Arrays.asList("period_start_time")));
        object3 = new TableInfo("WorkSpec", (Map)object2, (Set)object3, (Set)((Object)cloneable));
        object2 = TableInfo.read((SupportSQLiteDatabase)object, (String)"WorkSpec");
        if (!object3.equals(object2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n");
            ((StringBuilder)object).append(object3);
            ((StringBuilder)object).append("\n Found:\n");
            ((StringBuilder)object).append(object2);
            return new RoomOpenHelper.ValidationResult(false, ((StringBuilder)object).toString());
        }
        object2 = new HashMap(2);
        ((HashMap)object2).put("tag", new TableInfo.Column("tag", "TEXT", true, 1, null, 1));
        ((HashMap)object2).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
        object3 = new HashSet(1);
        ((HashSet)object3).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        cloneable = new HashSet(1);
        ((HashSet)cloneable).add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
        object3 = new TableInfo("WorkTag", (Map)object2, (Set)object3, (Set)((Object)cloneable));
        object2 = TableInfo.read((SupportSQLiteDatabase)object, (String)"WorkTag");
        if (!object3.equals(object2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n");
            ((StringBuilder)object).append(object3);
            ((StringBuilder)object).append("\n Found:\n");
            ((StringBuilder)object).append(object2);
            return new RoomOpenHelper.ValidationResult(false, ((StringBuilder)object).toString());
        }
        object2 = new HashMap(2);
        ((HashMap)object2).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
        ((HashMap)object2).put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, null, 1));
        object3 = new HashSet(1);
        ((HashSet)object3).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        object3 = new TableInfo("SystemIdInfo", (Map)object2, (Set)object3, new HashSet(0));
        object2 = TableInfo.read((SupportSQLiteDatabase)object, (String)"SystemIdInfo");
        if (!object3.equals(object2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n");
            ((StringBuilder)object).append(object3);
            ((StringBuilder)object).append("\n Found:\n");
            ((StringBuilder)object).append(object2);
            return new RoomOpenHelper.ValidationResult(false, ((StringBuilder)object).toString());
        }
        object3 = new HashMap(2);
        ((HashMap)object3).put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
        ((HashMap)object3).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
        cloneable = new HashSet(1);
        ((HashSet)cloneable).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        object2 = new HashSet(1);
        ((HashSet)object2).add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
        object2 = new TableInfo("WorkName", (Map)object3, (Set)((Object)cloneable), (Set)object2);
        object3 = TableInfo.read((SupportSQLiteDatabase)object, (String)"WorkName");
        if (!object2.equals(object3)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n");
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append("\n Found:\n");
            ((StringBuilder)object).append(object3);
            return new RoomOpenHelper.ValidationResult(false, ((StringBuilder)object).toString());
        }
        object2 = new HashMap(2);
        ((HashMap)object2).put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
        ((HashMap)object2).put("progress", new TableInfo.Column("progress", "BLOB", true, 0, null, 1));
        object3 = new HashSet(1);
        ((HashSet)object3).add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        object2 = new TableInfo("WorkProgress", (Map)object2, (Set)object3, new HashSet(0));
        object3 = TableInfo.read((SupportSQLiteDatabase)object, (String)"WorkProgress");
        if (!object2.equals(object3)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n");
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append("\n Found:\n");
            ((StringBuilder)object).append(object3);
            return new RoomOpenHelper.ValidationResult(false, ((StringBuilder)object).toString());
        }
        object3 = new HashMap(2);
        ((HashMap)object3).put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
        ((HashMap)object3).put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, null, 1));
        object3 = new TableInfo("Preference", (Map)object3, new HashSet(0), new HashSet(0));
        object = TableInfo.read((SupportSQLiteDatabase)object, (String)"Preference");
        if (object3.equals(object)) return new RoomOpenHelper.ValidationResult(true, null);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Preference(androidx.work.impl.model.Preference).\n Expected:\n");
        ((StringBuilder)object2).append(object3);
        ((StringBuilder)object2).append("\n Found:\n");
        ((StringBuilder)object2).append(object);
        return new RoomOpenHelper.ValidationResult(false, ((StringBuilder)object2).toString());
    }
}
