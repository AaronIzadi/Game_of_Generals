# Game of Generals

## About this game:

```
This game is another version of the game known as mini Shogi with two main differences:
1) Pieces can come back to life.
2) Some pieces have upgrade option!
```

## Pieces:
```
Pawn: Only moves forward (one step at a time).

Lance: Moves forward.

King: Moves one step at any desired direction.

Bishop: Moves diagonally (crosswise) as much as desired, but only
in the front direction.

Silver General: Moves to all its adjacent cells except for the ones with the same y (in coordinates) and the one in the back with the same x (in coordinates). To help you understand better take a look at this:
 #  #  #
   S G
 #     #
The #'s are the valid cells to move into.

Golden General: Just like the Silver General, it can move to all its adjacent cells except for the ones at the back with different x (in coordinates).
To help you understand better take a look at this:
 #  #  #
 # G G #
    #
The #'s are the valid cells to move into.

```

## Rules:

```
1) Black moves first.
2) You can't jump over pieces, but you can hit rival's piece.
3) How to win: The first to hit rival's king wins (King can be hit by
the rival's king).
4) About upgrade option: it activates by moving to the two last
rows of the table.
Pawn: Moves like Golden General.
Lance: It can move in any desired direction (vertically and
horizontally).
Bishop: It either moves diagonally as much as desired or
moves one step vertically.
Silver General: It can move two steps (at most) at any desired
direction.
5) When a piece is hit, it will be added to the rival's pieces (its
color changes). It can also be added to the table at the next
round.
6) If the hit piece was upgraded, it will be added to the new set
without any further power (it will move normally).
7) By putting the new hit piece at the last two rows, it won't be
upgraded.
```

## P.S:

```
This mini project was originally designed by a teacher assistant of the course "Advanced Programming".
Here is the link to his Github: [Aeirya](https://github.com/aeirya).
Good luck!
```
