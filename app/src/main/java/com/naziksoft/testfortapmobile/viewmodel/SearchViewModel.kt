package com.naziksoft.testfortapmobile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naziksoft.testfortapmobile.entity.MediaContent
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException

class SearchViewModel : ViewModel() {

    private val baseUrl = "https://www.youtube.com/results?search_query="

    private val errorLiveData: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    private val showResultLiveData: MutableLiveData<List<MediaContent>> by lazy { MutableLiveData<List<MediaContent>>() }

    fun getErrorLiveData(): LiveData<String> = errorLiveData
    fun getResultsLiveData(): LiveData<List<MediaContent>> = showResultLiveData

    fun search(query: String) {
        Thread(Runnable {
            try {
                val doc: Document = Jsoup.connect(baseUrl + query).get()
                showResultLiveData.postValue(parse(doc))
            } catch (e: IOException) {
                errorLiveData.postValue(e.message)
            }
        }).start()
    }

    fun onItemClicked(song: MediaContent) {
        // todo navigate to player
    }

    private fun parse(doc: Document): List<MediaContent> {
        // return test data
        return listOf(
            MediaContent(
                "MediaContent(https://i.ytimg.com/vi/C19SE_bDcYQ/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDvE3-nh-GlU-AXkPAoPtlqxre1AA, \"https://www.youtube.com//watch?v=C19SE_bDcYQ\")\n",
                "https://www.youtube.com//watch?v=C19SE_bDcYQ"
            ),
            MediaContent(
                "MediaContent(https://i.ytimg.com/vi/C19SE_bDcYQ/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDvE3-nh-GlU-AXkPAoPtlqxre1AA, \"https://www.youtube.com//watch?v=C19SE_bDcYQ\")\n",
                "https://www.youtube.com//watch?v=C19SE_bDcYQ"
            ),
            MediaContent(
                "MediaContent(https://i.ytimg.com/vi/C19SE_bDcYQ/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDvE3-nh-GlU-AXkPAoPtlqxre1AA, \"https://www.youtube.com//watch?v=C19SE_bDcYQ\")\n",
                "https://www.youtube.com//watch?v=C19SE_bDcYQ"
            ),
            MediaContent(
                "MediaContent(https://i.ytimg.com/vi/C19SE_bDcYQ/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDvE3-nh-GlU-AXkPAoPtlqxre1AA, \"https://www.youtube.com//watch?v=C19SE_bDcYQ\")\n",
                "https://www.youtube.com//watch?v=C19SE_bDcYQ"
            ),
            MediaContent(
                "MediaContent(https://i.ytimg.com/vi/C19SE_bDcYQ/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDvE3-nh-GlU-AXkPAoPtlqxre1AA, \"https://www.youtube.com//watch?v=C19SE_bDcYQ\")\n",
                "https://www.youtube.com//watch?v=C19SE_bDcYQ"
            ),
            MediaContent(
                "MediaContent(https://i.ytimg.com/vi/C19SE_bDcYQ/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDvE3-nh-GlU-AXkPAoPtlqxre1AA, \"https://www.youtube.com//watch?v=C19SE_bDcYQ\")\n",
                "https://www.youtube.com//watch?v=C19SE_bDcYQ"
            )
        )
    }

}