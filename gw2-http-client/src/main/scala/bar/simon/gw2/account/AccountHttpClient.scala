package bar.simon.gw2.account

import bar.simon.gw2.account.bank.{Bank, BankSlot}
import bar.simon.gw2.http.HttpClientConfig
import cats.effect.Sync
import cats.implicits._
import io.circe.Decoder

class AccountHttpClient[F[_]: Sync](config: HttpClientConfig[F]) extends AccountClient[F] {

  import bar.simon.gw2.account.bank.BankCodecs._

  private val bank = "bank"

  def getBank(token: AccessToken): F[Bank] =
    get[List[Option[BankSlot]]](bank, token).map(Bank)

  private def get[T](
      path: String,
      token: AccessToken,
      query: Map[String, String] = Map.empty
  )(implicit decoder: Decoder[T]): F[T] =
    config.get[T](path, query + ("access_token" -> token.value))
}
