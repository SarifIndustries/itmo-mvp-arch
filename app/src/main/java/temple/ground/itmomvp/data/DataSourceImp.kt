package temple.ground.itmomvp.data

class DataSourceImp: DataSource {
    override fun fetchData(): String {
        Thread.sleep(3000)
        return "Data from server"
    }
}