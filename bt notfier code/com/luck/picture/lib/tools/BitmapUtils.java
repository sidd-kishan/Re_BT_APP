/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Matrix
 *  android.net.Uri
 *  androidx.exifinterface.media.ExifInterface
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.tools.PictureFileUtils
 */
package com.luck.picture.lib.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BitmapUtils {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static int readPictureDegree(Context object, String string) {
        Throwable throwable222222;
        int n;
        Object object2;
        Object object3;
        block9: {
            block6: {
                block7: {
                    block8: {
                        Object object4 = null;
                        Object object5 = null;
                        Object var5_6 = null;
                        object3 = object4;
                        object2 = object5;
                        if (PictureMimeType.isContent((String)string)) {
                            object3 = object4;
                            object2 = object5;
                            object3 = object = object.getContentResolver().openInputStream(Uri.parse((String)string));
                            object2 = object;
                            object3 = object;
                            object2 = object;
                            string = new ExifInterface((InputStream)object);
                        } else {
                            object3 = object4;
                            object2 = object5;
                            string = new ExifInterface(string);
                            object = var5_6;
                        }
                        object3 = object;
                        object2 = object;
                        n = string.getAttributeInt("Orientation", 1);
                        if (n == 3) break block6;
                        if (n == 6) break block7;
                        if (n == 8) break block8;
                        PictureFileUtils.close((Closeable)object);
                        return 0;
                    }
                    n = 270;
                    break block9;
                }
                n = 90;
                break block9;
            }
            n = 180;
        }
        PictureFileUtils.close((Closeable)object);
        return n;
        {
            catch (Throwable throwable222222) {
            }
            catch (Exception exception) {}
            object3 = object2;
            {
                exception.printStackTrace();
            }
            PictureFileUtils.close(object2);
            return 0;
        }
        PictureFileUtils.close(object3);
        throw throwable222222;
    }

    public static void rotateImage(Context object, boolean bl, String string) {
        if (!bl) return;
        try {
            int n = BitmapUtils.readPictureDegree((Context)object, string);
            if (n <= 0) return;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            object = new File(string);
            if ((string = BitmapUtils.rotatingImage(BitmapFactory.decodeFile((String)((File)object).getAbsolutePath(), (BitmapFactory.Options)options), n)) == null) return;
            BitmapUtils.saveBitmapFile((Bitmap)string, (File)object);
            string.recycle();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Bitmap rotatingImage(Bitmap bitmap, int n) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float)n);
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (Matrix)matrix, (boolean)true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private static void saveBitmapFile(Bitmap object, File file) {
        void var0_3;
        Object object2;
        block7: {
            block8: {
                BufferedOutputStream bufferedOutputStream;
                Bitmap bitmap;
                Object var4_8 = null;
                object2 = bitmap = null;
                try {
                    object2 = bitmap;
                    object2 = bitmap;
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    object2 = bitmap;
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                }
                catch (Throwable throwable) {
                    break block7;
                }
                catch (Exception exception) {
                    object = var4_8;
                    break block8;
                }
                try {
                    object.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)bufferedOutputStream);
                    bufferedOutputStream.flush();
                }
                catch (Throwable throwable) {
                    object2 = bufferedOutputStream;
                    break block7;
                }
                catch (Exception exception) {
                    object = bufferedOutputStream;
                    break block8;
                }
                PictureFileUtils.close((Closeable)bufferedOutputStream);
                return;
            }
            object2 = object;
            {
                void var1_7;
                var1_7.printStackTrace();
            }
            PictureFileUtils.close((Closeable)object);
            return;
        }
        PictureFileUtils.close(object2);
        throw var0_3;
    }
}
