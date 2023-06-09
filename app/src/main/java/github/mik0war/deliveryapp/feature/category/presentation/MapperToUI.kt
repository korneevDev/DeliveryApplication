package github.mik0war.deliveryapp.feature.category.presentation

import github.mik0war.deliveryapp.feature.category.core.CategoryMapper

class MapperToUI(
    private val headerView: CustomTextView,
    private val imageView: CustomTextView
) : CategoryMapper<Unit> {
    override fun map(id: Int, name: String, imageUrl: String) {
        headerView.set(name)
        imageView.set(imageUrl)
    }

}