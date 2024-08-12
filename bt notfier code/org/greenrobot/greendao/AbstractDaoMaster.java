/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.AbstractDaoSession
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.identityscope.IdentityScopeType
 *  org.greenrobot.greendao.internal.DaoConfig
 */
package org.greenrobot.greendao;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public abstract class AbstractDaoMaster {
    protected final Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap;
    protected final Database db;
    protected final int schemaVersion;

    public AbstractDaoMaster(Database database, int n) {
        this.db = database;
        this.schemaVersion = n;
        this.daoConfigMap = new HashMap();
    }

    public Database getDatabase() {
        return this.db;
    }

    public int getSchemaVersion() {
        return this.schemaVersion;
    }

    public abstract AbstractDaoSession newSession();

    public abstract AbstractDaoSession newSession(IdentityScopeType var1);

    protected void registerDaoClass(Class<? extends AbstractDao<?, ?>> clazz) {
        DaoConfig daoConfig = new DaoConfig(this.db, clazz);
        this.daoConfigMap.put(clazz, daoConfig);
    }
}
