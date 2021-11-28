package bar.simon.gw2.itemstats

import io.circe.Decoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._
import io.circe.generic.extras.semiauto.{deriveConfiguredDecoder, deriveUnwrappedDecoder}

trait ItemStatsCodecs {

  implicit val conf: Configuration = Configuration.default.withDefaults.withSnakeCaseMemberNames

  implicit val idDecoder: Decoder[ItemStatsId] = deriveUnwrappedDecoder

  implicit val attributesDecoder: Decoder[ItemStatsAttributes] =
    Decoder[ItemStatsAttributes.AgonyResistance]
      .map[ItemStatsAttributes](identity)
      .or(Decoder[ItemStatsAttributes.BoonDuration].map[ItemStatsAttributes](identity))
      .or(Decoder[ItemStatsAttributes.ConditionDamage].map[ItemStatsAttributes](identity))
      .or(Decoder[ItemStatsAttributes.ConditionDuration].map[ItemStatsAttributes](identity))
      .or(Decoder[ItemStatsAttributes.CritDamage].map[ItemStatsAttributes](identity))
      .or(Decoder[ItemStatsAttributes.Healing].map[ItemStatsAttributes](identity))
      .or(Decoder[ItemStatsAttributes.Power].map[ItemStatsAttributes](identity))
      .or(Decoder[ItemStatsAttributes.Precision].map[ItemStatsAttributes](identity))
      .or(Decoder[ItemStatsAttributes.Toughness].map[ItemStatsAttributes](identity))
      .or(Decoder[ItemStatsAttributes.Vitality].map[ItemStatsAttributes](identity))

  implicit val statsDecoder: Decoder[ItemStats] = deriveConfiguredDecoder
}

object ItemStatsCodecs extends ItemStatsCodecs
