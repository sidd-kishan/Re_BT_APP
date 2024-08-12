/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

static class Streams.AppendableWriter.CurrentWrite
implements CharSequence {
    char[] chars;

    Streams.AppendableWriter.CurrentWrite() {
    }

    @Override
    public char charAt(int n) {
        return this.chars[n];
    }

    @Override
    public int length() {
        return this.chars.length;
    }

    @Override
    public CharSequence subSequence(int n, int n2) {
        return new String(this.chars, n, n2 - n);
    }
}
