/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry
 *  androidx.core.graphics.TypefaceCompatBaseImpl
 *  androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor
 */
package androidx.core.graphics;

import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;

class TypefaceCompatBaseImpl.2
implements TypefaceCompatBaseImpl.StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
    final TypefaceCompatBaseImpl this$0;

    TypefaceCompatBaseImpl.2(TypefaceCompatBaseImpl typefaceCompatBaseImpl) {
        this.this$0 = typefaceCompatBaseImpl;
    }

    public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
        return fontFileResourceEntry.getWeight();
    }

    public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
        return fontFileResourceEntry.isItalic();
    }
}
