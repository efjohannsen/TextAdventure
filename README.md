# TextAdventure
Modulopgave 4

## Ideas for structure

A World contains WorldTiles, WorldTiles can contain one Building (otherwise wilderness) and Persons, Buildings contain Rooms and Rooms contain RoomTiles.
Tiles can contain Persons, Items.
Items can be Potions. Could be expanded with Weapons, Armor etc.
Players can run Commands.
Persons can Talk (Text)

Speaking is done with something like this:
speak(132, SYSTEM_LANGUAGE)
...or it checks SYSTEM_LANGUAGE automatically
