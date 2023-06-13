package github.mik0war.deliveryapp.feature.getListData.dish.presentation

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.MainActivity
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.StringResourceProvider
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.getListData.category.presentation.CategoryListFragment.Companion.FRAGMENT_NAME_KEY
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ImageLoader
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListViewModel
import javax.inject.Inject

class DishListFragment : Fragment() {
    @Inject
    lateinit var dishViewModel: GetDataListViewModel<DishUIModel>
    lateinit var fillViewModel: ShoppingCartCommunicationViewModelFromDishList
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ((requireActivity() as MainActivity).application as DeliveryApp)
            .appComponent.dishSubComponent().create().inject(this)
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            (requireActivity() as MainActivity)
                .supportActionBar?.title = it.getString(FRAGMENT_NAME_KEY)
        }

        (requireActivity() as MainActivity).setBottomNavigationViewItemSelected(R.id.navigation_home)

        val recyclerView = view.findViewById<RecyclerView>(R.id.objectList)

        val dialogConfigurator = DishDialogConfigurator.Base(
            ImageLoader.Base(), StringResourceProvider.Base(requireContext())
        )

        fillViewModel = ShoppingCartCommunicationViewModelFromDishList(requireActivity().application as DeliveryApp)

        recyclerView.adapter = setupAdapter(dialogConfigurator)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        dishViewModel.getDataList()
    }
    private fun setupAdapter(dialogConfigurator: DishDialogConfigurator): DishRecyclerViewAdapter{
        val onSuccessClickListener: (name: DishUIModel) -> Unit = { uiModel ->
            val dialog = dialogConfigurator.configureDialog(Dialog(requireActivity()), uiModel){
                fillViewModel.addDishOnShoppingCart(uiModel, 1)
            }

            dialog.show()
        }

        val onErrorClickListener: () -> Unit = {
            dishViewModel.getDataList()
        }

        val adapter = DishRecyclerViewAdapter(
            dishViewModel,
            ImageLoader.Base(),
            DishTransferDataGetter()
        )

        adapter.onSuccessClickListener = onSuccessClickListener
        adapter.onErrorClickListener = onErrorClickListener

        dishViewModel.observe(this) {
            adapter.update()
        }

        return adapter
    }

}