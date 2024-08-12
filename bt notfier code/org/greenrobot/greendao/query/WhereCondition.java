/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.greendao.query;

import java.util.List;

public interface WhereCondition {
    public void appendTo(StringBuilder var1, String var2);

    public void appendValuesTo(List<Object> var1);
}
