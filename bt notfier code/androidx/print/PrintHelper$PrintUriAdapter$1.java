/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.CancellationSignal
 *  android.os.CancellationSignal$OnCancelListener
 *  android.print.PrintAttributes
 *  android.print.PrintAttributes$MediaSize
 *  android.print.PrintDocumentAdapter$LayoutResultCallback
 *  android.print.PrintDocumentInfo
 *  android.print.PrintDocumentInfo$Builder
 *  androidx.print.PrintHelper
 *  androidx.print.PrintHelper$PrintUriAdapter
 */
package androidx.print;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import androidx.print.PrintHelper;
import java.io.FileNotFoundException;

/*
 * Exception performing whole class analysis ignored.
 */
class PrintHelper.PrintUriAdapter.1
extends AsyncTask<Uri, Boolean, Bitmap> {
    final PrintHelper.PrintUriAdapter this$1;
    final CancellationSignal val$cancellationSignal;
    final PrintDocumentAdapter.LayoutResultCallback val$layoutResultCallback;
    final PrintAttributes val$newPrintAttributes;
    final PrintAttributes val$oldPrintAttributes;

    PrintHelper.PrintUriAdapter.1(PrintHelper.PrintUriAdapter printUriAdapter, CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
        this.this$1 = printUriAdapter;
        this.val$cancellationSignal = cancellationSignal;
        this.val$newPrintAttributes = printAttributes;
        this.val$oldPrintAttributes = printAttributes2;
        this.val$layoutResultCallback = layoutResultCallback;
    }

    protected Bitmap doInBackground(Uri ... bitmap) {
        try {
            bitmap = this.this$1.this$0.loadConstrainedBitmap(this.this$1.mImageFile);
            return bitmap;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
    }

    protected void onCancelled(Bitmap bitmap) {
        this.val$layoutResultCallback.onLayoutCancelled();
        this.this$1.mLoadBitmap = null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void onPostExecute(Bitmap bitmap) {
        Bitmap bitmap2;
        block10: {
            PrintAttributes.MediaSize mediaSize;
            block11: {
                super.onPostExecute((Object)bitmap);
                bitmap2 = bitmap;
                if (bitmap == null) break block10;
                if (!PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION) break block11;
                bitmap2 = bitmap;
                if (this.this$1.this$0.mOrientation != 0) break block10;
            }
            synchronized (this) {
                mediaSize = this.this$1.mAttributes.getMediaSize();
            }
            bitmap2 = bitmap;
            if (mediaSize != null) {
                bitmap2 = bitmap;
                if (mediaSize.isPortrait() != PrintHelper.isPortrait((Bitmap)bitmap)) {
                    bitmap2 = new Matrix();
                    bitmap2.postRotate(90.0f);
                    bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)bitmap2, (boolean)true);
                }
            }
        }
        this.this$1.mBitmap = bitmap2;
        if (bitmap2 != null) {
            bitmap = new PrintDocumentInfo.Builder(this.this$1.mJobName).setContentType(1).setPageCount(1).build();
            boolean bl = this.val$newPrintAttributes.equals((Object)this.val$oldPrintAttributes);
            this.val$layoutResultCallback.onLayoutFinished((PrintDocumentInfo)bitmap, true ^ bl);
        } else {
            this.val$layoutResultCallback.onLayoutFailed(null);
        }
        this.this$1.mLoadBitmap = null;
    }

    protected void onPreExecute() {
        this.val$cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
    }
}
