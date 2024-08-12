/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.SurfaceConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList = new ArrayList<SurfaceConfig>();

    private static void generateArrangements(List<int[]> list, int n, int[] nArray, int n2) {
        if (n2 >= nArray.length) {
            list.add((int[])nArray.clone());
            return;
        }
        int n3 = 0;
        while (n3 < n) {
            int n4;
            block4: {
                for (n4 = 0; n4 < n2; ++n4) {
                    if (n3 != nArray[n4]) continue;
                    n4 = 1;
                    break block4;
                }
                n4 = 0;
            }
            if (n4 == 0) {
                nArray[n2] = n3;
                SurfaceCombination.generateArrangements(list, n, nArray, n2 + 1);
            }
            ++n3;
        }
    }

    private List<int[]> getElementsArrangements(int n) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        SurfaceCombination.generateArrangements(arrayList, n, new int[n], 0);
        return arrayList;
    }

    public boolean addSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    public boolean isSupported(List<SurfaceConfig> list) {
        boolean bl;
        boolean bl2 = list.isEmpty();
        boolean bl3 = true;
        if (bl2) {
            return true;
        }
        if (list.size() > this.mSurfaceConfigList.size()) {
            return false;
        }
        Iterator<int[]> iterator = this.getElementsArrangements(this.mSurfaceConfigList.size()).iterator();
        block0: do {
            if (!iterator.hasNext()) {
                bl3 = false;
                break;
            }
            int[] nArray = iterator.next();
            int n = 0;
            boolean bl4 = true;
            while (true) {
                bl = bl4;
                if (n >= this.mSurfaceConfigList.size()) continue block0;
                bl = bl4;
                if (nArray[n] < list.size()) {
                    bl = bl4 &= this.mSurfaceConfigList.get(n).isSupported(list.get(nArray[n]));
                    if (!bl4) {
                        bl = bl4;
                        continue block0;
                    }
                }
                ++n;
                bl4 = bl;
            }
        } while (!bl);
        return bl3;
    }

    public boolean removeSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }
}
