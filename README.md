# Equinox
Equinox is an unique arcade-style shooter made for AP Computer Science. It was programmed entirely by myself, and Kyle Kovacs in around one month. Play the tutorial first!
## Screenshots
![title](http://i.imgur.com/B6cSOe6.png)
![gameplay](http://i.imgur.com/unOjjlI.gif)
## Tech
Equinox was programmed in Java.
## Compilation

```
javac -cp src/ -d build src/game/Game.java
cp -r src/sounds build
cd build
jar --create --verbose --file=asdf.jar --main-class=game/Game entity/ game/ screen/ uicomponent/ sounds/
java -jar asdf.jar
```

With 2 monitors it wouldn't come to the foreground, so I had to open and close my laptop lid.

