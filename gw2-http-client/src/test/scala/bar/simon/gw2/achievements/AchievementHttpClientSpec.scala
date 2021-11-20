package bar.simon.gw2.achievements

import bar.simon.gw2.http.HttpClientConfig
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration

class AchievementHttpClientSpec extends AnyWordSpec with Matchers {

  implicit val ec: IO[ExecutionContext] = IO.executionContext

  val timeout: Duration                 = Duration("2 s")
  val config: HttpClientConfig[IO]      = HttpClientConfig[IO]("https://api.guildwars2.com/v2", timeout)
  val client: AchievementHttpClient[IO] = new AchievementHttpClient[IO](config / "achievements", "en")

  "AchievementHttpClientSpec" should {
    "parse achievements" in {
      val test = for {
        ids          <- client.getAllAchievementIds
        achievement  <- client.getAchievement(AchievementId(910))
        achievements <- client.getAchievements(List(AchievementId(1840), AchievementId(2258)))
      } yield (ids, achievement, achievements)

      val (idsHead :: ids, achievement, achievementsHead :: achievements) = test.unsafeRunSync()

      idsHead shouldBe a[AchievementId]
      ids shouldBe a[List[_]]
      achievement shouldBe a[Achievement]
      achievementsHead shouldBe a[Achievement]
      achievements shouldBe a[List[_]]
    }
  }
}
