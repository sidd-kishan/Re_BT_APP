/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Option$CacheKeyUpdater
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public final class Option<T> {
    private static final CacheKeyUpdater<Object> EMPTY_UPDATER = new /* Unavailable Anonymous Inner Class!! */;
    private final CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    private Option(String string, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        this.key = Preconditions.checkNotEmpty((String)string);
        this.defaultValue = t;
        this.cacheKeyUpdater = (CacheKeyUpdater)Preconditions.checkNotNull(cacheKeyUpdater);
    }

    public static <T> Option<T> disk(String string, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<Object>(string, null, cacheKeyUpdater);
    }

    public static <T> Option<T> disk(String string, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<T>(string, t, cacheKeyUpdater);
    }

    private static <T> CacheKeyUpdater<T> emptyUpdater() {
        return EMPTY_UPDATER;
    }

    private byte[] getKeyBytes() {
        if (this.keyBytes != null) return this.keyBytes;
        this.keyBytes = this.key.getBytes(Key.CHARSET);
        return this.keyBytes;
    }

    /*
     * Exception decompiling
     */
    public static <T> Option<T> memory(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.NullPointerException
         *     at org.benf.cfr.reader.bytecode.analysis.types.GenericTypeBinder.extractBaseBindings(GenericTypeBinder.java:125)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter$InnerExplicitTypeCallRewriter.rewriteFunctionInvokation(ExplicitTypeCallRewriter.java:37)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter$InnerExplicitTypeCallRewriter.rewriteExpression(ExplicitTypeCallRewriter.java:56)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExpressionRewriterHelper.applyForwards(ExpressionRewriterHelper.java:12)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractConstructorInvokation.applyExpressionRewriter(AbstractConstructorInvokation.java:65)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter.rewriteExpression(ExplicitTypeCallRewriter.java:73)
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

    /*
     * Exception decompiling
     */
    public static <T> Option<T> memory(String var0, T var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.NullPointerException
         *     at org.benf.cfr.reader.bytecode.analysis.types.GenericTypeBinder.extractBaseBindings(GenericTypeBinder.java:125)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter$InnerExplicitTypeCallRewriter.rewriteFunctionInvokation(ExplicitTypeCallRewriter.java:37)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter$InnerExplicitTypeCallRewriter.rewriteExpression(ExplicitTypeCallRewriter.java:56)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExpressionRewriterHelper.applyForwards(ExpressionRewriterHelper.java:12)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractConstructorInvokation.applyExpressionRewriter(AbstractConstructorInvokation.java:65)
         *     at org.benf.cfr.reader.bytecode.analysis.parse.rewriters.ExplicitTypeCallRewriter.rewriteExpression(ExplicitTypeCallRewriter.java:73)
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

    public boolean equals(Object object) {
        if (!(object instanceof Option)) return false;
        object = (Option)object;
        return this.key.equals(((Option)object).key);
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option{key='");
        stringBuilder.append(this.key);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void update(T t, MessageDigest messageDigest) {
        this.cacheKeyUpdater.update(this.getKeyBytes(), t, messageDigest);
    }
}
