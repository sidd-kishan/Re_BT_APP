/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.query.AbstractQueryData
 *  org.greenrobot.greendao.query.DeleteQuery
 */
package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQueryData;
import org.greenrobot.greendao.query.DeleteQuery;

private static final class DeleteQuery.QueryData<T2>
extends AbstractQueryData<T2, DeleteQuery<T2>> {
    private DeleteQuery.QueryData(AbstractDao<T2, ?> abstractDao, String string, String[] stringArray) {
        super(abstractDao, string, stringArray);
    }

    protected DeleteQuery<T2> createQuery() {
        return new DeleteQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), null);
    }
}
