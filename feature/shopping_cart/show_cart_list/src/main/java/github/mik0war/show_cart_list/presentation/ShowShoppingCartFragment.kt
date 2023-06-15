package github.mik0war.show_cart_list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.database_communication.di.FillShoppingCartSubComponentProvider
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.dishCounted.DishCountedUIModel
import github.mik0war.recycler_list.presentation.GetDataListViewModel
import github.mik0war.recycler_list.presentation.ImageLoader
import github.mik0war.show_cart_list.R
import github.mik0war.show_cart_list.di.ShowShoppingCartSubComponentProvider
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import github.mik0war.recycler_list.R as R_list

class ShowShoppingCartFragment : Fragment() {
    @Inject
    lateinit var showCartViewModel: GetDataListViewModel<DishCountedUIModel>
    lateinit var fillViewModel: github.mik0war.database_communication.presentation.ShoppingCartCommunicationViewModelFromCart
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R_list.layout.fragment_list_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity().application as ShowShoppingCartSubComponentProvider).provideShowShoppingCartSubComponent()
            .inject(this)
        super.onViewCreated(view, savedInstanceState)

        val applyButton = view.findViewById<Button>(R_list.id.applyButton)
        applyButton.visibility = View.VISIBLE

        applyButton.setOnClickListener {
            accessToFillViewModel { fillViewModel.clearCart() }
        }

        val recyclerView = view.findViewById<RecyclerView>(R_list.id.objectList)

        fillViewModel =
            github.mik0war.database_communication.presentation.ShoppingCartCommunicationViewModelFromCart(
                requireActivity().application as FillShoppingCartSubComponentProvider
            )

        recyclerView.adapter = setupAdapter(applyButton)

        showCartViewModel.getDataList()
    }

    private fun setupAdapter(applyButton: Button): ShowShoppingCartRecyclerViewAdapter {
        val onSuccessClickListener: (value: Pair<DishCountedUIModel, Int>) -> Unit =
            { (uiModel, id) ->
                val changeCount = when (id) {
                    R.id.incrementButton -> 1
                    R.id.decrementButton -> -1
                    else -> throw IllegalStateException()
                }

                accessToFillViewModel { fillViewModel.addDishOnShoppingCart(uiModel, changeCount) }
            }

        val adapter = ShowShoppingCartRecyclerViewAdapter(
            showCartViewModel,
            ImageLoader.Base(),
            ShowShoppingCartTransferDataGetter(),
            StringResourceProvider.Base(requireContext())
        )

        adapter.onSuccessClickListener = onSuccessClickListener

        showCartViewModel.observe(this) {
            adapter.update()
        }

        showCartViewModel.observe(this) { dishCountedUIModelList ->
            var totalPrice = 0
            dishCountedUIModelList.forEach {
                totalPrice += it.getTotalPrice()
            }

            applyButton.text = if (totalPrice == 0)
                requireContext().getString(R.string.empty_buy_button_label)
            else
                requireContext().getString(R.string.buy_button_text, totalPrice)
        }

        return adapter
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun accessToFillViewModel(lambda: () -> Job) {
        GlobalScope.launch {
            lambda.invoke().join()
            showCartViewModel.getDataList()
        }
    }

}