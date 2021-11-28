package bar.simon.gw2.items

sealed trait ItemBinding

object ItemBinding {
  case object Account   extends ItemBinding
  case object Character extends ItemBinding
}
