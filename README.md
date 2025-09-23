# ❤️ Damage Indicators ![GitHub Release](https://img.shields.io/github/v/release/Lightre/damage-indicators?color=%23fb5d62) ![Modrinth Downloads](https://img.shields.io/modrinth/dt/damageindicators?color=%23fb5d62)

**Damage Indicators** displays clear, real-time damage indicators above players and mobs, making it easy to see hits in PvP and PvE.

![Damage Indicators Banner](https://cdn.modrinth.com/data/cached_images/95be6fc1b4fbf85158bc2c60d35f8abd1a14c5d7_0.webp)

## ✨ Features

- Visual damage indicators
- Optimized for PvP and PvE
- Minimalist and performance-friendly
- Customizable via `.yml` configuration

![---](https://i.imgur.com/LJD65XI.png)

## ⚙️ Configuration

Customize the indicators via the config file:


<details>
<summary>config.yml</summary>

```yaml
# -------------------------------------------------- #
#               DamageIndicators Config              #
# -------------------------------------------------- #

# Master switch for the plugin.
# If set to false, no indicators will be shown.
# You can also change this setting with the `/di toggle` command. (default: true)
enabled: true

# Text to appear at the beginning of the damage indicator.
# You can use color codes with '&'. (default: '&c❤ ')
indicator-prefix: '&c❤ '

# Special prefix that pops up when a crit lands. (default: '&e✯ ')
critical-indicator-prefix: '&e✯ '

# Time the damage indicator stays on screen (in secs)
# You have to use decimal (double) values (default: 2.0)
indicator-duration-seconds: 2.0
```

</details>



![---](https://i.imgur.com/LJD65XI.png)

## 🛠️ Installation

1. Download the plugin `.jar` file.
2. Place it into your server's `plugins` folder.
3. Restart the server or use `/reload`.
4. Customize `plugins/DamageIndicators/config.yml`.

![---](https://i.imgur.com/LJD65XI.png)

## 🎯 Usage

* Damage indicators for players and mobs are automatically active.
* Config changes are adjustable via `.yml`, some require reload.
* Optimized for both PvP and PvE servers.

![---](https://i.imgur.com/LJD65XI.png)

## ⚡ Commands

| Command      | Description                                                     |
|--------------| --------------------------------------------------------------- |
| `/di help`   | Displays information about the plugin.                          |
| `/di reload` | Reloads the plugin configuration without restarting the server. |
| `/di toggle` | Toggle damage indicators on/off.                                |

![---](https://i.imgur.com/LJD65XI.png)

## 😎 Preview

![Preview](https://cdn.modrinth.com/data/8B6f2zti/images/6d49ef3b329a021aa9113cf5f60494ffa32099e0.png)

![---](https://i.imgur.com/LJD65XI.png)

<p align="center"><b>🌟 Other Projects</b></p>

<p align="center">
        <a href="https://modrinth.com/modpack/boost-fps"><img
                        src="https://cdn.modrinth.com/data/fM8HTxkM/a19f7d97459ead2a567ff1023f763b2591039541_96.webp"
                        alt="BoostFPS" width="80" /></a>
        <a href="https://modrinth.com/mod/colder-foliage"><img
                        src="https://cdn.modrinth.com/data/AfD6LVG8/cd74e9bc58415cf1ccea5aa02b96ed8d0e1ed262.png"
                        alt="Colder Foliage" width="80" /></a>
        <a href="https://modrinth.com/resourcepack/no-foliage"><img
                        src="https://cdn.modrinth.com/data/Ggp8JA4b/4abeffa738046b08641f88b54843c15950244ba7.png"
                        alt="No Foliage" width="80" /></a>
        <a href="https://modrinth.com/mod/warmer-foliage"><img
                        src="https://cdn.modrinth.com/data/H6ktUOYw/2914aaaef26a107ae7e9415604b131204e20a127.png"
                        alt="Warmer Foliage" width="80" /></a>
        <a href="https://modrinth.com/project/essential-tweaks"><img
                        src="https://cdn.modrinth.com/data/cached_images/b27b7b0b0525e9cec7d85a86998ff439f0e44a8c_0.webp"
                        alt="Essential Tweaks" width="80" /></a>
</p>

<p align="center">
  Explore more of my projects and enhance your Minecraft experience!
</p>
<p align="center">
  — Made by Lightre
</p>