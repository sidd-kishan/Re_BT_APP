/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

class ListFuture<V>
implements ListenableFuture<List<V>> {
    private final boolean mAllMustSucceed;
    List<? extends ListenableFuture<? extends V>> mFutures;
    private final AtomicInteger mRemaining;
    private final ListenableFuture<List<V>> mResult;
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;
    List<V> mValues;

    ListFuture(List<? extends ListenableFuture<? extends V>> list, boolean bl, Executor executor) {
        this.mFutures = (List)Preconditions.checkNotNull(list);
        this.mValues = new ArrayList<V>(list.size());
        this.mAllMustSucceed = bl;
        this.mRemaining = new AtomicInteger(list.size());
        this.mResult = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new /* Unavailable Anonymous Inner Class!! */);
        this.init(executor);
    }

    /*
     * Exception decompiling
     */
    private void callAllGets() throws InterruptedException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 5[UNCONDITIONALDOLOOP]
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

    private void init(Executor executor) {
        int n;
        this.addListener((Runnable)new /* Unavailable Anonymous Inner Class!! */, CameraXExecutors.directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList<V>(this.mValues));
            return;
        }
        int n2 = 0;
        for (n = 0; n < this.mFutures.size(); ++n) {
            this.mValues.add(null);
        }
        List<ListenableFuture<V>> list = this.mFutures;
        n = n2;
        while (n < list.size()) {
            ListenableFuture<V> listenableFuture = list.get(n);
            listenableFuture.addListener((Runnable)new /* Unavailable Anonymous Inner Class!! */, executor);
            ++n;
        }
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    @Override
    public boolean cancel(boolean bl) {
        List<ListenableFuture<V>> list = this.mFutures;
        if (list == null) return this.mResult.cancel(bl);
        list = list.iterator();
        while (list.hasNext()) {
            ((ListenableFuture)list.next()).cancel(bl);
        }
        return this.mResult.cancel(bl);
    }

    @Override
    public List<V> get() throws InterruptedException, ExecutionException {
        this.callAllGets();
        return (List)this.mResult.get();
    }

    @Override
    public List<V> get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (List)this.mResult.get(l, timeUnit);
    }

    @Override
    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.mResult.isDone();
    }

    /*
     * Exception decompiling
     */
    void setOneValue(int var1_1, Future<? extends V> var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [5 : 142->151)] java.lang.Throwable
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
}
