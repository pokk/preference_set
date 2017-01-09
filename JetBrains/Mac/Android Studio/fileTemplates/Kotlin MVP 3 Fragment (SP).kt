#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}
import android.view.View
import dagger.internal.Preconditions
import rx.Observable
#end
#parse("File Header.java")
@PerFragment
class ${NAME}: BaseFragment(), ${Contract_name}Contract.View {
    //region Static initialization
    companion object Factory {
        // The key name of the fragment initialization parameters.
        private const val ARG_PARAM_: String = "param_"

        /**
         * Use this factory method to create a new instance of this fragment using the provided parameters.
         *
         * @return A new instance of [fragment] ${NAME}.
         */
        fun newInstance(arg1: String): ${NAME} = ${NAME}().apply() {
            this.arguments = Bundle().apply {
                this.putString(ARG_PARAM_, arg1)
            }
        }
    }
    //endregion

    @Inject
    lateinit var presenter: ${Contract_name}Contract.Presenter

    // Get the arguments from the bundle here.
    private val arg1: String by lazy { this.arguments.getString(ARG_PARAM_) }

    //region Fragment lifecycle
    override fun onResume() {
        super.onResume()
        this.presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        this.presenter.pause()
    }

    override fun onDestroy() {
        // After super.onDestroy() is executed, the presenter will be destroy. So the presenter should be
        // executed before super.onDestroy().
        this.presenter.destroy()
        super.onDestroy()
    }
    //endregion

    //region Initialization's order
    /**
     * Inject this fragment and [FragmentComponent].
     */
    override fun inject() {
        this.getComponent(FragmentComponent::class.java, null).inject(${NAME}@ this)
    }

    /**
     * Set this fragment xml layout.
     *
     * @return [LayoutRes] xml layout.
     */
    @LayoutRes
    override fun inflateView(): Int = R.layout.fragment

    /**
     * Set the presenter initialization.
     */
    override fun initPresenter() {
        this.presenter.init(${NAME}@ this)
    }

    /**
     * Initialization of this fragment. Set the listeners or view components' attributions.
     *
     * @param savedInstanceState the previous fragment data status after the system calls [onPause].
     */
    override fun init(savedInstanceState: Bundle?) {
    }
    //endregion
}
