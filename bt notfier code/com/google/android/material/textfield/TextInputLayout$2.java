/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.material.textfield.TextInputLayout
 */
package com.google.android.material.textfield;

import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

class TextInputLayout.2
implements View.OnClickListener {
    final TextInputLayout this$0;

    TextInputLayout.2(TextInputLayout textInputLayout) {
        this.this$0 = textInputLayout;
    }

    public void onClick(View view) {
        this.this$0.passwordVisibilityToggleRequested(false);
    }
}
