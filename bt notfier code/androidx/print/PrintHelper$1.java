/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.AsyncTask
 *  android.os.CancellationSignal
 *  android.os.ParcelFileDescriptor
 *  android.print.PageRange
 *  android.print.PrintAttributes
 *  android.print.PrintDocumentAdapter$WriteResultCallback
 *  android.util.Log
 *  androidx.print.PrintHelper
 */
package androidx.print;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.util.Log;
import androidx.print.PrintHelper;

class PrintHelper.1
extends AsyncTask<Void, Void, Throwable> {
    final PrintHelper this$0;
    final PrintAttributes val$attributes;
    final Bitmap val$bitmap;
    final CancellationSignal val$cancellationSignal;
    final ParcelFileDescriptor val$fileDescriptor;
    final int val$fittingMode;
    final PrintAttributes val$pdfAttributes;
    final PrintDocumentAdapter.WriteResultCallback val$writeResultCallback;

    PrintHelper.1(PrintHelper printHelper, CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int n, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.this$0 = printHelper;
        this.val$cancellationSignal = cancellationSignal;
        this.val$pdfAttributes = printAttributes;
        this.val$bitmap = bitmap;
        this.val$attributes = printAttributes2;
        this.val$fittingMode = n;
        this.val$fileDescriptor = parcelFileDescriptor;
        this.val$writeResultCallback = writeResultCallback;
    }

    /*
     * Exception decompiling
     */
    protected Throwable doInBackground(Void ... var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    protected void onPostExecute(Throwable throwable) {
        if (this.val$cancellationSignal.isCanceled()) {
            this.val$writeResultCallback.onWriteCancelled();
        } else if (throwable == null) {
            this.val$writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
        } else {
            Log.e((String)"PrintHelper", (String)"Error writing printed content", (Throwable)throwable);
            this.val$writeResultCallback.onWriteFailed(null);
        }
    }
}
