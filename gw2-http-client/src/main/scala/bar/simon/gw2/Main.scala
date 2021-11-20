package bar.simon.gw2

import cats.effect.{ExitCode, IO, IOApp}

import scala.concurrent.duration.Duration
import scala.util.Random

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    val timeout = Duration("2 s")
    val gw2     = Gw2HttpClient.create[IO]("en", timeout)

    for {
      allAchievementIds <- gw2.achievements.getAllAchievementIds
      randomId = allAchievementIds(Random.nextInt(allAchievementIds.size))
      achievement <- gw2.achievements.getAchievement(randomId)
    } yield {
      println(achievement)
      ExitCode.Success
    }
  }
}
