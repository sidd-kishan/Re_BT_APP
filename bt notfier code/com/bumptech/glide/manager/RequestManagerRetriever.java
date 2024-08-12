/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  android.view.View
 *  androidx.collection.ArrayMap
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.manager.ApplicationLifecycle
 *  com.bumptech.glide.manager.EmptyRequestManagerTreeNode
 *  com.bumptech.glide.manager.Lifecycle
 *  com.bumptech.glide.manager.RequestManagerFragment
 *  com.bumptech.glide.manager.RequestManagerRetriever$RequestManagerFactory
 *  com.bumptech.glide.manager.RequestManagerTreeNode
 *  com.bumptech.glide.manager.SupportRequestManagerFragment
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.ApplicationLifecycle;
import com.bumptech.glide.manager.EmptyRequestManagerTreeNode;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerFragment;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever
implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = new /* Unavailable Anonymous Inner Class!! */;
    private static final String FRAGMENT_INDEX_KEY = "key";
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final Handler handler;
    final Map<android.app.FragmentManager, RequestManagerFragment> pendingRequestManagerFragments = new HashMap<android.app.FragmentManager, RequestManagerFragment>();
    final Map<FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap<FragmentManager, SupportRequestManagerFragment>();
    private final Bundle tempBundle;
    private final ArrayMap<View, Fragment> tempViewToFragment;
    private final ArrayMap<View, androidx.fragment.app.Fragment> tempViewToSupportFragment = new ArrayMap();

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        this.tempViewToFragment = new ArrayMap();
        this.tempBundle = new Bundle();
        if (requestManagerFactory == null) {
            requestManagerFactory = DEFAULT_FACTORY;
        }
        this.factory = requestManagerFactory;
        this.handler = new Handler(Looper.getMainLooper(), (Handler.Callback)this);
    }

    private static void assertNotDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT < 17) return;
        if (activity.isDestroyed()) throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    private Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity)context;
        }
        if (!(context instanceof ContextWrapper)) return null;
        return this.findActivity(((ContextWrapper)context).getBaseContext());
    }

    private void findAllFragmentsWithViews(android.app.FragmentManager object, ArrayMap<View, Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT < 26) {
            this.findAllFragmentsWithViewsPreO((android.app.FragmentManager)object, arrayMap);
            return;
        }
        object = object.getFragments().iterator();
        while (object.hasNext()) {
            Fragment fragment = (Fragment)object.next();
            if (fragment.getView() == null) continue;
            arrayMap.put((Object)fragment.getView(), (Object)fragment);
            this.findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
        }
    }

    private void findAllFragmentsWithViewsPreO(android.app.FragmentManager fragmentManager, ArrayMap<View, Fragment> arrayMap) {
        int n = 0;
        while (true) {
            this.tempBundle.putInt(FRAGMENT_INDEX_KEY, n);
            Fragment fragment = null;
            try {
                Fragment fragment2;
                fragment = fragment2 = fragmentManager.getFragment(this.tempBundle, FRAGMENT_INDEX_KEY);
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put((Object)fragment.getView(), (Object)fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            ++n;
        }
    }

    private static void findAllSupportFragmentsWithViews(Collection<androidx.fragment.app.Fragment> object, Map<View, androidx.fragment.app.Fragment> map) {
        if (object == null) {
            return;
        }
        object = object.iterator();
        while (object.hasNext()) {
            androidx.fragment.app.Fragment fragment = (androidx.fragment.app.Fragment)object.next();
            if (fragment == null || fragment.getView() == null) continue;
            map.put(fragment.getView(), fragment);
            RequestManagerRetriever.findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), map);
        }
    }

    private Fragment findFragment(View view, Activity activity) {
        this.tempViewToFragment.clear();
        this.findAllFragmentsWithViews(activity.getFragmentManager(), this.tempViewToFragment);
        View view2 = activity.findViewById(0x1020002);
        View view3 = null;
        activity = view;
        view = view3;
        while (true) {
            view3 = view;
            if (activity.equals(view2)) break;
            view = (Fragment)this.tempViewToFragment.get((Object)activity);
            if (view != null) {
                view3 = view;
                break;
            }
            view3 = view;
            if (!(activity.getParent() instanceof View)) break;
            activity = (View)activity.getParent();
        }
        this.tempViewToFragment.clear();
        return view3;
    }

    private androidx.fragment.app.Fragment findSupportFragment(View view, FragmentActivity fragmentActivity) {
        this.tempViewToSupportFragment.clear();
        RequestManagerRetriever.findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
        View view2 = fragmentActivity.findViewById(0x1020002);
        View view3 = null;
        fragmentActivity = view;
        view = view3;
        while (true) {
            view3 = view;
            if (fragmentActivity.equals(view2)) break;
            view = (androidx.fragment.app.Fragment)this.tempViewToSupportFragment.get((Object)fragmentActivity);
            if (view != null) {
                view3 = view;
                break;
            }
            view3 = view;
            if (!(fragmentActivity.getParent() instanceof View)) break;
            fragmentActivity = (View)fragmentActivity.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return view3;
    }

    private RequestManager fragmentGet(Context context, android.app.FragmentManager fragmentManager, Fragment fragment) {
        RequestManagerFragment requestManagerFragment = this.getRequestManagerFragment(fragmentManager, fragment);
        fragment = requestManagerFragment.getRequestManager();
        fragmentManager = fragment;
        if (fragment != null) return fragmentManager;
        fragmentManager = Glide.get((Context)context);
        fragmentManager = this.factory.build((Glide)fragmentManager, (Lifecycle)requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
        requestManagerFragment.setRequestManager((RequestManager)fragmentManager);
        return fragmentManager;
    }

    private RequestManager getApplicationManager(Context context) {
        if (this.applicationManager != null) return this.applicationManager;
        synchronized (this) {
            if (this.applicationManager != null) return this.applicationManager;
            Glide glide = Glide.get((Context)context.getApplicationContext());
            RequestManagerFactory requestManagerFactory = this.factory;
            ApplicationLifecycle applicationLifecycle = new ApplicationLifecycle();
            EmptyRequestManagerTreeNode emptyRequestManagerTreeNode = new EmptyRequestManagerTreeNode();
            this.applicationManager = requestManagerFactory.build(glide, (Lifecycle)applicationLifecycle, (RequestManagerTreeNode)emptyRequestManagerTreeNode, context.getApplicationContext());
        }
        return this.applicationManager;
    }

    private RequestManager supportFragmentGet(Context context, FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.getSupportRequestManagerFragment(fragmentManager, fragment);
        fragment = supportRequestManagerFragment.getRequestManager();
        fragmentManager = fragment;
        if (fragment != null) return fragmentManager;
        fragmentManager = Glide.get((Context)context);
        fragmentManager = this.factory.build((Glide)fragmentManager, (Lifecycle)supportRequestManagerFragment.getGlideLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode(), context);
        supportRequestManagerFragment.setRequestManager((RequestManager)fragmentManager);
        return fragmentManager;
    }

    public RequestManager get(Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return this.get(activity.getApplicationContext());
        }
        RequestManagerRetriever.assertNotDestroyed(activity);
        return this.fragmentGet((Context)activity, activity.getFragmentManager(), null);
    }

    public RequestManager get(Fragment fragment) {
        if (fragment.getActivity() == null) throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        if (Util.isOnBackgroundThread()) return this.get(fragment.getActivity().getApplicationContext());
        if (Build.VERSION.SDK_INT < 17) {
            return this.get(fragment.getActivity().getApplicationContext());
        }
        android.app.FragmentManager fragmentManager = fragment.getChildFragmentManager();
        return this.fragmentGet((Context)fragment.getActivity(), fragmentManager, fragment);
    }

    public RequestManager get(Context context) {
        if (context == null) throw new IllegalArgumentException("You cannot start a load on a null Context");
        if (!Util.isOnMainThread()) return this.getApplicationManager(context);
        if (context instanceof Application) return this.getApplicationManager(context);
        if (context instanceof FragmentActivity) {
            return this.get((FragmentActivity)context);
        }
        if (context instanceof Activity) {
            return this.get((Activity)context);
        }
        if (!(context instanceof ContextWrapper)) return this.getApplicationManager(context);
        return this.get(((ContextWrapper)context).getBaseContext());
    }

    public RequestManager get(View view) {
        if (Util.isOnBackgroundThread()) {
            return this.get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull((Object)view);
        Preconditions.checkNotNull((Object)view.getContext(), (String)"Unable to obtain a request manager for a view without a Context");
        Activity activity = this.findActivity(view.getContext());
        if (activity == null) {
            return this.get(view.getContext().getApplicationContext());
        }
        if (!(activity instanceof FragmentActivity)) {
            if ((view = this.findFragment(view, activity)) != null) return this.get((Fragment)view);
            return this.get(activity);
        }
        view = (view = this.findSupportFragment(view, (FragmentActivity)activity)) != null ? this.get((androidx.fragment.app.Fragment)view) : this.get(activity);
        return view;
    }

    public RequestManager get(androidx.fragment.app.Fragment fragment) {
        Preconditions.checkNotNull((Object)fragment.getActivity(), (String)"You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return this.get(fragment.getActivity().getApplicationContext());
        }
        FragmentManager fragmentManager = fragment.getChildFragmentManager();
        return this.supportFragmentGet((Context)fragment.getActivity(), fragmentManager, fragment);
    }

    public RequestManager get(FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return this.get(fragmentActivity.getApplicationContext());
        }
        RequestManagerRetriever.assertNotDestroyed((Activity)fragmentActivity);
        return this.supportFragmentGet((Context)fragmentActivity, fragmentActivity.getSupportFragmentManager(), null);
    }

    RequestManagerFragment getRequestManagerFragment(android.app.FragmentManager fragmentManager, Fragment fragment) {
        RequestManagerFragment requestManagerFragment;
        RequestManagerFragment requestManagerFragment2 = requestManagerFragment = (RequestManagerFragment)fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment != null) return requestManagerFragment2;
        requestManagerFragment2 = requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager);
        if (requestManagerFragment != null) return requestManagerFragment2;
        requestManagerFragment2 = new RequestManagerFragment();
        requestManagerFragment2.setParentFragmentHint(fragment);
        this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment2);
        fragmentManager.beginTransaction().add((Fragment)requestManagerFragment2, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(1, (Object)fragmentManager).sendToTarget();
        return requestManagerFragment2;
    }

    SupportRequestManagerFragment getSupportRequestManagerFragment(FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment;
        SupportRequestManagerFragment supportRequestManagerFragment2 = supportRequestManagerFragment = (SupportRequestManagerFragment)fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment != null) return supportRequestManagerFragment2;
        supportRequestManagerFragment2 = supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(fragmentManager);
        if (supportRequestManagerFragment != null) return supportRequestManagerFragment2;
        supportRequestManagerFragment2 = new SupportRequestManagerFragment();
        supportRequestManagerFragment2.setParentFragmentHint(fragment);
        this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment2);
        fragmentManager.beginTransaction().add((androidx.fragment.app.Fragment)supportRequestManagerFragment2, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(2, (Object)fragmentManager).sendToTarget();
        return supportRequestManagerFragment2;
    }

    public boolean handleMessage(Message message) {
        int n = message.what;
        Object object = null;
        boolean bl = true;
        if (n != 1) {
            if (n != 2) {
                bl = false;
                message = null;
            } else {
                message = (FragmentManager)message.obj;
                object = this.pendingSupportRequestManagerFragments.remove(message);
            }
        } else {
            message = (android.app.FragmentManager)message.obj;
            object = this.pendingRequestManagerFragments.remove(message);
        }
        if (!bl) return bl;
        if (object != null) return bl;
        if (!Log.isLoggable((String)TAG, (int)5)) return bl;
        object = new StringBuilder();
        ((StringBuilder)object).append("Failed to remove expected request manager fragment, manager: ");
        ((StringBuilder)object).append(message);
        Log.w((String)TAG, (String)((StringBuilder)object).toString());
        return bl;
    }
}
