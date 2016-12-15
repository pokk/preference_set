#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}
import android.view.View
import dagger.internal.Preconditions
import rx.Observable
#end
#parse("File Header.java")
class ${NAME}: BaseFragment(), ${Contract_name}Contract.View {
    companion object Factory {
        // The key name of the fragment initialization parameters.
        @JvmStatic private val ARG_PARAM_: String = "param_"

        /**
         * Use this factory method to create a new instance of this fragment using the provided parameters.
         *
         * @return A new instance of [fragment] ${NAME}.
         */
        @JvmStatic fun newInstance(arg1: String): ${NAME} {
            val fragment: ${NAME} = ${NAME}()
            val bundle: Bundle = Bundle()
            bundle.putString(ARG_PARAM_, arg1)
            fragment.arguments = bundle

            return fragment
        }
    }
    
    @Inject
    lateinit var presenter: ${Contract_name}Contract.Presenter
    
    // The fragment initialization parameters.
    private var arg1: String? = null
    
    //region Fragment lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the arguments from the bundle here.
        if (null != arguments) {
            this.arg1 = arguments.getString(${NAME}.ARG_PARAM_)
        }
    }
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Avoid that an activity is deleted and get null pointer so inject the component here.
        this.getComponent(UseCaseComponent::class.java, null).inject(${NAME}@ this)
        // Keep the instance data.
        this.retainInstance = true

        // FIXED: https://www.zybuluo.com/kimo/note/255244
        if (null == rootView)
            rootView = inflater.inflate(R.layout.fragment_about, null)
        val parent: ViewGroup? = rootView?.parent as ViewGroup?
        parent?.removeView(rootView)

        this.presenter.setView(${NAME}@ this)
        this.presenter.init()

        return rootView
    }
    
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
    
    /**
     * Initialize the fragment of listeners, pictures, ...etc.
     */
    override fun init() {
    }

    //region Presenter implements
    override fun showLoading() { }

    override fun hideLoading() { }

    override fun showRetry() { }

    override fun hideRetry() { }

    override fun showError(message: String) {
        Preconditions.checkNotNull(message)
    }

    override fun context(): Context = this.activity.applicationContext

    override fun fragmentLifecycle(): Observable<FragmentEvent> = this.lifecycle()
    //endregion
}