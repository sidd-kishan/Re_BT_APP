/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.chip.Chip
 *  com.google.android.material.chip.ChipGroup$CheckedStateTracker
 *  com.google.android.material.chip.ChipGroup$LayoutParams
 *  com.google.android.material.chip.ChipGroup$OnCheckedChangeListener
 *  com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener
 *  com.google.android.material.internal.FlowLayout
 *  com.google.android.material.internal.ThemeEnforcement
 */
package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;

/*
 * Exception performing whole class analysis ignored.
 */
public class ChipGroup
extends FlowLayout {
    private int checkedId = -1;
    private final CheckedStateTracker checkedStateTracker = new CheckedStateTracker(this, null);
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private OnCheckedChangeListener onCheckedChangeListener;
    private PassThroughHierarchyChangeListener passThroughListener = new PassThroughHierarchyChangeListener(this, null);
    private boolean protectFromCheckedChange = false;
    private boolean singleSelection;

    public ChipGroup(Context context) {
        this(context, null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        context = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.ChipGroup, (int)n, (int)R.style.Widget_MaterialComponents_ChipGroup, (int[])new int[0]);
        n = context.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        this.setChipSpacingHorizontal(context.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, n));
        this.setChipSpacingVertical(context.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, n));
        this.setSingleLine(context.getBoolean(R.styleable.ChipGroup_singleLine, false));
        this.setSingleSelection(context.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        n = context.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        if (n != -1) {
            this.checkedId = n;
        }
        context.recycle();
        super.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)this.passThroughListener);
    }

    static /* synthetic */ boolean access$300(ChipGroup chipGroup) {
        return chipGroup.protectFromCheckedChange;
    }

    static /* synthetic */ int access$400(ChipGroup chipGroup) {
        return chipGroup.checkedId;
    }

    static /* synthetic */ boolean access$500(ChipGroup chipGroup) {
        return chipGroup.singleSelection;
    }

    static /* synthetic */ void access$600(ChipGroup chipGroup, int n, boolean bl) {
        chipGroup.setCheckedStateForView(n, bl);
    }

    static /* synthetic */ void access$700(ChipGroup chipGroup, int n) {
        chipGroup.setCheckedId(n);
    }

    static /* synthetic */ CheckedStateTracker access$800(ChipGroup chipGroup) {
        return chipGroup.checkedStateTracker;
    }

    private void setCheckedId(int n) {
        this.checkedId = n;
        OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
        if (onCheckedChangeListener == null) return;
        if (!this.singleSelection) return;
        onCheckedChangeListener.onCheckedChanged(this, n);
    }

    private void setCheckedStateForView(int n, boolean bl) {
        View view = this.findViewById(n);
        if (!(view instanceof Chip)) return;
        this.protectFromCheckedChange = true;
        ((Chip)view).setChecked(bl);
        this.protectFromCheckedChange = false;
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        Chip chip;
        if (view instanceof Chip && (chip = (Chip)view).isChecked()) {
            int n2 = this.checkedId;
            if (n2 != -1 && this.singleSelection) {
                this.setCheckedStateForView(n2, false);
            }
            this.setCheckedId(chip.getId());
        }
        super.addView(view, n, layoutParams);
    }

    public void check(int n) {
        int n2 = this.checkedId;
        if (n == n2) {
            return;
        }
        if (n2 != -1 && this.singleSelection) {
            this.setCheckedStateForView(n2, false);
        }
        if (n != -1) {
            this.setCheckedStateForView(n, true);
        }
        this.setCheckedId(n);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = super.checkLayoutParams(layoutParams) && layoutParams instanceof LayoutParams;
        return bl;
    }

    public void clearCheck() {
        this.protectFromCheckedChange = true;
        int n = 0;
        while (true) {
            if (n >= this.getChildCount()) {
                this.protectFromCheckedChange = false;
                this.setCheckedId(-1);
                return;
            }
            View view = this.getChildAt(n);
            if (view instanceof Chip) {
                ((Chip)view).setChecked(false);
            }
            ++n;
        }
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCheckedChipId() {
        int n = this.singleSelection ? this.checkedId : -1;
        return n;
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        int n = this.checkedId;
        if (n == -1) return;
        this.setCheckedStateForView(n, true);
        this.setCheckedId(this.checkedId);
    }

    public void setChipSpacing(int n) {
        this.setChipSpacingHorizontal(n);
        this.setChipSpacingVertical(n);
    }

    public void setChipSpacingHorizontal(int n) {
        if (this.chipSpacingHorizontal == n) return;
        this.chipSpacingHorizontal = n;
        this.setItemSpacing(n);
        this.requestLayout();
    }

    public void setChipSpacingHorizontalResource(int n) {
        this.setChipSpacingHorizontal(this.getResources().getDimensionPixelOffset(n));
    }

    public void setChipSpacingResource(int n) {
        this.setChipSpacing(this.getResources().getDimensionPixelOffset(n));
    }

    public void setChipSpacingVertical(int n) {
        if (this.chipSpacingVertical == n) return;
        this.chipSpacingVertical = n;
        this.setLineSpacing(n);
        this.requestLayout();
    }

    public void setChipSpacingVerticalResource(int n) {
        this.setChipSpacingVertical(this.getResources().getDimensionPixelOffset(n));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int n) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        PassThroughHierarchyChangeListener.access$202((PassThroughHierarchyChangeListener)this.passThroughListener, (ViewGroup.OnHierarchyChangeListener)onHierarchyChangeListener);
    }

    @Deprecated
    public void setShowDividerHorizontal(int n) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int n) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int n) {
        this.setSingleLine(this.getResources().getBoolean(n));
    }

    public void setSingleSelection(int n) {
        this.setSingleSelection(this.getResources().getBoolean(n));
    }

    public void setSingleSelection(boolean bl) {
        if (this.singleSelection == bl) return;
        this.singleSelection = bl;
        this.clearCheck();
    }
}
