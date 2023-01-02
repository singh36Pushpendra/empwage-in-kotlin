package com.emp

enum class EmpStatus(val fullDayHour: Int = 0) {
    ABSENT,
    FULL_TIME(8),
    PART_TIME(4)
}