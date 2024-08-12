/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  androidx.work.Logger
 */
package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WorkDatabasePathHelper {
    private static final String[] DATABASE_EXTRA_FILES;
    private static final String TAG;
    private static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        TAG = Logger.tagWithPrefix((String)"WrkDbPathHelper");
        DATABASE_EXTRA_FILES = new String[]{"-journal", "-shm", "-wal"};
    }

    private WorkDatabasePathHelper() {
    }

    public static File getDatabasePath(Context context) {
        if (Build.VERSION.SDK_INT >= 23) return WorkDatabasePathHelper.getNoBackupPath(context, WORK_DATABASE_NAME);
        return WorkDatabasePathHelper.getDefaultDatabasePath(context);
    }

    public static File getDefaultDatabasePath(Context context) {
        return context.getDatabasePath(WORK_DATABASE_NAME);
    }

    private static File getNoBackupPath(Context context, String string) {
        return new File(context.getNoBackupFilesDir(), string);
    }

    public static String getWorkDatabaseName() {
        return WORK_DATABASE_NAME;
    }

    public static void migrateDatabase(Context object) {
        Object object2 = WorkDatabasePathHelper.getDefaultDatabasePath(object);
        if (Build.VERSION.SDK_INT < 23) return;
        if (!((File)object2).exists()) return;
        Logger.get().debug(TAG, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
        Map<File, File> map = WorkDatabasePathHelper.migrationPaths(object);
        object2 = map.keySet().iterator();
        while (object2.hasNext()) {
            File file = (File)object2.next();
            File file2 = map.get(file);
            if (!file.exists() || file2 == null) continue;
            if (file2.exists()) {
                object = String.format("Over-writing contents of %s", file2);
                Logger.get().warning(TAG, (String)object, new Throwable[0]);
            }
            object = file.renameTo(file2) ? String.format("Migrated %s to %s", file, file2) : String.format("Renaming %s to %s failed", file, file2);
            Logger.get().debug(TAG, (String)object, new Throwable[0]);
        }
    }

    public static Map<File, File> migrationPaths(Context object) {
        HashMap<File, File> hashMap = new HashMap<File, File>();
        if (Build.VERSION.SDK_INT < 23) return hashMap;
        File file = WorkDatabasePathHelper.getDefaultDatabasePath(object);
        File file2 = WorkDatabasePathHelper.getDatabasePath(object);
        hashMap.put(file, file2);
        String[] stringArray = DATABASE_EXTRA_FILES;
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            object = stringArray[n2];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getPath());
            stringBuilder.append((String)object);
            File file3 = new File(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(file2.getPath());
            stringBuilder.append((String)object);
            hashMap.put(file3, new File(stringBuilder.toString()));
            ++n2;
        }
        return hashMap;
    }
}
