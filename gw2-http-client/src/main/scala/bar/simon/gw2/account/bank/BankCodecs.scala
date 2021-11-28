package bar.simon.gw2.account.bank

import io.circe.Decoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto._
import io.circe.refined._

trait BankCodecs {

  import bar.simon.gw2.items.ItemCodecs.{itemIdDecoder, bindingDecoder}
  import bar.simon.gw2.itemstats.ItemStatsCodecs.statsDecoder
  import bar.simon.gw2.skins.SkinCodecs.skinIdDecoder
  import bar.simon.gw2.colors.ColorCodecs.colorIdDecoder
  import bar.simon.gw2.characters.CharacterCodecs.nameDecoder

  implicit val conf: Configuration = Configuration.default.withDefaults.withSnakeCaseMemberNames

  implicit val bankSlotCodec: Decoder[BankSlot] = deriveConfiguredDecoder[BankSlot]

}

object BankCodecs extends BankCodecs
