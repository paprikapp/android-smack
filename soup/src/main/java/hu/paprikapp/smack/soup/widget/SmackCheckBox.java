package hu.paprikapp.smack.soup.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CheckBox;

/**
 * @author Balazs Varga
 */
public class SmackCheckBox extends CheckBox {

    public SmackCheckBox(@NonNull Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public SmackCheckBox(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public SmackCheckBox(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SmackCheckBox(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        SmackFont.in(this).trySetFromAttrs(attrs, defStyleAttr, defStyleRes);
    }
}
