#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}
import dagger.internal.Preconditions
#end
#parse("File Header.java")
class ${NAME} @Inject constructor(): ${Contract_name}Contract.Presenter {
    private lateinit var view: ${Contract_name}Contract.View

    //region View implementation
    override fun setView(view: ${Contract_name}Contract.View) {
        Preconditions.checkNotNull(view)

        this.view = view
    }

    override fun init() {
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
    }
    //endregion
}