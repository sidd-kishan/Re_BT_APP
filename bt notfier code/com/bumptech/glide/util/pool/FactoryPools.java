/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  androidx.core.util.Pools$SimplePool
 *  androidx.core.util.Pools$SynchronizedPool
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 *  com.bumptech.glide.util.pool.FactoryPools$FactoryPool
 *  com.bumptech.glide.util.pool.FactoryPools$Poolable
 *  com.bumptech.glide.util.pool.FactoryPools$Resetter
 */
package com.bumptech.glide.util.pool;

import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.List;

public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new /* Unavailable Anonymous Inner Class!! */;
    private static final String TAG = "FactoryPools";

    private FactoryPools() {
    }

    /*
     * Exception decompiling
     */
    private static <T extends Poolable> Pools.Pool<T> build(Pools.Pool<T> var0, Factory<T> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.NullPointerException
         *     at org.benf.cfr.reader.bytecode.analysis.types.GenericTypeBinder.extractBaseBindings(GenericTypeBinder.java:125)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter$InnerExplicitTypeCallRewriter.rewriteFunctionInvokation(ExplicitTypeCallRewriter.java:37)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter$InnerExplicitTypeCallRewriter.rewriteExpression(ExplicitTypeCallRewriter.java:56)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExpressionRewriterHelper.applyForwards(ExpressionRewriterHelper.java:12)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.applyExpressionRewriterToArgs(StaticFunctionInvokation.java:103)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter.rewriteExpression(ExplicitTypeCallRewriter.java:71)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.statement.ReturnValueStatement.rewriteExpressions(ReturnValueStatement.java:62)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.rewrite(Op03SimpleStatement.java:479)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Op03Rewriters.rewriteWith(Op03Rewriters.java:23)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:819)
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

    private static <T> Pools.Pool<T> build(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    private static <T> Resetter<T> emptyResetter() {
        return EMPTY_RESETTER;
    }

    public static <T extends Poolable> Pools.Pool<T> simple(int n, Factory<T> factory) {
        return FactoryPools.build(new Pools.SimplePool(n), factory);
    }

    public static <T extends Poolable> Pools.Pool<T> threadSafe(int n, Factory<T> factory) {
        return FactoryPools.build(new Pools.SynchronizedPool(n), factory);
    }

    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return FactoryPools.threadSafeList(20);
    }

    public static <T> Pools.Pool<List<T>> threadSafeList(int n) {
        return FactoryPools.build(new Pools.SynchronizedPool(n), new /* Unavailable Anonymous Inner Class!! */, new /* Unavailable Anonymous Inner Class!! */);
    }
}
