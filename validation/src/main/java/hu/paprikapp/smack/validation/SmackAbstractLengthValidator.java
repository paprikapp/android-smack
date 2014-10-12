package hu.paprikapp.smack.validation;

/**
 * @author Balazs Varga
 */
public abstract class SmackAbstractLengthValidator extends SmackAbstractValidator {

    private int mLength;
    private boolean mExactly;

    public SmackAbstractLengthValidator(String message, int length, boolean exactly) {
        super(message);
        mLength = length;
        mExactly = exactly;
    }

    public int getLength() {
        return mLength;
    }

    public void setLength(int length) {
        mLength = length;
    }

    public boolean isExactly() {
        return mExactly;
    }

    public void setExactly(boolean exactly) {
        mExactly = exactly;
    }
}
