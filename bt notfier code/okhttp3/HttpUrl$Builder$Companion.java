/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.HttpUrl
 *  okhttp3.HttpUrl$Companion
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class HttpUrl.Builder.Companion {
    private HttpUrl.Builder.Companion() {
    }

    public /* synthetic */ HttpUrl.Builder.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ int access$parsePort(HttpUrl.Builder.Companion companion, String string, int n, int n2) {
        return companion.parsePort(string, n, n2);
    }

    public static final /* synthetic */ int access$portColonOffset(HttpUrl.Builder.Companion companion, String string, int n, int n2) {
        return companion.portColonOffset(string, n, n2);
    }

    public static final /* synthetic */ int access$schemeDelimiterOffset(HttpUrl.Builder.Companion companion, String string, int n, int n2) {
        return companion.schemeDelimiterOffset(string, n, n2);
    }

    public static final /* synthetic */ int access$slashCount(HttpUrl.Builder.Companion companion, String string, int n, int n2) {
        return companion.slashCount(string, n, n2);
    }

    /*
     * Enabled force condition propagation
     */
    private final int parsePort(String string, int n, int n2) {
        int n3 = -1;
        try {
            int n4 = Integer.parseInt(HttpUrl.Companion.canonicalize$okhttp$default((HttpUrl.Companion)HttpUrl.Companion, (String)string, (int)n, (int)n2, (String)"", (boolean)false, (boolean)false, (boolean)false, (boolean)false, null, (int)248, null));
            n = n2 = 0;
            if (1 <= n4) {
                n = n2;
                if (n4 <= 65535) {
                    n = 1;
                }
            }
            n2 = n3;
            if (n == 0) return n2;
            return n4;
        }
        catch (NumberFormatException numberFormatException) {
            return n3;
        }
    }

    /*
     * Exception decompiling
     */
    private final int portColonOffset(String var1_1, int var2_2, int var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 3[SIMPLE_IF_TAKEN]
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

    private final int schemeDelimiterOffset(String string, int n, int n2) {
        int n3;
        block7: {
            char c;
            int n4;
            int n5;
            block8: {
                n5 = -1;
                if (n2 - n < 2) {
                    return -1;
                }
                n4 = string.charAt(n);
                if (Intrinsics.compare((int)n4, (int)97) >= 0 && Intrinsics.compare((int)n4, (int)122) <= 0) break block8;
                n3 = n5;
                if (Intrinsics.compare((int)n4, (int)65) < 0) return n3;
                if (Intrinsics.compare((int)n4, (int)90) <= 0) break block8;
                n3 = n5;
                break block7;
            }
            n3 = n5;
            if (++n >= n2) return n3;
            while (true) {
                block10: {
                    block9: {
                        n4 = n + 1;
                        c = string.charAt(n);
                        int n6 = 0;
                        n3 = 'a' <= c && c <= 'z' ? 1 : 0;
                        n3 = n3 != 0 || 'A' <= c && c <= 'Z' ? 1 : 0;
                        n3 = n3 != 0 || '0' <= c && c <= '9' ? 1 : 0;
                        n3 = n3 != 0 || c == '+' ? 1 : 0;
                        if ((n3 = n3 != 0 || c == '-' ? 1 : 0) != 0) break block9;
                        n3 = n6;
                        if (c != '.') break block10;
                    }
                    n3 = 1;
                }
                if (n3 == 0) break;
                if (n4 >= n2) {
                    n3 = n5;
                    break block7;
                }
                n = n4;
            }
            n3 = n5;
            if (c != ':') return n3;
            n3 = n;
        }
        return n3;
    }

    private final int slashCount(String string, int n, int n2) {
        int n3 = 0;
        int n4 = 0;
        if (n >= n2) return n3;
        n3 = n;
        n = n4;
        while (true) {
            n4 = n3 + 1;
            char c = string.charAt(n3);
            if (c != '\\') {
                n3 = n;
                if (c != '/') return n3;
            }
            ++n;
            if (n4 >= n2) {
                n3 = n;
                return n3;
            }
            n3 = n4;
        }
    }
}
