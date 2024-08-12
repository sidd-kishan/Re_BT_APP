/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.EncodingMismatchException
 *  com.hp.hpl.sparta.ParseCharStream
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.ParseHandler
 *  com.hp.hpl.sparta.ParseLog
 *  com.hp.hpl.sparta.ParseSource
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.EncodingMismatchException;
import com.hp.hpl.sparta.ParseCharStream;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.ParseHandler;
import com.hp.hpl.sparta.ParseLog;
import com.hp.hpl.sparta.ParseSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

class ParseByteStream
implements ParseSource {
    private ParseCharStream parseSource_;

    public ParseByteStream(String string, InputStream closeable, ParseLog parseLog, String string2, ParseHandler parseHandler) throws ParseException, IOException {
        if (parseLog == null) {
            parseLog = ParseSource.DEFAULT_LOG;
        }
        if (!closeable.markSupported()) throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
        closeable.mark(ParseSource.MAXLOOKAHEAD);
        Object object = new byte[4];
        int n = closeable.read((byte[])object);
        if (string2 == null) {
            string2 = ParseByteStream.guessEncoding(string, object, n, parseLog);
        }
        try {
            closeable.reset();
            object = new InputStreamReader;
            super((InputStream)closeable, ParseByteStream.fixEncoding(string2));
            try {
                ParseCharStream parseCharStream;
                this.parseSource_ = parseCharStream = new ParseCharStream(string, (Reader)object, parseLog, string2, parseHandler);
            }
            catch (IOException iOException) {
                InputStreamReader inputStreamReader;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Problem reading with assumed encoding of ");
                stringBuffer.append(string2);
                stringBuffer.append(" so restarting with ");
                stringBuffer.append("euc-jp");
                parseLog.note(stringBuffer.toString(), string, 1);
                closeable.reset();
                try {
                    inputStreamReader = new InputStreamReader((InputStream)closeable, ParseByteStream.fixEncoding("euc-jp"));
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("\"");
                    stringBuffer2.append("euc-jp");
                    stringBuffer2.append("\" is not a supported encoding");
                    ParseException parseException = new ParseException(parseLog, string, 1, 0, "euc-jp", stringBuffer2.toString());
                    throw parseException;
                }
                super(string, (Reader)inputStreamReader, parseLog, null, parseHandler);
                this.parseSource_ = stringBuffer;
            }
        }
        catch (EncodingMismatchException encodingMismatchException) {
            String string3 = encodingMismatchException.getDeclaredEncoding();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Encoding declaration of ");
            stringBuffer.append(string3);
            stringBuffer.append(" is different that assumed ");
            stringBuffer.append(string2);
            stringBuffer.append(" so restarting the parsing with the new encoding");
            parseLog.note(stringBuffer.toString(), string, 1);
            closeable.reset();
            try {
                closeable = new InputStreamReader((InputStream)closeable, ParseByteStream.fixEncoding(string3));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("\"");
                stringBuffer3.append(string3);
                stringBuffer3.append("\" is not a supported encoding");
                throw new ParseException(parseLog, string, 1, 0, string3, stringBuffer3.toString());
            }
            this.parseSource_ = new ParseCharStream(string, (Reader)closeable, parseLog, null, parseHandler);
        }
    }

    private static boolean equals(byte[] byArray, int n) {
        boolean bl;
        boolean bl2 = bl = false;
        if (byArray[0] != (byte)(n >>> 24)) return bl2;
        bl2 = bl;
        if (byArray[1] != (byte)(n >>> 16 & 0xFF)) return bl2;
        bl2 = bl;
        if (byArray[2] != (byte)(n >>> 8 & 0xFF)) return bl2;
        bl2 = bl;
        if (byArray[3] != (byte)(n & 0xFF)) return bl2;
        bl2 = true;
        return bl2;
    }

    private static boolean equals(byte[] byArray, short s) {
        boolean bl;
        boolean bl2 = bl = false;
        if (byArray[0] != (byte)(s >>> 8)) return bl2;
        bl2 = bl;
        if (byArray[1] != (byte)(s & 0xFF)) return bl2;
        bl2 = true;
        return bl2;
    }

    private static String fixEncoding(String string) {
        String string2 = string;
        if (!string.toLowerCase().equals("utf8")) return string2;
        string2 = "UTF-8";
        return string2;
    }

    /*
     * Unable to fully structure code
     */
    private static String guessEncoding(String var0, byte[] var1_1, int var2_2, ParseLog var3_3) throws IOException {
        block9: {
            block7: {
                block10: {
                    block8: {
                        block6: {
                            if (var2_2 == 4) break block6;
                            if (var2_2 <= 0) {
                                var4_4 = "no characters in input";
                            } else {
                                var4_4 = new StringBuffer();
                                var4_4.append("less than 4 characters in input: \"");
                                var4_4.append(new String(var1_1, 0, var2_2));
                                var4_4.append("\"");
                                var4_4 = var4_4.toString();
                            }
                            var3_3.error((String)var4_4, var0, 1);
                            ** GOTO lbl-1000
                        }
                        if (ParseByteStream.equals(var1_1, 65279) || ParseByteStream.equals(var1_1, -131072) || ParseByteStream.equals(var1_1, 65534) || ParseByteStream.equals(var1_1, -16842752) || ParseByteStream.equals(var1_1, 60) || ParseByteStream.equals(var1_1, 0x3C000000) || ParseByteStream.equals(var1_1, 15360) || ParseByteStream.equals(var1_1, 0x3C0000)) break block7;
                        if (!ParseByteStream.equals(var1_1, 3932223)) break block8;
                        var4_4 = "UTF-16BE";
                        break block9;
                    }
                    if (!ParseByteStream.equals(var1_1, 1006649088)) break block10;
                    var4_4 = "UTF-16LE";
                    break block9;
                }
                if (ParseByteStream.equals(var1_1, 1010792557)) ** GOTO lbl-1000
                if (ParseByteStream.equals(var1_1, 1282385812)) {
                    var4_4 = "EBCDIC";
                } else if (ParseByteStream.equals(var1_1, (short)-2) || ParseByteStream.equals(var1_1, (short)-257)) {
                    var4_4 = "UTF-16";
                } else lbl-1000:
                // 3 sources

                {
                    var4_4 = "UTF-8";
                }
                break block9;
            }
            var4_4 = "UCS-4";
        }
        if (var4_4.equals("UTF-8") != false) return var4_4;
        var5_5 = new StringBuffer();
        var5_5.append("From start ");
        var5_5.append(ParseByteStream.hex(var1_1[0]));
        var5_5.append(" ");
        var5_5.append(ParseByteStream.hex(var1_1[1]));
        var5_5.append(" ");
        var5_5.append(ParseByteStream.hex(var1_1[2]));
        var5_5.append(" ");
        var5_5.append(ParseByteStream.hex(var1_1[3]));
        var5_5.append(" deduced encoding = ");
        var5_5.append((String)var4_4);
        var3_3.note(var5_5.toString(), var0, 1);
        return var4_4;
    }

    private static String hex(byte by) {
        String string = Integer.toHexString(by);
        if ((by = (byte)string.length()) != 1) {
            String string2 = string;
            if (by == 2) return string2;
            string2 = string.substring(string.length() - 2);
            return string2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0");
        stringBuffer.append(string);
        return stringBuffer.toString();
    }

    public int getLineNumber() {
        return this.parseSource_.getLineNumber();
    }

    public String getSystemId() {
        return this.parseSource_.getSystemId();
    }

    public String toString() {
        return this.parseSource_.toString();
    }
}
