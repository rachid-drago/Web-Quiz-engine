import java.util.*;

class AsciiCharSequence implements CharSequence/* extends/implements */ {
    // implementation
    byte[] b;
    AsciiCharSequence(byte[] b) {
        this.b = b.clone();
    }

    @Override
    public int length() {
        return b.length;
    }

    @Override
    public char charAt(int i) {
        return (char) b[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        //byte[] b2 = new byte[i1 - i + 1];
        byte[] b2 = Arrays.copyOfRange(b, i, i1);

        return new AsciiCharSequence(b2);
    }

    @Override
    public String toString() {
        return new String(b);
    }

}