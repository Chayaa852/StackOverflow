package com.example.stackoverflow.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflow.R
import com.example.stackoverflow.adapter.QuestionRecyclerViewAdapter
import com.example.stackoverflow.databinding.FragmentHomeBinding
import com.example.stackoverflow.interfaces.OnItemSelectedListener
import com.example.stackoverflow.model.QuestionResponseItem
import com.example.stackoverflow.utils.showToast

class HomeFragment : Fragment(), OnItemSelectedListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var questionRecyclerViewAdapter: QuestionRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        fragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        fragmentHomeBinding.lifecycleOwner = this
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    override fun onResume() {
        super.onResume()
        fetchQuestions()
    }

    private fun fetchQuestions() {
        homeViewModel.fetchQuestions()
    }

    private fun initViews() {
        questionRecyclerViewAdapter = QuestionRecyclerViewAdapter(this)
        fragmentHomeBinding.rvQuestions.adapter = questionRecyclerViewAdapter
    }

    private fun initObservers() {
        homeViewModel.questionsMutableLiveData.observe(requireActivity(), {
            questionRecyclerViewAdapter.setData(it)
        })

        homeViewModel.error.observe(requireActivity(), {
            requireContext().showToast("An error occurred. Please retry.")
        })

        homeViewModel.isLoadingMutableLiveData.observe(requireActivity(), {
            if (it) {
                fragmentHomeBinding.pb1.visibility = View.VISIBLE
            } else {
                fragmentHomeBinding.pb1.visibility = View.GONE
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        homeViewModel.mCompositeDisposable.dispose()
    }

    override fun clickAction(item: Any) {
        if (item is QuestionResponseItem) {
            homeViewModel.questionMutableLiveData.postValue(item)
        }
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}