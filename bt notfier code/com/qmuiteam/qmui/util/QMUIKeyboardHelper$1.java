/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 */
package com.qmuiteam.qmui.util;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

static final class QMUIKeyboardHelper.1
implements Runnable {
    final EditText val$editText;

    QMUIKeyboardHelper.1(EditText editText) {
        this.val$editText = editText;
    }

    @Override
    public void run() {
        ((InputMethodManager)this.val$editText.getContext().getApplicationContext().getSystemService("input_method")).showSoftInput((View)this.val$editText, 1);
    }
}
