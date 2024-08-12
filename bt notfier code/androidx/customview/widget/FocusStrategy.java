/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  androidx.customview.widget.FocusStrategy$BoundsAdapter
 *  androidx.customview.widget.FocusStrategy$CollectionAdapter
 *  androidx.customview.widget.FocusStrategy$SequentialComparator
 */
package androidx.customview.widget;

import android.graphics.Rect;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.Collections;

class FocusStrategy {
    private FocusStrategy() {
    }

    private static boolean beamBeats(int n, Rect rect, Rect rect2, Rect rect3) {
        boolean bl = FocusStrategy.beamsOverlap(n, rect, rect2);
        boolean bl2 = FocusStrategy.beamsOverlap(n, rect, rect3);
        boolean bl3 = false;
        if (bl2) return false;
        if (!bl) {
            return false;
        }
        if (!FocusStrategy.isToDirectionOf(n, rect, rect3)) {
            return true;
        }
        if (n == 17) return true;
        if (n == 66) {
            return true;
        }
        if (FocusStrategy.majorAxisDistance(n, rect, rect2) >= FocusStrategy.majorAxisDistanceToFarEdge(n, rect, rect3)) return bl3;
        bl3 = true;
        return bl3;
    }

    private static boolean beamsOverlap(int n, Rect rect, Rect rect2) {
        boolean bl;
        block2: {
            boolean bl2;
            block3: {
                bl = true;
                bl2 = true;
                if (n == 17) break block2;
                if (n == 33) break block3;
                if (n == 66) break block2;
                if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            bl = rect2.right >= rect.left && rect2.left <= rect.right ? bl2 : false;
            return bl;
        }
        if (rect2.bottom >= rect.top && rect2.top <= rect.bottom) return bl;
        bl = false;
        return bl;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(L l, CollectionAdapter<L, T> collectionAdapter, BoundsAdapter<T> boundsAdapter, T t, Rect rect, int n) {
        Rect rect2 = new Rect(rect);
        int n2 = 0;
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    rect2.offset(0, -(rect.height() + 1));
                } else {
                    rect2.offset(-(rect.width() + 1), 0);
                }
            } else {
                rect2.offset(0, rect.height() + 1);
            }
        } else {
            rect2.offset(rect.width() + 1, 0);
        }
        Object object = null;
        int n3 = collectionAdapter.size(l);
        Rect rect3 = new Rect();
        while (n2 < n3) {
            Object object2 = collectionAdapter.get(l, n2);
            if (object2 != t) {
                boundsAdapter.obtainBounds(object2, rect3);
                if (FocusStrategy.isBetterCandidate(n, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    object = object2;
                }
            }
            ++n2;
        }
        return (T)object;
    }

    public static <L, T> T findNextFocusInRelativeDirection(L l, CollectionAdapter<L, T> collectionAdapter, BoundsAdapter<T> boundsAdapter, T t, int n, boolean bl, boolean bl2) {
        int n2 = collectionAdapter.size(l);
        ArrayList<Object> arrayList = new ArrayList<Object>(n2);
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                Collections.sort(arrayList, new SequentialComparator(bl, boundsAdapter));
                if (n == 1) return FocusStrategy.getPreviousFocusable(t, arrayList, bl2);
                if (n != 2) throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                return FocusStrategy.getNextFocusable(t, arrayList, bl2);
            }
            arrayList.add(collectionAdapter.get(l, n3));
            ++n3;
        }
    }

    private static <T> T getNextFocusable(T t, ArrayList<T> arrayList, boolean bl) {
        int n = arrayList.size();
        int n2 = t == null ? -1 : arrayList.lastIndexOf(t);
        if (++n2 < n) {
            return arrayList.get(n2);
        }
        if (!bl) return null;
        if (n <= 0) return null;
        return arrayList.get(0);
    }

    private static <T> T getPreviousFocusable(T t, ArrayList<T> arrayList, boolean bl) {
        int n = arrayList.size();
        int n2 = t == null ? n : arrayList.indexOf(t);
        if (--n2 >= 0) {
            return arrayList.get(n2);
        }
        if (!bl) return null;
        if (n <= 0) return null;
        return arrayList.get(n - 1);
    }

    private static int getWeightedDistanceFor(int n, int n2) {
        return n * 13 * n + n2 * n2;
    }

    private static boolean isBetterCandidate(int n, Rect rect, Rect rect2, Rect rect3) {
        boolean bl = FocusStrategy.isCandidate(rect, rect2, n);
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        if (!FocusStrategy.isCandidate(rect, rect3, n)) {
            return true;
        }
        if (FocusStrategy.beamBeats(n, rect, rect2, rect3)) {
            return true;
        }
        if (FocusStrategy.beamBeats(n, rect, rect3, rect2)) {
            return false;
        }
        if (FocusStrategy.getWeightedDistanceFor(FocusStrategy.majorAxisDistance(n, rect, rect2), FocusStrategy.minorAxisDistance(n, rect, rect2)) >= FocusStrategy.getWeightedDistanceFor(FocusStrategy.majorAxisDistance(n, rect, rect3), FocusStrategy.minorAxisDistance(n, rect, rect3))) return bl2;
        bl2 = true;
        return bl2;
    }

    private static boolean isCandidate(Rect rect, Rect rect2, int n) {
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    if ((rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom) return bl4;
                    bl4 = false;
                    return bl4;
                }
                bl4 = (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right ? bl : false;
                return bl4;
            }
            bl4 = (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top ? bl2 : false;
            return bl4;
        }
        bl4 = (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left ? bl3 : false;
        return bl4;
    }

    private static boolean isToDirectionOf(int n, Rect rect, Rect rect2) {
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    bl3 = rect.bottom <= rect2.top ? bl4 : false;
                    return bl3;
                }
                bl3 = rect.right <= rect2.left ? bl : false;
                return bl3;
            }
            bl3 = rect.top >= rect2.bottom ? bl2 : false;
            return bl3;
        }
        if (rect.left >= rect2.right) return bl3;
        bl3 = false;
        return bl3;
    }

    private static int majorAxisDistance(int n, Rect rect, Rect rect2) {
        return Math.max(0, FocusStrategy.majorAxisDistanceRaw(n, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int n, Rect rect, Rect rect2) {
        int n2;
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    n = rect2.top;
                    n2 = rect.bottom;
                } else {
                    n = rect2.left;
                    n2 = rect.right;
                }
            } else {
                n = rect.top;
                n2 = rect2.bottom;
            }
        } else {
            n = rect.left;
            n2 = rect2.right;
        }
        return n - n2;
    }

    private static int majorAxisDistanceToFarEdge(int n, Rect rect, Rect rect2) {
        return Math.max(1, FocusStrategy.majorAxisDistanceToFarEdgeRaw(n, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int n, Rect rect, Rect rect2) {
        int n2;
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    n = rect2.bottom;
                    n2 = rect.bottom;
                } else {
                    n = rect2.right;
                    n2 = rect.right;
                }
            } else {
                n = rect.top;
                n2 = rect2.top;
            }
        } else {
            n = rect.left;
            n2 = rect2.left;
        }
        return n - n2;
    }

    private static int minorAxisDistance(int n, Rect rect, Rect rect2) {
        if (n == 17) return Math.abs(rect.top + rect.height() / 2 - (rect2.top + rect2.height() / 2));
        if (n == 33) return Math.abs(rect.left + rect.width() / 2 - (rect2.left + rect2.width() / 2));
        if (n == 66) return Math.abs(rect.top + rect.height() / 2 - (rect2.top + rect2.height() / 2));
        if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return Math.abs(rect.left + rect.width() / 2 - (rect2.left + rect2.width() / 2));
    }
}
