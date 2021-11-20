package bar.simon.gw2.achievements

sealed trait AchievementFlag

object AchievementFlag {
  case object Pvp                  extends AchievementFlag
  case object CategoryDisplay      extends AchievementFlag
  case object MoveToTop            extends AchievementFlag
  case object IgnoreNearlyComplete extends AchievementFlag
  case object Repeatable           extends AchievementFlag
  case object Hidden               extends AchievementFlag
  case object RequiresUnlock       extends AchievementFlag
  case object RepairOnLogin        extends AchievementFlag
  case object Daily                extends AchievementFlag
  case object Weekly               extends AchievementFlag
  case object Monthly              extends AchievementFlag
  case object Permanent            extends AchievementFlag
}
