package github.mik0war.deliveryapp.feature.category.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.MainActivity
import github.mik0war.deliveryapp.R
import javax.inject.Inject

class CategoryListFragment : Fragment() {

    @Inject
    lateinit var categoryViewModel: CategoryViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_category_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ((requireActivity() as MainActivity).application as DeliveryApp)
            .appComponent.inject(this)
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerViewAdapter(categoryViewModel)

        categoryViewModel.observe(this) {
            adapter.update()
        }
        view.findViewById<RecyclerView>(R.id.categoryList).adapter = adapter

        categoryViewModel.getCategoryList()
    }
}