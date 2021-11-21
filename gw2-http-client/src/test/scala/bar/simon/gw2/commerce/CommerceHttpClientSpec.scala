package bar.simon.gw2.commerce

import bar.simon.gw2.commerce.listings.ItemListings
import bar.simon.gw2.commerce.prices.ItemPrice
import bar.simon.gw2.http.HttpClientConfig
import bar.simon.gw2.items.ItemId
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration

class CommerceHttpClientSpec extends AnyWordSpec with Matchers {

  implicit val ec: IO[ExecutionContext] = IO.executionContext

  val timeout: Duration              = Duration("2 s")
  val config: HttpClientConfig[IO]   = HttpClientConfig[IO]("https://api.guildwars2.com/v2", timeout)
  val client: CommerceHttpClient[IO] = new CommerceHttpClient[IO](config / "commerce", "en")

  "CommerceHttpClientSpec" should {
    "parse prices" in {
      val test = for {
        price  <- client.getPrices(ItemId(19684))
        prices <- client.getPrices(List(ItemId(19684), ItemId(19709)))
      } yield (price, prices)

      val (price, pricesHead :: prices) = test.unsafeRunSync()

      price shouldBe a[ItemPrice]
      pricesHead shouldBe a[ItemPrice]
      prices shouldBe a[List[_]]
    }

    "parse listings" in {
      val test = for {
        listing  <- client.getListings(ItemId(19684))
        listings <- client.getListings(List(ItemId(19684), ItemId(19709)))
      } yield (listing, listings)

      val (listing, listingsHead :: listings) = test.unsafeRunSync()

      listing shouldBe a[ItemListings]
      listingsHead shouldBe a[ItemListings]
      listings shouldBe a[List[_]]
    }
  }
}
