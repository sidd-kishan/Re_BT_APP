/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.query.AbstractQuery
 */
package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

abstract class AbstractQueryWithLimit<T>
extends AbstractQuery<T> {
    protected final int limitPosition;
    protected final int offsetPosition;

    protected AbstractQueryWithLimit(AbstractDao<T, ?> abstractDao, String string, String[] stringArray, int n, int n2) {
        super(abstractDao, string, stringArray);
        this.limitPosition = n;
        this.offsetPosition = n2;
    }

    public void setLimit(int n) {
        this.checkThread();
        if (this.limitPosition == -1) throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
        this.parameters[this.limitPosition] = Integer.toString(n);
    }

    public void setOffset(int n) {
        this.checkThread();
        if (this.offsetPosition == -1) throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
        this.parameters[this.offsetPosition] = Integer.toString(n);
    }

    public AbstractQueryWithLimit<T> setParameter(int n, Object object) {
        if (n < 0) return (AbstractQueryWithLimit)super.setParameter(n, object);
        if (n != this.limitPosition && n != this.offsetPosition) {
            return (AbstractQueryWithLimit)super.setParameter(n, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Illegal parameter index: ");
        ((StringBuilder)object).append(n);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }
}
