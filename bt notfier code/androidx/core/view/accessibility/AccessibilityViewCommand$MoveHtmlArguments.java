/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand;

public static final class AccessibilityViewCommand.MoveHtmlArguments
extends AccessibilityViewCommand.CommandArguments {
    public String getHTMLElement() {
        return this.mBundle.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
    }
}
