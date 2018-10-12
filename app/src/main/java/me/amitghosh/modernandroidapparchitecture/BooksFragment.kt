package me.amitghosh.modernandroidapparchitecture

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.amitghosh.modernandroidapparchitecture.utilities.InjectorUtils
import me.amitghosh.modernandroidapparchitecture.viewModels.BooksViewModel
import me.amitghosh.modernandroidapparchitecture.databinding.BooksFragmentBinding

class BooksFragment : Fragment() {

    companion object {
        fun newInstance() = BooksFragment()
    }

    private lateinit var viewModel: BooksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val binding = BooksFragmentBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = InjectorUtils.provideBooksViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(BooksViewModel::class.java)

        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
