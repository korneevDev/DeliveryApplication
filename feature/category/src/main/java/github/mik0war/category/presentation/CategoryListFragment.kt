package github.mik0war.category.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.category.di.CategorySubComponentProvider
import github.mik0war.entity.dataModel.category.CategoryUIModel
import github.mik0war.recycler_list.presentation.GetDataListViewModel
import github.mik0war.recycler_list.presentation.ImageLoader
import javax.inject.Inject
import github.mik0war.recycler_list.R as CoreR

class CategoryListFragment : Fragment() {

    @Inject
    lateinit var categoryViewModel: GetDataListViewModel<CategoryUIModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(CoreR.layout.fragment_list_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity().application as CategorySubComponentProvider).provideCategorySubComponent().inject(this)
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(CoreR.id.objectList).adapter = setupAdapter()

        categoryViewModel.getDataList()
    }

    private fun setupAdapter(): CategoryRecyclerViewAdapter {
        val adapter = CategoryRecyclerViewAdapter(
            categoryViewModel,
            ImageLoader.Base(),
            CategoryTransferDataGetter()
        )

        val onSuccessClickListener: (name: String) -> Unit = { string ->

            val request = NavDeepLinkRequest.Builder
                .fromUri("android-app://github.mik0war.deliveryapp/dishListFragment".toUri())
                .build()

            (context as ChangeActivityTitle).changeTitle(string){
                findNavController().navigateUp()
            }

            findNavController().navigate(request)
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