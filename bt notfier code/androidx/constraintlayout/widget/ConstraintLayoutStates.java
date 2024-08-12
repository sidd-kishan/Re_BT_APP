/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.util.SparseArray
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayoutStates$State
 *  androidx.constraintlayout.widget.ConstraintLayoutStates$Variant
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.ConstraintsChangedListener
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<State> mStateList = new SparseArray();

    ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int n) {
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintLayout = constraintLayout;
        this.load(context, n);
    }

    private void load(Context context, int n) {
        XmlResourceParser xmlResourceParser = context.getResources().getXml(n);
        State state = null;
        try {
            n = xmlResourceParser.getEventType();
            while (n != 1) {
                Object object;
                if (n != 0) {
                    if (n != 2) {
                        object = state;
                    } else {
                        String string = xmlResourceParser.getName();
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
                            case 1657696882: {
                                if (!string.equals("layoutDescription")) break;
                                n = 0;
                                break;
                            }
                            case 1382829617: {
                                if (!string.equals("StateSet")) break;
                                n = 1;
                                break;
                            }
                            case 80204913: {
                                if (!string.equals("State")) break;
                                n = 2;
                                break;
                            }
                            case -1349929691: {
                                if (!string.equals("ConstraintSet")) break;
                                n = 4;
                            }
                        }
                        object = state;
                        if (n != 0) {
                            object = state;
                            if (n != 1) {
                                if (n != 2) {
                                    if (n != 3) {
                                        if (n != 4) {
                                            object = new StringBuilder();
                                            ((StringBuilder)object).append("unknown tag ");
                                            ((StringBuilder)object).append(string);
                                            Log.v((String)TAG, (String)((StringBuilder)object).toString());
                                            object = state;
                                        } else {
                                            this.parseConstraintSet(context, xmlResourceParser);
                                            object = state;
                                        }
                                    } else {
                                        string = new Variant(context, (XmlPullParser)xmlResourceParser);
                                        object = state;
                                        if (state != null) {
                                            state.add((Variant)string);
                                            object = state;
                                        }
                                    }
                                } else {
                                    object = new State(context, (XmlPullParser)xmlResourceParser);
                                    this.mStateList.put(((State)object).mId, object);
                                }
                            }
                        }
                    }
                } else {
                    xmlResourceParser.getName();
                    object = state;
                }
                n = xmlResourceParser.next();
                state = object;
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

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        int n = xmlPullParser.getAttributeCount();
        int n2 = 0;
        while (n2 < n) {
            if ("id".equals(xmlPullParser.getAttributeName(n2))) {
                String string = xmlPullParser.getAttributeValue(n2);
                if (string.contains("/")) {
                    String string2 = string.substring(string.indexOf(47) + 1);
                    n2 = context.getResources().getIdentifier(string2, "id", context.getPackageName());
                } else {
                    n2 = -1;
                }
                n = n2;
                if (n2 == -1) {
                    if (string != null && string.length() > 1) {
                        n = Integer.parseInt(string.substring(1));
                    } else {
                        Log.e((String)TAG, (String)"error in parsing id");
                        n = n2;
                    }
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(n, (Object)constraintSet);
                return;
            }
            ++n2;
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

    public void updateConstraints(int n, float f, float f2) {
        int n2 = this.mCurrentStateId;
        if (n2 == n) {
            State state = n == -1 ? (State)this.mStateList.valueAt(0) : (State)this.mStateList.get(n2);
            if (this.mCurrentConstraintNumber != -1 && ((Variant)state.mVariants.get(this.mCurrentConstraintNumber)).match(f, f2)) {
                return;
            }
            n2 = state.findMatch(f, f2);
            if (this.mCurrentConstraintNumber == n2) {
                return;
            }
            ConstraintSet constraintSet = n2 == -1 ? this.mDefaultConstraintSet : ((Variant)state.mVariants.get((int)n2)).mConstraintSet;
            n = n2 == -1 ? state.mConstraintID : ((Variant)state.mVariants.get((int)n2)).mConstraintID;
            if (constraintSet == null) {
                return;
            }
            this.mCurrentConstraintNumber = n2;
            state = this.mConstraintsChangedListener;
            if (state != null) {
                state.preLayoutChange(-1, n);
            }
            constraintSet.applyTo(this.mConstraintLayout);
            state = this.mConstraintsChangedListener;
            if (state == null) return;
            state.postLayoutChange(-1, n);
        } else {
            this.mCurrentStateId = n;
            State state = (State)this.mStateList.get(n);
            int n3 = state.findMatch(f, f2);
            Object object = n3 == -1 ? state.mConstraintSet : ((Variant)state.mVariants.get((int)n3)).mConstraintSet;
            n2 = n3 == -1 ? state.mConstraintID : ((Variant)state.mVariants.get((int)n3)).mConstraintID;
            if (object == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("NO Constraint set found ! id=");
                ((StringBuilder)object).append(n);
                ((StringBuilder)object).append(", dim =");
                ((StringBuilder)object).append(f);
                ((StringBuilder)object).append(", ");
                ((StringBuilder)object).append(f2);
                Log.v((String)TAG, (String)((StringBuilder)object).toString());
                return;
            }
            this.mCurrentConstraintNumber = n3;
            state = this.mConstraintsChangedListener;
            if (state != null) {
                state.preLayoutChange(n, n2);
            }
            object.applyTo(this.mConstraintLayout);
            object = this.mConstraintsChangedListener;
            if (object == null) return;
            object.postLayoutChange(n, n2);
        }
    }
}
