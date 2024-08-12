/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry
 */
package androidx.core.content.res;

import androidx.core.content.res.FontResourcesParserCompat;

public static final class FontResourcesParserCompat.FontFamilyFilesResourceEntry
implements FontResourcesParserCompat.FamilyResourceEntry {
    private final FontResourcesParserCompat.FontFileResourceEntry[] mEntries;

    public FontResourcesParserCompat.FontFamilyFilesResourceEntry(FontResourcesParserCompat.FontFileResourceEntry[] fontFileResourceEntryArray) {
        this.mEntries = fontFileResourceEntryArray;
    }

    public FontResourcesParserCompat.FontFileResourceEntry[] getEntries() {
        return this.mEntries;
    }
}
