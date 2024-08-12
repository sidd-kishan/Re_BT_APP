/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableIterator
 *  okhttp3.internal.cache.DiskLruCache
 *  okhttp3.internal.cache.DiskLruCache$Entry
 *  okhttp3.internal.cache.DiskLruCache$Snapshot
 */
package okhttp3.internal.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.internal.cache.DiskLruCache;

@Metadata(d1={"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\r\u0010\u000b\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012 \u0006*\b\u0018\u00010\u0005R\u00020\u00030\u0005R\u00020\u00030\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"okhttp3/internal/cache/DiskLruCache$snapshots$1", "", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "delegate", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "kotlin.jvm.PlatformType", "nextSnapshot", "removeSnapshot", "hasNext", "", "next", "remove", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class DiskLruCache.snapshots.1
implements Iterator<DiskLruCache.Snapshot>,
KMutableIterator {
    private final Iterator<DiskLruCache.Entry> delegate;
    private DiskLruCache.Snapshot nextSnapshot;
    private DiskLruCache.Snapshot removeSnapshot;
    final DiskLruCache this$0;

    DiskLruCache.snapshots.1(DiskLruCache object) {
        this.this$0 = object;
        object = new ArrayList(this.this$0.getLruEntries$okhttp().values()).iterator();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"ArrayList(lruEntries.values).iterator()");
        this.delegate = object;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    @Override
    public boolean hasNext() {
        if (this.nextSnapshot != null) {
            return true;
        }
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            void var2_3;
            boolean bl = diskLruCache.getClosed$okhttp();
            if (bl) {
                return false;
            }
            do {
                if (!this.delegate.hasNext()) {
                    Unit unit = Unit.INSTANCE;
                    return false;
                }
                DiskLruCache.Entry entry = this.delegate.next();
                if (entry == null) {
                    Object var2_5 = null;
                    continue;
                }
                DiskLruCache.Snapshot snapshot = entry.snapshot$okhttp();
            } while (var2_3 == null);
            this.nextSnapshot = var2_3;
            return true;
        }
    }

    @Override
    public DiskLruCache.Snapshot next() {
        DiskLruCache.Snapshot snapshot;
        if (!this.hasNext()) throw new NoSuchElementException();
        this.removeSnapshot = snapshot = this.nextSnapshot;
        this.nextSnapshot = null;
        Intrinsics.checkNotNull((Object)snapshot);
        return snapshot;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void remove() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Last catch has completely empty body
         *     at org.benf.cfr.reader.bytecode.analysis.parse.utils.finalhelp.FinalAnalyzer.identifyFinally(FinalAnalyzer.java:286)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.FinallyRewriter.identifyFinally(FinallyRewriter.java:40)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:611)
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
}
