package com.naziksoft.testfortapmobile.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.naziksoft.testfortapmobile.adapter.MediaContentAdapter
import com.naziksoft.testfortapmobile.databinding.SearchFragmentBinding
import com.naziksoft.testfortapmobile.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private lateinit var viewBinding: SearchFragmentBinding
    private val viewModel: SearchViewModel by viewModel()
    private val adapter: MediaContentAdapter by lazy { MediaContentAdapter(viewModel) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = SearchFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            searchField.doOnTextChanged { text, start, before, count ->
                if (count > 3) {
                    viewModel.search(text.toString())
                }
            }

            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        }

        viewModel.getResultsLiveData().observe(
            viewLifecycleOwner,
            {
                adapter.setData(it)
            })
    }
}