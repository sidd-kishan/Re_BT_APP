/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.SpecialEffectsController$3
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController;

static final class SpecialEffectsController.Operation.State
extends Enum<SpecialEffectsController.Operation.State> {
    private static final SpecialEffectsController.Operation.State[] $VALUES;
    public static final /* enum */ SpecialEffectsController.Operation.State GONE;
    public static final /* enum */ SpecialEffectsController.Operation.State INVISIBLE;
    public static final /* enum */ SpecialEffectsController.Operation.State REMOVED;
    public static final /* enum */ SpecialEffectsController.Operation.State VISIBLE;

    static {
        SpecialEffectsController.Operation.State state;
        REMOVED = new SpecialEffectsController.Operation.State();
        VISIBLE = new SpecialEffectsController.Operation.State();
        GONE = new SpecialEffectsController.Operation.State();
        INVISIBLE = state = new SpecialEffectsController.Operation.State();
        $VALUES = new SpecialEffectsController.Operation.State[]{REMOVED, VISIBLE, GONE, state};
    }

    static SpecialEffectsController.Operation.State from(int n) {
        if (n == 0) return VISIBLE;
        if (n == 4) return INVISIBLE;
        if (n == 8) {
            return GONE;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown visibility ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static SpecialEffectsController.Operation.State from(View view) {
        if (view.getAlpha() != 0.0f) return SpecialEffectsController.Operation.State.from(view.getVisibility());
        if (view.getVisibility() != 0) return SpecialEffectsController.Operation.State.from(view.getVisibility());
        return INVISIBLE;
    }

    public static SpecialEffectsController.Operation.State valueOf(String string) {
        return Enum.valueOf(SpecialEffectsController.Operation.State.class, string);
    }

    public static SpecialEffectsController.Operation.State[] values() {
        return (SpecialEffectsController.Operation.State[])$VALUES.clone();
    }

    void applyState(View view) {
        int n = SpecialEffectsController.3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[this.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) return;
                    if (FragmentManager.isLoggingEnabled((int)2)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("SpecialEffectsController: Setting view ");
                        stringBuilder.append(view);
                        stringBuilder.append(" to INVISIBLE");
                        Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                    }
                    view.setVisibility(4);
                } else {
                    if (FragmentManager.isLoggingEnabled((int)2)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("SpecialEffectsController: Setting view ");
                        stringBuilder.append(view);
                        stringBuilder.append(" to GONE");
                        Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                    }
                    view.setVisibility(8);
                }
            } else {
                if (FragmentManager.isLoggingEnabled((int)2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("SpecialEffectsController: Setting view ");
                    stringBuilder.append(view);
                    stringBuilder.append(" to VISIBLE");
                    Log.v((String)"FragmentManager", (String)stringBuilder.toString());
                }
                view.setVisibility(0);
            }
        } else {
            ViewGroup viewGroup = (ViewGroup)view.getParent();
            if (viewGroup == null) return;
            if (FragmentManager.isLoggingEnabled((int)2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SpecialEffectsController: Removing view ");
                stringBuilder.append(view);
                stringBuilder.append(" from container ");
                stringBuilder.append(viewGroup);
                Log.v((String)"FragmentManager", (String)stringBuilder.toString());
            }
            viewGroup.removeView(view);
        }
    }
}
