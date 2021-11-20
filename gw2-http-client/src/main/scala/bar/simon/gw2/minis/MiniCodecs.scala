package bar.simon.gw2.minis

import io.circe._
import io.circe.generic.extras.semiauto.deriveUnwrappedDecoder

trait MiniCodecs {

  implicit val miniIdDecoder: Decoder[MiniId] = deriveUnwrappedDecoder

}

object MiniCodecs extends MiniCodecs
