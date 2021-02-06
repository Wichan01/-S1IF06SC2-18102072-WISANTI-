package com.wisanti_18102072.praktikum14.ui.globalquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.wisanti_18102072.praktikum14.CoroutineContextProvider
import com.wisanti_18102072.praktikum14.R
import com.wisanti_18102072.praktikum14.TokenPref
import com.wisanti_18102072.praktikum14.`interface`.MainView
import com.wisanti_18102072.praktikum14.adapter.QuoteAdapter
import com.wisanti_18102072.praktikum14.api.MainPresenter
import com.wisanti_18102072.praktikum14.databinding.FragmentGlobalQuotesBinding
import com.wisanti_18102072.praktikum14.model.Login
import com.wisanti_18102072.praktikum14.model.Quote
import com.wisanti_18102072.praktikum14.model.Token
import kotlinx.android.synthetic.main.fragment_global_quotes.*
import org.jetbrains.anko.support.v4.onRefresh

class GlobalQuotesFragment : Fragment(), MainView {
    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: QuoteAdapter
    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
        Bundle?
    ): View? = inflater.inflate(R.layout.fragment_global_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGlobalQuotesBinding.bind(view)
        binding.recyclerviewGlobalQuotes.layoutManager = LinearLayoutManager(activity)
        tokenPref = TokenPref(requireActivity())
        token = tokenPref.getToken()
        adapter = QuoteAdapter(requireActivity())
        binding.recyclerviewGlobalQuotes.adapter = adapter
        presenter = MainPresenter(this, CoroutineContextProvider())
        progressbar.visibility = View.VISIBLE
        presenter.getAllQuotes(token.token)
        swiperefresh.onRefresh {
            progressbar.visibility = View.INVISIBLE
            presenter.getAllQuotes(token.token)
        }
    }
    override fun onResume() {
        super.onResume()
        presenter.getAllQuotes(token.token)
    }
    override fun showMessage(messsage: String) {
        Toast.makeText(requireActivity(),messsage, Toast.LENGTH_SHORT).show()
    }
    override fun resultQuote(data: ArrayList<Quote>) {
        quotes.clear()
        adapter.listQuotes = data
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        progressbar.visibility = View.INVISIBLE
        swiperefresh.isRefreshing = false
    }
    override fun resultLogin(data: Login) {
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is myquotes Fragment"
    }
    val text: LiveData<String> = _text
}