/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.test.AbstractDaoTestSinglePk
 */
package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.test.AbstractDaoTestSinglePk;

public abstract class AbstractDaoTestLongPk<D extends AbstractDao<T, Long>, T>
extends AbstractDaoTestSinglePk<D, T, Long> {
    public AbstractDaoTestLongPk(Class<D> clazz) {
        super(clazz);
    }

    protected Long createRandomPk() {
        return this.random.nextLong();
    }

    public void testAssignPk() {
        if (this.daoAccess.isEntityUpdateable()) {
            Object object = this.createEntity(null);
            if (object != null) {
                Object object2 = this.createEntity(null);
                this.dao.insert(object);
                this.dao.insert(object2);
                object = (Long)this.daoAccess.getKey(object);
                AbstractDaoTestLongPk.assertNotNull((Object)object);
                object2 = (Long)this.daoAccess.getKey(object2);
                AbstractDaoTestLongPk.assertNotNull((Object)object2);
                AbstractDaoTestLongPk.assertFalse((boolean)((Long)object).equals(object2));
                AbstractDaoTestLongPk.assertNotNull((Object)this.dao.load(object));
                AbstractDaoTestLongPk.assertNotNull((Object)this.dao.load(object2));
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Skipping testAssignPk for ");
                stringBuilder.append(this.daoClass);
                stringBuilder.append(" (createEntity returned null for null key)");
                DaoLog.d((String)stringBuilder.toString());
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Skipping testAssignPk for not updateable ");
            stringBuilder.append(this.daoClass);
            DaoLog.d((String)stringBuilder.toString());
        }
    }
}
