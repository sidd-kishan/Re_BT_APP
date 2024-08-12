/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.widget.longimage.DecoderFactory
 */
package com.luck.picture.lib.widget.longimage;

import com.luck.picture.lib.widget.longimage.DecoderFactory;

public class CompatDecoderFactory<T>
implements DecoderFactory<T> {
    private Class<? extends T> clazz;

    public CompatDecoderFactory(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    public T make() throws IllegalAccessException, InstantiationException {
        return this.clazz.newInstance();
    }
}
