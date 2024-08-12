/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 *  androidx.core.graphics.PathParser
 *  androidx.core.graphics.PathParser$PathDataNode
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.core.graphics.PathParser;

private static class AnimatorInflaterCompat.PathDataEvaluator
implements TypeEvaluator<PathParser.PathDataNode[]> {
    private PathParser.PathDataNode[] mNodeArray;

    AnimatorInflaterCompat.PathDataEvaluator() {
    }

    AnimatorInflaterCompat.PathDataEvaluator(PathParser.PathDataNode[] pathDataNodeArray) {
        this.mNodeArray = pathDataNodeArray;
    }

    public PathParser.PathDataNode[] evaluate(float f, PathParser.PathDataNode[] object, PathParser.PathDataNode[] pathDataNodeArray) {
        if (!PathParser.canMorph((PathParser.PathDataNode[])object, (PathParser.PathDataNode[])pathDataNodeArray)) {
            object = new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            throw object;
        }
        if (!PathParser.canMorph((PathParser.PathDataNode[])this.mNodeArray, (PathParser.PathDataNode[])object)) {
            this.mNodeArray = PathParser.deepCopyNodes((PathParser.PathDataNode[])object);
        }
        int n = 0;
        while (n < ((PathParser.PathDataNode[])object).length) {
            this.mNodeArray[n].interpolatePathDataNode(object[n], pathDataNodeArray[n], f);
            ++n;
        }
        return this.mNodeArray;
    }
}
