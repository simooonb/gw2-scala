package bar.simon.gw2.achievements.groups

import bar.simon.gw2.achievements.categories.AchievementCategoryId
import eu.timepit.refined.types.all.PosInt

final case class AchievementGroup(
    id: AchievementGroupId,
    name: String,
    description: String,
    order: PosInt,
    categories: List[AchievementCategoryId]
)
