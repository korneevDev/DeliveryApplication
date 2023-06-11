package github.mik0war.deliveryapp.feature.internetData.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ObserveLiveData<T> {
    fun observe(owner: LifecycleOwner, observer: Observer<T>)
}