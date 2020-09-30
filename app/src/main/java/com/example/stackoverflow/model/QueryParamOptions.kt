package com.example.stackoverflow.model

enum class Order(val order: String) {
    DESC("desc"),
    ASC("asc");

    companion object {
        fun valueOf(value: String, defaultValue: Order = Order.DESC): Order =
            values().find { it.order == value } ?: defaultValue
    }
}

enum class Sort(val sort: String) {
    ACTIVITY("activity"),
    VOTES("votes"),
    CREATION("creation"),
    HOT("hot"),
    WEEK("week"),
    MONTH("month");

    companion object {
        fun valueOf(value: String, defaultValue: Sort = VOTES): Sort =
            values().find { it.sort == value } ?: defaultValue
    }
}