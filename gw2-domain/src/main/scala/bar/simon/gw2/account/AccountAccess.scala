package bar.simon.gw2.account

sealed trait AccountAccess

object AccountAccess {
  case object None          extends AccountAccess
  case object PlayForFree   extends AccountAccess
  case object GuildWars2    extends AccountAccess
  case object HeartOfThorns extends AccountAccess
  case object PathOfFire    extends AccountAccess
}
