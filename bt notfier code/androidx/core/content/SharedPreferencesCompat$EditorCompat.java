/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 *  androidx.core.content.SharedPreferencesCompat$EditorCompat$Helper
 */
package androidx.core.content;

import android.content.SharedPreferences;
import androidx.core.content.SharedPreferencesCompat;

@Deprecated
public static final class SharedPreferencesCompat.EditorCompat {
    private static SharedPreferencesCompat.EditorCompat sInstance;
    private final Helper mHelper = new Helper();

    private SharedPreferencesCompat.EditorCompat() {
    }

    @Deprecated
    public static SharedPreferencesCompat.EditorCompat getInstance() {
        if (sInstance != null) return sInstance;
        sInstance = new SharedPreferencesCompat.EditorCompat();
        return sInstance;
    }

    @Deprecated
    public void apply(SharedPreferences.Editor editor) {
        this.mHelper.apply(editor);
    }
}
