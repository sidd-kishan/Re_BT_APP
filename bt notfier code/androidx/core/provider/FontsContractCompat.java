/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.os.Handler
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  androidx.core.graphics.TypefaceCompat
 *  androidx.core.graphics.TypefaceCompat$ResourcesCallbackAdapter
 *  androidx.core.graphics.TypefaceCompatUtil
 *  androidx.core.provider.CallbackWithHandler
 *  androidx.core.provider.FontProvider
 *  androidx.core.provider.FontRequest
 *  androidx.core.provider.FontRequestWorker
 *  androidx.core.provider.FontsContractCompat$FontFamilyResult
 *  androidx.core.provider.FontsContractCompat$FontInfo
 *  androidx.core.provider.FontsContractCompat$FontRequestCallback
 *  androidx.core.provider.RequestExecutor
 */
package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.RequestExecutor;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;

public class FontsContractCompat {
    @Deprecated
    public static final String PARCEL_FONT_RESULTS = "font_results";
    @Deprecated
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    @Deprecated
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

    private FontsContractCompat() {
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArray) {
        return TypefaceCompat.createFromFontInfo((Context)context, (CancellationSignal)cancellationSignal, (FontInfo[])fontInfoArray, (int)0);
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        return FontProvider.getFontFamilyResult((Context)context, (FontRequest)fontRequest, (CancellationSignal)cancellationSignal);
    }

    @Deprecated
    public static Typeface getFontSync(Context context, FontRequest fontRequest, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean bl, int n, int n2) {
        fontCallback = new TypefaceCompat.ResourcesCallbackAdapter(fontCallback);
        return FontsContractCompat.requestFont(context, fontRequest, n2, bl, n, ResourcesCompat.FontCallback.getHandler((Handler)handler), (FontRequestCallback)fontCallback);
    }

    @Deprecated
    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        return FontProvider.getProvider((PackageManager)packageManager, (FontRequest)fontRequest, (Resources)resources);
    }

    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArray, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer((Context)context, (FontInfo[])fontInfoArray, (CancellationSignal)cancellationSignal);
    }

    public static Typeface requestFont(Context context, FontRequest fontRequest, int n, boolean bl, int n2, Handler handler, FontRequestCallback fontRequestCallback) {
        handler = new CallbackWithHandler(fontRequestCallback, handler);
        if (!bl) return FontRequestWorker.requestFontAsync((Context)context, (FontRequest)fontRequest, (int)n, null, (CallbackWithHandler)handler);
        return FontRequestWorker.requestFontSync((Context)context, (FontRequest)fontRequest, (CallbackWithHandler)handler, (int)n, (int)n2);
    }

    public static void requestFont(Context context, FontRequest fontRequest, FontRequestCallback fontRequestCallback, Handler object) {
        fontRequestCallback = new CallbackWithHandler(fontRequestCallback);
        object = RequestExecutor.createHandlerExecutor((Handler)object);
        FontRequestWorker.requestFontAsync((Context)context.getApplicationContext(), (FontRequest)fontRequest, (int)0, (Executor)object, (CallbackWithHandler)fontRequestCallback);
    }

    @Deprecated
    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }
}
