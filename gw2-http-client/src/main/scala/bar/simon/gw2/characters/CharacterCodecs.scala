package bar.simon.gw2.characters

import io.circe._
import io.circe.generic.extras.semiauto.deriveUnwrappedDecoder

trait CharacterCodecs {

  implicit val levelDecoder: Decoder[CharacterLevel] = deriveUnwrappedDecoder

}
