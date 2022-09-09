fun main() {
    print("insert number dig: ")
    val dig = readLine()?.toInt()
    val rnd = rndNum(dig!!)
    println("The computer chooses a number, try to guess it")
    println("  num      bool  pgia")
    var num: Int
    var bpArr: List<Int>
    do{
        do {
            print("  ")
            num = readLine()?.toInt()!!
        }
        while (!checkNum(num) || num.toString().length != dig)
        bpArr = calcbp(num, rnd, dig)
        println("           ${bpArr[0]}     ${bpArr[1]}")
    }
    while (bpArr[0] != dig)
}