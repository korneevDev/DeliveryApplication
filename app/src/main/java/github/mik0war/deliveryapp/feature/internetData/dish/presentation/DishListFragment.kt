package github.mik0war.deliveryapp.feature.internetData.dish.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.MainActivity
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.internetData.core.presentation.ImageLoader
import github.mik0war.deliveryapp.feature.internetData.core.presentation.InternetDataViewModel
import javax.inject.Inject

class DishListFragment : Fragment() {
    @Inject
    lateinit var dishViewModel: InternetDataViewModel<DishUIModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_category_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ((requireActivity() as MainActivity).application as DeliveryApp)
            .appComponent.dishSubComponent().create().inject(this)
        super.onViewCreated(view, savedInstanceState)

        val adapter = DishRecyclerViewAdapter(dishViewModel, ImageLoader.Base()){
            dishViewModel.getCategoryList()
        }

        dishViewModel.observe(this) {
            adapter.update()
        }

        view.findViewById<RecyclerView>(R.id.categoryList).adapter = adapter

        dishViewModel.getCategoryList()
    }
}