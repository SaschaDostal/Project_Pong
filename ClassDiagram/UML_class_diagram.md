```plantuml
class Hitbox {
  -hitbox: Rect
  +getHitbox(): Rect
}
abstract class GameComponent {
  #id: int
  #pos: Position
  #visible: boolean
  #hitbox: Rect/Hitbox//[]
  +getID(): int
  +getPos(): Position
  +isVisible(): boolean
  +move(pos: Position)
}
class GameBoard {
  -gameComponents: GameComponent[]
  -validPositions: Position[]
  +getBall(): Ball
  +getPlayer1(): Player
  +getPlayer2(): Player
  +draw()
}
class PlayerBar {
  -speed: int
  +getSpeed(): int
}
class Ball {
  -speed: int
  +getSpeed: int
}
class Wall {

}
class Control {
  -players: Player[]
  -ball: Ball
  +main(args: String[])
  -step()
  -goal()
}
class Player {
  -id: int
  -bar: PlayerBar
  -score: int
  +getID(): int
  +getBar(): Playerbar
  +goal()
}
class ScoringSystem {
    -numberOfPlayers: int
    -pointsPlayer1: int
    -pointsPlayer2: int
    -pointsPlayer3: int
    -pointsPlayer4: int
    +addPointToPlayer(player: int)
    +getPointsOfPlayer(player: int): int
    +resetPlayerPoints()
    +printScore(names: String[])
}
class GameWindow {

}
class Movenment {

}
class Scaling {

}

GameComponent "m" -- "1" GameBoard: has <
GameComponent <|-- PlayerBar
GameComponent <|-- Ball
GameComponent <|-- Wall
GameComponent "1" -- "1//m" Hitbox: has >
Control "1" -- "1" GameBoard: manages >
Control "1" -- "1" Ball: manages >
Control "1" -- "1..4" Player: manages >
Control "1" -- "1" ScoringSystem: manages >
Player "1" -- "1" PlayerBar: has >
note "m = [1, inf)" as N1
```