/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.compress.InputStreamProvider
 */
package com.luck.picture.lib.compress;

import com.luck.picture.lib.compress.InputStreamProvider;
import java.io.IOException;
import java.io.InputStream;

public abstract class InputStreamAdapter
implements InputStreamProvider {
    private InputStream inputStream;

    /*
     * Exception decompiling
     */
    public void close() {
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

    public InputStream open() throws IOException {
        InputStream inputStream;
        this.close();
        this.inputStream = inputStream = this.openInternal();
        return inputStream;
    }

    public abstract InputStream openInternal() throws IOException;
}
