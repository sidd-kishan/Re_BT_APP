/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 */
package androidx.core.content;

import android.content.SharedPreferences;

private static class SharedPreferencesCompat.EditorCompat.Helper {
    SharedPreferencesCompat.EditorCompat.Helper() {
    }

    public void apply(SharedPreferences.Editor editor) {
        try {
            editor.apply();
        }
        catch (AbstractMethodError abstractMethodError) {
            editor.commit();
        }
    }
}
