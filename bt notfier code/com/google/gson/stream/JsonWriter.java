/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class JsonWriter
implements Closeable,
Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS;
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        REPLACEMENT_CHARS = new String[128];
        int n = 0;
        while (true) {
            if (n > 31) {
                String[] stringArray = REPLACEMENT_CHARS;
                stringArray[34] = "\\\"";
                stringArray[92] = "\\\\";
                stringArray[9] = "\\t";
                stringArray[8] = "\\b";
                stringArray[10] = "\\n";
                stringArray[13] = "\\r";
                stringArray[12] = "\\f";
                stringArray = (String[])stringArray.clone();
                HTML_SAFE_REPLACEMENT_CHARS = stringArray;
                stringArray[60] = "\\u003c";
                stringArray[62] = "\\u003e";
                stringArray[38] = "\\u0026";
                stringArray[61] = "\\u003d";
                stringArray[39] = "\\u0027";
                return;
            }
            JsonWriter.REPLACEMENT_CHARS[n] = String.format("\\u%04x", n);
            ++n;
        }
    }

    public JsonWriter(Writer writer) {
        this.push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) throw new NullPointerException("out == null");
        this.out = writer;
    }

    private void beforeName() throws IOException {
        int n = this.peek();
        if (n == 5) {
            this.out.write(44);
        } else if (n != 3) throw new IllegalStateException("Nesting problem.");
        this.newline();
        this.replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int n = this.peek();
        if (n != 1) {
            if (n != 2) {
                if (n != 4) {
                    if (n != 6) {
                        if (n != 7) throw new IllegalStateException("Nesting problem.");
                        if (!this.lenient) throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                    this.replaceTop(7);
                } else {
                    this.out.append(this.separator);
                    this.replaceTop(5);
                }
            } else {
                this.out.append(',');
                this.newline();
            }
        } else {
            this.replaceTop(2);
            this.newline();
        }
    }

    private JsonWriter close(int n, int n2, char c) throws IOException {
        int n3 = this.peek();
        if (n3 != n2) {
            if (n3 != n) throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Dangling name: ");
            stringBuilder.append(this.deferredName);
            throw new IllegalStateException(stringBuilder.toString());
        }
        --this.stackSize;
        if (n3 == n2) {
            this.newline();
        }
        this.out.write(c);
        return this;
    }

    private void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.out.write(10);
        int n = this.stackSize;
        int n2 = 1;
        while (n2 < n) {
            this.out.write(this.indent);
            ++n2;
        }
    }

    private JsonWriter open(int n, char c) throws IOException {
        this.beforeValue();
        this.push(n);
        this.out.write(c);
        return this;
    }

    private int peek() {
        int n = this.stackSize;
        if (n == 0) throw new IllegalStateException("JsonWriter is closed.");
        return this.stack[n - 1];
    }

    private void push(int n) {
        int n2 = this.stackSize;
        int[] nArray = this.stack;
        if (n2 == nArray.length) {
            this.stack = Arrays.copyOf(nArray, n2 * 2);
        }
        nArray = this.stack;
        n2 = this.stackSize;
        this.stackSize = n2 + 1;
        nArray[n2] = n;
    }

    private void replaceTop(int n) {
        this.stack[this.stackSize - 1] = n;
    }

    private void string(String string) throws IOException {
        String[] stringArray = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        this.out.write(34);
        int n = string.length();
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            int n3;
            block8: {
                String string2;
                block7: {
                    char c;
                    block9: {
                        block6: {
                            String string3;
                            c = string.charAt(i);
                            if (c >= '\u0080') break block6;
                            string2 = string3 = stringArray[c];
                            if (string3 != null) break block7;
                            n3 = n2;
                            break block8;
                        }
                        if (c != '\u2028') break block9;
                        string2 = "\\u2028";
                        break block7;
                    }
                    n3 = n2;
                    if (c != '\u2029') break block8;
                    string2 = "\\u2029";
                }
                if (n2 < i) {
                    this.out.write(string, n2, i - n2);
                }
                this.out.write(string2);
                n3 = i + 1;
            }
            n2 = n3;
        }
        if (n2 < n) {
            this.out.write(string, n2, n - n2);
        }
        this.out.write(34);
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName == null) return;
        this.beforeName();
        this.string(this.deferredName);
        this.deferredName = null;
    }

    public JsonWriter beginArray() throws IOException {
        this.writeDeferredName();
        return this.open(1, '[');
    }

    public JsonWriter beginObject() throws IOException {
        this.writeDeferredName();
        return this.open(3, '{');
    }

    @Override
    public void close() throws IOException {
        this.out.close();
        int n = this.stackSize;
        if (n > 1) throw new IOException("Incomplete document");
        if (n == 1) {
            if (this.stack[n - 1] != 7) throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public JsonWriter endArray() throws IOException {
        return this.close(1, 2, ']');
    }

    public JsonWriter endObject() throws IOException {
        return this.close(3, 5, '}');
    }

    @Override
    public void flush() throws IOException {
        if (this.stackSize == 0) throw new IllegalStateException("JsonWriter is closed.");
        this.out.flush();
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter jsonValue(String string) throws IOException {
        if (string == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        this.out.append(string);
        return this;
    }

    public JsonWriter name(String string) throws IOException {
        if (string == null) throw new NullPointerException("name == null");
        if (this.deferredName != null) throw new IllegalStateException();
        if (this.stackSize == 0) throw new IllegalStateException("JsonWriter is closed.");
        this.deferredName = string;
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            this.writeDeferredName();
        }
        this.beforeValue();
        this.out.write("null");
        return this;
    }

    public final void setHtmlSafe(boolean bl) {
        this.htmlSafe = bl;
    }

    public final void setIndent(String string) {
        if (string.length() == 0) {
            this.indent = null;
            this.separator = ":";
        } else {
            this.indent = string;
            this.separator = ": ";
        }
    }

    public final void setLenient(boolean bl) {
        this.lenient = bl;
    }

    public final void setSerializeNulls(boolean bl) {
        this.serializeNulls = bl;
    }

    public JsonWriter value(double d) throws IOException {
        this.writeDeferredName();
        if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append(d);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.beforeValue();
        this.out.append(Double.toString(d));
        return this;
    }

    public JsonWriter value(long l) throws IOException {
        this.writeDeferredName();
        this.beforeValue();
        this.out.write(Long.toString(l));
        return this;
    }

    public JsonWriter value(Boolean object) throws IOException {
        if (object == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        Writer writer = this.out;
        object = ((Boolean)object).booleanValue() ? "true" : "false";
        writer.write((String)object);
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        CharSequence charSequence = number.toString();
        if (!this.lenient && (((String)charSequence).equals("-Infinity") || ((String)charSequence).equals("Infinity") || ((String)charSequence).equals("NaN"))) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Numeric values must be finite, but was ");
            ((StringBuilder)charSequence).append(number);
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
        }
        this.beforeValue();
        this.out.append(charSequence);
        return this;
    }

    public JsonWriter value(String string) throws IOException {
        if (string == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue();
        this.string(string);
        return this;
    }

    public JsonWriter value(boolean bl) throws IOException {
        this.writeDeferredName();
        this.beforeValue();
        Writer writer = this.out;
        String string = bl ? "true" : "false";
        writer.write(string);
        return this;
    }
}
