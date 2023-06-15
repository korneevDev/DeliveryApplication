package github.mik0war.entity.dataModel.tag

sealed class Tag(
    private val name: String,
){
    fun getTagName() = name
    open class Common(name: String): Tag(name)
    open class Selected(name: String): Tag(name)
    class Unreachable(name: String): Tag(name)

    open class MainSelected(name: String): Selected(name)

    class MainSuperSelected(name: String): MainSelected(name)
    class MainCommon(name: String): Common(name)
}

enum class TagState{
    COMMON,
    SELECTED
}