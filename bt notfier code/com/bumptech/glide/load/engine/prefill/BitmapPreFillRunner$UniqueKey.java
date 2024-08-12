/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 */
package com.bumptech.glide.load.engine.prefill;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

private static final class BitmapPreFillRunner.UniqueKey
implements Key {
    BitmapPreFillRunner.UniqueKey() {
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
