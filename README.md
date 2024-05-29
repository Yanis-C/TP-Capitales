
Énoncé :
TP : Devine la Capitale (API web)

Nous allons créer une API web qui permet de jouer au jeu suivant:

On nous propose le nom d’un pays et nous devons deviner le nom de sa capitale pour gagner le point.

Pour la bdd on importe ce script: https://file.notion.so/f/f/8f85d04d-364b-472f-83e6-cd818df1014d/a0503211-b253-44a6-899b-6fc5869cf000/countries_capital_PSQL.sql?id=c8f3d655-ba14-4a96-8868-57b1ca807476&table=block&spaceId=8f85d04d-364b-472f-83e6-cd818df1014d&expirationTimestamp=1717084800000&signature=nVjCf9UwA_dJIm8KujzRlwTn_3c06P8B4YQwXvbIZFI&downloadName=countries_capital_PSQL.sql

Routes de l'API :

POST /player:
On crée un joueur dans la bdd (il faut bien retenir son id !)
ex params:

{
    "name": "Mario"
}

GET /games:
On obtient aléatoirement l’id et le nom d’un pays

GET /games/{id_player}:
On obtient aléatoirement l’id et le nom d’un pays, en excluant le dernier pays deviné par l'utilisateur

POST /games/{id_country}/{id_player}:
Pour l'id du pays et le joueur spécifiés dans l'url, on propose une capitale

ex params:
{
    "capital": "London"
}


Les paramètres et résultats des routes sont aussi présents sur le Swagger
