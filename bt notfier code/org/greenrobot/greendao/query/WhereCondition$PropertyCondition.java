/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.Property
 *  org.greenrobot.greendao.internal.SqlUtils
 *  org.greenrobot.greendao.query.WhereCondition$AbstractCondition
 */
package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.query.WhereCondition;

public static class WhereCondition.PropertyCondition
extends WhereCondition.AbstractCondition {
    public final String op;
    public final Property property;

    public WhereCondition.PropertyCondition(Property property, String string) {
        this.property = property;
        this.op = string;
    }

    public WhereCondition.PropertyCondition(Property property, String string, Object object) {
        super(WhereCondition.PropertyCondition.checkValueForType(property, object));
        this.property = property;
        this.op = string;
    }

    public WhereCondition.PropertyCondition(Property property, String string, Object[] objectArray) {
        super(WhereCondition.PropertyCondition.checkValuesForType(property, objectArray));
        this.property = property;
        this.op = string;
    }

    private static Object checkValueForType(Property object, Object object2) {
        if (object2 != null) {
            if (object2.getClass().isArray()) throw new DaoException("Illegal value: found array, but simple object required");
        }
        if (((Property)object).type == Date.class) {
            if (object2 instanceof Date) {
                return ((Date)object2).getTime();
            }
            if (object2 instanceof Long) {
                return object2;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Illegal date value: expected java.util.Date or Long for value ");
            ((StringBuilder)object).append(object2);
            throw new DaoException(((StringBuilder)object).toString());
        }
        if (((Property)object).type != Boolean.TYPE) {
            if (((Property)object).type != Boolean.class) return object2;
        }
        if (object2 instanceof Boolean) {
            return ((Boolean)object2).booleanValue() ? 1 : 0;
        }
        if (object2 instanceof Number) {
            int n = ((Number)object2).intValue();
            if (n == 0) return object2;
            if (n == 1) {
                return object2;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Illegal boolean value: numbers must be 0 or 1, but was ");
            ((StringBuilder)object).append(object2);
            throw new DaoException(((StringBuilder)object).toString());
        }
        if (!(object2 instanceof String)) return object2;
        object = (String)object2;
        if ("TRUE".equalsIgnoreCase((String)object)) {
            return 1;
        }
        if ("FALSE".equalsIgnoreCase((String)object)) {
            return 0;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was ");
        ((StringBuilder)object).append(object2);
        throw new DaoException(((StringBuilder)object).toString());
    }

    private static Object[] checkValuesForType(Property property, Object[] objectArray) {
        int n = 0;
        while (n < objectArray.length) {
            objectArray[n] = WhereCondition.PropertyCondition.checkValueForType(property, objectArray[n]);
            ++n;
        }
        return objectArray;
    }

    public void appendTo(StringBuilder stringBuilder, String string) {
        SqlUtils.appendProperty((StringBuilder)stringBuilder, (String)string, (Property)this.property).append(this.op);
    }
}
