/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TabHost
 *  android.widget.TabHost$OnTabChangeListener
 *  android.widget.TabHost$TabContentFactory
 *  android.widget.TabHost$TabSpec
 *  android.widget.TabWidget
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTabHost$DummyTabFactory
 *  androidx.fragment.app.FragmentTabHost$SavedState
 *  androidx.fragment.app.FragmentTabHost$TabInfo
 *  androidx.fragment.app.FragmentTransaction
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTabHost;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost
extends TabHost
implements TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<TabInfo> mTabs = new ArrayList();

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.initFragmentTabHost(context, null);
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initFragmentTabHost(context, attributeSet);
    }

    private FragmentTransaction doTabChanged(String string, FragmentTransaction fragmentTransaction) {
        TabInfo tabInfo = this.getTabInfoForTag(string);
        string = fragmentTransaction;
        if (this.mLastTab == tabInfo) return string;
        string = fragmentTransaction;
        if (fragmentTransaction == null) {
            string = this.mFragmentManager.beginTransaction();
        }
        if ((fragmentTransaction = this.mLastTab) != null && fragmentTransaction.fragment != null) {
            string.detach(this.mLastTab.fragment);
        }
        if (tabInfo != null) {
            if (tabInfo.fragment == null) {
                tabInfo.fragment = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), tabInfo.clss.getName());
                tabInfo.fragment.setArguments(tabInfo.args);
                string.add(this.mContainerId, tabInfo.fragment, tabInfo.tag);
            } else {
                string.attach(tabInfo.fragment);
            }
        }
        this.mLastTab = tabInfo;
        return string;
    }

    private void ensureContent() {
        if (this.mRealTabContent != null) return;
        Object object = (FrameLayout)this.findViewById(this.mContainerId);
        this.mRealTabContent = object;
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No tab content FrameLayout found for id ");
        ((StringBuilder)object).append(this.mContainerId);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    private void ensureHierarchy(Context context) {
        if (this.findViewById(16908307) != null) return;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        TabWidget tabWidget = new TabWidget(context);
        tabWidget.setId(16908307);
        tabWidget.setOrientation(0);
        linearLayout.addView((View)tabWidget, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2, 0.0f));
        tabWidget = new FrameLayout(context);
        tabWidget.setId(0x1020011);
        linearLayout.addView((View)tabWidget, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(0, 0, 0.0f));
        context = new FrameLayout(context);
        this.mRealTabContent = context;
        context.setId(this.mContainerId);
        linearLayout.addView((View)context, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    private TabInfo getTabInfoForTag(String string) {
        int n = this.mTabs.size();
        int n2 = 0;
        while (n2 < n) {
            TabInfo tabInfo = this.mTabs.get(n2);
            if (tabInfo.tag.equals(string)) {
                return tabInfo;
            }
            ++n2;
        }
        return null;
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.mContainerId = context.getResourceId(0, 0);
        context.recycle();
        super.setOnTabChangedListener((TabHost.OnTabChangeListener)this);
    }

    @Deprecated
    public void addTab(TabHost.TabSpec tabSpec, Class<?> tabInfo, Bundle bundle) {
        tabSpec.setContent((TabHost.TabContentFactory)new DummyTabFactory(this.mContext));
        String string = tabSpec.getTag();
        tabInfo = new TabInfo(string, tabInfo, bundle);
        if (this.mAttached) {
            tabInfo.fragment = this.mFragmentManager.findFragmentByTag(string);
            if (tabInfo.fragment != null && !tabInfo.fragment.isDetached()) {
                bundle = this.mFragmentManager.beginTransaction();
                bundle.detach(tabInfo.fragment);
                bundle.commit();
            }
        }
        this.mTabs.add(tabInfo);
        this.addTab(tabSpec);
    }

    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String string = this.getCurrentTabTag();
        int n = this.mTabs.size();
        FragmentTransaction fragmentTransaction = null;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mAttached = true;
                if ((fragmentTransaction = this.doTabChanged(string, fragmentTransaction)) == null) return;
                fragmentTransaction.commit();
                this.mFragmentManager.executePendingTransactions();
                return;
            }
            TabInfo tabInfo = this.mTabs.get(n2);
            tabInfo.fragment = this.mFragmentManager.findFragmentByTag(tabInfo.tag);
            FragmentTransaction fragmentTransaction2 = fragmentTransaction;
            if (tabInfo.fragment != null) {
                fragmentTransaction2 = fragmentTransaction;
                if (!tabInfo.fragment.isDetached()) {
                    if (tabInfo.tag.equals(string)) {
                        this.mLastTab = tabInfo;
                        fragmentTransaction2 = fragmentTransaction;
                    } else {
                        fragmentTransaction2 = fragmentTransaction;
                        if (fragmentTransaction == null) {
                            fragmentTransaction2 = this.mFragmentManager.beginTransaction();
                        }
                        fragmentTransaction2.detach(tabInfo.fragment);
                    }
                }
            }
            ++n2;
            fragmentTransaction = fragmentTransaction2;
        }
    }

    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    @Deprecated
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.setCurrentTabByTag(parcelable.curTab);
    }

    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.curTab = this.getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public void onTabChanged(String string) {
        TabHost.OnTabChangeListener onTabChangeListener;
        if (this.mAttached && (onTabChangeListener = this.doTabChanged(string, null)) != null) {
            onTabChangeListener.commit();
        }
        if ((onTabChangeListener = this.mOnTabChangeListener) == null) return;
        onTabChangeListener.onTabChanged(string);
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager) {
        this.ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.ensureContent();
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager, int n) {
        this.ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = n;
        this.ensureContent();
        this.mRealTabContent.setId(n);
        if (this.getId() != -1) return;
        this.setId(0x1020012);
    }
}
