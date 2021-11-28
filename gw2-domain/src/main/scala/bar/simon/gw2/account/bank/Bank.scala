package bar.simon.gw2.account.bank

final case class Bank(slots: List[Option[BankSlot]]) {
  lazy val size: Int         = slots.size
  lazy val usedRatio: Double = slots.count(_.nonEmpty).toDouble / size
  lazy val freeRatio: Double = 1 - usedRatio
}
