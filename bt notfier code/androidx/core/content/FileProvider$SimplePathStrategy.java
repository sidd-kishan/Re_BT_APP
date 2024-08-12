/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 *  androidx.core.content.FileProvider$PathStrategy
 */
package androidx.core.content;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

static class FileProvider.SimplePathStrategy
implements FileProvider.PathStrategy {
    private final String mAuthority;
    private final HashMap<String, File> mRoots = new HashMap();

    FileProvider.SimplePathStrategy(String string) {
        this.mAuthority = string;
    }

    void addRoot(String charSequence, File file) {
        if (TextUtils.isEmpty((CharSequence)charSequence)) throw new IllegalArgumentException("Name must not be empty");
        try {
            File file2 = file.getCanonicalFile();
            this.mRoots.put((String)charSequence, file2);
        }
        catch (IOException iOException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Failed to resolve canonical path for ");
            ((StringBuilder)charSequence).append(file);
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString(), iOException);
        }
    }

    public File getFileForUri(Uri object) {
        Object object2 = object.getEncodedPath();
        int n = ((String)object2).indexOf(47, 1);
        Object object3 = Uri.decode((String)((String)object2).substring(1, n));
        object2 = Uri.decode((String)((String)object2).substring(n + 1));
        if ((object3 = this.mRoots.get(object3)) == null) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Unable to find configured root for ");
            ((StringBuilder)object3).append(object);
            throw new IllegalArgumentException(((StringBuilder)object3).toString());
        }
        object = new File((File)object3, (String)object2);
        try {
            object2 = ((File)object).getCanonicalFile();
            if (!((File)object2).getPath().startsWith(((File)object3).getPath())) throw new SecurityException("Resolved path jumped beyond configured root");
            return object2;
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to resolve canonical path for ");
            stringBuilder.append(object);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public Uri getUriForFile(File object) {
        Object object2;
        Iterator<Map.Entry<String, File>> iterator;
        CharSequence charSequence;
        try {
            charSequence = ((File)object).getCanonicalPath();
            object = null;
            iterator = this.mRoots.entrySet().iterator();
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to resolve canonical path for ");
            stringBuilder.append(object);
            object = new IllegalArgumentException(stringBuilder.toString());
            throw object;
        }
        while (iterator.hasNext()) {
            object2 = iterator.next();
            String string = object2.getValue().getPath();
            if (!((String)charSequence).startsWith(string) || object != null && string.length() <= ((File)object.getValue()).getPath().length()) continue;
            object = object2;
        }
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to find configured root that contains ");
            ((StringBuilder)object).append((String)charSequence);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        object2 = ((File)object.getValue()).getPath();
        object2 = ((String)object2).endsWith("/") ? ((String)charSequence).substring(((String)object2).length()) : ((String)charSequence).substring(((String)object2).length() + 1);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(Uri.encode((String)((String)object.getKey())));
        ((StringBuilder)charSequence).append('/');
        ((StringBuilder)charSequence).append(Uri.encode((String)object2, (String)"/"));
        object = ((StringBuilder)charSequence).toString();
        return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath((String)object).build();
    }
}
