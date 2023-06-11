package github.mik0war.deliveryapp.feature.internetData.dish.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.MainActivity
import github.mik0war.deliveryapp.R
import github.mik0war.deliveryapp.entity.dish.DishUIModel
import github.mik0war.deliveryapp.feature.internetData.category.presentation.CategoryListFragment.Companion.FRAGMENT_NAME_KEY
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

        val onSuccessClickListener: (name: String) -> Unit = { string ->
            val bundle = Bundle().also { it.putString(FRAGMENT_NAME_KEY, string) }
            findNavController().navigate(R.id.action_navigation_dish_to_navigation_home, bundle)
        }

        val adapter = DishRecyclerViewAdapter(dishViewModel, ImageLoader.Base(), onSuccessClickListener){
            dishViewModel.getCategoryList()
        }

        dishViewModel.observe(this) {
            adapter.update()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.objectList)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        dishViewModel.getCategoryList()
    }
}