package bar.simon.gw2.achievements

import bar.simon.gw2.items.ItemId
import bar.simon.gw2.minis.MiniId
import bar.simon.gw2.skins.SkinId

sealed trait AchievementBit

object AchievementBit {
  final case class Text(text: String)  extends AchievementBit
  final case class Item(id: ItemId)    extends AchievementBit
  final case class Minipet(id: MiniId) extends AchievementBit
  final case class Skin(id: SkinId)    extends AchievementBit
}
