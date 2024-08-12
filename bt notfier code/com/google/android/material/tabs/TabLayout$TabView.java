/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.text.Layout
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.TooltipCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.MarginLayoutParamsCompat
 *  androidx.core.view.PointerIconCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.TextViewCompat
 *  com.google.android.material.R$layout
 *  com.google.android.material.ripple.RippleUtils
 *  com.google.android.material.tabs.TabLayout
 *  com.google.android.material.tabs.TabLayout$Tab
 */
package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.tabs.TabLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class TabLayout.TabView
extends LinearLayout {
    private Drawable baseBackgroundDrawable;
    private ImageView customIconView;
    private TextView customTextView;
    private View customView;
    private int defaultMaxLines;
    private ImageView iconView;
    private TabLayout.Tab tab;
    private TextView textView;
    final TabLayout this$0;

    public TabLayout.TabView(TabLayout tabLayout, Context context) {
        this.this$0 = tabLayout;
        super(context);
        this.defaultMaxLines = 2;
        this.updateBackgroundDrawable(context);
        ViewCompat.setPaddingRelative((View)this, (int)tabLayout.tabPaddingStart, (int)tabLayout.tabPaddingTop, (int)tabLayout.tabPaddingEnd, (int)tabLayout.tabPaddingBottom);
        this.setGravity(17);
        this.setOrientation(tabLayout.inlineLabel ^ 1);
        this.setClickable(true);
        ViewCompat.setPointerIcon((View)this, (PointerIconCompat)PointerIconCompat.getSystemIcon((Context)this.getContext(), (int)1002));
    }

    static /* synthetic */ void access$000(TabLayout.TabView tabView, Context context) {
        tabView.updateBackgroundDrawable(context);
    }

    static /* synthetic */ void access$300(TabLayout.TabView tabView, Canvas canvas) {
        tabView.drawBackground(canvas);
    }

    static /* synthetic */ int access$500(TabLayout.TabView tabView) {
        return tabView.getContentWidth();
    }

    private float approximateLineWidth(Layout layout, int n, float f) {
        return layout.getLineWidth(n) * (f / layout.getPaint().getTextSize());
    }

    private void drawBackground(Canvas canvas) {
        Drawable drawable = this.baseBackgroundDrawable;
        if (drawable == null) return;
        drawable.setBounds(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
        this.baseBackgroundDrawable.draw(canvas);
    }

    private int getContentWidth() {
        TextView textView = this.textView;
        int n = 0;
        ImageView imageView = this.iconView;
        View view = this.customView;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n < 3) {
            View view2 = (new View[]{textView, imageView, view})[n];
            int n5 = n2;
            int n6 = n3;
            int n7 = n4;
            if (view2 != null) {
                n5 = n2;
                n6 = n3;
                n7 = n4;
                if (view2.getVisibility() == 0) {
                    n3 = n4 != 0 ? Math.min(n3, view2.getLeft()) : view2.getLeft();
                    n4 = n4 != 0 ? Math.max(n2, view2.getRight()) : view2.getRight();
                    n7 = 1;
                    n6 = n3;
                    n5 = n4;
                }
            }
            ++n;
            n2 = n5;
            n3 = n6;
            n4 = n7;
        }
        return n2 - n3;
    }

    private void updateBackgroundDrawable(Context context) {
        int n = this.this$0.tabBackgroundResId;
        Object var4_3 = null;
        if (n != 0) {
            context = AppCompatResources.getDrawable((Context)context, (int)this.this$0.tabBackgroundResId);
            this.baseBackgroundDrawable = context;
            if (context != null && context.isStateful()) {
                this.baseBackgroundDrawable.setState(this.getDrawableState());
            }
        } else {
            this.baseBackgroundDrawable = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        context = gradientDrawable;
        if (this.this$0.tabRippleColorStateList != null) {
            context = new GradientDrawable();
            context.setCornerRadius(1.0E-5f);
            context.setColor(-1);
            ColorStateList colorStateList = RippleUtils.convertToRippleDrawableColor((ColorStateList)this.this$0.tabRippleColorStateList);
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.this$0.unboundedRipple) {
                    gradientDrawable = null;
                }
                if (this.this$0.unboundedRipple) {
                    context = var4_3;
                }
                context = new RippleDrawable(colorStateList, (Drawable)gradientDrawable, (Drawable)context);
            } else {
                context = DrawableCompat.wrap((Drawable)context);
                DrawableCompat.setTintList((Drawable)context, (ColorStateList)colorStateList);
                context = new LayerDrawable(new Drawable[]{gradientDrawable, context});
            }
        }
        ViewCompat.setBackground((View)this, (Drawable)context);
        this.this$0.invalidate();
    }

    private void updateTextAndIcon(TextView object, ImageView imageView) {
        Object object2 = this.tab;
        Object var7_4 = null;
        object2 = object2 != null && object2.getIcon() != null ? DrawableCompat.wrap((Drawable)this.tab.getIcon()).mutate() : null;
        Object object3 = this.tab;
        object3 = object3 != null ? object3.getText() : null;
        if (imageView != null) {
            if (object2 != null) {
                imageView.setImageDrawable((Drawable)object2);
                imageView.setVisibility(0);
                this.setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
        boolean bl = TextUtils.isEmpty((CharSequence)object3) ^ true;
        if (object != null) {
            if (bl) {
                object.setText((CharSequence)object3);
                object.setVisibility(0);
                this.setVisibility(0);
            } else {
                object.setVisibility(8);
                object.setText(null);
            }
        }
        if (imageView != null) {
            object = (ViewGroup.MarginLayoutParams)imageView.getLayoutParams();
            int n = bl && imageView.getVisibility() == 0 ? this.this$0.dpToPx(8) : 0;
            if (this.this$0.inlineLabel) {
                if (n != MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)object)) {
                    MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)object, (int)n);
                    object.bottomMargin = 0;
                    imageView.setLayoutParams((ViewGroup.LayoutParams)object);
                    imageView.requestLayout();
                }
            } else if (n != object.bottomMargin) {
                object.bottomMargin = n;
                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)object, (int)0);
                imageView.setLayoutParams((ViewGroup.LayoutParams)object);
                imageView.requestLayout();
            }
        }
        object = (object = this.tab) != null ? TabLayout.Tab.access$100((TabLayout.Tab)object) : null;
        if (bl) {
            object = var7_4;
        }
        TooltipCompat.setTooltipText((View)this, (CharSequence)object);
    }

    protected void drawableStateChanged() {
        boolean bl;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        Drawable drawable = this.baseBackgroundDrawable;
        boolean bl2 = bl = false;
        if (drawable != null) {
            bl2 = bl;
            if (drawable.isStateful()) {
                bl2 = false | this.baseBackgroundDrawable.setState(nArray);
            }
        }
        if (!bl2) return;
        this.invalidate();
        this.this$0.invalidate();
    }

    public TabLayout.Tab getTab() {
        return this.tab;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ActionBar.Tab.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ActionBar.Tab.class.getName());
    }

    public void onMeasure(int n, int n2) {
        float f;
        int n3;
        int n4;
        block13: {
            block14: {
                int n5;
                int n6;
                block11: {
                    block12: {
                        n6 = View.MeasureSpec.getSize((int)n);
                        n5 = View.MeasureSpec.getMode((int)n);
                        n4 = this.this$0.getTabMaxWidth();
                        n3 = n;
                        if (n4 <= 0) break block11;
                        if (n5 == 0) break block12;
                        n3 = n;
                        if (n6 <= n4) break block11;
                    }
                    n3 = View.MeasureSpec.makeMeasureSpec((int)this.this$0.tabMaxWidth, (int)Integer.MIN_VALUE);
                }
                super.onMeasure(n3, n2);
                if (this.textView == null) return;
                float f2 = this.this$0.tabTextSize;
                n4 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                n5 = 1;
                if (imageView != null && imageView.getVisibility() == 0) {
                    n = 1;
                    f = f2;
                } else {
                    imageView = this.textView;
                    f = f2;
                    n = n4;
                    if (imageView != null) {
                        f = f2;
                        n = n4;
                        if (imageView.getLineCount() > 1) {
                            f = this.this$0.tabTextMultiLineSize;
                            n = n4;
                        }
                    }
                }
                f2 = this.textView.getTextSize();
                n6 = this.textView.getLineCount();
                n4 = TextViewCompat.getMaxLines((TextView)this.textView);
                if (f == f2) {
                    if (n4 < 0) return;
                    if (n == n4) return;
                }
                n4 = n5;
                if (this.this$0.mode != 1) break block13;
                n4 = n5;
                if (!(f > f2)) break block13;
                n4 = n5;
                if (n6 != 1) break block13;
                imageView = this.textView.getLayout();
                if (imageView == null) break block14;
                n4 = n5;
                if (!(this.approximateLineWidth((Layout)imageView, 0, f) > (float)(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()))) break block13;
            }
            n4 = 0;
        }
        if (n4 == 0) return;
        this.textView.setTextSize(0, f);
        this.textView.setMaxLines(n);
        super.onMeasure(n3, n2);
    }

    public boolean performClick() {
        boolean bl;
        boolean bl2 = bl = super.performClick();
        if (this.tab == null) return bl2;
        if (!bl) {
            this.playSoundEffect(0);
        }
        this.tab.select();
        bl2 = true;
        return bl2;
    }

    void reset() {
        this.setTab(null);
        this.setSelected(false);
    }

    public void setSelected(boolean bl) {
        TextView textView;
        boolean bl2 = this.isSelected() != bl;
        super.setSelected(bl);
        if (bl2 && bl && Build.VERSION.SDK_INT < 16) {
            this.sendAccessibilityEvent(4);
        }
        if ((textView = this.textView) != null) {
            textView.setSelected(bl);
        }
        if ((textView = this.iconView) != null) {
            textView.setSelected(bl);
        }
        if ((textView = this.customView) == null) return;
        textView.setSelected(bl);
    }

    void setTab(TabLayout.Tab tab) {
        if (tab == this.tab) return;
        this.tab = tab;
        this.update();
    }

    final void update() {
        TabLayout.Tab tab = this.tab;
        Object var4_2 = null;
        View view = tab != null ? tab.getCustomView() : null;
        if (view != null) {
            ViewParent viewParent = view.getParent();
            if (viewParent != this) {
                if (viewParent != null) {
                    ((ViewGroup)viewParent).removeView(view);
                }
                this.addView(view);
            }
            this.customView = view;
            viewParent = this.textView;
            if (viewParent != null) {
                viewParent.setVisibility(8);
            }
            if ((viewParent = this.iconView) != null) {
                viewParent.setVisibility(8);
                this.iconView.setImageDrawable(null);
            }
            viewParent = (TextView)view.findViewById(16908308);
            this.customTextView = viewParent;
            if (viewParent != null) {
                this.defaultMaxLines = TextViewCompat.getMaxLines((TextView)viewParent);
            }
            this.customIconView = (ImageView)view.findViewById(16908294);
        } else {
            view = this.customView;
            if (view != null) {
                this.removeView(view);
                this.customView = null;
            }
            this.customTextView = null;
            this.customIconView = null;
        }
        view = this.customView;
        boolean bl = false;
        if (view == null) {
            if (this.iconView == null) {
                view = (ImageView)LayoutInflater.from((Context)this.getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup)this, false);
                this.addView(view, 0);
                this.iconView = view;
            }
            view = var4_2;
            if (tab != null) {
                view = var4_2;
                if (tab.getIcon() != null) {
                    view = DrawableCompat.wrap((Drawable)tab.getIcon()).mutate();
                }
            }
            if (view != null) {
                DrawableCompat.setTintList((Drawable)view, (ColorStateList)this.this$0.tabIconTint);
                if (this.this$0.tabIconTintMode != null) {
                    DrawableCompat.setTintMode((Drawable)view, (PorterDuff.Mode)this.this$0.tabIconTintMode);
                }
            }
            if (this.textView == null) {
                view = (TextView)LayoutInflater.from((Context)this.getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup)this, false);
                this.addView(view);
                this.textView = view;
                this.defaultMaxLines = TextViewCompat.getMaxLines((TextView)view);
            }
            TextViewCompat.setTextAppearance((TextView)this.textView, (int)this.this$0.tabTextAppearance);
            if (this.this$0.tabTextColors != null) {
                this.textView.setTextColor(this.this$0.tabTextColors);
            }
            this.updateTextAndIcon(this.textView, this.iconView);
        } else if (this.customTextView != null || this.customIconView != null) {
            this.updateTextAndIcon(this.customTextView, this.customIconView);
        }
        if (tab != null && !TextUtils.isEmpty((CharSequence)TabLayout.Tab.access$100((TabLayout.Tab)tab))) {
            this.setContentDescription(TabLayout.Tab.access$100((TabLayout.Tab)tab));
        }
        boolean bl2 = bl;
        if (tab != null) {
            bl2 = bl;
            if (tab.isSelected()) {
                bl2 = true;
            }
        }
        this.setSelected(bl2);
    }

    final void updateOrientation() {
        this.setOrientation(this.this$0.inlineLabel ^ 1);
        if (this.customTextView == null && this.customIconView == null) {
            this.updateTextAndIcon(this.textView, this.iconView);
        } else {
            this.updateTextAndIcon(this.customTextView, this.customIconView);
        }
    }
}
