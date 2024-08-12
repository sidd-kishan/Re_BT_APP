/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.greendao.converter;

public interface PropertyConverter<P, D> {
    public D convertToDatabaseValue(P var1);

    public P convertToEntityProperty(D var1);
}
