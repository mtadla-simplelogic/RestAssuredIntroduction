# RestAssuredIntroduction

Ćwiczenia dla 
https://jsonplaceholder.typicode.com/todos


Testy API do napisania:

1. Pobierz wszystkie 'todos' 
 - sprawdz czy status to 200

2. Pobierz 'todo' o id 4
 - sprawdz czy status to 200
 - sprawdz asercją cczy reponsponse zawiera id=1


3. Pobierz 'todos', które były stworzone przez usera o userId = 1
 - sprawdz czy status to 200

4. Pobierz 'todos', które były stworzone przez usera o userId = 1 oraz mają status completed = 1
 - sprawdz czy status to 200

5. Stwórz 'todo' o danych:
    userId = 9,
    title = I should do the homework
    completed = true
- sprawdz czy status to 201
- sprawdz asercją czy reponsponse zawiera odpowiednie: userId, title, completed

    
Ćwiczenia dla 
https://jsonplaceholder.typicode.com/users


6. Pobierz 'userów', którzy pracują w w firmie o nazwie Deckow-Crist 
 - sprawdz czy status to 201
 - sprawdz asercją czy w tablicy obiektów otrzymanych w response, pierwszy obiekt ma nazwę company równą Deckow-Crist 

