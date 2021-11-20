package bar.simon.gw2.items

import io.circe._
import io.circe.generic.extras.semiauto.deriveUnwrappedDecoder

trait ItemCodecs {

  implicit val itemIdDecoder: Decoder[ItemId] = deriveUnwrappedDecoder

}

object ItemCodecs extends ItemCodecs