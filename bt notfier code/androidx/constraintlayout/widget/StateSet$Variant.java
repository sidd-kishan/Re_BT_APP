/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  android.util.Xml
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.R;
import org.xmlpull.v1.XmlPullParser;

static class StateSet.Variant {
    int mConstraintID = -1;
    int mId;
    boolean mIsLayout;
    float mMaxHeight;
    float mMaxWidth;
    float mMinHeight;
    float mMinWidth = Float.NaN;

    public StateSet.Variant(Context context, XmlPullParser object) {
        this.mMinHeight = Float.NaN;
        this.mMaxWidth = Float.NaN;
        this.mMaxHeight = Float.NaN;
        int n = 0;
        this.mIsLayout = false;
        TypedArray typedArray = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)object), R.styleable.Variant);
        int n2 = typedArray.getIndexCount();
        while (true) {
            if (n >= n2) {
                typedArray.recycle();
                return;
            }
            int n3 = typedArray.getIndex(n);
            if (n3 == R.styleable.Variant_constraints) {
                this.mConstraintID = typedArray.getResourceId(n3, this.mConstraintID);
                object = context.getResources().getResourceTypeName(this.mConstraintID);
                context.getResources().getResourceName(this.mConstraintID);
                if ("layout".equals(object)) {
                    this.mIsLayout = true;
                }
            } else if (n3 == R.styleable.Variant_region_heightLessThan) {
                this.mMaxHeight = typedArray.getDimension(n3, this.mMaxHeight);
            } else if (n3 == R.styleable.Variant_region_heightMoreThan) {
                this.mMinHeight = typedArray.getDimension(n3, this.mMinHeight);
            } else if (n3 == R.styleable.Variant_region_widthLessThan) {
                this.mMaxWidth = typedArray.getDimension(n3, this.mMaxWidth);
            } else if (n3 == R.styleable.Variant_region_widthMoreThan) {
                this.mMinWidth = typedArray.getDimension(n3, this.mMinWidth);
            } else {
                Log.v((String)"ConstraintLayoutStates", (String)"Unknown tag");
            }
            ++n;
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
