/*
 * Decompiled with CFR 0.152.
 */
package com.hp.hpl.sparta.xpath;

import java.io.IOException;
import java.io.Reader;

public class SimpleStreamTokenizer {
    private static final int QUOTE = -6;
    public static final int TT_EOF = -1;
    public static final int TT_NUMBER = -2;
    public static final int TT_WORD = -3;
    private static final int WHITESPACE = -5;
    private final StringBuffer buf_;
    private final int[] charType_;
    private char inQuote_;
    private int nextType_;
    public int nval;
    private boolean pushedBack_;
    private final Reader reader_;
    public String sval = "";
    public int ttype = Integer.MIN_VALUE;

    public SimpleStreamTokenizer(Reader reader) throws IOException {
        this.nval = Integer.MIN_VALUE;
        this.buf_ = new StringBuffer();
        this.charType_ = new int[256];
        int n = 0;
        this.pushedBack_ = false;
        this.inQuote_ = '\u0000';
        this.reader_ = reader;
        while (true) {
            if (n >= this.charType_.length) {
                this.nextToken();
                return;
            }
            this.charType_[n] = 65 <= n && n <= 90 || 97 <= n && n <= 122 || n == 45 ? -3 : (48 <= n && n <= 57 ? -2 : (n >= 0 && n <= 32 ? -5 : n));
            n = (char)(n + 1);
        }
    }

    public int nextToken() throws IOException {
        int n;
        if (this.pushedBack_) {
            this.pushedBack_ = false;
            return this.ttype;
        }
        this.ttype = this.nextType_;
        do {
            int n2;
            int n3;
            block11: {
                int n4;
                block14: {
                    block16: {
                        String string;
                        block15: {
                            block12: {
                                block13: {
                                    boolean bl;
                                    n4 = 0;
                                    do {
                                        if ((n3 = this.reader_.read()) == -1) {
                                            if (this.inQuote_ != '\u0000') throw new IOException("Unterminated quote");
                                            n2 = -1;
                                        } else {
                                            n2 = this.charType_[n3];
                                        }
                                        bl = this.inQuote_ == '\u0000' && n2 == -5;
                                        n = n4 == 0 && !bl ? 0 : 1;
                                        n4 = n;
                                    } while (bl);
                                    if (n2 == 39 || n2 == 34) {
                                        n4 = this.inQuote_;
                                        if (n4 == 0) {
                                            this.inQuote_ = (char)n2;
                                        } else if (n4 == n2) {
                                            this.inQuote_ = '\u0000';
                                        }
                                    }
                                    if ((n4 = this.inQuote_) != 0) {
                                        n2 = n4;
                                    }
                                    n = n == 0 && ((n = this.ttype) < -1 || n == 39 || n == 34) && this.ttype == n2 ? 0 : 1;
                                    if (n == 0) break block11;
                                    n4 = this.ttype;
                                    if (n4 == -3) break block12;
                                    if (n4 == -2) break block13;
                                    if (n4 != 34 && n4 != 39) break block14;
                                    string = this.buf_.toString().substring(1, this.buf_.length() - 1);
                                    break block15;
                                }
                                this.nval = Integer.parseInt(this.buf_.toString());
                                break block16;
                            }
                            string = this.buf_.toString();
                        }
                        this.sval = string;
                    }
                    this.buf_.setLength(0);
                }
                if (n2 != -5) {
                    n4 = n2 == -6 ? n3 : n2;
                    this.nextType_ = n4;
                }
            }
            if (n2 != -3 && n2 != -2 && n2 != 34 && n2 != 39) continue;
            this.buf_.append((char)n3);
        } while (n == 0);
        return this.ttype;
    }

    public void ordinaryChar(char c) {
        this.charType_[c] = c;
    }

    public void pushBack() {
        this.pushedBack_ = true;
    }

    public String toString() {
        int n = this.ttype;
        if (n != -3) {
            if (n == -2) return Integer.toString(this.nval);
            if (n == -1) return "(EOF)";
            if (n != 34) {
                if (n != 39) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("'");
                    stringBuffer.append((char)this.ttype);
                    stringBuffer.append("'");
                    return stringBuffer.toString();
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("'");
                stringBuffer.append(this.sval);
                stringBuffer.append("'");
                return stringBuffer.toString();
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"");
        stringBuffer.append(this.sval);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public void wordChars(char c, char c2) {
        while (c <= c2) {
            this.charType_[c] = -3;
            c = (char)(c + '\u0001');
        }
        return;
    }
}
