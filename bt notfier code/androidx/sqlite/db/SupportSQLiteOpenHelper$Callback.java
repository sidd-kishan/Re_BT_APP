/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Pair
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.sqlite.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public static abstract class SupportSQLiteOpenHelper.Callback {
    private static final String TAG = "SupportSQLite";
    public final int version;

    public SupportSQLiteOpenHelper.Callback(int n) {
        this.version = n;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void deleteDatabaseFile(String string) {
        Serializable serializable;
        block6: {
            if (string.equalsIgnoreCase(":memory:")) return;
            if (string.trim().length() == 0) {
                return;
            }
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("deleting the database file: ");
            ((StringBuilder)serializable).append(string);
            Log.w((String)TAG, (String)((StringBuilder)serializable).toString());
            if (Build.VERSION.SDK_INT < 16) break block6;
            serializable = new File(string);
            SQLiteDatabase.deleteDatabase((File)serializable);
            return;
        }
        try {
            serializable = new File(string);
            if (((File)serializable).delete()) return;
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Could not delete the database file ");
            ((StringBuilder)serializable).append(string);
            Log.e((String)TAG, (String)((StringBuilder)serializable).toString());
            return;
        }
        catch (Exception exception) {
            try {
                Log.e((String)TAG, (String)"error while deleting corrupted database file", (Throwable)exception);
                return;
            }
            catch (Exception exception2) {
                Log.w((String)TAG, (String)"delete failed: ", (Throwable)exception2);
            }
        }
    }

    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onCorruption(SupportSQLiteDatabase object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Corruption reported by sqlite on database: ");
        ((StringBuilder)object2).append(object.getPath());
        Log.e((String)TAG, (String)((StringBuilder)object2).toString());
        if (!object.isOpen()) {
            this.deleteDatabaseFile(object.getPath());
            return;
        }
        object2 = null;
        StringBuilder stringBuilder = null;
        try {
            try {
                List list = object.getAttachedDbs();
                object2 = list;
            }
            catch (SQLiteException sQLiteException) {}
            stringBuilder = object2;
            try {
                object.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            if (object2 == null) {
                this.deleteDatabaseFile(object.getPath());
                return;
            }
            object = object2.iterator();
        }
        catch (Throwable throwable) {}
        while (object.hasNext()) {
            this.deleteDatabaseFile((String)((Pair)object.next()).second);
        }
        return;
        if (stringBuilder != null) {
            object = stringBuilder.iterator();
            while (object.hasNext()) {
                this.deleteDatabaseFile((String)((Pair)object.next()).second);
            }
            throw throwable;
        }
        this.deleteDatabaseFile(object.getPath());
        throw throwable;
    }

    public abstract void onCreate(SupportSQLiteDatabase var1);

    public void onDowngrade(SupportSQLiteDatabase object, int n, int n2) {
        object = new StringBuilder();
        ((StringBuilder)object).append("Can't downgrade database from version ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" to ");
        ((StringBuilder)object).append(n2);
        throw new SQLiteException(((StringBuilder)object).toString());
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public abstract void onUpgrade(SupportSQLiteDatabase var1, int var2, int var3);
}
