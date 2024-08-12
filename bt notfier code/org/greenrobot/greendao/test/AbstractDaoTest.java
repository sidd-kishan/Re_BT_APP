/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.InternalUnitTestDaoAccess
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.identityscope.IdentityScope
 *  org.greenrobot.greendao.test.DbTest
 */
package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.InternalUnitTestDaoAccess;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.test.DbTest;

public abstract class AbstractDaoTest<D extends AbstractDao<T, K>, T, K>
extends DbTest {
    protected D dao;
    protected InternalUnitTestDaoAccess<T, K> daoAccess;
    protected final Class<D> daoClass;
    protected IdentityScope<K, T> identityScopeForDao;
    protected Property pkColumn;

    public AbstractDaoTest(Class<D> clazz) {
        this(clazz, true);
    }

    public AbstractDaoTest(Class<D> clazz, boolean bl) {
        super(bl);
        this.daoClass = clazz;
    }

    protected void clearIdentityScopeIfAny() {
        IdentityScope<K, T> identityScope = this.identityScopeForDao;
        if (identityScope != null) {
            identityScope.clear();
            DaoLog.d((String)"Identity scope cleared");
        } else {
            DaoLog.d((String)"No identity scope to clear");
        }
    }

    protected void logTableDump() {
        this.logTableDump(this.dao.getTablename());
    }

    public void setIdentityScopeBeforeSetUp(IdentityScope<K, T> identityScope) {
        this.identityScopeForDao = identityScope;
    }

    protected void setUp() throws Exception {
        super.setUp();
        try {
            InternalUnitTestDaoAccess internalUnitTestDaoAccess;
            this.setUpTableForDao();
            this.daoAccess = internalUnitTestDaoAccess = new InternalUnitTestDaoAccess(this.db, this.daoClass, this.identityScopeForDao);
            this.dao = internalUnitTestDaoAccess.getDao();
            return;
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not prepare DAO Test", exception);
        }
    }

    protected void setUpTableForDao() throws Exception {
        try {
            this.daoClass.getMethod("createTable", Database.class, Boolean.TYPE).invoke(null, this.db, false);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            DaoLog.i((String)"No createTable method");
        }
    }
}
