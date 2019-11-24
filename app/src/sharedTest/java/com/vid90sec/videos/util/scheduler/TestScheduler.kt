package com.vid90sec.videos.util.scheduler

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
object TestScheduler:IScheduler{
    override fun io(): Scheduler = Schedulers.trampoline()

    override fun ui(): Scheduler = Schedulers.trampoline()

}