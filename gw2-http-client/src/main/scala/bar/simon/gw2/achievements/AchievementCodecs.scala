package bar.simon.gw2.achievements

import bar.simon.gw2.achievements.categories.{AchievementCategory, AchievementCategoryId}
import bar.simon.gw2.achievements.daily.{AchievementDailies, AchievementDaily, AchievementDailyLevelWindow}
import bar.simon.gw2.achievements.groups.{AchievementGroup, AchievementGroupId}
import io.circe._
import io.circe.refined._
import io.circe.generic.auto._
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.{deriveConfiguredDecoder, deriveEnumerationCodec, deriveUnwrappedDecoder}

trait AchievementCodecs {

  import bar.simon.gw2.account.AccountCodecs.accountAccessDecoder

  import bar.simon.gw2.items.ItemCodecs.itemIdDecoder
  import bar.simon.gw2.minis.MiniCodecs.miniIdDecoder
  import bar.simon.gw2.skins.SkinCodecs.skinIdDecoder

  implicit val conf: Configuration =
    Configuration.default.withDefaults.withSnakeCaseMemberNames.withDiscriminator("type")

  implicit val achievementIdDecoder: Decoder[AchievementId]                 = deriveUnwrappedDecoder
  implicit val achievementGroupIdDecoder: Decoder[AchievementGroupId]       = deriveUnwrappedDecoder
  implicit val achievementCategoryIdDecoder: Decoder[AchievementCategoryId] = deriveUnwrappedDecoder

  implicit val achievementBitDecoder: Decoder[AchievementBit] =
    Decoder[AchievementBit.Text]
      .map[AchievementBit](identity)
      .or(Decoder[AchievementBit.Item].map[AchievementBit](identity))
      .or(Decoder[AchievementBit.Minipet].map[AchievementBit](identity))
      .or(Decoder[AchievementBit.Skin].map[AchievementBit](identity))

  implicit val achievementTypeDecoder: Decoder[AchievementType] = deriveEnumerationCodec
  implicit val achievementFlagDecoder: Decoder[AchievementFlag] = deriveEnumerationCodec
  implicit val achievementTierDecoder: Decoder[AchievementTier] = deriveConfiguredDecoder
  implicit val achievementDecoder: Decoder[Achievement]         = deriveConfiguredDecoder

  implicit val achievementDailyLevelWindowDecoder: Decoder[AchievementDailyLevelWindow] = deriveConfiguredDecoder
  implicit val achievementDailyDecoder: Decoder[AchievementDaily]                       = deriveConfiguredDecoder
  implicit val achievementDailiesDecoder: Decoder[AchievementDailies]                   = deriveConfiguredDecoder

  implicit val achievementGroupDecoder: Decoder[AchievementGroup]       = deriveConfiguredDecoder
  implicit val achievementCategoryDecoder: Decoder[AchievementCategory] = deriveConfiguredDecoder
}

object AchievementCodecs extends AchievementCodecs
