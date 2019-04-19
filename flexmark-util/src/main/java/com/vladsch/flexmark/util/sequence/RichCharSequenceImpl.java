package com.vladsch.flexmark.util.sequence;

/**
 * A CharSequence that references original char sequence and maps '\0' to '\uFFFD'
 * a subSequence() returns a sub-sequence from the original base sequence
 */
final public class RichCharSequenceImpl extends RichCharSequenceBase<RichCharSequenceImpl> {
    public static final RichCharSequenceImpl NULL = new RichCharSequenceImpl("");
    public static final RichCharSequenceImpl[] EMPTY_ARRAY = new RichCharSequenceImpl[0];

    final CharSequence charSequence;

    public RichCharSequenceImpl(CharSequence charSequence) {
        this.charSequence = charSequence;
    }

    @Override
    public RichCharSequenceImpl[] emptyArray() {
        return EMPTY_ARRAY;
    }

    @Override
    public RichCharSequenceImpl nullSequence() {
        return NULL;
    }

    @Override
    public RichCharSequenceImpl sequenceOf(final CharSequence charSequence, final int startIndex, final int endIndex) {
        return of(charSequence, startIndex, endIndex);
    }

    @Override
    public RichCharSequenceImpl subSequence(final int start, final int end) {
        if (start == 0 && end == charSequence.length()) return this;
        return new RichCharSequenceImpl(charSequence.subSequence(start, end));
    }

    @Override
    public int length() {
        return charSequence.length();
    }

    @Override
    public char charAt(final int index) {
        return charSequence.charAt(index);
    }

    public static RichCharSequenceImpl of(CharSequence charSequence) {
        if (charSequence instanceof RichCharSequenceImpl) return ((RichCharSequenceImpl) charSequence);
        else if (charSequence != null) return of(charSequence, 0, charSequence.length());
        return NULL;
    }

    public static RichCharSequenceImpl of(CharSequence charSequence, int start) {
        if (charSequence instanceof RichCharSequenceImpl) return ((RichCharSequenceImpl) charSequence).subSequence(start);
        else if (charSequence != null) return of(charSequence, start, charSequence.length());
        return NULL;
    }

    public static RichCharSequenceImpl of(CharSequence charSequence, int start, int end) {
        if (charSequence instanceof RichCharSequenceImpl) return ((RichCharSequenceImpl) charSequence).subSequence(start, end);
        else if (charSequence != null) {
            if (start == 0 && end == charSequence.length()) return new RichCharSequenceImpl(charSequence);
            else return new RichCharSequenceImpl(charSequence.subSequence(start, end));
        }
        return NULL;
    }
}
