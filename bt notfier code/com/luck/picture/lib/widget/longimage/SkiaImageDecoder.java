/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.luck.picture.lib.tools.ValueOf
 *  com.luck.picture.lib.widget.longimage.ImageDecoder
 */
package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.longimage.ImageDecoder;
import java.io.InputStream;

public class SkiaImageDecoder
implements ImageDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public Bitmap decode(Context context, Uri object) throws Exception {
        block10: {
            int n;
            BitmapFactory.Options options;
            block13: {
                void var1_4;
                int n2;
                block16: {
                    Object var7_12;
                    block15: {
                        String string;
                        block14: {
                            block11: {
                                int n3;
                                block12: {
                                    string = object.toString();
                                    options = new BitmapFactory.Options();
                                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                                    if (!string.startsWith(RESOURCE_PREFIX)) break block11;
                                    string = object.getAuthority();
                                    Resources resources = context.getPackageName().equals(string) ? context.getResources() : context.getPackageManager().getResourcesForApplication(string);
                                    object = object.getPathSegments();
                                    n3 = object.size();
                                    n2 = 0;
                                    if (n3 != 2 || !((String)object.get(0)).equals("drawable")) break block12;
                                    n = resources.getIdentifier((String)object.get(1), "drawable", string);
                                    break block13;
                                }
                                n = n2;
                                if (n3 != 1) break block13;
                                n = n2;
                                if (!TextUtils.isDigitsOnly((CharSequence)((CharSequence)object.get(0)))) break block13;
                                n = ValueOf.toInt(object.get(0));
                            }
                            boolean bl = string.startsWith(ASSET_PREFIX);
                            var7_12 = null;
                            if (!bl) break block14;
                            object = string.substring(22);
                            context = BitmapFactory.decodeStream((InputStream)context.getAssets().open((String)object), null, (BitmapFactory.Options)options);
                            break block10;
                        }
                        if (!string.startsWith(FILE_PREFIX)) break block15;
                        context = BitmapFactory.decodeFile((String)string.substring(7), (BitmapFactory.Options)options);
                        break block10;
                    }
                    object = context.getContentResolver().openInputStream((Uri)object);
                    try {
                        context = BitmapFactory.decodeStream((InputStream)object, null, (BitmapFactory.Options)options);
                        if (object == null) break block10;
                    }
                    catch (Throwable throwable) {}
                    try {
                        ((InputStream)object).close();
                        break block10;
                    }
                    catch (Exception exception) {}
                    break block16;
                    catch (Throwable throwable) {
                        object = var7_12;
                    }
                }
                if (object == null) throw var1_4;
                try {
                    ((InputStream)object).close();
                }
                catch (Exception exception) {
                    throw var1_4;
                }
                throw var1_4;
                catch (NumberFormatException numberFormatException) {
                    n = n2;
                }
            }
            context = BitmapFactory.decodeResource((Resources)context.getResources(), (int)n, (BitmapFactory.Options)options);
        }
        if (context == null) throw new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
        return context;
    }
}
