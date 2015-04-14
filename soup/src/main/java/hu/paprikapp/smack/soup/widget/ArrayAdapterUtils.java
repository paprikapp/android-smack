package hu.paprikapp.smack.soup.widget;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.support.annotation.NonNull;

import java.util.Collection;

/**
 * Created by warnyul on 8/2/2014.
 */
public final class ArrayAdapterUtils {

    private ArrayAdapterUtils() {}

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <T> void addAll(@NonNull ArrayAdapter<T> adapter, @Nullable Collection<T> items) {
        if (items == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            adapter.addAll(items);
        } else {
            for (T item : items) {
                adapter.add(item);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <T> void addAll(@NonNull ArrayAdapter<T> adapter, @Nullable T... items) {
        if (items == null)
            return;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            adapter.addAll(items);
        } else {
            for (T item : items) {
                adapter.add(item);
            }
        }
    }
}
