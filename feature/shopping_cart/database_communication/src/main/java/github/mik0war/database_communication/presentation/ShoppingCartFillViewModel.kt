package github.mik0war.database_communication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.mik0war.database_communication.domain.Interactor
import github.mik0war.entity.DataMapper
import github.mik0war.entity.Entity
import github.mik0war.entity.di.MainDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

interface ShoppingCartFillViewModel<T : Entity> {
    fun changeDishCountOnShoppingCart(dish: T, count: Int): Job
    fun clearCart(): Job

    class Base<S : Entity, R : Entity> @Inject constructor(
        private val interactor: Interactor<R>,
        private val mapper: DataMapper<S, R>,
        @MainDispatcher private val dispatcher: CoroutineDispatcher
    ) : ViewModel(), ShoppingCartFillViewModel<S> {
        override fun changeDishCountOnShoppingCart(dish: S, count: Int) =
            viewModelScope.launch(dispatcher) {
                interactor.addDishToCart(mapper.map(dish), count)
            }

        override fun clearCart(): Job =
            viewModelScope.launch(dispatcher) {
                interactor.clearCart()
            }
    }
}