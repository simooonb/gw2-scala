package bar.simon.gw2.achievements.daily

final case class AchievementDailies(
    pve: List[AchievementDaily],
    pvp: List[AchievementDaily],
    wvw: List[AchievementDaily],
    fractals: List[AchievementDaily],
    special: List[AchievementDaily]
)
