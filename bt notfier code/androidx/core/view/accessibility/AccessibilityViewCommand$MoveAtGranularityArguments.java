/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand;

public static final class AccessibilityViewCommand.MoveAtGranularityArguments
extends AccessibilityViewCommand.CommandArguments {
    public boolean getExtendSelection() {
        return this.mBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
    }

    public int getGranularity() {
        return this.mBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
    }
}
