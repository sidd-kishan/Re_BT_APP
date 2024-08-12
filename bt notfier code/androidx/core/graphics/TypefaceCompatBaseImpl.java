/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.CancellationSignal
 *  android.util.Log
 *  androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry
 *  androidx.core.graphics.TypefaceCompat
 *  androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor
 *  androidx.core.graphics.TypefaceCompatUtil
 *  androidx.core.provider.FontsContractCompat$FontInfo
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontsContractCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap();

    TypefaceCompatBaseImpl() {
    }

    private void addFontFamily(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long l = TypefaceCompatBaseImpl.getUniqueKey(typeface);
        if (l == 0L) return;
        this.mFontFamilies.put(l, fontFamilyFilesResourceEntry);
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int n) {
        return TypefaceCompatBaseImpl.findBestFont(fontFamilyFilesResourceEntry.getEntries(), n, new /* Unavailable Anonymous Inner Class!! */);
    }

    private static <T> T findBestFont(T[] TArray, int n, StyleExtractor<T> styleExtractor) {
        int n2 = (n & 1) == 0 ? 400 : 700;
        boolean bl = (n & 2) != 0;
        T t = null;
        int n3 = Integer.MAX_VALUE;
        int n4 = TArray.length;
        n = 0;
        while (n < n4) {
            int n5;
            block4: {
                int n6;
                T t2;
                block3: {
                    t2 = TArray[n];
                    n6 = Math.abs(styleExtractor.getWeight(t2) - n2);
                    n5 = styleExtractor.isItalic(t2) == bl ? 0 : 1;
                    n6 = n6 * 2 + n5;
                    if (t == null) break block3;
                    n5 = n3;
                    if (n3 <= n6) break block4;
                }
                t = t2;
                n5 = n6;
            }
            ++n;
            n3 = n5;
        }
        return t;
    }

    private static long getUniqueKey(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
            long l = ((Number)field.get(typeface)).longValue();
            return l;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)TAG, (String)"Could not retrieve font from family.", (Throwable)illegalAccessException);
            return 0L;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Log.e((String)TAG, (String)"Could not retrieve font from family.", (Throwable)noSuchFieldException);
            return 0L;
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int n) {
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = this.findBestEntry(fontFamilyFilesResourceEntry, n);
        if (fontFileResourceEntry == null) {
            return null;
        }
        context = TypefaceCompat.createFromResourcesFontFile((Context)context, (Resources)resources, (int)fontFileResourceEntry.getResourceId(), (String)fontFileResourceEntry.getFileName(), (int)n);
        this.addFontFamily((Typeface)context, fontFamilyFilesResourceEntry);
        return context;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public Typeface createFromFontInfo(Context context, CancellationSignal object, FontsContractCompat.FontInfo[] fontInfoArray, int n) {
        void var1_4;
        void var2_11;
        block7: {
            void var4_15;
            void var3_14;
            int n2 = ((void)var3_14).length;
            Object var6_17 = null;
            if (n2 < 1) {
                return null;
            }
            FontsContractCompat.FontInfo fontInfo = this.findBestInfo((FontsContractCompat.FontInfo[])var3_14, (int)var4_15);
            InputStream inputStream = context.getContentResolver().openInputStream(fontInfo.getUri());
            try {
                context = this.createFromInputStream(context, inputStream);
            }
            catch (Throwable throwable) {
                break block7;
            }
            TypefaceCompatUtil.closeQuietly((Closeable)inputStream);
            return context;
            catch (Throwable throwable) {
                Object var2_10 = var6_17;
            }
        }
        TypefaceCompatUtil.closeQuietly((Closeable)var2_11);
        throw var1_4;
        catch (IOException iOException) {
            void var2_13;
            block8: {
                Object var2_12 = null;
                break block8;
                catch (IOException iOException2) {}
            }
            TypefaceCompatUtil.closeQuietly((Closeable)var2_13);
            return null;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    protected Typeface createFromInputStream(Context object, InputStream inputStream) {
        block6: {
            if ((object = TypefaceCompatUtil.getTempFile((Context)object)) == null) {
                return null;
            }
            try {
                boolean bl = TypefaceCompatUtil.copyToFile((File)object, (InputStream)inputStream);
                if (bl) break block6;
            }
            catch (RuntimeException runtimeException) {
                return null;
            }
            ((File)object).delete();
            return null;
        }
        try {
            inputStream = Typeface.createFromFile((String)((File)object).getPath());
            return inputStream;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            ((File)object).delete();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public Typeface createFromResourcesFontFile(Context object, Resources resources, int n, String string, int n2) {
        block6: {
            if ((object = TypefaceCompatUtil.getTempFile((Context)object)) == null) {
                return null;
            }
            try {
                boolean bl = TypefaceCompatUtil.copyToFile((File)object, (Resources)resources, (int)n);
                if (bl) break block6;
            }
            catch (RuntimeException runtimeException) {
                return null;
            }
            ((File)object).delete();
            return null;
        }
        try {
            resources = Typeface.createFromFile((String)((File)object).getPath());
            return resources;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            ((File)object).delete();
        }
    }

    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArray, int n) {
        return TypefaceCompatBaseImpl.findBestFont(fontInfoArray, n, new /* Unavailable Anonymous Inner Class!! */);
    }

    FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface typeface) {
        long l = TypefaceCompatBaseImpl.getUniqueKey(typeface);
        if (l != 0L) return this.mFontFamilies.get(l);
        return null;
    }
}
