package me.amitghosh.modernandroidapparchitecture.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import me.amitghosh.modernandroidapparchitecture.data.AppDatabase
import me.amitghosh.modernandroidapparchitecture.data.Book

class SeedDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }

    override fun doWork(): Worker.Result {
        val bookType = object : TypeToken<List<Book>>() {}.type
        var jsonReader: JsonReader? = null

        return try {
            val inputStream = applicationContext.assets.open("book.json")
            jsonReader = JsonReader(inputStream.reader())
            val books: List<Book> = Gson().fromJson(jsonReader, bookType)
            val database = AppDatabase.getInstance(applicationContext)
            database.bookDao().insertAll(books)
            Worker.Result.SUCCESS
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Worker.Result.FAILURE
        } finally {
            jsonReader?.close()
        }
    }
}
