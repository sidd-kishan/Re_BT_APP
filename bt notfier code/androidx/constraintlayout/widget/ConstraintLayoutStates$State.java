/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Xml
 *  androidx.constraintlayout.widget.ConstraintLayoutStates$Variant
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

static class ConstraintLayoutStates.State {
    int mConstraintID = -1;
    ConstraintSet mConstraintSet;
    int mId;
    ArrayList<ConstraintLayoutStates.Variant> mVariants = new ArrayList();

    public ConstraintLayoutStates.State(Context context, XmlPullParser xmlPullParser) {
        xmlPullParser = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.State);
        int n = xmlPullParser.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                xmlPullParser.recycle();
                return;
            }
            int n3 = xmlPullParser.getIndex(n2);
            if (n3 == R.styleable.State_android_id) {
                this.mId = xmlPullParser.getResourceId(n3, this.mId);
            } else if (n3 == R.styleable.State_constraints) {
                this.mConstraintID = xmlPullParser.getResourceId(n3, this.mConstraintID);
                String string = context.getResources().getResourceTypeName(this.mConstraintID);
                context.getResources().getResourceName(this.mConstraintID);
                if ("layout".equals(string)) {
                    string = new ConstraintSet();
                    this.mConstraintSet = string;
                    string.clone(context, this.mConstraintID);
                }
            }
            ++n2;
        }
    }

    void add(ConstraintLayoutStates.Variant variant) {
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
