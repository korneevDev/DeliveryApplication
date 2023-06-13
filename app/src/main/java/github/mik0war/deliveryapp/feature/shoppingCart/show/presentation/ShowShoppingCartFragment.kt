package github.mik0war.deliveryapp.feature.shoppingCart.show.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.MainActivity
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.entity.dishCounted.DishCountedUIModel
import github.mik0war.deliveryapp.feature.getListData.category.presentation.CategoryListFragment
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListViewModel
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ImageLoader
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowShoppingCartFragment: Fragment() {
    @Inject
    lateinit var showCartViewModel: GetDataListViewModel<DishCountedUIModel>
    lateinit var fillViewModel: ShoppingCartCommunicationViewModelFromCart
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ((requireActivity() as MainActivity).application as DeliveryApp)
            .appComponent.shoppingCartSubComponent().create().inject(this)
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            (requireActivity() as MainActivity)
                .supportActionBar?.title = it.getString(CategoryListFragment.FRAGMENT_NAME_KEY)
        }


        val recyclerView = view.findViewById<RecyclerView>(R.id.objectList)

        fillViewModel = ShoppingCartCommunicationViewModelFromCart(requireActivity().application as DeliveryApp)

        recyclerView.adapter = setupAdapter()

        showCartViewModel.getDataList()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun setupAdapter(): ShowShoppingCartRecyclerViewAdapter {
        val onSuccessClickListener: (value: Pair<DishCountedUIModel, Int>) -> Unit = { (uiModel, id) ->
            val changeCount = when(id){
                R.id.incrementButton -> 1
                R.id.decrementButton -> -1
                else -> throw IllegalStateException()
            }
            GlobalScope.launch {
                fillViewModel.addDishOnShoppingCart(uiModel, changeCount).join()
                showCartViewModel.getDataList()
            }
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

        return adapter
    }

}