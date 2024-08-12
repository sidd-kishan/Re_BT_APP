/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$LongRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 *  okio.BufferedSource
 *  okio.FileMetadata
 *  okio.FileSystem
 *  okio.Path
 *  okio.Path$Companion
 *  okio.ZipFileSystem
 *  okio.internal.EocdRecord
 *  okio.internal.ZipEntry
 *  okio.internal.ZipKt$openZip$1
 */
package okio.internal;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;
import okio.internal.EocdRecord;
import okio.internal.ZipEntry;
import okio.internal.ZipKt;

@Metadata(d1={"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u00064"}, d2={"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 0xFFFFFFFFL;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> zipEntry) {
        Map map = new LinkedHashMap();
        Iterator iterator = CollectionsKt.sortedWith((Iterable)((Iterable)zipEntry), (Comparator)((Comparator)new /* Unavailable Anonymous Inner Class!! */)).iterator();
        block0: while (iterator.hasNext()) {
            ZipEntry zipEntry2;
            zipEntry = zipEntry2 = (ZipEntry)iterator.next();
            if (map.put(zipEntry2.getCanonicalPath(), zipEntry2) != null) continue;
            while (true) {
                Path path;
                if ((path = zipEntry.getCanonicalPath().parent()) == null) continue block0;
                zipEntry2 = (ZipEntry)map.get(path);
                if (zipEntry2 != null) {
                    ((Collection)zipEntry2.getChildren()).add(zipEntry.getCanonicalPath());
                    continue block0;
                }
                zipEntry2 = new ZipEntry(path, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                map.put(path, zipEntry2);
                ((Collection)zipEntry2.getChildren()).add(zipEntry.getCanonicalPath());
                zipEntry = zipEntry2;
            }
            break;
        }
        return map;
    }

    private static final Long dosDateTimeToEpochMillis(int n, int n2) {
        if (n2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set((n >> 9 & 0x7F) + 1980, (n >> 5 & 0xF) - 1, n & 0x1F, n2 >> 11 & 0x1F, n2 >> 5 & 0x3F, (n2 & 0x1F) << 1);
        return gregorianCalendar.getTime().getTime();
    }

    private static final String getHex(int n) {
        String string = Integer.toString(n, CharsKt.checkRadix((int)16));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return Intrinsics.stringPlus((String)"0x", (Object)string);
    }

    /*
     * Exception decompiling
     */
    public static final ZipFileSystem openZip(Path var0, FileSystem var1_7, Function1<? super ZipEntry, Boolean> var2_13) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 8 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int n, Object object) throws IOException {
        if ((n & 4) == 0) return ZipKt.openZip(path, fileSystem, (Function1<? super ZipEntry, Boolean>)function1);
        function1 = (Function1)openZip.1.INSTANCE;
        return ZipKt.openZip(path, fileSystem, (Function1<? super ZipEntry, Boolean>)function1);
    }

    public static final ZipEntry readEntry(BufferedSource object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        int n = object.readIntLe();
        if (n != 33639248) {
            object = new StringBuilder();
            ((StringBuilder)object).append("bad zip: expected ");
            ((StringBuilder)object).append(ZipKt.getHex(33639248));
            ((StringBuilder)object).append(" but was ");
            ((StringBuilder)object).append(ZipKt.getHex(n));
            throw new IOException(((StringBuilder)object).toString());
        }
        object.skip(4L);
        n = object.readShortLe() & 0xFFFF;
        if ((n & 1) != 0) throw new IOException(Intrinsics.stringPlus((String)"unsupported zip: general purpose bit flag=", (Object)ZipKt.getHex(n)));
        n = object.readShortLe();
        short s = object.readShortLe();
        Long l = ZipKt.dosDateTimeToEpochMillis(object.readShortLe() & 0xFFFF, s & 0xFFFF);
        long l2 = object.readIntLe();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = (long)object.readIntLe() & 0xFFFFFFFFL;
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = (long)object.readIntLe() & 0xFFFFFFFFL;
        short s2 = object.readShortLe();
        s = object.readShortLe();
        short s3 = object.readShortLe();
        object.skip(8L);
        Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = (long)object.readIntLe() & 0xFFFFFFFFL;
        String string = object.readUtf8((long)(s2 & 0xFFFF));
        if (StringsKt.contains$default((CharSequence)string, (char)'\u0000', (boolean)false, (int)2, null)) throw new IOException("bad zip: filename contains 0x00");
        long l3 = longRef2.element == 0xFFFFFFFFL ? (long)8 + 0L : 0L;
        long l4 = l3;
        if (longRef.element == 0xFFFFFFFFL) {
            l4 = l3 + (long)8;
        }
        l3 = l4;
        if (longRef3.element == 0xFFFFFFFFL) {
            l3 = l4 + (long)8;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ZipKt.readExtra((BufferedSource)object, s & 0xFFFF, (Function2<? super Integer, ? super Long, Unit>)((Function2)new /* Unavailable Anonymous Inner Class!! */));
        if (l3 > 0L) {
            if (!booleanRef.element) throw new IOException("bad zip: zip64 extra required but absent");
        }
        object = object.readUtf8((long)(s3 & 0xFFFF));
        return new ZipEntry(Path.Companion.get$default((Path.Companion)Path.Companion, (String)"/", (boolean)false, (int)1, null).resolve(string), StringsKt.endsWith$default((String)string, (String)"/", (boolean)false, (int)2, null), (String)object, l2 & 0xFFFFFFFFL, longRef.element, longRef2.element, n & 0xFFFF, l, longRef3.element);
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short s = bufferedSource.readShortLe();
        short s2 = bufferedSource.readShortLe();
        long l = bufferedSource.readShortLe() & 0xFFFF;
        if (l != (long)(bufferedSource.readShortLe() & 0xFFFF)) throw new IOException("unsupported zip: spanned");
        if ((s & 0xFFFF) != 0) throw new IOException("unsupported zip: spanned");
        if ((s2 & 0xFFFF) != 0) throw new IOException("unsupported zip: spanned");
        bufferedSource.skip(4L);
        return new EocdRecord(l, 0xFFFFFFFFL & (long)bufferedSource.readIntLe(), bufferedSource.readShortLe() & 0xFFFF);
    }

    private static final void readExtra(BufferedSource bufferedSource, int n, Function2<? super Integer, ? super Long, Unit> function2) {
        long l = n;
        while (l != 0L) {
            if (l < 4L) throw new IOException("bad zip: truncated header in extra field");
            n = bufferedSource.readShortLe() & 0xFFFF;
            long l2 = (long)bufferedSource.readShortLe() & 0xFFFFL;
            if ((l -= (long)4) < l2) throw new IOException("bad zip: truncated value in extra field");
            bufferedSource.require(l2);
            long l3 = bufferedSource.getBuffer().size();
            function2.invoke((Object)n, (Object)l2);
            l3 = bufferedSource.getBuffer().size() + l2 - l3;
            if (l3 < 0L) throw new IOException(Intrinsics.stringPlus((String)"unsupported zip: too many bytes processed for ", (Object)n));
            if (l3 > 0L) {
                bufferedSource.getBuffer().skip(l3);
            }
            l -= l2;
        }
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)fileMetadata, (String)"basicMetadata");
        bufferedSource = ZipKt.readOrSkipLocalHeader(bufferedSource, fileMetadata);
        Intrinsics.checkNotNull((Object)bufferedSource);
        return bufferedSource;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource object, FileMetadata fileMetadata) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Long l = fileMetadata == null ? null : fileMetadata.getLastModifiedAtMillis();
        objectRef.element = l;
        l = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        int n = object.readIntLe();
        if (n != 67324752) {
            object = new StringBuilder();
            ((StringBuilder)object).append("bad zip: expected ");
            ((StringBuilder)object).append(ZipKt.getHex(67324752));
            ((StringBuilder)object).append(" but was ");
            ((StringBuilder)object).append(ZipKt.getHex(n));
            throw new IOException(((StringBuilder)object).toString());
        }
        object.skip(2L);
        n = object.readShortLe() & 0xFFFF;
        if ((n & 1) != 0) throw new IOException(Intrinsics.stringPlus((String)"unsupported zip: general purpose bit flag=", (Object)ZipKt.getHex(n)));
        object.skip(18L);
        long l2 = object.readShortLe();
        n = object.readShortLe() & 0xFFFF;
        object.skip(l2 & 0xFFFFL);
        if (fileMetadata == null) {
            object.skip((long)n);
            return null;
        }
        ZipKt.readExtra((BufferedSource)object, n, (Function2<? super Integer, ? super Long, Unit>)((Function2)new /* Unavailable Anonymous Inner Class!! */));
        return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), null, fileMetadata.getSize(), (Long)objectRef2.element, (Long)objectRef.element, (Long)((Ref.ObjectRef)l).element, null, 128, null);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int n = bufferedSource.readIntLe();
        int n2 = bufferedSource.readIntLe();
        long l = bufferedSource.readLongLe();
        if (l != bufferedSource.readLongLe()) throw new IOException("unsupported zip: spanned");
        if (n != 0) throw new IOException("unsupported zip: spanned");
        if (n2 != 0) throw new IOException("unsupported zip: spanned");
        bufferedSource.skip(8L);
        return new EocdRecord(l, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"<this>");
        ZipKt.readOrSkipLocalHeader(bufferedSource, null);
    }
}
