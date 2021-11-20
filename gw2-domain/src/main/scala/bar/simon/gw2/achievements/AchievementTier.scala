package bar.simon.gw2.achievements

import eu.timepit.refined.types.all.PosInt

final case class AchievementTier(count: PosInt, points: PosInt)
