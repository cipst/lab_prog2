//Tag.java
public enum Tag { 
//etichette che indicano l'uso di parti di una espressione
 NUM,                      // numero
 ID,                       // identificatore (costante o variabile)
 PLUS,MINUS,TIMES,DIVIDE,  // diverse operazioni ...
 EOF }                     // End Of File: un token per terminare

 
 /* Isolare un testo in “token” è il primo passo per capirlo. Nel file Tag.java abbiamo inserito una “tag” per i numeri, i nomi delle operazioni e così via. Per esempio: nell’espressione 

 (bMin+bMag)*h/2;

possiamo isolare i seguenti “token”: 

<LPAR,“(”>,   <ID,“bMin”>,   <PLUS,“+”>,  <ID,“bMag”>,    …

 Definiamo una classe Token dei token. Quindi, per fare una semplice prova, costruiamo dei token e ne stampiamo la descrizione. Normalmente, invece, i token non vengono costruiti ma isolati dentro a un testo.
 */

