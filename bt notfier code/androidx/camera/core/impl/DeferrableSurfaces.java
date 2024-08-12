/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException
 *  androidx.camera.core.impl._$$Lambda$DeferrableSurfaces$1M8fKlBzTzms6mhVK_pmWAC05CU
 *  androidx.camera.core.impl._$$Lambda$DeferrableSurfaces$Yekn_mWFALhEwuFd18dTMaz7qws
 *  androidx.camera.core.impl._$$Lambda$DeferrableSurfaces$_eJ7iY3oHlcbhnrK9kAok8keF3w
 *  androidx.camera.core.impl._$$Lambda$DeferrableSurfaces$pmCedm8iLOMS_IHrIv_Uw2AJ038
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl._$;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class DeferrableSurfaces {
    private DeferrableSurfaces() {
    }

    public static void decrementAll(List<DeferrableSurface> object) {
        object = object.iterator();
        while (object.hasNext()) {
            ((DeferrableSurface)object.next()).decrementUseCount();
        }
    }

    /*
     * Exception decompiling
     */
    public static void incrementAll(List<DeferrableSurface> var0) throws DeferrableSurface.SurfaceClosedException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[DOLOOP]], but top level block is 0[TRYBLOCK]
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

    static /* synthetic */ void lambda$surfaceListWithTimeout$0(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long l) {
        if (listenableFuture.isDone()) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot complete surfaceList within ");
        stringBuilder.append(l);
        completer.setException((Throwable)new TimeoutException(stringBuilder.toString()));
        listenableFuture.cancel(true);
    }

    static /* synthetic */ void lambda$surfaceListWithTimeout$1(Executor executor, ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long l) {
        executor.execute((Runnable)new _$.Lambda.DeferrableSurfaces.Yekn_mWFALhEwuFd18dTMaz7qws(listenableFuture, completer, l));
    }

    static /* synthetic */ void lambda$surfaceListWithTimeout$2(ListenableFuture listenableFuture) {
        listenableFuture.cancel(true);
    }

    static /* synthetic */ Object lambda$surfaceListWithTimeout$3(List object, ScheduledExecutorService object2, Executor executor, long l, boolean bl, CallbackToFutureAdapter.Completer completer) throws Exception {
        object = Futures.successfulAsList((Collection)object);
        object2 = object2.schedule((Runnable)new _$.Lambda.DeferrableSurfaces.1M8fKlBzTzms6mhVK_pmWAC05CU(executor, (ListenableFuture)object, completer, l), l, TimeUnit.MILLISECONDS);
        completer.addCancellationListener((Runnable)new _$.Lambda.DeferrableSurfaces.pmCedm8iLOMS_IHrIv_Uw2AJ038((ListenableFuture)object), executor);
        Futures.addCallback((ListenableFuture)object, (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)executor);
        return "surfaceList";
    }

    public static ListenableFuture<List<Surface>> surfaceListWithTimeout(Collection<DeferrableSurface> object, boolean bl, long l, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        ArrayList<ListenableFuture> arrayList = new ArrayList<ListenableFuture>();
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(((DeferrableSurface)object.next()).getSurface());
        }
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.DeferrableSurfaces._eJ7iY3oHlcbhnrK9kAok8keF3w(arrayList, scheduledExecutorService, executor, l, bl));
    }

    public static boolean tryIncrementAll(List<DeferrableSurface> list) {
        try {
            DeferrableSurfaces.incrementAll(list);
            return true;
        }
        catch (DeferrableSurface.SurfaceClosedException surfaceClosedException) {
            return false;
        }
    }
}
