/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.graphics.TypefaceCompatBaseImpl
 *  androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor
 *  androidx.core.provider.FontsContractCompat$FontInfo
 */
package androidx.core.graphics;

import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.provider.FontsContractCompat;

class TypefaceCompatBaseImpl.1
implements TypefaceCompatBaseImpl.StyleExtractor<FontsContractCompat.FontInfo> {
    final TypefaceCompatBaseImpl this$0;

    TypefaceCompatBaseImpl.1(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
        this.this$0 = typefaceCompatBaseImpl;
    }

    public int getWeight(FontsContractCompat.FontInfo fontInfo) {
        return fontInfo.getWeight();
    }

    public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
        return fontInfo.isItalic();
    }
}
