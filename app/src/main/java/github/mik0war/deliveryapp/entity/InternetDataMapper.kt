package github.mik0war.deliveryapp.entity

interface InternetDataMapper<S: Entity, R: Entity> {
    fun map(dataObject: S): R
}