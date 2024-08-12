/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  androidx.core.graphics.PathParser$ExtractFloatResult
 *  androidx.core.graphics.PathParser$PathDataNode
 */
package androidx.core.graphics;

import android.graphics.Path;
import androidx.core.graphics.PathParser;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArray) {
        arrayList.add(new PathDataNode(c, fArray));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArray, PathDataNode[] pathDataNodeArray2) {
        if (pathDataNodeArray == null) return false;
        if (pathDataNodeArray2 == null) {
            return false;
        }
        if (pathDataNodeArray.length != pathDataNodeArray2.length) {
            return false;
        }
        int n = 0;
        while (n < pathDataNodeArray.length) {
            if (pathDataNodeArray[n].mType != pathDataNodeArray2[n].mType) return false;
            if (pathDataNodeArray[n].mParams.length != pathDataNodeArray2[n].mParams.length) {
                return false;
            }
            ++n;
        }
        return true;
    }

    static float[] copyOfRange(float[] fArray, int n, int n2) {
        if (n > n2) throw new IllegalArgumentException();
        int n3 = fArray.length;
        if (n < 0) throw new ArrayIndexOutOfBoundsException();
        if (n > n3) throw new ArrayIndexOutOfBoundsException();
        n3 = Math.min(n2 -= n, n3 - n);
        float[] fArray2 = new float[n2];
        System.arraycopy(fArray, n, fArray2, 0, n3);
        return fArray2;
    }

    public static PathDataNode[] createNodesFromPathData(String string) {
        if (string == null) {
            return null;
        }
        ArrayList<PathDataNode> arrayList = new ArrayList<PathDataNode>();
        int n = 1;
        int n2 = 0;
        while (true) {
            if (n >= string.length()) {
                if (n - n2 != 1) return arrayList.toArray(new PathDataNode[arrayList.size()]);
                if (n2 >= string.length()) return arrayList.toArray(new PathDataNode[arrayList.size()]);
                PathParser.addNode(arrayList, string.charAt(n2), new float[0]);
                return arrayList.toArray(new PathDataNode[arrayList.size()]);
            }
            String string2 = string.substring(n2, n = PathParser.nextStart(string, n)).trim();
            if (string2.length() > 0) {
                float[] fArray = PathParser.getFloats(string2);
                PathParser.addNode(arrayList, string2.charAt(0), fArray);
            }
            n2 = n++;
        }
    }

    public static Path createPathFromPathData(String string) {
        Path path = new Path();
        Object object = PathParser.createNodesFromPathData(string);
        if (object == null) return null;
        try {
            PathDataNode.nodesToPath((PathDataNode[])object, (Path)path);
            return path;
        }
        catch (RuntimeException runtimeException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Error in parsing ");
            ((StringBuilder)object).append(string);
            throw new RuntimeException(((StringBuilder)object).toString(), runtimeException);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArray) {
        if (pathDataNodeArray == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArray2 = new PathDataNode[pathDataNodeArray.length];
        int n = 0;
        while (n < pathDataNodeArray.length) {
            pathDataNodeArray2[n] = new PathDataNode(pathDataNodeArray[n]);
            ++n;
        }
        return pathDataNodeArray2;
    }

    /*
     * Unable to fully structure code
     */
    private static void extract(String var0, int var1_1, ExtractFloatResult var2_2) {
        var2_2.mEndWithNegOrDot = false;
        var3_4 = false;
        var6_5 = false;
        var5_6 = false;
        for (var4_3 = var1_1; var4_3 < var0.length(); ++var4_3) {
            block8: {
                block7: {
                    var7_7 = var0.charAt(var4_3);
                    if (var7_7 == ' ') break block7;
                    if (var7_7 == 'E' || var7_7 == 'e') ** GOTO lbl25
                    switch (var7_7) {
                        default: {
                            ** GOTO lbl23
                        }
                        case '.': {
                            if (var6_5) ** GOTO lbl17
                            var3_4 = false;
                            var6_5 = true;
                            break block8;
lbl17:
                            // 1 sources

                            var2_2.mEndWithNegOrDot = true;
                            break;
                        }
                        case '-': {
                            if (var4_3 != var1_1 && !var3_4) {
                                var2_2.mEndWithNegOrDot = true;
                                break;
                            }
lbl23:
                            // 3 sources

                            var3_4 = false;
                            break block8;
                        }
lbl25:
                        // 1 sources

                        var3_4 = true;
                        break block8;
                        case ',': 
                    }
                }
                var3_4 = false;
                var5_6 = true;
            }
            if (var5_6) break;
        }
        var2_2.mEndPosition = var4_3;
    }

    private static float[] getFloats(String string) {
        if (string.charAt(0) == 'z') return new float[0];
        if (string.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArray = new float[string.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int n = string.length();
            int n2 = 1;
            int n3 = 0;
            while (true) {
                if (n2 >= n) {
                    fArray = PathParser.copyOfRange(fArray, 0, n3);
                    return fArray;
                }
                PathParser.extract(string, n2, extractFloatResult);
                int n4 = extractFloatResult.mEndPosition;
                int n5 = n3;
                if (n2 < n4) {
                    fArray[n3] = Float.parseFloat(string.substring(n2, n4));
                    n5 = n3 + 1;
                }
                if (extractFloatResult.mEndWithNegOrDot) {
                    n2 = n4;
                    n3 = n5;
                    continue;
                }
                n2 = n4 + 1;
                n3 = n5;
            }
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error in parsing \"");
            stringBuilder.append(string);
            stringBuilder.append("\"");
            throw new RuntimeException(stringBuilder.toString(), numberFormatException);
        }
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] object, PathDataNode[] pathDataNodeArray, PathDataNode[] pathDataNodeArray2, float f) {
        if (object != null && pathDataNodeArray != null && pathDataNodeArray2 != null) {
            if (((PathDataNode[])object).length != pathDataNodeArray.length) throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
            if (pathDataNodeArray.length != pathDataNodeArray2.length) throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
            boolean bl = PathParser.canMorph(pathDataNodeArray, pathDataNodeArray2);
            int n = 0;
            if (!bl) {
                return false;
            }
            while (n < ((PathDataNode[])object).length) {
                object[n].interpolatePathDataNode(pathDataNodeArray[n], pathDataNodeArray2[n], f);
                ++n;
            }
            return true;
        }
        object = new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        throw object;
    }

    private static int nextStart(String string, int n) {
        while (n < string.length()) {
            char c = string.charAt(n);
            if (((c - 65) * (c - 90) <= 0 || (c - 97) * (c - 122) <= 0) && c != 'e' && c != 'E') {
                return n;
            }
            ++n;
        }
        return n;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArray, PathDataNode[] pathDataNodeArray2) {
        int n = 0;
        while (n < pathDataNodeArray2.length) {
            pathDataNodeArray[n].mType = pathDataNodeArray2[n].mType;
            for (int i = 0; i < pathDataNodeArray2[n].mParams.length; ++i) {
                pathDataNodeArray[n].mParams[i] = pathDataNodeArray2[n].mParams[i];
            }
            ++n;
        }
    }
}
