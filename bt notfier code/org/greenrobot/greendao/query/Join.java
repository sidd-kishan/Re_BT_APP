/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.query.WhereCollector
 *  org.greenrobot.greendao.query.WhereCondition
 */
package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.WhereCollector;
import org.greenrobot.greendao.query.WhereCondition;

public class Join<SRC, DST> {
    final AbstractDao<DST, ?> daoDestination;
    final Property joinPropertyDestination;
    final Property joinPropertySource;
    final String sourceTablePrefix;
    final String tablePrefix;
    final WhereCollector<DST> whereCollector;

    public Join(String string, Property property, AbstractDao<DST, ?> abstractDao, Property property2, String string2) {
        this.sourceTablePrefix = string;
        this.joinPropertySource = property;
        this.daoDestination = abstractDao;
        this.joinPropertyDestination = property2;
        this.tablePrefix = string2;
        this.whereCollector = new WhereCollector(abstractDao, string2);
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition ... whereConditionArray) {
        return this.whereCollector.combineWhereConditions(" AND ", whereCondition, whereCondition2, whereConditionArray);
    }

    public String getTablePrefix() {
        return this.tablePrefix;
    }

    public WhereCondition or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition ... whereConditionArray) {
        return this.whereCollector.combineWhereConditions(" OR ", whereCondition, whereCondition2, whereConditionArray);
    }

    public Join<SRC, DST> where(WhereCondition whereCondition, WhereCondition ... whereConditionArray) {
        this.whereCollector.add(whereCondition, whereConditionArray);
        return this;
    }

    public Join<SRC, DST> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition ... whereConditionArray) {
        this.whereCollector.add(this.or(whereCondition, whereCondition2, whereConditionArray), new WhereCondition[0]);
        return this;
    }
}
