package practice.phrases.domain.util



//sealed class Resource<out T: Any> {
//    data class Success<out T: Any>(val data: T): Resource<T>()
//    data class Error(val exception: Throwable): Resource<Nothing>()
//    object Loading: Resource<Nothing>()
//
//    fun toData(): T? = if(this is Success) this.data else null
//}

// Thanks https://speakerdeck.com/skydoves/modeling-retrofit-responses-with-sealed-classes-and-coroutines?slide=20
// https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe
sealed class NetworkResult<T : Any> {
    class Success<T: Any>(val data: T) : NetworkResult<T>()
    class Failure<T: Any>(val code: Int, val message: String?) : NetworkResult<T>()
    class Exception<T: Any>(val e: Throwable) : NetworkResult<T>()
}


