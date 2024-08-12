/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.Signature
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  androidx.core.content.res.FontResourcesParserCompat
 *  androidx.core.provider.FontRequest
 *  androidx.core.provider.FontsContractCompat$FontFamilyResult
 *  androidx.core.provider.FontsContractCompat$FontInfo
 */
package androidx.core.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = new /* Unavailable Anonymous Inner Class!! */;

    private FontProvider() {
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArray) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        int n = 0;
        while (n < signatureArray.length) {
            arrayList.add(signatureArray[n].toByteArray());
            ++n;
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int n = 0;
        while (n < list.size()) {
            if (!Arrays.equals(list.get(n), list2.get(n))) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() == null) return FontResourcesParserCompat.readCerts((Resources)resources, (int)fontRequest.getCertificatesArrayResId());
        return fontRequest.getCertificates();
    }

    static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfo = FontProvider.getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (providerInfo != null) return FontsContractCompat.FontFamilyResult.create((int)0, (FontsContractCompat.FontInfo[])FontProvider.query(context, fontRequest, providerInfo.authority, cancellationSignal));
        return FontsContractCompat.FontFamilyResult.create((int)1, null);
    }

    static ProviderInfo getProvider(PackageManager object, FontRequest object2, Resources object3) throws PackageManager.NameNotFoundException {
        String string = object2.getProviderAuthority();
        int n = 0;
        ProviderInfo providerInfo = object.resolveContentProvider(string, 0);
        if (providerInfo == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No package found for authority: ");
            ((StringBuilder)object).append(string);
            object = new PackageManager.NameNotFoundException(((StringBuilder)object).toString());
            throw object;
        }
        if (!providerInfo.packageName.equals(object2.getProviderPackage())) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Found content provider ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(", but package was not ");
            ((StringBuilder)object).append(object2.getProviderPackage());
            throw new PackageManager.NameNotFoundException(((StringBuilder)object).toString());
        }
        object = FontProvider.convertToByteArrayList(object.getPackageInfo((String)providerInfo.packageName, (int)64).signatures);
        Collections.sort(object, sByteArrayComparator);
        object3 = FontProvider.getCertificates(object2, (Resources)object3);
        while (n < object3.size()) {
            object2 = new ArrayList((Collection)object3.get(n));
            Collections.sort(object2, sByteArrayComparator);
            if (FontProvider.equalsByteArrayList((List<byte[]>)object, (List<byte[]>)object2)) {
                return providerInfo;
            }
            ++n;
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    static FontsContractCompat.FontInfo[] query(Context var0, FontRequest var1_2, String var2_3, CancellationSignal var3_4) {
        var14_5 = new ArrayList<E>();
        var16_6 = new Uri.Builder().scheme("content").authority(var2_3).build();
        var17_7 = new Uri.Builder().scheme("content").authority(var2_3).appendPath("file").build();
        var15_8 = null;
        var2_3 = var15_8;
        try {
            var18_9 = new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            var2_3 = var15_8;
        }
        catch (Throwable var0_1) {
            if (var2_3 == null) throw var0_1;
            var2_3.close();
            throw var0_1;
        }
        {
            block16: {
                if (Build.VERSION.SDK_INT > 16) {
                    var2_3 = var15_8;
                    var0 = var0.getContentResolver().query(var16_6, var18_9, "query = ?", new String[]{var1_2.getQuery()}, null, (CancellationSignal)var3_4);
                } else {
                    var2_3 = var15_8;
                    var0 = var0.getContentResolver().query(var16_6, var18_9, "query = ?", new String[]{var1_2.getQuery()}, null);
                }
                var1_2 = var14_5;
                if (var0 == null) break block16;
                var1_2 = var14_5;
                var2_3 = var0;
                if (var0.getCount() <= 0) break block16;
                var2_3 = var0;
                var9_10 = var0.getColumnIndex("result_code");
                var2_3 = var0;
                var2_3 = var0;
                var3_4 = new ArrayList();
                var2_3 = var0;
                var10_11 = var0.getColumnIndex("_id");
                var2_3 = var0;
                var7_12 = var0.getColumnIndex("file_id");
                var2_3 = var0;
                var11_13 = var0.getColumnIndex("font_ttc_index");
                var2_3 = var0;
                var12_14 = var0.getColumnIndex("font_weight");
                var2_3 = var0;
                var8_15 = var0.getColumnIndex("font_italic");
                while (true) {
                    var2_3 = var0;
                    if (!var0.moveToNext()) break;
                    if (var9_10 != -1) {
                        var2_3 = var0;
                        var4_16 = var0.getInt(var9_10);
                    } else {
                        var4_16 = 0;
                    }
                    if (var11_13 != -1) {
                        var2_3 = var0;
                        var5_17 = var0.getInt(var11_13);
                    } else {
                        var5_17 = 0;
                    }
                    if (var7_12 == -1) {
                        var2_3 = var0;
                        var1_2 = ContentUris.withAppendedId((Uri)var16_6, (long)var0.getLong(var10_11));
                    } else {
                        var2_3 = var0;
                        var1_2 = ContentUris.withAppendedId((Uri)var17_7, (long)var0.getLong(var7_12));
                    }
                    if (var12_14 != -1) {
                        var2_3 = var0;
                        var6_18 = var0.getInt(var12_14);
                    } else {
                        var6_18 = 400;
                    }
                    if (var8_15 == -1) ** GOTO lbl-1000
                    var2_3 = var0;
                    if (var0.getInt(var8_15) == 1) {
                        var13_19 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var13_19 = false;
                    }
                    var2_3 = var0;
                    var3_4.add(FontsContractCompat.FontInfo.create((Uri)var1_2, (int)var5_17, (int)var6_18, (boolean)var13_19, (int)var4_16));
                }
                var1_2 = var3_4;
            }
            if (var0 == null) return var1_2.toArray(new FontsContractCompat.FontInfo[0]);
        }
        var0.close();
        return var1_2.toArray(new FontsContractCompat.FontInfo[0]);
    }
}
