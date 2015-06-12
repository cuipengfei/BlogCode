package observerS

import observerS.Observers.Observer

import scala.collection.mutable

case class WeatherData(var temperature: Float, var humidity: Float, var pressure: Float) {
  var observers: Seq[Observer] = Nil

  def register(observer: Observer) =
    observers = observer +: observers

  def weatherChanged(weatherData: WeatherData) =
    observers.foreach(observer => observer(weatherData))
}

object Observers {
  type Observer = WeatherData => Unit

  val currentConditionsDisplay: Observer = weatherData =>
    println(s"Current conditions: ${weatherData.temperature} " +
      s"F degrees and ${weatherData.humidity} % humidity")

  def statisticsDisplay(historyWeathers: mutable.Seq[WeatherData] = mutable.Seq()): Observer = weatherData => {
    weatherData +: historyWeathers

    println(s"Avg/Max/Min temperature = ${historyWeathers.maxBy(_.temperature)}" +
      s"/${historyWeathers.minBy(_.temperature)}" +
      s"/${historyWeathers.map(_.temperature).sum / historyWeathers.size}")
  }
}