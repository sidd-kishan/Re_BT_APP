/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.server.response.FastJsonResponse
 *  com.google.android.gms.common.server.response.FastJsonResponse$Field
 *  com.google.android.gms.common.server.response.FastParser$ParseException
 *  com.google.android.gms.common.server.response.zaa
 *  com.google.android.gms.common.server.response.zab
 *  com.google.android.gms.common.server.response.zac
 *  com.google.android.gms.common.server.response.zad
 *  com.google.android.gms.common.server.response.zae
 *  com.google.android.gms.common.server.response.zaf
 *  com.google.android.gms.common.server.response.zag
 *  com.google.android.gms.common.server.response.zah
 *  com.google.android.gms.common.server.response.zai
 *  com.google.android.gms.common.util.Base64Utils
 *  com.google.android.gms.common.util.JsonUtils
 */
package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastParser;
import com.google.android.gms.common.server.response.zaa;
import com.google.android.gms.common.server.response.zab;
import com.google.android.gms.common.server.response.zac;
import com.google.android.gms.common.server.response.zad;
import com.google.android.gms.common.server.response.zae;
import com.google.android.gms.common.server.response.zaf;
import com.google.android.gms.common.server.response.zag;
import com.google.android.gms.common.server.response.zah;
import com.google.android.gms.common.server.response.zai;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaf = new char[]{'u', 'l', 'l'};
    private static final char[] zag = new char[]{'r', 'u', 'e'};
    private static final char[] zah = new char[]{'r', 'u', 'e', '\"'};
    private static final char[] zai = new char[]{'a', 'l', 's', 'e'};
    private static final char[] zaj = new char[]{'a', 'l', 's', 'e', '\"'};
    private static final char[] zak = new char[]{'\n'};
    private static final zai<Integer> zam = new zaa();
    private static final zai<Long> zan = new zab();
    private static final zai<Float> zao = new zac();
    private static final zai<Double> zap = new zad();
    private static final zai<Boolean> zaq = new zae();
    private static final zai<String> zar = new zaf();
    private static final zai<BigInteger> zas = new zag();
    private static final zai<BigDecimal> zat = new zah();
    private final char[] zaa = new char[1];
    private final char[] zab = new char[32];
    private final char[] zac = new char[1024];
    private final StringBuilder zad = new StringBuilder(32);
    private final StringBuilder zae = new StringBuilder(1024);
    private final Stack<Integer> zal = new Stack();

    /*
     * Unable to fully structure code
     */
    private static final String zaA(BufferedReader var0, char[] var1_1, StringBuilder var2_2, char[] var3_3) throws ParseException, IOException {
        var2_2.setLength(0);
        var0.mark(var1_1.length);
        var7_4 = false;
        var5_5 = false;
        block0: while (true) {
            if ((var9_9 = var0.read(var1_1)) == -1) {
                var0 = new ParseException("Unexpected EOF while parsing string");
                throw var0;
            }
            var6_7 = 0;
            while (true) {
                block11: {
                    block8: {
                        block10: {
                            block9: {
                                if (var6_7 >= var9_9) break block9;
                                var4_6 = var1_1[var6_7];
                                if (!Character.isISOControl(var4_6)) break block8;
                                break block10;
                            }
                            var2_2.append(var1_1, 0, var9_9);
                            var0.mark(var1_1.length);
                            continue block0;
                        }
                        if (var3_3 == null) throw new ParseException("Unexpected control character while reading string");
                        var8_8 = 0;
                        while (var8_8 < var3_3.length) {
                            if (var3_3[var8_8] != var4_6) {
                                ++var8_8;
                                continue;
                            }
                            break block8;
                        }
                        throw new ParseException("Unexpected control character while reading string");
                    }
                    if (var4_6 != '\"') break block11;
                    if (!var5_5) {
                        var2_2.append(var1_1, 0, var6_7);
                        var0.reset();
                        var0.skip(var6_7 + 1);
                        if (var7_4 == false) return var2_2.toString();
                        return JsonUtils.unescapeString((String)var2_2.toString());
                    }
                    ** GOTO lbl-1000
                }
                if (var4_6 == '\\') {
                    var5_5 ^= true;
                    var7_4 = true;
                } else lbl-1000:
                // 2 sources

                {
                    var5_5 = false;
                }
                ++var6_7;
            }
            break;
        }
    }

    static /* synthetic */ int zaa(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
        return fastParser.zao(bufferedReader);
    }

    static /* synthetic */ long zab(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
        return fastParser.zap(bufferedReader);
    }

    static /* synthetic */ float zac(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
        return fastParser.zas(bufferedReader);
    }

    static /* synthetic */ double zad(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
        return fastParser.zat(bufferedReader);
    }

    static /* synthetic */ boolean zae(FastParser fastParser, BufferedReader bufferedReader, boolean bl) throws ParseException, IOException {
        return fastParser.zar(bufferedReader, false);
    }

    static /* synthetic */ String zaf(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
        return fastParser.zal(bufferedReader);
    }

    static /* synthetic */ BigInteger zag(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
        return fastParser.zaq(bufferedReader);
    }

    static /* synthetic */ BigDecimal zah(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException {
        return fastParser.zau(bufferedReader);
    }

    /*
     * Unable to fully structure code
     */
    private final boolean zai(BufferedReader var1_1, FastJsonResponse var2_4) throws ParseException, IOException {
        var7_5 = var2_4.getFieldMappings();
        var5_6 = this.zaj((BufferedReader)var1_1);
        var6_7 = 1;
        if (var5_6 == null) {
            this.zaz(1);
            return false;
        }
        while (true) {
            if (var5_6 == null) {
                this.zaz(1);
                return true;
            }
            var8_10 = (FastJsonResponse.Field)var7_5.get(var5_6);
            if (var8_10 == null) {
                var5_6 = this.zak((BufferedReader)var1_1);
                continue;
            }
            this.zal.push(4);
            var4_9 = var8_10.zaa;
            switch (var4_9) {
                default: {
                    var1_1 = new StringBuilder(30);
                    var1_1.append("Invalid field type ");
                    var1_1.append(var4_9);
                    throw new ParseException(var1_1.toString());
                }
                case 11: {
                    if (var8_10.zab) {
                        var4_9 = this.zaw((BufferedReader)var1_1);
                        if (var4_9 == 110) {
                            this.zay((BufferedReader)var1_1, FastParser.zaf);
                            var2_4.addConcreteTypeArrayInternal(var8_10, var8_10.zae, null);
                            break;
                        }
                        this.zal.push(5);
                        if (var4_9 != 91) throw new ParseException("Expected array start");
                        var2_4.addConcreteTypeArrayInternal(var8_10, var8_10.zae, this.zav((BufferedReader)var1_1, var8_10));
                        break;
                    }
                    var4_9 = this.zaw((BufferedReader)var1_1);
                    if (var4_9 == 110) {
                        this.zay((BufferedReader)var1_1, FastParser.zaf);
                        var2_4.addConcreteTypeInternal(var8_10, var8_10.zae, null);
                        break;
                    }
                    this.zal.push(var6_7);
                    if (var4_9 != 123) throw new ParseException("Expected start of object");
                    try {
                        var5_6 = var8_10.zaf();
                        this.zai((BufferedReader)var1_1, (FastJsonResponse)var5_6);
                        var2_4.addConcreteTypeInternal(var8_10, var8_10.zae, (FastJsonResponse)var5_6);
                        break;
                    }
                    catch (IllegalAccessException var1_2) {
                        throw new ParseException("Error instantiating inner object", (Throwable)var1_2);
                    }
                    catch (InstantiationException var1_3) {
                        throw new ParseException("Error instantiating inner object", (Throwable)var1_3);
                    }
                }
                case 10: {
                    var4_9 = this.zaw((BufferedReader)var1_1);
                    if (var4_9 != 110) ** GOTO lbl62
                    this.zay((BufferedReader)var1_1, FastParser.zaf);
                    var5_6 = null;
                    ** GOTO lbl95
lbl62:
                    // 1 sources

                    if (var4_9 != 123) throw new ParseException("Expected start of a map object");
                    this.zal.push(var6_7);
                    var5_6 = new HashMap<K, V>();
                    while ((var4_9 = (int)this.zaw((BufferedReader)var1_1)) != 0) {
                        if (var4_9 == 34) ** GOTO lbl71
                        if (var4_9 != 125) continue;
                        this.zaz(1);
                        ** GOTO lbl95
lbl71:
                        // 1 sources

                        var9_11 = FastParser.zaA((BufferedReader)var1_1, this.zab, this.zad, null);
                        if (this.zaw((BufferedReader)var1_1) != ':') {
                            var1_1 = String.valueOf(var9_11);
                            var1_1 = var1_1.length() != 0 ? "No map value found for key ".concat((String)var1_1) : new String("No map value found for key ");
                            throw new ParseException((String)var1_1);
                        }
                        if (this.zaw((BufferedReader)var1_1) != '\"') {
                            var1_1 = String.valueOf(var9_11);
                            var1_1 = var1_1.length() != 0 ? "Expected String value for key ".concat((String)var1_1) : new String("Expected String value for key ");
                            throw new ParseException((String)var1_1);
                        }
                        var5_6.put(var9_11, FastParser.zaA((BufferedReader)var1_1, this.zab, this.zad, null));
                        var3_8 = this.zaw((BufferedReader)var1_1);
                        if (var3_8 == ',') {
                            continue;
                        }
                        ** GOTO lbl87
                    }
                    throw new ParseException("Unexpected EOF");
lbl87:
                    // 1 sources

                    if (var3_8 != '}') {
                        var1_1 = new StringBuilder(48);
                        var1_1.append("Unexpected character while parsing string map: ");
                        var1_1.append(var3_8);
                        throw new ParseException(var1_1.toString());
                    }
                    this.zaz(1);
lbl95:
                    // 3 sources

                    var2_4.zar(var8_10, (Map)var5_6);
                    break;
                }
                case 9: {
                    var2_4.zaq(var8_10, Base64Utils.decodeUrlSafe((String)this.zan((BufferedReader)var1_1, this.zac, this.zae, FastParser.zak)));
                    break;
                }
                case 8: {
                    var2_4.zaq(var8_10, Base64Utils.decode((String)this.zan((BufferedReader)var1_1, this.zac, this.zae, FastParser.zak)));
                    break;
                }
                case 7: {
                    if (var8_10.zab) {
                        var2_4.zap(var8_10, this.zam((BufferedReader)var1_1, FastParser.zar));
                        break;
                    }
                    var2_4.zao(var8_10, this.zal((BufferedReader)var1_1));
                    break;
                }
                case 6: {
                    if (var8_10.zab) {
                        var2_4.zan(var8_10, this.zam((BufferedReader)var1_1, FastParser.zaq));
                        break;
                    }
                    var2_4.zam(var8_10, this.zar((BufferedReader)var1_1, false));
                    break;
                }
                case 5: {
                    if (var8_10.zab) {
                        var2_4.zal(var8_10, this.zam((BufferedReader)var1_1, FastParser.zat));
                        break;
                    }
                    var2_4.zak(var8_10, this.zau((BufferedReader)var1_1));
                    break;
                }
                case 4: {
                    if (var8_10.zab) {
                        var2_4.zaj(var8_10, this.zam((BufferedReader)var1_1, FastParser.zap));
                        break;
                    }
                    var2_4.zai(var8_10, this.zat((BufferedReader)var1_1));
                    break;
                }
                case 3: {
                    if (var8_10.zab) {
                        var2_4.zah(var8_10, this.zam((BufferedReader)var1_1, FastParser.zao));
                        break;
                    }
                    var2_4.zag(var8_10, this.zas((BufferedReader)var1_1));
                    break;
                }
                case 2: {
                    if (var8_10.zab) {
                        var2_4.zaf(var8_10, this.zam((BufferedReader)var1_1, FastParser.zan));
                        break;
                    }
                    var2_4.zae(var8_10, this.zap((BufferedReader)var1_1));
                    break;
                }
                case 1: {
                    if (var8_10.zab) {
                        var2_4.zad(var8_10, this.zam((BufferedReader)var1_1, FastParser.zas));
                        break;
                    }
                    var2_4.zac(var8_10, this.zaq((BufferedReader)var1_1));
                    break;
                }
                case 0: {
                    if (var8_10.zab) {
                        var2_4.zab(var8_10, this.zam((BufferedReader)var1_1, FastParser.zam));
                        break;
                    }
                    var2_4.zaa(var8_10, this.zao((BufferedReader)var1_1));
                    break;
                }
            }
            this.zaz(4);
            this.zaz(2);
            var3_8 = this.zaw((BufferedReader)var1_1);
            if (var3_8 != ',') {
                if (var3_8 != '}') {
                    var1_1 = new StringBuilder(55);
                    var1_1.append("Expected end of object or field separator, but found: ");
                    var1_1.append(var3_8);
                    throw new ParseException(var1_1.toString());
                }
                var5_6 = null;
                continue;
            }
            var5_6 = this.zaj((BufferedReader)var1_1);
        }
    }

    private final String zaj(BufferedReader object) throws ParseException, IOException {
        this.zal.push(2);
        char c = this.zaw((BufferedReader)object);
        if (c == '\"') {
            this.zal.push(3);
            String string = FastParser.zaA((BufferedReader)object, this.zab, this.zad, null);
            this.zaz(3);
            if (this.zaw((BufferedReader)object) != ':') throw new ParseException("Expected key/value separator");
            return string;
        }
        if (c == ']') {
            this.zaz(2);
            this.zaz(1);
            this.zaz(5);
            return null;
        }
        if (c == '}') {
            this.zaz(2);
            return null;
        }
        object = new StringBuilder(19);
        ((StringBuilder)object).append("Unexpected token: ");
        ((StringBuilder)object).append(c);
        throw new ParseException(((StringBuilder)object).toString());
    }

    /*
     * Unable to fully structure code
     */
    private final String zak(BufferedReader var1_1) throws ParseException, IOException {
        block25: {
            var1_1.mark(1024);
            var3_2 = this.zaw((BufferedReader)var1_1);
            var6_3 = 1;
            if (var3_2 == 34) break block25;
            if (var3_2 == 44) throw new ParseException("Missing value");
            if (var3_2 != 91) {
                if (var3_2 != 123) {
                    var1_1.reset();
                    this.zax((BufferedReader)var1_1, this.zac);
                } else {
                    this.zal.push(1);
                    var1_1.mark(32);
                    var2_4 = this.zaw((BufferedReader)var1_1);
                    if (var2_4 == '}') {
                        this.zaz(1);
                    } else {
                        if (var2_4 != '\"') {
                            var1_1 = new StringBuilder(18);
                            var1_1.append("Unexpected token ");
                            var1_1.append(var2_4);
                            throw new ParseException(var1_1.toString());
                        }
                        var1_1.reset();
                        this.zaj((BufferedReader)var1_1);
                        while (this.zak((BufferedReader)var1_1) != null) {
                        }
                        this.zaz(1);
                    }
                }
            } else {
                this.zal.push(5);
                var1_1.mark(32);
                if (this.zaw((BufferedReader)var1_1) == ']') {
                    this.zaz(5);
                } else {
                    var1_1.reset();
                    var5_5 = 0;
                    block1: while (true) {
                        var7_9 = false;
                        var3_2 = var6_3;
                        while (var3_2 > 0) {
                            var2_4 = this.zaw((BufferedReader)var1_1);
                            if (var2_4 == '\u0000') throw new ParseException("Unexpected EOF while parsing array");
                            if (Character.isISOControl(var2_4) != false) throw new ParseException("Unexpected control character while reading array");
                            var4_7 = var5_5;
                            var6_3 = var2_4;
                            if (var2_4 == '\"') {
                                var4_7 = var5_5;
                                if (!var7_9) {
                                    var4_7 = var5_5 ^ 1;
                                }
                                var6_3 = 34;
                            }
                            var5_5 = var3_2;
                            var8_10 = var6_3;
                            if (var6_3 == 91) {
                                var5_5 = var3_2;
                                if (var4_7 == 0) {
                                    var5_5 = var3_2 + 1;
                                }
                                var8_10 = 91;
                            }
                            var3_2 = var5_5;
                            if (var8_10 == 93) {
                                var3_2 = var5_5;
                                if (var4_7 == 0) {
                                    var3_2 = var5_5 - 1;
                                }
                            }
                            var5_5 = var4_7;
                            var6_3 = var3_2;
                            if (var8_10 != 92) continue block1;
                            var5_5 = var4_7;
                            var6_3 = var3_2;
                            if (var4_7 != 0) ** break;
                            continue block1;
                            var7_9 ^= true;
                            var5_5 = var4_7;
                        }
                        break;
                    }
                    this.zaz(5);
                }
            }
            ** GOTO lbl-1000
        }
        if (var1_1.read(this.zaa) == -1) {
            var1_1 = new ParseException("Unexpected EOF while parsing string");
            throw var1_1;
        }
        var5_6 = this.zaa[0];
        var3_2 = 0;
        while (true) {
            block26: {
                var4_8 = var5_6;
                var6_3 = var3_2;
                if (var5_6 == 34) {
                    ** if (var3_2 == 0) goto lbl-1000
lbl-1000:
                    // 1 sources

                    {
                        var4_8 = 34;
                        var6_3 = 1;
                        ** GOTO lbl107
                    }
                }
                break block26;
lbl-1000:
                // 6 sources

                {
                    var2_4 = this.zaw((BufferedReader)var1_1);
                    if (var2_4 == ',') {
                        this.zaz(2);
                        return this.zaj((BufferedReader)var1_1);
                    }
                    if (var2_4 == '}') {
                        this.zaz(2);
                        return null;
                    }
                    var1_1 = new StringBuilder(18);
                    var1_1.append("Unexpected token ");
                    var1_1.append(var2_4);
                    throw new ParseException(var1_1.toString());
                }
            }
            var3_2 = var4_8 == 92 ? var6_3 ^ '\u0001' : 0;
            if (var1_1.read(this.zaa) == -1) throw new ParseException("Unexpected EOF while parsing string");
            var2_4 = this.zaa[0];
            if (Character.isISOControl(var2_4) != false) throw new ParseException("Unexpected control character while reading string");
            var5_6 = var2_4;
        }
    }

    private final String zal(BufferedReader bufferedReader) throws ParseException, IOException {
        return this.zan(bufferedReader, this.zab, this.zad, null);
    }

    private final <O> ArrayList<O> zam(BufferedReader bufferedReader, zai<O> zai2) throws ParseException, IOException {
        char c = this.zaw(bufferedReader);
        if (c == 'n') {
            this.zay(bufferedReader, zaf);
            return null;
        }
        if (c != '[') {
            bufferedReader = new ParseException("Expected start of array");
            throw bufferedReader;
        }
        this.zal.push(5);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        while (true) {
            bufferedReader.mark(1024);
            c = this.zaw(bufferedReader);
            if (c == '\u0000') throw new ParseException("Unexpected EOF");
            if (c == ',') continue;
            if (c == ']') {
                this.zaz(5);
                return arrayList;
            }
            bufferedReader.reset();
            arrayList.add(zai2.zaa(this, bufferedReader));
        }
    }

    private final String zan(BufferedReader bufferedReader, char[] cArray, StringBuilder stringBuilder, char[] cArray2) throws ParseException, IOException {
        char c = this.zaw(bufferedReader);
        if (c == '\"') return FastParser.zaA(bufferedReader, cArray, stringBuilder, cArray2);
        if (c != 'n') throw new ParseException("Expected string");
        this.zay(bufferedReader, zaf);
        return null;
    }

    private final int zao(BufferedReader object) throws ParseException, IOException {
        int n;
        int n2 = this.zax((BufferedReader)object, this.zac);
        if (n2 == 0) {
            return 0;
        }
        object = this.zac;
        if (n2 <= 0) {
            object = new ParseException("No number to parse");
            throw object;
        }
        Object object2 = object[0];
        int n3 = object2 == 45 ? Integer.MIN_VALUE : -2147483647;
        int n4 = object2 == 45 ? 1 : 0;
        if (n4 < n2) {
            n = n4 + 1;
            object2 = Character.digit((char)object[n4], 10);
            if (object2 < 0) throw new ParseException("Unexpected non-digit character");
            object2 = -object2;
        } else {
            n = n4;
            object2 = false;
        }
        while (n < n2) {
            int n5 = Character.digit((char)object[n], 10);
            if (n5 < 0) throw new ParseException("Unexpected non-digit character");
            if (object2 < -214748364) throw new ParseException("Number too large");
            if ((object2 *= 10) < n3 + n5) throw new ParseException("Number too large");
            object2 -= n5;
            ++n;
        }
        if (n4 != 0) {
            if (n <= 1) throw new ParseException("No digits to parse");
        } else {
            object2 = -object2;
        }
        return (int)object2;
    }

    private final long zap(BufferedReader object) throws ParseException, IOException {
        long l;
        int n;
        int n2 = this.zax((BufferedReader)object, this.zac);
        if (n2 == 0) {
            return 0L;
        }
        object = this.zac;
        if (n2 <= 0) {
            object = new ParseException("No number to parse");
            throw object;
        }
        int n3 = 0;
        Object object2 = object[0];
        long l2 = object2 == 45 ? Long.MIN_VALUE : -9223372036854775807L;
        if (object2 == 45) {
            n3 = 1;
        }
        if (n3 < n2) {
            object2 = n3 + 1;
            n = Character.digit((char)object[n3], 10);
            if (n < 0) throw new ParseException("Unexpected non-digit character");
            l = -n;
        } else {
            l = 0L;
            object2 = n3;
        }
        while (object2 < n2) {
            n = Character.digit((char)object[object2], 10);
            if (n < 0) throw new ParseException("Unexpected non-digit character");
            if (l < -922337203685477580L) throw new ParseException("Number too large");
            long l3 = l * 10L;
            if (l3 < l2 + (l = (long)n)) throw new ParseException("Number too large");
            l = l3 - l;
            ++object2;
        }
        if (n3 != 0) {
            if (object2 <= true) throw new ParseException("No digits to parse");
        } else {
            l = -l;
        }
        return l;
    }

    private final BigInteger zaq(BufferedReader bufferedReader) throws ParseException, IOException {
        int n = this.zax(bufferedReader, this.zac);
        if (n != 0) return new BigInteger(new String(this.zac, 0, n));
        return null;
    }

    private final boolean zar(BufferedReader object, boolean bl) throws ParseException, IOException {
        char c = this.zaw((BufferedReader)object);
        if (c == '\"') {
            if (bl) throw new ParseException("No boolean value found in string");
            return this.zar((BufferedReader)object, true);
        }
        if (c != 'f') {
            if (c == 'n') {
                this.zay((BufferedReader)object, zaf);
                return false;
            }
            if (c != 't') {
                object = new StringBuilder(19);
                ((StringBuilder)object).append("Unexpected token: ");
                ((StringBuilder)object).append(c);
                throw new ParseException(((StringBuilder)object).toString());
            }
            char[] cArray = bl ? zah : zag;
            this.zay((BufferedReader)object, cArray);
            return true;
        }
        char[] cArray = bl ? zaj : zai;
        this.zay((BufferedReader)object, cArray);
        return false;
    }

    private final float zas(BufferedReader bufferedReader) throws ParseException, IOException {
        int n = this.zax(bufferedReader, this.zac);
        if (n != 0) return Float.parseFloat(new String(this.zac, 0, n));
        return 0.0f;
    }

    private final double zat(BufferedReader bufferedReader) throws ParseException, IOException {
        int n = this.zax(bufferedReader, this.zac);
        if (n != 0) return Double.parseDouble(new String(this.zac, 0, n));
        return 0.0;
    }

    private final BigDecimal zau(BufferedReader bufferedReader) throws ParseException, IOException {
        int n = this.zax(bufferedReader, this.zac);
        if (n != 0) return new BigDecimal(new String(this.zac, 0, n));
        return null;
    }

    private final <T extends FastJsonResponse> ArrayList<T> zav(BufferedReader object, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<FastJsonResponse> arrayList = new ArrayList<FastJsonResponse>();
        char c = this.zaw((BufferedReader)object);
        if (c == ']') {
            this.zaz(5);
            return arrayList;
        }
        if (c == 'n') {
            this.zay((BufferedReader)object, zaf);
            this.zaz(5);
            return null;
        }
        if (c != '{') {
            object = new StringBuilder(19);
            ((StringBuilder)object).append("Unexpected token: ");
            ((StringBuilder)object).append(c);
            throw new ParseException(((StringBuilder)object).toString());
        }
        this.zal.push(1);
        while (true) {
            try {
                FastJsonResponse fastJsonResponse = field.zaf();
                if (!this.zai((BufferedReader)object, fastJsonResponse)) return arrayList;
                arrayList.add(fastJsonResponse);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new ParseException("Error instantiating inner object", (Throwable)illegalAccessException);
            }
            catch (InstantiationException instantiationException) {
                throw new ParseException("Error instantiating inner object", (Throwable)instantiationException);
            }
            c = this.zaw((BufferedReader)object);
            if (c != ',') {
                if (c == ']') {
                    this.zaz(5);
                    return arrayList;
                }
                object = new StringBuilder(19);
                ((StringBuilder)object).append("Unexpected token: ");
                ((StringBuilder)object).append(c);
                throw new ParseException(((StringBuilder)object).toString());
            }
            if (this.zaw((BufferedReader)object) != '{') throw new ParseException("Expected start of next object in array");
            this.zal.push(1);
        }
    }

    private final char zaw(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zaa) == -1) return '\u0000';
        do {
            if (!Character.isWhitespace(this.zaa[0])) return this.zaa[0];
        } while (bufferedReader.read(this.zaa) != -1);
        return '\u0000';
    }

    /*
     * Unable to fully structure code
     */
    private final int zax(BufferedReader var1_1, char[] var2_2) throws ParseException, IOException {
        block7: {
            block8: {
                var3_3 = this.zaw(var1_1);
                if (var3_3 == '\u0000') {
                    var1_1 = new ParseException("Unexpected EOF");
                    throw var1_1;
                }
                if (var3_3 == ',') throw new ParseException("Missing value");
                if (var3_3 == 'n') {
                    this.zay(var1_1, FastParser.zaf);
                    return 0;
                }
                var1_1.mark(1024);
                if (var3_3 != '\"') break block8;
                var4_4 = 0;
                var5_6 = false;
                while (true) {
                    block9: {
                        var6_7 = var4_4;
                        if (var4_4 >= var2_2.length) break block7;
                        var6_7 = var4_4;
                        if (var1_1.read(var2_2, var4_4, 1) == -1) break block7;
                        var3_3 = var2_2[var4_4];
                        if (Character.isISOControl(var3_3) != false) throw new ParseException("Unexpected control character while reading string");
                        if (var3_3 != '\"') break block9;
                        if (!var5_6) {
                            var1_1.reset();
                            var1_1.skip(var4_4 + 1);
                            return var4_4;
                        }
                        ** GOTO lbl-1000
                    }
                    if (var3_3 == '\\') {
                        var5_6 ^= true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var5_6 = false;
                    }
                    ++var4_4;
                }
            }
            var2_2[0] = var3_3;
            var4_5 = 1;
            while (true) {
                var6_7 = var4_5;
                if (var4_5 >= var2_2.length) break block7;
                var6_7 = var4_5;
                if (var1_1.read(var2_2, var4_5, 1) == -1) break block7;
                var3_3 = var2_2[var4_5];
                if (var3_3 == '}' || var3_3 == ',' || Character.isWhitespace(var3_3) || var2_2[var4_5] == ']') break;
                ++var4_5;
            }
            var1_1.reset();
            var1_1.skip(var4_5 - 1);
            var2_2[var4_5] = '\u0000';
            return var4_5;
        }
        if (var6_7 != var2_2.length) throw new ParseException("Unexpected EOF");
        throw new ParseException("Absurdly long value");
    }

    private final void zay(BufferedReader bufferedReader, char[] cArray) throws ParseException, IOException {
        int n;
        int n2 = 0;
        while (n2 < (n = cArray.length)) {
            int n3 = bufferedReader.read(this.zab, 0, n - n2);
            if (n3 == -1) throw new ParseException("Unexpected EOF");
            for (n = 0; n < n3; ++n) {
                if (cArray[n + n2] != this.zab[n]) throw new ParseException("Unexpected character");
            }
            n2 += n3;
        }
    }

    private final void zaz(int n) throws ParseException {
        if (this.zal.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder(46);
            stringBuilder.append("Expected state ");
            stringBuilder.append(n);
            stringBuilder.append(" but had empty stack");
            throw new ParseException(stringBuilder.toString());
        }
        int n2 = this.zal.pop();
        if (n2 == n) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Expected state ");
        stringBuilder.append(n);
        stringBuilder.append(" but had ");
        stringBuilder.append(n2);
        throw new ParseException(stringBuilder.toString());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public void parse(InputStream var1_1, T var2_4) throws ParseException {
        var1_1 = new BufferedReader(new InputStreamReader((InputStream)var1_1), 1024);
        try {
            block11: {
                block10: {
                    this.zal.push(0);
                    var3_6 = this.zaw((BufferedReader)var1_1);
                    if (var3_6 == '\u0000') ** GOTO lbl44
                    if (var3_6 == '[') break block10;
                    if (var3_6 != '{') {
                        var2_4 = new StringBuilder(19);
                        var2_4.append("Unexpected token: ");
                        var2_4.append(var3_6);
                        var4_7 = new ParseException(var2_4.toString());
                        throw var4_7;
                    }
                    this.zal.push(1);
                    this.zai((BufferedReader)var1_1, (FastJsonResponse)var2_4);
                    break block11;
                }
                this.zal.push(5);
                var4_8 = var2_4.getFieldMappings();
                if (var4_8.size() != 1) ** GOTO lbl-1000
                var5_10 = (FastJsonResponse.Field)var4_8.entrySet().iterator().next().getValue();
                var4_8 = this.zav((BufferedReader)var1_1, var5_10);
                var2_4.addConcreteTypeArrayInternal(var5_10, var5_10.zae, (ArrayList)var4_8);
            }
            this.zaz(0);
            ** GOTO lbl35
        }
        catch (IOException var4_9) {
            var2_4 = new ParseException((Throwable)var4_9);
            throw var2_4;
lbl35:
            // 1 sources

            try {
                var1_1.close();
                return;
            }
            catch (IOException var1_2) {
                Log.w((String)"FastParser", (String)"Failed to close reader while parsing.");
                return;
            }
lbl-1000:
            // 1 sources

            {
                var2_4 = new ParseException("Object array response class must have a single Field");
                throw var2_4;
lbl44:
                // 1 sources

                var2_4 = new ParseException("No data to parse");
                throw var2_4;
            }
            catch (Throwable var2_5) {}
        }
        try {
            var1_1.close();
        }
        catch (IOException var1_3) {
            Log.w((String)"FastParser", (String)"Failed to close reader while parsing.");
        }
        throw var2_5;
    }
}
