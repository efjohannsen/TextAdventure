# TextAdventure
Modulopgave 4

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.

## Ideas for structure

- A World contains WorldTiles, WorldTiles can contain one Building (otherwise wilderness) and Persons, Buildings contain Rooms and Rooms contain RoomTiles.
- Tiles can contain Persons, Items.
- Items can be Potions. Could be expanded with Weapons, Armor etc
- Players can run Commands.
- Persons can Talk (Text)
- Positioning of fx. Players and Items are tracked by WorldTiles and RoomTiles, not by the Players and Items themselves.

Speaking is done with something like this:  
speak(132)  
...and it checks the language configured in Game.java automatically.

### Buildings

- always entered from the bottom
- rooms are laid out on x/y axes. the first room is always 0,0
- the y-axis' minimum is always 0 (the first room) but can be up to any positive number.
- the x-axis is an interval from any negative to any positive value.
- moving north increments the y-axis, and south decrements it.
- moving east increments the x-axis, and south decrements it.
- So each Room's position consists of two numbers: one for each axis.
- A Building contains only a maximum value of y, and a minimum AND maximum value of x.

## Development ideas

- Support movement keys? Successfully tested, but it would require JNA.
