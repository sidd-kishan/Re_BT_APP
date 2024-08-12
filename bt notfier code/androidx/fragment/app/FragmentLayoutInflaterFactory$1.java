/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  androidx.fragment.app.FragmentLayoutInflaterFactory
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentStateManager
 *  androidx.fragment.app.SpecialEffectsController
 */
package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentLayoutInflaterFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController;

class FragmentLayoutInflaterFactory.1
implements View.OnAttachStateChangeListener {
    final FragmentLayoutInflaterFactory this$0;
    final FragmentStateManager val$fragmentStateManager;

    FragmentLayoutInflaterFactory.1(FragmentLayoutInflaterFactory fragmentLayoutInflaterFactory, FragmentStateManager fragmentStateManager) {
        this.this$0 = fragmentLayoutInflaterFactory;
        this.val$fragmentStateManager = fragmentStateManager;
    }

    public void onViewAttachedToWindow(View view) {
        view = this.val$fragmentStateManager.getFragment();
        this.val$fragmentStateManager.moveToExpectedState();
        SpecialEffectsController.getOrCreateController((ViewGroup)((ViewGroup)view.mView.getParent()), (FragmentManager)this.this$0.mFragmentManager).forceCompleteAllOperations();
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
