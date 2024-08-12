/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.core.content.ContextCompat
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.yalantis.ucrop.callback.BitmapLoadCallback
 *  com.yalantis.ucrop.model.ExifInfo
 *  com.yalantis.ucrop.task.BitmapLoadTask$BitmapWorkerResult
 *  com.yalantis.ucrop.util.BitmapLoadUtils
 *  com.yalantis.ucrop.util.FileUtils
 */
package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.task.BitmapLoadTask;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class BitmapLoadTask
extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final int MAX_BITMAP_SIZE = 0x6400000;
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final Context mContext;
    private Uri mInputUri;
    private final Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int n, int n2, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = n;
        this.mRequiredHeight = n2;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    private boolean checkSize(Bitmap bitmap, BitmapFactory.Options options) {
        int n = bitmap != null ? bitmap.getByteCount() : 0;
        if (n <= 0x6400000) return false;
        options.inSampleSize *= 2;
        return true;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private void copyFile(Uri object, Uri object2) throws NullPointerException, IOException {
        void var1_5;
        FileOutputStream fileOutputStream;
        block10: {
            FileOutputStream fileOutputStream2;
            InputStream inputStream;
            block9: {
                int n;
                Log.d((String)TAG, (String)"copyFile");
                if (object2 == null) {
                    object = new NullPointerException("Output Uri is null - cannot copy image");
                    throw object;
                }
                fileOutputStream = null;
                inputStream = this.mContext.getContentResolver().openInputStream(object);
                object = new File(object2.getPath());
                fileOutputStream2 = new FileOutputStream((File)object);
                if (inputStream == null) break block9;
                object = new byte[1024];
                while ((n = inputStream.read((byte[])object)) > 0) {
                    ((OutputStream)fileOutputStream2).write((byte[])object, 0, n);
                }
                BitmapLoadUtils.close((Closeable)fileOutputStream2);
                BitmapLoadUtils.close((Closeable)inputStream);
                this.mInputUri = this.mOutputUri;
                return;
            }
            try {
                object = new NullPointerException("InputStream for given input Uri is null");
                throw object;
            }
            catch (Throwable throwable) {
                fileOutputStream = fileOutputStream2;
                object2 = inputStream;
            }
            break block10;
            catch (Throwable throwable) {
                object2 = inputStream;
            }
            break block10;
            catch (Throwable throwable) {
                object2 = null;
            }
        }
        BitmapLoadUtils.close(fileOutputStream);
        BitmapLoadUtils.close((Closeable)object2);
        this.mInputUri = this.mOutputUri;
        throw var1_5;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private void downloadFile(Uri object, Uri object2) throws NullPointerException, IOException {
        void var2_12;
        Object object3;
        BufferedOutputStream bufferedOutputStream;
        block16: {
            void var6_28;
            Object object4;
            BufferedOutputStream bufferedOutputStream2;
            block15: {
                block17: {
                    Log.d((String)TAG, (String)"downloadFile");
                    if (object2 == null) {
                        object = new NullPointerException("Output Uri is null - cannot download image");
                        throw object;
                    }
                    bufferedOutputStream2 = null;
                    BufferedOutputStream bufferedOutputStream3 = null;
                    bufferedOutputStream = null;
                    BufferedOutputStream bufferedOutputStream4 = null;
                    object4 = new URL(object.toString());
                    byte[] byArray = new byte[1024];
                    object = new BufferedInputStream(((URL)object4).openStream());
                    OutputStream outputStream = this.mContext.getContentResolver().openOutputStream(object2);
                    object4 = object;
                    OutputStream outputStream2 = outputStream;
                    if (outputStream == null) break block15;
                    bufferedOutputStream = bufferedOutputStream3;
                    object3 = object;
                    OutputStream outputStream3 = outputStream;
                    bufferedOutputStream = bufferedOutputStream3;
                    object3 = object;
                    OutputStream outputStream4 = outputStream;
                    bufferedOutputStream2 = new BufferedOutputStream(outputStream);
                    try {
                        int n;
                        while ((n = ((FilterInputStream)object).read(byArray)) > -1) {
                            bufferedOutputStream2.write(byArray, 0, n);
                        }
                        bufferedOutputStream2.flush();
                        object4 = object;
                        OutputStream outputStream5 = outputStream;
                        break block15;
                    }
                    catch (Throwable throwable) {
                        bufferedOutputStream = bufferedOutputStream2;
                        object3 = object;
                        object = throwable;
                        break block16;
                    }
                    catch (Exception exception) {
                        object4 = object;
                        object = outputStream;
                        break block17;
                    }
                    catch (Exception exception) {
                        bufferedOutputStream2 = bufferedOutputStream4;
                        object4 = object;
                        object = outputStream;
                        break block17;
                    }
                    catch (Throwable throwable) {
                        bufferedOutputStream2 = null;
                        object3 = object;
                        object = throwable;
                        BufferedOutputStream bufferedOutputStream5 = bufferedOutputStream2;
                        break block16;
                    }
                    catch (Exception exception) {
                        Object var2_8 = null;
                        bufferedOutputStream2 = bufferedOutputStream4;
                        object4 = object;
                        object = var2_8;
                        break block17;
                    }
                    catch (Throwable throwable) {
                        Object var2_9 = null;
                        object3 = null;
                        break block16;
                    }
                    catch (Exception exception) {
                        object = null;
                        object4 = null;
                        bufferedOutputStream2 = bufferedOutputStream4;
                    }
                }
                bufferedOutputStream = bufferedOutputStream2;
                object3 = object4;
                Object object5 = object;
                try {
                    void var6_26;
                    var6_26.printStackTrace();
                    Object object6 = object;
                }
                catch (Throwable throwable) {
                    void var9_34;
                    void var2_11 = var9_34;
                }
            }
            this.mInputUri = this.mOutputUri;
            BitmapLoadUtils.close(bufferedOutputStream2);
            BitmapLoadUtils.close((Closeable)object4);
            BitmapLoadUtils.close((Closeable)var6_28);
            return;
        }
        this.mInputUri = this.mOutputUri;
        BitmapLoadUtils.close(bufferedOutputStream);
        BitmapLoadUtils.close((Closeable)object3);
        BitmapLoadUtils.close((Closeable)var2_12);
        throw object;
    }

    private String getFilePath() {
        if (ContextCompat.checkSelfPermission((Context)this.mContext, (String)"android.permission.READ_EXTERNAL_STORAGE") != 0) return "";
        return FileUtils.getPath((Context)this.mContext, (Uri)this.mInputUri);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    private void processInputUri() throws NullPointerException, IOException {
        void var1_7;
        String string = this.mInputUri.getScheme();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Uri scheme: ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (!"http".equals(string) && !"https".equals(string)) {
            if ("content".equals(string)) {
                void var1_4;
                string = this.getFilePath();
                if (!TextUtils.isEmpty((CharSequence)string) && new File(string).exists()) {
                    string = SdkVersionUtils.checkedAndroid_Q() ? this.mInputUri : Uri.fromFile((File)new File(string));
                    this.mInputUri = string;
                    return;
                }
                try {
                    this.copyFile(this.mInputUri, this.mOutputUri);
                    return;
                }
                catch (IOException iOException) {
                }
                catch (NullPointerException nullPointerException) {
                    // empty catch block
                }
                Log.e((String)TAG, (String)"Copying failed", (Throwable)var1_4);
                throw var1_4;
            }
            if ("file".equals(string)) {
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid Uri scheme ");
            stringBuilder.append(string);
            Log.e((String)TAG, (String)stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid Uri scheme");
            stringBuilder.append(string);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        try {
            this.downloadFile(this.mInputUri, this.mOutputUri);
            return;
        }
        catch (IOException iOException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        Log.e((String)TAG, (String)"Downloading failed", (Throwable)var1_7);
        throw var1_7;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    protected BitmapWorkerResult doInBackground(Void ... object) {
        int n;
        Bitmap bitmap;
        Object object2;
        int n2;
        BitmapFactory.Options options;
        block18: {
            void var1_6;
            if (this.mInputUri == null) {
                return new BitmapWorkerResult((Exception)new NullPointerException("Input Uri cannot be null"));
            }
            try {
                this.processInputUri();
            }
            catch (IOException iOException) {
                return new BitmapWorkerResult((Exception)var1_6);
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = BitmapLoadUtils.calculateInSampleSize((BitmapFactory.Options)options, (int)this.mRequiredWidth, (int)this.mRequiredHeight);
            n2 = 0;
            options.inJustDecodeBounds = false;
            object = null;
            break block18;
            return new BitmapWorkerResult((Exception)var1_6);
        }
        while (n2 == 0) {
            InputStream inputStream;
            block17: {
                object2 = object;
                inputStream = this.mContext.getContentResolver().openInputStream(this.mInputUri);
                bitmap = BitmapFactory.decodeStream((InputStream)inputStream, null, (BitmapFactory.Options)options);
                object = bitmap;
                if (options.outWidth == -1) break block17;
                object = bitmap;
                n = options.outHeight;
                if (n == -1) break block17;
                object2 = bitmap;
                {
                    catch (Throwable throwable) {
                        object2 = object;
                        BitmapLoadUtils.close((Closeable)inputStream);
                        object2 = object;
                        throw throwable;
                    }
                }
                BitmapLoadUtils.close((Closeable)inputStream);
                object2 = bitmap;
                boolean bl = this.checkSize(bitmap, options);
                if (bl) {
                    object = bitmap;
                    continue;
                }
                n2 = 1;
                object = bitmap;
                continue;
            }
            object = bitmap;
            object = bitmap;
            object = bitmap;
            object = bitmap;
            StringBuilder stringBuilder = new StringBuilder();
            object = bitmap;
            stringBuilder.append("Bounds for bitmap could not be retrieved from the Uri: [");
            object = bitmap;
            stringBuilder.append(this.mInputUri);
            object = bitmap;
            stringBuilder.append("]");
            object = bitmap;
            object2 = new IllegalArgumentException(stringBuilder.toString());
            object = bitmap;
            BitmapWorkerResult bitmapWorkerResult = new BitmapWorkerResult((Exception)object2);
            object2 = bitmap;
            try {
                BitmapLoadUtils.close((Closeable)inputStream);
                return bitmapWorkerResult;
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"doInBackground: ImageDecoder.createSource: ", (Throwable)iOException);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Bitmap could not be decoded from the Uri: [");
                ((StringBuilder)object2).append(this.mInputUri);
                ((StringBuilder)object2).append("]");
                return new BitmapWorkerResult((Exception)new IllegalArgumentException(((StringBuilder)object2).toString(), iOException));
            }
            catch (OutOfMemoryError outOfMemoryError) {
                Log.e((String)TAG, (String)"doInBackground: BitmapFactory.decodeFileDescriptor: ", (Throwable)outOfMemoryError);
                options.inSampleSize *= 2;
                object = object2;
            }
        }
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Bitmap could not be decoded from the Uri: [");
            ((StringBuilder)object).append(this.mInputUri);
            ((StringBuilder)object).append("]");
            return new BitmapWorkerResult((Exception)new IllegalArgumentException(((StringBuilder)object).toString()));
        }
        n = BitmapLoadUtils.getExifOrientation((Context)this.mContext, (Uri)this.mInputUri);
        n2 = BitmapLoadUtils.exifToDegrees((int)n);
        int n3 = BitmapLoadUtils.exifToTranslation((int)n);
        bitmap = new ExifInfo(n, n2, n3);
        object2 = new Matrix();
        if (n2 != 0) {
            object2.preRotate((float)n2);
        }
        if (n3 != 1) {
            object2.postScale((float)n3, 1.0f);
        }
        if (object2.isIdentity()) return new BitmapWorkerResult((Bitmap)object, (ExifInfo)bitmap);
        return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap((Bitmap)object, (Matrix)object2), (ExifInfo)bitmap);
    }

    protected void onPostExecute(BitmapWorkerResult object) {
        if (object.mBitmapWorkerException == null) {
            String string = this.mInputUri.toString();
            BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            Bitmap bitmap = object.mBitmapResult;
            ExifInfo exifInfo = object.mExifInfo;
            object = PictureMimeType.isContent((String)string) ? string : this.mInputUri.getPath();
            string = this.mOutputUri;
            string = string == null ? null : string.getPath();
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, (String)object, string);
        } else {
            this.mBitmapLoadCallback.onFailure(object.mBitmapWorkerException);
        }
    }
}
