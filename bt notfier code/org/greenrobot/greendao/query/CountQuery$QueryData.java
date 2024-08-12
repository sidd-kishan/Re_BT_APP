/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.query.AbstractQueryData
 *  org.greenrobot.greendao.query.CountQuery
 */
package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQueryData;
import org.greenrobot.greendao.query.CountQuery;

private static final class CountQuery.QueryData<T2>
extends AbstractQueryData<T2, CountQuery<T2>> {
    private CountQuery.QueryData(AbstractDao<T2, ?> abstractDao, String string, String[] stringArray) {
        super(abstractDao, string, stringArray);
    }

    protected CountQuery<T2> createQuery() {
        return new CountQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), null);
    }
}
