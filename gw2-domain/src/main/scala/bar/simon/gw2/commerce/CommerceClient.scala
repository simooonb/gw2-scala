package bar.simon.gw2.commerce

import bar.simon.gw2.commerce.listings.ItemListings
import bar.simon.gw2.commerce.prices.ItemPrice
import bar.simon.gw2.items.ItemId

trait CommerceClient[F[_]] {
  def getItemIdsFromListings: F[List[ItemId]]
  def getListings(id: ItemId): F[ItemListings]
  def getListings(ids: List[ItemId]): F[List[ItemListings]]

  def getItemIdsFromPrices: F[List[ItemId]]
  def getPrices(id: ItemId): F[ItemPrice]
  def getPrices(ids: List[ItemId]): F[List[ItemPrice]]
}
