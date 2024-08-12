/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CrossProcessCursor
 *  android.database.Cursor
 *  android.database.CursorWindow
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteStatement
 *  org.greenrobot.greendao.AbstractDaoSession
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.DatabaseStatement
 *  org.greenrobot.greendao.identityscope.IdentityScope
 *  org.greenrobot.greendao.identityscope.IdentityScopeLong
 *  org.greenrobot.greendao.internal.DaoConfig
 *  org.greenrobot.greendao.internal.FastCursor
 *  org.greenrobot.greendao.internal.TableStatements
 *  org.greenrobot.greendao.query.Query
 *  org.greenrobot.greendao.query.QueryBuilder
 *  org.greenrobot.greendao.rx.RxDao
 *  rx.schedulers.Schedulers
 */
package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.FastCursor;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;
import rx.schedulers.Schedulers;

public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;
    protected final Database db;
    protected final IdentityScope<K, T> identityScope;
    protected final IdentityScopeLong<T> identityScopeLong;
    protected final boolean isStandardSQLite;
    protected final int pkOrdinal;
    private volatile RxDao<T, K> rxDao;
    private volatile RxDao<T, K> rxDaoPlain;
    protected final AbstractDaoSession session;
    protected final TableStatements statements;

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, null);
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        abstractDaoSession = daoConfig.db;
        this.db = abstractDaoSession;
        this.isStandardSQLite = abstractDaoSession.getRawDatabase() instanceof SQLiteDatabase;
        this.identityScope = abstractDaoSession = daoConfig.getIdentityScope();
        this.identityScopeLong = abstractDaoSession instanceof IdentityScopeLong ? (IdentityScopeLong)abstractDaoSession : null;
        this.statements = daoConfig.statements;
        int n = daoConfig.pkProperty != null ? daoConfig.pkProperty.ordinal : -1;
        this.pkOrdinal = n;
    }

    private void deleteByKeyInsideSynchronized(K k, DatabaseStatement databaseStatement) {
        if (k instanceof Long) {
            databaseStatement.bindLong(1, ((Long)k).longValue());
        } else {
            if (k == null) throw new DaoException("Cannot delete entity, key is null");
            databaseStatement.bindString(1, k.toString());
        }
        databaseStatement.execute();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    private void deleteInTxInternal(Iterable<T> object, Iterable<K> iterable2) {
        block17: {
            ArrayList<Object> arrayList;
            this.assertSinglePk();
            DatabaseStatement databaseStatement = this.statements.getDeleteStatement();
            this.db.beginTransaction();
            try {
                synchronized (databaseStatement) {
                    if (this.identityScope == null) break block15;
                }
            }
            catch (Throwable throwable) {
                this.db.endTransaction();
                throw throwable;
            }
            {
                block19: {
                    Throwable throwable2;
                    block16: {
                        block18: {
                            block15: {
                                this.identityScope.lock();
                                arrayList = new ArrayList<Object>();
                                break block18;
                            }
                            arrayList = null;
                        }
                        if (object != null) {
                            try {
                                Iterator<T> iterator = object.iterator();
                                while (iterator.hasNext()) {
                                    object = this.getKeyVerified(iterator.next());
                                    this.deleteByKeyInsideSynchronized(object, databaseStatement);
                                    if (arrayList == null) continue;
                                    arrayList.add(object);
                                }
                            }
                            catch (Throwable throwable2) {
                                break block16;
                            }
                        }
                        if (iterable2 != null) {
                            for (Iterable<Object> iterable2 : iterable2) {
                                this.deleteByKeyInsideSynchronized(iterable2, databaseStatement);
                                if (arrayList == null) continue;
                                arrayList.add(iterable2);
                            }
                        }
                        break block19;
                    }
                    if (this.identityScope == null) throw throwable2;
                    this.identityScope.unlock();
                    throw throwable2;
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            {
                this.db.setTransactionSuccessful();
                if (arrayList == null || this.identityScope == null) break block17;
                this.identityScope.remove(arrayList);
            }
        }
        this.db.endTransaction();
    }

    private long executeInsert(T t, DatabaseStatement databaseStatement, boolean bl) {
        long l;
        if (this.db.isDbLockedByCurrentThread()) {
            l = this.insertInsideTx(t, databaseStatement);
        } else {
            this.db.beginTransaction();
            l = this.insertInsideTx(t, databaseStatement);
            this.db.setTransactionSuccessful();
        }
        if (!bl) return l;
        this.updateKeyAfterInsertAndAttach(t, l, true);
        return l;
        finally {
            this.db.endTransaction();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private void executeInsertInTx(DatabaseStatement databaseStatement, Iterable<T> iterator, boolean bl) {
        this.db.beginTransaction();
        try {
            synchronized (databaseStatement) {
                if (this.identityScope == null) break block18;
            }
        }
        catch (Throwable throwable) {
            this.db.endTransaction();
            throw throwable;
        }
        {
            void var3_5;
            block18: {
                this.identityScope.lock();
            }
            if (this.isStandardSQLite) {
                SQLiteStatement sQLiteStatement = (SQLiteStatement)databaseStatement.getRawStatement();
                Iterator iterator2 = iterator.iterator();
                while (iterator2.hasNext()) {
                    iterator = iterator2.next();
                    this.bindValues(sQLiteStatement, iterator);
                    if (var3_5 != false) {
                        this.updateKeyAfterInsertAndAttach(iterator, sQLiteStatement.executeInsert(), false);
                        continue;
                    }
                    sQLiteStatement.execute();
                }
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    Object t = iterator.next();
                    this.bindValues(databaseStatement, t);
                    if (var3_5 != false) {
                        this.updateKeyAfterInsertAndAttach(t, databaseStatement.executeInsert(), false);
                        continue;
                    }
                    databaseStatement.execute();
                }
            }
        }
        {
            this.db.setTransactionSuccessful();
        }
        this.db.endTransaction();
        return;
        {
            finally {
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
        }
    }

    private long insertInsideTx(T t, DatabaseStatement databaseStatement) {
        synchronized (databaseStatement) {
            if (this.isStandardSQLite) {
                SQLiteStatement sQLiteStatement = (SQLiteStatement)databaseStatement.getRawStatement();
                this.bindValues(sQLiteStatement, t);
                long l = sQLiteStatement.executeInsert();
                return l;
            }
            this.bindValues(databaseStatement, t);
            long l = databaseStatement.executeInsert();
            return l;
        }
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int n = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int n2 = 0;
        while (true) {
            list.add(this.loadCurrent(cursor, 0, false));
            if (++n2 >= n) {
                cursorWindow = this.moveToNextUnlocked(cursor);
                if (cursorWindow == null) return;
                n = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
            } else if (!cursor.moveToNext()) return;
            ++n2;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor object) {
        this.identityScope.unlock();
        try {
            object = object.moveToNext() ? ((CrossProcessCursor)object).getWindow() : null;
        }
        finally {
            this.identityScope.lock();
        }
        return object;
    }

    protected void assertSinglePk() {
        if (this.config.pkColumns.length == 1) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this);
        stringBuilder.append(" (");
        stringBuilder.append(this.config.tablename);
        stringBuilder.append(") does not have a single-column primary key");
        throw new DaoException(stringBuilder.toString());
    }

    protected void attachEntity(T t) {
    }

    protected final void attachEntity(K k, T t, boolean bl) {
        this.attachEntity(t);
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope == null) return;
        if (k == null) return;
        if (bl) {
            identityScope.put(k, t);
        } else {
            identityScope.putNoLock(k, t);
        }
    }

    protected abstract void bindValues(SQLiteStatement var1, T var2);

    protected abstract void bindValues(DatabaseStatement var1, T var2);

    public long count() {
        return this.statements.getCountStatement().simpleQueryForLong();
    }

    public void delete(T t) {
        this.assertSinglePk();
        this.deleteByKey(this.getKeyVerified(t));
    }

    public void deleteAll() {
        IdentityScope<K, T> identityScope = this.db;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM '");
        stringBuilder.append(this.config.tablename);
        stringBuilder.append("'");
        identityScope.execSQL(stringBuilder.toString());
        identityScope = this.identityScope;
        if (identityScope == null) return;
        identityScope.clear();
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void deleteByKey(K k) {
        this.assertSinglePk();
        IdentityScope<K, T> identityScope = this.statements.getDeleteStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            // MONITORENTER : identityScope
            this.deleteByKeyInsideSynchronized(k, (DatabaseStatement)identityScope);
            // MONITOREXIT : identityScope
        } else {
            this.db.beginTransaction();
            this.deleteByKeyInsideSynchronized(k, (DatabaseStatement)identityScope);
            // MONITOREXIT : identityScope
            this.db.setTransactionSuccessful();
        }
        identityScope = this.identityScope;
        if (identityScope == null) return;
        identityScope.remove(k);
        return;
        finally {
            this.db.endTransaction();
        }
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        this.deleteInTxInternal(null, iterable);
    }

    public void deleteByKeyInTx(K ... KArray) {
        this.deleteInTxInternal(null, Arrays.asList(KArray));
    }

    public void deleteInTx(Iterable<T> iterable) {
        this.deleteInTxInternal(iterable, null);
    }

    public void deleteInTx(T ... TArray) {
        this.deleteInTxInternal(Arrays.asList(TArray), null);
    }

    public boolean detach(T t) {
        if (this.identityScope == null) return false;
        K k = this.getKeyVerified(t);
        return this.identityScope.detach(k, t);
    }

    public void detachAll() {
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope == null) return;
        identityScope.clear();
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public Database getDatabase() {
        return this.db;
    }

    protected abstract K getKey(T var1);

    protected K getKeyVerified(T t) {
        K k = this.getKey(t);
        if (k != null) return k;
        if (t != null) throw new DaoException("Entity has no key");
        throw new NullPointerException("Entity may not be null");
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    protected abstract boolean hasKey(T var1);

    public long insert(T t) {
        return this.executeInsert(t, this.statements.getInsertStatement(), true);
    }

    public void insertInTx(Iterable<T> iterable) {
        this.insertInTx(iterable, this.isEntityUpdateable());
    }

    public void insertInTx(Iterable<T> iterable, boolean bl) {
        this.executeInsertInTx(this.statements.getInsertStatement(), iterable, bl);
    }

    public void insertInTx(T ... TArray) {
        this.insertInTx((Iterable<T>)Arrays.asList(TArray), this.isEntityUpdateable());
    }

    public long insertOrReplace(T t) {
        return this.executeInsert(t, this.statements.getInsertOrReplaceStatement(), true);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        this.insertOrReplaceInTx(iterable, this.isEntityUpdateable());
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean bl) {
        this.executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, bl);
    }

    public void insertOrReplaceInTx(T ... TArray) {
        this.insertOrReplaceInTx((Iterable<T>)Arrays.asList(TArray), this.isEntityUpdateable());
    }

    public long insertWithoutSettingPk(T t) {
        return this.executeInsert(t, this.statements.getInsertOrReplaceStatement(), false);
    }

    protected abstract boolean isEntityUpdateable();

    public T load(K object) {
        this.assertSinglePk();
        if (object == null) {
            return null;
        }
        Object object2 = this.identityScope;
        if (object2 != null && (object2 = object2.get(object)) != null) {
            return (T)object2;
        }
        object2 = this.statements.getSelectByKey();
        object = object.toString();
        return this.loadUniqueAndCloseCursor(this.db.rawQuery(object2, new String[]{object}));
    }

    public List<T> loadAll() {
        return this.loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll(), null));
    }

    protected List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            List<T> list = this.loadAllFromCursor(cursor);
            return list;
        }
        finally {
            cursor.close();
        }
    }

    /*
     * Unable to fully structure code
     */
    protected List<T> loadAllFromCursor(Cursor var1_1) {
        var3_2 = var1_1.getCount();
        if (var3_2 == 0) {
            return new ArrayList<E>();
        }
        var7_3 = new ArrayList<T>(var3_2);
        var5_4 = null;
        if (!(var1_1 instanceof CrossProcessCursor)) ** GOTO lbl27
        var6_6 = ((CrossProcessCursor)var1_1).getWindow();
        var5_4 = var6_6;
        if (var6_6 == null) ** GOTO lbl27
        if (var6_6.getNumRows() == var3_2) {
            var1_1 = new FastCursor(var6_6);
            var2_7 = true;
            var5_4 = var6_6;
        } else {
            var5_4 = new StringBuilder();
            var5_4.append("Window vs. result size: ");
            var5_4.append(var6_6.getNumRows());
            var5_4.append("/");
            var5_4.append(var3_2);
            DaoLog.d((String)var5_4.toString());
            var5_4 = var6_6;
lbl27:
            // 3 sources

            var2_7 = false;
        }
        if (var1_1.moveToFirst() == false) return var7_3;
        var6_6 = this.identityScope;
        if (var6_6 != null) {
            var6_6.lock();
            this.identityScope.reserveRoom(var3_2);
        }
        if (var2_7 || var5_4 == null) ** GOTO lbl-1000
        try {
            if (this.identityScope != null) {
                this.loadAllUnlockOnWindowBounds((Cursor)var1_1, (CursorWindow)var5_4, (List<T>)var7_3);
            } else lbl-1000:
            // 2 sources

            {
                do {
                    var7_3.add(this.loadCurrent((Cursor)var1_1, 0, false));
                } while (var4_8 = var1_1.moveToNext());
            }
            var1_1 = this.identityScope;
            if (var1_1 == null) return var7_3;
        }
        catch (Throwable var5_5) {
            var1_1 = this.identityScope;
            if (var1_1 == null) throw var5_5;
            var1_1.unlock();
            throw var5_5;
        }
        var1_1.unlock();
        return var7_3;
    }

    public T loadByRowId(long l) {
        String string = Long.toString(l);
        return this.loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByRowId(), new String[]{string}));
    }

    protected final T loadCurrent(Cursor object, int n, boolean bl) {
        if (this.identityScopeLong != null) {
            if (n != 0 && object.isNull(this.pkOrdinal + n)) {
                return null;
            }
            long l = object.getLong(this.pkOrdinal + n);
            Object object2 = this.identityScopeLong;
            object2 = bl ? object2.get2(l) : object2.get2NoLock(l);
            if (object2 != null) {
                return (T)object2;
            }
            object = this.readEntity((Cursor)object, n);
            this.attachEntity(object);
            if (bl) {
                this.identityScopeLong.put2(l, object);
            } else {
                this.identityScopeLong.put2NoLock(l, object);
            }
            return (T)object;
        }
        if (this.identityScope != null) {
            K k = this.readKey((Cursor)object, n);
            if (n != 0 && k == null) {
                return null;
            }
            Object object3 = this.identityScope;
            object3 = bl ? object3.get(k) : object3.getNoLock(k);
            if (object3 != null) {
                return (T)object3;
            }
            object = this.readEntity((Cursor)object, n);
            this.attachEntity(k, object, bl);
            return (T)object;
        }
        if (n != 0 && this.readKey((Cursor)object, n) == null) {
            return null;
        }
        object = this.readEntity((Cursor)object, n);
        this.attachEntity(object);
        return (T)object;
    }

    protected final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int n) {
        return abstractDao.loadCurrent(cursor, n, true);
    }

    protected T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return this.loadCurrent(cursor, 0, true);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected unique result, but count was ");
        stringBuilder.append(cursor.getCount());
        throw new DaoException(stringBuilder.toString());
    }

    protected T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            T t = this.loadUnique(cursor);
            return t;
        }
        finally {
            cursor.close();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate((AbstractDao)this);
    }

    public List<T> queryRaw(String string, String ... stringArray) {
        Database database = this.db;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.statements.getSelectAll());
        stringBuilder.append(string);
        return this.loadAllAndCloseCursor(database.rawQuery(stringBuilder.toString(), stringArray));
    }

    public Query<T> queryRawCreate(String string, Object ... objectArray) {
        return this.queryRawCreateListArgs(string, Arrays.asList(objectArray));
    }

    public Query<T> queryRawCreateListArgs(String string, Collection<Object> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.statements.getSelectAll());
        stringBuilder.append(string);
        return Query.internalCreate((AbstractDao)this, (String)stringBuilder.toString(), (Object[])collection.toArray());
    }

    protected abstract T readEntity(Cursor var1, int var2);

    protected abstract void readEntity(Cursor var1, T var2, int var3);

    protected abstract K readKey(Cursor var1, int var2);

    public void refresh(T object) {
        this.assertSinglePk();
        Object object2 = this.getKeyVerified(object);
        String string = this.statements.getSelectByKey();
        String string2 = object2.toString();
        string2 = this.db.rawQuery(string, new String[]{string2});
        try {
            if (string2.moveToFirst()) {
                if (string2.isLast()) {
                    this.readEntity((Cursor)string2, object, 0);
                    this.attachEntity(object2, object, true);
                    return;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Expected unique result, but count was ");
                ((StringBuilder)object2).append(string2.getCount());
                object = new DaoException(((StringBuilder)object2).toString());
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Entity does not exist in the database anymore: ");
            stringBuilder.append(object.getClass());
            stringBuilder.append(" with key ");
            stringBuilder.append(object2);
            string = new DaoException(stringBuilder.toString());
            throw string;
        }
        finally {
            string2.close();
        }
    }

    public RxDao<T, K> rx() {
        if (this.rxDao != null) return this.rxDao;
        this.rxDao = new RxDao(this, Schedulers.io());
        return this.rxDao;
    }

    public RxDao<T, K> rxPlain() {
        if (this.rxDaoPlain != null) return this.rxDaoPlain;
        this.rxDaoPlain = new RxDao(this);
        return this.rxDaoPlain;
    }

    public void save(T t) {
        if (this.hasKey(t)) {
            this.update(t);
        } else {
            this.insert(t);
        }
    }

    public void saveInTx(Iterable<T> iterable2) {
        Object object = iterable2.iterator();
        int n = 0;
        int n2 = 0;
        while (object.hasNext()) {
            if (this.hasKey(object.next())) {
                ++n;
                continue;
            }
            ++n2;
        }
        if (n <= 0 || n2 <= 0) {
            if (n2 > 0) {
                this.insertInTx(iterable2);
            } else {
                if (n <= 0) return;
                this.updateInTx(iterable2);
            }
        } else {
            object = new ArrayList(n);
            ArrayList<Iterable<T>> arrayList = new ArrayList<Iterable<T>>(n2);
            for (Iterable<T> iterable2 : iterable2) {
                if (this.hasKey(iterable2)) {
                    object.add(iterable2);
                    continue;
                }
                arrayList.add(iterable2);
            }
            this.db.beginTransaction();
            try {
                this.updateInTx((Iterable<T>)object);
                this.insertInTx((Iterable<T>)arrayList);
                this.db.setTransactionSuccessful();
            }
            finally {
                this.db.endTransaction();
            }
        }
    }

    public void saveInTx(T ... TArray) {
        this.saveInTx((Iterable<T>)Arrays.asList(TArray));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void update(T t) {
        this.assertSinglePk();
        DatabaseStatement databaseStatement = this.statements.getUpdateStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (databaseStatement) {
                if (this.isStandardSQLite) {
                    this.updateInsideSynchronized(t, (SQLiteStatement)databaseStatement.getRawStatement(), true);
                } else {
                    this.updateInsideSynchronized(t, databaseStatement, true);
                }
                return;
            }
        }
        this.db.beginTransaction();
        synchronized (databaseStatement) {
            this.updateInsideSynchronized(t, databaseStatement, true);
        }
        try {
            this.db.setTransactionSuccessful();
            return;
        }
        finally {
            this.db.endTransaction();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public void updateInTx(Iterable<T> iterator) {
        block24: {
            DatabaseStatement databaseStatement = this.statements.getUpdateStatement();
            this.db.beginTransaction();
            try {
                synchronized (databaseStatement) {
                    if (this.identityScope == null) break block23;
                }
            }
            catch (Throwable throwable) {
                this.db.endTransaction();
                throw throwable;
            }
            catch (RuntimeException runtimeException) {
                try {
                    this.db.endTransaction();
                    break block24;
                }
                catch (RuntimeException runtimeException2) {
                    DaoLog.w((String)"Could not end transaction (rethrowing initial exception)", (Throwable)runtimeException2);
                    throw runtimeException;
                }
            }
            {
                block23: {
                    this.identityScope.lock();
                }
                if (this.isStandardSQLite) {
                    SQLiteStatement sQLiteStatement = (SQLiteStatement)databaseStatement.getRawStatement();
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        this.updateInsideSynchronized(iterator.next(), sQLiteStatement, false);
                    }
                } else {
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        this.updateInsideSynchronized(iterator.next(), databaseStatement, false);
                    }
                }
            }
            {
                this.db.setTransactionSuccessful();
            }
            this.db.endTransaction();
            iterator = null;
            {
                finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
        }
        if (iterator != null) throw iterator;
    }

    public void updateInTx(T ... TArray) {
        this.updateInTx((Iterable<T>)Arrays.asList(TArray));
    }

    protected void updateInsideSynchronized(T t, SQLiteStatement sQLiteStatement, boolean bl) {
        this.bindValues(sQLiteStatement, t);
        int n = this.config.allColumns.length + 1;
        K k = this.getKey(t);
        if (k instanceof Long) {
            sQLiteStatement.bindLong(n, ((Long)k).longValue());
        } else {
            if (k == null) throw new DaoException("Cannot update entity without key - was it inserted before?");
            sQLiteStatement.bindString(n, k.toString());
        }
        sQLiteStatement.execute();
        this.attachEntity(k, t, bl);
    }

    protected void updateInsideSynchronized(T t, DatabaseStatement databaseStatement, boolean bl) {
        this.bindValues(databaseStatement, t);
        int n = this.config.allColumns.length + 1;
        K k = this.getKey(t);
        if (k instanceof Long) {
            databaseStatement.bindLong(n, ((Long)k).longValue());
        } else {
            if (k == null) throw new DaoException("Cannot update entity without key - was it inserted before?");
            databaseStatement.bindString(n, k.toString());
        }
        databaseStatement.execute();
        this.attachEntity(k, t, bl);
    }

    protected abstract K updateKeyAfterInsert(T var1, long var2);

    protected void updateKeyAfterInsertAndAttach(T t, long l, boolean bl) {
        if (l != -1L) {
            this.attachEntity(this.updateKeyAfterInsert(t, l), t, bl);
        } else {
            DaoLog.w((String)"Could not insert row (executeInsert returned -1)");
        }
    }
}
