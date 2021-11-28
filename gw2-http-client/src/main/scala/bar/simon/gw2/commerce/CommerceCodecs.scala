package bar.simon.gw2.commerce

import bar.simon.gw2.commerce.listings.{ItemListings, Listings}
import bar.simon.gw2.commerce.prices.{ItemPrice, Price}
import io.circe._
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveConfiguredDecoder

trait CommerceCodecs {

  import bar.simon.gw2.items.ItemCodecs.itemIdDecoder

  implicit val conf: Configuration = Configuration.default.withDefaults.withSnakeCaseMemberNames

  implicit val priceDecoder: Decoder[Price]         = deriveConfiguredDecoder
  implicit val itemPriceDecoder: Decoder[ItemPrice] = deriveConfiguredDecoder

  implicit val listingsDecoder: Decoder[Listings]         = deriveConfiguredDecoder
  implicit val itemListingsDecoder: Decoder[ItemListings] = deriveConfiguredDecoder

}

object CommerceCodecs extends CommerceCodecs
