package bar.simon.gw2.account.bank

import bar.simon.gw2.characters.CharacterName
import bar.simon.gw2.colors.ColorId
import bar.simon.gw2.items.{ItemBinding, ItemId}
import bar.simon.gw2.itemstats.ItemStats
import bar.simon.gw2.skins.SkinId
import eu.timepit.refined.types.all.PosInt

final case class BankSlot(
    id: ItemId,
    count: PosInt,
    charges: Option[PosInt],
    skin: Option[SkinId],
    dyes: Option[List[ColorId]],
    upgrades: Option[List[ItemId]],
    upgradeSlotIndices: Option[List[Int]],
    infusions: Option[List[ItemId]],
    binding: Option[ItemBinding],
    boundTo: Option[CharacterName],
    stats: Option[ItemStats]
)
