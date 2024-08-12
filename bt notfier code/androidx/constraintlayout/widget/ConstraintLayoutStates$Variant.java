/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.util.Xml
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import org.xmlpull.v1.XmlPullParser;

static class ConstraintLayoutStates.Variant {
    int mConstraintID = -1;
    ConstraintSet mConstraintSet;
    int mId;
    float mMaxHeight;
    float mMaxWidth;
    float mMinHeight;
    float mMinWidth = Float.NaN;

    public ConstraintLayoutStates.Variant(Context context, XmlPullParser xmlPullParser) {
        this.mMinHeight = Float.NaN;
        this.mMaxWidth = Float.NaN;
        this.mMaxHeight = Float.NaN;
        xmlPullParser = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.Variant);
        int n = xmlPullParser.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                xmlPullParser.recycle();
                return;
            }
            int n3 = xmlPullParser.getIndex(n2);
            if (n3 == R.styleable.Variant_constraints) {
                this.mConstraintID = xmlPullParser.getResourceId(n3, this.mConstraintID);
                String string = context.getResources().getResourceTypeName(this.mConstraintID);
                context.getResources().getResourceName(this.mConstraintID);
                if ("layout".equals(string)) {
                    string = new ConstraintSet();
                    this.mConstraintSet = string;
                    string.clone(context, this.mConstraintID);
                }
            } else if (n3 == R.styleable.Variant_region_heightLessThan) {
                this.mMaxHeight = xmlPullParser.getDimension(n3, this.mMaxHeight);
            } else if (n3 == R.styleable.Variant_region_heightMoreThan) {
                this.mMinHeight = xmlPullParser.getDimension(n3, this.mMinHeight);
            } else if (n3 == R.styleable.Variant_region_widthLessThan) {
                this.mMaxWidth = xmlPullParser.getDimension(n3, this.mMaxWidth);
            } else if (n3 == R.styleable.Variant_region_widthMoreThan) {
                this.mMinWidth = xmlPullParser.getDimension(n3, this.mMinWidth);
            } else {
                Log.v((String)"ConstraintLayoutStates", (String)"Unknown tag");
            }
            ++n2;
        }
    }

    boolean match(float f, float f2) {
        if (!Float.isNaN(this.mMinWidth) && f < this.mMinWidth) {
            return false;
        }
        if (!Float.isNaN(this.mMinHeight) && f2 < this.mMinHeight) {
            return false;
        }
        if (!Float.isNaN(this.mMaxWidth) && f > this.mMaxWidth) {
            return false;
        }
        if (Float.isNaN(this.mMaxHeight)) return true;
        if (!(f2 > this.mMaxHeight)) return true;
        return false;
    }
}
