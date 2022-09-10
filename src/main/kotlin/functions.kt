import kotlin.math.pow

fun numToArr(num: Int) = num.toString().toCharArray().toTypedArray().map { i -> i.digitToInt() }

fun calcbp(selected_num: Int, guess_num: Int, dig: Int = 4): List<Int> {
    val selectedArr = numToArr(selected_num)
    val guessArr = numToArr(guess_num)
    var bool = 0
    val boolArr = Array(dig) { false }
    var pgia = 0
    for (i in 0 until dig){
        if (selectedArr[i] == guessArr[i]) {
            bool++
            boolArr[i] = true
        }
    }

    for (i in 0 until dig){
        for (j in 0 until dig){
            if (selectedArr[i] == guessArr[j] && !boolArr[i] && i != j && !boolArr[j])
                pgia++
        }
    }
    return listOf(bool, pgia)
}


fun checkNum(num:Int): Boolean{
    val numArr = numToArr(num)
    for (i in numArr.indices) {
        for (j in numArr.indices) {
            if (numArr[i] == numArr[j] && i != j)
                return false
        }
    }

    return true
}

fun rndNum(dig: Int): Int{
    val max = (10.0.pow(dig) - 1).toInt()
    val min = 10.0.pow(dig - 1).toInt()
    var rnd: Int
    do 
        rnd = (min..max).random()
    while (!checkNum(rnd))
    return rnd
}

fun test(){
    println(calcbp(1234, 1572))
    println(calcbp(1234, 3214))
    println(calcbp(12345, 32145, 5))
    println(checkNum(1234))
    println(checkNum(1277))
    println(checkNum(1233))
    println(rndNum(4))

}

fun main(){
    test()
}
