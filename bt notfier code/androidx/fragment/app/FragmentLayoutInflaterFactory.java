/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  androidx.fragment.R$styleable
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.fragment.app.FragmentFactory
 *  androidx.fragment.app.FragmentManager
 */
package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;

class FragmentLayoutInflaterFactory
implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public View onCreateView(View object, String string, Context object2, AttributeSet object3) {
        if (FragmentContainerView.class.getName().equals(string)) {
            return new FragmentContainerView((Context)object2, (AttributeSet)object3, this.mFragmentManager);
        }
        boolean bl = "fragment".equals(string);
        string = null;
        if (!bl) {
            return null;
        }
        String string2 = object3.getAttributeValue(null, "class");
        TypedArray typedArray = object2.obtainStyledAttributes((AttributeSet)object3, R.styleable.Fragment);
        String string3 = string2;
        if (string2 == null) {
            string3 = typedArray.getString(R.styleable.Fragment_android_name);
        }
        int n = typedArray.getResourceId(R.styleable.Fragment_android_id, -1);
        String string4 = typedArray.getString(R.styleable.Fragment_android_tag);
        typedArray.recycle();
        if (string3 == null) return null;
        if (!FragmentFactory.isFragmentClass((ClassLoader)object2.getClassLoader(), (String)string3)) {
            return null;
        }
        int n2 = object != null ? object.getId() : 0;
        if (n2 == -1 && n == -1 && string4 == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(object3.getPositionDescription());
            ((StringBuilder)object).append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            ((StringBuilder)object).append(string3);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (n != -1) {
            string = this.mFragmentManager.findFragmentById(n);
        }
        string2 = string;
        if (string == null) {
            string2 = string;
            if (string4 != null) {
                string2 = this.mFragmentManager.findFragmentByTag(string4);
            }
        }
        string = string2;
        if (string2 == null) {
            string = string2;
            if (n2 != -1) {
                string = this.mFragmentManager.findFragmentById(n2);
            }
        }
        if (string == null) {
            string = this.mFragmentManager.getFragmentFactory().instantiate(object2.getClassLoader(), string3);
            ((Fragment)string).mFromLayout = true;
            int n3 = n != 0 ? n : n2;
            ((Fragment)string).mFragmentId = n3;
            ((Fragment)string).mContainerId = n2;
            ((Fragment)string).mTag = string4;
            ((Fragment)string).mInLayout = true;
            ((Fragment)string).mFragmentManager = this.mFragmentManager;
            ((Fragment)string).mHost = this.mFragmentManager.getHost();
            string.onInflate(this.mFragmentManager.getHost().getContext(), (AttributeSet)object3, ((Fragment)string).mSavedFragmentState);
            string2 = this.mFragmentManager.addFragment((Fragment)string);
            object2 = string;
            object3 = string2;
            if (FragmentManager.isLoggingEnabled((int)2)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Fragment ");
                ((StringBuilder)object2).append((Object)string);
                ((StringBuilder)object2).append(" has been inflated via the <fragment> tag: id=0x");
                ((StringBuilder)object2).append(Integer.toHexString(n));
                Log.v((String)TAG, (String)((StringBuilder)object2).toString());
                object2 = string;
                object3 = string2;
            }
        } else {
            if (((Fragment)string).mInLayout) {
                object = new StringBuilder();
                ((StringBuilder)object).append(object3.getPositionDescription());
                ((StringBuilder)object).append(": Duplicate id 0x");
                ((StringBuilder)object).append(Integer.toHexString(n));
                ((StringBuilder)object).append(", tag ");
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(", or parent id 0x");
                ((StringBuilder)object).append(Integer.toHexString(n2));
                ((StringBuilder)object).append(" with another fragment for ");
                ((StringBuilder)object).append(string3);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            ((Fragment)string).mInLayout = true;
            ((Fragment)string).mFragmentManager = this.mFragmentManager;
            ((Fragment)string).mHost = this.mFragmentManager.getHost();
            string.onInflate(this.mFragmentManager.getHost().getContext(), (AttributeSet)object3, ((Fragment)string).mSavedFragmentState);
            string2 = this.mFragmentManager.createOrGetFragmentStateManager((Fragment)string);
            object2 = string;
            object3 = string2;
            if (FragmentManager.isLoggingEnabled((int)2)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Retained Fragment ");
                ((StringBuilder)object2).append((Object)string);
                ((StringBuilder)object2).append(" has been re-attached via the <fragment> tag: id=0x");
                ((StringBuilder)object2).append(Integer.toHexString(n));
                Log.v((String)TAG, (String)((StringBuilder)object2).toString());
                object3 = string2;
                object2 = string;
            }
        }
        ((Fragment)object2).mContainer = (ViewGroup)object;
        object3.moveToExpectedState();
        object3.ensureInflatedView();
        if (((Fragment)object2).mView == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Fragment ");
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(" did not create a view.");
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        if (n != 0) {
            ((Fragment)object2).mView.setId(n);
        }
        if (((Fragment)object2).mView.getTag() == null) {
            ((Fragment)object2).mView.setTag((Object)string4);
        }
        ((Fragment)object2).mView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        return ((Fragment)object2).mView;
    }

    public View onCreateView(String string, Context context, AttributeSet attributeSet) {
        return this.onCreateView(null, string, context, attributeSet);
    }
}
