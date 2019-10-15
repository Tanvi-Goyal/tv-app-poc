package com.embibe.app.embibetvapp.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.FragmentActivity
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.model.ObjectBox
import com.embibe.app.embibetvapp.model.Videos
import com.embibe.app.embibetvapp.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.objectbox.Box
import io.objectbox.BoxStore
import org.json.JSONObject


class SplashActivity : FragmentActivity() {

    companion object {
        var SPLASH_DISPLAY_LENGTH: Long = 2000
        lateinit var videoBox: Box<Videos>
        lateinit var boxStore: BoxStore
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        boxStore = ObjectBox.init(App.context)
        videoBox = boxStore.boxFor(Videos::class.java)
        if (videoBox.all.size == 0) {
            val obj = JSONObject(Utils.readJSONFromAsset())
            val jsonArray = obj.getJSONArray("data")
            val dataList = Gson().fromJson<List<Videos>>(
                jsonArray.toString(),
                object : TypeToken<List<Videos>>() {}.type
            )

            val alteredList: ArrayList<Videos> = arrayListOf()

            for (video in dataList) {
                for (item in video.contentList!!) {
                    //item.snippetDetail.target = item.snippetDummy
                    //item.snippetDummy = null
                    item.title = item.snippet.title
                    item.contentDescription = item.snippet.description

                    if (item.anotations != null && item.anotations!!.size > 0) {
                        for (anotation in item.anotations!!) {
                            if (anotation.questions != null && anotation.questions!!.size > 0) {
                                anotation.questionList.addAll(anotation.questions!!)
                                anotation.questions = null
                            }
                        }
                        item.anotationList.addAll(item.anotations!!)
                        item.anotations = null
                    } else
                        item.anotationEnabled = false
                }
                if (video.contentList != null && video.contentList!!.size > 0) {
                    video.contents.addAll(video.contentList!!)
                }


                video.contentList = null
                alteredList.add(video)
            }
            videoBox.put(alteredList)
        }

        Handler().postDelayed(Runnable {
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this@SplashActivity, DashBoardActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}
