package bar.simon.gw2.account

import bar.simon.gw2.account.bank.Bank

trait AccountClient[F[_]] {

  def getBank(token: AccessToken): F[Bank]

}
