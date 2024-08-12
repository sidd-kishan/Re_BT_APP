/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.observers.BasicQueueDisposable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

static final class ObservableFromIterable.FromIterableDisposable<T>
extends BasicQueueDisposable<T> {
    boolean checkNext;
    volatile boolean disposed;
    boolean done;
    final Observer<? super T> downstream;
    boolean fusionMode;
    final Iterator<? extends T> it;

    ObservableFromIterable.FromIterableDisposable(Observer<? super T> observer, Iterator<? extends T> iterator) {
        this.downstream = observer;
        this.it = iterator;
    }

    public void clear() {
        this.done = true;
    }

    public void dispose() {
        this.disposed = true;
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean isEmpty() {
        return this.done;
    }

    public T poll() {
        if (this.done) {
            return null;
        }
        if (this.checkNext) {
            if (this.it.hasNext()) return (T)ObjectHelper.requireNonNull(this.it.next(), (String)"The iterator returned a null value");
            this.done = true;
            return null;
        }
        this.checkNext = true;
        return (T)ObjectHelper.requireNonNull(this.it.next(), (String)"The iterator returned a null value");
    }

    public int requestFusion(int n) {
        if ((n & 1) == 0) return 0;
        this.fusionMode = true;
        return 1;
    }

    /*
     * Exception decompiling
     */
    void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 1[TRYBLOCK]
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
