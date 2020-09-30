package com.example.stackoverflow.interfaces

import com.example.stackoverflow.BuildConfig
import com.example.stackoverflow.model.Order
import com.example.stackoverflow.model.QuestionResponse
import com.example.stackoverflow.model.Sort
import com.example.stackoverflow.network.Endpoints.GET_ALL_QUESTIONS
import com.example.stackoverflow.network.Endpoints.MIN_ANSWER_COUNT
import com.example.stackoverflow.network.Endpoints.SHOULD_HAVE_ACCEPTED
import com.example.stackoverflow.network.Endpoints.SITE
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface APIInterface {

    @GET(GET_ALL_QUESTIONS)
    fun getAllQuestions(
        @Query("order") order: String = Order.DESC.name.toLowerCase(Locale.getDefault()),
        @Query("sort") sort: String = Sort.ACTIVITY.name.toLowerCase(Locale.getDefault()),
        @Query("accepted") accepted: Boolean = SHOULD_HAVE_ACCEPTED,
        @Query("answers") answers: Int = MIN_ANSWER_COUNT,
        @Query("site") site: String = SITE,
        @Query("filter") filter: String = BuildConfig.API_KEY
    ): Observable<QuestionResponse>

}