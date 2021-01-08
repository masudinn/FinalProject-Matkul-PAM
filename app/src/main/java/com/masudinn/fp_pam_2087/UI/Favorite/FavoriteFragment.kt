package com.masudinn.fp_pam_2087.UI.Favorite

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
import com.masudinn.fp_pam_2087.Repo.RepositoryPresenter
import com.masudinn.fp_pam_2087.Server.Client
import com.masudinn.fp_pam_2087.Server.RestApi
import com.masudinn.fp_pam_2087.Utils.AppScheduleProvider
import com.masudinn.fp_pam_2087.Utils.hide
import com.masudinn.fp_pam_2087.Utils.show
import kotlinx.android.synthetic.main.fragment_favorite.*


class FavoriteFragment : Fragment(), FavoriteMatchView.View {

    private var matchLists: MutableList<MatchEvent> = mutableListOf()
    private lateinit var mPresenter: FavoriteMatchPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun hideLoading() {
        mainProgressBarFav.hide()
        recyclerview_fav.visibility=View.VISIBLE
    }

    override fun showLoading() {
        mainProgressBarFav.show()
        recyclerview_fav.visibility=View.INVISIBLE
    }



    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerview_fav.layoutManager = layoutManager
        recyclerview_fav.adapter = TeamAdapter(matchList, context)    }

    override fun hideSwipeRefresh() {
        swipe_refresh_layout_fav.isRefreshing = false
        mainProgressBarFav.hide()
        recyclerview_fav.visibility = View.VISIBLE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val service = Client.getClient().create(RestApi::class.java)
        val request = MatchEventPresenter(service)
        val repository = RepositoryPresenter(context!!)
        val appSchedulerProvider= AppScheduleProvider()
        mPresenter = FavoriteMatchPresenter(this, request, repository, appSchedulerProvider)
        mPresenter.getFootballMatchData()
//        swipe_refresh_layout_fav.onRefresh {
//            mPresenter.getFootballMatchData()
//        }
    }
}