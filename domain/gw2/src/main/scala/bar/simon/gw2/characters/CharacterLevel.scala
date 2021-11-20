package bar.simon.gw2.characters

import eu.timepit.refined.types.all.PosInt

// TODO: use refined to narrow this between 1 and 80?
final case class CharacterLevel(value: PosInt) extends AnyVal
