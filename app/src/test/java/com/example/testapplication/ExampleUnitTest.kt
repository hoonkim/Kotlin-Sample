package com.example.testapplication

import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test() {
        val numArray: IntArray = intArrayOf(-1, 0, 1, 2, -1, -4)
        val numList: MutableList<List<Int>> = mutableListOf()
        numArray.take(numArray.size - 2).forEachIndexed { index1, num1 ->
            numArray.slice(index1 + 1 until numArray.size - 1).forEachIndexed { index2 , num2->
                numArray.slice(index1 + index2 + 2 until numArray.size).forEach { num3 ->
                    if (num1 + num2 + num3 == 0) {
                        numList.add(listOf(num1, num2, num3))
                    }
                }
            }
        }

        println(numList)
    }


}

