/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.util;

static final class ByteBufferUtil.SafeArray {
    final byte[] data;
    final int limit;
    final int offset;

    ByteBufferUtil.SafeArray(byte[] byArray, int n, int n2) {
        this.data = byArray;
        this.offset = n;
        this.limit = n2;
    }
}
