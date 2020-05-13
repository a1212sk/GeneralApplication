package alexander.skornyakov.generalapplication.ui.start.first

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.databinding.StartSecondFragmentBinding
import androidx.databinding.DataBindingUtil

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() =
            SecondFragment()
    }

    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<StartSecondFragmentBinding>(
            inflater,
            R.layout.start_second_fragment,
            container,
            false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SecondViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
