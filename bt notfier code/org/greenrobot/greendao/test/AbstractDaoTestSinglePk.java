/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.DatabaseUtils
 *  android.database.SQLException
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.internal.SqlUtils
 *  org.greenrobot.greendao.test.AbstractDaoTest
 */
package org.greenrobot.greendao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.test.AbstractDaoTest;

public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K>
extends AbstractDaoTest<D, T, K> {
    private Property pkColumn;
    protected Set<K> usedPks = new HashSet<K>();

    public AbstractDaoTestSinglePk(Class<D> clazz) {
        super(clazz);
    }

    protected boolean checkKeyIsNullable() {
        if (this.createEntity(null) != null) return true;
        DaoLog.d((String)"Test is not available for entities with non-null keys");
        return false;
    }

    protected abstract T createEntity(K var1);

    protected T createEntityWithRandomPk() {
        return this.createEntity(this.nextPk());
    }

    protected abstract K createRandomPk();

    protected K nextPk() {
        int n = 0;
        while (true) {
            Object object;
            if (n >= 100000) {
                object = new IllegalStateException("Could not find a new PK");
                throw object;
            }
            object = this.createRandomPk();
            if (this.usedPks.add(object)) {
                return object;
            }
            ++n;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    protected Cursor queryWithDummyColumnsInFront(int n, String string, K k) {
        RuntimeException runtimeException2;
        CharSequence charSequence;
        block6: {
            int n2;
            charSequence = new StringBuilder("SELECT ");
            int n3 = 0;
            for (n2 = 0; n2 < n; ++n2) {
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append(",");
            }
            SqlUtils.appendColumns((StringBuilder)charSequence, (String)"T", (String[])this.dao.getAllColumns()).append(" FROM ");
            ((StringBuilder)charSequence).append('\"');
            ((StringBuilder)charSequence).append(this.dao.getTablename());
            ((StringBuilder)charSequence).append('\"');
            ((StringBuilder)charSequence).append(" T");
            if (k != null) {
                ((StringBuilder)charSequence).append(" WHERE ");
                AbstractDaoTestSinglePk.assertEquals((int)1, (int)this.dao.getPkColumns().length);
                ((StringBuilder)charSequence).append(this.dao.getPkColumns()[0]);
                ((StringBuilder)charSequence).append("=");
                DatabaseUtils.appendValueToSql((StringBuilder)charSequence, k);
            }
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence = this.db.rawQuery((String)charSequence, null);
            AbstractDaoTestSinglePk.assertTrue((boolean)charSequence.moveToFirst());
            for (n2 = n3; n2 < n; ++n2) {
                try {
                    AbstractDaoTestSinglePk.assertEquals((String)string, (String)charSequence.getString(n2));
                    continue;
                }
                catch (RuntimeException runtimeException2) {
                    break block6;
                }
            }
            if (k == null) return charSequence;
            {
                AbstractDaoTestSinglePk.assertEquals((int)1, (int)charSequence.getCount());
                return charSequence;
            }
        }
        charSequence.close();
        throw runtimeException2;
    }

    protected void runLoadPkTest(int n) {
        K k = this.nextPk();
        Object object = this.createEntity(k);
        this.dao.insert(object);
        object = this.queryWithDummyColumnsInFront(n, "42", k);
        try {
            AbstractDaoTestSinglePk.assertEquals(k, (Object)this.daoAccess.readKey(object, n));
            return;
        }
        finally {
            object.close();
        }
    }

    protected void setUp() throws Exception {
        super.setUp();
        for (Property property : this.daoAccess.getProperties()) {
            if (!property.primaryKey) continue;
            if (this.pkColumn != null) throw new RuntimeException("Test does not work with multiple PK columns");
            this.pkColumn = property;
        }
        if (this.pkColumn != null) {
            return;
        }
        RuntimeException runtimeException = new RuntimeException("Test does not work without a PK column");
        throw runtimeException;
    }

    public void testCount() {
        this.dao.deleteAll();
        AbstractDaoTestSinglePk.assertEquals((long)0L, (long)this.dao.count());
        this.dao.insert(this.createEntityWithRandomPk());
        AbstractDaoTestSinglePk.assertEquals((long)1L, (long)this.dao.count());
        this.dao.insert(this.createEntityWithRandomPk());
        AbstractDaoTestSinglePk.assertEquals((long)2L, (long)this.dao.count());
    }

    public void testDelete() {
        K k = this.nextPk();
        this.dao.deleteByKey(k);
        T t = this.createEntity(k);
        this.dao.insert(t);
        AbstractDaoTestSinglePk.assertNotNull((Object)this.dao.load(k));
        this.dao.deleteByKey(k);
        AbstractDaoTestSinglePk.assertNull((Object)this.dao.load(k));
    }

    public void testDeleteAll() {
        Object object = new ArrayList<T>();
        for (int i = 0; i < 10; ++i) {
            object.add(this.createEntityWithRandomPk());
        }
        this.dao.insertInTx(object);
        this.dao.deleteAll();
        AbstractDaoTestSinglePk.assertEquals((long)0L, (long)this.dao.count());
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = this.daoAccess.getKey(object2);
            AbstractDaoTestSinglePk.assertNotNull(object2);
            AbstractDaoTestSinglePk.assertNull((Object)this.dao.load(object2));
        }
    }

    public void testDeleteByKeyInTx() {
        Object object = new ArrayList<T>();
        for (int i = 0; i < 10; ++i) {
            object.add(this.createEntityWithRandomPk());
        }
        this.dao.insertInTx(object);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(this.daoAccess.getKey(object.get(0)));
        arrayList.add(this.daoAccess.getKey(object.get(3)));
        arrayList.add(this.daoAccess.getKey(object.get(4)));
        arrayList.add(this.daoAccess.getKey(object.get(8)));
        this.dao.deleteByKeyInTx(arrayList);
        AbstractDaoTestSinglePk.assertEquals((long)(object.size() - arrayList.size()), (long)this.dao.count());
        object = arrayList.iterator();
        while (object.hasNext()) {
            arrayList = object.next();
            AbstractDaoTestSinglePk.assertNotNull(arrayList);
            AbstractDaoTestSinglePk.assertNull((Object)this.dao.load(arrayList));
        }
    }

    public void testDeleteInTx() {
        Object object = new ArrayList<T>();
        for (int i = 0; i < 10; ++i) {
            object.add(this.createEntityWithRandomPk());
        }
        this.dao.insertInTx(object);
        Object object2 = new ArrayList();
        object2.add(object.get(0));
        object2.add(object.get(3));
        object2.add(object.get(4));
        object2.add(object.get(8));
        this.dao.deleteInTx(object2);
        AbstractDaoTestSinglePk.assertEquals((long)(object.size() - object2.size()), (long)this.dao.count());
        object = object2.iterator();
        while (object.hasNext()) {
            object2 = object.next();
            object2 = this.daoAccess.getKey(object2);
            AbstractDaoTestSinglePk.assertNotNull((Object)object2);
            AbstractDaoTestSinglePk.assertNull((Object)this.dao.load(object2));
        }
    }

    public void testInsertAndLoad() {
        Object object = this.nextPk();
        T t = this.createEntity(object);
        this.dao.insert(t);
        AbstractDaoTestSinglePk.assertEquals(object, (Object)this.daoAccess.getKey(t));
        object = this.dao.load(object);
        AbstractDaoTestSinglePk.assertNotNull(object);
        AbstractDaoTestSinglePk.assertEquals((Object)this.daoAccess.getKey(t), (Object)this.daoAccess.getKey(object));
    }

    public void testInsertInTx() {
        this.dao.deleteAll();
        ArrayList<T> arrayList = new ArrayList<T>();
        int n = 0;
        while (true) {
            if (n >= 20) {
                this.dao.insertInTx(arrayList);
                AbstractDaoTestSinglePk.assertEquals((long)arrayList.size(), (long)this.dao.count());
                return;
            }
            arrayList.add(this.createEntityWithRandomPk());
            ++n;
        }
    }

    public void testInsertOrReplaceInTx() {
        this.dao.deleteAll();
        ArrayList<T> arrayList = new ArrayList<T>();
        ArrayList<T> arrayList2 = new ArrayList<T>();
        int n = 0;
        while (true) {
            if (n >= 20) {
                this.dao.insertOrReplaceInTx(arrayList);
                this.dao.insertOrReplaceInTx(arrayList2);
                AbstractDaoTestSinglePk.assertEquals((long)arrayList2.size(), (long)this.dao.count());
                return;
            }
            T t = this.createEntityWithRandomPk();
            if (n % 2 == 0) {
                arrayList.add(t);
            }
            arrayList2.add(t);
            ++n;
        }
    }

    public void testInsertOrReplaceTwice() {
        T t = this.createEntityWithRandomPk();
        long l = this.dao.insert(t);
        long l2 = this.dao.insertOrReplace(t);
        if (this.dao.getPkProperty().type != Long.class) return;
        AbstractDaoTestSinglePk.assertEquals((long)l, (long)l2);
    }

    /*
     * Enabled force condition propagation
     */
    public void testInsertTwice() {
        T t = this.createEntity(this.nextPk());
        this.dao.insert(t);
        try {
            this.dao.insert(t);
            AbstractDaoTestSinglePk.fail((String)"Inserting twice should not work");
            return;
        }
        catch (SQLException sQLException) {
            return;
        }
    }

    public void testLoadAll() {
        this.dao.deleteAll();
        ArrayList<T> arrayList = new ArrayList<T>();
        int n = 0;
        while (true) {
            if (n >= 15) {
                this.dao.insertInTx(arrayList);
                List list = this.dao.loadAll();
                AbstractDaoTestSinglePk.assertEquals((int)arrayList.size(), (int)list.size());
                return;
            }
            arrayList.add(this.createEntity(this.nextPk()));
            ++n;
        }
    }

    public void testLoadPk() {
        this.runLoadPkTest(0);
    }

    public void testLoadPkWithOffset() {
        this.runLoadPkTest(10);
    }

    public void testQuery() {
        this.dao.insert(this.createEntityWithRandomPk());
        K k = this.nextPk();
        this.dao.insert(this.createEntity(k));
        this.dao.insert(this.createEntityWithRandomPk());
        Object object = new StringBuilder();
        ((StringBuilder)object).append("WHERE ");
        ((StringBuilder)object).append(this.dao.getPkColumns()[0]);
        ((StringBuilder)object).append("=?");
        object = ((StringBuilder)object).toString();
        object = this.dao.queryRaw((String)object, new String[]{k.toString()});
        AbstractDaoTestSinglePk.assertEquals((int)1, (int)object.size());
        AbstractDaoTestSinglePk.assertEquals(k, (Object)this.daoAccess.getKey(object.get(0)));
    }

    public void testReadWithOffset() {
        K k = this.nextPk();
        Object object = this.createEntity(k);
        this.dao.insert(object);
        object = this.queryWithDummyColumnsInFront(5, "42", k);
        try {
            Object object2 = this.daoAccess.readEntity(object, 5);
            AbstractDaoTestSinglePk.assertEquals(k, (Object)this.daoAccess.getKey(object2));
            return;
        }
        finally {
            object.close();
        }
    }

    public void testRowId() {
        T t = this.createEntityWithRandomPk();
        T t2 = this.createEntityWithRandomPk();
        boolean bl = this.dao.insert(t) != this.dao.insert(t2);
        AbstractDaoTestSinglePk.assertTrue((boolean)bl);
    }

    public void testSave() {
        if (!this.checkKeyIsNullable()) {
            return;
        }
        this.dao.deleteAll();
        T t = this.createEntity(null);
        if (t == null) return;
        this.dao.save(t);
        this.dao.save(t);
        AbstractDaoTestSinglePk.assertEquals((long)1L, (long)this.dao.count());
    }

    public void testSaveInTx() {
        if (!this.checkKeyIsNullable()) {
            return;
        }
        this.dao.deleteAll();
        ArrayList<T> arrayList = new ArrayList<T>();
        ArrayList<T> arrayList2 = new ArrayList<T>();
        int n = 0;
        while (true) {
            if (n >= 20) {
                this.dao.saveInTx(arrayList);
                this.dao.saveInTx(arrayList2);
                AbstractDaoTestSinglePk.assertEquals((long)arrayList2.size(), (long)this.dao.count());
                return;
            }
            T t = this.createEntity(null);
            if (n % 2 == 0) {
                arrayList.add(t);
            }
            arrayList2.add(t);
            ++n;
        }
    }

    public void testUpdate() {
        this.dao.deleteAll();
        T t = this.createEntityWithRandomPk();
        this.dao.insert(t);
        this.dao.update(t);
        AbstractDaoTestSinglePk.assertEquals((long)1L, (long)this.dao.count());
    }
}
