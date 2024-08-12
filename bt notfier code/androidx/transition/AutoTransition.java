/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.transition.ChangeBounds
 *  androidx.transition.Fade
 *  androidx.transition.Transition
 *  androidx.transition.TransitionSet
 */
package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;

public class AutoTransition
extends TransitionSet {
    public AutoTransition() {
        this.init();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    private void init() {
        this.setOrdering(1);
        this.addTransition((Transition)new Fade(2)).addTransition((Transition)new ChangeBounds()).addTransition((Transition)new Fade(1));
    }
}
