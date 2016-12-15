#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}

#end
/**
 * This specifies the contract between the [IPresenter] and the [IView].
 *
 * @author  ${USER}
 * @version 0.0.1
 * @since   ${DATE}
 */

interface ${NAME} {
    interface Presenter: IPresenter<View>

    interface View: IView, IFragmentView
}