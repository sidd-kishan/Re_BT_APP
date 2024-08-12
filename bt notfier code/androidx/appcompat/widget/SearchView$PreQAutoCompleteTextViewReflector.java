/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.widget.AutoCompleteTextView
 */
package androidx.appcompat.widget;

import android.os.Build;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

private static class SearchView.PreQAutoCompleteTextViewReflector {
    private Method mDoAfterTextChanged = null;
    private Method mDoBeforeTextChanged = null;
    private Method mEnsureImeVisible = null;

    /*
     * Enabled force condition propagation
     */
    SearchView.PreQAutoCompleteTextViewReflector() {
        Method method;
        SearchView.PreQAutoCompleteTextViewReflector.preApi29Check();
        try {
            this.mDoBeforeTextChanged = method = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            method.setAccessible(true);
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        try {
            this.mDoAfterTextChanged = method = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            method.setAccessible(true);
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        try {
            this.mEnsureImeVisible = method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
            method.setAccessible(true);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return;
        }
    }

    private static void preApi29Check() {
        if (Build.VERSION.SDK_INT >= 29) throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
    }

    /*
     * Enabled force condition propagation
     */
    void doAfterTextChanged(AutoCompleteTextView autoCompleteTextView) {
        SearchView.PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method = this.mDoAfterTextChanged;
        if (method == null) return;
        try {
            method.invoke(autoCompleteTextView, new Object[0]);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    void doBeforeTextChanged(AutoCompleteTextView autoCompleteTextView) {
        SearchView.PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method = this.mDoBeforeTextChanged;
        if (method == null) return;
        try {
            method.invoke(autoCompleteTextView, new Object[0]);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    void ensureImeVisible(AutoCompleteTextView autoCompleteTextView) {
        SearchView.PreQAutoCompleteTextViewReflector.preApi29Check();
        Method method = this.mEnsureImeVisible;
        if (method == null) return;
        try {
            method.invoke(autoCompleteTextView, true);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}
