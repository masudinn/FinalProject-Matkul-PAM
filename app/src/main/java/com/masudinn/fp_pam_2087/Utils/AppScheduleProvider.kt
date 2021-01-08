package com.masudinn.fp_pam_2087.Utils

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppScheduleProvider : ScheduleProviderView {
    override fun ui() = AndroidSchedulers.mainThread()
    override fun io() = Schedulers.io()
}

class TrampolineScheduleProvider : ScheduleProviderView {
    override fun ui() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}