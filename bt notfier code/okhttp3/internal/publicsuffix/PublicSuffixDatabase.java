/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 *  okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion
 *  okio.BufferedSource
 *  okio.GzipSource
 *  okio.Okio
 *  okio.Source
 */
package okhttp3.internal.publicsuffix;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class PublicSuffixDatabase {
    public static final Companion Companion = new Companion(null);
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL;
    private static final PublicSuffixDatabase instance;
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    static {
        WILDCARD_LABEL = new byte[]{(byte)42};
        PREVAILING_RULE = CollectionsKt.listOf((Object)"*");
        instance = new PublicSuffixDatabase();
    }

    public static final /* synthetic */ PublicSuffixDatabase access$getInstance$cp() {
        return instance;
    }

    private final List<String> findMatchingRule(List<String> object) {
        Object object2;
        Object object3;
        Object object4;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            this.readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        int n = this.publicSuffixListBytes != null ? 1 : 0;
        if (n == 0) {
            object = new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
            throw object;
        }
        int n2 = object.size();
        byte[][] byArrayArray = new byte[n2][];
        for (n = 0; n < n2; ++n) {
            object4 = (Object[])object.get(n);
            object3 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"UTF_8");
            if (object4 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            object3 = ((String)object4).getBytes((Charset)object3);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"(this as java.lang.String).getBytes(charset)");
            byArrayArray[n] = (byte[])object3;
        }
        Object[] objectArray = (Object[])byArrayArray;
        int n3 = objectArray.length - 1;
        Object var7_10 = null;
        if (n3 >= 0) {
            n = 0;
            while (true) {
                n2 = n + 1;
                object4 = Companion;
                object3 = this.publicSuffixListBytes;
                object = object3;
                if (object3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"publicSuffixListBytes");
                    object = null;
                }
                if ((object = okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion.access$binarySearch((Companion)object4, (byte[])object, (byte[][])byArrayArray, (int)n)) == null) {
                    if (n2 > n3) break;
                    n = n2;
                    continue;
                }
                break;
            }
        } else {
            object = null;
        }
        if (objectArray.length > 1 && (n3 = ((Object[])(object2 = (byte[][])byArrayArray.clone())).length - 1) > 0) {
            n = 0;
            while (true) {
                n2 = n + 1;
                object2[n] = WILDCARD_LABEL;
                Companion companion = Companion;
                object4 = this.publicSuffixListBytes;
                object3 = object4;
                if (object4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"publicSuffixListBytes");
                    object3 = null;
                }
                if ((object4 = okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion.access$binarySearch((Companion)companion, (byte[])object3, (byte[][])object2, (int)n)) == null) {
                    if (n2 >= n3) break;
                    n = n2;
                    continue;
                }
                break;
            }
        } else {
            object4 = null;
        }
        if (object4 != null && (n3 = objectArray.length - 1) > 0) {
            n = 0;
            while (true) {
                n2 = n + 1;
                object2 = Companion;
                object3 = objectArray = (Object[])this.publicSuffixExceptionListBytes;
                if (objectArray == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"publicSuffixExceptionListBytes");
                    object3 = null;
                }
                if ((object3 = okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion.access$binarySearch((Companion)object2, (byte[])object3, (byte[][])byArrayArray, (int)n)) == null) {
                    if (n2 >= n3) break;
                    n = n2;
                    continue;
                }
                break;
            }
        } else {
            object3 = null;
        }
        if (object3 != null) {
            return StringsKt.split$default((CharSequence)Intrinsics.stringPlus((String)"!", (Object)object3), (char[])new char[]{'.'}, (boolean)false, (int)0, (int)6, null);
        }
        if (object == null && object4 == null) {
            return PREVAILING_RULE;
        }
        object3 = object == null ? null : StringsKt.split$default((CharSequence)((CharSequence)object), (char[])new char[]{'.'}, (boolean)false, (int)0, (int)6, null);
        object = object3;
        if (object3 == null) {
            object = CollectionsKt.emptyList();
        }
        object3 = object4 == null ? var7_10 : StringsKt.split$default((CharSequence)((CharSequence)object4), (char[])new char[]{'.'}, (boolean)false, (int)0, (int)6, null);
        object4 = object3;
        if (object3 == null) {
            object4 = CollectionsKt.emptyList();
        }
        if (object.size() > object4.size()) return object;
        object = object4;
        return object;
    }

    private final void readTheList() throws IOException {
        byte[] byArray;
        byte[] byArray2;
        Closeable closeable = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (closeable == null) {
            return;
        }
        closeable = (Closeable)Okio.buffer((Source)((Source)new GzipSource(Okio.source((InputStream)closeable))));
        Throwable throwable = null;
        try {
            BufferedSource bufferedSource = (BufferedSource)closeable;
            byArray2 = bufferedSource.readByteArray((long)bufferedSource.readInt());
            byArray = bufferedSource.readByteArray((long)bufferedSource.readInt());
            bufferedSource = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            try {
                throw throwable2;
            }
            catch (Throwable throwable3) {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable2);
                throw throwable3;
            }
        }
        CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        synchronized (this) {
            Intrinsics.checkNotNull((Object)byArray2);
            this.publicSuffixListBytes = byArray2;
            Intrinsics.checkNotNull((Object)byArray);
            this.publicSuffixExceptionListBytes = byArray;
            closeable = Unit.INSTANCE;
            // MONITOREXIT @DISABLED, blocks:[1, 3] lbl26 : MonitorExitStatement: MONITOREXIT : this
            this.readCompleteLatch.countDown();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private final void readTheListUninterruptibly() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 22->39)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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

    private final List<String> splitDomain(String object) {
        if (!Intrinsics.areEqual((Object)CollectionsKt.last((List)(object = StringsKt.split$default((CharSequence)((CharSequence)object), (char[])new char[]{'.'}, (boolean)false, (int)0, (int)6, null))), (Object)"")) return object;
        return CollectionsKt.dropLast((List)object, (int)1);
    }

    public final String getEffectiveTldPlusOne(String string) {
        int n;
        int n2;
        Intrinsics.checkNotNullParameter((Object)string, (String)"domain");
        Object object = IDN.toUnicode(string);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"unicodeDomain");
        List<String> list = this.splitDomain((String)object);
        object = this.findMatchingRule(list);
        if (list.size() == object.size() && ((String)object.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String)object.get(0)).charAt(0) == '!') {
            n2 = list.size();
            n = object.size();
        } else {
            n2 = list.size();
            n = object.size() + 1;
        }
        return SequencesKt.joinToString$default((Sequence)SequencesKt.drop((Sequence)CollectionsKt.asSequence((Iterable)this.splitDomain(string)), (int)(n2 - n)), (CharSequence)".", null, null, (int)0, null, null, (int)62, null);
    }

    public final void setListBytes(byte[] byArray, byte[] byArray2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"publicSuffixListBytes");
        Intrinsics.checkNotNullParameter((Object)byArray2, (String)"publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = byArray;
        this.publicSuffixExceptionListBytes = byArray2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
