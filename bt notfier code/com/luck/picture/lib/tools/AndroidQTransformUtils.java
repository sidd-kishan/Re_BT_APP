/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.StringUtils
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Source
 */
package com.luck.picture.lib.tools;

import android.content.Context;
import android.net.Uri;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.StringUtils;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class AndroidQTransformUtils {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public static String copyPathToAndroidQ(Context context, long l, String string, int n, int n2, String object, String string2) {
        Throwable throwable2222222;
        Context context2;
        block6: {
            block7: {
                block5: {
                    Context context3;
                    Context context4 = null;
                    context2 = context3 = null;
                    Context context5 = context4;
                    string = Uri.parse((String)string);
                    context2 = context3;
                    context5 = context4;
                    string2 = PictureFileUtils.createFilePath((Context)context, (String)StringUtils.getEncryptionValue((long)l, (int)n, (int)n2), (String)object, (String)string2);
                    context2 = context3;
                    context5 = context4;
                    context2 = context3;
                    context5 = context4;
                    object = new File(string2);
                    context2 = context3;
                    context5 = context4;
                    if (((File)object).exists()) {
                        return string2;
                    }
                    context2 = context3;
                    context5 = context4;
                    context2 = context = Okio.buffer((Source)Okio.source((InputStream)Objects.requireNonNull(context.getContentResolver().openInputStream((Uri)string))));
                    context5 = context;
                    boolean bl = PictureFileUtils.bufferCopy((BufferedSource)context, (File)object);
                    if (!bl) break block5;
                    if (context == null) return string2;
                    {
                        catch (Throwable throwable2222222) {
                            break block6;
                        }
                        catch (Exception exception) {}
                        context2 = context5;
                        {
                            exception.printStackTrace();
                            if (context5 == null) return "";
                        }
                        if (!context5.isOpen()) return "";
                        context = context5;
                        break block7;
                    }
                    if (!context.isOpen()) return string2;
                    PictureFileUtils.close((Closeable)context);
                    return string2;
                }
                if (context == null) return "";
                if (!context.isOpen()) return "";
            }
            PictureFileUtils.close((Closeable)context);
            return "";
        }
        if (context2 == null) throw throwable2222222;
        if (!context2.isOpen()) throw throwable2222222;
        PictureFileUtils.close(context2);
        throw throwable2222222;
    }

    public static boolean copyPathToDCIM(Context context, File file, Uri uri) {
        try {
            boolean bl = PictureFileUtils.bufferCopy((File)file, (OutputStream)context.getContentResolver().openOutputStream(uri));
            return bl;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
