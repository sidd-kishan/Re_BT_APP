/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.query.AbstractQueryData
 *  org.greenrobot.greendao.query.Query
 */
package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQueryData;
import org.greenrobot.greendao.query.Query;

private static final class Query.QueryData<T2>
extends AbstractQueryData<T2, Query<T2>> {
    private final int limitPosition;
    private final int offsetPosition;

    Query.QueryData(AbstractDao<T2, ?> abstractDao, String string, String[] stringArray, int n, int n2) {
        super(abstractDao, string, stringArray);
        this.limitPosition = n;
        this.offsetPosition = n2;
    }

    protected Query<T2> createQuery() {
        return new Query(this, this.dao, this.sql, (String[])this.initialValues.clone(), this.limitPosition, this.offsetPosition, null);
    }
}
