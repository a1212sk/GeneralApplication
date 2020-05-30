package alexander.skornyakov.generalapplication.ui.main.second

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.ViewModelProviderFactory
import alexander.skornyakov.generalapplication.data.model.MainFirstModel
import alexander.skornyakov.generalapplication.data.model.MainSecondModel
import alexander.skornyakov.generalapplication.databinding.MainFirstFragmentBinding
import alexander.skornyakov.generalapplication.databinding.MainSecondFragmentBinding
import alexander.skornyakov.generalapplication.ui.main.MainActivity
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
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
        initData(binding)
        vm.chapter.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.textView.text = it.toString()
            }
        })
        return binding.root
    }

    fun initData(binding: MainSecondFragmentBinding){
        binding.vm?.items?.observe(viewLifecycleOwner, Observer {
            initRecyclerView(binding)
        })
        val data = mutableListOf<MainSecondModel>()
        for(i in 0..10){
            val image = BitmapFactory.decodeResource(context?.resources,R.drawable.daisies_5091308_640)
            val item = MainSecondModel("Header $i", image,resources.getString(R.string.text))
            data.add(item)
        }
        binding.vm?.items?.postValue(data)
    }

    private fun initRecyclerView(binding: MainSecondFragmentBinding){
        val data = binding.vm?.items?.value!!
        val rvAdapter = SecondRecyclerViewAdapter(data)
        binding.rv.adapter = rvAdapter
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(context)
        rvAdapter.setOnItemClickListener(object : SecondRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {

            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
        vm = viewModelProviderFactory.create(SecondViewModel::class.java)
        val chapter = arguments?.get("chapterNumber") as Int
        vm.setChapter(chapter)
    }
}