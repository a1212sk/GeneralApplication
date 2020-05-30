package alexander.skornyakov.generalapplication.ui.main.first

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.ViewModelProviderFactory
import alexander.skornyakov.generalapplication.data.model.MainFirstModel
import alexander.skornyakov.generalapplication.databinding.MainFirstFragmentBinding
import alexander.skornyakov.generalapplication.ui.main.MainActivity
import alexander.skornyakov.generalapplication.ui.main.first.FirstRecyclerViewAdapter.OnItemClickListener
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_first_fragment.*
import javax.inject.Inject

class FirstFragment : Fragment(){

    lateinit var vm : FirstViewModel
    @Inject lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<MainFirstFragmentBinding>(
            inflater,
            R.layout.main_first_fragment,
            container,
            false)
        binding.vm = vm
        initData(binding)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
        vm = viewModelProviderFactory.create(FirstViewModel::class.java)
    }

    fun initData(binding: MainFirstFragmentBinding){
        binding.vm?.items?.observe(viewLifecycleOwner, Observer {
            initRecyclerView(binding)
        })
        val data = mutableListOf<MainFirstModel>()
        for(i in 0..10){
            val image = BitmapFactory.decodeResource(context?.resources,R.drawable.daisies_5091308_640)
            val item = MainFirstModel("Header $i", image,resources.getString(R.string.text))
            data.add(item)
        }
        binding.vm?.items?.postValue(data)
    }

    private fun initRecyclerView(binding: MainFirstFragmentBinding){
        val data = binding.vm?.items?.value!!
        val rvAdapter = FirstRecyclerViewAdapter(data)
        binding.rv.adapter = rvAdapter
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(context)
        rvAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Log.d("FirstFragment","clicked "+position)
                val action = FirstFragmentDirections.actionMainFirstFragmentToMainSecondFragment(position)
                findNavController().navigate(action)
            }
        })
    }
}