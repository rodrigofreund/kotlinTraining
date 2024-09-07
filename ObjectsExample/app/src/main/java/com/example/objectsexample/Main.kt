package com.example.objectsexample

data class Item(
    val code: String,
    val name: String,
    val description: String,
    val price: Double
)

class OrderItem (
    private val item: Item,
    private var quantity: Int = 1,
    private var discount: Double = 0.0,
    private var tax: Double = 0.0,
) {
    private var finalPrice : Double = item.price

    init {
        finalPrice = item.price * quantity
    }

    fun setQuantity(quantity: Int) {
        this.quantity = quantity;
        updateFinalPrice()
    }

    fun setDiscount(value: Double) {
        this.discount = value;
        updateFinalPrice()
    }

    private fun updateFinalPrice() {
        val discountValue = item.price * discount
        val taxValue = item.price * tax
        this.finalPrice = (item.price + taxValue - discountValue) * quantity
    }

    override fun toString(): String {
        return "$item"
    }
}

fun main() {

    val item1 : Item = Item("1221", "Banana", "Banana Caturra", 0.45)

    val orderItem = OrderItem(item1)
    orderItem.setQuantity(10)

}