package bar.simon.gw2.account

import io.circe._
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveEnumerationCodec, deriveUnwrappedDecoder}

trait AccountCodecs {

  implicit val conf: Configuration = Configuration.default.withDefaults.withSnakeCaseMemberNames

  implicit val accountAccessDecoder: Decoder[AccountAccess] = deriveEnumerationCodec
  implicit val accessTokenDecoder: Decoder[AccessToken]     = deriveUnwrappedDecoder

}

object AccountCodecs extends AccountCodecs
