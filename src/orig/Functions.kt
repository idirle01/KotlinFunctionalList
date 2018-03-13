package orig

fun <T> tail(l: List<T>): List<T> = when (l) {
    emptyList<T>() -> throw IllegalArgumentException()
    else -> l.drop(1)
}

fun <T> head (l: List<T>): T = (l.take(1))[0]

fun <T> setHead(l: List<T>, item: T): List<T> = when (l) {
    emptyList<T>() -> listOf(item)
    else -> listOf(item) + tail(l)
}

fun <T> drop(l: List<T>, n: Int): List<T> = when (n) {
    in 1 until l.size -> {
        dropHelper(l,n)
    } else -> emptyList()
}

var counter: Int = 0
fun <T> dropHelper (l:List<T>, n: Int): List<T> {
    if (counter == n) {
        return tail(l)
    } else {
        counter ++
        return dropHelper(tail(l), n-1)
    }
}

fun <T> init(l: List<T>): List<T> = when (l) {
    emptyList<T>() -> throw IllegalArgumentException()
    else ->
        if (l.size == 1) emptyList() else listOf(head(l)) + init(tail(l))

}


fun <T> foldLeft(l: List<T>, initial : T, f: (T, T) -> T): T = when (l) {
    emptyList<T>() -> initial
    else -> foldLeft(tail(l), f(initial, head(l)), f)
}


fun <T> sum(l: List<T>) : T = TODO() //  this doesn't work for some reason


fun <T> product(l: List<T>) : T = TODO()  //  this doesn't work for some reason

fun <T> length(l: List<T>) : Int = TODO()  //  this doesn't work for some reason

// need to have a look at how we can do this with foldLeft
// look into tailrec options
fun <T> reverse(l: List<T>): List<T> =  when (l) {
    emptyList<T>() -> emptyList()
    else -> reverse(tail(l)) + head(l)
}

fun <T> flatten(l: List<List<T>>): List<T> = when (l) {
    emptyList<T>() -> emptyList()
    else -> head(l) + flatten(tail(l))
}

fun <T> map(l: List<T>, f: (T) -> T): List<T> = TODO()

fun <T> filter(l: List<T>, f: (T) -> Boolean): List<T> = TODO()

fun <T> flatMap(l: List<T>, f:(T) -> List<T>): List<T> = TODO()

fun <T> maxAverage(l: List<Triple<T, T, T>>): T = TODO()

fun <T> variance(l: List<T>): T = TODO()