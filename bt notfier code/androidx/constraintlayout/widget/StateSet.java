/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.Xml
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.ConstraintsChangedListener
 *  androidx.constraintlayout.widget.R$styleable
 *  androidx.constraintlayout.widget.StateSet$State
 *  androidx.constraintlayout.widget.StateSet$Variant
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    private SparseArray<State> mStateList = new SparseArray();

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        this.mConstraintSetMap = new SparseArray();
        this.load(context, xmlPullParser);
    }

    private void load(Context context, XmlPullParser xmlPullParser) {
        int n;
        TypedArray typedArray = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.StateSet);
        int n2 = typedArray.getIndexCount();
        for (n = 0; n < n2; ++n) {
            int n3 = typedArray.getIndex(n);
            if (n3 != R.styleable.StateSet_defaultState) continue;
            this.mDefaultState = typedArray.getResourceId(n3, this.mDefaultState);
        }
        typedArray.recycle();
        typedArray = null;
        try {
            n = xmlPullParser.getEventType();
            while (n != 1) {
                Object object;
                if (n != 0) {
                    if (n != 2) {
                        if (n != 3) {
                            object = typedArray;
                        } else {
                            object = typedArray;
                            if ("StateSet".equals(xmlPullParser.getName())) {
                                return;
                            }
                        }
                    } else {
                        String string = xmlPullParser.getName();
                        n = -1;
                        switch (string.hashCode()) {
                            default: {
                                break;
                            }
                            case 1901439077: {
                                if (!string.equals("Variant")) break;
                                n = 3;
                                break;
                            }
                            case 1382829617: {
                                if (!string.equals("StateSet")) break;
                                n = 1;
                                break;
                            }
                            case 1301459538: {
                                if (!string.equals("LayoutDescription")) break;
                                n = 0;
                                break;
                            }
                            case 80204913: {
                                if (!string.equals("State")) break;
                                n = 2;
                            }
                        }
                        object = typedArray;
                        if (n != 0) {
                            object = typedArray;
                            if (n != 1) {
                                if (n != 2) {
                                    if (n != 3) {
                                        object = new StringBuilder();
                                        ((StringBuilder)object).append("unknown tag ");
                                        ((StringBuilder)object).append(string);
                                        Log.v((String)TAG, (String)((StringBuilder)object).toString());
                                        object = typedArray;
                                    } else {
                                        string = new Variant(context, xmlPullParser);
                                        object = typedArray;
                                        if (typedArray != null) {
                                            typedArray.add((Variant)string);
                                            object = typedArray;
                                        }
                                    }
                                } else {
                                    object = new State(context, xmlPullParser);
                                    this.mStateList.put(((State)object).mId, object);
                                }
                            }
                        }
                    }
                } else {
                    xmlPullParser.getName();
                    object = typedArray;
                }
                n = xmlPullParser.next();
                typedArray = object;
            }
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (XmlPullParserException xmlPullParserException) {
            xmlPullParserException.printStackTrace();
        }
    }

    public int convertToConstraintSet(int n, int n2, float f, float f2) {
        State state = (State)this.mStateList.get(n2);
        if (state == null) {
            return n2;
        }
        if (f == -1.0f || f2 == -1.0f) {
            if (state.mConstraintID == n) {
                return n;
            }
            Iterator iterator = state.mVariants.iterator();
            do {
                if (!iterator.hasNext()) return state.mConstraintID;
            } while (n != ((Variant)iterator.next()).mConstraintID);
            return n;
        }
        Variant variant = null;
        Iterator iterator = state.mVariants.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                if (variant == null) return state.mConstraintID;
                return variant.mConstraintID;
            }
            Variant variant2 = (Variant)iterator.next();
            if (!variant2.match(f, f2)) continue;
            if (n == variant2.mConstraintID) {
                return n;
            }
            variant = variant2;
        }
    }

    public boolean needsToChange(int n, float f, float f2) {
        int n2 = this.mCurrentStateId;
        if (n2 != n) {
            return true;
        }
        Object object = n == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(n2);
        object = (State)object;
        if (this.mCurrentConstraintNumber != -1 && ((Variant)((State)object).mVariants.get(this.mCurrentConstraintNumber)).match(f, f2)) {
            return false;
        }
        if (this.mCurrentConstraintNumber != object.findMatch(f, f2)) return true;
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int n, int n2, int n3) {
        return this.updateConstraints(-1, n, n2, n3);
    }

    public int updateConstraints(int n, int n2, float f, float f2) {
        if (n == n2) {
            State state = n2 == -1 ? (State)this.mStateList.valueAt(0) : (State)this.mStateList.get(this.mCurrentStateId);
            if (state == null) {
                return -1;
            }
            if (this.mCurrentConstraintNumber != -1 && ((Variant)state.mVariants.get(n)).match(f, f2)) {
                return n;
            }
            n2 = state.findMatch(f, f2);
            if (n == n2) {
                return n;
            }
            n = n2 == -1 ? state.mConstraintID : ((Variant)state.mVariants.get((int)n2)).mConstraintID;
            return n;
        }
        State state = (State)this.mStateList.get(n2);
        if (state == null) {
            return -1;
        }
        n = state.findMatch(f, f2);
        n = n == -1 ? state.mConstraintID : ((Variant)state.mVariants.get((int)n)).mConstraintID;
        return n;
    }
}
