/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.DatabaseUtils
 *  android.database.sqlite.SQLiteDatabase
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.database.Database
 */
package org.greenrobot.greendao;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.database.Database;

public class DbUtils {
    public static int copyAllBytes(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] byArray = new byte[4096];
        int n = 0;
        int n2;
        while ((n2 = inputStream.read(byArray)) != -1) {
            outputStream.write(byArray, 0, n2);
            n += n2;
        }
        return n;
    }

    public static int executeSqlScript(Context context, Database database, String string) throws IOException {
        return DbUtils.executeSqlScript(context, database, string, true);
    }

    public static int executeSqlScript(Context object, Database database, String string, boolean bl) throws IOException {
        object = new String(DbUtils.readAsset((Context)object, string), "UTF-8").split(";(\\s)*[\n\r]");
        int n = bl ? DbUtils.executeSqlStatementsInTx(database, (String[])object) : DbUtils.executeSqlStatements(database, (String[])object);
        object = new StringBuilder();
        ((StringBuilder)object).append("Executed ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" statements from SQL script '");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("'");
        DaoLog.i((String)((StringBuilder)object).toString());
        return n;
    }

    public static int executeSqlStatements(Database database, String[] stringArray) {
        int n = stringArray.length;
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            String string = stringArray[n2].trim();
            int n4 = n3;
            if (string.length() > 0) {
                database.execSQL(string);
                n4 = n3 + 1;
            }
            ++n2;
            n3 = n4;
        }
        return n3;
    }

    public static int executeSqlStatementsInTx(Database database, String[] stringArray) {
        database.beginTransaction();
        try {
            int n = DbUtils.executeSqlStatements(database, stringArray);
            database.setTransactionSuccessful();
            return n;
        }
        finally {
            database.endTransaction();
        }
    }

    public static void logTableDump(SQLiteDatabase sQLiteDatabase, String string) {
        sQLiteDatabase = sQLiteDatabase.query(string, null, null, null, null, null, null);
        try {
            DaoLog.d((String)DatabaseUtils.dumpCursorToString((Cursor)sQLiteDatabase));
            return;
        }
        finally {
            sQLiteDatabase.close();
        }
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DbUtils.copyAllBytes(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readAsset(Context object, String object2) throws IOException {
        object = object.getResources().getAssets().open((String)object2);
        try {
            object2 = DbUtils.readAllBytes((InputStream)object);
            return object2;
        }
        finally {
            ((InputStream)object).close();
        }
    }

    public static void vacuum(Database database) {
        database.execSQL("VACUUM");
    }
}
