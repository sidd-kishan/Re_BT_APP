/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

static final class FlowableFromIterable.IteratorSubscription<T>
extends FlowableFromIterable.BaseRangeSubscription<T> {
    private static final long serialVersionUID = -6022804456014692607L;
    final Subscriber<? super T> downstream;

    FlowableFromIterable.IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> iterator) {
        super(iterator);
        this.downstream = subscriber;
    }

    /*
     * Exception decompiling
     */
    void fastPath() {
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

    void slowPath(long l) {
        long l2;
        Iterator iterator = this.it;
        Subscriber<? super T> subscriber = this.downstream;
        do {
            l2 = 0L;
            while (true) {
                long l3;
                if (l2 != l) {
                    block11: {
                        Object e;
                        block10: {
                            if (this.cancelled) {
                                return;
                            }
                            try {
                                e = iterator.next();
                                if (this.cancelled) {
                                    return;
                                }
                                if (e != null) break block10;
                            }
                            catch (Throwable throwable) {
                                Exceptions.throwIfFatal((Throwable)throwable);
                                subscriber.onError(throwable);
                                return;
                            }
                            subscriber.onError((Throwable)new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(e);
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            boolean bl = iterator.hasNext();
                            if (bl) break block11;
                            if (this.cancelled) return;
                        }
                        catch (Throwable throwable) {
                            Exceptions.throwIfFatal((Throwable)throwable);
                            subscriber.onError(throwable);
                            return;
                        }
                        subscriber.onComplete();
                        return;
                    }
                    ++l2;
                    continue;
                }
                l = l3 = this.get();
                if (l2 == l3) break;
            }
            l = l2 = this.addAndGet(-l2);
        } while (l2 != 0L);
    }
}
