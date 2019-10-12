package com.example.testapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        lateinit var test:String
        var test2:String? = null

        test = if (test2 == null) "" else test as String
        println(test)
    }
}