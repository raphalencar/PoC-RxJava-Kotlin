package com.br.rba.pocrxjava

import com.br.rba.pocrxjava.model.Books
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RxBooksApiService {
    @GET("v1/volumes?")
    fun getBookByName(@Query("q") bookName: String,
                      @Query("maxResults") maxResult: String,
                      @Query("printType") printType: String): Observable<Books>
}