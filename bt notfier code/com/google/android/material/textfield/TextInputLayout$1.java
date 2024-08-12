/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 *  com.google.android.material.textfield.TextInputLayout
 */
package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.material.textfield.TextInputLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class TextInputLayout.1
implements TextWatcher {
    final TextInputLayout this$0;

    TextInputLayout.1(TextInputLayout textInputLayout) {
        this.this$0 = textInputLayout;
    }

    public void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.this$0;
        textInputLayout.updateLabelState(TextInputLayout.access$000((TextInputLayout)textInputLayout) ^ true);
        if (!this.this$0.counterEnabled) return;
        this.this$0.updateCounter(editable.length());
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }
}
