package bar.simon.gw2.itemstats

sealed trait ItemStatsAttributes

object ItemStatsAttributes {
  final case class AgonyResistance(value: Double)   extends ItemStatsAttributes
  final case class BoonDuration(value: Double)      extends ItemStatsAttributes
  final case class ConditionDamage(value: Double)   extends ItemStatsAttributes
  final case class ConditionDuration(value: Double) extends ItemStatsAttributes
  final case class CritDamage(value: Double)        extends ItemStatsAttributes
  final case class Healing(value: Double)           extends ItemStatsAttributes
  final case class Power(value: Double)             extends ItemStatsAttributes
  final case class Precision(value: Double)         extends ItemStatsAttributes
  final case class Toughness(value: Double)         extends ItemStatsAttributes
  final case class Vitality(value: Double)          extends ItemStatsAttributes
}
