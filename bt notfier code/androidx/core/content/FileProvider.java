/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.ProviderInfo
 *  android.database.Cursor
 *  android.database.MatrixCursor
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.ParcelFileDescriptor
 *  android.webkit.MimeTypeMap
 *  androidx.core.content.ContextCompat
 *  androidx.core.content.FileProvider$PathStrategy
 *  androidx.core.content.FileProvider$SimplePathStrategy
 */
package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = new String[]{"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static HashMap<String, PathStrategy> sCache = new HashMap();
    private PathStrategy mStrategy;

    private static File buildPath(File file, String ... stringArray) {
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            File file2 = file;
            if (string != null) {
                file2 = new File(file, string);
            }
            ++n2;
            file = file2;
        }
        return file;
    }

    private static Object[] copyOf(Object[] objectArray, int n) {
        Object[] objectArray2 = new Object[n];
        System.arraycopy(objectArray, 0, objectArray2, 0, n);
        return objectArray2;
    }

    private static String[] copyOf(String[] stringArray, int n) {
        String[] stringArray2 = new String[n];
        System.arraycopy(stringArray, 0, stringArray2, 0, n);
        return stringArray2;
    }

    private static PathStrategy getPathStrategy(Context object, String object2) {
        HashMap<String, PathStrategy> hashMap = sCache;
        synchronized (hashMap) {
            PathStrategy pathStrategy;
            PathStrategy pathStrategy2 = pathStrategy = sCache.get(object2);
            if (pathStrategy != null) return pathStrategy2;
            try {
                pathStrategy2 = FileProvider.parsePathStrategy(object, (String)object2);
                sCache.put((String)object2, pathStrategy2);
            }
            catch (XmlPullParserException xmlPullParserException) {
                object = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", xmlPullParserException);
                throw object;
            }
            catch (IOException iOException) {
                object2 = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", iOException);
                throw object2;
            }
            return pathStrategy2;
        }
    }

    public static Uri getUriForFile(Context context, String string, File file) {
        return FileProvider.getPathStrategy(context, string).getUriForFile(file);
    }

    public static Uri getUriForFile(Context context, String string, File file, String string2) {
        return FileProvider.getUriForFile(context, string, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, string2).build();
    }

    private static int modeToMode(String string) {
        int n;
        if ("r".equals(string)) {
            n = 0x10000000;
        } else if (!"w".equals(string) && !"wt".equals(string)) {
            if ("wa".equals(string)) {
                n = 0x2A000000;
            } else if ("rw".equals(string)) {
                n = 0x38000000;
            } else {
                if (!"rwt".equals(string)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid mode: ");
                    stringBuilder.append(string);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                n = 0x3C000000;
            }
        } else {
            n = 0x2C000000;
        }
        return n;
    }

    private static PathStrategy parsePathStrategy(Context object, String object2) throws IOException, XmlPullParserException {
        int n;
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy((String)object2);
        ProviderInfo providerInfo = object.getPackageManager().resolveContentProvider((String)object2, 128);
        if (providerInfo == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Couldn't find meta-data for provider with authority ");
            ((StringBuilder)object).append((String)object2);
            object = new IllegalArgumentException(((StringBuilder)object).toString());
            throw object;
        }
        XmlResourceParser xmlResourceParser = providerInfo.loadXmlMetaData(object.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (xmlResourceParser == null) throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        while ((n = xmlResourceParser.next()) != 1) {
            if (n != 2) continue;
            File[] fileArray = xmlResourceParser.getName();
            providerInfo = null;
            String string = xmlResourceParser.getAttributeValue(null, ATTR_NAME);
            String string2 = xmlResourceParser.getAttributeValue(null, ATTR_PATH);
            if (TAG_ROOT_PATH.equals(fileArray)) {
                object2 = DEVICE_ROOT;
            } else if (TAG_FILES_PATH.equals(fileArray)) {
                object2 = object.getFilesDir();
            } else if (TAG_CACHE_PATH.equals(fileArray)) {
                object2 = object.getCacheDir();
            } else if (TAG_EXTERNAL.equals(fileArray)) {
                object2 = Environment.getExternalStorageDirectory();
            } else if (TAG_EXTERNAL_FILES.equals(fileArray)) {
                fileArray = ContextCompat.getExternalFilesDirs((Context)object, null);
                object2 = providerInfo;
                if (fileArray.length > 0) {
                    object2 = fileArray[0];
                }
            } else if (TAG_EXTERNAL_CACHE.equals(fileArray)) {
                fileArray = ContextCompat.getExternalCacheDirs((Context)object);
                object2 = providerInfo;
                if (fileArray.length > 0) {
                    object2 = fileArray[0];
                }
            } else {
                object2 = providerInfo;
                if (Build.VERSION.SDK_INT >= 21) {
                    object2 = providerInfo;
                    if (TAG_EXTERNAL_MEDIA.equals(fileArray)) {
                        fileArray = object.getExternalMediaDirs();
                        object2 = providerInfo;
                        if (fileArray.length > 0) {
                            object2 = fileArray[0];
                        }
                    }
                }
            }
            if (object2 == null) continue;
            simplePathStrategy.addRoot(string, FileProvider.buildPath((File)object2, string2));
        }
        return simplePathStrategy;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) throw new SecurityException("Provider must not be exported");
        if (!providerInfo.grantUriPermissions) throw new SecurityException("Provider must grant uri permissions");
        this.mStrategy = FileProvider.getPathStrategy(context, providerInfo.authority.split(";")[0]);
    }

    public int delete(Uri uri, String string, String[] stringArray) {
        return this.mStrategy.getFileForUri(uri).delete() ? 1 : 0;
    }

    public String getType(Uri object) {
        int n = ((File)(object = this.mStrategy.getFileForUri((Uri)object))).getName().lastIndexOf(46);
        if (n < 0) return "application/octet-stream";
        object = ((File)object).getName().substring(n + 1);
        object = MimeTypeMap.getSingleton().getMimeTypeFromExtension((String)object);
        if (object == null) return "application/octet-stream";
        return object;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String string) throws FileNotFoundException {
        return ParcelFileDescriptor.open((File)this.mStrategy.getFileForUri(uri), (int)FileProvider.modeToMode(string));
    }

    public Cursor query(Uri matrixCursor, String[] object, String string, String[] object2, String objectArray) {
        object2 = this.mStrategy.getFileForUri((Uri)matrixCursor);
        string = matrixCursor.getQueryParameter(DISPLAYNAME_FIELD);
        matrixCursor = object;
        if (object == null) {
            matrixCursor = COLUMNS;
        }
        String[] stringArray = new String[((String[])matrixCursor).length];
        objectArray = new Object[((String[])matrixCursor).length];
        int n = ((String[])matrixCursor).length;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            int n4;
            block8: {
                block7: {
                    block6: {
                        if (n2 >= n) {
                            matrixCursor = FileProvider.copyOf(stringArray, n3);
                            object = FileProvider.copyOf(objectArray, n3);
                            matrixCursor = new MatrixCursor((String[])matrixCursor, 1);
                            matrixCursor.addRow((Object[])object);
                            return matrixCursor;
                        }
                        object = matrixCursor[n2];
                        if (!"_display_name".equals(object)) break block6;
                        stringArray[n3] = "_display_name";
                        n4 = n3 + 1;
                        object = string == null ? ((File)object2).getName() : string;
                        objectArray[n3] = object;
                        n3 = n4;
                        break block7;
                    }
                    n4 = n3;
                    if (!"_size".equals(object)) break block8;
                    stringArray[n3] = "_size";
                    n4 = n3 + 1;
                    objectArray[n3] = ((File)object2).length();
                    n3 = n4;
                }
                n4 = n3;
            }
            ++n2;
            n3 = n4;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String string, String[] stringArray) {
        throw new UnsupportedOperationException("No external updates");
    }
}
