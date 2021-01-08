package com.masudinn.fp_pam_2087.UI.LastMatch

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
import kotlinx.android.synthetic.main.fragment_last_match.*

class LastMatchFragment : Fragment() , LastMatchView.View
{
    private lateinit var mPresenter: LastMatchPresenter

    private var matchLists: MutableList<MatchEvent> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_last_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = Client.getClient().create(RestApi::class.java)
        val request = MatchEventPresenter(service)
        val schedulerProvider = AppScheduleProvider()
        mPresenter = LastMatchPresenter(this, request, schedulerProvider)
        mPresenter.getFootballData()

    }

    override fun hideLoading() {
        mainProgressBarLast.hide()
        recyclerview_lastmatch.visibility = View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBarLast.show()
        recyclerview_lastmatch.visibility = View.INVISIBLE
    }

    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerview_lastmatch.layoutManager = layoutManager
        recyclerview_lastmatch.adapter = TeamAdapter(matchList, context)
    }

}