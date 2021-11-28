package bar.simon.gw2.characters

import io.circe._
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveUnwrappedDecoder

trait CharacterCodecs {
  implicit val conf: Configuration = Configuration.default.withDefaults.withSnakeCaseMemberNames

  implicit val levelDecoder: Decoder[CharacterLevel] = deriveUnwrappedDecoder
  implicit val nameDecoder: Decoder[CharacterName]   = deriveUnwrappedDecoder

}

object CharacterCodecs extends CharacterCodecs
