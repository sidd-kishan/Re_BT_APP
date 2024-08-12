/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Date;

class SqlTypesSupport.2
extends DefaultDateTypeAdapter.DateType<Timestamp> {
    SqlTypesSupport.2(Class clazz) {
        super(clazz);
    }

    @Override
    protected Timestamp deserialize(Date date) {
        return new Timestamp(date.getTime());
    }
}
