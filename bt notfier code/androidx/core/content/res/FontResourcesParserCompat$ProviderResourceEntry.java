/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry
 *  androidx.core.provider.FontRequest
 */
package androidx.core.content.res;

import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontRequest;

public static final class FontResourcesParserCompat.ProviderResourceEntry
implements FontResourcesParserCompat.FamilyResourceEntry {
    private final FontRequest mRequest;
    private final int mStrategy;
    private final String mSystemFontFamilyName;
    private final int mTimeoutMs;

    public FontResourcesParserCompat.ProviderResourceEntry(FontRequest fontRequest, int n, int n2) {
        this(fontRequest, n, n2, null);
    }

    public FontResourcesParserCompat.ProviderResourceEntry(FontRequest fontRequest, int n, int n2, String string) {
        this.mRequest = fontRequest;
        this.mStrategy = n;
        this.mTimeoutMs = n2;
        this.mSystemFontFamilyName = string;
    }

    public int getFetchStrategy() {
        return this.mStrategy;
    }

    public FontRequest getRequest() {
        return this.mRequest;
    }

    public String getSystemFontFamilyName() {
        return this.mSystemFontFamilyName;
    }

    public int getTimeout() {
        return this.mTimeoutMs;
    }
}
