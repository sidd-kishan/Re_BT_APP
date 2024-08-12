/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Challenge
 *  okhttp3.Cookie
 *  okhttp3.CookieJar
 *  okhttp3.Headers
 *  okhttp3.HttpUrl
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okhttp3.internal.platform.Platform
 *  okio.Buffer
 *  okio.ByteString
 */
package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\u0006\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0002\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n\u001a\f\u0010\u001a\u001a\u00020\u0004*\u00020\u0010H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "hasBody", "", "response", "Lokhttp3/Response;", "parseChallenges", "", "Lokhttp3/Challenge;", "Lokhttp3/Headers;", "headerName", "", "promisesBody", "readChallengeHeader", "", "Lokio/Buffer;", "result", "", "readQuotedString", "readToken", "receiveHeaders", "Lokhttp3/CookieJar;", "url", "Lokhttp3/HttpUrl;", "headers", "skipCommasAndWhitespace", "startsWith", "prefix", "", "okhttp"}, k=2, mv={1, 5, 1}, xi=48)
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.Companion.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.Companion.encodeUtf8("\t ,=");

    @Deprecated(level=DeprecationLevel.ERROR, message="No longer supported", replaceWith=@ReplaceWith(expression="response.promisesBody()", imports={}))
    public static final boolean hasBody(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        return HttpHeaders.promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String string) {
        Intrinsics.checkNotNullParameter((Object)headers, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"headerName");
        List list = new ArrayList();
        int n = headers.size();
        if (n <= 0) return list;
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            if (StringsKt.equals((String)string, (String)headers.name(n2), (boolean)true)) {
                Buffer buffer = new Buffer().writeUtf8(headers.value(n2));
                try {
                    HttpHeaders.readChallengeHeader(buffer, list);
                }
                catch (EOFException eOFException) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, (Throwable)eOFException);
                }
            }
            if (n3 >= n) {
                return list;
            }
            n2 = n3;
        }
    }

    public static final boolean promisesBody(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"<this>");
        if (Intrinsics.areEqual((Object)response.request().method(), (Object)"HEAD")) {
            return false;
        }
        int n = response.code();
        if ((n < 100 || n >= 200) && n != 204 && n != 304) {
            return true;
        }
        if (Util.headersContentLength((Response)response) != -1L) return true;
        if (!StringsKt.equals((String)"chunked", (String)Response.header$default((Response)response, (String)"Transfer-Encoding", null, (int)2, null), (boolean)true)) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    private static final void readChallengeHeader(Buffer var0, List<Challenge> var1_1) throws EOFException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[UNCONDITIONALDOLOOP]], but top level block is 2[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static final String readQuotedString(Buffer object) throws EOFException {
        byte by;
        byte by2 = object.readByte();
        by2 = by2 == (by = (byte)34) ? (byte)1 : 0;
        if (by2 == 0) {
            object = new IllegalArgumentException("Failed requirement.".toString());
            throw object;
        }
        Buffer buffer = new Buffer();
        long l;
        while ((l = object.indexOfElement(QUOTED_STRING_DELIMITERS)) != -1L) {
            if (object.getByte(l) == by) {
                buffer.write(object, l);
                object.readByte();
                return buffer.readUtf8();
            }
            if (object.size() == l + 1L) {
                return null;
            }
            buffer.write(object, l);
            object.readByte();
            buffer.write(object, 1L);
        }
        return null;
    }

    private static final String readToken(Buffer object) {
        long l;
        long l2 = l = object.indexOfElement(TOKEN_DELIMITERS);
        if (l == -1L) {
            l2 = object.size();
        }
        object = l2 != 0L ? object.readUtf8(l2) : null;
        return object;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers object) {
        Intrinsics.checkNotNullParameter((Object)cookieJar, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        Intrinsics.checkNotNullParameter((Object)object, (String)"headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        if ((object = Cookie.Companion.parseAll(httpUrl, (Headers)object)).isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, (List)object);
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) {
        boolean bl = false;
        while (!buffer.exhausted()) {
            byte by = buffer.getByte(0L);
            if (by == (byte)44) {
                buffer.readByte();
                bl = true;
                continue;
            }
            by = by == (byte)32 || by == (byte)9 ? (byte)1 : 0;
            if (by == 0) return bl;
            buffer.readByte();
        }
        return bl;
    }

    private static final boolean startsWith(Buffer buffer, byte by) {
        boolean bl = !buffer.exhausted() && buffer.getByte(0L) == by;
        return bl;
    }
}
