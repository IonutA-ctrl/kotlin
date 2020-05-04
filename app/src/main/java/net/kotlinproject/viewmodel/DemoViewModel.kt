package net.kotlinproject.viewmodel

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.IllegalArgumentException

class DemoViewModel {
    private val RESULT_1 = "Coroutines 1"
    private val RESULT_2 = "Coroutines 2"
    private val WAITTEXT = "loading.."
    val text_result = ObservableField("")
    val theExpression = ObservableField("")
    val theResult = ObservableField("")
    //calculator_fragment


    fun addToExpression1(){
        evaluateExpression("1")
    }
    fun addToExpression2(){
        evaluateExpression("2")
    }
    fun addToExpression3(){
        evaluateExpression("3")
    }
    fun addToExpression4(){
        evaluateExpression("4")
    }
    fun addToExpression5(){
        evaluateExpression("5")
    }
    fun addToExpression6(){
        evaluateExpression("6")
    }
    fun addToExpression7(){
        evaluateExpression("7")
    }
    fun addToExpression8(){
        evaluateExpression("8")
    }
    fun addToExpression9(){
        evaluateExpression("9")
    }
    fun addToExpression0(){
        evaluateExpression("0")
    }
    fun addToExpressionPlus(){
        evaluateExpression("+")
    }
    fun addToExpressionMinus(){
        evaluateExpression("-")
    }
    fun addToExpressionMultiply(){
        evaluateExpression("*")
    }
    fun addToExpressionDivide(){
        evaluateExpression("/")
    }
    fun addToExpressionDot(){
        evaluateExpression(".")
    }
    fun addToExpressionClear(){
        theExpression.set("")
        theResult.set("")
    }
    fun addToExpressionEquals(){
        var text = theResult.get().toString()
        theExpression.set(text)
        theResult.set(text)
    }
    fun addToExpressionBack(){
        var text = theExpression.get().toString()
        if(text.isNotEmpty()){
            text = text.substring(0,text.length-1)
            theExpression.set(text)
            calculateExpression()
        }
    }
    fun evaluateExpression(string: String) {
        var sc = theExpression.get()
        theExpression.set(sc+string)
        calculateExpression()
    }
    fun calculateExpression(){
        var text = theExpression.get().toString()
        if(text.isNotEmpty()){
            try{
                val expression = ExpressionBuilder(text).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    theResult.set(longResult.toString())
                } else {
                    theResult.set(result.toString())
                }
            } catch (e:IllegalArgumentException){
                e.printStackTrace()
            }
        }
    }



    //fragment_settings
    fun clearButtonClicked() {
        text_result.set("Cleared!")
    }
    fun coroutinesButtonClicked(){
        CoroutineScope(Dispatchers.IO).launch {
            fakeApiRequest()
        }
    }
    private fun setNewText(input: String){
        val newText = "" +"\n$input"
        text_result.set(newText)
    }
    private suspend fun setTextOnMainThread(input: String) {
        withContext (Dispatchers.Main) {
            setNewText(input)
        }
    }

    suspend fun fakeApiRequest() {
        logThread("fakeApiRequest")
        val result1 = getResult1FromApi() // wait until job is done
        if ( result1.equals(RESULT_1)) {
            setTextOnMainThread(RESULT_1)
            val result3 = getResult3FromApi() // wait until job is done
            if (result3.equals(WAITTEXT)) {
                setTextOnMainThread(WAITTEXT)
                val result2 = getResult2FromApi() // wait until job is done
                if (result2.equals(RESULT_2)) {
                    setTextOnMainThread(RESULT_2)
                } else {
                    setTextOnMainThread("Couldn't get coroutines 2")
                }
            } else {
                setTextOnMainThread("Couldn't get loading sentence")
            }
        } else {
            setTextOnMainThread("Couldn't get Coroutines 1")
        }
    }


    private suspend fun getResult1FromApi(): String {
        logThread("getResult1FromApi")
        delay(1000) // Does not block thread. Just suspends the coroutine inside the thread
        return RESULT_1
    }

    private suspend fun getResult2FromApi(): String {
        logThread("getResult2FromApi")
        delay(2000)
        return RESULT_2
    }
    private suspend fun getResult3FromApi(): String {
        logThread("getResult3FromApi")
        delay(2000)
        return WAITTEXT
    }
    private fun logThread(methodName: String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }
}