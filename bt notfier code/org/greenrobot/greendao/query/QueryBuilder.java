/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  org.greenrobot.greendao.AbstractDao
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.internal.SqlUtils
 *  org.greenrobot.greendao.query.CloseableListIterator
 *  org.greenrobot.greendao.query.CountQuery
 *  org.greenrobot.greendao.query.CursorQuery
 *  org.greenrobot.greendao.query.DeleteQuery
 *  org.greenrobot.greendao.query.Join
 *  org.greenrobot.greendao.query.LazyList
 *  org.greenrobot.greendao.query.Query
 *  org.greenrobot.greendao.query.WhereCollector
 *  org.greenrobot.greendao.query.WhereCondition
 *  org.greenrobot.greendao.rx.RxQuery
 */
package org.greenrobot.greendao.query;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.query.CloseableListIterator;
import org.greenrobot.greendao.query.CountQuery;
import org.greenrobot.greendao.query.CursorQuery;
import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.WhereCollector;
import org.greenrobot.greendao.query.WhereCondition;
import org.greenrobot.greendao.rx.RxQuery;

public class QueryBuilder<T> {
    public static boolean LOG_SQL;
    public static boolean LOG_VALUES;
    private final AbstractDao<T, ?> dao;
    private boolean distinct;
    private final List<Join<T, ?>> joins;
    private Integer limit;
    private Integer offset;
    private StringBuilder orderBuilder;
    private String stringOrderCollation;
    private final String tablePrefix;
    private final List<Object> values;
    private final WhereCollector<T> whereCollector;

    protected QueryBuilder(AbstractDao<T, ?> abstractDao) {
        this(abstractDao, "T");
    }

    protected QueryBuilder(AbstractDao<T, ?> abstractDao, String string) {
        this.dao = abstractDao;
        this.tablePrefix = string;
        this.values = new ArrayList<Object>();
        this.joins = new ArrayList();
        this.whereCollector = new WhereCollector(abstractDao, string);
        this.stringOrderCollation = " COLLATE NOCASE";
    }

    private <J> Join<T, J> addJoin(String string, Property property, AbstractDao<J, ?> abstractDao, Property property2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("J");
        stringBuilder.append(this.joins.size() + 1);
        string = new Join(string, property, abstractDao, property2, stringBuilder.toString());
        this.joins.add((Join<T, ?>)string);
        return string;
    }

    private void appendJoinsAndWheres(StringBuilder stringBuilder, String string) {
        this.values.clear();
        for (Join<T, ?> object2 : this.joins) {
            stringBuilder.append(" JOIN ");
            stringBuilder.append(object2.daoDestination.getTablename());
            stringBuilder.append(' ');
            stringBuilder.append(object2.tablePrefix);
            stringBuilder.append(" ON ");
            SqlUtils.appendProperty((StringBuilder)stringBuilder, (String)object2.sourceTablePrefix, (Property)object2.joinPropertySource).append('=');
            SqlUtils.appendProperty((StringBuilder)stringBuilder, (String)object2.tablePrefix, (Property)object2.joinPropertyDestination);
        }
        boolean bl = this.whereCollector.isEmpty() ^ true;
        if (bl) {
            stringBuilder.append(" WHERE ");
            this.whereCollector.appendWhereClause(stringBuilder, (String)string, this.values);
        }
        Iterator<Join<T, ?>> iterator = this.joins.iterator();
        while (iterator.hasNext()) {
            string = iterator.next();
            if (string.whereCollector.isEmpty()) continue;
            if (!bl) {
                stringBuilder.append(" WHERE ");
                bl = true;
            } else {
                stringBuilder.append(" AND ");
            }
            string.whereCollector.appendWhereClause(stringBuilder, string.tablePrefix, this.values);
        }
    }

    private int checkAddLimit(StringBuilder stringBuilder) {
        int n;
        if (this.limit != null) {
            stringBuilder.append(" LIMIT ?");
            this.values.add(this.limit);
            n = this.values.size() - 1;
        } else {
            n = -1;
        }
        return n;
    }

    private int checkAddOffset(StringBuilder stringBuilder) {
        int n;
        if (this.offset != null) {
            if (this.limit == null) throw new IllegalStateException("Offset cannot be set without limit");
            stringBuilder.append(" OFFSET ?");
            this.values.add(this.offset);
            n = this.values.size() - 1;
        } else {
            n = -1;
        }
        return n;
    }

    private void checkLog(String charSequence) {
        if (LOG_SQL) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Built SQL for query: ");
            stringBuilder.append((String)charSequence);
            DaoLog.d((String)stringBuilder.toString());
        }
        if (!LOG_VALUES) return;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Values for query: ");
        ((StringBuilder)charSequence).append(this.values);
        DaoLog.d((String)((StringBuilder)charSequence).toString());
    }

    private void checkOrderBuilder() {
        StringBuilder stringBuilder = this.orderBuilder;
        if (stringBuilder == null) {
            this.orderBuilder = new StringBuilder();
        } else {
            if (stringBuilder.length() <= 0) return;
            this.orderBuilder.append(",");
        }
    }

    private StringBuilder createSelectBuilder() {
        StringBuilder stringBuilder = new StringBuilder(SqlUtils.createSqlSelect((String)this.dao.getTablename(), (String)this.tablePrefix, (String[])this.dao.getAllColumns(), (boolean)this.distinct));
        this.appendJoinsAndWheres(stringBuilder, this.tablePrefix);
        StringBuilder stringBuilder2 = this.orderBuilder;
        if (stringBuilder2 == null) return stringBuilder;
        if (stringBuilder2.length() <= 0) return stringBuilder;
        stringBuilder.append(" ORDER BY ");
        stringBuilder.append((CharSequence)this.orderBuilder);
        return stringBuilder;
    }

    public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> abstractDao) {
        return new QueryBuilder<T2>(abstractDao);
    }

    private void orderAscOrDesc(String string, Property ... propertyArray) {
        int n = propertyArray.length;
        int n2 = 0;
        while (n2 < n) {
            Object object = propertyArray[n2];
            this.checkOrderBuilder();
            this.append(this.orderBuilder, (Property)object);
            if (String.class.equals((Object)object.type) && (object = this.stringOrderCollation) != null) {
                this.orderBuilder.append((String)object);
            }
            this.orderBuilder.append(string);
            ++n2;
        }
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition ... whereConditionArray) {
        return this.whereCollector.combineWhereConditions(" AND ", whereCondition, whereCondition2, whereConditionArray);
    }

    protected StringBuilder append(StringBuilder stringBuilder, Property property) {
        this.whereCollector.checkProperty(property);
        stringBuilder.append(this.tablePrefix);
        stringBuilder.append('.');
        stringBuilder.append('\'');
        stringBuilder.append(property.columnName);
        stringBuilder.append('\'');
        return stringBuilder;
    }

    public Query<T> build() {
        CharSequence charSequence = this.createSelectBuilder();
        int n = this.checkAddLimit((StringBuilder)charSequence);
        int n2 = this.checkAddOffset((StringBuilder)charSequence);
        charSequence = charSequence.toString();
        this.checkLog((String)charSequence);
        return Query.create(this.dao, (String)charSequence, (Object[])this.values.toArray(), (int)n, (int)n2);
    }

    public CountQuery<T> buildCount() {
        CharSequence charSequence = new StringBuilder(SqlUtils.createSqlSelectCountStar((String)this.dao.getTablename(), (String)this.tablePrefix));
        this.appendJoinsAndWheres((StringBuilder)charSequence, this.tablePrefix);
        charSequence = charSequence.toString();
        this.checkLog((String)charSequence);
        return CountQuery.create(this.dao, (String)charSequence, (Object[])this.values.toArray());
    }

    public CursorQuery buildCursor() {
        CharSequence charSequence = this.createSelectBuilder();
        int n = this.checkAddLimit((StringBuilder)charSequence);
        int n2 = this.checkAddOffset((StringBuilder)charSequence);
        charSequence = charSequence.toString();
        this.checkLog((String)charSequence);
        return CursorQuery.create(this.dao, (String)charSequence, (Object[])this.values.toArray(), (int)n, (int)n2);
    }

    public DeleteQuery<T> buildDelete() {
        if (!this.joins.isEmpty()) throw new DaoException("JOINs are not supported for DELETE queries");
        String string = this.dao.getTablename();
        CharSequence charSequence = new StringBuilder(SqlUtils.createSqlDelete((String)string, null));
        this.appendJoinsAndWheres((StringBuilder)charSequence, this.tablePrefix);
        charSequence = ((StringBuilder)charSequence).toString();
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append(this.tablePrefix);
        charSequence2.append(".\"");
        charSequence2 = charSequence2.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\"');
        stringBuilder.append(string);
        stringBuilder.append("\".\"");
        string = ((String)charSequence).replace(charSequence2, stringBuilder.toString());
        this.checkLog(string);
        return DeleteQuery.create(this.dao, (String)string, (Object[])this.values.toArray());
    }

    public long count() {
        return this.buildCount().count();
    }

    public QueryBuilder<T> distinct() {
        this.distinct = true;
        return this;
    }

    public <J> Join<T, J> join(Class<J> clazz, Property property) {
        return this.join(this.dao.getPkProperty(), clazz, property);
    }

    public <J> Join<T, J> join(Property property, Class<J> abstractDao) {
        abstractDao = this.dao.getSession().getDao(abstractDao);
        Property property2 = abstractDao.getPkProperty();
        return this.addJoin(this.tablePrefix, property, abstractDao, property2);
    }

    public <J> Join<T, J> join(Property property, Class<J> abstractDao, Property property2) {
        abstractDao = this.dao.getSession().getDao(abstractDao);
        return this.addJoin(this.tablePrefix, property, abstractDao, property2);
    }

    public <J> Join<T, J> join(Join<?, T> join, Property property, Class<J> abstractDao, Property property2) {
        abstractDao = this.dao.getSession().getDao(abstractDao);
        return this.addJoin(join.tablePrefix, property, abstractDao, property2);
    }

    public QueryBuilder<T> limit(int n) {
        this.limit = n;
        return this;
    }

    public List<T> list() {
        return this.build().list();
    }

    public CloseableListIterator<T> listIterator() {
        return this.build().listIterator();
    }

    public LazyList<T> listLazy() {
        return this.build().listLazy();
    }

    public LazyList<T> listLazyUncached() {
        return this.build().listLazyUncached();
    }

    public QueryBuilder<T> offset(int n) {
        this.offset = n;
        return this;
    }

    public WhereCondition or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition ... whereConditionArray) {
        return this.whereCollector.combineWhereConditions(" OR ", whereCondition, whereCondition2, whereConditionArray);
    }

    public QueryBuilder<T> orderAsc(Property ... propertyArray) {
        this.orderAscOrDesc(" ASC", propertyArray);
        return this;
    }

    public QueryBuilder<T> orderCustom(Property property, String string) {
        this.checkOrderBuilder();
        this.append(this.orderBuilder, property).append(' ');
        this.orderBuilder.append(string);
        return this;
    }

    public QueryBuilder<T> orderDesc(Property ... propertyArray) {
        this.orderAscOrDesc(" DESC", propertyArray);
        return this;
    }

    public QueryBuilder<T> orderRaw(String string) {
        this.checkOrderBuilder();
        this.orderBuilder.append(string);
        return this;
    }

    public QueryBuilder<T> preferLocalizedStringOrder() {
        if (!(this.dao.getDatabase().getRawDatabase() instanceof SQLiteDatabase)) return this;
        this.stringOrderCollation = " COLLATE LOCALIZED";
        return this;
    }

    public RxQuery<T> rx() {
        return this.build().__InternalRx();
    }

    public RxQuery<T> rxPlain() {
        return this.build().__internalRxPlain();
    }

    public QueryBuilder<T> stringOrderCollation(String string) {
        if (!(this.dao.getDatabase().getRawDatabase() instanceof SQLiteDatabase)) return this;
        CharSequence charSequence = string;
        if (string != null) {
            if (string.startsWith(" ")) {
                charSequence = string;
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(" ");
                ((StringBuilder)charSequence).append(string);
                charSequence = ((StringBuilder)charSequence).toString();
            }
        }
        this.stringOrderCollation = charSequence;
        return this;
    }

    public T unique() {
        return (T)this.build().unique();
    }

    public T uniqueOrThrow() {
        return (T)this.build().uniqueOrThrow();
    }

    public QueryBuilder<T> where(WhereCondition whereCondition, WhereCondition ... whereConditionArray) {
        this.whereCollector.add(whereCondition, whereConditionArray);
        return this;
    }

    public QueryBuilder<T> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition ... whereConditionArray) {
        this.whereCollector.add(this.or(whereCondition, whereCondition2, whereConditionArray), new WhereCondition[0]);
        return this;
    }
}
