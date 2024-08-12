/*
 * Decompiled with CFR 0.152.
 */
package androidx.collection;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int n) {
        if (n <= 0) throw new IllegalArgumentException("maxSize <= 0");
        this.maxSize = n;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    private int safeSizeOf(K k, V v) {
        int n = this.sizeOf(k, v);
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(k);
        stringBuilder.append("=");
        stringBuilder.append(v);
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected V create(K k) {
        return null;
    }

    public final int createCount() {
        synchronized (this) {
            int n = this.createCount;
            return n;
        }
    }

    protected void entryRemoved(boolean bl, K k, V v, V v2) {
    }

    public final void evictAll() {
        this.trimToSize(-1);
    }

    public final int evictionCount() {
        synchronized (this) {
            int n = this.evictionCount;
            return n;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final V get(K k) {
        if (k == null) throw new NullPointerException("key == null");
        // MONITORENTER : this
        V v = this.map.get(k);
        if (v != null) {
            ++this.hitCount;
            // MONITOREXIT : this
            return v;
        }
        ++this.missCount;
        // MONITOREXIT : this
        v = this.create(k);
        if (v == null) {
            return null;
        }
        // MONITORENTER : this
        ++this.createCount;
        V v2 = this.map.put(k, v);
        if (v2 != null) {
            this.map.put(k, v2);
        } else {
            this.size += this.safeSizeOf(k, v);
        }
        // MONITOREXIT : this
        if (v2 != null) {
            this.entryRemoved(false, k, v, v2);
            return v2;
        }
        this.trimToSize(this.maxSize);
        return v;
    }

    public final int hitCount() {
        synchronized (this) {
            int n = this.hitCount;
            return n;
        }
    }

    public final int maxSize() {
        synchronized (this) {
            int n = this.maxSize;
            return n;
        }
    }

    public final int missCount() {
        synchronized (this) {
            int n = this.missCount;
            return n;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final V put(K k, V v) {
        if (k == null) throw new NullPointerException("key == null || value == null");
        if (v == null) throw new NullPointerException("key == null || value == null");
        // MONITORENTER : this
        ++this.putCount;
        this.size += this.safeSizeOf(k, v);
        V v2 = this.map.put(k, v);
        if (v2 != null) {
            this.size -= this.safeSizeOf(k, v2);
        }
        // MONITOREXIT : this
        if (v2 != null) {
            this.entryRemoved(false, k, v2, v);
        }
        this.trimToSize(this.maxSize);
        return v2;
    }

    public final int putCount() {
        synchronized (this) {
            int n = this.putCount;
            return n;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final V remove(K k) {
        Object v;
        if (k == null) throw new NullPointerException("key == null");
        synchronized (this) {
            v = this.map.remove(k);
            if (v != null) {
                this.size -= this.safeSizeOf(k, v);
            }
        }
        if (v == null) return v;
        this.entryRemoved(false, k, v, null);
        return v;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void resize(int n) {
        if (n <= 0) throw new IllegalArgumentException("maxSize <= 0");
        synchronized (this) {
            this.maxSize = n;
        }
        this.trimToSize(n);
    }

    public final int size() {
        synchronized (this) {
            int n = this.size;
            return n;
        }
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public final Map<K, V> snapshot() {
        synchronized (this) {
            LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<K, V>(this.map);
            return linkedHashMap;
        }
    }

    public final String toString() {
        synchronized (this) {
            int n = this.hitCount + this.missCount;
            n = n != 0 ? this.hitCount * 100 / n : 0;
            String string = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.maxSize, this.hitCount, this.missCount, n);
            return string;
        }
    }

    /*
     * Exception decompiling
     */
    public void trimToSize(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[UNCONDITIONALDOLOOP]], but top level block is 2[MONITOR]
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
}
