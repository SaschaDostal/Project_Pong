```plantuml
class Hitbox {
  -hitbox: Rect
  +getHitbox(): Rect
}
abstract class GameComponent {
  #hitbox: Rectangle
  #id: int
  #pos: Position
  #visible: boolean
  GameComponent(id: int, pos: Position, visible: boolean, hitbox: Rectangle)
  +getHitbox(): Rectangle
  +getId(): int
  +getPosition(): Position
  +isVisible(): boolean
  +move(pos: Position)
  +paintComponent(graphics: Graphics)
}
class Position {
  -x: int
  -y: int
  +Position(x: int, y: int)
  +getX(): int
  +getY(): int
  setX(x: double)
  setY(y: double)
}
class GameBoard {
  -gameComponents: GameComponent[]
  +GameBoard(gameComponents: GameComponent[])
  +draw()
  +getBall(): Ball
  +getGameComponents(): GameComponent[]
  +getPlayerBar1(): PlayerBar
  +getPlayerBar2(): PlayerBar
  +isValidHitboxPosition(hitbox: Rectangle): Validity
  paint(graphics: Graphics)
}
class PlayerBar {
  -serialVersionUID: long
  -speed: int
  +PlayerBar(id: int, pos: Position, visible: boolean, hitbox: Rectangle, speed: int)
  +getSpeed(): int
  +moveDown()
  +moveUp()
  +paintComponent(graphics: Graphics)
}
class Ball {
  -direction: float[]
  -floatPosX: float
  -floatPosY: float
  - lastComponentHit: int
  -speed: int
  +Ball(id: int, pos: Position, visible: boolean, hitbox: Rectangle, speed: float)
  +getDirection(): float[]
  +getLastComponentHit(): int
  +getSpeed(): int
  +move()
  +paintComponent()
  +randomDirections(): float[]
  +setDirection(dir: float[])
  +setFloatPosX(x: float)
  +setFloatPosY(y: float)
  +setLastComponentHit(lastComponentHit: int)
  +setSpeed(speed: double)
}
class Wall {
  -serialVersionUID: long
  +Wall(id: int, pos: Position, visible: boolean, hitbox: Rectangle)
  +paintComponent(g: Graphics)
}
class Goal {
  -serialVersionUID: long
  +Wall(id: int, pos: Position, visible: boolean, hitbox: Rectangle)
  +paintComponent(g: Graphics)
}
class Control {
  +main(args: String[])
  -ball: Ball
  -board: GameBoard
  -goals: Goal[]
  -mov: Movement
  -playerNames: String[]
  -players: Player[]
  -playsc: PlayerScore
  -score: ScoringSystem
  -startWindow: StartWindow
  -timer: Timer
  -walls: Wall[]
  -window: GameWindow
  -BAPlayer: AACPlayer
  -GOPlayer: AACPLayer
  +actionPerformed(e: ActionEvent)
  -collision(gameComponents: GameComponent[])
  +endGame()
  +reset()
  +startGame()
  -step()
}
class AACPlayer {
  -files: File[]
  -interrupted: boolean
  -loop: boolean
  -muted: boolean
  -paused: boolean
  -playback: Thread
  -repeat: boolean
  +AACPlayer(File)
  +AACPlayer(File[])
  +AACPlayer(String)
  +enableLoop()
  +disableLoop()
  +enableRepeat()
  +disableRepeat()
  +isMuted(): boolean
  +isPlaying(): boolean
  +pause()
  +play()
  +resume()
  +stop()
  +toggleMute()
  -initThread()
}
class StartWindow {
  -serialVersionUID: long
  -contentPane: JPanel
  -textField_2: JTextField
  -textField_3: JTextField
  +StartWindow(con: Control)
}
class Player {
  -id: int
  -bar: PlayerBar
  +Player(id: int, bar: PlayerBar)
  +getID(): int
  +getBar(): Playerbar
}
class PlayerScore {
  -serialVersionUID: long
  -boxBoxBloxs: Rectangle
  -boxBoxBloxs2: Rectangle
  -score1: String
  -score2: String
  +PlayerScore(id: int, pos: Position, visible: boolean, hitbox: Rectangle)
  +getScore1(): int
  +getScore2(): int
  paintComponent(graphics: Graphics)
  setScore1(score1: int)
  setScore2(score2: int)
}
class ScoringSystem {
  -numberOfPlayers: int
  -pointsPlayer1: int
  -pointsPlayer2: int
  -pointsPlayer3: int
  -pointsPlayer4: int
  +ScoringSystem(playerNumber: int)
  +addPointToPlayer(player: int)
  +getPointsOfPlayer(player: int): int
  +resetPlayerPoints()
  +printScore(names: String[])
}
class GameWindow {
  -serialVersionUID: long
  -gameBoard: GameBoard
  +GameWindow(gameBoard: GameBoard)
  +getGameBoard()
  -initialize()

}
class Movement {
  -upPressed: boolean
  -downPressed: boolean
  -wPressed: boolean
  -sPressed: boolean
  -keylis: KeyListener
  +Movement()
  +getKeyListener(): KeyListener
  +isUpPressed(): boolean
  +isDownPressed(): boolean
  +isWPressed(): boolean
  +isSPressed(): boolean
}
abstract class MyRunnable{
  keylis: KeyListener
  {abstract}#getLis(): KeyListener
} 
class Scaling {
  {static}+sizeX: int
  {static}+sizeY: int
  {static}+playerBarRecX: int
  {static}+playerBarRecY: int
  {static}+playerBarPos1X: int
  {static}+playerBarPos1Y: int
  {static}+playerBarPos2X: int
  {static}+playerBarPos2Y: int
  {static}+wallRecX: int
  {static}+wallRecY: int
  {static}+wallPos1X: int
  {static}+wallPos1Y: int
  {static}+wallPos2X: int
  {static}+wallPos2Y: int
  {static}+wallRec1X: int
  {static}+wallRec1Y: int
  {static}+wallPos3X: int
  {static}+wallPos3Y: int
  {static}+wallPos4X: int
  {static}+wallPos4Y: int
  {static}+ballRecX: int
  {static}+ballRecY: int
  {static}+ballPosX: int
  {static}+ballPosY:int
  {static}+maxValid: int
  {static}+minValid: int
  +Scaling()
}

GameComponent "m" --o "1" GameBoard: has <
GameComponent <|-- PlayerBar
GameComponent <|-- Ball
GameComponent <|-- Wall
GameComponent <|-- Goal
GameComponent <|-- PlayerScore
GameComponent "1" o-- "1//m" Hitbox: has >
GameComponent "1" o-- "1" Position
GameWindow "1" o-- "1" GameBoard
Movement o-- MyRunnable 
Control "1" -- "1" GameBoard: manages >
Control "1" -- "1" Ball: manages >
Control "1" -- "2" Player: manages >
Control "1" -- "2" Wall: manages >
Control "1" -- "2" Goal: manages >
Control "1" -- "1" ScoringSystem: manages >
Control "1" -- "1" PlayerScore: manages >
Control "1" -- "1" GameWindow: manages >
Control "1" -- "1" Movement: manages >
Control  -- Scaling: scales <
Control "1" -- "1" StartWindow: has <
Control "1" -- "m" AACPLayer: manages >
Player "1" o-- "1" PlayerBar: has >
note "m = [1, inf)" as N1
```