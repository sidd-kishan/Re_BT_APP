/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.executor.ArchTaskExecutor
 *  androidx.arch.core.internal.FastSafeIterableMap
 *  androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry$ObserverWithState
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class LifecycleRegistry
extends Lifecycle {
    private int mAddingObserverCounter = 0;
    private final boolean mEnforceMainThread;
    private boolean mHandlingEvent = false;
    private final WeakReference<LifecycleOwner> mLifecycleOwner;
    private boolean mNewEventOccurred = false;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap = new FastSafeIterableMap();
    private ArrayList<Lifecycle.State> mParentStates = new ArrayList();
    private Lifecycle.State mState;

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean bl) {
        this.mLifecycleOwner = new WeakReference<LifecycleOwner>(lifecycleOwner);
        this.mState = Lifecycle.State.INITIALIZED;
        this.mEnforceMainThread = bl;
    }

    private void backwardPass(LifecycleOwner object) {
        Iterator iterator = this.mObserverMap.descendingIterator();
        block0: while (iterator.hasNext()) {
            if (this.mNewEventOccurred) return;
            Map.Entry entry = (Map.Entry)iterator.next();
            ObserverWithState observerWithState = (ObserverWithState)entry.getValue();
            while (true) {
                if (observerWithState.mState.compareTo((Enum)this.mState) <= 0 || this.mNewEventOccurred || !this.mObserverMap.contains(entry.getKey())) continue block0;
                Lifecycle.Event event = Lifecycle.Event.downFrom((Lifecycle.State)observerWithState.mState);
                if (event == null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("no event down from ");
                    ((StringBuilder)object).append(observerWithState.mState);
                    throw new IllegalStateException(((StringBuilder)object).toString());
                }
                this.pushParentState(event.getTargetState());
                observerWithState.dispatchEvent((LifecycleOwner)object, event);
                this.popParentState();
            }
            break;
        }
        return;
    }

    private Lifecycle.State calculateTargetState(LifecycleObserver object) {
        object = this.mObserverMap.ceil(object);
        Lifecycle.State state = null;
        object = object != null ? ((ObserverWithState)object.getValue()).mState : null;
        if (this.mParentStates.isEmpty()) return LifecycleRegistry.min(LifecycleRegistry.min(this.mState, (Lifecycle.State)object), state);
        state = this.mParentStates;
        state = state.get(state.size() - 1);
        return LifecycleRegistry.min(LifecycleRegistry.min(this.mState, (Lifecycle.State)object), state);
    }

    public static LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner) {
        return new LifecycleRegistry(lifecycleOwner, false);
    }

    private void enforceMainThreadIfNeeded(String string) {
        if (!this.mEnforceMainThread) return;
        if (ArchTaskExecutor.getInstance().isMainThread()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Method ");
        stringBuilder.append(string);
        stringBuilder.append(" must be called on the main thread");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void forwardPass(LifecycleOwner object) {
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = this.mObserverMap.iteratorWithAdditions();
        block0: while (iteratorWithAdditions.hasNext()) {
            if (this.mNewEventOccurred) return;
            Map.Entry entry = (Map.Entry)iteratorWithAdditions.next();
            ObserverWithState observerWithState = (ObserverWithState)entry.getValue();
            while (true) {
                if (observerWithState.mState.compareTo((Enum)this.mState) >= 0 || this.mNewEventOccurred || !this.mObserverMap.contains(entry.getKey())) continue block0;
                this.pushParentState(observerWithState.mState);
                Lifecycle.Event event = Lifecycle.Event.upFrom((Lifecycle.State)observerWithState.mState);
                if (event == null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("no event up from ");
                    ((StringBuilder)object).append(observerWithState.mState);
                    throw new IllegalStateException(((StringBuilder)object).toString());
                }
                observerWithState.dispatchEvent((LifecycleOwner)object, event);
                this.popParentState();
            }
            break;
        }
        return;
    }

    private boolean isSynced() {
        int n = this.mObserverMap.size();
        boolean bl = true;
        if (n == 0) {
            return true;
        }
        Lifecycle.State state = ((ObserverWithState)this.mObserverMap.eldest().getValue()).mState;
        Lifecycle.State state2 = ((ObserverWithState)this.mObserverMap.newest().getValue()).mState;
        if (state == state2 && this.mState == state2) return bl;
        bl = false;
        return bl;
    }

    static Lifecycle.State min(Lifecycle.State state, Lifecycle.State state2) {
        Lifecycle.State state3 = state;
        if (state2 == null) return state3;
        state3 = state;
        if (state2.compareTo((Enum)state) >= 0) return state3;
        state3 = state2;
        return state3;
    }

    private void moveToState(Lifecycle.State state) {
        if (this.mState == state) {
            return;
        }
        this.mState = state;
        if (!this.mHandlingEvent && this.mAddingObserverCounter == 0) {
            this.mHandlingEvent = true;
            this.sync();
            this.mHandlingEvent = false;
            return;
        }
        this.mNewEventOccurred = true;
    }

    private void popParentState() {
        ArrayList<Lifecycle.State> arrayList = this.mParentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    private void pushParentState(Lifecycle.State state) {
        this.mParentStates.add(state);
    }

    private void sync() {
        Object object = (LifecycleOwner)this.mLifecycleOwner.get();
        if (object == null) {
            object = new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
            throw object;
        }
        while (true) {
            if (this.isSynced()) {
                this.mNewEventOccurred = false;
                return;
            }
            this.mNewEventOccurred = false;
            if (this.mState.compareTo((Enum)((ObserverWithState)this.mObserverMap.eldest().getValue()).mState) < 0) {
                this.backwardPass((LifecycleOwner)object);
            }
            Map.Entry entry = this.mObserverMap.newest();
            if (this.mNewEventOccurred || entry == null || this.mState.compareTo((Enum)((ObserverWithState)entry.getValue()).mState) <= 0) continue;
            this.forwardPass((LifecycleOwner)object);
        }
    }

    public void addObserver(LifecycleObserver object) {
        this.enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.mState == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED;
        ObserverWithState observerWithState = new ObserverWithState((LifecycleObserver)object, state);
        if ((ObserverWithState)this.mObserverMap.putIfAbsent(object, (Object)observerWithState) != null) {
            return;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner)this.mLifecycleOwner.get();
        if (lifecycleOwner == null) {
            return;
        }
        boolean bl = this.mAddingObserverCounter != 0 || this.mHandlingEvent;
        state = this.calculateTargetState((LifecycleObserver)object);
        ++this.mAddingObserverCounter;
        while (observerWithState.mState.compareTo((Enum)state) < 0 && this.mObserverMap.contains(object)) {
            this.pushParentState(observerWithState.mState);
            state = Lifecycle.Event.upFrom((Lifecycle.State)observerWithState.mState);
            if (state == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("no event up from ");
                ((StringBuilder)object).append(observerWithState.mState);
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            observerWithState.dispatchEvent(lifecycleOwner, (Lifecycle.Event)state);
            this.popParentState();
            state = this.calculateTargetState((LifecycleObserver)object);
        }
        if (!bl) {
            this.sync();
        }
        --this.mAddingObserverCounter;
    }

    public Lifecycle.State getCurrentState() {
        return this.mState;
    }

    public int getObserverCount() {
        this.enforceMainThreadIfNeeded("getObserverCount");
        return this.mObserverMap.size();
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        this.enforceMainThreadIfNeeded("handleLifecycleEvent");
        this.moveToState(event.getTargetState());
    }

    @Deprecated
    public void markState(Lifecycle.State state) {
        this.enforceMainThreadIfNeeded("markState");
        this.setCurrentState(state);
    }

    public void removeObserver(LifecycleObserver lifecycleObserver) {
        this.enforceMainThreadIfNeeded("removeObserver");
        this.mObserverMap.remove((Object)lifecycleObserver);
    }

    public void setCurrentState(Lifecycle.State state) {
        this.enforceMainThreadIfNeeded("setCurrentState");
        this.moveToState(state);
    }
}
