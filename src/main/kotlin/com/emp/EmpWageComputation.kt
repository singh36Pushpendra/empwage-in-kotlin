package com.emp

import java.util.Random

object EmpWageComputation {

    fun checkEmpStatus(): EmpStatus {
        val random = Random()
        val ordinal = random.nextInt(3)

        return when (ordinal) {
            EmpStatus.ABSENT.ordinal -> EmpStatus.ABSENT
            EmpStatus.FULL_TIME.ordinal -> EmpStatus.FULL_TIME
            EmpStatus.PART_TIME.ordinal -> EmpStatus.PART_TIME
            else -> EmpStatus.ABSENT
        }
    }

    fun computeDailyWage(empStatus: EmpStatus, wagePerHour: Float): Float = wagePerHour * empStatus.fullDayHour * 1.0f

    fun computeMonthlyWage(companyName: String, wagePerHour: Float, workingDays: Int, workingHours: Int): Triple<String, List<Float>, Float> {
        var empStatus: EmpStatus

        var day = 1
        var dailyWage = 0f
        var monthlyWage: Float = 0f
        var totalWorkingHours = 0
        val dailyWagesOfMonth = mutableListOf<Float>()

        print("\nCompany Name: $companyName")
        while (day != (workingDays + 1) && totalWorkingHours != workingHours) {
            empStatus = checkEmpStatus()
            totalWorkingHours += empStatus.fullDayHour
            dailyWage = computeDailyWage(empStatus, wagePerHour)
            dailyWagesOfMonth.add(dailyWage)
            monthlyWage += dailyWage

//            println("\nDay $day:")
//            println("Employee Status: $empStatus \t $totalWorkingHours")
//            println("Employee Daily Wage: ${dailyWage}Rs.")

            day++
        }
        println("\nMonthly wage of employee: ${monthlyWage}Rs.\n")
        return Triple(companyName, dailyWagesOfMonth, monthlyWage)
    }
}