package com.vid90sec.videos.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Created by Mudassar Hussain on 11/24/2019.
 */
object LiveDataUtil{
    fun <T> getValue(liveData: LiveData<T>):T{
        val data = arrayOfNulls<Any>(1)

        val latch = CountDownLatch(1)

        val observer = object : Observer<T> {
            override fun onChanged(t: T) {
                data[0] = t
                latch.countDown()
                liveData.removeObserver(this)
            }
        }

        liveData.observeForever(observer)
        latch.await(2, TimeUnit.SECONDS)

        return data[0] as T
    }
}