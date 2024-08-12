/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
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
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;

private class PrintHelper.PrintUriAdapter
extends PrintDocumentAdapter {
    PrintAttributes mAttributes;
    Bitmap mBitmap;
    final PrintHelper.OnPrintFinishCallback mCallback;
    final int mFittingMode;
    final Uri mImageFile;
    final String mJobName;
    AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
    final PrintHelper this$0;

    PrintHelper.PrintUriAdapter(PrintHelper printHelper, String string, Uri uri, PrintHelper.OnPrintFinishCallback onPrintFinishCallback, int n) {
        this.this$0 = printHelper;
        this.mJobName = string;
        this.mImageFile = uri;
        this.mCallback = onPrintFinishCallback;
        this.mFittingMode = n;
        this.mBitmap = null;
    }

    void cancelLoad() {
        Object object = this.this$0.mLock;
        synchronized (object) {
            if (this.this$0.mDecodeOptions == null) return;
            if (Build.VERSION.SDK_INT < 24) {
                this.this$0.mDecodeOptions.requestCancelDecode();
            }
            this.this$0.mDecodeOptions = null;
            return;
        }
    }

    public void onFinish() {
        super.onFinish();
        this.cancelLoad();
        PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.mLoadBitmap;
        if (onPrintFinishCallback != null) {
            onPrintFinishCallback.cancel(true);
        }
        if ((onPrintFinishCallback = this.mCallback) != null) {
            onPrintFinishCallback.onFinish();
        }
        if ((onPrintFinishCallback = this.mBitmap) == null) return;
        onPrintFinishCallback.recycle();
        this.mBitmap = null;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        // MONITORENTER : this
        this.mAttributes = printAttributes2;
        // MONITOREXIT : this
        if (cancellationSignal.isCanceled()) {
            layoutResultCallback.onLayoutCancelled();
            return;
        }
        if (this.mBitmap != null) {
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), printAttributes2.equals((Object)printAttributes) ^ true);
            return;
        }
        this.mLoadBitmap = new /* Unavailable Anonymous Inner Class!! */.execute((Object[])new Uri[0]);
    }

    public void onWrite(PageRange[] pageRangeArray, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
    }
}
