/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.util.Arrays;

public class JsonReader
implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];
    private final Reader in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack;
    private int stackSize;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess(){

            @Override
            public void promoteNameToValue(JsonReader reader) throws IOException {
                if (reader instanceof JsonTreeReader) {
                    ((JsonTreeReader)reader).promoteNameToValue();
                    return;
                }
                int p = reader.peeked;
                if (p == 0) {
                    p = reader.doPeek();
                }
                if (p == 13) {
                    reader.peeked = 9;
                } else if (p == 12) {
                    reader.peeked = 8;
                } else {
                    if (p != 14) throw new IllegalStateException("Expected a name but was " + (Object)((Object)reader.peek()) + reader.locationString());
                    reader.peeked = 10;
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] nArray = new int[32];
        this.stack = nArray;
        this.stackSize = 0;
        this.stackSize = 0 + 1;
        nArray[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader == null) throw new NullPointerException("in == null");
        this.in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void consumeNonExecutePrefix() throws IOException {
        int n;
        this.nextNonWhitespace(true);
        this.pos = n = this.pos - 1;
        if (n + 5 > this.limit && !this.fillBuffer(5)) {
            return;
        }
        char[] cArray = this.buffer;
        if (cArray[n] != ')') return;
        if (cArray[n + 1] != ']') return;
        if (cArray[n + 2] != '}') return;
        if (cArray[n + 3] != '\'') return;
        if (cArray[n + 4] != '\n') return;
        this.pos += 5;
    }

    private boolean fillBuffer(int n) throws IOException {
        char[] cArray = this.buffer;
        int n2 = this.lineStart;
        int n3 = this.pos;
        this.lineStart = n2 - n3;
        n2 = this.limit;
        if (n2 != n3) {
            this.limit = n2 -= n3;
            System.arraycopy(cArray, n3, cArray, 0, n2);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            n3 = this.limit;
            if ((n3 = reader.read(cArray, n3, cArray.length - n3)) == -1) return false;
            this.limit = n2 = this.limit + n3;
            n3 = n;
            if (this.lineNumber == 0) {
                int n4 = this.lineStart;
                n3 = n;
                if (n4 == 0) {
                    n3 = n;
                    if (n2 > 0) {
                        n3 = n;
                        if (cArray[0] == '\ufeff') {
                            ++this.pos;
                            this.lineStart = n4 + 1;
                            n3 = n + 1;
                        }
                    }
                }
            }
            n = n3;
        } while (this.limit < n3);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private boolean isLiteral(char var1_1) throws IOException {
        if (var1_1 == '\t') return false;
        if (var1_1 == '\n') return false;
        if (var1_1 == '\f') return false;
        if (var1_1 == '\r') return false;
        if (var1_1 == ' ') return false;
        if (var1_1 == '#') ** GOTO lbl-1000
        if (var1_1 == ',') return false;
        if (var1_1 == '/' || var1_1 == '=') ** GOTO lbl-1000
        if (var1_1 == '{') return false;
        if (var1_1 == '}') return false;
        if (var1_1 == ':') return false;
        if (var1_1 == ';') ** GOTO lbl-1000
        switch (var1_1) {
            default: {
                return true;
            }
            case '\\': lbl-1000:
            // 4 sources

            {
                this.checkLenient();
                break;
            }
            case '[': 
            case ']': 
        }
        return false;
    }

    private int nextNonWhitespace(boolean bl) throws IOException {
        Object object = this.buffer;
        Object object2 = this.pos;
        int n = this.limit;
        while (true) {
            int n2 = object2;
            int n3 = n;
            if (object2 == n) {
                this.pos = object2;
                if (!this.fillBuffer(1)) {
                    if (bl) break;
                    return -1;
                }
                n2 = this.pos;
                n3 = this.limit;
            }
            object2 = n2 + 1;
            n = object[n2];
            if (n == 10) {
                ++this.lineNumber;
                this.lineStart = object2;
            } else if (n != 32 && n != 13 && n != 9) {
                if (n == 47) {
                    this.pos = object2;
                    if (object2 == n3) {
                        this.pos = object2 - 1;
                        boolean bl2 = this.fillBuffer(2);
                        ++this.pos;
                        if (!bl2) {
                            return n;
                        }
                    }
                    this.checkLenient();
                    n3 = this.pos;
                    object2 = object[n3];
                    if (object2 != 42) {
                        if (object2 != 47) {
                            return n;
                        }
                        this.pos = n3 + 1;
                        this.skipToEndOfLine();
                        object2 = this.pos;
                        n = this.limit;
                        continue;
                    }
                    this.pos = n3 + 1;
                    if (!this.skipTo("*/")) throw this.syntaxError("Unterminated comment");
                    object2 = this.pos + 2;
                    n = this.limit;
                    continue;
                }
                if (n != 35) {
                    this.pos = object2;
                    return n;
                }
                this.pos = object2;
                this.checkLenient();
                this.skipToEndOfLine();
                object2 = this.pos;
                n = this.limit;
                continue;
            }
            n = n3;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("End of input");
        ((StringBuilder)object).append(this.locationString());
        throw new EOFException(((StringBuilder)object).toString());
    }

    private String nextQuotedValue(char c) throws IOException {
        int n;
        char[] cArray = this.buffer;
        Serializable serializable = null;
        block0: while (true) {
            StringBuilder stringBuilder;
            int n2;
            n = this.pos;
            int n3 = this.limit;
            block1: while (true) {
                int n4 = n;
                while ((n2 = n4) < n3) {
                    n4 = n2 + 1;
                    if ((n2 = cArray[n2]) == c) {
                        this.pos = n4;
                        c = (char)(n4 - n - 1);
                        if (serializable != null) break block0;
                        return new String(cArray, n, (int)c);
                    }
                    if (n2 == 92) {
                        this.pos = n4;
                        n4 = n4 - n - 1;
                        stringBuilder = serializable;
                        if (serializable == null) {
                            stringBuilder = new StringBuilder(Math.max((n4 + 1) * 2, 16));
                        }
                        stringBuilder.append(cArray, n, n4);
                        stringBuilder.append(this.readEscapeCharacter());
                        n = this.pos;
                        n3 = this.limit;
                        serializable = stringBuilder;
                        continue block1;
                    }
                    if (n2 != 10) continue;
                    ++this.lineNumber;
                    this.lineStart = n4;
                }
                break;
            }
            stringBuilder = serializable;
            if (serializable == null) {
                stringBuilder = new StringBuilder(Math.max((n2 - n) * 2, 16));
            }
            stringBuilder.append(cArray, n, n2 - n);
            this.pos = n2;
            if (!this.fillBuffer(1)) {
                serializable = this.syntaxError("Unterminated string");
                throw serializable;
            }
            serializable = stringBuilder;
        }
        ((StringBuilder)serializable).append(cArray, n, c);
        return ((StringBuilder)serializable).toString();
    }

    /*
     * Recovered potentially malformed switches.  Disable with '--allowmalformedswitch false'
     * Unable to fully structure code
     */
    private String nextUnquotedValue() throws IOException {
        block11: {
            var2_1 = 0;
            var5_2 /* !! */  = null;
            do {
                block10: {
                    var1_3 = 0;
                    block5: while (true) {
                        if ((var3_4 = this.pos) + var1_3 >= this.limit) ** GOTO lbl20
                        if ((var3_4 = this.buffer[var3_4 + var1_3]) == 9 || var3_4 == 10 || var3_4 == 12 || var3_4 == 13 || var3_4 == 32) break;
                        if (var3_4 == 35) ** GOTO lbl-1000
                        if (var3_4 == 44) break;
                        if (var3_4 == 47 || var3_4 == 61) ** GOTO lbl-1000
                        if (var3_4 == 123 || var3_4 == 125 || var3_4 == 58) break;
                        if (var3_4 == 59) ** GOTO lbl-1000
                        switch (var3_4) {
                            default: {
                                ++var1_3;
                                continue block5;
                            }
                            case 92: lbl-1000:
                            // 4 sources

                            {
                                this.checkLenient();
                                break block5;
                            }
lbl20:
                            // 1 sources

                            if (var1_3 < this.buffer.length) {
                                if (!this.fillBuffer(var1_3 + 1)) break block5;
                                continue block5;
                            }
                            break block10;
                            case 91: 
                            case 93: 
                        }
                        break;
                    }
                    var4_5 = var5_2 /* !! */ ;
                    break block11;
                }
                var4_5 = var5_2 /* !! */ ;
                if (var5_2 /* !! */  == null) {
                    var4_5 = new StringBuilder(Math.max(var1_3, 16));
                }
                var4_5.append(this.buffer, this.pos, var1_3);
                this.pos += var1_3;
                var5_2 /* !! */  = var4_5;
            } while (this.fillBuffer(1));
            var1_3 = var2_1;
        }
        if (var4_5 == null) {
            var4_5 = new String(this.buffer, this.pos, var1_3);
        } else {
            var4_5.append(this.buffer, this.pos, var1_3);
            var4_5 = var4_5.toString();
        }
        this.pos += var1_3;
        return var4_5;
    }

    private int peekKeyword() throws IOException {
        String string;
        String string2;
        int n = this.buffer[this.pos];
        if (n != 116 && n != 84) {
            if (n != 102 && n != 70) {
                if (n != 110) {
                    if (n != 78) return 0;
                }
                n = 7;
                string2 = "null";
                string = "NULL";
            } else {
                n = 6;
                string2 = "false";
                string = "FALSE";
            }
        } else {
            n = 5;
            string2 = "true";
            string = "TRUE";
        }
        int n2 = string2.length();
        for (int i = 1; i < n2; ++i) {
            if (this.pos + i >= this.limit && !this.fillBuffer(i + 1)) {
                return 0;
            }
            char c = this.buffer[this.pos + i];
            if (c == string2.charAt(i) || c == string.charAt(i)) continue;
            return 0;
        }
        if ((this.pos + n2 < this.limit || this.fillBuffer(n2 + 1)) && this.isLiteral(this.buffer[this.pos + n2])) {
            return 0;
        }
        this.pos += n2;
        this.peeked = n;
        return n;
    }

    /*
     * Unable to fully structure code
     */
    private int peekNumber() throws IOException {
        var14_1 = this.buffer;
        var9_2 = this.pos;
        var4_3 = this.limit;
        var6_4 = 0;
        var2_5 = 0;
        var3_6 = 1;
        var10_7 = 0L;
        var5_8 = false;
        while (true) {
            block20: {
                block22: {
                    block12: {
                        block13: {
                            block21: {
                                block14: {
                                    block15: {
                                        block11: {
                                            block16: {
                                                block17: {
                                                    block19: {
                                                        block18: {
                                                            block10: {
                                                                var8_11 = var9_2;
                                                                var7_10 = var4_3;
                                                                if (var9_2 + var6_4 != var4_3) break block10;
                                                                if (var6_4 == var14_1.length) {
                                                                    return 0;
                                                                }
                                                                if (!this.fillBuffer(var6_4 + 1)) break block11;
                                                                var8_11 = this.pos;
                                                                var7_10 = this.limit;
                                                            }
                                                            if ((var1_9 = var14_1[var8_11 + var6_4]) == '+') break block12;
                                                            if (var1_9 == 'E' || var1_9 == 'e') break block13;
                                                            if (var1_9 == '-') break block14;
                                                            if (var1_9 == '.') break block15;
                                                            if (var1_9 < '0' || var1_9 > '9') break block16;
                                                            if (var2_5 == 1 || var2_5 == 0) break block17;
                                                            if (var2_5 != 2) break block18;
                                                            if (var10_7 == 0L) {
                                                                return 0;
                                                            }
                                                            var12_12 = 10L * var10_7 - (long)(var1_9 - 48);
                                                            var4_3 = var10_7 <= -922337203685477580L && (var10_7 != -922337203685477580L || var12_12 >= var10_7) ? 0 : 1;
                                                            var4_3 = var3_6 & var4_3;
                                                            ** GOTO lbl-1000
                                                        }
                                                        if (var2_5 != 3) break block19;
                                                        var2_5 = 4;
                                                        break block20;
                                                    }
                                                    if (var2_5 != 5) {
                                                        var4_3 = var3_6;
                                                        var12_12 = var10_7;
                                                        ** if (var2_5 == 6) goto lbl-1000
                                                    }
                                                    ** GOTO lbl-1000
lbl-1000:
                                                    // 2 sources

                                                    {
                                                        var3_6 = var4_3;
                                                        var10_7 = var12_12;
                                                        ** GOTO lbl87
                                                    }
lbl-1000:
                                                    // 2 sources

                                                    {
                                                        var2_5 = 7;
                                                    }
                                                    break block20;
                                                }
                                                var10_7 = -(var1_9 - 48);
                                                var2_5 = 2;
                                                break block20;
                                            }
                                            if (this.isLiteral(var1_9) != false) return 0;
                                        }
                                        if (!(var2_5 != 2 || var3_6 == 0 || var10_7 == -9223372036854775808L && !var5_8 || var10_7 == 0L && var5_8)) {
                                            if (!var5_8) {
                                                var10_7 = -var10_7;
                                            }
                                            this.peekedLong = var10_7;
                                            this.pos += var6_4;
                                            this.peeked = 15;
                                            return 15;
                                        }
                                        if (var2_5 != 2 && var2_5 != 4) {
                                            if (var2_5 != 7) return 0;
                                        }
                                        this.peekedNumberLength = var6_4;
                                        this.peeked = 16;
                                        return 16;
                                    }
                                    if (var2_5 != 2) return 0;
                                    var2_5 = 3;
                                    break block20;
                                }
                                if (var2_5 != 0) break block21;
                                var2_5 = 1;
                                var5_8 = true;
                                break block20;
                            }
                            if (var2_5 != 5) return 0;
                            break block22;
                        }
                        if (var2_5 != 2) {
                            if (var2_5 != 4) return 0;
                        }
                        var2_5 = 5;
                        break block20;
                    }
                    if (var2_5 != 5) return 0;
                }
                var2_5 = 6;
            }
            ++var6_4;
            var9_2 = var8_11;
            var4_3 = var7_10;
        }
    }

    private void push(int n) {
        int n2 = this.stackSize;
        int[] nArray = this.stack;
        if (n2 == nArray.length) {
            this.stack = Arrays.copyOf(nArray, n2 *= 2);
            this.pathIndices = Arrays.copyOf(this.pathIndices, n2);
            this.pathNames = Arrays.copyOf(this.pathNames, n2);
        }
        nArray = this.stack;
        n2 = this.stackSize;
        this.stackSize = n2 + 1;
        nArray[n2] = n;
    }

    private char readEscapeCharacter() throws IOException {
        int n;
        if (this.pos == this.limit) {
            if (!this.fillBuffer(1)) throw this.syntaxError("Unterminated escape sequence");
        }
        Object object = this.buffer;
        int n2 = this.pos;
        this.pos = n = n2 + 1;
        char c = object[n2];
        if (c == '\n') {
            ++this.lineNumber;
            this.lineStart = n;
            return c;
        }
        if (c == '\"') return c;
        if (c == '\'') return c;
        if (c == '/') return c;
        if (c == '\\') return c;
        if (c == 'b') return '\b';
        if (c == 'f') return '\f';
        if (c == 'n') return '\n';
        if (c == 'r') return '\r';
        if (c == 't') return '\t';
        if (c != 'u') throw this.syntaxError("Invalid escape sequence");
        if (n + 4 > this.limit) {
            if (!this.fillBuffer(4)) throw this.syntaxError("Unterminated escape sequence");
        }
        c = '\u0000';
        n2 = n = this.pos;
        while (true) {
            int n3;
            if ((n3 = n2) >= n + 4) {
                this.pos += 4;
                return c;
            }
            n2 = this.buffer[n3];
            char c2 = (char)(c << 4);
            if (n2 >= 48 && n2 <= 57) {
                n2 -= 48;
            } else {
                if (n2 >= 97 && n2 <= 102) {
                    n2 -= 97;
                } else {
                    if (n2 < 65 || n2 > 70) break;
                    n2 -= 65;
                }
                n2 += 10;
            }
            c = (char)(c2 + n2);
            n2 = n3 + 1;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("\\u");
        ((StringBuilder)object).append(new String(this.buffer, this.pos, 4));
        throw new NumberFormatException(((StringBuilder)object).toString());
    }

    private void skipQuotedValue(char c) throws IOException {
        Object object = this.buffer;
        do {
            int n = this.pos;
            int n2 = this.limit;
            while (n < n2) {
                int n3 = n + 1;
                if ((n = object[n]) == c) {
                    this.pos = n3;
                    return;
                }
                if (n == 92) {
                    this.pos = n3;
                    this.readEscapeCharacter();
                    n = this.pos;
                    n2 = this.limit;
                    continue;
                }
                if (n == 10) {
                    ++this.lineNumber;
                    this.lineStart = n3;
                }
                n = n3;
            }
            this.pos = n;
        } while (this.fillBuffer(1));
        object = this.syntaxError("Unterminated string");
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    private boolean skipTo(String var1_1) throws IOException {
        var3_2 = var1_1.length();
        block0: while (true) {
            block6: {
                var4_4 = this.pos;
                var5_5 = this.limit;
                var2_3 = 0;
                if (var4_4 + var3_2 > var5_5) {
                    if (this.fillBuffer(var3_2) == false) return false;
                }
                if ((var6_6 = this.buffer)[var4_4 = this.pos] != '\n') break block6;
                ++this.lineNumber;
                this.lineStart = var4_4 + 1;
                ** GOTO lbl15
            }
            while (var2_3 < var3_2) {
                block7: {
                    if (this.buffer[this.pos + var2_3] == var1_1.charAt(var2_3)) break block7;
lbl15:
                    // 2 sources

                    ++this.pos;
                    continue block0;
                }
                ++var2_3;
            }
            return true;
        }
    }

    private void skipToEndOfLine() throws IOException {
        int n;
        do {
            int n2;
            if (this.pos >= this.limit) {
                if (!this.fillBuffer(1)) return;
            }
            char[] cArray = this.buffer;
            n = this.pos;
            this.pos = n2 = n + 1;
            if ((n = cArray[n]) != 10) continue;
            ++this.lineNumber;
            this.lineStart = n2;
            break;
        } while (n != 13);
    }

    /*
     * Unable to fully structure code
     */
    private void skipUnquotedValue() throws IOException {
        do {
            var1_1 = 0;
            block5: while ((var2_2 = this.pos) + var1_1 < this.limit) {
                block6: {
                    if ((var2_2 = this.buffer[var2_2 + var1_1]) == 9 || var2_2 == 10 || var2_2 == 12 || var2_2 == 13 || var2_2 == 32) break block6;
                    if (var2_2 == 35) ** GOTO lbl-1000
                    if (var2_2 == 44) break block6;
                    if (var2_2 == 47 || var2_2 == 61) ** GOTO lbl-1000
                    if (var2_2 == 123 || var2_2 == 125 || var2_2 == 58) break block6;
                    if (var2_2 == 59) ** GOTO lbl-1000
                    switch (var2_2) {
                        default: {
                            ++var1_1;
                            continue block5;
                        }
                        case 92: lbl-1000:
                        // 4 sources

                        {
                            this.checkLenient();
                            break;
                        }
                        case 91: 
                        case 93: 
                    }
                }
                this.pos += var1_1;
                return;
            }
            this.pos = var2_2 + var1_1;
        } while (this.fillBuffer(1));
    }

    private IOException syntaxError(String string) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(this.locationString());
        throw new MalformedJsonException(stringBuilder.toString());
    }

    public void beginArray() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 3) {
            this.push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(this.locationString());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void beginObject() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 1) {
            this.push(3);
            this.peeked = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(this.locationString());
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    int doPeek() throws IOException {
        int n;
        int n2;
        block33: {
            block31: {
                Object[] objectArray;
                block32: {
                    block30: {
                        objectArray = this.stack;
                        n2 = this.stackSize;
                        n = objectArray[n2 - 1];
                        if (n != 1) break block30;
                        objectArray[n2 - 1] = 2;
                        break block31;
                    }
                    if (n != 2) break block32;
                    n2 = this.nextNonWhitespace(true);
                    if (n2 != 44) {
                        if (n2 != 59) {
                            if (n2 != 93) throw this.syntaxError("Unterminated array");
                            this.peeked = 4;
                            return 4;
                        }
                        this.checkLenient();
                    }
                    break block31;
                }
                if (n == 3 || n == 5) break block33;
                if (n == 4) {
                    objectArray[n2 - 1] = 5;
                    n2 = this.nextNonWhitespace(true);
                    if (n2 != 58) {
                        if (n2 != 61) throw this.syntaxError("Expected ':'");
                        this.checkLenient();
                        if ((this.pos < this.limit || this.fillBuffer(1)) && (objectArray = (Object[])this.buffer)[n2 = this.pos] == 62) {
                            this.pos = n2 + 1;
                        }
                    }
                } else if (n == 6) {
                    if (this.lenient) {
                        this.consumeNonExecutePrefix();
                    }
                    this.stack[this.stackSize - 1] = 7;
                } else if (n == 7) {
                    if (this.nextNonWhitespace(false) == -1) {
                        this.peeked = 17;
                        return 17;
                    }
                    this.checkLenient();
                    --this.pos;
                } else if (n == 8) throw new IllegalStateException("JsonReader is closed");
            }
            n2 = this.nextNonWhitespace(true);
            if (n2 == 34) {
                this.peeked = 9;
                return 9;
            }
            if (n2 == 39) {
                this.checkLenient();
                this.peeked = 8;
                return 8;
            }
            if (n2 != 44 && n2 != 59) {
                if (n2 == 91) {
                    this.peeked = 3;
                    return 3;
                }
                if (n2 != 93) {
                    if (n2 == 123) {
                        this.peeked = 1;
                        return 1;
                    }
                    --this.pos;
                    n = this.peekKeyword();
                    if (n != 0) {
                        return n;
                    }
                    n = this.peekNumber();
                    if (n != 0) {
                        return n;
                    }
                    if (!this.isLiteral(this.buffer[this.pos])) throw this.syntaxError("Expected value");
                    this.checkLenient();
                    this.peeked = 10;
                    return 10;
                }
                if (n == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (n != 1) {
                if (n != 2) throw this.syntaxError("Unexpected value");
            }
            this.checkLenient();
            --this.pos;
            this.peeked = 7;
            return 7;
        }
        this.stack[this.stackSize - 1] = 4;
        if (n == 5 && (n2 = this.nextNonWhitespace(true)) != 44) {
            if (n2 != 59) {
                if (n2 != 125) throw this.syntaxError("Unterminated object");
                this.peeked = 2;
                return 2;
            }
            this.checkLenient();
        }
        if ((n2 = this.nextNonWhitespace(true)) == 34) {
            this.peeked = 13;
            return 13;
        }
        if (n2 == 39) {
            this.checkLenient();
            this.peeked = 12;
            return 12;
        }
        if (n2 != 125) {
            this.checkLenient();
            --this.pos;
            if (!this.isLiteral((char)n2)) throw this.syntaxError("Expected name");
            this.peeked = 14;
            return 14;
        }
        if (n == 5) throw this.syntaxError("Expected name");
        this.peeked = 2;
        return 2;
    }

    public void endArray() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 4) {
            n2 = this.stackSize - 1;
            this.stackSize = n2--;
            int[] nArray = this.pathIndices;
            nArray[n2] = nArray[n2] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(this.locationString());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void endObject() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 2) {
            this.stackSize = n2 = this.stackSize - 1;
            this.pathNames[n2] = null;
            int[] nArray = this.pathIndices;
            nArray[--n2] = nArray[n2] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(this.locationString());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String getPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        int n = this.stackSize;
        int n2 = 0;
        while (n2 < n) {
            int n3 = this.stack[n2];
            if (n3 != 1 && n3 != 2) {
                if (n3 == 3 || n3 == 4 || n3 == 5) {
                    stringBuilder.append('.');
                    String[] stringArray = this.pathNames;
                    if (stringArray[n2] != null) {
                        stringBuilder.append(stringArray[n2]);
                    }
                }
            } else {
                stringBuilder.append('[');
                stringBuilder.append(this.pathIndices[n2]);
                stringBuilder.append(']');
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    public boolean hasNext() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        boolean bl = n2 != 2 && n2 != 4;
        return bl;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    String locationString() {
        int n = this.lineNumber;
        int n2 = this.pos;
        int n3 = this.lineStart;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" at line ");
        stringBuilder.append(n + 1);
        stringBuilder.append(" column ");
        stringBuilder.append(n2 - n3 + 1);
        stringBuilder.append(" path ");
        stringBuilder.append(this.getPath());
        return stringBuilder.toString();
    }

    public boolean nextBoolean() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 5) {
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n2 = this.stackSize - 1;
            nArray[n2] = nArray[n2] + 1;
            return true;
        }
        if (n2 == 6) {
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n2 = this.stackSize - 1;
            nArray[n2] = nArray[n2] + 1;
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a boolean but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(this.locationString());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public double nextDouble() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 15) {
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n2 = this.stackSize - 1;
            nArray[n2] = nArray[n2] + 1;
            return this.peekedLong;
        }
        if (n2 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (n2 != 8 && n2 != 9) {
            if (n2 == 10) {
                this.peekedString = this.nextUnquotedValue();
            } else if (n2 != 11) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a double but was ");
                stringBuilder.append((Object)this.peek());
                stringBuilder.append(this.locationString());
                throw new IllegalStateException(stringBuilder.toString());
            }
        } else {
            char c = n2 == 8 ? (char)'\'' : '\"';
            this.peekedString = this.nextQuotedValue(c);
        }
        this.peeked = 11;
        double d = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d);
            stringBuilder.append(this.locationString());
            throw new MalformedJsonException(stringBuilder.toString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] nArray = this.pathIndices;
        n2 = this.stackSize - 1;
        nArray[n2] = nArray[n2] + 1;
        return d;
    }

    public int nextInt() throws IOException {
        int n;
        int n2;
        block11: {
            n = n2 = this.peeked;
            if (n2 == 0) {
                n = this.doPeek();
            }
            if (n == 15) {
                long l = this.peekedLong;
                n = (int)l;
                if (l == (long)n) {
                    this.peeked = 0;
                    int[] nArray = this.pathIndices;
                    n2 = this.stackSize - 1;
                    nArray[n2] = nArray[n2] + 1;
                    return n;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected an int but was ");
                stringBuilder.append(this.peekedLong);
                stringBuilder.append(this.locationString());
                throw new NumberFormatException(stringBuilder.toString());
            }
            if (n == 16) {
                this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else {
                int[] nArray;
                if (n != 8 && n != 9 && n != 10) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected an int but was ");
                    stringBuilder.append((Object)this.peek());
                    stringBuilder.append(this.locationString());
                    throw new IllegalStateException(stringBuilder.toString());
                }
                if (n == 10) {
                    this.peekedString = this.nextUnquotedValue();
                } else {
                    char c = n == 8 ? (char)'\'' : '\"';
                    this.peekedString = this.nextQuotedValue(c);
                }
                try {
                    n = Integer.parseInt(this.peekedString);
                    this.peeked = 0;
                    nArray = this.pathIndices;
                    n2 = this.stackSize - 1;
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                    break block11;
                }
                nArray[n2] = nArray[n2] + 1;
                return n;
            }
        }
        this.peeked = 11;
        double d = Double.parseDouble(this.peekedString);
        n2 = (int)d;
        if ((double)n2 == d) {
            this.peekedString = null;
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n = this.stackSize - 1;
            nArray[n] = nArray[n] + 1;
            return n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected an int but was ");
        stringBuilder.append(this.peekedString);
        stringBuilder.append(this.locationString());
        throw new NumberFormatException(stringBuilder.toString());
    }

    public long nextLong() throws IOException {
        int n;
        block10: {
            int n2;
            n = n2 = this.peeked;
            if (n2 == 0) {
                n = this.doPeek();
            }
            if (n == 15) {
                this.peeked = 0;
                int[] nArray = this.pathIndices;
                n = this.stackSize - 1;
                nArray[n] = nArray[n] + 1;
                return this.peekedLong;
            }
            if (n == 16) {
                this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
                this.pos += this.peekedNumberLength;
            } else {
                int[] nArray;
                long l;
                if (n != 8 && n != 9 && n != 10) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected a long but was ");
                    stringBuilder.append((Object)this.peek());
                    stringBuilder.append(this.locationString());
                    throw new IllegalStateException(stringBuilder.toString());
                }
                if (n == 10) {
                    this.peekedString = this.nextUnquotedValue();
                } else {
                    char c = n == 8 ? (char)'\'' : '\"';
                    this.peekedString = this.nextQuotedValue(c);
                }
                try {
                    l = Long.parseLong(this.peekedString);
                    this.peeked = 0;
                    nArray = this.pathIndices;
                    n = this.stackSize - 1;
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                    break block10;
                }
                nArray[n] = nArray[n] + 1;
                return l;
            }
        }
        this.peeked = 11;
        double d = Double.parseDouble(this.peekedString);
        long l = (long)d;
        if ((double)l == d) {
            this.peekedString = null;
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n = this.stackSize - 1;
            nArray[n] = nArray[n] + 1;
            return l;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a long but was ");
        stringBuilder.append(this.peekedString);
        stringBuilder.append(this.locationString());
        throw new NumberFormatException(stringBuilder.toString());
    }

    public String nextName() throws IOException {
        String string;
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 14) {
            string = this.nextUnquotedValue();
        } else if (n2 == 12) {
            string = this.nextQuotedValue('\'');
        } else {
            if (n2 != 13) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a name but was ");
                stringBuilder.append((Object)this.peek());
                stringBuilder.append(this.locationString());
                throw new IllegalStateException(stringBuilder.toString());
            }
            string = this.nextQuotedValue('\"');
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = string;
        return string;
    }

    public void nextNull() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 7) {
            this.peeked = 0;
            int[] nArray = this.pathIndices;
            n2 = this.stackSize - 1;
            nArray[n2] = nArray[n2] + 1;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected null but was ");
        stringBuilder.append((Object)this.peek());
        stringBuilder.append(this.locationString());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public String nextString() throws IOException {
        String string;
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        if (n2 == 10) {
            string = this.nextUnquotedValue();
        } else if (n2 == 8) {
            string = this.nextQuotedValue('\'');
        } else if (n2 == 9) {
            string = this.nextQuotedValue('\"');
        } else if (n2 == 11) {
            string = this.peekedString;
            this.peekedString = null;
        } else if (n2 == 15) {
            string = Long.toString(this.peekedLong);
        } else {
            if (n2 != 16) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a string but was ");
                stringBuilder.append((Object)this.peek());
                stringBuilder.append(this.locationString());
                throw new IllegalStateException(stringBuilder.toString());
            }
            string = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.peeked = 0;
        int[] nArray = this.pathIndices;
        n2 = this.stackSize - 1;
        nArray[n2] = nArray[n2] + 1;
        return string;
    }

    public JsonToken peek() throws IOException {
        int n;
        int n2 = n = this.peeked;
        if (n == 0) {
            n2 = this.doPeek();
        }
        switch (n2) {
            default: {
                throw new AssertionError();
            }
            case 17: {
                return JsonToken.END_DOCUMENT;
            }
            case 15: 
            case 16: {
                return JsonToken.NUMBER;
            }
            case 12: 
            case 13: 
            case 14: {
                return JsonToken.NAME;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return JsonToken.STRING;
            }
            case 7: {
                return JsonToken.NULL;
            }
            case 5: 
            case 6: {
                return JsonToken.BOOLEAN;
            }
            case 4: {
                return JsonToken.END_ARRAY;
            }
            case 3: {
                return JsonToken.BEGIN_ARRAY;
            }
            case 2: {
                return JsonToken.END_OBJECT;
            }
            case 1: 
        }
        return JsonToken.BEGIN_OBJECT;
    }

    public final void setLenient(boolean bl) {
        this.lenient = bl;
    }

    public void skipValue() throws IOException {
        int n;
        int n2 = 0;
        do {
            block8: {
                block12: {
                    block13: {
                        int n3;
                        block11: {
                            block10: {
                                block9: {
                                    block7: {
                                        block6: {
                                            block5: {
                                                n3 = n = this.peeked;
                                                if (n == 0) {
                                                    n3 = this.doPeek();
                                                }
                                                if (n3 != 3) break block5;
                                                this.push(1);
                                                break block6;
                                            }
                                            if (n3 != 1) break block7;
                                            this.push(3);
                                        }
                                        n = n2 + 1;
                                        break block8;
                                    }
                                    if (n3 != 4) break block9;
                                    --this.stackSize;
                                    break block10;
                                }
                                if (n3 != 2) break block11;
                                --this.stackSize;
                            }
                            n = n2 - 1;
                            break block8;
                        }
                        if (n3 == 14 || n3 == 10) break block12;
                        if (n3 == 8 || n3 == 12) break block13;
                        if (n3 != 9 && n3 != 13) {
                            n = n2;
                            if (n3 == 16) {
                                this.pos += this.peekedNumberLength;
                                n = n2;
                            }
                            break block8;
                        } else {
                            this.skipQuotedValue('\"');
                            n = n2;
                        }
                        break block8;
                    }
                    this.skipQuotedValue('\'');
                    n = n2;
                    break block8;
                }
                this.skipUnquotedValue();
                n = n2;
            }
            this.peeked = 0;
            n2 = n;
        } while (n != 0);
        int[] nArray = this.pathIndices;
        n = this.stackSize;
        n2 = n - 1;
        nArray[n2] = nArray[n2] + 1;
        this.pathNames[n - 1] = "null";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(this.locationString());
        return stringBuilder.toString();
    }
}
