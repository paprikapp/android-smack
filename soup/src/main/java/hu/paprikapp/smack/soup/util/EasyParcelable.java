package hu.paprikapp.smack.soup.util;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

/**
 * @author Balazs Varga
 */
public class EasyParcelable {
    private EasyParcelable() {
        throw new UnsupportedOperationException("No instances.");
    }

    public static <T extends Parcelable> Parcelable.Creator<T> createCreator(final Class<T> clazz) {
        return new Parcelable.Creator<T>() {
            @Override
            public T createFromParcel(Parcel source) {
                return newInstance(clazz, source);
            }

            @SuppressWarnings("unchecked")
            @Override
            public T[] newArray(int size) {
                return (T[]) Array.newInstance(clazz, size);
            }
        };
    }

    private static <T extends Parcelable> T newInstance(Class<T> clazz, Parcel source) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(Parcel.class);
            constructor.setAccessible(true);
            return constructor.newInstance(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
