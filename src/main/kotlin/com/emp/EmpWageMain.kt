package com.emp

fun main(args: Array<String>) {

    val companiesMonthlyWages: MutableList<Triple<String, List<Float>, Float>> = mutableListOf()

    val wageCompany1 = CompanyEmpWage("Infosys", 25f, 25, 100)
    val wageCompany2 = CompanyEmpWage("Accenture", 24f, 21, 90)
    val wageCompany3 = CompanyEmpWage("TCS", 20f, 20, 80)

    val empWageBuilder = EmpWageBuilder()

    with(empWageBuilder) {
        addCompanyEmpWage(wageCompany1)
        addCompanyEmpWage(wageCompany2)
        addCompanyEmpWage(wageCompany3)
    }

    val company1MonthlyWage = with(wageCompany1) {
        EmpWageComputation.computeMonthlyWage(companyName, wagePerHour, workingDays, workingHours)
    }
    val company2MonthlyWage = with(wageCompany2) {
        EmpWageComputation.computeMonthlyWage(companyName, wagePerHour, workingDays, workingHours)
    }
    val company3MonthlyWage = with(wageCompany3) {
        EmpWageComputation.computeMonthlyWage(companyName, wagePerHour, workingDays, workingHours)
    }

    with(companiesMonthlyWages) {
        add(company1MonthlyWage)
        add(company2MonthlyWage)
        add(company3MonthlyWage)
    }

    empWageBuilder.companiesEmpWageBuilders.forEach {
        println(it)
    }
    companiesMonthlyWages.forEach {
        println(it)
    }
}