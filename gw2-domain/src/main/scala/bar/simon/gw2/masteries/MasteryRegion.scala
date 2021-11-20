package bar.simon.gw2.masteries

sealed trait MasteryRegion

object MasteryRegion {
  case object Tyria   extends MasteryRegion
  case object Maguuma extends MasteryRegion
  case object Desert  extends MasteryRegion
  case object Tundra  extends MasteryRegion
}
