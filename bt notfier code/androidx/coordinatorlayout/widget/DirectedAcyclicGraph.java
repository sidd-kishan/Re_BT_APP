/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.util.Pools$Pool
 *  androidx.core.util.Pools$SimplePool
 */
package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class DirectedAcyclicGraph<T> {
    private final SimpleArrayMap<T, ArrayList<T>> mGraph;
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final ArrayList<T> mSortResult;
    private final HashSet<T> mSortTmpMarked;

    public DirectedAcyclicGraph() {
        this.mGraph = new SimpleArrayMap();
        this.mSortResult = new ArrayList();
        this.mSortTmpMarked = new HashSet();
    }

    private void dfs(T object, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(object)) {
            return;
        }
        if (hashSet.contains(object)) {
            object = new RuntimeException("This graph contains cyclic dependencies");
            throw object;
        }
        hashSet.add(object);
        ArrayList arrayList2 = (ArrayList)this.mGraph.get(object);
        if (arrayList2 != null) {
            int n = arrayList2.size();
            for (int i = 0; i < n; ++i) {
                this.dfs(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(object);
        arrayList.add(object);
    }

    private ArrayList<T> getEmptyList() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList = (ArrayList)this.mListPool.acquire();
        if (arrayList != null) return arrayList2;
        arrayList2 = new ArrayList();
        return arrayList2;
    }

    private void poolList(ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(T t, T t2) {
        ArrayList<T> arrayList;
        if (!this.mGraph.containsKey(t)) throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        if (!this.mGraph.containsKey(t2)) throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        ArrayList<T> arrayList2 = arrayList = (ArrayList<T>)this.mGraph.get(t);
        if (arrayList == null) {
            arrayList2 = this.getEmptyList();
            this.mGraph.put(t, arrayList2);
        }
        arrayList2.add(t2);
    }

    public void addNode(T t) {
        if (this.mGraph.containsKey(t)) return;
        this.mGraph.put(t, null);
    }

    public void clear() {
        int n = this.mGraph.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mGraph.clear();
                return;
            }
            ArrayList arrayList = (ArrayList)this.mGraph.valueAt(n2);
            if (arrayList != null) {
                this.poolList(arrayList);
            }
            ++n2;
        }
    }

    public boolean contains(T t) {
        return this.mGraph.containsKey(t);
    }

    public List getIncomingEdges(T t) {
        return (List)this.mGraph.get(t);
    }

    public List<T> getOutgoingEdges(T t) {
        int n = this.mGraph.size();
        ArrayList<Object> arrayList = null;
        int n2 = 0;
        while (n2 < n) {
            ArrayList arrayList2 = (ArrayList)this.mGraph.valueAt(n2);
            ArrayList<Object> arrayList3 = arrayList;
            if (arrayList2 != null) {
                arrayList3 = arrayList;
                if (arrayList2.contains(t)) {
                    arrayList3 = arrayList;
                    if (arrayList == null) {
                        arrayList3 = new ArrayList<Object>();
                    }
                    arrayList3.add(this.mGraph.keyAt(n2));
                }
            }
            ++n2;
            arrayList = arrayList3;
        }
        return arrayList;
    }

    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int n = this.mGraph.size();
        int n2 = 0;
        while (n2 < n) {
            this.dfs(this.mGraph.keyAt(n2), this.mSortResult, this.mSortTmpMarked);
            ++n2;
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(T t) {
        int n = this.mGraph.size();
        int n2 = 0;
        while (n2 < n) {
            ArrayList arrayList = (ArrayList)this.mGraph.valueAt(n2);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    int size() {
        return this.mGraph.size();
    }
}
