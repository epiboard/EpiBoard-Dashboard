# <div align="center"> :computer: EpiBoard :computer: </div>

<div align="center"><em>Alexis GUYON && Kevin VENDOME && Antoine DUQUENNE </em> </div>

## Resume
This project aims at realising:

The goal is to have a Dashboard to receive important generic information from the user about his games (League of Legends / Wow) and also an english dictionary and a country service to get some informations about words and countries.

## Summary
1. [Technologies used](#technologies-used)
2. [Services](#services)
   * [League of Legends](#league-of-legends1)
   * [Raider IO](#raider-io2)
   * [Rest countries](#rest-countries3)
   * [Free dictionary](#free-dictionary4)
3. [Swagger](#swagger)
4. [Sources](#sources)

## Technologies used

| Framework Backend  | Framework Frontend |     DataBase    |
| :----------------: | :----------------: | :-------------: |
|     Spring boot    |       React        | MySQL Workbench |
|[Documentation](https://spring.io/guides)| [Documentation](https://www.php.net/manual/en)| [Documentation](https://www.mysql.com/products/workbench/)|

## Services
This project have to contain 4 Services and 9 Widgets :

#### League of Legends[^1]
<ul>
  <li><b>Widget <em>(Champions)</em>:</b> get all champions and informations about them from the game League of Legends.</li>
  <li><b>Widget <em>(Profil)</em>:</b> get the profil of a League of Legends's user.</li>
  <li><b>Widget <em>(In Game)</em>:</b> get all of informations of a game running in League of Legends by Profil name.</li>
</ul>

#### Raider IO[^2]
<ul>
  <li><b>Widget <em>(Character)</em>:</b> get character information from the game World of Warcraft.</li>
  <li><b>Widget <em>(Guild)</em>:</b> get all members from a guild and their character's informations from the game World of Warcraft.</li>
</ul>

#### Rest Countries[^3]
<ul>
  <li><b>Widget <em>(Capital)</em>:</b> get the capital from a country.</li>
  <li><b>Widget <em>(Region)</em>:</b> get all of countries from a region.</li>
</ul>

#### Free Dictionary[^4]
<ul>
  <li><b>Widget <em>(Phonetic)</em>:</b> get phonetic and audio from a word.</li>
  <li><b>Widget <em>(Definition)</em>:</b> get definition(s) and some examples from a word.</li>
</ul>

## Swagger

To access to the swagger and get all documentation from the Backend's API, once you start the back, you can go on this url:

```
http://localhost:8080/swagger-ui/
```

## Sources
Links of APIs used :
[^1]:[Developer Riotgames](https://developer.riotgames.com/docs/portal#_getting-started)
[^2]:[RaiderIo Developer API](https://raider.io/api)
[^3]:[Rest Countries](https://restcountries.com/)
[^4]:[Dictionary Api Dev](https://dictionaryapi.dev/)

