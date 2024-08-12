/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Helper
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintSet$Constraint
 *  androidx.constraintlayout.widget.R$id
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper
extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds = new int[32];
    private HashMap<Integer, String> mMap = new HashMap();
    protected String mReferenceIds;
    protected boolean mUseViewMeasure = false;
    private View[] mViews = null;
    protected Context myContext;

    public ConstraintHelper(Context context) {
        super(context);
        this.myContext = context;
        this.init(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myContext = context;
        this.init(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.myContext = context;
        this.init(attributeSet);
    }

    private void addID(String string) {
        int n;
        Object object;
        if (string == null) return;
        if (string.length() == 0) return;
        if (this.myContext == null) {
            return;
        }
        string = string.trim();
        if (this.getParent() instanceof ConstraintLayout) {
            object = (ConstraintLayout)this.getParent();
        }
        if ((n = this.findId(string)) != 0) {
            this.mMap.put(n, string);
            this.addRscID(n);
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("Could not find id of \"");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append("\"");
            Log.w((String)"ConstraintHelper", (String)((StringBuilder)object).toString());
        }
    }

    private void addRscID(int n) {
        if (n == this.getId()) {
            return;
        }
        int n2 = this.mCount;
        int[] nArray = this.mIds;
        if (n2 + 1 > nArray.length) {
            this.mIds = Arrays.copyOf(nArray, nArray.length * 2);
        }
        nArray = this.mIds;
        n2 = this.mCount;
        nArray[n2] = n;
        this.mCount = n2 + 1;
    }

    private int[] convertReferenceString(View object, String object2) {
        String[] stringArray = ((String)object2).split(",");
        object.getContext();
        object2 = new int[stringArray.length];
        int n = 0;
        int n2 = 0;
        while (true) {
            if (n >= stringArray.length) {
                object = object2;
                if (n2 == stringArray.length) return object;
                object = Arrays.copyOf((int[])object2, n2);
                return object;
            }
            int n3 = this.findId(stringArray[n].trim());
            int n4 = n2;
            if (n3 != 0) {
                object2[n2] = n3;
                n4 = n2 + 1;
            }
            ++n;
            n2 = n4;
        }
    }

    private int findId(ConstraintLayout constraintLayout, String string) {
        if (string == null) return 0;
        if (constraintLayout == null) {
            return 0;
        }
        Resources resources = this.myContext.getResources();
        if (resources == null) {
            return 0;
        }
        int n = constraintLayout.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = constraintLayout.getChildAt(n2);
            if (view.getId() != -1) {
                String string2 = null;
                try {
                    String string3;
                    string2 = string3 = resources.getResourceEntryName(view.getId());
                }
                catch (Resources.NotFoundException notFoundException) {
                    // empty catch block
                }
                if (string.equals(string2)) {
                    return view.getId();
                }
            }
            ++n2;
        }
        return 0;
    }

    private int findId(String string) {
        int n;
        ConstraintLayout constraintLayout = this.getParent() instanceof ConstraintLayout ? (ConstraintLayout)this.getParent() : null;
        boolean bl = this.isInEditMode();
        int n2 = n = 0;
        if (bl) {
            n2 = n;
            if (constraintLayout != null) {
                Object object = constraintLayout.getDesignInformation(0, (Object)string);
                n2 = n;
                if (object instanceof Integer) {
                    n2 = (Integer)object;
                }
            }
        }
        n = n2;
        if (n2 == 0) {
            n = n2;
            if (constraintLayout != null) {
                n = this.findId(constraintLayout, string);
            }
        }
        n2 = n;
        if (n == 0) {
            try {
                n2 = R.id.class.getField(string).getInt(null);
            }
            catch (Exception exception) {
                n2 = n;
            }
        }
        n = n2;
        if (n2 != 0) return n;
        n = this.myContext.getResources().getIdentifier(string, "id", this.myContext.getPackageName());
        return n;
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e((String)"ConstraintHelper", (String)"Views added to a ConstraintHelper need to have an id");
            return;
        }
        if (view.getParent() == null) {
            Log.e((String)"ConstraintHelper", (String)"Views added to a ConstraintHelper need to have a parent");
            return;
        }
        this.mReferenceIds = null;
        this.addRscID(view.getId());
        this.requestLayout();
    }

    protected void applyLayoutFeatures() {
        ViewParent viewParent = this.getParent();
        if (viewParent == null) return;
        if (!(viewParent instanceof ConstraintLayout)) return;
        this.applyLayoutFeatures((ConstraintLayout)viewParent);
    }

    protected void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int n = this.getVisibility();
        float f = Build.VERSION.SDK_INT >= 21 ? this.getElevation() : 0.0f;
        int n2 = 0;
        while (n2 < this.mCount) {
            View view = constraintLayout.getViewById(this.mIds[n2]);
            if (view != null) {
                view.setVisibility(n);
                if (f > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    view.setTranslationZ(view.getTranslationZ() + f);
                }
            }
            ++n2;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    protected View[] getViews(ConstraintLayout constraintLayout) {
        View[] viewArray = this.mViews;
        if (viewArray == null || viewArray.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        int n = 0;
        while (n < this.mCount) {
            int n2 = this.mIds[n];
            this.mViews[n] = constraintLayout.getViewById(n2);
            ++n;
        }
        return this.mViews;
    }

    protected void init(AttributeSet attributeSet) {
        if (attributeSet == null) return;
        attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
        int n = attributeSet.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                attributeSet.recycle();
                return;
            }
            int n3 = attributeSet.getIndex(n2);
            if (n3 == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                String string;
                this.mReferenceIds = string = attributeSet.getString(n3);
                this.setIds(string);
            }
            ++n2;
        }
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        if (constraint.layout.mReferenceIds != null) {
            this.setReferencedIds(constraint.layout.mReferenceIds);
        } else if (constraint.layout.mReferenceIdString != null && constraint.layout.mReferenceIdString.length() > 0) {
            constraint.layout.mReferenceIds = this.convertReferenceString(this, constraint.layout.mReferenceIdString);
        }
        helperWidget.removeAllIds();
        if (constraint.layout.mReferenceIds == null) return;
        int n = 0;
        while (n < constraint.layout.mReferenceIds.length) {
            layoutParams = (ConstraintWidget)sparseArray.get(constraint.layout.mReferenceIds[n]);
            if (layoutParams != null) {
                helperWidget.add((ConstraintWidget)layoutParams);
            }
            ++n;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String string = this.mReferenceIds;
        if (string == null) return;
        this.setIds(string);
    }

    public void onDraw(Canvas canvas) {
    }

    protected void onMeasure(int n, int n2) {
        if (this.mUseViewMeasure) {
            super.onMeasure(n, n2);
        } else {
            this.setMeasuredDimension(0, 0);
        }
    }

    public void removeView(View object) {
        int n = object.getId();
        if (n == -1) {
            return;
        }
        this.mReferenceIds = null;
        for (int i = 0; i < this.mCount; ++i) {
            if (this.mIds[i] != n) continue;
            while (i < (n = this.mCount) - 1) {
                object = this.mIds;
                n = i + 1;
                object[i] = object[n];
                i = n;
            }
            this.mIds[n - 1] = 0;
            this.mCount = n - 1;
            break;
        }
        this.requestLayout();
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean bl) {
    }

    protected void setIds(String string) {
        this.mReferenceIds = string;
        if (string == null) {
            return;
        }
        int n = 0;
        this.mCount = 0;
        while (true) {
            int n2;
            if ((n2 = string.indexOf(44, n)) == -1) {
                this.addID(string.substring(n));
                return;
            }
            this.addID(string.substring(n, n2));
            n = n2 + 1;
        }
    }

    public void setReferencedIds(int[] nArray) {
        this.mReferenceIds = null;
        int n = 0;
        this.mCount = 0;
        while (n < nArray.length) {
            this.addRscID(nArray[n]);
            ++n;
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.removeAllIds();
        int n = 0;
        while (n < this.mCount) {
            helper.add((ConstraintWidget)sparseArray.get(this.mIds[n]));
            ++n;
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        Helper helper;
        if (this.isInEditMode()) {
            this.setIds(this.mReferenceIds);
        }
        if ((helper = this.mHelperWidget) == null) {
            return;
        }
        helper.removeAllIds();
        int n = 0;
        while (true) {
            if (n >= this.mCount) {
                this.mHelperWidget.updateConstraints(constraintLayout.mLayoutWidget);
                return;
            }
            int n2 = this.mIds[n];
            View view = constraintLayout.getViewById(n2);
            helper = view;
            if (view == null) {
                String string = this.mMap.get(n2);
                n2 = this.findId(constraintLayout, string);
                helper = view;
                if (n2 != 0) {
                    this.mIds[n] = n2;
                    this.mMap.put(n2, string);
                    helper = constraintLayout.getViewById(n2);
                }
            }
            if (helper != null) {
                this.mHelperWidget.add(constraintLayout.getViewWidget((View)helper));
            }
            ++n;
        }
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        if (!(layoutParams instanceof ConstraintLayout.LayoutParams)) return;
        ((ConstraintLayout.LayoutParams)layoutParams).widget = (ConstraintWidget)this.mHelperWidget;
    }
}
