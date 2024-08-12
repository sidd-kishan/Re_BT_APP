/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.internal.SqlUtils
 *  org.greenrobot.greendao.query.WhereCondition
 *  org.greenrobot.greendao.query.WhereCondition$PropertyCondition
 */
package org.greenrobot.greendao;

import java.util.Collection;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.query.WhereCondition;

public class Property {
    public final String columnName;
    public final String name;
    public final int ordinal;
    public final boolean primaryKey;
    public final Class<?> type;

    public Property(int n, Class<?> clazz, String string, boolean bl, String string2) {
        this.ordinal = n;
        this.type = clazz;
        this.name = string;
        this.primaryKey = bl;
        this.columnName = string2;
    }

    public WhereCondition between(Object object, Object object2) {
        return new WhereCondition.PropertyCondition(this, " BETWEEN ? AND ?", new Object[]{object, object2});
    }

    public WhereCondition eq(Object object) {
        return new WhereCondition.PropertyCondition(this, "=?", object);
    }

    public WhereCondition ge(Object object) {
        return new WhereCondition.PropertyCondition(this, ">=?", object);
    }

    public WhereCondition gt(Object object) {
        return new WhereCondition.PropertyCondition(this, ">?", object);
    }

    public WhereCondition in(Collection<?> collection) {
        return this.in(collection.toArray());
    }

    public WhereCondition in(Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder(" IN (");
        SqlUtils.appendPlaceholders((StringBuilder)stringBuilder, (int)objectArray.length).append(')');
        return new WhereCondition.PropertyCondition(this, stringBuilder.toString(), objectArray);
    }

    public WhereCondition isNotNull() {
        return new WhereCondition.PropertyCondition(this, " IS NOT NULL");
    }

    public WhereCondition isNull() {
        return new WhereCondition.PropertyCondition(this, " IS NULL");
    }

    public WhereCondition le(Object object) {
        return new WhereCondition.PropertyCondition(this, "<=?", object);
    }

    public WhereCondition like(String string) {
        return new WhereCondition.PropertyCondition(this, " LIKE ?", (Object)string);
    }

    public WhereCondition lt(Object object) {
        return new WhereCondition.PropertyCondition(this, "<?", object);
    }

    public WhereCondition notEq(Object object) {
        return new WhereCondition.PropertyCondition(this, "<>?", object);
    }

    public WhereCondition notIn(Collection<?> collection) {
        return this.notIn(collection.toArray());
    }

    public WhereCondition notIn(Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder(" NOT IN (");
        SqlUtils.appendPlaceholders((StringBuilder)stringBuilder, (int)objectArray.length).append(')');
        return new WhereCondition.PropertyCondition(this, stringBuilder.toString(), objectArray);
    }
}
