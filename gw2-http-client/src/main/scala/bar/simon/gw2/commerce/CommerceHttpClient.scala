package bar.simon.gw2.commerce

import bar.simon.gw2.commerce.listings.ItemListings
import bar.simon.gw2.commerce.prices.ItemPrice
import bar.simon.gw2.http.HttpClientConfig
import bar.simon.gw2.items.ItemId
import cats.effect.Sync
import io.circe.Decoder

final class CommerceHttpClient[F[_]: Sync](config: HttpClientConfig[F], lang: String) extends CommerceClient[F] {

  import bar.simon.gw2.commerce.CommerceCodecs._
  import bar.simon.gw2.items.ItemCodecs.itemIdDecoder

  private val listings = "listings"
  private val prices   = "prices"

  override def getItemIdsFromListings: F[List[ItemId]] =
    get[List[ItemId]](listings)

  override def getListings(id: ItemId): F[ItemListings] =
    get[ItemListings](s"$listings/${id.value}")

  override def getListings(ids: List[ItemId]): F[List[ItemListings]] =
    get[List[ItemListings]](listings, Map("ids" -> ids.map(_.value).mkString(",")))

  override def getItemIdsFromPrices: F[List[ItemId]] =
    get[List[ItemId]](prices)

  override def getPrices(id: ItemId): F[ItemPrice] =
    get[ItemPrice](s"$prices/${id.value}")

  override def getPrices(ids: List[ItemId]): F[List[ItemPrice]] =
    get[List[ItemPrice]](prices, Map("ids" -> ids.map(_.value).mkString(",")))

  private def get[T](path: String, query: Map[String, String] = Map.empty)(implicit decoder: Decoder[T]): F[T] =
    config.get[T](path, query + ("lang" -> lang))
}
