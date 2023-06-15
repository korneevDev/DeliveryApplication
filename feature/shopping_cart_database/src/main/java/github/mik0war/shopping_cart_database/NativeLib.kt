package github.mik0war.shopping_cart_database

class NativeLib {

    /**
     * A native method that is implemented by the 'shopping_cart_database' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'shopping_cart_database' library on application startup.
        init {
            System.loadLibrary("shopping_cart_database")
        }
    }
}