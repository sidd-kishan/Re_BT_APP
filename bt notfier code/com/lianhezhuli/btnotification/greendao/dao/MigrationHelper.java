/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  android.text.TextUtils
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.StandardDatabase
 *  org.greenrobot.greendao.internal.DaoConfig
 */
package com.lianhezhuli.btnotification.greendao.dao;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.internal.DaoConfig;

public final class MigrationHelper {
    private static void createAllTables(Database database, boolean bl, Class<? extends AbstractDao<?, ?>> ... classArray) {
        MigrationHelper.reflectMethod(database, "createTable", bl, classArray);
    }

    private static void dropAllTables(Database database, boolean bl, Class<? extends AbstractDao<?, ?>> ... classArray) {
        MigrationHelper.reflectMethod(database, "dropTable", bl, classArray);
    }

    private static void generateNewTablesIfNotExists(Database database, Class<? extends AbstractDao<?, ?>> ... classArray) {
        MigrationHelper.reflectMethod(database, "createTable", true, classArray);
    }

    private static void generateTempTables(Database database, Class<? extends AbstractDao<?, ?>> ... classArray) {
        int n = 0;
        while (n < classArray.length) {
            Object object = new DaoConfig(database, classArray[n]);
            String string = object.tablename;
            object = object.tablename.concat("_TEMP");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TEMP TABLE ");
            stringBuilder.append((String)object);
            stringBuilder.append(" AS SELECT * FROM ");
            stringBuilder.append(string);
            stringBuilder.append(";");
            database.execSQL(stringBuilder.toString());
            ++n;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private static List<String> getColumns(Database object, String arrayList) {
        void var0_3;
        Object object2;
        block10: {
            block11: {
                block9: {
                    Database database = null;
                    Object var3_7 = null;
                    Object var4_8 = null;
                    object2 = database;
                    try {
                        object2 = database;
                        StringBuilder stringBuilder = new StringBuilder();
                        object2 = database;
                        stringBuilder.append("SELECT * FROM ");
                        object2 = database;
                        stringBuilder.append((String)((Object)arrayList));
                        object2 = database;
                        stringBuilder.append(" limit 0");
                        object2 = database;
                        arrayList = object.rawQuery(stringBuilder.toString(), null);
                        object = var4_8;
                        if (arrayList == null) break block9;
                        object = var4_8;
                    }
                    catch (Throwable throwable) {
                        break block10;
                    }
                    catch (Exception exception) {
                        object = var3_7;
                        break block11;
                    }
                    try {
                        if (arrayList.getColumnCount() <= 0) break block9;
                        object = Arrays.asList(arrayList.getColumnNames());
                    }
                    catch (Throwable throwable) {
                        object2 = arrayList;
                        break block10;
                    }
                    catch (Exception exception) {
                        object = arrayList;
                        arrayList = exception;
                        break block11;
                    }
                }
                if (arrayList != null) {
                    arrayList.close();
                }
                arrayList = object;
                if (object != null) return arrayList;
                return new ArrayList();
            }
            object2 = object;
            {
                ((Throwable)((Object)arrayList)).printStackTrace();
                if (object == null) return new ArrayList();
            }
            object.close();
            return new ArrayList();
        }
        if (object2 != null) {
            object2.close();
        }
        new ArrayList();
        throw var0_3;
    }

    public static void migrate(SQLiteDatabase sQLiteDatabase, Class<? extends AbstractDao<?, ?>> ... classArray) {
        sQLiteDatabase = new StandardDatabase(sQLiteDatabase);
        MigrationHelper.generateNewTablesIfNotExists((Database)sQLiteDatabase, classArray);
        MigrationHelper.generateTempTables((Database)sQLiteDatabase, classArray);
        MigrationHelper.dropAllTables((Database)sQLiteDatabase, true, classArray);
        MigrationHelper.createAllTables((Database)sQLiteDatabase, false, classArray);
        MigrationHelper.restoreData((Database)sQLiteDatabase, classArray);
    }

    public static void migrate(Database database, Class<? extends AbstractDao<?, ?>> ... classArray) {
        MigrationHelper.generateNewTablesIfNotExists(database, classArray);
        MigrationHelper.generateTempTables(database, classArray);
        MigrationHelper.dropAllTables(database, true, classArray);
        MigrationHelper.createAllTables(database, false, classArray);
        MigrationHelper.restoreData(database, classArray);
    }

    private static void reflectMethod(Database database, String string, boolean bl, Class<? extends AbstractDao<?, ?>> ... classArray) {
        if (classArray.length < 1) {
            return;
        }
        try {
            int n = classArray.length;
            int n2 = 0;
            while (n2 < n) {
                classArray[n2].getDeclaredMethod(string, Database.class, Boolean.TYPE).invoke(null, database, bl);
                ++n2;
            }
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
    }

    private static void restoreData(Database database, Class<? extends AbstractDao<?, ?>> ... classArray) {
        int n = 0;
        while (n < classArray.length) {
            String string;
            DaoConfig daoConfig = new DaoConfig(database, classArray[n]);
            CharSequence charSequence = daoConfig.tablename;
            String string2 = daoConfig.tablename.concat("_TEMP");
            Object object = MigrationHelper.getColumns(database, string2);
            ArrayList<String> arrayList = new ArrayList<String>(object.size());
            for (int i = 0; i < daoConfig.properties.length; ++i) {
                string = daoConfig.properties[i].columnName;
                if (!object.contains(string)) continue;
                arrayList.add(string);
            }
            if (arrayList.size() > 0) {
                string = TextUtils.join((CharSequence)",", arrayList);
                object = new StringBuilder();
                ((StringBuilder)object).append("INSERT INTO ");
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append(" (");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(") SELECT ");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(" FROM ");
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(";");
                database.execSQL(((StringBuilder)object).toString());
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("DROP TABLE ");
            ((StringBuilder)charSequence).append(string2);
            database.execSQL(((StringBuilder)charSequence).toString());
            ++n;
        }
    }
}
