package bar.simon.gw2.commerce.listings

import bar.simon.gw2.items.ItemId

final case class ItemListings(id: ItemId, buys: List[Listings], sells: List[Listings])
