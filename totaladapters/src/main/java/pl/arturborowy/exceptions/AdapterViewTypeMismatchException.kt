package pl.arturborowy.exceptions

class AdapterViewTypeMismatchException : ClassCastException(
        "getLayoutResId() top view has different type than ViewT.")