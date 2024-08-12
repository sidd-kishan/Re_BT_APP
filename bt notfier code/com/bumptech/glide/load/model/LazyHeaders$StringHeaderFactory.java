/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.LazyHeaderFactory
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaderFactory;

static final class LazyHeaders.StringHeaderFactory
implements LazyHeaderFactory {
    private final String value;

    LazyHeaders.StringHeaderFactory(String string) {
        this.value = string;
    }

    public String buildHeader() {
        return this.value;
    }

    public boolean equals(Object object) {
        if (!(object instanceof LazyHeaders.StringHeaderFactory)) return false;
        object = (LazyHeaders.StringHeaderFactory)object;
        return this.value.equals(((LazyHeaders.StringHeaderFactory)object).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StringHeaderFactory{value='");
        stringBuilder.append(this.value);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
