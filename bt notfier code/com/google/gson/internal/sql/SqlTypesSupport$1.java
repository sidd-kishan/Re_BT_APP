/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.util.Date;

class SqlTypesSupport.1
extends DefaultDateTypeAdapter.DateType<java.sql.Date> {
    SqlTypesSupport.1(Class clazz) {
        super(clazz);
    }

    @Override
    protected java.sql.Date deserialize(Date date) {
        return new java.sql.Date(date.getTime());
    }
}
