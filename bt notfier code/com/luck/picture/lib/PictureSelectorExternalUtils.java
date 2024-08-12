/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.ExifInterface
 *  android.net.Uri
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 */
package com.luck.picture.lib;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import java.io.Closeable;
import java.io.InputStream;

public class PictureSelectorExternalUtils {
    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static ExifInterface getExifInterface(Context object, String object2) {
        void var0_7;
        Object object3;
        block11: {
            void var0_4;
            Object object4;
            block10: {
                block9: {
                    block8: {
                        object4 = null;
                        Object var3_13 = null;
                        if (!SdkVersionUtils.checkedAndroid_Q() || !PictureMimeType.isContent((String)object3)) break block8;
                        InputStream inputStream = object.getContentResolver().openInputStream(Uri.parse((String)object3));
                        object3 = var3_13;
                        object4 = inputStream;
                        if (inputStream == null) break block9;
                        object3 = inputStream;
                        try {
                            object4 = new ExifInterface(inputStream);
                            object3 = object4;
                            object4 = inputStream;
                            break block9;
                        }
                        catch (Exception exception) {
                            break block10;
                        }
                    }
                    try {
                        object3 = new ExifInterface((String)object3);
                        object4 = null;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2 = object4;
                        break block11;
                    }
                    catch (Exception exception) {
                        Object var0_3 = null;
                    }
                }
                PictureFileUtils.close((Closeable)object4);
                return object3;
            }
            object3 = var0_4;
            try {
                ((Throwable)object4).printStackTrace();
            }
            catch (Throwable throwable) {
                object4 = object3;
                object3 = throwable;
                Throwable throwable3 = object4;
            }
            PictureFileUtils.close((Closeable)var0_4);
            return null;
        }
        PictureFileUtils.close((Closeable)var0_7);
        throw object3;
    }
}
