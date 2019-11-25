package com.vid90sec.videos.data.source.youtube.api

import com.vid90sec.videos.data.source.youtube.model.YouTubePlayList
import io.reactivex.Observable
import java.lang.Exception


/**
 * Created by Mudassar Hussain on 11/25/2019.
 */
class MockYouTubeVideoApi(val youTubePlayList: YouTubePlayList?):YouTubeVideoApi{
    override fun loadYouTubePlayList(part:String, maxResult:Int,playlistId:String, key:String):
            Observable<YouTubePlayList> {
        return if(youTubePlayList == null){
            var mockException = Exception("Mock exception!!")
            return Observable.error(mockException)
        }else{
            Observable.just(youTubePlayList)
        }
    }

}