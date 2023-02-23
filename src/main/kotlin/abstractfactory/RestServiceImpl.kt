package abstractfactory

class RestServiceImpl: IServiceStackAbstractFactory {
    override fun getProductsService(): IProductService = ProductServiceRestImpl()

    override fun getEmployeeService(): IEmployeeService= EmployeeServiceRestImpl()
}