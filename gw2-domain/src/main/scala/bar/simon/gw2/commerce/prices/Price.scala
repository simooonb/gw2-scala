package bar.simon.gw2.commerce.prices

import eu.timepit.refined.types.all.PosInt

final case class Price(unitPrice: PosInt, quantity: PosInt)
