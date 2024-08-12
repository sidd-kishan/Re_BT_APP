/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.inputmethod.EditorInfo
 */
package androidx.core.view.inputmethod;

import android.view.inputmethod.EditorInfo;

private static class EditorInfoCompat.Impl30 {
    private EditorInfoCompat.Impl30() {
    }

    static CharSequence getInitialSelectedText(EditorInfo editorInfo, int n) {
        return editorInfo.getInitialSelectedText(n);
    }

    static CharSequence getInitialTextAfterCursor(EditorInfo editorInfo, int n, int n2) {
        return editorInfo.getInitialTextAfterCursor(n, n2);
    }

    static CharSequence getInitialTextBeforeCursor(EditorInfo editorInfo, int n, int n2) {
        return editorInfo.getInitialTextBeforeCursor(n, n2);
    }

    static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int n) {
        editorInfo.setInitialSurroundingSubText(charSequence, n);
    }
}
