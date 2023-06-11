package github.mik0war.deliveryapp.feature.shoppingCart.fillShoppingCart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.deliveryapp.di.MainDispatcher
import github.mik0war.deliveryapp.entity.Entity
import github.mik0war.deliveryapp.entity.DataMapper
import github.mik0war.deliveryapp.feature.shoppingCart.fillShoppingCart.domain.Interactor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

interface ShoppingCartFillViewModel<T : Entity> {
    fun changeDishCountOnShoppingCart(dish: T, count: Int): Job

    class Base<S : Entity, R : Entity> @Inject constructor(
        private val interactor: Interactor<R>,
        private val mapper: DataMapper<S, R>,
        @MainDispatcher private val dispatcher: CoroutineDispatcher
    ) : ViewModel(), ShoppingCartFillViewModel<S> {
        override fun changeDishCountOnShoppingCart(dish: S, count: Int) =
            viewModelScope.launch(dispatcher) {
                interactor.addDishToCart(mapper.map(dish), count)
            }
    }
}