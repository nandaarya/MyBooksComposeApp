package com.example.mybookscomposeapp.data

class Repository {

//    private val orderRewards = mutableListOf<Book>()
//
//    init {
//        if (orderRewards.isEmpty()) {
//            FakeRewardDataSource.dummyRewards.forEach {
//                orderRewards.add(OrderReward(it, 0))
//            }
//        }
//    }

    fun getBooks(): List<Book> {
        return BookData.books
    }

    fun searchBooks(query: String): List<Book>{
        return BookData.books.filter {
            it.bookTitle.contains(query, ignoreCase = true)
        }
    }

    fun getBookById(bookId: Long): Book {
        return BookData.books.first {
            it.id == bookId
        }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(): Repository =
            instance ?: synchronized(this) {
                Repository().apply {
                    instance = this
                }
            }
    }
}