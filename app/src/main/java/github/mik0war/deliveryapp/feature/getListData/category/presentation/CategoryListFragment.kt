package github.mik0war.deliveryapp.feature.getListData.category.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.MainActivity
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.category.CategoryUIModel
import github.mik0war.deliveryapp.feature.getListData.core.presentation.ImageLoader
import github.mik0war.deliveryapp.feature.getListData.core.presentation.GetDataListViewModel
import javax.inject.Inject

class CategoryListFragment : Fragment() {

    @Inject
    lateinit var categoryViewModel: GetDataListViewModel<CategoryUIModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ((requireActivity() as MainActivity).application as DeliveryApp)
            .appComponent.categorySubComponent().create().inject(this)
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.objectList).adapter = setupAdapter()

        categoryViewModel.getDataList()
    }

    companion object{
        const val FRAGMENT_NAME_KEY = "FRAGMENT_KEY"
    }

    private fun setupAdapter(): CategoryRecyclerViewAdapter{
        val adapter = CategoryRecyclerViewAdapter(
            categoryViewModel,
            ImageLoader.Base(),
            CategoryTransferDataGetter()
        )

        val onSuccessClickListener: (name: String) -> Unit = { string ->
            val bundle = Bundle().also { it.putString(FRAGMENT_NAME_KEY, string) }
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dish, bundle)
        }

        val onErrorClockListener: () -> Unit = {
            categoryViewModel.getDataList()
        }

        adapter.onSuccessClickListener = onSuccessClickListener
        adapter.onErrorClickListener = onErrorClockListener

        categoryViewModel.observe(this) {
            adapter.update()
        }

        return adapter
    }
}