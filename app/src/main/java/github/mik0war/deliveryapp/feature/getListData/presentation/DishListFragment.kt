package github.mik0war.deliveryapp.feature.getListData.presentation

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.database_communication.presentation.ShoppingCartCommunicationViewModelFromDishList
import github.mik0war.deliveryapp.DeliveryApp
import github.mik0war.deliveryapp.MainActivity
import github.mik0war.deliveryapp.R
import github.mik0war.recycler_list.R as R_listModule
import github.mik0war.deliveryapp.feature.getListData.tags.presentation.TagsRecyclerViewAdapter
import github.mik0war.deliveryapp.feature.getListData.tags.presentation.TagsViewModel
import github.mik0war.entity.ColorResourceProvider
import github.mik0war.entity.StringResourceProvider
import github.mik0war.entity.dataModel.dish.DishUIModel
import github.mik0war.entity.dataModel.tag.Tag
import github.mik0war.entity.dataModel.tag.TagState
import github.mik0war.recycler_list.presentation.GetDataListViewModel
import github.mik0war.recycler_list.presentation.ImageLoader
import javax.inject.Inject

class DishListFragment : Fragment() {
    @Inject
    lateinit var dishViewModel: GetDataListViewModel<DishUIModel>
    @Inject
    lateinit var tagsViewModel: TagsViewModel<DishUIModel>

    lateinit var fillViewModel: ShoppingCartCommunicationViewModelFromDishList
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R_listModule.layout.fragment_list_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ((requireActivity() as MainActivity).application as DeliveryApp)
            .appComponent.dishSubComponent().create().inject(this)
        super.onViewCreated(view, savedInstanceState)


        (requireActivity() as MainActivity).setBottomNavigationViewItemSelected(R.id.navigation_home)

        val recyclerView = view.findViewById<RecyclerView>(R_listModule.id.objectList)

        val dialogConfigurator = DishDialogConfigurator.Base(
            ImageLoader.Base(), StringResourceProvider.Base(requireContext())
        )

        fillViewModel = ShoppingCartCommunicationViewModelFromDishList(requireActivity().application as DeliveryApp)

        recyclerView.adapter = setupAdapter(dialogConfigurator)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        dishViewModel.getDataList()

        val tagsView = view.findViewById<RecyclerView>(R_listModule.id.tagsList)
        tagsView.visibility = View.VISIBLE

        tagsView.adapter = setupTagsAdapter()

    }
    private fun setupAdapter(dialogConfigurator: DishDialogConfigurator): DishRecyclerViewAdapter {
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

    private fun setupTagsAdapter() : TagsRecyclerViewAdapter {

        dishViewModel.observe(this) {
            tagsViewModel.setTagsList(it)
        }

        val onChangeTagClickListener: (tag: Tag, newTagState: TagState) -> Unit = { tag, state  ->
            tagsViewModel.updateTag(tag, state)
            dishViewModel.getDataList(tagsViewModel.getSelectedTags())
        }

        val adapter = TagsRecyclerViewAdapter(
            tagsViewModel,
            ColorResourceProvider.Base(requireContext()),
            onChangeTagClickListener
            )

        tagsViewModel.observe(this){
            adapter.update()
        }

        return adapter
    }
}