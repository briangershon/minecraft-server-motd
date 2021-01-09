# minecraft-server-motd-3t3n

<img src="src/main/resources/3t3n-icon.png" width="64" height="64" alt="latest server icon" />

Minecraft "Ping" plugin for displaying an icon, message of the day (motd) and number of players to those attempting to connect to the server.

(`3t3n` is the abbreviation for a hosted server)

<img src="screenshot.png" width="800" height="508" alt="Minecraft Multiplayer Server Dialog" />

Features:

* Example Minecraft "ping" plugin. Also a very easy initial plugin for those learning about plugin development.
* Compiled to support older servers running on Java 8.
* Tested plugin on these servers:
    * Spigot 1.16.4-R0.1-SNAPSHOT (compile with Java 14 on MacOS) when testing plugin locally.
    * Paper 1.16.4 (compiled with Java 8) running on a paid hosting service using an older version of Java.

## My Development Environment Setup and Workflow

### Setup

Setup dependencies for your environment. Refer to [Creating a blank Spigot plugin, using Maven](https://www.spigotmc.org/wiki/creating-a-plugin-with-maven-using-intellij-idea/).

For MacOS, Java 14 was installed and then Maven installed via Home Brew (`brew install maven`).

### Run a local Minecraft server

Spigot is installed into `~/spigotmc`.

In one terminal, I run Spigot via my `run.sh` script:

```bash
#/bin/sh
java -Xms2G -Xmx2G -jar spigot-1.16.4.jar nogui

# java -jar BuildTools.jar
```

### Editing 

This repo is cloned into my home folder at `~/minecraft-server-motd-3t3n`.

Edit plugin via Eclipse for nice code auto completion.

### Test the plugin

I use a second terminal session for compiling and copying the plugin to the local server.

    mvn clean package
    cp target/Motd3T3NPingPlugin-1.0.1.jar ~/spigotmc/plugins/

Flip over to `~/spigotmc` terminal and type `reload`. Or if server not running use `run.sh` script.

You can then run the Minecraft client, choose `Add Server`, and type `localhost` for Server Address. Click Refresh and you should see the new server icon and message-of-the-day.

## To Release Your Plugin

Make sure you first update the plugin version in `pom.xml` in `<version>1.0.1</version>`.

    mvn clean package

You should now have your new plugin jar file in `target` folder.

## To install on your Spigot compatable Minecraft Server

- Copy `target/Motd3T3NPingPlugin-n.n.n.jar` to your server `/plugin` folder, and reload server configuration (or just restart server).

- Copy `src/main/resources/3t3n-icon.png` image (64x64) to the root of your Minecraft server folder (NOT the `plugin` folder).

You should see a message in your server console:

```
[11:50:26] [Server thread/INFO]: [Motd3t3n] Enabling Motd3t3n v1.0.0
```
