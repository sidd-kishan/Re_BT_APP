/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load;

import java.security.MessageDigest;

public static interface Option.CacheKeyUpdater<T> {
    public void update(byte[] var1, T var2, MessageDigest var3);
}
