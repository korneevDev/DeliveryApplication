package github.mik0war.deliveryapp.entity

interface DataMapper<S: Entity, R: Entity> {
    fun map(dataObject: S): R
}