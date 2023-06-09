package github.mik0war.deliveryapp.feature.category.presentation

interface CustomViewInterface<T>{
    fun set(content: T)
}
interface CustomTextViewInterface : CustomViewInterface<String>

