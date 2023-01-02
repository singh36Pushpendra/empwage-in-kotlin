package com.emp

data class CompanyEmpWage(var companyName: String, var wagePerHour: Float, var workingDays: Int, var workingHours: Int) {
}

class EmpWageBuilder {
    private val _companiesEmpWageBuilders = mutableListOf<CompanyEmpWage>()
    internal var companiesEmpWageBuilders = listOf<CompanyEmpWage>()
        get() {
            return _companiesEmpWageBuilders
        }

    fun addCompanyEmpWage(companyEmpWage: CompanyEmpWage) {
        _companiesEmpWageBuilders.add(companyEmpWage)
    }
}