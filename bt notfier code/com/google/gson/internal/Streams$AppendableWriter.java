/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;

private static final class Streams.AppendableWriter
extends Writer {
    private final Appendable appendable;
    private final CurrentWrite currentWrite = new CurrentWrite();

    Streams.AppendableWriter(Appendable appendable) {
        this.appendable = appendable;
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }

    @Override
    public void write(int n) throws IOException {
        this.appendable.append((char)n);
    }

    @Override
    public void write(char[] cArray, int n, int n2) throws IOException {
        this.currentWrite.chars = cArray;
        this.appendable.append(this.currentWrite, n, n2 + n);
    }

    private static class CurrentWrite
    implements CharSequence {
        private char[] chars;
        private String cachedString;

        private CurrentWrite() {
        }

        void setChars(char[] chars) {
            this.chars = chars;
            this.cachedString = null;
        }

        @Override
        public int length() {
            return this.chars.length;
        }

        @Override
        public char charAt(int i) {
            return this.chars[i];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new String(this.chars, start, end - start);
        }

        @Override
        public String toString() {
            if (this.cachedString != null) return this.cachedString;
            this.cachedString = new String(this.chars);
            return this.cachedString;
        }
    }
}
