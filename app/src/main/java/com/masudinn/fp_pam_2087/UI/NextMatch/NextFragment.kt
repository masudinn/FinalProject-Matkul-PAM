package com.masudinn.fp_pam_2087.UI.NextMatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.masudinn.fp_pam_2087.Adapter.TeamAdapter
import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEvent
import com.masudinn.fp_pam_2087.Model.MatchEvent.MatchEventPresenter
import com.masudinn.fp_pam_2087.R
import com.masudinn.fp_pam_2087.Server.Client
import com.masudinn.fp_pam_2087.Server.RestApi
import com.masudinn.fp_pam_2087.Utils.AppScheduleProvider
import com.masudinn.fp_pam_2087.Utils.hide
import com.masudinn.fp_pam_2087.Utils.show
import kotlinx.android.synthetic.main.fragment_next.*


class NextFragment : Fragment(), NextMatchView.View {

    private lateinit var mPresenter : NextMatchPresenter
    private var matchLists : MutableList<MatchEvent> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = Client.getClient().create(RestApi::class.java)
        val request = MatchEventPresenter(service)
        val scheduler = AppScheduleProvider()
        mPresenter = NextMatchPresenter(this, request,scheduler)
        mPresenter.getFootballUpcomingData()

    }


    override fun hideLoading() {
        mainProgressBarNext.hide()
        recyclerview_nextmatch.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBarNext.show()
        recyclerview_nextmatch.visibility = View.INVISIBLE

    }
    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerview_nextmatch.layoutManager = layoutManager
        recyclerview_nextmatch.adapter = TeamAdapter(matchList,context)
    }
}