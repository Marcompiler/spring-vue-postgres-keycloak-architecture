# Frontend - App - Src - Router

## Description

Le router contient l'**ensemble des chemins définis pour chaque page de l'application**.

L'ensemble des vues de l'application sont accessibles au moyen d'une URL, d'un chemin menant à la page correspondante. Pour faire le lien entre cette page et le chemin choisi, c'est ici au niveau du router que ça se passe.

Ce router a été généré par Vue.JS et fut laissé intouché.

## Comment utiliser

**Dans l'indexeur** "[`index.js`](./index.js)", vous pouvez **ajouter/retirer des associations entre un chemin, un nom et une page** (*le composant correspondant*).

Vous avez donc un exemple d'association où la page d'accueil est chargée dès le démarrage de l'application et où la page "à propos", quant à elle, est en "[lazy load](https://en.wikipedia.org/wiki/Lazy_loading)", autrement dit elle est chargée qu'à la demande.
