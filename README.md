Apache Thrift - Esempio base
============================

Il repository contiene un esempio in Java di comunicazione server-client, in cui classe service è creata automaticamente utilizzando la libreria [Apache Thrift](https://thrift.apache.org/).  

L'esempio è ispirato al [Quickstart di Dzone](https://dzone.com/articles/apache-thrift-java-quickstart).  

Installazione Apache Thrift
---------------------------

Per installare `thrift` è sufficiente seguire le istruzioni raccolte sul sito ufficiale. Personalmente, ho avuto i seguenti problemi:  

* la versione di `libboost` consigliata sul sito è troppo vecchia (ho dovuto installare la v.1.58.)
* ANT è necessario per poter generare le classi Java con `thrift`
* `export LD_LIBRARY_PATH=/usr/local/lib/:${LD_LIBRARY_PATH}`


Utilizzo di Thrift
------------------

Per generare la classe `AdditionService.java` è utilizzato il file `add.thrift` nel seguente modo:  
`thrift --gen java -out ./thrift-sample-server/src/main/java/ add.thrift `  
Le restanti classi di server e client sono costruite a mano.  

Organizzazione con Maven
------------------------

I pacchetti server, client e parent sono stati "pommizzati" per automatizzare la compilazione degli esempi. I file pom.xml necessitano comunque di miglioramento.  

Per generare insieme i due file .jar, spostarsi in `thrift-sample-parent` e digitare:  
`mvn clean install`  

Per generare uno solo dei jar, spostarsi nella cartella desiderata e digitare:  
`mvn clean compile assembly:single`  
In questo modo saranno generati i file .jar contenenti le dipendenze necessarie.  

Provare l'esempio
-----------------

Una volta generati i due file .jar, eseguire prima il server ed in seguito il client con il comando `java -jar`.  
Se tutto è andato a buon fine, dovreste vedere un `42` sulla console del client.
