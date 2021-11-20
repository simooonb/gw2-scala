package bar.simon.gw2.achievements

sealed trait AchievementType

object AchievementType {
  case object Default extends AchievementType
  case object ItemSet extends AchievementType
}
