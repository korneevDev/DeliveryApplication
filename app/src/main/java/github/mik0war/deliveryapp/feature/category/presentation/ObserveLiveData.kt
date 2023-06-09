package github.mik0war.deliveryapp.feature.category.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ObserveLiveData<T> {
    fun observe(owner: LifecycleOwner, observer: Observer<T>)
}