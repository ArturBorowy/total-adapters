package pl.arturborowy.util

internal object EmptyMethod {

    fun <FirstArgumentT, SecondArgumentT> twoArguments() =
            { _: FirstArgumentT, _: SecondArgumentT -> }
}