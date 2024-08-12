/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.os.CancellationSignal
 *  android.os.ParcelFileDescriptor
 *  android.print.PageRange
 *  android.print.PrintAttributes
 *  android.print.PrintDocumentAdapter
 *  android.print.PrintDocumentAdapter$LayoutResultCallback
 *  android.print.PrintDocumentAdapter$WriteResultCallback
 *  android.print.PrintDocumentInfo$Builder
 *  androidx.print.PrintHelper
 *  androidx.print.PrintHelper$OnPrintFinishCallback
 */
package androidx.print;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;

private class PrintHelper.PrintBitmapAdapter
extends PrintDocumentAdapter {
    private PrintAttributes mAttributes;
    private final Bitmap mBitmap;
    private final PrintHelper.OnPrintFinishCallback mCallback;
    private final int mFittingMode;
    private final String mJobName;
    final PrintHelper this$0;

    PrintHelper.PrintBitmapAdapter(PrintHelper printHelper, String string, int n, Bitmap bitmap, PrintHelper.OnPrintFinishCallback onPrintFinishCallback) {
        this.this$0 = printHelper;
        this.mJobName = string;
        this.mFittingMode = n;
        this.mBitmap = bitmap;
        this.mCallback = onPrintFinishCallback;
    }

    public void onFinish() {
        PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
        if (onPrintFinishCallback == null) return;
        onPrintFinishCallback.onFinish();
    }

    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        this.mAttributes = printAttributes2;
        layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), printAttributes2.equals((Object)printAttributes) ^ true);
    }

    public void onWrite(PageRange[] pageRangeArray, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
    }
}
