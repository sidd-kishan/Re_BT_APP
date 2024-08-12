/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.internal.TableStatements
 */
package org.greenrobot.greendao;

import android.database.Cursor;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.internal.TableStatements;

public final class InternalQueryDaoAccess<T> {
    private final AbstractDao<T, ?> dao;

    public InternalQueryDaoAccess(AbstractDao<T, ?> abstractDao) {
        this.dao = abstractDao;
    }

    public static <T2> TableStatements getStatements(AbstractDao<T2, ?> abstractDao) {
        return abstractDao.getStatements();
    }

    public TableStatements getStatements() {
        return this.dao.getStatements();
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        return this.dao.loadAllAndCloseCursor(cursor);
    }

    public T loadCurrent(Cursor cursor, int n, boolean bl) {
        return (T)this.dao.loadCurrent(cursor, n, bl);
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        return (T)this.dao.loadUniqueAndCloseCursor(cursor);
    }
}
