/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.ParcelFileDescriptor
 *  android.print.PrintAttributes
 *  android.print.PrintAttributes$Builder
 *  android.print.PrintAttributes$Margins
 *  android.print.PrintAttributes$MediaSize
 *  android.print.PrintDocumentAdapter
 *  android.print.PrintDocumentAdapter$WriteResultCallback
 *  android.print.PrintManager
 *  android.util.Log
 *  androidx.print.PrintHelper$OnPrintFinishCallback
 *  androidx.print.PrintHelper$PrintBitmapAdapter
 *  androidx.print.PrintHelper$PrintUriAdapter
 */
package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.util.Log;
import androidx.print.PrintHelper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode = 2;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions = null;
    final Object mLock = new Object();
    int mOrientation = 1;
    int mScaleMode = 2;

    static {
        int n = Build.VERSION.SDK_INT;
        boolean bl = false;
        boolean bl2 = n < 20 || Build.VERSION.SDK_INT > 23;
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = bl2;
        bl2 = bl;
        if (Build.VERSION.SDK_INT != 23) {
            bl2 = true;
        }
        IS_MIN_MARGINS_HANDLING_CORRECT = bl2;
    }

    public PrintHelper(Context context) {
        this.mContext = context;
    }

    static Bitmap convertBitmapForColorMode(Bitmap bitmap, int n) {
        if (n != 1) {
            return bitmap;
        }
        Bitmap bitmap2 = Bitmap.createBitmap((int)bitmap.getWidth(), (int)bitmap.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return bitmap2;
    }

    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder builder = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            builder.setColorMode(printAttributes.getColorMode());
        }
        if (Build.VERSION.SDK_INT < 23) return builder;
        if (printAttributes.getDuplexMode() == 0) return builder;
        builder.setDuplexMode(printAttributes.getDuplexMode());
        return builder;
    }

    static Matrix getMatrix(int n, int n2, RectF rectF, int n3) {
        Matrix matrix = new Matrix();
        float f = rectF.width();
        float f2 = n;
        f /= f2;
        f = n3 == 2 ? Math.max(f, rectF.height() / (float)n2) : Math.min(f, rectF.height() / (float)n2);
        matrix.postScale(f, f);
        matrix.postTranslate((rectF.width() - f2 * f) / 2.0f, (rectF.height() - (float)n2 * f) / 2.0f);
        return matrix;
    }

    static boolean isPortrait(Bitmap bitmap) {
        boolean bl = bitmap.getWidth() <= bitmap.getHeight();
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    private Bitmap loadBitmap(Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        void var1_4;
        block8: {
            if (uri == null) throw new IllegalArgumentException("bad argument to loadBitmap");
            Object object = this.mContext;
            if (object == null) throw new IllegalArgumentException("bad argument to loadBitmap");
            Object var3_9 = null;
            try {
                object = object.getContentResolver().openInputStream(uri);
            }
            catch (Throwable throwable) {
                options = var3_9;
                break block8;
            }
            try {
                uri = BitmapFactory.decodeStream((InputStream)object, null, (BitmapFactory.Options)options);
                if (object == null) return uri;
            }
            catch (Throwable throwable) {
                options = object;
                break block8;
            }
            try {
                ((InputStream)object).close();
            }
            catch (IOException iOException) {
                Log.w((String)LOG_TAG, (String)"close fail ", (Throwable)iOException);
            }
            return uri;
        }
        if (options == null) throw var1_4;
        try {
            options.close();
        }
        catch (IOException iOException) {
            Log.w((String)LOG_TAG, (String)"close fail ", (Throwable)iOException);
        }
        throw var1_4;
    }

    public static boolean systemSupportsPrint() {
        boolean bl = Build.VERSION.SDK_INT >= 19;
        return bl;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        if (Build.VERSION.SDK_INT < 19) return this.mOrientation;
        if (this.mOrientation != 0) return this.mOrientation;
        return 1;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    Bitmap loadConstrainedBitmap(Uri object) throws FileNotFoundException {
        if (object != null && this.mContext != null) {
            BitmapFactory.Options options;
            Object object2 = new BitmapFactory.Options();
            object2.inJustDecodeBounds = true;
            this.loadBitmap((Uri)object, (BitmapFactory.Options)object2);
            int n = object2.outWidth;
            int n2 = object2.outHeight;
            if (n <= 0) return null;
            if (n2 <= 0) {
                return null;
            }
            int n3 = 1;
            for (int i = Math.max(n, n2); i > 3500; i >>>= 1, n3 <<= 1) {
            }
            if (n3 <= 0) return null;
            if (Math.min(n, n2) / n3 <= 0) {
                return null;
            }
            object2 = this.mLock;
            synchronized (object2) {
                this.mDecodeOptions = options = new BitmapFactory.Options();
                options.inMutable = true;
                this.mDecodeOptions.inSampleSize = n3;
                options = this.mDecodeOptions;
            }
            try {
                object2 = this.loadBitmap((Uri)object, options);
                return object2;
            }
            finally {
                object = this.mLock;
                synchronized (object) {
                    this.mDecodeOptions = null;
                }
            }
        }
        object = new IllegalArgumentException("bad argument to getScaledBitmap");
        throw object;
    }

    public void printBitmap(String string, Bitmap bitmap) {
        this.printBitmap(string, bitmap, null);
    }

    public void printBitmap(String string, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        if (Build.VERSION.SDK_INT < 19) return;
        if (bitmap == null) return;
        PrintManager printManager = (PrintManager)this.mContext.getSystemService("print");
        PrintAttributes.MediaSize mediaSize = PrintHelper.isPortrait(bitmap) ? PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        mediaSize = new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build();
        printManager.print(string, (PrintDocumentAdapter)new PrintBitmapAdapter(this, string, this.mScaleMode, bitmap, onPrintFinishCallback), (PrintAttributes)mediaSize);
    }

    public void printBitmap(String string, Uri uri) throws FileNotFoundException {
        this.printBitmap(string, uri, null);
    }

    public void printBitmap(String string, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        onPrintFinishCallback = new PrintUriAdapter(this, string, uri, onPrintFinishCallback, this.mScaleMode);
        PrintManager printManager = (PrintManager)this.mContext.getSystemService("print");
        uri = new PrintAttributes.Builder();
        uri.setColorMode(this.mColorMode);
        int n = this.mOrientation;
        if (n != 1 && n != 0) {
            if (n == 2) {
                uri.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
            }
        } else {
            uri.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        }
        printManager.print(string, (PrintDocumentAdapter)onPrintFinishCallback, uri.build());
    }

    public void setColorMode(int n) {
        this.mColorMode = n;
    }

    public void setOrientation(int n) {
        this.mOrientation = n;
    }

    public void setScaleMode(int n) {
        this.mScaleMode = n;
    }

    void writeBitmap(PrintAttributes printAttributes, int n, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        PrintAttributes printAttributes2 = IS_MIN_MARGINS_HANDLING_CORRECT ? printAttributes : PrintHelper.copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        new /* Unavailable Anonymous Inner Class!! */.execute((Object[])new Void[0]);
    }
}
