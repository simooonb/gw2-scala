package bar.simon.gw2.achievements

import eu.timepit.refined.types.all.PosInt

final case class Achievement(
    id: AchievementId,
    icon: Option[String],
    name: String,
    description: String,
    requirement: String,
    lockedText: String,
    `type`: AchievementType,
    flags: List[AchievementFlag],
    tiers: List[AchievementTier],
    prerequisites: List[AchievementId],
    bits: List[AchievementBit],
    pointCap: Option[PosInt]
)
