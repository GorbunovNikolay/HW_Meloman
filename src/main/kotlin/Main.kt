import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {
    var Ilya =      User("Илья",    false)  //покупатель
    var Nikolay =   User("Николай", true)   //постоянный покупатель


    var priceMusic = 100.00
    calculateTheDiscount(Ilya, priceMusic)

    priceMusic = 1005.00
    calculateTheDiscount(Ilya, priceMusic)

    priceMusic = 10050.00
    calculateTheDiscount(Ilya, priceMusic)
    calculateTheDiscount(Nikolay, priceMusic)
}

class User(val name: String, var regularCustomer: Boolean) {

}

fun calculateTheDiscount(ThisUser: User, price: Double) {
    val charRub = '\u20BD'
    println("покупка - $price $charRub →")

    var discount = 0.00

    if (price >= 1001 && price <= 10000) {
        discount = 100.00
    }

    if (price >= 10001) {
        discount = (5 * price) / 100
        var discount5percent = discount

        println("после применения 5% скидки - " + (price - discount5percent))

        if (ThisUser.regularCustomer) {
            var discount1percent = 1 * (price - discount) / 100
            discount = price - (discount + discount1percent)
            println("после применения 1% скидки - $discount")
        }
    }


    var df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    var resultDiscount = df.format(discount)
    
    println("${ThisUser.name} Ваша сумма скидки составляет: $resultDiscount $charRub" + "\n")
}

