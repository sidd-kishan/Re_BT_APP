/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.graphics.Path
 *  android.util.Log
 *  androidx.core.graphics.PathParser
 *  androidx.core.graphics.PathParser$PathDataNode
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Path;
import android.util.Log;
import androidx.core.graphics.PathParser;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

private static abstract class VectorDrawableCompat.VPath
extends VectorDrawableCompat.VObject {
    protected static final int FILL_TYPE_WINDING = 0;
    int mChangingConfigurations;
    int mFillRule = 0;
    protected PathParser.PathDataNode[] mNodes = null;
    String mPathName;

    public VectorDrawableCompat.VPath() {
        super(null);
    }

    public VectorDrawableCompat.VPath(VectorDrawableCompat.VPath vPath) {
        super(null);
        this.mPathName = vPath.mPathName;
        this.mChangingConfigurations = vPath.mChangingConfigurations;
        this.mNodes = PathParser.deepCopyNodes((PathParser.PathDataNode[])vPath.mNodes);
    }

    public void applyTheme(Resources.Theme theme) {
    }

    public boolean canApplyTheme() {
        return false;
    }

    public PathParser.PathDataNode[] getPathData() {
        return this.mNodes;
    }

    public String getPathName() {
        return this.mPathName;
    }

    public boolean isClipPath() {
        return false;
    }

    public String nodesToString(PathParser.PathDataNode[] pathDataNodeArray) {
        String string = " ";
        int n = 0;
        while (n < pathDataNodeArray.length) {
            Object object = new StringBuilder();
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(pathDataNodeArray[n].mType);
            ((StringBuilder)object).append(":");
            string = ((StringBuilder)object).toString();
            object = pathDataNodeArray[n].mParams;
            for (int i = 0; i < ((Object)object).length; ++i) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append((float)object[i]);
                stringBuilder.append(",");
                string = stringBuilder.toString();
            }
            ++n;
        }
        return string;
    }

    public void printVPath(int n) {
        String string = "";
        int n2 = 0;
        while (true) {
            StringBuilder stringBuilder;
            if (n2 >= n) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("current path is :");
                stringBuilder.append(this.mPathName);
                stringBuilder.append(" pathData is ");
                stringBuilder.append(this.nodesToString(this.mNodes));
                Log.v((String)"VectorDrawableCompat", (String)stringBuilder.toString());
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("    ");
            string = stringBuilder.toString();
            ++n2;
        }
    }

    public void setPathData(PathParser.PathDataNode[] pathDataNodeArray) {
        if (!PathParser.canMorph((PathParser.PathDataNode[])this.mNodes, (PathParser.PathDataNode[])pathDataNodeArray)) {
            this.mNodes = PathParser.deepCopyNodes((PathParser.PathDataNode[])pathDataNodeArray);
        } else {
            PathParser.updateNodes((PathParser.PathDataNode[])this.mNodes, (PathParser.PathDataNode[])pathDataNodeArray);
        }
    }

    public void toPath(Path path) {
        path.reset();
        PathParser.PathDataNode[] pathDataNodeArray = this.mNodes;
        if (pathDataNodeArray == null) return;
        PathParser.PathDataNode.nodesToPath((PathParser.PathDataNode[])pathDataNodeArray, (Path)path);
    }
}
