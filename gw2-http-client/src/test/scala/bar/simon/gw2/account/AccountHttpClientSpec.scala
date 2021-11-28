package bar.simon.gw2.account

import bar.simon.gw2.account.bank.{Bank, BankSlot}
import bar.simon.gw2.http.HttpClientConfig
import bar.simon.gw2.items.ItemId
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import org.mockito.scalatest.MockitoSugar
import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import eu.timepit.refined.auto._

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration

// TODO: mock return HTTP response not case class!
class AccountHttpClientSpec extends AnyWordSpec with Matchers with MockitoSugar with BeforeAndAfterEach {

  implicit val ec: IO[ExecutionContext] = IO.executionContext

  val timeout: Duration             = Duration("2 s")
  val config: HttpClientConfig[IO]  = HttpClientConfig[IO]("https://api.guildwars2.com/v2", timeout)
  val client: AccountHttpClient[IO] = mock[AccountHttpClient[IO]]
  val token: AccessToken            = AccessToken("token")

  val itemId: ItemId     = ItemId(123)
  val bankSlot: BankSlot = BankSlot(itemId, 1, None, None, None, None, None, None, None, None, None)

  "AccountHttpClient" should {
    "parse bank" in {
      val test = client.getBank(token)
      val bank = test.unsafeRunSync()

      when(client.getBank(any[AccessToken])).thenReturn(IO.pure(Bank(List(Some(bankSlot)))))
      bank.slots.head.get shouldBe a[BankSlot]
    }
  }

  override def beforeEach(): Unit = {
    when(client.getBank(any[AccessToken])).thenReturn(IO.pure(Bank(List(Some(bankSlot)))))

    ()
  }
}
