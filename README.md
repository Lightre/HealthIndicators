# ❤️ Damage Indicators

Health Indicators is a lightweight PaperMC plugin that adds clear and compact health bars for players and mobs, letting you quickly see health at a glance.

---

## 📸 Preview

![Damage Indicators Banner](https://cdn.modrinth.com/data/cached_images/95be6fc1b4fbf85158bc2c60d35f8abd1a14c5d7_0.webp)

---

## ✨ Features

- Visual damage indicators
- Optimized for PvP and PvE
- Minimalist and performance-friendly
- Customizable via `.yml` configuration

---

## 🛠️ Configuration

Customize the indicators via the config file:

```yaml
# HealthIndicators Plugin Config

# Text to appear at the beginning of the damage indicator.
# You can use color codes with '&'. (default: '&c❤ ')
indicator-prefix: '&c❤ '

# Special prefix that pops up when a crit lands. (default: '&e✯ ')
critical-indicator-prefix: '&e✯ '

# Time the damage indicator stays on screen (in secs)
# You have to use decimal (double) values (default: 2.0)
indicator-duration-seconds: 2.0
```

---

## 🛠️ Installation

1. Download the plugin `.jar` file.
2. Place it into your server's `plugins` folder.
3. Restart the server or use `/reload`.
4. Customize `plugins/HealthIndicators/config.yml`.

---

## 🎯 Usage

* Health bars for players and mobs are automatically active.
* Config changes are adjustable via `.yml`, some require reload.
* Optimized for both PvP and PvE servers.

---

## ⚡ Commands

| Command        | Description                                                     |
| -------------- | --------------------------------------------------------------- |
| `/hi help`     | Displays information about the plugin.                          |
| `/hi reload`   | Reloads the plugin configuration without restarting the server. |
| `/hi toggle`   | Toggle health indicators on/off.                                |