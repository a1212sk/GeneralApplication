package alexander.skornyakov.generalapplication.ui.start.first

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.databinding.StartFirstFragmentBinding
import androidx.databinding.DataBindingUtil

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() =
            FirstFragment()
    }

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<StartFirstFragmentBinding>(
            inflater,
            R.layout.start_first_fragment,
            container,
            false)
        binding.goToSecondBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.newInstance())
                .commitNow()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
