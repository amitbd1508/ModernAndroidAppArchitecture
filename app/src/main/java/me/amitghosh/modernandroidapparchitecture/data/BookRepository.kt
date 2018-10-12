package me.amitghosh.modernandroidapparchitecture.data

class BookRepository private constructor(private val bookDao: BookDao) {

    fun getPlants() = bookDao.getBooks()

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: BookRepository? = null

        fun getInstance(bookDao: BookDao) =
                instance ?: synchronized(this) {
                    instance ?: BookRepository(bookDao).also { instance = it }
                }
    }
}
