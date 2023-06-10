package github.mik0war.deliveryapp.feature.internetData.core.presentation

interface CustomViewInterface<T>{
    fun set(content: T)
}
interface CustomTextViewInterface : CustomViewInterface<String>

