/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.identityscope.IdentityScope
 *  org.greenrobot.greendao.internal.DaoConfig
 */
package org.greenrobot.greendao;

import android.database.Cursor;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.internal.DaoConfig;

public class InternalUnitTestDaoAccess<T, K> {
    private final AbstractDao<T, K> dao;

    public InternalUnitTestDaoAccess(Database database, Class<AbstractDao<T, K>> clazz, IdentityScope<?, ?> identityScope) throws Exception {
        database = new DaoConfig(database, clazz);
        database.setIdentityScope(identityScope);
        this.dao = clazz.getConstructor(DaoConfig.class).newInstance(database);
    }

    public AbstractDao<T, K> getDao() {
        return this.dao;
    }

    public K getKey(T t) {
        return (K)this.dao.getKey(t);
    }

    public Property[] getProperties() {
        return this.dao.getProperties();
    }

    public boolean isEntityUpdateable() {
        return this.dao.isEntityUpdateable();
    }

    public T readEntity(Cursor cursor, int n) {
        return (T)this.dao.readEntity(cursor, n);
    }

    public K readKey(Cursor cursor, int n) {
        return (K)this.dao.readKey(cursor, n);
    }
}
