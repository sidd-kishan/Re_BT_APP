/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.util.Date;

class DefaultDateTypeAdapter.DateType.1
extends DefaultDateTypeAdapter.DateType<Date> {
    DefaultDateTypeAdapter.DateType.1(Class clazz) {
        super(clazz);
    }

    @Override
    protected Date deserialize(Date date) {
        return date;
    }
}
