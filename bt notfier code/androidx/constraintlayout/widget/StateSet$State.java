/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Xml
 *  androidx.constraintlayout.widget.R$styleable
 *  androidx.constraintlayout.widget.StateSet$Variant
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Xml;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

static class StateSet.State {
    int mConstraintID = -1;
    int mId;
    boolean mIsLayout;
    ArrayList<StateSet.Variant> mVariants = new ArrayList();

    public StateSet.State(Context context, XmlPullParser object) {
        int n = 0;
        this.mIsLayout = false;
        TypedArray typedArray = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)object), R.styleable.State);
        int n2 = typedArray.getIndexCount();
        while (true) {
            if (n >= n2) {
                typedArray.recycle();
                return;
            }
            int n3 = typedArray.getIndex(n);
            if (n3 == R.styleable.State_android_id) {
                this.mId = typedArray.getResourceId(n3, this.mId);
            } else if (n3 == R.styleable.State_constraints) {
                this.mConstraintID = typedArray.getResourceId(n3, this.mConstraintID);
                object = context.getResources().getResourceTypeName(this.mConstraintID);
                context.getResources().getResourceName(this.mConstraintID);
                if ("layout".equals(object)) {
                    this.mIsLayout = true;
                }
            }
            ++n;
        }
    }

    void add(StateSet.Variant variant) {
        this.mVariants.add(variant);
    }

    public int findMatch(float f, float f2) {
        int n = 0;
        while (n < this.mVariants.size()) {
            if (this.mVariants.get(n).match(f, f2)) {
                return n;
            }
            ++n;
        }
        return -1;
    }
}
