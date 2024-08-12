/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.query.WhereCondition
 *  org.greenrobot.greendao.query.WhereCondition$PropertyCondition
 *  org.greenrobot.greendao.query.WhereCondition$StringCondition
 */
package org.greenrobot.greendao.query;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.WhereCondition;

class WhereCollector<T> {
    private final AbstractDao<T, ?> dao;
    private final String tablePrefix;
    private final List<WhereCondition> whereConditions;

    WhereCollector(AbstractDao<T, ?> abstractDao, String string) {
        this.dao = abstractDao;
        this.tablePrefix = string;
        this.whereConditions = new ArrayList<WhereCondition>();
    }

    void add(WhereCondition whereCondition, WhereCondition ... whereConditionArray) {
        this.checkCondition(whereCondition);
        this.whereConditions.add(whereCondition);
        int n = whereConditionArray.length;
        int n2 = 0;
        while (n2 < n) {
            whereCondition = whereConditionArray[n2];
            this.checkCondition(whereCondition);
            this.whereConditions.add(whereCondition);
            ++n2;
        }
    }

    void addCondition(StringBuilder stringBuilder, List<Object> list, WhereCondition whereCondition) {
        this.checkCondition(whereCondition);
        whereCondition.appendTo(stringBuilder, this.tablePrefix);
        whereCondition.appendValuesTo(list);
    }

    void appendWhereClause(StringBuilder stringBuilder, String string, List<Object> list) {
        ListIterator<WhereCondition> listIterator = this.whereConditions.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious()) {
                stringBuilder.append(" AND ");
            }
            WhereCondition whereCondition = listIterator.next();
            whereCondition.appendTo(stringBuilder, string);
            whereCondition.appendValuesTo(list);
        }
    }

    void checkCondition(WhereCondition whereCondition) {
        if (!(whereCondition instanceof WhereCondition.PropertyCondition)) return;
        this.checkProperty(((WhereCondition.PropertyCondition)whereCondition).property);
    }

    void checkProperty(Property property) {
        boolean bl;
        Object object = this.dao;
        if (object == null) return;
        object = object.getProperties();
        int n = ((Property[])object).length;
        boolean bl2 = false;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            if (property == object[n2]) {
                bl = true;
                break;
            }
            ++n2;
        }
        if (bl) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Property '");
        ((StringBuilder)object).append(property.name);
        ((StringBuilder)object).append("' is not part of ");
        ((StringBuilder)object).append(this.dao);
        throw new DaoException(((StringBuilder)object).toString());
    }

    WhereCondition combineWhereConditions(String string, WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition ... whereConditionArray) {
        StringBuilder stringBuilder = new StringBuilder("(");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        this.addCondition(stringBuilder, arrayList, whereCondition);
        stringBuilder.append(string);
        this.addCondition(stringBuilder, arrayList, whereCondition2);
        int n = whereConditionArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                stringBuilder.append(')');
                return new WhereCondition.StringCondition(stringBuilder.toString(), arrayList.toArray());
            }
            whereCondition = whereConditionArray[n2];
            stringBuilder.append(string);
            this.addCondition(stringBuilder, arrayList, whereCondition);
            ++n2;
        }
    }

    boolean isEmpty() {
        return this.whereConditions.isEmpty();
    }
}
