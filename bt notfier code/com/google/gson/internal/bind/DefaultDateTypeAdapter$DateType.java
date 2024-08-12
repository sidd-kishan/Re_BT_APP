/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.util.Date;

public static abstract class DefaultDateTypeAdapter.DateType<T extends Date> {
    public static final DefaultDateTypeAdapter.DateType<Date> DATE = new DefaultDateTypeAdapter.DateType<Date>(Date.class){

        @Override
        protected Date deserialize(Date date) {
            return date;
        }
    };
    private final Class<T> dateClass;

    protected DefaultDateTypeAdapter.DateType(Class<T> clazz) {
        this.dateClass = clazz;
    }

    private final TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
        return TypeAdapters.newFactory(this.dateClass, defaultDateTypeAdapter);
    }

    public final TypeAdapterFactory createAdapterFactory(int n) {
        return this.createFactory(new DefaultDateTypeAdapter(this, n, null));
    }

    public final TypeAdapterFactory createAdapterFactory(int n, int n2) {
        return this.createFactory(new DefaultDateTypeAdapter(this, n, n2, null));
    }

    public final TypeAdapterFactory createAdapterFactory(String string) {
        return this.createFactory(new DefaultDateTypeAdapter(this, string, null));
    }

    public final TypeAdapterFactory createDefaultsAdapterFactory() {
        return this.createFactory(new DefaultDateTypeAdapter(this, 2, 2, null));
    }

    protected abstract T deserialize(Date var1);
}
