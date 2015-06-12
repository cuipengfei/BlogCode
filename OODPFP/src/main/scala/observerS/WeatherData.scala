package observerS

import observerS.Observers.Observer

import scala.collection.mutable

case class WeatherData(temperature: Float, humidity: Float, pressure: Float) {
  var observers: Seq[Observer] = Nil

  def register(observer: Observer) =
    observers = observers :+ observer

  def weatherChanged(weatherData: WeatherData) =
    observers.foreach(observer => observer(weatherData))
}

object Observers {
  type Observer = WeatherData => Unit

  val currentConditionsDisplay: Observer = weatherData =>
    println(s"Current conditions: " +
      s"${weatherData.temperature} F degrees and " +
      s"${weatherData.humidity} % humidity")

  def statisticsDisplay(history: mutable.Buffer[WeatherData] = mutable.Buffer()): Observer =
    weatherData => {
      history += weatherData
      println(s"Avg/Max/Min temperature = " +
        s"${history.maxBy(_.temperature).temperature}" +
        s"/${history.minBy(_.temperature).temperature}" +
        s"/${history.map(_.temperature).sum / history.size}")
    }

  def forecastDisplay(history: mutable.Buffer[WeatherData] = mutable.Buffer(WeatherData(29.92f, 0, 0))): Observer =
    weatherData => {
      history += weatherData

      val currentPressure = history.last.temperature
      val lastPressure = history(history.size - 2).temperature

      print("Forecast: ")
      if (currentPressure > lastPressure) println("Improving weather on the way!")
      else if (currentPressure == lastPressure) println("More of the same")
      else if (currentPressure < lastPressure) println("Watch out for cooler, rainy weather")
    }

  def main(args: Array[String]) {
    val weatherData = new WeatherData(0, 0, 0)

    weatherData.register(currentConditionsDisplay)
    weatherData.register(statisticsDisplay())
    weatherData.register(forecastDisplay())

    weatherData.weatherChanged(WeatherData(80, 65, 30.4f))
    weatherData.weatherChanged(WeatherData(82, 70, 29.2f))
    weatherData.weatherChanged(WeatherData(78, 90, 29.2f))
  }
}