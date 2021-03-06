package bar.simon.gw2

import bar.simon.gw2.account.AccountHttpClient
import bar.simon.gw2.achievements.AchievementHttpClient
import bar.simon.gw2.commerce.CommerceHttpClient
import bar.simon.gw2.http.HttpClientConfig
import cats.effect.Sync

import scala.concurrent.duration.Duration

object Gw2HttpClient {

  // TODO: model languages other than a simple String
  def create[F[_]](lang: String, timeout: Duration)(implicit F: Sync[F]): Gw2Client[F] = {
    val config = HttpClientConfig("https://api.guildwars2.com/v2", timeout)

    Gw2Client(
      new AchievementHttpClient[F](config / "achievements", lang),
      new AccountHttpClient[F](config / "account"),
      new CommerceHttpClient[F](config / "commerce", lang)
    )
  }

}
