/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.util.Log
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.yalantis.ucrop.util;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.Locale;

public class FileUtils {
    private static final String TAG = "FileUtils";

    private FileUtils() {
    }

    /*
     * WARNING - void declaration
     */
    public static void copyFile(String object, String object2) throws IOException {
        void var1_4;
        Object object3;
        block6: {
            block7: {
                Object object4;
                Object object5;
                if (((String)object).equalsIgnoreCase((String)object2)) {
                    return;
                }
                object3 = null;
                Object var4_6 = null;
                try {
                    object5 = new File((String)object);
                    object4 = new FileInputStream((File)object5);
                    object5 = ((FileInputStream)object4).getChannel();
                    object = var4_6;
                }
                catch (Throwable throwable) {
                    object = null;
                    break block6;
                }
                try {
                    object = var4_6;
                    object = var4_6;
                    object4 = new File((String)object2);
                    object = var4_6;
                    object3 = new FileOutputStream((File)object4);
                    object = var4_6;
                    object = object2 = ((FileOutputStream)object3).getChannel();
                    ((FileChannel)object5).transferTo(0L, ((FileChannel)object5).size(), (WritableByteChannel)object2);
                    object = object2;
                    ((AbstractInterruptibleChannel)object5).close();
                    if (object5 == null) break block7;
                }
                catch (Throwable throwable) {
                    object3 = object5;
                    break block6;
                }
                ((AbstractInterruptibleChannel)object5).close();
            }
            if (object2 == null) return;
            ((AbstractInterruptibleChannel)object2).close();
            return;
        }
        if (object3 != null) {
            ((AbstractInterruptibleChannel)object3).close();
        }
        if (object == null) throw var1_4;
        ((AbstractInterruptibleChannel)object).close();
        throw var1_4;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean copyFile(FileInputStream fileInputStream, String object) throws IOException {
        FileChannel fileChannel;
        Object object2;
        block11: {
            void var1_6;
            Object object3;
            block10: {
                FileChannel fileChannel2;
                if (fileInputStream == null) {
                    return false;
                }
                AbstractInterruptibleChannel abstractInterruptibleChannel = null;
                object3 = null;
                Object object4 = null;
                AbstractInterruptibleChannel abstractInterruptibleChannel2 = null;
                try {
                    fileChannel2 = fileInputStream.getChannel();
                    object3 = abstractInterruptibleChannel2;
                    object2 = abstractInterruptibleChannel;
                }
                catch (Throwable throwable) {
                    object2 = null;
                    break block10;
                }
                catch (Exception exception) {
                    object2 = null;
                    fileChannel = object4;
                    break block11;
                }
                try {
                    object3 = abstractInterruptibleChannel2;
                    object2 = abstractInterruptibleChannel;
                    object3 = abstractInterruptibleChannel2;
                    object2 = abstractInterruptibleChannel;
                    object4 = new File((String)object);
                    object3 = abstractInterruptibleChannel2;
                    object2 = abstractInterruptibleChannel;
                    FileOutputStream fileOutputStream = new FileOutputStream((File)object4);
                    object3 = abstractInterruptibleChannel2;
                    object2 = abstractInterruptibleChannel;
                    object3 = object = fileOutputStream.getChannel();
                    object2 = object;
                    fileChannel2.transferTo(0L, fileChannel2.size(), (WritableByteChannel)object);
                    object3 = object;
                    object2 = object;
                    fileChannel2.close();
                }
                catch (Throwable throwable) {
                    object2 = object3;
                    object3 = fileChannel2;
                    break block10;
                }
                catch (Exception exception) {
                    fileChannel = fileChannel2;
                    break block11;
                }
                fileInputStream.close();
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (object == null) return true;
                ((AbstractInterruptibleChannel)object).close();
                return true;
            }
            fileInputStream.close();
            if (object3 != null) {
                ((AbstractInterruptibleChannel)object3).close();
            }
            if (object2 == null) throw var1_6;
            ((AbstractInterruptibleChannel)object2).close();
            throw var1_6;
        }
        fileInputStream.close();
        if (fileChannel != null) {
            fileChannel.close();
        }
        if (object2 == null) return false;
        ((AbstractInterruptibleChannel)object2).close();
        return false;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static String getDataColumn(Context context, Uri uri, String string, String[] stringArray) {
        void var0_3;
        block9: {
            block10: {
                block8: {
                    Object var4_10;
                    block7: {
                        var4_10 = null;
                        context = context.getContentResolver().query(uri, new String[]{"_data"}, string, stringArray, null);
                        if (context == null) break block7;
                        uri = context;
                        try {
                            if (!context.moveToFirst()) break block7;
                            uri = context;
                            string = context.getString(context.getColumnIndexOrThrow("_data"));
                            if (context == null) return string;
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            break block8;
                        }
                        context.close();
                        return string;
                    }
                    if (context == null) return null;
                    break block10;
                    catch (Throwable throwable) {
                        uri = var4_10;
                        break block9;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        context = null;
                    }
                }
                uri = context;
                try {
                    void var2_8;
                    Log.i((String)TAG, (String)String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", var2_8.getMessage()));
                    if (context == null) return null;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            context.close();
            return null;
        }
        if (uri == null) throw var0_3;
        uri.close();
        throw var0_3;
    }

    public static String getPath(Context object, Uri object2) {
        boolean bl = Build.VERSION.SDK_INT >= 19;
        Object var3_4 = null;
        if (bl && DocumentsContract.isDocumentUri((Context)object, (Uri)object2)) {
            if (FileUtils.isExternalStorageDocument((Uri)object2)) {
                object = DocumentsContract.getDocumentId((Uri)object2).split(":");
                if (!"primary".equalsIgnoreCase(object[0])) return "";
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(Environment.getExternalStorageDirectory());
                ((StringBuilder)object2).append("/");
                ((StringBuilder)object2).append(object[1]);
                return ((StringBuilder)object2).toString();
            }
            if (FileUtils.isDownloadsDocument((Uri)object2)) {
                if (TextUtils.isEmpty((CharSequence)(object2 = DocumentsContract.getDocumentId((Uri)object2)))) return "";
                try {
                    object = FileUtils.getDataColumn((Context)object, ContentUris.withAppendedId((Uri)Uri.parse((String)"content://downloads/public_downloads"), (long)ValueOf.toLong((Object)object2)), null, null);
                    return object;
                }
                catch (NumberFormatException numberFormatException) {
                    Log.i((String)TAG, (String)numberFormatException.getMessage());
                    return "";
                }
            }
            if (!FileUtils.isMediaDocument((Uri)object2)) return "";
            String[] stringArray = DocumentsContract.getDocumentId((Uri)object2).split(":");
            String string = stringArray[0];
            if ("image".equals(string)) {
                object2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(string)) {
                object2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                object2 = var3_4;
                if (!"audio".equals(string)) return FileUtils.getDataColumn((Context)object, (Uri)object2, "_id=?", new String[]{stringArray[1]});
                object2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return FileUtils.getDataColumn((Context)object, (Uri)object2, "_id=?", new String[]{stringArray[1]});
        }
        if ("content".equalsIgnoreCase(object2.getScheme())) {
            if (!FileUtils.isGooglePhotosUri((Uri)object2)) return FileUtils.getDataColumn((Context)object, (Uri)object2, null, null);
            return object2.getLastPathSegment();
        }
        if (!"file".equalsIgnoreCase(object2.getScheme())) return "";
        return object2.getPath();
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static String rename(String string) {
        String string2 = string.substring(0, string.lastIndexOf("."));
        string = string.substring(string.lastIndexOf("."));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("_");
        stringBuilder.append(DateUtils.getCreateFileName());
        stringBuilder.append(string);
        return stringBuilder.toString();
    }
}
