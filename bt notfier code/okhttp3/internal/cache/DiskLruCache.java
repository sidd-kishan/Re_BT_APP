/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.DiskLruCache$Companion
 *  okhttp3.internal.cache.DiskLruCache$Editor
 *  okhttp3.internal.cache.DiskLruCache$Entry
 *  okhttp3.internal.cache.DiskLruCache$Snapshot
 *  okhttp3.internal.cache.DiskLruCache$cleanupTask$1
 *  okhttp3.internal.cache.FaultHidingSink
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.concurrent.TaskQueue
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.platform.Platform
 *  okio.BufferedSink
 *  okio.FileSystem
 *  okio.Okio
 *  okio.Path
 *  okio.Sink
 */
package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.FaultHidingSink;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;

@Metadata(d1={"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010)\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0004\\]^_B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020:H\u0016J!\u0010<\u001a\u00020:2\n\u0010=\u001a\u00060>R\u00020\u00002\u0006\u0010?\u001a\u00020\u0010H\u0000\u00a2\u0006\u0002\b@J\u0006\u0010A\u001a\u00020:J \u0010B\u001a\b\u0018\u00010>R\u00020\u00002\u0006\u0010C\u001a\u00020(2\b\b\u0002\u0010D\u001a\u00020\u000bH\u0007J\u0006\u0010E\u001a\u00020:J\b\u0010F\u001a\u00020:H\u0016J\u0017\u0010G\u001a\b\u0018\u00010HR\u00020\u00002\u0006\u0010C\u001a\u00020(H\u0086\u0002J\u0006\u0010I\u001a\u00020:J\u0006\u0010J\u001a\u00020\u0010J\b\u0010K\u001a\u00020\u0010H\u0002J\b\u0010L\u001a\u00020%H\u0002J\b\u0010M\u001a\u00020:H\u0002J\b\u0010N\u001a\u00020:H\u0002J\u0010\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020(H\u0002J\r\u0010Q\u001a\u00020:H\u0000\u00a2\u0006\u0002\bRJ\u000e\u0010S\u001a\u00020\u00102\u0006\u0010C\u001a\u00020(J\u0019\u0010T\u001a\u00020\u00102\n\u0010U\u001a\u00060)R\u00020\u0000H\u0000\u00a2\u0006\u0002\bVJ\b\u0010W\u001a\u00020\u0010H\u0002J\u0006\u00106\u001a\u00020\u000bJ\u0010\u0010X\u001a\f\u0012\b\u0012\u00060HR\u00020\u00000YJ\u0006\u0010Z\u001a\u00020:J\u0010\u0010[\u001a\u00020:2\u0006\u0010C\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0010X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R8\u0010&\u001a&\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060)R\u00020\u00000'j\u0012\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060)R\u00020\u0000`*X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R&\u0010\n\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108\u00a8\u0006`"}, d2={"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokio/FileSystem;", "directory", "Lokio/Path;", "appVersion", "", "valueCount", "maxSize", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokio/FileSystem;Lokio/Path;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "civilizedFileSystem", "", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getDirectory", "()Lokio/Path;", "getFileSystem$okhttp", "()Lokio/FileSystem;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lkotlin/collections/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "mostRecentTrimFailed", "nextSequenceNumber", "redundantOpCount", "size", "getValueCount$okhttp", "()I", "checkNotClosed", "", "close", "completeEdit", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "success", "completeEdit$okhttp", "delete", "edit", "key", "expectedSequenceNumber", "evictAll", "flush", "get", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "initialize", "isClosed", "journalRebuildRequired", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "rebuildJournal", "rebuildJournal$okhttp", "remove", "removeEntry", "entry", "removeEntry$okhttp", "removeOldestEntry", "snapshots", "", "trimToSize", "validateKey", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class DiskLruCache
implements Closeable,
Flushable {
    public static final long ANY_SEQUENCE_NUMBER;
    public static final String CLEAN;
    public static final Companion Companion;
    public static final String DIRTY;
    public static final String JOURNAL_FILE;
    public static final String JOURNAL_FILE_BACKUP;
    public static final String JOURNAL_FILE_TEMP;
    public static final Regex LEGAL_KEY_PATTERN;
    public static final String MAGIC;
    public static final String READ;
    public static final String REMOVE;
    public static final String VERSION_1;
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final cleanupTask.1 cleanupTask;
    private boolean closed;
    private final Path directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    static {
        Companion = new Companion(null);
        JOURNAL_FILE = "journal";
        JOURNAL_FILE_TEMP = "journal.tmp";
        JOURNAL_FILE_BACKUP = "journal.bkp";
        MAGIC = "libcore.io.DiskLruCache";
        VERSION_1 = "1";
        ANY_SEQUENCE_NUMBER = -1L;
        LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
        CLEAN = "CLEAN";
        DIRTY = "DIRTY";
        REMOVE = "REMOVE";
        READ = "READ";
    }

    public DiskLruCache(FileSystem fileSystem2, Path path, int n, int n2, long l, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter((Object)fileSystem2, (String)"fileSystem");
        Intrinsics.checkNotNullParameter((Object)path, (String)"directory");
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
        this.directory = path;
        this.appVersion = n;
        this.valueCount = n2;
        this.fileSystem = (FileSystem)new /* Unavailable Anonymous Inner Class!! */;
        this.maxSize = l;
        n2 = 1;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new /* Unavailable Anonymous Inner Class!! */;
        n = l > 0L ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException("maxSize <= 0".toString());
        n = this.valueCount > 0 ? n2 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException("valueCount <= 0".toString());
        this.journalFile = this.directory.resolve(JOURNAL_FILE);
        this.journalFileTmp = this.directory.resolve(JOURNAL_FILE_TEMP);
        this.journalFileBackup = this.directory.resolve(JOURNAL_FILE_BACKUP);
    }

    public static final /* synthetic */ boolean access$getCivilizedFileSystem$p(DiskLruCache diskLruCache) {
        return diskLruCache.civilizedFileSystem;
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache diskLruCache) {
        return diskLruCache.initialized;
    }

    public static final /* synthetic */ boolean access$journalRebuildRequired(DiskLruCache diskLruCache) {
        return diskLruCache.journalRebuildRequired();
    }

    public static final /* synthetic */ void access$setHasJournalErrors$p(DiskLruCache diskLruCache, boolean bl) {
        diskLruCache.hasJournalErrors = bl;
    }

    public static final /* synthetic */ void access$setJournalWriter$p(DiskLruCache diskLruCache, BufferedSink bufferedSink) {
        diskLruCache.journalWriter = bufferedSink;
    }

    public static final /* synthetic */ void access$setMostRecentRebuildFailed$p(DiskLruCache diskLruCache, boolean bl) {
        diskLruCache.mostRecentRebuildFailed = bl;
    }

    public static final /* synthetic */ void access$setMostRecentTrimFailed$p(DiskLruCache diskLruCache, boolean bl) {
        diskLruCache.mostRecentTrimFailed = bl;
    }

    public static final /* synthetic */ void access$setRedundantOpCount$p(DiskLruCache diskLruCache, int n) {
        diskLruCache.redundantOpCount = n;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void checkNotClosed() {
        synchronized (this) {
            boolean bl = this.closed;
            if (bl ^ true) {
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("cache is closed".toString());
            throw (Throwable)illegalStateException;
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String string, long l, int n, Object object) throws IOException {
        if ((n & 2) == 0) return diskLruCache.edit(string, l);
        l = ANY_SEQUENCE_NUMBER;
        return diskLruCache.edit(string, l);
    }

    private final boolean journalRebuildRequired() {
        int n = this.redundantOpCount;
        boolean bl = n >= 2000 && n >= this.lruEntries.size();
        return bl;
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer((Sink)((Sink)new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), (Function1)new /* Unavailable Anonymous Inner Class!! */)));
    }

    private final void processJournal() throws IOException {
        Util.deleteIfExists((FileSystem)this.fileSystem, (Path)this.journalFileTmp);
        Iterator<Entry> iterator = this.lruEntries.values().iterator();
        block0: while (iterator.hasNext()) {
            block5: {
                int n;
                int n2;
                int n3;
                Entry entry;
                block6: {
                    block4: {
                        block3: {
                            entry = iterator.next();
                            Intrinsics.checkNotNullExpressionValue((Object)entry, (String)"i.next()");
                            Editor editor = entry.getCurrentEditor$okhttp();
                            n3 = 0;
                            n2 = 0;
                            if (editor != null) break block3;
                            n = this.valueCount;
                            if (n <= 0) continue;
                            break block4;
                        }
                        entry.setCurrentEditor$okhttp(null);
                        n = this.valueCount;
                        if (n <= 0) break block5;
                        break block6;
                    }
                    while (true) {
                        n3 = n2 + 1;
                        this.size += entry.getLengths$okhttp()[n2];
                        if (n3 >= n) continue block0;
                        n2 = n3;
                    }
                }
                n2 = n3;
                while (true) {
                    n3 = n2 + 1;
                    Util.deleteIfExists((FileSystem)this.fileSystem, (Path)((Path)entry.getCleanFiles$okhttp().get(n2)));
                    Util.deleteIfExists((FileSystem)this.fileSystem, (Path)((Path)entry.getDirtyFiles$okhttp().get(n2)));
                    if (n3 >= n) break;
                    n2 = n3;
                }
            }
            iterator.remove();
        }
    }

    /*
     * Exception decompiling
     */
    private final void readJournal() throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[CATCHBLOCK]
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

    private final void readJournalLine(String object) throws IOException {
        String string;
        CharSequence charSequence = (CharSequence)object;
        int n = StringsKt.indexOf$default((CharSequence)charSequence, (char)' ', (int)0, (boolean)false, (int)6, null);
        if (n == -1) throw new IOException(Intrinsics.stringPlus((String)"unexpected journal line: ", (Object)object));
        int n2 = n + 1;
        int n3 = StringsKt.indexOf$default((CharSequence)charSequence, (char)' ', (int)n2, (boolean)false, (int)4, null);
        if (n3 == -1) {
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            string = ((String)object).substring(n2);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
            charSequence = string;
            if (n == REMOVE.length()) {
                charSequence = string;
                if (StringsKt.startsWith$default((String)object, (String)REMOVE, (boolean)false, (int)2, null)) {
                    this.lruEntries.remove(string);
                    return;
                }
            }
        } else {
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            charSequence = ((String)object).substring(n2, n3);
            Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        }
        Entry entry = this.lruEntries.get(charSequence);
        string = entry;
        if (entry == null) {
            string = new Entry(this, (String)charSequence);
            ((Map)this.lruEntries).put(charSequence, string);
        }
        if (n3 != -1 && n == CLEAN.length() && StringsKt.startsWith$default((String)object, (String)CLEAN, (boolean)false, (int)2, null)) {
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            object = ((String)object).substring(n3 + 1);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).substring(startIndex)");
            object = StringsKt.split$default((CharSequence)((CharSequence)object), (char[])new char[]{' '}, (boolean)false, (int)0, (int)6, null);
            string.setReadable$okhttp(true);
            string.setCurrentEditor$okhttp(null);
            string.setLengths$okhttp((List)object);
        } else if (n3 == -1 && n == DIRTY.length() && StringsKt.startsWith$default((String)object, (String)DIRTY, (boolean)false, (int)2, null)) {
            string.setCurrentEditor$okhttp(new Editor(this, (Entry)string));
        } else {
            if (n3 != -1) throw new IOException(Intrinsics.stringPlus((String)"unexpected journal line: ", (Object)object));
            if (n != READ.length()) throw new IOException(Intrinsics.stringPlus((String)"unexpected journal line: ", (Object)object));
            if (!StringsKt.startsWith$default((String)object, (String)READ, (boolean)false, (int)2, null)) throw new IOException(Intrinsics.stringPlus((String)"unexpected journal line: ", (Object)object));
        }
    }

    private final boolean removeOldestEntry() {
        Entry entry;
        Iterator<Entry> iterator = this.lruEntries.values().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while ((entry = iterator.next()).getZombie$okhttp());
        Intrinsics.checkNotNullExpressionValue((Object)entry, (String)"toEvict");
        this.removeEntry$okhttp(entry);
        return true;
    }

    private final void validateKey(String string) {
        if (LEGAL_KEY_PATTERN.matches((CharSequence)string)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
        stringBuilder.append(string);
        stringBuilder.append('\"');
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void close() throws IOException {
        synchronized (this) {
            int n;
            int n2;
            BufferedSink bufferedSink;
            block9: {
                if (this.initialized && !this.closed) {
                    bufferedSink = this.lruEntries.values();
                    Intrinsics.checkNotNullExpressionValue(bufferedSink, (String)"lruEntries.values");
                    n2 = 0;
                    bufferedSink = bufferedSink.toArray(new Entry[0]);
                    if (bufferedSink != null) {
                        n = ((Entry[])bufferedSink).length;
                        break block9;
                    } else {
                        bufferedSink = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        throw bufferedSink;
                    }
                }
                this.closed = true;
                return;
            }
            while (n2 < n) {
                int n3;
                Entry entry = bufferedSink[n2];
                n2 = n3 = n2 + 1;
                if (entry.getCurrentEditor$okhttp() == null) continue;
                if ((entry = entry.getCurrentEditor$okhttp()) == null) {
                    n2 = n3;
                    continue;
                }
                entry.detach$okhttp();
                n2 = n3;
            }
            this.trimToSize();
            bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull((Object)bufferedSink);
            bufferedSink.close();
            this.journalWriter = null;
            this.closed = true;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void completeEdit$okhttp(Editor object, boolean bl) throws IOException {
        synchronized (this) {
            long l;
            int n;
            int n2;
            int n3;
            Entry entry;
            block17: {
                int n4;
                block19: {
                    block18: {
                        Intrinsics.checkNotNullParameter((Object)object, (String)"editor");
                        entry = object.getEntry$okhttp();
                        if (!Intrinsics.areEqual((Object)entry.getCurrentEditor$okhttp(), (Object)object)) break block18;
                        n3 = 0;
                        if (!bl || entry.getReadable$okhttp() || (n4 = this.valueCount) <= 0) break block17;
                        break block19;
                    }
                    object = new IllegalStateException("Check failed.".toString());
                    throw (Throwable)object;
                }
                n2 = 0;
                while (true) {
                    n = n2 + 1;
                    boolean[] blArray = object.getWritten$okhttp();
                    Intrinsics.checkNotNull((Object)blArray);
                    if (!blArray[n2]) break;
                    if (!this.fileSystem.exists((Path)entry.getDirtyFiles$okhttp().get(n2))) {
                        object.abort();
                        return;
                    }
                    if (n < n4) {
                        n2 = n;
                        continue;
                    }
                    break block17;
                    break;
                }
                object.abort();
                object = new IllegalStateException(Intrinsics.stringPlus((String)"Newly created entry didn't create value for index ", (Object)n2));
                throw object;
            }
            if ((n = this.valueCount) > 0) {
                n2 = n3;
                while (true) {
                    n3 = n2 + 1;
                    object = (Path)entry.getDirtyFiles$okhttp().get(n2);
                    if (bl && !entry.getZombie$okhttp()) {
                        if (this.fileSystem.exists((Path)object)) {
                            Path path = (Path)entry.getCleanFiles$okhttp().get(n2);
                            this.fileSystem.atomicMove((Path)object, path);
                            long l2 = entry.getLengths$okhttp()[n2];
                            object = this.fileSystem.metadata(path).getSize();
                            l = object == null ? 0L : (Long)object;
                            entry.getLengths$okhttp()[n2] = l;
                            this.size = this.size - l2 + l;
                        }
                    } else {
                        Util.deleteIfExists((FileSystem)this.fileSystem, (Path)object);
                    }
                    if (n3 >= n) break;
                    n2 = n3;
                }
            }
            entry.setCurrentEditor$okhttp(null);
            if (entry.getZombie$okhttp()) {
                this.removeEntry$okhttp(entry);
                return;
            }
            ++this.redundantOpCount;
            object = this.journalWriter;
            Intrinsics.checkNotNull((Object)object);
            if (!entry.getReadable$okhttp() && !bl) {
                this.getLruEntries$okhttp().remove(entry.getKey$okhttp());
                object.writeUtf8(REMOVE).writeByte(32);
                object.writeUtf8(entry.getKey$okhttp());
                object.writeByte(10);
            } else {
                entry.setReadable$okhttp(true);
                object.writeUtf8(CLEAN).writeByte(32);
                object.writeUtf8(entry.getKey$okhttp());
                entry.writeLengths$okhttp((BufferedSink)object);
                object.writeByte(10);
                if (bl) {
                    l = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1L + l;
                    entry.setSequenceNumber$okhttp(l);
                }
            }
            object.flush();
            if (this.size <= this.maxSize) {
                if (!this.journalRebuildRequired()) return;
            }
            TaskQueue.schedule$default((TaskQueue)this.cleanupQueue, (Task)((Task)this.cleanupTask), (long)0L, (int)2, null);
            return;
        }
    }

    public final void delete() throws IOException {
        this.close();
        Util.deleteContents((FileSystem)this.fileSystem, (Path)this.directory);
    }

    public final Editor edit(String string) throws IOException {
        Intrinsics.checkNotNullParameter((Object)string, (String)"key");
        return DiskLruCache.edit$default(this, string, 0L, 2, null);
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final Editor edit(String string, long l) throws IOException {
        synchronized (this) {
            int n;
            Editor editor;
            void var2_2;
            Intrinsics.checkNotNullParameter((Object)string, (String)"key");
            this.initialize();
            this.checkNotClosed();
            this.validateKey(string);
            Entry entry = this.lruEntries.get(string);
            if (var2_2 != ANY_SEQUENCE_NUMBER) {
                if (entry == null) return null;
                long l2 = entry.getSequenceNumber$okhttp();
                if (l2 != var2_2) {
                    return null;
                }
            }
            if ((editor = entry == null ? null : entry.getCurrentEditor$okhttp()) != null) {
                return null;
            }
            if (entry != null && (n = entry.getLockingSourceCount$okhttp()) != 0) {
                return null;
            }
            if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                editor = this.journalWriter;
                Intrinsics.checkNotNull((Object)editor);
                editor.writeUtf8(DIRTY).writeByte(32).writeUtf8(string).writeByte(10);
                editor.flush();
                boolean bl = this.hasJournalErrors;
                if (bl) {
                    return null;
                }
                editor = entry;
                if (entry == null) {
                    editor = new Entry(this, string);
                    ((Map)this.lruEntries).put(string, editor);
                }
                string = new Editor(this, (Entry)editor);
                editor.setCurrentEditor$okhttp((Editor)string);
                return string;
            }
            TaskQueue.schedule$default((TaskQueue)this.cleanupQueue, (Task)((Task)this.cleanupTask), (long)0L, (int)2, null);
            return null;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void evictAll() throws IOException {
        synchronized (this) {
            int n;
            this.initialize();
            Object object = this.lruEntries.values();
            Intrinsics.checkNotNullExpressionValue(object, (String)"lruEntries.values");
            object = object.toArray(new Entry[0]);
            if (object != null) {
                n = ((Entry[])object).length;
            } else {
                object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                throw object;
            }
            for (int i = 0; i < n; ++i) {
                Entry entry = object[i];
                Intrinsics.checkNotNullExpressionValue((Object)entry, (String)"entry");
                this.removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void flush() throws IOException {
        synchronized (this) {
            boolean bl = this.initialized;
            if (!bl) {
                return;
            }
            this.checkNotClosed();
            this.trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull((Object)bufferedSink);
            bufferedSink.flush();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final Snapshot get(String string) throws IOException {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"key");
            this.initialize();
            this.checkNotClosed();
            this.validateKey(string);
            Entry entry = this.lruEntries.get(string);
            if (entry == null) {
                return null;
            }
            Snapshot snapshot = entry.snapshot$okhttp();
            if (snapshot == null) {
                return null;
            }
            ++this.redundantOpCount;
            entry = this.journalWriter;
            Intrinsics.checkNotNull((Object)entry);
            entry.writeUtf8(READ).writeByte(32).writeUtf8(string).writeByte(10);
            if (!this.journalRebuildRequired()) return snapshot;
            TaskQueue.schedule$default((TaskQueue)this.cleanupQueue, (Task)((Task)this.cleanupTask), (long)0L, (int)2, null);
            return snapshot;
        }
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final Path getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final long getMaxSize() {
        synchronized (this) {
            long l = this.maxSize;
            return l;
        }
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void initialize() throws IOException {
        synchronized (this) {
            if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                stringBuilder.append((Object)Thread.currentThread().getName());
                stringBuilder.append(" MUST hold lock on ");
                stringBuilder.append(this);
                AssertionError assertionError = new AssertionError((Object)stringBuilder.toString());
                throw assertionError;
            }
            boolean bl = this.initialized;
            if (bl) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = Util.isCivilized((FileSystem)this.fileSystem, (Path)this.journalFileBackup);
            bl = this.fileSystem.exists(this.journalFile);
            if (bl) {
                try {
                    this.readJournal();
                    this.processJournal();
                    this.initialized = true;
                    return;
                }
                catch (IOException iOException) {
                    Platform platform = Platform.Companion.get();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("DiskLruCache ");
                    stringBuilder.append(this.directory);
                    stringBuilder.append(" is corrupt: ");
                    stringBuilder.append((Object)iOException.getMessage());
                    stringBuilder.append(", removing");
                    platform.log(stringBuilder.toString(), 5, (Throwable)iOException);
                    try {
                        this.delete();
                    }
                    finally {
                        this.closed = false;
                    }
                }
            }
            this.rebuildJournal$okhttp();
            this.initialized = true;
            return;
        }
    }

    public final boolean isClosed() {
        synchronized (this) {
            boolean bl = this.closed;
            return bl;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public final void rebuildJournal$okhttp() throws IOException {
        synchronized (this) {
            var1_1 /* !! */  = this.journalWriter;
            if (var1_1 /* !! */  != null) {
                var1_1 /* !! */ .close();
            }
            var3_4 = (Closeable)Okio.buffer((Sink)this.fileSystem.sink(this.journalFileTmp, false));
            var1_1 /* !! */  = null;
            {
                catch (Throwable var1_3) {
                    throw var1_3;
                }
                try {
                    var4_6 = (BufferedSink)var3_4;
                    var4_6.writeUtf8(DiskLruCache.MAGIC).writeByte(10);
                    var4_6.writeUtf8(DiskLruCache.VERSION_1).writeByte(10);
                    var4_6.writeDecimalLong((long)this.appVersion).writeByte(10);
                    var4_6.writeDecimalLong((long)this.getValueCount$okhttp()).writeByte(10);
                    var4_6.writeByte(10);
                    for (Unit var2_8 : this.getLruEntries$okhttp().values()) {
                        if (var2_8.getCurrentEditor$okhttp() != null) {
                            var4_6.writeUtf8(DiskLruCache.DIRTY).writeByte(32);
                            var4_6.writeUtf8(var2_8.getKey$okhttp());
                            var4_6.writeByte(10);
                            continue;
                        }
                        var4_6.writeUtf8(DiskLruCache.CLEAN).writeByte(32);
                        var4_6.writeUtf8(var2_8.getKey$okhttp());
                        var2_8.writeLengths$okhttp(var4_6);
                        var4_6.writeByte(10);
                    }
                    var2_8 = Unit.INSTANCE;
                }
                catch (Throwable var1_2) {
                    var2_8 = null;
                }
                if (var3_4 == null) ** GOTO lbl53
                try {
                    var3_4.close();
                    ** GOTO lbl53
                }
                catch (Throwable var3_5) {}
                if (var1_1 /* !! */  != null) ** GOTO lbl-1000
                var1_1 /* !! */  = var3_5;
                ** GOTO lbl53
lbl-1000:
                // 1 sources

                {
                    ExceptionsKt.addSuppressed((Throwable)var1_1 /* !! */ , (Throwable)var3_5);
lbl53:
                    // 4 sources

                    if (var1_1 /* !! */  != null) throw var1_1 /* !! */ ;
                    Intrinsics.checkNotNull(var2_8);
                    if (this.fileSystem.exists(this.journalFile)) {
                        this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                        this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                        Util.deleteIfExists((FileSystem)this.fileSystem, (Path)this.journalFileBackup);
                    } else {
                        this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                    }
                    this.journalWriter = this.newJournalWriter();
                    this.hasJournalErrors = false;
                    this.mostRecentRebuildFailed = false;
                    return;
                }
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean remove(String string) throws IOException {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"key");
            this.initialize();
            this.checkNotClosed();
            this.validateKey(string);
            string = this.lruEntries.get(string);
            if (string == null) {
                return false;
            }
            boolean bl = this.removeEntry$okhttp((Entry)string);
            if (!bl) return bl;
            if (this.size > this.maxSize) return bl;
            this.mostRecentTrimFailed = false;
            return bl;
        }
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        Editor editor;
        Intrinsics.checkNotNullParameter((Object)entry, (String)"entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (editor = this.journalWriter) != null) {
                editor.writeUtf8(DIRTY);
                editor.writeByte(32);
                editor.writeUtf8(entry.getKey$okhttp());
                editor.writeByte(10);
                editor.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        if ((editor = entry.getCurrentEditor$okhttp()) != null) {
            editor.detach$okhttp();
        }
        int n = 0;
        int n2 = this.valueCount;
        if (n2 > 0) {
            while (true) {
                int n3 = n + 1;
                Util.deleteIfExists((FileSystem)this.fileSystem, (Path)((Path)entry.getCleanFiles$okhttp().get(n)));
                this.size -= entry.getLengths$okhttp()[n];
                entry.getLengths$okhttp()[n] = 0L;
                if (n3 >= n2) break;
                n = n3;
            }
        }
        ++this.redundantOpCount;
        editor = this.journalWriter;
        if (editor != null) {
            editor.writeUtf8(REMOVE);
            editor.writeByte(32);
            editor.writeUtf8(entry.getKey$okhttp());
            editor.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (!this.journalRebuildRequired()) return true;
        TaskQueue.schedule$default((TaskQueue)this.cleanupQueue, (Task)((Task)this.cleanupTask), (long)0L, (int)2, null);
        return true;
    }

    public final void setClosed$okhttp(boolean bl) {
        this.closed = bl;
    }

    public final void setMaxSize(long l) {
        synchronized (this) {
            this.maxSize = l;
            if (!this.initialized) return;
            TaskQueue.schedule$default((TaskQueue)this.cleanupQueue, (Task)((Task)this.cleanupTask), (long)0L, (int)2, null);
            return;
        }
    }

    public final long size() throws IOException {
        synchronized (this) {
            this.initialize();
            long l = this.size;
            return l;
        }
    }

    public final Iterator<Snapshot> snapshots() throws IOException {
        synchronized (this) {
            this.initialize();
            Object object = new /* Unavailable Anonymous Inner Class!! */;
            object = (Iterator)object;
            return object;
        }
    }

    public final void trimToSize() throws IOException {
        do {
            if (this.size > this.maxSize) continue;
            this.mostRecentTrimFailed = false;
            return;
        } while (this.removeOldestEntry());
    }
}
