/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.query.WhereCondition$AbstractCondition
 */
package org.greenrobot.greendao.query;

import org.greenrobot.greendao.query.WhereCondition;

public static class WhereCondition.StringCondition
extends WhereCondition.AbstractCondition {
    protected final String string;

    public WhereCondition.StringCondition(String string) {
        this.string = string;
    }

    public WhereCondition.StringCondition(String string, Object object) {
        super(object);
        this.string = string;
    }

    public WhereCondition.StringCondition(String string, Object ... objectArray) {
        super(objectArray);
        this.string = string;
    }

    public void appendTo(StringBuilder stringBuilder, String string) {
        stringBuilder.append(this.string);
    }
}
