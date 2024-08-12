/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDaoMaster
 *  org.greenrobot.greendao.AbstractDaoSession
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.test.DbTest
 */
package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.test.DbTest;

public abstract class AbstractDaoSessionTest<T extends AbstractDaoMaster, S extends AbstractDaoSession>
extends DbTest {
    protected T daoMaster;
    private final Class<T> daoMasterClass;
    protected S daoSession;

    public AbstractDaoSessionTest(Class<T> clazz) {
        this(clazz, true);
    }

    public AbstractDaoSessionTest(Class<T> clazz, boolean bl) {
        super(bl);
        this.daoMasterClass = clazz;
    }

    protected void setUp() throws Exception {
        super.setUp();
        try {
            this.daoMaster = (AbstractDaoMaster)this.daoMasterClass.getConstructor(Database.class).newInstance(this.db);
            this.daoMasterClass.getMethod("createAllTables", Database.class, Boolean.TYPE).invoke(null, this.db, false);
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not prepare DAO session test", exception);
        }
        this.daoSession = this.daoMaster.newSession();
    }
}
