package alexander.skornyakov.generalapplication.ui.main.first

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.data.repository.IRepository
import alexander.skornyakov.generalapplication.databinding.MainFirstFragmentBinding
import alexander.skornyakov.generalapplication.ui.main.MainActivity
import alexander.skornyakov.generalapplication.ui.main.first.FirstRecyclerViewAdapter.OnItemClickListener
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.toList
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class FirstFragment : Fragment(){

    lateinit var vm: FirstViewModel
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory
    @Inject
    lateinit var repository: IRepository

    lateinit var loadDataJob: Job

    lateinit var binding: MainFirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate<MainFirstFragmentBinding>(
            inflater,
            R.layout.main_first_fragment,
            container,
            false
        )
        binding.vm = vm
        initRecyclerView(binding)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initData(binding)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
        vm = viewModelProviderFactory.create(FirstViewModel::class.java)
    }

    private fun initData(binding: MainFirstFragmentBinding){
        val items = binding.vm?.items
        items?.value?.clear()
        loadDataJob = CoroutineScope(Dispatchers.IO + Job()).launch {
            repository.getAllFirstModels()
                .flowOn(Dispatchers.IO)
                .collect {
                    items?.value?.add(it)
                    items?.postValue(items?.value)
                }
        }
    }

    private fun initRecyclerView(binding: MainFirstFragmentBinding) {
        val rvAdapter = FirstRecyclerViewAdapter()
        binding.rv.adapter = rvAdapter
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(context)
        val items = binding.vm?.items
        items?.removeObservers(viewLifecycleOwner)
        items?.observe(viewLifecycleOwner, Observer {
            rvAdapter.submitList(it.toMutableList())
        })
        rvAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                loadDataJob.cancel()
                val action =
                    FirstFragmentDirections.actionMainFirstFragmentToMainSecondFragment(position)
                findNavController().navigate(action)

            }
        })
    }

}