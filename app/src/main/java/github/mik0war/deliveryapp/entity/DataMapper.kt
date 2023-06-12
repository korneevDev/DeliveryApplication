package github.mik0war.deliveryapp.entity

import github.mik0war.deliveryapp.entity.mapper.Mapper
import javax.inject.Inject

interface DataMapper<S: Entity, R: Entity> {
    fun map(dataObject: S): R

    class Abstract<S: Entity, R: Entity> @Inject constructor(
        private val mapper: Mapper<R>
    ) : DataMapper<S, R>{
        override fun map(dataObject: S): R =
            dataObject.map(mapper)
    }
}