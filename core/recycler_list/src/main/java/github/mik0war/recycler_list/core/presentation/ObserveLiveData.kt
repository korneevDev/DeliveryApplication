package github.mik0war.recycler_list.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ObserveLiveData<T> {
    fun observe(owner: LifecycleOwner, observer: Observer<T>)
}