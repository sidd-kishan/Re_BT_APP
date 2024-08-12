/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand;

public static final class AccessibilityViewCommand.SetTextArguments
extends AccessibilityViewCommand.CommandArguments {
    public CharSequence getText() {
        return this.mBundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
    }
}
