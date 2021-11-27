import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {
    var Ilya =      User("Илья",    501.70,  false) //по умолчанию без скидок
    var Nikolay =   User("Николай", 1507.38, false) //по умолчанию скидка 100 руб
    var Olga =      User("Ольга",   20579.90,false) //по умолчанию скидка 5% от суммы
    var Valeriy =   User("Валерий", 55678.58,true)  //по умолчанию 5%, + доп 1%
    calculateTheDiscount(Ilya)
    calculateTheDiscount(Nikolay)
    calculateTheDiscount(Olga)
    calculateTheDiscount(Valeriy)
}

class User(val name: String, var purchaseAmount: Double, var regularCustomer: Boolean) {

}

fun calculateTheDiscount(ThisUser: User) {
    var discount = 0.00

    if (ThisUser.purchaseAmount >= 1001 && ThisUser.purchaseAmount <= 10000) {
        discount = 100.00
    }
    if (ThisUser.purchaseAmount >= 10001) {
        discount = (5 * ThisUser.purchaseAmount) / 100
        if (ThisUser.regularCustomer) {
            var discount1percent = 1 * (ThisUser.purchaseAmount - discount) / 100
            discount = discount + discount1percent
        }
    }

    var df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    var resultDiscount = df.format(discount)
    val charRub = '\u20BD'

    println("${ThisUser.name} Ваша сумма скидки составляет: $resultDiscount $charRub")
}

