package com.vid90sec.videos.util.scheduler

import io.reactivex.Scheduler

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
interface IScheduler{
    fun io():Scheduler

    fun ui(): Scheduler
}