package pl.arturborowy.util

object EmptyMethod {

    fun <FirstArgumentT, SecondArgumentT> twoArguments() =
            { _: FirstArgumentT, _: SecondArgumentT -> }
}