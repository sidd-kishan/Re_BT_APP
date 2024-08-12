/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand;

public static final class AccessibilityViewCommand.SetSelectionArguments
extends AccessibilityViewCommand.CommandArguments {
    public int getEnd() {
        return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
    }

    public int getStart() {
        return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
    }
}
