package com.masudinn.fp_pam_2087.Utils

import io.reactivex.Scheduler

interface ScheduleProviderView {
    fun ui(): Scheduler
    fun io(): Scheduler
}