/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  com.google.android.material.textfield.TextInputLayout
 */
package com.google.android.material.textfield;

import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.textfield.TextInputLayout;

public static class TextInputLayout.AccessibilityDelegate
extends AccessibilityDelegateCompat {
    private final TextInputLayout layout;

    public TextInputLayout.AccessibilityDelegate(TextInputLayout textInputLayout) {
        this.layout = textInputLayout;
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(object, accessibilityNodeInfoCompat);
        object = this.layout.getEditText();
        object = object != null ? object.getText() : null;
        CharSequence charSequence = this.layout.getHint();
        CharSequence charSequence2 = this.layout.getError();
        CharSequence charSequence3 = this.layout.getCounterOverflowDescription();
        boolean bl = TextUtils.isEmpty((CharSequence)object) ^ true;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence) ^ true;
        boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence2) ^ true;
        boolean bl4 = false;
        boolean bl5 = bl3 || !TextUtils.isEmpty((CharSequence)charSequence3);
        if (bl) {
            accessibilityNodeInfoCompat.setText((CharSequence)object);
        } else if (bl2) {
            accessibilityNodeInfoCompat.setText(charSequence);
        }
        if (bl2) {
            accessibilityNodeInfoCompat.setHintText(charSequence);
            boolean bl6 = bl4;
            if (!bl) {
                bl6 = bl4;
                if (bl2) {
                    bl6 = true;
                }
            }
            accessibilityNodeInfoCompat.setShowingHintText(bl6);
        }
        if (!bl5) return;
        object = bl3 ? charSequence2 : charSequence3;
        accessibilityNodeInfoCompat.setError((CharSequence)object);
        accessibilityNodeInfoCompat.setContentInvalid(true);
    }

    public void onPopulateAccessibilityEvent(View object, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(object, accessibilityEvent);
        object = this.layout.getEditText();
        object = object != null ? object.getText() : null;
        Object object2 = object;
        if (TextUtils.isEmpty((CharSequence)object)) {
            object2 = this.layout.getHint();
        }
        if (TextUtils.isEmpty((CharSequence)object2)) return;
        accessibilityEvent.getText().add(object2);
    }
}
