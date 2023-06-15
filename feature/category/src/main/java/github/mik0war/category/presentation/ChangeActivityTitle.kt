package github.mik0war.category.presentation

interface ChangeActivityTitle {
    fun changeTitle(newTitle: String, buttonListener: () -> Unit)
}