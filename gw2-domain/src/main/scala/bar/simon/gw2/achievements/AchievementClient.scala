package bar.simon.gw2.achievements

import bar.simon.gw2.achievements.categories.{AchievementCategory, AchievementCategoryId}
import bar.simon.gw2.achievements.daily.AchievementDailies
import bar.simon.gw2.achievements.groups.{AchievementGroup, AchievementGroupId}

trait AchievementClient[F[_]] {
  def getAllAchievementIds: F[List[AchievementId]]
  def getAchievement(id: AchievementId): F[Achievement]
  def getAchievements(ids: List[AchievementId]): F[List[Achievement]]

  def getAllGroupIds: F[List[AchievementGroupId]]
  def getGroup(id: AchievementGroupId): F[AchievementGroup]
  def getGroups(ids: List[AchievementGroupId]): F[List[AchievementGroup]]

  def getAllCategoryIds: F[List[AchievementCategoryId]]
  def getCategory(id: AchievementCategoryId): F[AchievementCategory]
  def getCategories(ids: List[AchievementCategoryId]): F[List[AchievementCategory]]

  def getDailiesOfToday: F[AchievementDailies]
  def getDailiesOfTomorrow: F[AchievementDailies]
}
