package bar.simon.gw2.items

import io.circe._
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveEnumerationCodec, deriveUnwrappedDecoder}

trait ItemCodecs {
  implicit val conf: Configuration = Configuration.default.withDefaults.withSnakeCaseMemberNames

  implicit val itemIdDecoder: Decoder[ItemId]       = deriveUnwrappedDecoder
  implicit val bindingDecoder: Decoder[ItemBinding] = deriveEnumerationCodec

}

object ItemCodecs extends ItemCodecs
