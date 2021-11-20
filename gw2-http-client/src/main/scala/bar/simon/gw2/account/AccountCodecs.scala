package bar.simon.gw2.account

import io.circe._
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveEnumerationCodec

trait AccountCodecs {

  implicit val conf: Configuration = Configuration.default.withDefaults

  implicit val accountAccessDecoder: Decoder[AccountAccess] = deriveEnumerationCodec

}

object AccountCodecs extends AccountCodecs
