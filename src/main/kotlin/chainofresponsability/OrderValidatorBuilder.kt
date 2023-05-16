package chainofresponsability

class OrderValidatorBuilder {
    companion object {
        fun buildSalesOrderValidator(): OrderValidator {
            val validator: OrderValidator = SalesOrderValidator()
            validator.addValidator(buildCustomerValidator())
            validator.addValidator(OrderItemValidator())
            validator.addValidator(CreditValidator())
            return validator
        }

        private fun buildCustomerValidator(): OrderValidator {
            val validator: OrderValidator = CustomerValidator()
            validator.addValidator(buildContributorValidator())
            return validator
        }

        private fun buildContributorValidator(): OrderValidator {
            val validator: OrderValidator = ContributorValidator()
            validator.addValidator(AddressValidator())
            validator.addValidator(TelephoneValidator())
            return validator
        }
    }

}