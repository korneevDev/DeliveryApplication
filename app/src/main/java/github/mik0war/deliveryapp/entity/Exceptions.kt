package github.mik0war.deliveryapp.entity

import java.io.IOException

class NoConnectionException : IOException()
class ServiceUnavailableException : IOException()
class NoCachedDishesException : IOException()