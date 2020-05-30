package alexander.skornyakov.generalapplication.ui.main.second

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.ViewModelProviderFactory
import alexander.skornyakov.generalapplication.databinding.MainSecondFragmentBinding
import alexander.skornyakov.generalapplication.ui.main.MainActivity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import javax.inject.Inject

class SecondFragment : Fragment(){

    lateinit var vm : SecondViewModel
    @Inject lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MainSecondFragmentBinding>(
            inflater,
            R.layout.main_second_fragment,
            container,
            false)
        binding.vm = vm
        vm.chapter.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.textView2.text = it.toString()
            }
        })
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
        vm = viewModelProviderFactory.create(SecondViewModel::class.java)
        val chapter = arguments?.get("chapterNumber") as Int
        vm.setChapter(chapter)
    }
}