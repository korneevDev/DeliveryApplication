package github.mik0war.deliveryapp.feature.internetData.core.core

interface InternetDataMapper<S: Entity, R: Entity> {
    fun map(dataObject: S): R
}