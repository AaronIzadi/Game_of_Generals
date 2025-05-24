
# Game of Generals ♟️

## About this game

Game of Generals is a variation of mini Shogi with two main differences:  
1. Pieces can come back to life.  
2. Some pieces have an upgrade option!

---

## Pieces

- **Pawn:** Moves forward one step at a time.  
- **Lance:** Moves forward any number of steps.  
- **King:** Moves one step in any direction.  
- **Bishop:** Moves diagonally (crosswise) any number of steps, but only forward.  
- **Silver General:** Moves to all adjacent cells **except** those with the same y-coordinate and the one behind with the same x-coordinate.  
  To visualize:
  ```
  #  #  #
     SG
  #     #
  ```
  (# indicates valid cells to move to)

- **Golden General:** Moves to all adjacent cells **except** those behind with different x-coordinates.  
  To visualize:
  ```
  #  #  #
  #  GG #
     #
  ```
  (# indicates valid cells to move to)

---

## Rules

1. Black moves first.  
2. You cannot jump over pieces but can capture an opponent’s piece.  
3. **Winning condition:** The first to capture the rival’s king wins (kings can capture each other).  
4. **Upgrade option:** Activated when moving into the last two rows of the board.  
   - Pawn: Moves like a Golden General.  
   - Lance: Can move in any direction vertically and horizontally.  
   - Bishop: Moves either diagonally any number of steps or one step vertically.  
   - Silver General: Can move up to two steps in any direction.  
5. Captured pieces change color and can be placed back on the board next turn.  
6. Upgraded captured pieces revert to normal when added back.  
7. Pieces placed in the last two rows **do not** upgrade immediately.

---

## P.S.

This mini project was originally designed by a teaching assistant for the "Advanced Programming" course.

Check out the original author’s GitHub here: [Aeirya](https://github.com/aeirya)

Good luck! 🍀
