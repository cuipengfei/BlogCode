package templatemethodS

object Beverages {
  type Brew = () => Unit
  type AddCondiments = () => Unit
  type CaffeineBeverage = () => Unit

  def caffeineBeverageWith(brew: Brew, addCondiments: AddCondiments)
  : CaffeineBeverage = () => {
    boilWater()
    brew()
    pourInCup()
    addCondiments()
  }

  val brewCoffee: Brew = () => println("Dripping Coffee through filter")
  val addMilkSugar: AddCondiments = () => println("Adding Sugar and Milk")
  val brewTea: Brew = () => println("Steeping the tea")
  val addLemon: AddCondiments = () => println("Adding Lemon")

  private def boilWater() = println("Boiling water")

  private def pourInCup() = println("Pouring into cup")

  def main(args: Array[String]) {
    val coffee: CaffeineBeverage = caffeineBeverageWith(brewCoffee, addMilkSugar)
    val tea: CaffeineBeverage = caffeineBeverageWith(brewTea, addLemon)
    coffee()
    tea()
  }
}
