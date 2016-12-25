#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}
import dagger.internal.Preconditions
#end
#parse("File Header.java")
class ${NAME}: BasePresenter<${Contract_name}Contract.View>(), ${Contract_name}Contract.Presenter {
    //region View implementation
    override fun init(view: ${Contract_name}Contract.View) {
        super.init(view)
    }
    //endregion
}
