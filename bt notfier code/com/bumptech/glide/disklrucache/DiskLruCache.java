/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.disklrucache.DiskLruCache$DiskLruCacheThreadFactory
 *  com.bumptech.glide.disklrucache.DiskLruCache$Editor
 *  com.bumptech.glide.disklrucache.DiskLruCache$Entry
 *  com.bumptech.glide.disklrucache.DiskLruCache$Value
 *  com.bumptech.glide.disklrucache.Util
 */
package com.bumptech.glide.disklrucache;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.disklrucache.Util;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis ignored.
 */
public final class DiskLruCache
implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    private final File directory;
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private long maxSize;
    private long nextSequenceNumber = 0L;
    private int redundantOpCount;
    private long size = 0L;
    private final int valueCount;

    private DiskLruCache(File file, int n, int n2, long l) {
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)new DiskLruCacheThreadFactory(null));
        this.cleanupCallable = new /* Unavailable Anonymous Inner Class!! */;
        this.directory = file;
        this.appVersion = n;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = n2;
        this.maxSize = l;
    }

    static /* synthetic */ Writer access$100(DiskLruCache diskLruCache) {
        return diskLruCache.journalWriter;
    }

    static /* synthetic */ Editor access$1700(DiskLruCache diskLruCache, String string, long l) throws IOException {
        return diskLruCache.edit(string, l);
    }

    static /* synthetic */ String access$1800(InputStream inputStream) throws IOException {
        return DiskLruCache.inputStreamToString(inputStream);
    }

    static /* synthetic */ int access$1900(DiskLruCache diskLruCache) {
        return diskLruCache.valueCount;
    }

    static /* synthetic */ void access$200(DiskLruCache diskLruCache) throws IOException {
        diskLruCache.trimToSize();
    }

    static /* synthetic */ File access$2000(DiskLruCache diskLruCache) {
        return diskLruCache.directory;
    }

    static /* synthetic */ void access$2100(DiskLruCache diskLruCache, Editor editor, boolean bl) throws IOException {
        diskLruCache.completeEdit(editor, bl);
    }

    static /* synthetic */ boolean access$300(DiskLruCache diskLruCache) {
        return diskLruCache.journalRebuildRequired();
    }

    static /* synthetic */ void access$400(DiskLruCache diskLruCache) throws IOException {
        diskLruCache.rebuildJournal();
    }

    static /* synthetic */ int access$502(DiskLruCache diskLruCache, int n) {
        diskLruCache.redundantOpCount = n;
        return n;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) throw new IllegalStateException("cache is closed");
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void completeEdit(Editor object, boolean bl) throws IOException {
        synchronized (this) {
            long l;
            int n;
            Entry entry;
            block15: {
                int n2;
                block17: {
                    block16: {
                        entry = Editor.access$1500((Editor)object);
                        if (Entry.access$800((Entry)entry) != object) break block16;
                        n = n2 = 0;
                        if (!bl) break block15;
                        n = n2;
                        if (Entry.access$700((Entry)entry)) break block15;
                        break block17;
                    }
                    object = new IllegalStateException();
                    throw object;
                }
                int n3 = 0;
                while (true) {
                    n = n2;
                    if (n3 >= this.valueCount) break block15;
                    if (!Editor.access$1600((Editor)object)[n3]) break;
                    if (!entry.getDirtyFile(n3).exists()) {
                        object.abort();
                        return;
                    }
                    ++n3;
                }
                object.abort();
                object = new StringBuilder();
                ((StringBuilder)object).append("Newly created entry didn't create value for index ");
                ((StringBuilder)object).append(n3);
                IllegalStateException illegalStateException = new IllegalStateException(((StringBuilder)object).toString());
                throw illegalStateException;
            }
            while (n < this.valueCount) {
                File file = entry.getDirtyFile(n);
                if (bl) {
                    if (file.exists()) {
                        object = entry.getCleanFile(n);
                        file.renameTo((File)object);
                        long l2 = Entry.access$1100((Entry)entry)[n];
                        Entry.access$1100((Entry)entry)[n] = l = ((File)object).length();
                        this.size = this.size - l2 + l;
                    }
                } else {
                    DiskLruCache.deleteIfExists(file);
                }
                ++n;
            }
            ++this.redundantOpCount;
            Entry.access$802((Entry)entry, null);
            if (Entry.access$700((Entry)entry) | bl) {
                Entry.access$702((Entry)entry, (boolean)true);
                this.journalWriter.append("CLEAN");
                this.journalWriter.append(' ');
                this.journalWriter.append(Entry.access$1200((Entry)entry));
                this.journalWriter.append(entry.getLengths());
                this.journalWriter.append('\n');
                if (bl) {
                    l = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1L + l;
                    Entry.access$1302((Entry)entry, (long)l);
                }
            } else {
                this.lruEntries.remove(Entry.access$1200((Entry)entry));
                this.journalWriter.append("REMOVE");
                this.journalWriter.append(' ');
                this.journalWriter.append(Entry.access$1200((Entry)entry));
                this.journalWriter.append('\n');
            }
            this.journalWriter.flush();
            if (this.size <= this.maxSize) {
                if (!this.journalRebuildRequired()) return;
            }
            this.executorService.submit(this.cleanupCallable);
            return;
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (!file.exists()) return;
        if (!file.delete()) throw new IOException();
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private Editor edit(String string, long l) throws IOException {
        synchronized (this) {
            Editor editor;
            void var2_2;
            this.checkNotClosed();
            Entry entry = this.lruEntries.get(string);
            if (var2_2 != -1L) {
                if (entry == null) return null;
                long l2 = Entry.access$1300((Entry)entry);
                if (l2 != var2_2) {
                    return null;
                }
            }
            if (entry == null) {
                entry = new Entry(this, string, null);
                this.lruEntries.put(string, entry);
            } else {
                editor = Entry.access$800((Entry)entry);
                if (editor != null) {
                    return null;
                }
            }
            editor = new Editor(this, entry, null);
            Entry.access$802((Entry)entry, (Editor)editor);
            this.journalWriter.append("DIRTY");
            this.journalWriter.append(' ');
            this.journalWriter.append(string);
            this.journalWriter.append('\n');
            this.journalWriter.flush();
            return editor;
        }
    }

    private static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.readFully((Reader)new InputStreamReader(inputStream, Util.UTF_8));
    }

    private boolean journalRebuildRequired() {
        int n = this.redundantOpCount;
        boolean bl = n >= 2000 && n >= this.lruEntries.size();
        return bl;
    }

    public static DiskLruCache open(File object, int n, int n2, long l) throws IOException {
        if (l <= 0L) throw new IllegalArgumentException("maxSize <= 0");
        if (n2 <= 0) throw new IllegalArgumentException("valueCount <= 0");
        Object object2 = new File((File)object, "journal.bkp");
        if (((File)object2).exists()) {
            File file = new File((File)object, "journal");
            if (file.exists()) {
                ((File)object2).delete();
            } else {
                DiskLruCache.renameTo((File)object2, file, false);
            }
        }
        object2 = new DiskLruCache((File)object, n, n2, l);
        if (((DiskLruCache)object2).journalFile.exists()) {
            try {
                super.readJournal();
                super.processJournal();
                return object2;
            }
            catch (IOException iOException) {
                PrintStream printStream = System.out;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DiskLruCache ");
                stringBuilder.append(object);
                stringBuilder.append(" is corrupt: ");
                stringBuilder.append(iOException.getMessage());
                stringBuilder.append(", removing");
                printStream.println(stringBuilder.toString());
                ((DiskLruCache)object2).delete();
            }
        }
        ((File)object).mkdirs();
        object = new DiskLruCache((File)object, n, n2, l);
        super.rebuildJournal();
        return object;
    }

    private void processJournal() throws IOException {
        DiskLruCache.deleteIfExists(this.journalFileTmp);
        Iterator<Entry> iterator = this.lruEntries.values().iterator();
        block0: while (iterator.hasNext()) {
            int n;
            Entry entry = iterator.next();
            Editor editor = Entry.access$800((Entry)entry);
            int n2 = 0;
            if (editor == null) {
                n = n2;
                while (true) {
                    if (n >= this.valueCount) continue block0;
                    this.size += Entry.access$1100((Entry)entry)[n];
                    ++n;
                }
            }
            Entry.access$802((Entry)entry, null);
            for (n = 0; n < this.valueCount; ++n) {
                DiskLruCache.deleteIfExists(entry.getCleanFile(n));
                DiskLruCache.deleteIfExists(entry.getDirtyFile(n));
            }
            iterator.remove();
        }
    }

    /*
     * Exception decompiling
     */
    private void readJournal() throws IOException {
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

    private void readJournalLine(String stringArray) throws IOException {
        CharSequence charSequence;
        block13: {
            block11: {
                int n;
                int n2;
                block12: {
                    String string;
                    block10: {
                        n2 = stringArray.indexOf(32);
                        if (n2 == -1) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("unexpected journal line: ");
                            stringBuilder.append((String)stringArray);
                            throw new IOException(stringBuilder.toString());
                        }
                        int n3 = n2 + 1;
                        n = stringArray.indexOf(32, n3);
                        if (n == -1) {
                            string = stringArray.substring(n3);
                            charSequence = string;
                            if (n2 == 6) {
                                charSequence = string;
                                if (stringArray.startsWith("REMOVE")) {
                                    this.lruEntries.remove(string);
                                    return;
                                }
                            }
                        } else {
                            charSequence = stringArray.substring(n3, n);
                        }
                        Entry entry = this.lruEntries.get(charSequence);
                        string = entry;
                        if (entry == null) {
                            string = new Entry(this, (String)charSequence, null);
                            this.lruEntries.put((String)charSequence, (Entry)string);
                        }
                        if (n == -1 || n2 != 5 || !stringArray.startsWith("CLEAN")) break block10;
                        stringArray = stringArray.substring(n + 1).split(" ");
                        Entry.access$702((Entry)string, (boolean)true);
                        Entry.access$802((Entry)string, null);
                        Entry.access$900((Entry)string, (String[])stringArray);
                        break block11;
                    }
                    if (n != -1 || n2 != 5 || !stringArray.startsWith("DIRTY")) break block12;
                    Entry.access$802((Entry)string, (Editor)new Editor(this, (Entry)string, null));
                    break block11;
                }
                if (n != -1 || n2 != 4 || !stringArray.startsWith("READ")) break block13;
            }
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("unexpected journal line: ");
        ((StringBuilder)charSequence).append((String)stringArray);
        throw new IOException(((StringBuilder)charSequence).toString());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private void rebuildJournal() throws IOException {
        synchronized (this) {
            if (this.journalWriter != null) {
                this.journalWriter.close();
            }
            FileOutputStream closeable2 = new FileOutputStream(this.journalFileTmp);
            Object object = new OutputStreamWriter((OutputStream)closeable2, Util.US_ASCII);
            BufferedWriter bufferedWriter = new BufferedWriter((Writer)object);
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.appVersion));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.valueCount));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.lruEntries.values()) {
                    StringBuilder stringBuilder;
                    if (Entry.access$800((Entry)entry) != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("DIRTY ");
                        stringBuilder.append(Entry.access$1200((Entry)entry));
                        stringBuilder.append('\n');
                        bufferedWriter.write(stringBuilder.toString());
                        continue;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("CLEAN ");
                    stringBuilder.append(Entry.access$1200((Entry)entry));
                    stringBuilder.append(entry.getLengths());
                    stringBuilder.append('\n');
                    bufferedWriter.write(stringBuilder.toString());
                }
            }
            finally {
                ((Writer)bufferedWriter).close();
            }
            {
                if (this.journalFile.exists()) {
                    DiskLruCache.renameTo(this.journalFile, this.journalFileBackup, true);
                }
                DiskLruCache.renameTo(this.journalFileTmp, this.journalFile, false);
                this.journalFileBackup.delete();
                object = new FileOutputStream(this.journalFile, true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)object, Util.US_ASCII);
                bufferedWriter = new BufferedWriter(outputStreamWriter);
                this.journalWriter = bufferedWriter;
                return;
            }
        }
    }

    private static void renameTo(File file, File file2, boolean bl) throws IOException {
        if (bl) {
            DiskLruCache.deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) throw new IOException();
    }

    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            this.remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void close() throws IOException {
        synchronized (this) {
            Object object = this.journalWriter;
            if (object == null) {
                return;
            }
            object = new ArrayList(this.lruEntries.values());
            object = ((ArrayList)object).iterator();
            while (true) {
                if (!object.hasNext()) {
                    this.trimToSize();
                    this.journalWriter.close();
                    this.journalWriter = null;
                    return;
                }
                Entry entry = (Entry)object.next();
                if (Entry.access$800((Entry)entry) == null) continue;
                Entry.access$800((Entry)entry).abort();
            }
        }
    }

    public void delete() throws IOException {
        this.close();
        Util.deleteContents((File)this.directory);
    }

    public Editor edit(String string) throws IOException {
        return this.edit(string, -1L);
    }

    public void flush() throws IOException {
        synchronized (this) {
            this.checkNotClosed();
            this.trimToSize();
            this.journalWriter.flush();
            return;
        }
    }

    public Value get(String string) throws IOException {
        synchronized (this) {
            boolean bl;
            Entry entry;
            block9: {
                block8: {
                    this.checkNotClosed();
                    entry = this.lruEntries.get(string);
                    if (entry != null) break block8;
                    return null;
                }
                bl = Entry.access$700((Entry)entry);
                if (bl) break block9;
                return null;
            }
            try {
                File[] fileArray = entry.cleanFiles;
                int n = fileArray.length;
                for (int i = 0; i < n; ++i) {
                    bl = fileArray[i].exists();
                    if (bl) continue;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            return null;
            ++this.redundantOpCount;
            this.journalWriter.append("READ");
            this.journalWriter.append(' ');
            this.journalWriter.append(string);
            this.journalWriter.append('\n');
            if (this.journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            string = new Value(this, string, Entry.access$1300((Entry)entry), entry.cleanFiles, Entry.access$1100((Entry)entry), null);
            return string;
        }
    }

    public File getDirectory() {
        return this.directory;
    }

    public long getMaxSize() {
        synchronized (this) {
            long l = this.maxSize;
            return l;
        }
    }

    public boolean isClosed() {
        synchronized (this) {
            Writer writer = this.journalWriter;
            boolean bl = writer == null;
            return bl;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public boolean remove(String object) throws IOException {
        synchronized (this) {
            block6: {
                this.checkNotClosed();
                Object object2 = this.lruEntries.get(object);
                if (object2 == null) return false;
                if (Entry.access$800((Entry)object2) != null) break block6;
                for (int i = 0; i < this.valueCount; this.size -= Entry.access$1100((Entry)object2)[i], ++i) {
                    File file = object2.getCleanFile(i);
                    if (file.exists() && !file.delete()) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("failed to delete ");
                        ((StringBuilder)object2).append(file);
                        object = new IOException(((StringBuilder)object2).toString());
                        throw object;
                    }
                    Entry.access$1100((Entry)object2)[i] = 0L;
                }
                {
                    ++this.redundantOpCount;
                    this.journalWriter.append("REMOVE");
                    this.journalWriter.append(' ');
                    this.journalWriter.append((CharSequence)object);
                    this.journalWriter.append('\n');
                    this.lruEntries.remove(object);
                    if (!this.journalRebuildRequired()) return true;
                    this.executorService.submit(this.cleanupCallable);
                    return true;
                }
            }
            return false;
        }
    }

    public void setMaxSize(long l) {
        synchronized (this) {
            this.maxSize = l;
            this.executorService.submit(this.cleanupCallable);
            return;
        }
    }

    public long size() {
        synchronized (this) {
            long l = this.size;
            return l;
        }
    }
}
