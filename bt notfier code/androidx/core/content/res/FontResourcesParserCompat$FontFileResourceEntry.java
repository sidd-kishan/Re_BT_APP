/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.content.res;

public static final class FontResourcesParserCompat.FontFileResourceEntry {
    private final String mFileName;
    private boolean mItalic;
    private int mResourceId;
    private int mTtcIndex;
    private String mVariationSettings;
    private int mWeight;

    public FontResourcesParserCompat.FontFileResourceEntry(String string, int n, boolean bl, String string2, int n2, int n3) {
        this.mFileName = string;
        this.mWeight = n;
        this.mItalic = bl;
        this.mVariationSettings = string2;
        this.mTtcIndex = n2;
        this.mResourceId = n3;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public int getResourceId() {
        return this.mResourceId;
    }

    public int getTtcIndex() {
        return this.mTtcIndex;
    }

    public String getVariationSettings() {
        return this.mVariationSettings;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isItalic() {
        return this.mItalic;
    }
}
