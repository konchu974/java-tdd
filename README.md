# Exercice de développement TDD

Projet utilisé dans le cadre de formation CDA à l'AFPA.

## Mise en contexte
Vous travaillez pour une entreprise spécialisée dans le développement d'IDE.

On vous demande de fournir un module de conversion décimal->hexadécimal->binaire qui devra être intégré dans la nouvelle bouture de "BlazinglyFastIDE", un logiciel dernière génération.

Dans un premier temps, vous allez développer une application indépendante (l'intégration dans l'application finale se fera par la suite).

Pour mener à bien votre mission et fournir du code de qualité, vous allez adopter une approche de développement **TEST DRIVEN DEVELOPMENT**.


## Lancement du projet

L'application est basée sur l'outil de "build" Maven.
Ainsi, vous pourrez démarrer l'application en utilisant la commande suivante :
```
mvn run
```

Il vous sera également possible d'utiliser votre IDE fétiche !

## Marche à suivre

Votre objectif est de compléter **TOUT D'ABORD UNE FONCTION DE TESTS** avant de passer à l'implémentation de l'algorithme associé.

Par exemple, pour garantir le fonctionnement de la méthode `binaryToDecimal(String binary)`,
 il vous faudra tout d'abord ajouter un assertion dans la méthode `testBinaryToDecimal` de la classe `ConverterToolTest`.

Plus d'informations sont données en commentaires de ce projet, veillez à bien tout lire.

Bon courage !

![Image "Keep calm and write unit test"](./keepcalm-unit-test.png)

 <p xmlns:cc="http://creativecommons.org/ns#" xmlns:dct="http://purl.org/dc/terms/"><a property="dct:title" rel="cc:attributionURL" href="https://github.com/afpa-learning/tdd">tdd</a> by <a rel="cc:attributionURL dct:creator" property="cc:attributionName" href="https://github.com/afpa-learning">Afpa</a> is licensed under <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/?ref=chooser-v1" target="_blank" rel="license noopener noreferrer" style="display:inline-block;">CC BY-NC-SA 4.0<img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/cc.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/by.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/nc.svg?ref=chooser-v1" alt=""><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/sa.svg?ref=chooser-v1" alt=""></a></p> 
