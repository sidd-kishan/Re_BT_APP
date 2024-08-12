/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.query.WhereCondition
 */
package org.greenrobot.greendao.query;

import java.util.List;
import org.greenrobot.greendao.query.WhereCondition;

public static abstract class WhereCondition.AbstractCondition
implements WhereCondition {
    protected final boolean hasSingleValue;
    protected final Object value;
    protected final Object[] values;

    public WhereCondition.AbstractCondition() {
        this.hasSingleValue = false;
        this.value = null;
        this.values = null;
    }

    public WhereCondition.AbstractCondition(Object object) {
        this.value = object;
        this.hasSingleValue = true;
        this.values = null;
    }

    public WhereCondition.AbstractCondition(Object[] objectArray) {
        this.value = null;
        this.hasSingleValue = false;
        this.values = objectArray;
    }

    public void appendValuesTo(List<Object> list) {
        if (this.hasSingleValue) {
            list.add(this.value);
            return;
        }
        Object[] objectArray = this.values;
        if (objectArray == null) return;
        int n = objectArray.length;
        int n2 = 0;
        while (n2 < n) {
            list.add(objectArray[n2]);
            ++n2;
        }
    }
}
