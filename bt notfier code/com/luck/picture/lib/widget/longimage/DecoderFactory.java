/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.widget.longimage;

public interface DecoderFactory<T> {
    public T make() throws IllegalAccessException, InstantiationException;
}
