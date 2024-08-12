/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Typeface
 *  androidx.collection.LruCache
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.graphics.TypefaceCompat
 *  androidx.core.provider.CallbackWithHandler
 *  androidx.core.provider.FontProvider
 *  androidx.core.provider.FontRequest
 *  androidx.core.provider.FontRequestWorker$TypefaceResult
 *  androidx.core.provider.FontsContractCompat$FontFamilyResult
 *  androidx.core.provider.FontsContractCompat$FontInfo
 *  androidx.core.provider.RequestExecutor
 *  androidx.core.util.Consumer
 */
package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.RequestExecutor;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE;
    static final Object LOCK;
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES;
    static final LruCache<String, Typeface> sTypefaceCache;

    static {
        sTypefaceCache = new LruCache(16);
        DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor((String)"fonts-androidx", (int)10, (int)10000);
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap();
    }

    private FontRequestWorker() {
    }

    private static String createCacheId(FontRequest fontRequest, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fontRequest.getId());
        stringBuilder.append("-");
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    private static int getFontFamilyResultStatus(FontsContractCompat.FontFamilyResult fontInfoArray) {
        int n = fontInfoArray.getStatusCode();
        int n2 = -3;
        int n3 = 1;
        if (n != 0) {
            if (fontInfoArray.getStatusCode() == 1) return -2;
            return -3;
        }
        fontInfoArray = fontInfoArray.getFonts();
        n = n3;
        if (fontInfoArray == null) return n;
        if (fontInfoArray.length == 0) {
            n = n3;
            return n;
        }
        int n4 = fontInfoArray.length;
        int n5 = 0;
        n3 = 0;
        while (true) {
            n = n5;
            if (n3 >= n4) return n;
            n = fontInfoArray[n3].getResultCode();
            if (n != 0) {
                if (n < 0) {
                    n3 = n2;
                    break;
                }
                n3 = n;
                break;
            }
            ++n3;
        }
        return n3;
    }

    static TypefaceResult getFontSync(String string, Context context, FontRequest fontRequest, int n) {
        Typeface typeface = (Typeface)sTypefaceCache.get((Object)string);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            fontRequest = FontProvider.getFontFamilyResult((Context)context, (FontRequest)fontRequest, null);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return new TypefaceResult(-1);
        }
        int n2 = FontRequestWorker.getFontFamilyResultStatus((FontsContractCompat.FontFamilyResult)fontRequest);
        if (n2 != 0) {
            return new TypefaceResult(n2);
        }
        if ((context = TypefaceCompat.createFromFontInfo((Context)context, null, (FontsContractCompat.FontInfo[])fontRequest.getFonts(), (int)n)) == null) return new TypefaceResult(-3);
        sTypefaceCache.put((Object)string, (Object)context);
        return new TypefaceResult((Typeface)context);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    static Typeface requestFontAsync(Context object, FontRequest fontRequest, int n, Executor executor, CallbackWithHandler object2) {
        String string = FontRequestWorker.createCacheId(fontRequest, n);
        Typeface typeface = (Typeface)sTypefaceCache.get((Object)string);
        if (typeface != null) {
            object2.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        typeface = new /* Unavailable Anonymous Inner Class!! */;
        object2 = LOCK;
        synchronized (object2) {
            ArrayList<Typeface> arrayList = (ArrayList<Typeface>)PENDING_REPLIES.get((Object)string);
            if (arrayList != null) {
                arrayList.add(typeface);
                return null;
            }
            arrayList = new ArrayList<Typeface>();
            arrayList.add(typeface);
            PENDING_REPLIES.put((Object)string, arrayList);
        }
        fontRequest = new /* Unavailable Anonymous Inner Class!! */;
        object = executor;
        if (executor == null) {
            object = DEFAULT_EXECUTOR_SERVICE;
        }
        RequestExecutor.execute((Executor)object, (Callable)fontRequest, (Consumer)new /* Unavailable Anonymous Inner Class!! */);
        return null;
    }

    static Typeface requestFontSync(Context context, FontRequest fontRequest, CallbackWithHandler callbackWithHandler, int n, int n2) {
        String string = FontRequestWorker.createCacheId(fontRequest, n);
        Typeface typeface = (Typeface)sTypefaceCache.get((Object)string);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        if (n2 == -1) {
            context = FontRequestWorker.getFontSync(string, context, fontRequest, n);
            callbackWithHandler.onTypefaceResult((TypefaceResult)context);
            return context.mTypeface;
        }
        context = new /* Unavailable Anonymous Inner Class!! */;
        try {
            context = (TypefaceResult)RequestExecutor.submit((ExecutorService)DEFAULT_EXECUTOR_SERVICE, (Callable)context, (int)n2);
            callbackWithHandler.onTypefaceResult((TypefaceResult)context);
            context = context.mTypeface;
            return context;
        }
        catch (InterruptedException interruptedException) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(-3));
            return null;
        }
    }

    static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }
}
