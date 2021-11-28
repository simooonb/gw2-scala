package bar.simon.gw2.colors

import io.circe.Decoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveUnwrappedDecoder

trait ColorCodecs {
  implicit val conf: Configuration              = Configuration.default.withDefaults.withSnakeCaseMemberNames
  implicit val colorIdDecoder: Decoder[ColorId] = deriveUnwrappedDecoder
}

object ColorCodecs extends ColorCodecs
