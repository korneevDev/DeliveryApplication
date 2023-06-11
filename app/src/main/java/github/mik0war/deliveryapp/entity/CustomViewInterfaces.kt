package github.mik0war.deliveryapp.entity

interface CustomViewInterface<T>{
    fun set(content: T)
}
interface CustomTextViewInterface : CustomViewInterface<String>

