/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewStub
 *  android.view.Window
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$id
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.app.AlertController$ButtonHandler
 *  androidx.appcompat.app.AlertController$RecycleListView
 *  androidx.appcompat.app.AppCompatDialog
 *  androidx.appcompat.widget.LinearLayoutCompat$LayoutParams
 *  androidx.core.view.ViewCompat
 *  androidx.core.widget.NestedScrollView
 *  androidx.core.widget.NestedScrollView$OnScrollChangeListener
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;

class AlertController {
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View.OnClickListener mButtonHandler = new /* Unavailable Anonymous Inner Class!! */;
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint = 0;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem = -1;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private int mIconId = 0;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified = false;
    private int mViewSpacingTop;
    private final Window mWindow;

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new ButtonHandler((DialogInterface)appCompatDialog);
        context = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = context.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = context.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = context.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = context.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = context.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = context.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = context.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = context.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        context.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    static boolean canTextInput(View view) {
        int n;
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        view = (ViewGroup)view;
        int n2 = view.getChildCount();
        do {
            if (n2 <= 0) return false;
            n2 = n = n2 - 1;
        } while (!AlertController.canTextInput(view.getChildAt(n)));
        return true;
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    static void manageScrollIndicators(View view, View view2, View view3) {
        int n;
        int n2 = 0;
        if (view2 != null) {
            n = view.canScrollVertically(-1) ? 0 : 4;
            view2.setVisibility(n);
        }
        if (view3 == null) return;
        n = view.canScrollVertically(1) ? n2 : 4;
        view3.setVisibility(n);
    }

    private ViewGroup resolvePanel(View view, View view2) {
        ViewParent viewParent;
        if (view == null) {
            view = view2;
            if (!(view2 instanceof ViewStub)) return (ViewGroup)view;
            view = ((ViewStub)view2).inflate();
            return (ViewGroup)view;
        }
        if (view2 != null && (viewParent = view2.getParent()) instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView(view2);
        }
        view2 = view;
        if (!(view instanceof ViewStub)) return (ViewGroup)view2;
        view2 = ((ViewStub)view).inflate();
        return (ViewGroup)view2;
    }

    private int selectContentView() {
        int n = this.mButtonPanelSideLayout;
        if (n == 0) {
            return this.mAlertDialogLayout;
        }
        if (this.mButtonPanelLayoutHint != 1) return this.mAlertDialogLayout;
        return n;
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view, int n, int n2) {
        View view2 = this.mWindow.findViewById(R.id.scrollIndicatorUp);
        View view3 = this.mWindow.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators((View)view, (int)n, (int)n2);
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
            if (view3 == null) return;
            viewGroup.removeView(view3);
        } else {
            view = view2;
            if (view2 != null) {
                view = view2;
                if ((n & 1) == 0) {
                    viewGroup.removeView(view2);
                    view = null;
                }
            }
            view2 = view3;
            if (view3 != null) {
                view2 = view3;
                if ((n & 2) == 0) {
                    viewGroup.removeView(view3);
                    view2 = null;
                }
            }
            if (view == null) {
                if (view2 == null) return;
            }
            if (this.mMessage != null) {
                this.mScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)new /* Unavailable Anonymous Inner Class!! */);
                this.mScrollView.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            } else {
                view3 = this.mListView;
                if (view3 != null) {
                    view3.setOnScrollListener((AbsListView.OnScrollListener)new /* Unavailable Anonymous Inner Class!! */);
                    this.mListView.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
                } else {
                    if (view != null) {
                        viewGroup.removeView(view);
                    }
                    if (view2 == null) return;
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void setupButtons(ViewGroup viewGroup) {
        int n;
        int n2;
        Button button;
        this.mButtonPositive = button = (Button)viewGroup.findViewById(16908313);
        button.setOnClickListener(this.mButtonHandler);
        boolean bl = TextUtils.isEmpty((CharSequence)this.mButtonPositiveText);
        int n3 = 1;
        if (bl && this.mButtonPositiveIcon == null) {
            this.mButtonPositive.setVisibility(8);
            n2 = 0;
        } else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            button = this.mButtonPositiveIcon;
            if (button != null) {
                n2 = this.mButtonIconDimen;
                button.setBounds(0, 0, n2, n2);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
            }
            this.mButtonPositive.setVisibility(0);
            n2 = 1;
        }
        this.mButtonNegative = button = (Button)viewGroup.findViewById(16908314);
        button.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty((CharSequence)this.mButtonNegativeText) && this.mButtonNegativeIcon == null) {
            this.mButtonNegative.setVisibility(8);
        } else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            button = this.mButtonNegativeIcon;
            if (button != null) {
                n = this.mButtonIconDimen;
                button.setBounds(0, 0, n, n);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
            }
            this.mButtonNegative.setVisibility(0);
            n2 |= 2;
        }
        this.mButtonNeutral = button = (Button)viewGroup.findViewById(16908315);
        button.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty((CharSequence)this.mButtonNeutralText) && this.mButtonNeutralIcon == null) {
            this.mButtonNeutral.setVisibility(8);
        } else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            button = this.mButtonNeutralIcon;
            if (button != null) {
                n = this.mButtonIconDimen;
                button.setBounds(0, 0, n, n);
                this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
            }
            this.mButtonNeutral.setVisibility(0);
            n2 |= 4;
        }
        if (AlertController.shouldCenterSingleButton(this.mContext)) {
            if (n2 == 1) {
                this.centerButton(this.mButtonPositive);
            } else if (n2 == 2) {
                this.centerButton(this.mButtonNegative);
            } else if (n2 == 4) {
                this.centerButton(this.mButtonNeutral);
            }
        }
        n2 = n2 != 0 ? n3 : 0;
        if (n2 != 0) return;
        viewGroup.setVisibility(8);
    }

    private void setupContent(ViewGroup viewGroup) {
        TextView textView;
        Object object;
        this.mScrollView = object = (NestedScrollView)this.mWindow.findViewById(R.id.scrollView);
        object.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        this.mMessageView = textView = (TextView)viewGroup.findViewById(16908299);
        if (textView == null) {
            return;
        }
        object = this.mMessage;
        if (object != null) {
            textView.setText((CharSequence)object);
        } else {
            textView.setVisibility(8);
            this.mScrollView.removeView((View)this.mMessageView);
            if (this.mListView != null) {
                viewGroup = (ViewGroup)this.mScrollView.getParent();
                int n = viewGroup.indexOfChild((View)this.mScrollView);
                viewGroup.removeViewAt(n);
                viewGroup.addView((View)this.mListView, n, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroup.setVisibility(8);
            }
        }
    }

    private void setupCustomContent(ViewGroup viewGroup) {
        Object object = this.mView;
        boolean bl = false;
        if (object == null) {
            object = this.mViewLayoutResId != 0 ? LayoutInflater.from((Context)this.mContext).inflate(this.mViewLayoutResId, viewGroup, false) : null;
        }
        if (object != null) {
            bl = true;
        }
        if (!bl || !AlertController.canTextInput(object)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (bl) {
            FrameLayout frameLayout = (FrameLayout)this.mWindow.findViewById(R.id.custom);
            frameLayout.addView(object, new ViewGroup.LayoutParams(-1, -1));
            if (this.mViewSpacingSpecified) {
                frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.mListView == null) return;
            ((LinearLayoutCompat.LayoutParams)viewGroup.getLayoutParams()).weight = 0.0f;
        } else {
            viewGroup.setVisibility(8);
        }
    }

    private void setupTitle(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            viewGroup.addView(this.mCustomTitleView, 0, layoutParams);
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
        } else {
            this.mIconView = (ImageView)this.mWindow.findViewById(16908294);
            if (TextUtils.isEmpty((CharSequence)this.mTitle) ^ true && this.mShowTitle) {
                viewGroup = (TextView)this.mWindow.findViewById(R.id.alertTitle);
                this.mTitleView = viewGroup;
                viewGroup.setText(this.mTitle);
                int n = this.mIconId;
                if (n != 0) {
                    this.mIconView.setImageResource(n);
                } else {
                    viewGroup = this.mIcon;
                    if (viewGroup != null) {
                        this.mIconView.setImageDrawable((Drawable)viewGroup);
                    } else {
                        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                        this.mIconView.setVisibility(8);
                    }
                }
            } else {
                this.mWindow.findViewById(R.id.title_template).setVisibility(8);
                this.mIconView.setVisibility(8);
                viewGroup.setVisibility(8);
            }
        }
    }

    private void setupView() {
        View view = this.mWindow.findViewById(R.id.parentPanel);
        View view2 = view.findViewById(R.id.topPanel);
        View view3 = view.findViewById(R.id.contentPanel);
        View view4 = view.findViewById(R.id.buttonPanel);
        view = (ViewGroup)view.findViewById(R.id.customPanel);
        this.setupCustomContent((ViewGroup)view);
        View view5 = view.findViewById(R.id.topPanel);
        View view6 = view.findViewById(R.id.contentPanel);
        View view7 = view.findViewById(R.id.buttonPanel);
        view2 = this.resolvePanel(view5, view2);
        view3 = this.resolvePanel(view6, view3);
        view4 = this.resolvePanel(view7, view4);
        this.setupContent((ViewGroup)view3);
        this.setupButtons((ViewGroup)view4);
        this.setupTitle((ViewGroup)view2);
        int n = 0;
        int n2 = view != null && view.getVisibility() != 8 ? 1 : 0;
        int n3 = view2 != null && view2.getVisibility() != 8 ? 1 : 0;
        boolean bl = view4 != null && view4.getVisibility() != 8;
        if (!bl && view3 != null && (view4 = view3.findViewById(R.id.textSpacerNoButtons)) != null) {
            view4.setVisibility(0);
        }
        if (n3 != 0) {
            view4 = this.mScrollView;
            if (view4 != null) {
                view4.setClipToPadding(true);
            }
            view4 = null;
            if (this.mMessage != null || this.mListView != null) {
                view4 = view2.findViewById(R.id.titleDividerNoCustom);
            }
            if (view4 != null) {
                view4.setVisibility(0);
            }
        } else if (view3 != null && (view4 = view3.findViewById(R.id.textSpacerNoTitle)) != null) {
            view4.setVisibility(0);
        }
        if ((view4 = this.mListView) instanceof RecycleListView) {
            ((RecycleListView)view4).setHasDecor(n3 != 0, bl);
        }
        if (n2 == 0) {
            view4 = this.mListView;
            if (view4 == null) {
                view4 = this.mScrollView;
            }
            if (view4 != null) {
                n2 = n;
                if (bl) {
                    n2 = 2;
                }
                this.setScrollIndicators((ViewGroup)view3, view4, n3 | n2, 3);
            }
        }
        if ((view4 = this.mListView) == null) return;
        view3 = this.mAdapter;
        if (view3 == null) return;
        view4.setAdapter((ListAdapter)view3);
        n2 = this.mCheckedItem;
        if (n2 <= -1) return;
        view4.setItemChecked(n2, true);
        view4.setSelection(n2);
    }

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context = context.getTheme();
        int n = R.attr.alertDialogCenterButtons;
        boolean bl = true;
        context.resolveAttribute(n, typedValue, true);
        if (typedValue.data != 0) return bl;
        bl = false;
        return bl;
    }

    public Button getButton(int n) {
        if (n == -3) return this.mButtonNeutral;
        if (n == -2) return this.mButtonNegative;
        if (n == -1) return this.mButtonPositive;
        return null;
    }

    public int getIconAttributeResId(int n) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(n, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        int n = this.selectContentView();
        this.mDialog.setContentView(n);
        this.setupView();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        boolean bl = nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
        return bl;
    }

    public boolean onKeyUp(int n, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        boolean bl = nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
        return bl;
    }

    public void setButton(int n, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        Message message2 = message;
        if (message == null) {
            message2 = message;
            if (onClickListener != null) {
                message2 = this.mHandler.obtainMessage(n, (Object)onClickListener);
            }
        }
        if (n != -3) {
            if (n != -2) {
                if (n != -1) throw new IllegalArgumentException("Button does not exist");
                this.mButtonPositiveText = charSequence;
                this.mButtonPositiveMessage = message2;
                this.mButtonPositiveIcon = drawable;
            } else {
                this.mButtonNegativeText = charSequence;
                this.mButtonNegativeMessage = message2;
                this.mButtonNegativeIcon = drawable;
            }
        } else {
            this.mButtonNeutralText = charSequence;
            this.mButtonNeutralMessage = message2;
            this.mButtonNeutralIcon = drawable;
        }
    }

    public void setButtonPanelLayoutHint(int n) {
        this.mButtonPanelLayoutHint = n;
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setIcon(int n) {
        this.mIcon = null;
        this.mIconId = n;
        ImageView imageView = this.mIconView;
        if (imageView == null) return;
        if (n != 0) {
            imageView.setVisibility(0);
            this.mIconView.setImageResource(this.mIconId);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        ImageView imageView = this.mIconView;
        if (imageView == null) return;
        if (drawable != null) {
            imageView.setVisibility(0);
            this.mIconView.setImageDrawable(drawable);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView == null) return;
        textView.setText(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TextView textView = this.mTitleView;
        if (textView == null) return;
        textView.setText(charSequence);
    }

    public void setView(int n) {
        this.mView = null;
        this.mViewLayoutResId = n;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view, int n, int n2, int n3, int n4) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = n;
        this.mViewSpacingTop = n2;
        this.mViewSpacingRight = n3;
        this.mViewSpacingBottom = n4;
    }
}
