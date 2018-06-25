package com.br.rba.pocrxjava

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun searchBooks(view: View) {
        val queryString = bookInput!!.text.toString()

        // Hide the keyboard when the button is pushed
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS)

        // Check the status of the network connection
        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected && queryString.isNotEmpty()) {
            authorText!!.text = ""
            titleText!!.setText(R.string.no_search_term)
            makeRxCall(queryString)
        } else {
            authorText!!.text = ""
            titleText!!.setText(R.string.no_network)
        }
    }

    private fun makeRxCall(queryString: String) {
        val observable = apiService().getBookByName(queryString, "2", "books")
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { books ->
                            titleText.text = books.items?.get(0)?.volumeInfo?.title ?: "No Data"
                            authorText.text = books.items?.get(0)?.volumeInfo!!.authors?.get(0) ?: "No author"
                        },
                        { error ->
                            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                        }
                )
    }

    private fun apiService() = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RxBooksApiService::class.java)
}

