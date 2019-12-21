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

GameComponent "m" -- "1" GameBoard: has <
GameComponent <|-- PlayerBar
GameComponent <|-- Ball
GameComponent "1" -- "1//m" Hitbox: has >
Control "1" -- "1" GameBoard: manages >
Control "1" -- "1" Ball: manages >
Control "1" -- "2..n" Player: manages >
Player "1" -- "1" PlayerBar: has >
note "m = [1, inf)\nn = inf" as N1
```