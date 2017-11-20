package infiltration;

import android.content.Context;

public class outcry {
    public outcry(Context context, String str) {
        try {
            init(context, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private native void init(Context context, String str);

    static {
        System.loadLibrary("secondhand");
    }
}
