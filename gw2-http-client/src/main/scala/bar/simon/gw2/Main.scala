package bar.simon.gw2

import cats.effect.{ExitCode, IO, IOApp}
import bar.simon.gw2.utils.CollectionOps.SeqOps

import scala.concurrent.duration.Duration

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    val timeout = Duration("2 s")
    val gw2     = Gw2HttpClient.create[IO]("en", timeout)

    for {
      allAchievementIds <- gw2.achievements.getAllAchievementIds
      achievement <- gw2.achievements.getAchievement(allAchievementIds.getRandom())
      allPricesItemIds <- gw2.commerce.getItemIdsFromPrices
      prices <- gw2.commerce.getPrices(allPricesItemIds.getRandom())
      allListingsItemIds <- gw2.commerce.getItemIdsFromListings
      listings <- gw2.commerce.getListings(allListingsItemIds.getRandom())
    } yield {
      println(achievement)
      println(prices)
      println(listings)
      ExitCode.Success
    }
  }
}
