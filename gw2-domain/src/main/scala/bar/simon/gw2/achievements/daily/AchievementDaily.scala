package bar.simon.gw2.achievements.daily

import bar.simon.gw2.account.AccountAccess
import bar.simon.gw2.achievements.AchievementId

final case class AchievementDaily(
    id: AchievementId,
    level: AchievementDailyLevelWindow,
    requiredAccess: List[AccountAccess] // TODO: check what's happening with schemas?
)
