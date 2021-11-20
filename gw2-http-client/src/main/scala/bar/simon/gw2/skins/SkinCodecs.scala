package bar.simon.gw2.skins

import io.circe._
import io.circe.generic.extras.semiauto.deriveUnwrappedDecoder

trait SkinCodecs {

  implicit val skinIdDecoder: Decoder[SkinId] = deriveUnwrappedDecoder

}

object SkinCodecs extends SkinCodecs
