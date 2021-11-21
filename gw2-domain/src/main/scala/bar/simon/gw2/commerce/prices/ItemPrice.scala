package bar.simon.gw2.commerce.prices

import bar.simon.gw2.items.ItemId

final case class ItemPrice(id: ItemId, whitelisted: Boolean, buys: Price, sells: Price)
