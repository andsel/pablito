# Modello a ricerca & richiesta
* Il **tasker** pubblica le proprie _skill_ legate al suo _profilo_, ad esempio "taglio erba", richiesta monetaria per mq 
    ed altre informazioni utili, definisce se ha strumenti propri ( fascie orarie), comuni d'intervento (intesi come 
    area o CAP)
* Il **task bidder** (offerente) ricerca dei tasker che facciano match per tipologia di lavoro, area, costo e feedback.
* Il **task bidder** dopo aver trovato possibile **tasker** li contatta per mezzo della piattaforma
* Il pagamento fra le parti avviene offline in prima battuta
* Una volta compiuto il task sia **tasker** che **task bidder** possono lasciare dei feedback a vicenda.

## Possibili caratteristiche delle entità (se lo sono) in gioco
* **tasker**: skills, toolbox, zone, costo, feedback
* **task bidder**: ?
* **task offer** ciò che lega il **tasker** al **task bidder** per un periodo limitato di tempo.
NB
I feedback una volta dati non possono essere revocati, una volta dato è di chi lo riceve ma ha un riferimento a chi lo ha dato.

## Possibili azioni
* ricerca di tasker _SearchForTasker_ (del **task bidder**)
* _ConfirmTaskOffer_ e _RefuseTaskOffer_ (del **tasker**)
* _AskTaskOfferConfirmation_ (del **task bidder**)

## Possibile workflow per ricerca, selezione e richiesta disponibilità
1. il **task bidder** ricerca mediante alcuni criteri i **tasker** che gli potrebbero interessare, usando alcuni criteri
    ad esempio: comune, toolbox propria o meno
2. Scorre la lista e sceglie quale **tasker** richiedere la disponibilità
3. il **tasker** deve decidere entro un certo lasso di tempo (24 h?) se accettare o rifiutare, ma per farlo
    può scambiare una serie di messaggi con il **task bidder**.
    3a. se _rifiuta_ viene informato il **task bidder** che deciderà se riprendere con la ricerca (magari con gli 
    stessi criteri, ma escludendo il **tasker** che ha appena rifiutato)
    3b. il **tasker** ed il **task bidder** si rilasciano feedback una volta completato il task 
    
========================================================

Definizione di possibili Entità/Aggregati e Value objects
**tasker**, **task bidder**, **task offer** sono tutti entità.
Un aggregato potrebbe raggruppare **tasker**, **task offer** mentre l'altro 
aggregato sarà l'entità **task bidder**