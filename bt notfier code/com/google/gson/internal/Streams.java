/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static JsonElement parse(JsonReader object) throws JsonParseException {
        boolean bl;
        try {
            try {
                ((JsonReader)object).peek();
                bl = false;
            }
            catch (EOFException eOFException) {
                bl = true;
            }
            try {
                return TypeAdapters.JSON_ELEMENT.read((JsonReader)object);
            }
            catch (EOFException eOFException) {
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new JsonSyntaxException(numberFormatException);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        catch (MalformedJsonException malformedJsonException) {
            throw new JsonSyntaxException(malformedJsonException);
        }
        if (!bl) void var0_6;
        throw new JsonSyntaxException((Throwable)var0_6);
        return JsonNull.INSTANCE;
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        appendable = appendable instanceof Writer ? (Writer)appendable : new AppendableWriter(appendable);
        return appendable;
    }

    private static final class AppendableWriter
    extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        AppendableWriter(Appendable appendable) {
            this.appendable = appendable;
        }

        @Override
        public void write(char[] chars, int offset, int length) throws IOException {
            this.currentWrite.setChars(chars);
            this.appendable.append(this.currentWrite, offset, offset + length);
        }

        @Override
        public void flush() {
        }

        @Override
        public void close() {
        }

        @Override
        public void write(int i) throws IOException {
            this.appendable.append((char)i);
        }

        @Override
        public void write(String str, int off, int len) throws IOException {
            Objects.requireNonNull(str);
            this.appendable.append(str, off, off + len);
        }

        @Override
        public Writer append(CharSequence csq) throws IOException {
            this.appendable.append(csq);
            return this;
        }

        @Override
        public Writer append(CharSequence csq, int start, int end) throws IOException {
            this.appendable.append(csq, start, end);
            return this;
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
}
