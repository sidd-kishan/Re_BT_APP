/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 *  androidx.camera.core.ImageCapture$OutputFileResults
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImageSaver$1
 *  androidx.camera.core.ImageSaver$OnImageSavedCallback
 *  androidx.camera.core.ImageSaver$SaveError
 *  androidx.camera.core.Logger
 *  androidx.camera.core._$$Lambda$ImageSaver$AirN55SwcszagHg1aVwvl21IDMo
 *  androidx.camera.core._$$Lambda$ImageSaver$HfQA6xPBRLNQ0BpfzYalLScwgm8
 *  androidx.camera.core._$$Lambda$ImageSaver$cLMwDiHvEkallNeVcmwbWTEzfGw
 *  androidx.camera.core.impl.utils.Exif
 *  androidx.camera.core.internal.compat.workaround.ExifRotationAvailability
 *  androidx.camera.core.internal.utils.ImageUtil
 *  androidx.camera.core.internal.utils.ImageUtil$CodecFailedException
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageSaver;
import androidx.camera.core.Logger;
import androidx.camera.core._$;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class ImageSaver
implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private final OnImageSavedCallback mCallback;
    private final ImageProxy mImage;
    private final int mOrientation;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final Executor mSequentialIoExecutor;
    private final Executor mUserCallbackExecutor;

    ImageSaver(ImageProxy imageProxy, ImageCapture.OutputFileOptions outputFileOptions, int n, Executor executor, Executor executor2, OnImageSavedCallback onImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = n;
        this.mCallback = onImageSavedCallback;
        this.mUserCallbackExecutor = executor;
        this.mSequentialIoExecutor = executor2;
    }

    private void copyTempFileToOutputStream(File object, OutputStream outputStream) throws IOException {
        object = new FileInputStream((File)object);
        try {
            int n;
            byte[] byArray = new byte[1024];
            while ((n = ((InputStream)object).read(byArray)) > 0) {
                outputStream.write(byArray, 0, n);
            }
            return;
        }
        finally {
            ((InputStream)object).close();
        }
    }

    private boolean copyTempFileToUri(File file, Uri object) throws IOException {
        object = this.mOutputFileOptions.getContentResolver().openOutputStream((Uri)object);
        if (object == null) {
            if (object == null) return false;
            ((OutputStream)object).close();
            return false;
        }
        try {
            this.copyTempFileToOutputStream(file, (OutputStream)object);
            return true;
        }
        finally {
            if (object != null) {
                ((OutputStream)object).close();
            }
        }
    }

    private boolean isSaveToFile() {
        boolean bl = this.mOutputFileOptions.getFile() != null;
        return bl;
    }

    private boolean isSaveToMediaStore() {
        boolean bl = this.mOutputFileOptions.getSaveCollection() != null && this.mOutputFileOptions.getContentResolver() != null && this.mOutputFileOptions.getContentValues() != null;
        return bl;
    }

    private boolean isSaveToOutputStream() {
        boolean bl = this.mOutputFileOptions.getOutputStream() != null;
        return bl;
    }

    private void postError(SaveError saveError, String string, Throwable throwable) {
        try {
            Executor executor = this.mUserCallbackExecutor;
            _$.Lambda.ImageSaver.cLMwDiHvEkallNeVcmwbWTEzfGw cLMwDiHvEkallNeVcmwbWTEzfGw2 = new _$.Lambda.ImageSaver.cLMwDiHvEkallNeVcmwbWTEzfGw(this, saveError, string, throwable);
            executor.execute((Runnable)cLMwDiHvEkallNeVcmwbWTEzfGw2);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            Logger.e((String)TAG, (String)"Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
        }
    }

    private void postSuccess(Uri uri) {
        try {
            Executor executor = this.mUserCallbackExecutor;
            _$.Lambda.ImageSaver.HfQA6xPBRLNQ0BpfzYalLScwgm8 hfQA6xPBRLNQ0BpfzYalLScwgm8 = new _$.Lambda.ImageSaver.HfQA6xPBRLNQ0BpfzYalLScwgm8(this, uri);
            executor.execute((Runnable)hfQA6xPBRLNQ0BpfzYalLScwgm8);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            Logger.e((String)TAG, (String)"Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private File saveImageToTempFile() {
        Exif exif;
        File file;
        Object object;
        String string;
        block29: {
            block28: {
                block27: {
                    try {
                        boolean bl = this.isSaveToFile();
                        if (bl) {
                            string = this.mOutputFileOptions.getFile().getParent();
                            object = new StringBuilder();
                            ((StringBuilder)object).append(TEMP_FILE_PREFIX);
                            ((StringBuilder)object).append(UUID.randomUUID().toString());
                            ((StringBuilder)object).append(TEMP_FILE_SUFFIX);
                            file = new File(string, ((StringBuilder)object).toString());
                            break block27;
                        }
                        file = File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
                    }
                    catch (IOException iOException) {
                        this.postError(SaveError.FILE_IO_FAILED, "Failed to create temp file", iOException);
                        return null;
                    }
                }
                string = this.mImage;
                object = new FileOutputStream(file);
                ((FileOutputStream)object).write(ImageUtil.imageToJpegByteArray((ImageProxy)this.mImage));
                exif = Exif.createFromFile((File)file);
                exif.attachTimestamp();
                Object object2 = new ExifRotationAvailability();
                if (object2.shouldUseExifOrientation(this.mImage)) {
                    Object object3 = this.mImage.getPlanes()[0].getBuffer();
                    ((Buffer)object3).rewind();
                    object2 = new byte[((Buffer)object3).capacity()];
                    ((ByteBuffer)object3).get((byte[])object2);
                    object3 = new ByteArrayInputStream((byte[])object2);
                    exif.setOrientation(Exif.createFromInputStream((InputStream)object3).getOrientation());
                } else {
                    exif.rotate(this.mOrientation);
                }
                object2 = this.mOutputFileOptions.getMetadata();
                if (object2.isReversedHorizontal()) {
                    exif.flipHorizontally();
                }
                if (object2.isReversedVertical()) {
                    exif.flipVertically();
                }
                if (object2.getLocation() != null) {
                    exif.attachLocation(this.mOutputFileOptions.getMetadata().getLocation());
                }
                exif.save();
                ((FileOutputStream)object).close();
                if (string == null) break block28;
                string.close();
            }
            exif = null;
            string = null;
            object = string;
            break block29;
            catch (Throwable throwable) {
                try {
                    ((FileOutputStream)object).close();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    try {
                        throwable.addSuppressed(throwable2);
                        throw throwable;
                    }
                    catch (Throwable throwable3) {
                        if (string == null) throw throwable3;
                        try {
                            string.close();
                            throw throwable3;
                        }
                        catch (Throwable throwable4) {
                            try {
                                throwable3.addSuppressed(throwable4);
                                throw throwable3;
                            }
                            catch (ImageUtil.CodecFailedException codecFailedException) {
                                int n = 1.$SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[codecFailedException.getFailureType().ordinal()];
                                if (n != 1) {
                                    if (n != 2) {
                                        string = SaveError.UNKNOWN;
                                        object = "Failed to transcode mImage";
                                        break block29;
                                    } else {
                                        string = SaveError.CROP_FAILED;
                                        object = "Failed to crop mImage";
                                    }
                                    break block29;
                                }
                                string = SaveError.ENCODE_FAILED;
                                object = "Failed to encode mImage";
                                break block29;
                            }
                            catch (IllegalArgumentException illegalArgumentException) {
                            }
                            catch (IOException iOException) {
                                // empty catch block
                            }
                        }
                    }
                }
            }
            string = SaveError.FILE_IO_FAILED;
            object = "Failed to write temp file";
        }
        if (string == null) return file;
        this.postError((SaveError)string, (String)object, (Throwable)exif);
        file.delete();
        return null;
    }

    private void setContentValuePending(ContentValues contentValues, int n) {
        if (Build.VERSION.SDK_INT < 29) return;
        contentValues.put("is_pending", Integer.valueOf(n));
    }

    private void setUriNotPending(Uri uri) {
        if (Build.VERSION.SDK_INT < 29) return;
        ContentValues contentValues = new ContentValues();
        this.setContentValuePending(contentValues, 0);
        this.mOutputFileOptions.getContentResolver().update(uri, contentValues, null, null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    void copyTempFileToDestination(File var1_1) {
        block18: {
            block20: {
                block21: {
                    block19: {
                        block17: {
                            Preconditions.checkNotNull((Object)var1_1);
                            var5_2 = null;
                            try {
                                if (!this.isSaveToMediaStore()) ** GOTO lbl-1000
                                var2_5 = this.mOutputFileOptions.getContentValues() != null ? new ContentValues(this.mOutputFileOptions.getContentValues()) : new ContentValues();
                                this.setContentValuePending((ContentValues)var2_5, 1);
                                var4_9 = this.mOutputFileOptions.getContentResolver().insert(this.mOutputFileOptions.getSaveCollection(), (ContentValues)var2_5);
                                if (var4_9 == null) {
                                    break block17;
                                }
                                ** GOTO lbl25
                            }
                            catch (Throwable var2_6) {
                                break block18;
                            }
                            catch (IllegalArgumentException var2_7) {
                                break block19;
                            }
                            catch (IOException var2_8) {
                                // empty catch block
                                break block19;
                            }
                        }
                        try {
                            var2_5 = SaveError.FILE_IO_FAILED;
                            var3_10 = "Failed to insert URI.";
                            break block20;
lbl25:
                            // 1 sources

                            if (!this.copyTempFileToUri(var1_1, var4_9)) {
                                var2_5 = SaveError.FILE_IO_FAILED;
                                var3_10 = "Failed to save to URI.";
                            } else {
                                var2_5 = null;
                                var3_10 = null;
                            }
                            this.setUriNotPending(var4_9);
                            break block20;
                        }
                        catch (IllegalArgumentException var5_3) {
                            break block21;
                        }
                        catch (IOException var5_4) {
                            break block21;
                        }
lbl-1000:
                        // 1 sources

                        {
                            block22: {
                                if (!this.isSaveToOutputStream()) break block22;
                                this.copyTempFileToOutputStream(var1_1, this.mOutputFileOptions.getOutputStream());
                                ** GOTO lbl-1000
                            }
                            if (!this.isSaveToFile()) ** GOTO lbl-1000
                            var2_5 = this.mOutputFileOptions.getFile();
                            if (var2_5.exists()) {
                                var2_5.delete();
                            }
                            if (!var1_1.renameTo((File)var2_5)) {
                                var2_5 = SaveError.FILE_IO_FAILED;
                                var3_10 = "Failed to rename file.";
                                var4_9 = null;
                            } else lbl-1000:
                            // 3 sources

                            {
                                var4_9 = null;
                                var3_10 = var2_5 = null;
                            }
                            break block20;
                        }
                    }
                    var4_9 = null;
                    var5_2 = var2_5;
                }
                var2_5 = SaveError.FILE_IO_FAILED;
                var3_10 = "Failed to write destination file.";
            }
            var1_1.delete();
            if (var2_5 != null) {
                this.postError((SaveError)var2_5, (String)var3_10, var5_2);
            } else {
                this.postSuccess(var4_9);
            }
            return;
        }
        var1_1.delete();
        throw var2_6;
    }

    public /* synthetic */ void lambda$postError$2$ImageSaver(SaveError saveError, String string, Throwable throwable) {
        this.mCallback.onError(saveError, string, throwable);
    }

    public /* synthetic */ void lambda$postSuccess$1$ImageSaver(Uri uri) {
        this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
    }

    public /* synthetic */ void lambda$run$0$ImageSaver(File file) {
        this.copyTempFileToDestination(file);
    }

    @Override
    public void run() {
        File file = this.saveImageToTempFile();
        if (file == null) return;
        this.mSequentialIoExecutor.execute((Runnable)new _$.Lambda.ImageSaver.AirN55SwcszagHg1aVwvl21IDMo(this, file));
    }
}
