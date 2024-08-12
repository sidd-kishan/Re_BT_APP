/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand;

public static final class AccessibilityViewCommand.MoveWindowArguments
extends AccessibilityViewCommand.CommandArguments {
    public int getX() {
        return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_X");
    }

    public int getY() {
        return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_Y");
    }
}
