package bar.simon.gw2.achievements

import bar.simon.gw2.items.ItemId
import bar.simon.gw2.masteries.{MasteryId, MasteryRegion}
import bar.simon.gw2.titles.TitleId
import eu.timepit.refined.types.all.PosInt

sealed trait AchievementReward

object AchievementReward {
  final case class Coins(count: PosInt)                          extends AchievementReward
  final case class Item(id: ItemId, count: PosInt)               extends AchievementReward
  final case class Mastery(id: MasteryId, region: MasteryRegion) extends AchievementReward
  final case class Title(id: TitleId)                            extends AchievementReward
}
