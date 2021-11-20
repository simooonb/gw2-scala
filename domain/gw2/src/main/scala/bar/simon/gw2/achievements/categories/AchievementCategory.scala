package bar.simon.gw2.achievements.categories

import bar.simon.gw2.achievements.AchievementId
import eu.timepit.refined.types.all.PosInt

final case class AchievementCategory(
    id: AchievementCategoryId,
    name: String,
    description: String,
    order: PosInt,
    icon: String,
    achievements: List[AchievementId]
)
