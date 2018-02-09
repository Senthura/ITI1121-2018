Ce dossier contient six exemples présentant des défis rencontrés par
les étudiants pour le devoir 1. Même si vous n’avez pas fait face à
ces défis, ce pourrait être utile de regarder le code pour trouver
source des erreurs.

Le débogage est une compétence essentielle. Elle vous rendra plus
productif et rendra vos activités de développement de logiciels plus
plaisantes.

De plus, lire le code de quelqu’un d’autre est difficile au début. Ça
vous oblige à déchiffrer le raisonnement d’une autre
personne. Cependant, dans le l’industrie, la plupart du temps, vous
devrez travailler sur des projets existants. Par conséquent, nous vous
encourageons fortement à pratiquer la lecture de programmes existants.

La description du devoir était plutôt formelle.  Il y avait
possiblement des termes que vous ne connaissiez pas. Cependant, du
point de vue de la programmation, cette application avait deux
composantes principales: stocker des données numériques dans un
tableau bidimensionnel et faire des calculs numériques simples
(essentiellement des boucles et des sommations).

Si vous y pensez, notre devoir 1 avait beaucoup en commun avec le
problème suivant, qui est la base de mes six exemples.

Problème: écrire une classe, appelée Grades, qui permet de stocker les notes
des étudiants pour une classe donnée. Le constructeur a un paramètre
qui spécifie le nombre de notes à stocker. Un objet de la
classe Grades a une méthode addGrade qui permet d’ajouter une note au
contenu de l’objet. L’objet a aussi une méthode getAverage
qui calcule la note moyenne de la classe. Les exemples 05_Grades et
06_Grades portent sur ce problème. Tout ceci correspond à la partie 1 
du devoir 1. Pour la partie 2, vous pouvez imaginer que pour chaque étudiant, nous
devons stocker la note pour chaque question d’un examen. Ces notes
correspondraient aux attributs du devoir 1. Cette dernière partie est
laissée˙comme un exercice.

Mais d’abord, travaillons sur l’idée de stocker des exemples dans un
objet de la classe Samples. Lorsque vous devez résoudre un problème,
l’une des premières stratégies que vous devriez considérer consiste à
résoudre un problème plus simple. Ici, j’ai isolé l’exigence de
stocker des éléments dans un objet. C’est plus facile de travailler
sur la résolution de ce problème en isolation, plutôt que travailler
sur le problème dans le contexte de l’ensemble du problème, régression
linéaire. Seulement quand vous êtes sûr que votre solution fonctionne
devriez-vous passer aux prochaines parties du devoir ?

01_Samples, 02_Samples et 03_Samples concernent le stockage d’éléments dans
un objet de la classe Samples. Le contenu est construit ligne par ligne.

01_Samples

La méthode principale fait plusieurs appels à la méthode addSample,
chaque fois en ajoutant une ligne à l’objet Samples. Ici, j’ai eu
l’idée de faire en sorte que chaque entrée de la matrice résultante
est unique afin que tout problème puisse être facilement détecté (ou
du moins c’est ce que j’espérais, plus sur cela dans le second
exemple).

    double[] sample;
    sample = new double[NUMBER_OF_FEATURES];

    double value;
    value = 0.0;

    Samples training;
    training = new Samples(NUMBER_OF_SAMPLES, NUMBER_OF_FEATURES);

    for (int i=0; i<NUMBER_OF_SAMPLES; i++) {
        for (int j=0; j<NUMBER_OF_FEATURES; j++) {
          sample[j] = value;
          value = value + 1.0;
        }
        training.addSample(sample);
    }

    System.out.print(training);

Je m’attendais à ce que l’exécution de la méthode principale produise
la sortie suivante:

 0.0, 1.0, 2.0, 3.0, 4.0
 5,0, 6,0, 7,0, 8,0, 9,0
10,0, 11,0, 12,0, 13,0, 14,0
15,0, 16,0, 17,0, 18,0, 19,0
20,0, 21,0, 22,0, 23,0, 24,0
25,0, 26,0, 27,0, 28,0, 29,0
30,0, 31,0, 32,0, 33,0, 34,0
35,0, 36,0, 37,0, 38,0, 39,0
40,0, 41,0, 42,0, 43,0, 44,0
45,0, 46,0, 47,0, 48,0, 49,0

Cependant, voici la sorie:

45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0
45,0, 46,0, 47,0, 48,0, 49,0

Pouvez-vous trouver pourquoi ? Quelles (s) structures récurrentes
observez-vous ? La sortie a deux propriétés qui disent quelque chose
sur la nature des problèmes.  Quelles sont ces propriétés ?

02_Samples

Cet exemple est plus difficile à déboguer puisqu’il produit le bon
résultat, mais il illustre une mauvaise pratique qui pourrait conduire
à de sévères erreurs dans le futur. Vous auriez perdu des points pour
ceci dans le devoir. Quelle est cette erreur ou quelles sont ces
erreurs ?

 0.0, 1.0, 2.0, 3.0, 4.0
 5,0, 6,0, 7,0, 8,0, 9,0
10,0, 11,0, 12,0, 13,0, 14,0
15,0, 16,0, 17,0, 18,0, 19,0
20,0, 21,0, 22,0, 23,0, 24,0
25,0, 26,0, 27,0, 28,0, 29,0
30,0, 31,0, 32,0, 33,0, 34,0
35,0, 36,0, 37,0, 38,0, 39,0
40,0, 41,0, 42,0, 43,0, 44,0
45,0, 46,0, 47,0, 48,0, 49,0

03_Samples

Cette solution devrait être acceptable, mais vous pouvez la critiquer.

04_Samples

Introduis l’idée que chaque exemple devrait aussi avoir sa valeur
attendue.

05_Grades

Exemple de programme pour sauvegarder des notes, mais avec une erreur
de programmation. Quelle est-elle?  Lorsque vous regardez la sortie,
quel résultat donne une idée de la nature de l’erreur ?

06_Grades

Le programme a deux erreurs graves. Vous auriez dû 
identifier l’une des erreurs à l’exercice 05_Grades, mais l’autre est assez
difficile à trouver! Cette erreur produit une erreur d’exécution:

> java Main
Exception in thread "main" java.lang.NullPointerException
	at Grades.addGrade(Grades.java:14)
	at Main.main(Main.java:16)
