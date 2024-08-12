/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.net.Uri
 *  androidx.camera.core.impl.utils.Exif
 *  androidx.camera.view.TransformUtils
 *  androidx.camera.view.transform.OutputTransform
 */
package androidx.camera.view.transform;

import android.content.ContentResolver;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.view.TransformUtils;
import androidx.camera.view.transform.OutputTransform;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileTransformFactory {
    private final boolean mUseExifOrientation;

    FileTransformFactory(boolean bl) {
        this.mUseExifOrientation = bl;
    }

    public OutputTransform getOutputTransform(ContentResolver object, Uri uri) throws IOException {
        object = object.openInputStream(uri);
        try {
            uri = this.getOutputTransform((InputStream)object);
            return uri;
        }
        finally {
            if (object != null) {
                ((InputStream)object).close();
            }
        }
    }

    public OutputTransform getOutputTransform(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            file = this.getOutputTransform(fileInputStream);
            return file;
        }
        finally {
            ((InputStream)fileInputStream).close();
        }
    }

    public OutputTransform getOutputTransform(InputStream inputStream) throws IOException {
        Exif exif = Exif.createFromInputStream((InputStream)inputStream);
        inputStream = new Rect(0, 0, exif.getWidth(), exif.getHeight());
        Matrix matrix = TransformUtils.getNormalizedToBuffer((Rect)inputStream);
        if (!this.mUseExifOrientation) return new OutputTransform(matrix, TransformUtils.rectToSize((Rect)inputStream));
        matrix.postConcat(TransformUtils.getExifTransform((int)exif.getOrientation(), (int)exif.getWidth(), (int)exif.getHeight()));
        return new OutputTransform(matrix, TransformUtils.rectToSize((Rect)inputStream));
    }
}
