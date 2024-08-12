/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  okhttp3.FormBody$Builder
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.HttpUrl
 *  okhttp3.HttpUrl$Builder
 *  okhttp3.MediaType
 *  okhttp3.MultipartBody
 *  okhttp3.MultipartBody$Builder
 *  okhttp3.MultipartBody$Part
 *  okhttp3.Request$Builder
 *  okhttp3.RequestBody
 *  okio.Buffer
 *  retrofit2.RequestBuilder$ContentTypeOverridingRequestBody
 */
package retrofit2;

import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.RequestBuilder;

final class RequestBuilder {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final HttpUrl baseUrl;
    @Nullable
    private RequestBody body;
    @Nullable
    private MediaType contentType;
    @Nullable
    private FormBody.Builder formBuilder;
    private final boolean hasBody;
    private final Headers.Builder headersBuilder;
    private final String method;
    @Nullable
    private MultipartBody.Builder multipartBuilder;
    @Nullable
    private String relativeUrl;
    private final Request.Builder requestBuilder;
    @Nullable
    private HttpUrl.Builder urlBuilder;

    RequestBuilder(String string, HttpUrl httpUrl, @Nullable String string2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean bl, boolean bl2, boolean bl3) {
        this.method = string;
        this.baseUrl = httpUrl;
        this.relativeUrl = string2;
        this.requestBuilder = new Request.Builder();
        this.contentType = mediaType;
        this.hasBody = bl;
        this.headersBuilder = headers != null ? headers.newBuilder() : new Headers.Builder();
        if (bl2) {
            this.formBuilder = new FormBody.Builder();
        } else {
            if (!bl3) return;
            string = new MultipartBody.Builder();
            this.multipartBuilder = string;
            string.setType(MultipartBody.FORM);
        }
    }

    private static String canonicalizeForPath(String string, boolean bl) {
        String string2;
        int n = string.length();
        int n2 = 0;
        while (true) {
            string2 = string;
            if (n2 >= n) return string2;
            int n3 = string.codePointAt(n2);
            if (n3 < 32 || n3 >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(n3) != -1 || !bl && (n3 == 47 || n3 == 37)) break;
            n2 += Character.charCount(n3);
        }
        string2 = new Buffer();
        string2.writeUtf8(string, 0, n2);
        RequestBuilder.canonicalizeForPath((Buffer)string2, string, n2, n, bl);
        string2 = string2.readUtf8();
        return string2;
    }

    /*
     * Exception decompiling
     */
    private static void canonicalizeForPath(Buffer var0, String var1_1, int var2_2, int var3_3, boolean var4_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:461)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:251)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:673)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:56)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:722)
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

    void addFormField(String string, String string2, boolean bl) {
        if (bl) {
            this.formBuilder.addEncoded(string, string2);
        } else {
            this.formBuilder.add(string, string2);
        }
    }

    void addHeader(String string, String string2) {
        if ("Content-Type".equalsIgnoreCase(string)) {
            try {
                this.contentType = MediaType.get((String)string2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed content type: ");
                stringBuilder.append(string2);
                throw new IllegalArgumentException(stringBuilder.toString(), illegalArgumentException);
            }
        } else {
            this.headersBuilder.add(string, string2);
        }
    }

    void addHeaders(Headers headers) {
        this.headersBuilder.addAll(headers);
    }

    void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    void addPathParam(String charSequence, String string, boolean bl) {
        if (this.relativeUrl == null) throw new AssertionError();
        String string2 = RequestBuilder.canonicalizeForPath(string, bl);
        String string3 = this.relativeUrl;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append((String)charSequence);
        stringBuilder.append("}");
        charSequence = string3.replace(stringBuilder.toString(), string2);
        if (!PATH_TRAVERSAL.matcher(charSequence).matches()) {
            this.relativeUrl = charSequence;
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("@Path parameters shouldn't perform path traversal ('.' or '..'): ");
        ((StringBuilder)charSequence).append(string);
        throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
    }

    void addQueryParam(String charSequence, @Nullable String string, boolean bl) {
        String string2 = this.relativeUrl;
        if (string2 != null) {
            string2 = this.baseUrl.newBuilder(string2);
            this.urlBuilder = string2;
            if (string2 == null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Malformed URL. Base: ");
                ((StringBuilder)charSequence).append(this.baseUrl);
                ((StringBuilder)charSequence).append(", Relative: ");
                ((StringBuilder)charSequence).append(this.relativeUrl);
                throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
            }
            this.relativeUrl = null;
        }
        if (bl) {
            this.urlBuilder.addEncodedQueryParameter((String)charSequence, string);
        } else {
            this.urlBuilder.addQueryParameter((String)charSequence, string);
        }
    }

    <T> void addTag(Class<T> clazz, @Nullable T t) {
        this.requestBuilder.tag(clazz, t);
    }

    Request.Builder get() {
        HttpUrl httpUrl;
        Object object = this.urlBuilder;
        if (object != null) {
            httpUrl = object.build();
        } else {
            httpUrl = this.baseUrl.resolve(this.relativeUrl);
            if (httpUrl == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Malformed URL. Base: ");
                ((StringBuilder)object).append(this.baseUrl);
                ((StringBuilder)object).append(", Relative: ");
                ((StringBuilder)object).append(this.relativeUrl);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
        }
        Object object2 = this.body;
        object = object2;
        if (object2 == null) {
            object = this.formBuilder;
            if (object != null) {
                object = object.build();
            } else {
                object = this.multipartBuilder;
                if (object != null) {
                    object = object.build();
                } else {
                    object = object2;
                    if (this.hasBody) {
                        object = RequestBody.create(null, (byte[])new byte[0]);
                    }
                }
            }
        }
        MediaType mediaType = this.contentType;
        object2 = object;
        if (mediaType == null) return this.requestBuilder.url(httpUrl).headers(this.headersBuilder.build()).method(this.method, object2);
        if (object != null) {
            object2 = new ContentTypeOverridingRequestBody((RequestBody)object, mediaType);
        } else {
            this.headersBuilder.add("Content-Type", mediaType.toString());
            object2 = object;
        }
        return this.requestBuilder.url(httpUrl).headers(this.headersBuilder.build()).method(this.method, object2);
    }

    void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    void setRelativeUrl(Object object) {
        this.relativeUrl = object.toString();
    }
}
