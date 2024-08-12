/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$MessagingStyle$Message
 *  android.app.Person
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  androidx.core.app.Person
 *  androidx.core.app.Person$Builder
 */
package androidx.core.app;

import android.app.Notification;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.Person;
import java.util.ArrayList;
import java.util.List;

public static final class NotificationCompat.MessagingStyle.Message {
    static final String KEY_DATA_MIME_TYPE = "type";
    static final String KEY_DATA_URI = "uri";
    static final String KEY_EXTRAS_BUNDLE = "extras";
    static final String KEY_NOTIFICATION_PERSON = "sender_person";
    static final String KEY_PERSON = "person";
    static final String KEY_SENDER = "sender";
    static final String KEY_TEXT = "text";
    static final String KEY_TIMESTAMP = "time";
    private String mDataMimeType;
    private Uri mDataUri;
    private Bundle mExtras = new Bundle();
    private final Person mPerson;
    private final CharSequence mText;
    private final long mTimestamp;

    public NotificationCompat.MessagingStyle.Message(CharSequence charSequence, long l, Person person) {
        this.mText = charSequence;
        this.mTimestamp = l;
        this.mPerson = person;
    }

    @Deprecated
    public NotificationCompat.MessagingStyle.Message(CharSequence charSequence, long l, CharSequence charSequence2) {
        this(charSequence, l, new Person.Builder().setName(charSequence2).build());
    }

    static Bundle[] getBundleArrayForMessages(List<NotificationCompat.MessagingStyle.Message> list) {
        Bundle[] bundleArray = new Bundle[list.size()];
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            bundleArray[n2] = list.get(n2).toBundle();
            ++n2;
        }
        return bundleArray;
    }

    static NotificationCompat.MessagingStyle.Message getMessageFromBundle(Bundle bundle) {
        try {
            if (!bundle.containsKey(KEY_TEXT)) return null;
            if (bundle.containsKey(KEY_TIMESTAMP)) {
                Person person;
                if (bundle.containsKey(KEY_PERSON)) {
                    person = Person.fromBundle((Bundle)bundle.getBundle(KEY_PERSON));
                } else if (bundle.containsKey(KEY_NOTIFICATION_PERSON) && Build.VERSION.SDK_INT >= 28) {
                    person = Person.fromAndroidPerson((android.app.Person)((android.app.Person)bundle.getParcelable(KEY_NOTIFICATION_PERSON)));
                } else if (bundle.containsKey(KEY_SENDER)) {
                    person = new Person.Builder();
                    person = person.setName(bundle.getCharSequence(KEY_SENDER)).build();
                } else {
                    person = null;
                }
                NotificationCompat.MessagingStyle.Message message = new NotificationCompat.MessagingStyle.Message(bundle.getCharSequence(KEY_TEXT), bundle.getLong(KEY_TIMESTAMP), person);
                if (bundle.containsKey(KEY_DATA_MIME_TYPE) && bundle.containsKey(KEY_DATA_URI)) {
                    message.setData(bundle.getString(KEY_DATA_MIME_TYPE), (Uri)bundle.getParcelable(KEY_DATA_URI));
                }
                if (!bundle.containsKey(KEY_EXTRAS_BUNDLE)) return message;
                message.getExtras().putAll(bundle.getBundle(KEY_EXTRAS_BUNDLE));
                return message;
            }
        }
        catch (ClassCastException classCastException) {}
        return null;
    }

    static List<NotificationCompat.MessagingStyle.Message> getMessagesFromBundleArray(Parcelable[] parcelableArray) {
        ArrayList<NotificationCompat.MessagingStyle.Message> arrayList = new ArrayList<NotificationCompat.MessagingStyle.Message>(parcelableArray.length);
        int n = 0;
        while (n < parcelableArray.length) {
            NotificationCompat.MessagingStyle.Message message;
            if (parcelableArray[n] instanceof Bundle && (message = NotificationCompat.MessagingStyle.Message.getMessageFromBundle((Bundle)parcelableArray[n])) != null) {
                arrayList.add(message);
            }
            ++n;
        }
        return arrayList;
    }

    private Bundle toBundle() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            bundle.putCharSequence(KEY_TEXT, charSequence);
        }
        bundle.putLong(KEY_TIMESTAMP, this.mTimestamp);
        charSequence = this.mPerson;
        if (charSequence != null) {
            bundle.putCharSequence(KEY_SENDER, charSequence.getName());
            if (Build.VERSION.SDK_INT >= 28) {
                bundle.putParcelable(KEY_NOTIFICATION_PERSON, (Parcelable)this.mPerson.toAndroidPerson());
            } else {
                bundle.putBundle(KEY_PERSON, this.mPerson.toBundle());
            }
        }
        if ((charSequence = this.mDataMimeType) != null) {
            bundle.putString(KEY_DATA_MIME_TYPE, (String)charSequence);
        }
        if ((charSequence = this.mDataUri) != null) {
            bundle.putParcelable(KEY_DATA_URI, (Parcelable)charSequence);
        }
        if ((charSequence = this.mExtras) == null) return bundle;
        bundle.putBundle(KEY_EXTRAS_BUNDLE, (Bundle)charSequence);
        return bundle;
    }

    public String getDataMimeType() {
        return this.mDataMimeType;
    }

    public Uri getDataUri() {
        return this.mDataUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Person getPerson() {
        return this.mPerson;
    }

    @Deprecated
    public CharSequence getSender() {
        Object object = this.mPerson;
        object = object == null ? null : object.getName();
        return object;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public NotificationCompat.MessagingStyle.Message setData(String string, Uri uri) {
        this.mDataMimeType = string;
        this.mDataUri = uri;
        return this;
    }

    Notification.MessagingStyle.Message toAndroidMessage() {
        Person person = this.getPerson();
        int n = Build.VERSION.SDK_INT;
        CharSequence charSequence = null;
        CharSequence charSequence2 = null;
        if (n >= 28) {
            CharSequence charSequence3 = this.getText();
            long l = this.getTimestamp();
            charSequence = person == null ? charSequence2 : person.toAndroidPerson();
            charSequence = new Notification.MessagingStyle.Message(charSequence3, l, (android.app.Person)charSequence);
        } else {
            charSequence2 = this.getText();
            long l = this.getTimestamp();
            if (person != null) {
                charSequence = person.getName();
            }
            charSequence = new Notification.MessagingStyle.Message(charSequence2, l, charSequence);
        }
        if (this.getDataMimeType() == null) return charSequence;
        charSequence.setData(this.getDataMimeType(), this.getDataUri());
        return charSequence;
    }
}
