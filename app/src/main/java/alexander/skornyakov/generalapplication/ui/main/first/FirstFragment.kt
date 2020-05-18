package alexander.skornyakov.generalapplication.ui.main.first

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.ViewModelProviderFactory
import alexander.skornyakov.generalapplication.data.model.MainFirstModel
import alexander.skornyakov.generalapplication.databinding.MainFirstFragmentBinding
import alexander.skornyakov.generalapplication.ui.main.MainActivity
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        val data = mutableListOf<MainFirstModel>()
        for(i in 0..10){
            val image = BitmapFactory.decodeResource(context?.resources,R.drawable.daisies_5091308_640)
            val item = MainFirstModel("Header $i", image,resources.getString(R.string.text))
            data.add(item)
        }
        val rvAdapter = FirstRecyclerViewAdapter(data)
        binding.rv.adapter = rvAdapter
        binding.rv.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainComponent.inject(this)
        vm = viewModelProviderFactory.create(FirstViewModel::class.java)
    }
}