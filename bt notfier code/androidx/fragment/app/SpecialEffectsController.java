/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.os.CancellationSignal
 *  androidx.core.view.ViewCompat
 *  androidx.fragment.R$id
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentStateManager
 *  androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation
 *  androidx.fragment.app.SpecialEffectsController$Operation
 *  androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 *  androidx.fragment.app.SpecialEffectsControllerFactory
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsControllerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    boolean mIsContainerPostponed = false;
    boolean mOperationDirectionIsPop = false;
    final ArrayList<Operation> mPendingOperations = new ArrayList();
    final ArrayList<Operation> mRunningOperations = new ArrayList();

    SpecialEffectsController(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    private void enqueue(Operation.State state, Operation.LifecycleImpact lifecycleImpact, FragmentStateManager fragmentStateManager) {
        ArrayList<Operation> arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Operation operation = this.findPendingOperation(fragmentStateManager.getFragment());
            if (operation != null) {
                operation.mergeWith(state, lifecycleImpact);
                return;
            }
            operation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.mPendingOperations.add(operation);
            state = new /* Unavailable Anonymous Inner Class!! */;
            operation.addCompletionListener((Runnable)state);
            state = new /* Unavailable Anonymous Inner Class!! */;
            operation.addCompletionListener((Runnable)state);
            return;
        }
    }

    private Operation findPendingOperation(Fragment fragment) {
        Operation operation;
        Iterator<Operation> iterator = this.mPendingOperations.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!(operation = iterator.next()).getFragment().equals((Object)fragment) || operation.isCanceled());
        return operation;
    }

    private Operation findRunningOperation(Fragment fragment) {
        Operation operation;
        Iterator<Operation> iterator = this.mRunningOperations.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!(operation = iterator.next()).getFragment().equals((Object)fragment) || operation.isCanceled());
        return operation;
    }

    static SpecialEffectsController getOrCreateController(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return SpecialEffectsController.getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    static SpecialEffectsController getOrCreateController(ViewGroup viewGroup, SpecialEffectsControllerFactory object) {
        Object object2 = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (object2 instanceof SpecialEffectsController) {
            return (SpecialEffectsController)object2;
        }
        object = object.createController(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, object);
        return object;
    }

    private void updateFinalState() {
        Iterator<Operation> iterator = this.mPendingOperations.iterator();
        while (iterator.hasNext()) {
            Operation operation = iterator.next();
            if (operation.getLifecycleImpact() != Operation.LifecycleImpact.ADDING) continue;
            operation.mergeWith(Operation.State.from((int)operation.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
        }
    }

    void enqueueAdd(Operation.State state, FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            stringBuilder.append(fragmentStateManager.getFragment());
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        this.enqueue(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    void enqueueHide(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            stringBuilder.append(fragmentStateManager.getFragment());
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        this.enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    void enqueueRemove(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            stringBuilder.append(fragmentStateManager.getFragment());
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        this.enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    void enqueueShow(FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled((int)2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            stringBuilder.append(fragmentStateManager.getFragment());
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        this.enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    abstract void executeOperations(List<Operation> var1, boolean var2);

    void executePendingOperations() {
        if (this.mIsContainerPostponed) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow((View)this.mContainer)) {
            this.forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        ArrayList<Operation> arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            try {
                if (this.mPendingOperations.isEmpty()) return;
                Object object = new ArrayList(this.mRunningOperations);
                this.mRunningOperations.clear();
                ArrayList<Operation> arrayList2 = ((ArrayList)object).iterator();
                while (arrayList2.hasNext()) {
                    Operation operation = arrayList2.next();
                    if (FragmentManager.isLoggingEnabled((int)2)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("SpecialEffectsController: Cancelling operation ");
                        ((StringBuilder)object).append(operation);
                        Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
                    }
                    operation.cancel();
                    if (operation.isComplete()) continue;
                    this.mRunningOperations.add(operation);
                }
                this.updateFinalState();
                arrayList2 = new ArrayList<Operation>(this.mPendingOperations);
                this.mPendingOperations.clear();
                this.mRunningOperations.addAll(arrayList2);
                object = arrayList2.iterator();
                while (true) {
                    if (!object.hasNext()) {
                        this.executeOperations(arrayList2, this.mOperationDirectionIsPop);
                        this.mOperationDirectionIsPop = false;
                        return;
                    }
                    ((Operation)object.next()).onStart();
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void forceCompleteAllOperations() {
        boolean bl = ViewCompat.isAttachedToWindow((View)this.mContainer);
        ArrayList<Operation> arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            try {
                Object object;
                Operation operation;
                this.updateFinalState();
                Object object2 = this.mPendingOperations.iterator();
                while (object2.hasNext()) {
                    object2.next().onStart();
                }
                object2 = new ArrayList(this.mRunningOperations);
                Object object3 = ((ArrayList)object2).iterator();
                while (object3.hasNext()) {
                    operation = object3.next();
                    if (FragmentManager.isLoggingEnabled((int)2)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("SpecialEffectsController: ");
                        if (bl) {
                            object2 = "";
                        } else {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("Container ");
                            ((StringBuilder)object2).append(this.mContainer);
                            ((StringBuilder)object2).append(" is not attached to window. ");
                            object2 = ((StringBuilder)object2).toString();
                        }
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append("Cancelling running operation ");
                        ((StringBuilder)object).append(operation);
                        Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
                    }
                    operation.cancel();
                }
                object2 = new ArrayList(this.mPendingOperations);
                object = ((ArrayList)object2).iterator();
                while (object.hasNext()) {
                    operation = (Operation)object.next();
                    if (FragmentManager.isLoggingEnabled((int)2)) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("SpecialEffectsController: ");
                        if (bl) {
                            object2 = "";
                        } else {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("Container ");
                            ((StringBuilder)object2).append(this.mContainer);
                            ((StringBuilder)object2).append(" is not attached to window. ");
                            object2 = ((StringBuilder)object2).toString();
                        }
                        ((StringBuilder)object3).append((String)object2);
                        ((StringBuilder)object3).append("Cancelling pending operation ");
                        ((StringBuilder)object3).append(operation);
                        Log.v((String)"FragmentManager", (String)((StringBuilder)object3).toString());
                    }
                    operation.cancel();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void forcePostponedExecutePendingOperations() {
        if (!this.mIsContainerPostponed) return;
        this.mIsContainerPostponed = false;
        this.executePendingOperations();
    }

    Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager fragmentStateManager) {
        Object object = this.findPendingOperation(fragmentStateManager.getFragment());
        object = object != null ? object.getLifecycleImpact() : null;
        fragmentStateManager = this.findRunningOperation(fragmentStateManager.getFragment());
        if (fragmentStateManager == null) return object;
        if (object == null) return fragmentStateManager.getLifecycleImpact();
        if (object != Operation.LifecycleImpact.NONE) return object;
        return fragmentStateManager.getLifecycleImpact();
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    /*
     * Enabled force condition propagation
     */
    void markPostponedState() {
        ArrayList<Operation> arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            this.updateFinalState();
            this.mIsContainerPostponed = false;
            int n = this.mPendingOperations.size() - 1;
            while (n >= 0) {
                Operation operation = this.mPendingOperations.get(n);
                Operation.State state = Operation.State.from((View)operation.getFragment().mView);
                if (operation.getFinalState() == Operation.State.VISIBLE && state != Operation.State.VISIBLE) {
                    this.mIsContainerPostponed = operation.getFragment().isPostponed();
                    return;
                }
                --n;
            }
            return;
        }
    }

    void updateOperationDirection(boolean bl) {
        this.mOperationDirectionIsPop = bl;
    }
}
