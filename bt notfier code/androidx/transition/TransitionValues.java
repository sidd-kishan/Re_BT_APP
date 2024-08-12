/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.transition.Transition
 */
package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    final ArrayList<Transition> mTargetedTransitions;
    public final Map<String, Object> values = new HashMap<String, Object>();
    public View view;

    @Deprecated
    public TransitionValues() {
        this.mTargetedTransitions = new ArrayList();
    }

    public TransitionValues(View view) {
        this.mTargetedTransitions = new ArrayList();
        this.view = view;
    }

    public boolean equals(Object object) {
        if (!(object instanceof TransitionValues)) return false;
        View view = this.view;
        object = (TransitionValues)object;
        if (view != ((TransitionValues)object).view) return false;
        if (!this.values.equals(((TransitionValues)object).values)) return false;
        return true;
    }

    public int hashCode() {
        return this.view.hashCode() * 31 + this.values.hashCode();
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("TransitionValues@");
        charSequence.append(Integer.toHexString(this.hashCode()));
        charSequence.append(":\n");
        Object object = charSequence.toString();
        charSequence = new StringBuilder();
        charSequence.append((String)object);
        charSequence.append("    view = ");
        charSequence.append(this.view);
        charSequence.append("\n");
        object = charSequence.toString();
        charSequence = new StringBuilder();
        charSequence.append((String)object);
        charSequence.append("    values:");
        charSequence = charSequence.toString();
        object = this.values.keySet().iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append("    ");
            stringBuilder.append(string);
            stringBuilder.append(": ");
            stringBuilder.append(this.values.get(string));
            stringBuilder.append("\n");
            charSequence = stringBuilder.toString();
        }
        return charSequence;
    }
}
