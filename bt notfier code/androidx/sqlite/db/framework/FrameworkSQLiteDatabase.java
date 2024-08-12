/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteDatabase$CursorFactory
 *  android.database.sqlite.SQLiteTransactionListener
 *  android.os.CancellationSignal
 *  android.text.TextUtils
 *  android.util.Pair
 *  androidx.sqlite.db.SimpleSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteProgram
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteStatement
 *  androidx.sqlite.db.framework.FrameworkSQLiteStatement
 */
package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class FrameworkSQLiteDatabase
implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final SQLiteDatabase mDelegate;

    FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.mDelegate = sQLiteDatabase;
    }

    public void beginTransaction() {
        this.mDelegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.mDelegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() throws IOException {
        this.mDelegate.close();
    }

    public SupportSQLiteStatement compileStatement(String string) {
        return new FrameworkSQLiteStatement(this.mDelegate.compileStatement(string));
    }

    public int delete(String charSequence, String string, Object[] objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM ");
        stringBuilder.append((String)charSequence);
        if (TextUtils.isEmpty((CharSequence)string)) {
            charSequence = "";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(" WHERE ");
            ((StringBuilder)charSequence).append(string);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        stringBuilder.append((String)charSequence);
        charSequence = this.compileStatement(stringBuilder.toString());
        SimpleSQLiteQuery.bind((SupportSQLiteProgram)charSequence, (Object[])objectArray);
        return charSequence.executeUpdateDelete();
    }

    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.mDelegate.endTransaction();
    }

    public void execSQL(String string) throws SQLException {
        this.mDelegate.execSQL(string);
    }

    public void execSQL(String string, Object[] objectArray) throws SQLException {
        this.mDelegate.execSQL(string, objectArray);
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    public String getPath() {
        return this.mDelegate.getPath();
    }

    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    public long insert(String string, int n, ContentValues contentValues) throws SQLException {
        return this.mDelegate.insertWithOnConflict(string, null, contentValues, n);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        boolean bl = this.mDelegate == sQLiteDatabase;
        return bl;
    }

    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    public boolean needUpgrade(int n) {
        return this.mDelegate.needUpgrade(n);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return this.mDelegate.rawQueryWithFactory((SQLiteDatabase.CursorFactory)new /* Unavailable Anonymous Inner Class!! */, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        return this.mDelegate.rawQueryWithFactory((SQLiteDatabase.CursorFactory)new /* Unavailable Anonymous Inner Class!! */, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null, cancellationSignal);
    }

    public Cursor query(String string) {
        return this.query((SupportSQLiteQuery)new SimpleSQLiteQuery(string));
    }

    public Cursor query(String string, Object[] objectArray) {
        return this.query((SupportSQLiteQuery)new SimpleSQLiteQuery(string, objectArray));
    }

    public void setForeignKeyConstraintsEnabled(boolean bl) {
        this.mDelegate.setForeignKeyConstraintsEnabled(bl);
    }

    public void setLocale(Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int n) {
        this.mDelegate.setMaxSqlCacheSize(n);
    }

    public long setMaximumSize(long l) {
        return this.mDelegate.setMaximumSize(l);
    }

    public void setPageSize(long l) {
        this.mDelegate.setPageSize(l);
    }

    public void setTransactionSuccessful() {
        this.mDelegate.setTransactionSuccessful();
    }

    public void setVersion(int n) {
        this.mDelegate.setVersion(n);
    }

    public int update(String object, int n, ContentValues contentValues, String string, Object[] objectArray) {
        Iterator iterator;
        int n2;
        Object[] objectArray2;
        int n3;
        StringBuilder stringBuilder;
        if (contentValues != null && contentValues.size() != 0) {
            stringBuilder = new StringBuilder(120);
            stringBuilder.append("UPDATE ");
            stringBuilder.append(CONFLICT_VALUES[n]);
            stringBuilder.append((String)object);
            stringBuilder.append(" SET ");
            n = contentValues.size();
            n3 = objectArray == null ? n : objectArray.length + n;
            objectArray2 = new Object[n3];
            n2 = 0;
            iterator = contentValues.keySet().iterator();
        } else {
            object = new IllegalArgumentException("Empty values");
            throw object;
        }
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            object = n2 > 0 ? "," : "";
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            objectArray2[n2] = contentValues.get(string2);
            stringBuilder.append("=?");
            ++n2;
        }
        if (objectArray != null) {
            for (n2 = n; n2 < n3; ++n2) {
                objectArray2[n2] = objectArray[n2 - n];
            }
        }
        if (!TextUtils.isEmpty((CharSequence)string)) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(string);
        }
        object = this.compileStatement(stringBuilder.toString());
        SimpleSQLiteQuery.bind((SupportSQLiteProgram)object, (Object[])objectArray2);
        return object.executeUpdateDelete();
    }

    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long l) {
        return this.mDelegate.yieldIfContendedSafely(l);
    }
}
