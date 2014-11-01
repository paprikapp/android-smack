package hu.paprikapp.smack.soup.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CheckBox;

/**
 * @author Balazs Varga
 */
public class SmackCheckBox extends CheckBox {
    public SmackCheckBox(Context context) {
        super(context);
        init(context, null, -1);
    }

    public SmackCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, -1);
    }

    public SmackCheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        SmackFont.in(this).trySetFromAttrs(attrs);
    }
}
