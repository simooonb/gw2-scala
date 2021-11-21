package bar.simon.gw2.commerce.listings

import eu.timepit.refined.types.all.PosInt

final case class Listings(listings: PosInt, unitPrice: PosInt, quantity: PosInt)
